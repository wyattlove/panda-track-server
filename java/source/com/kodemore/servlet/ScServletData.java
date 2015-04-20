/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.file.KmFile;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonObjectIF;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.result.ScResultIF;
import com.kodemore.servlet.result.ScSimpleResult;
import com.kodemore.thread.KmThreadLocalManager;
import com.kodemore.time.KmDate;
import com.kodemore.utility.KmGeneralError;
import com.kodemore.utility.Kmu;

/**
 * I provide a convenient wrapper for holding onto the servlet, http request,
 * and http response.  In addition to the various convenience methods implemented
 * here, this wrapper also provided a more convenient way to pass the servlet,
 * request, and reponse through the method call stack; this help clean up the code
 * when applying a thread safe implementation of servlets and page handlers.
 */
public class ScServletData
    implements ScConstantsIF
{
    //##################################################
    //# instance creation
    //##################################################

    public static void _install(ScServletData data)
    {
        data.setLocal();
        data.reset();
    }

    //##################################################
    //# variables (delgates)
    //##################################################

    private HttpServlet          _servlet;
    private HttpServletRequest   _request;
    private HttpServletResponse  _response;

    //##################################################
    //# variables (setup)
    //##################################################

    /**
     * The time when I was created.  Used for logging.
     */
    private long                 _creationTimeNanos;

    /**
     * Determines if parameters values should be normalized.
     * Normalized values strip non-printable characters, and
     * trim leading and trailing whitespace.  This is normally
     * desireable as it helps avoid a large number of potential
     * problems.
     */
    private boolean              _normalizeParameterValues;

    /**
     * The list of parameters extracted from the http request so that
     * values can be overridden during processing.
     */
    private ScParameterList      _parameters;

    //##################################################
    //# variables (response)
    //##################################################

    /**
     * A list of application error messages that we intend to display
     * to the user.
     */
    private KmList<KmErrorIF>    _errors;

    /**
     * The result that we intend to write to the http response.
     * We store the result in this manner so that we can defer
     * writing the http response until after we have confirmed
     * that the database transaction successfully committed.
     */
    private ScResultIF           _result;

    /**
     * The number of bytes written to the http response.
     * This value is only set when the http response is written.
     * Setting the "result" does not immediately affect this value.
     */
    private int                  _responseSize;

    /**
     * I provide a copy of the cookies that are set into the response.
     * This is so that the value can be retrieved within the same
     * http request cycle.
     */
    private KmMap<String,Cookie> _setCookies;

    //##################################################
    //# constructor
    //##################################################

    protected ScServletData(
        HttpServlet servlet,
        HttpServletRequest request,
        HttpServletResponse response)
    {
        _servlet = servlet;
        _request = request;
        _response = response;

        _normalizeParameterValues = true;
        _creationTimeNanos = System.nanoTime();
    }

    /**
     * If a database transaction fails, then the transient changes to
     * to the servlet data should be reset.  This method resets the
     * appropriate data.
     */
    public void reset()
    {
        installVariables();
        installParameters();
    }

    private void installVariables()
    {
        _setCookies = new KmMap<>();
        _errors = new KmList<>();
        _result = null;
    }

    private void installParameters()
    {
        _parameters = new ScParameterList();

        Enumeration<String> e = getParameterNames();
        while ( e.hasMoreElements() )
        {
            String key = e.nextElement();
            String[] values = _request.getParameterValues(key);

            for ( String value : values )
            {
                value = _normalize(value);
                _parameters.addValue(key, value);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Enumeration<String> getParameterNames()
    {
        return _request.getParameterNames();
    }

    //##################################################
    //# accessing
    //##################################################

    public HttpServlet _getServlet()
    {
        return _servlet;
    }

    public HttpServletRequest _getRequest()
    {
        return _request;
    }

    public HttpServletResponse _getResponse()
    {
        return _response;
    }

    public boolean getNormalizeParameterValues()
    {
        return _normalizeParameterValues;
    }

    public void setNormalizeParameterValues(boolean e)
    {
        _normalizeParameterValues = e;
    }

    public long getCreationTimeNanos()
    {
        return _creationTimeNanos;
    }

    //##################################################
    //# request (misc)
    //##################################################

    /**
     * Determine if a query string was provided to specify parameters.
     * Query strings are the parameters on the GET, not on the POST.
     */
    public boolean hasQueryString()
    {
        return Kmu.hasValue(_getRequest().getQueryString());
    }

    public String getQueryString()
    {
        return _getRequest().getQueryString();
    }

    /**
     * Request: http://localhost:8080/app/servlet/account/test?key=value
     *       => http://localhost:8080/app/servlet/account/test
     */
    public String getRequestUri()
    {
        return _getRequest().getRequestURI();
    }

    public String getRequestUriAndQueryString()
    {
        String uri = getRequestUri();
        return addQueryString(uri);
    }

    public String getRequestUrlWithoutQueryString()
    {
        return _getRequest().getRequestURL().toString();
    }

    public String getFullRequestUrl()
    {
        String url = _getRequest().getRequestURL().toString();
        return addQueryString(url);
    }

    private String addQueryString(String uri)
    {
        String query = _getRequest().getQueryString();
        if ( query == null )
            return uri;

        return uri + "?" + query;
    }

    /**
     * E.g.: HTTP/1.1
     */
    public String getProtocol()
    {
        return _getRequest().getProtocol();
    }

    /**
     * E.g.: http
     */
    public String getRequestScheme()
    {
        return _getRequest().getScheme();
    }

    public String getRequestServerName()
    {
        return _getRequest().getServerName();
    }

    public Iterator<String> getHeaderNames()
    {
        KmList<String> v = new KmList<>();

        Enumeration<?> e = _getRequest().getHeaderNames();
        while ( e.hasMoreElements() )
            v.add((String)e.nextElement());

        v.sort();
        return v.iterator();
    }

    public String getHeader(String name)
    {
        return _getRequest().getHeader(name);
    }

    public InputStream getInputStream()
    {
        try
        {
            return _getRequest().getInputStream();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public HttpSession _getHttpSession()
    {
        HttpSession e;
        e = _getRequest().getSession();
        e.setMaxInactiveInterval(getSessionTimeoutSeconds());
        return e;
    }

    public String getRemoteIpAddress()
    {
        return _request.getRemoteAddr();
    }

    //##################################################
    //# multi part
    //##################################################

    /**
     * Get the uploaded files from a multi-part upload.
     *
     * This relies on the Apache Commons DiskFileItemFactory and may introduce some
     * architectural considerations.
     *
     * 1) deletion of (Apache's) temporary files
     * 2) clean shutdown of servlet container
     * 3) security
     *
     * For additional info see here... http://goo.gl/q93J27
     *
     * Security Review
     *     Local untrusted users could change the contents of the
     *     temp files causing unknown an probable malicous behavior.  This is not
     *     a problem if you use an isolated web server which does not allow local
     *     logins for users.  Our users are considered trusted and already have root
     *     privileges.  I see no issue for us.
     *
     * Temp file deleteion
     *     We need to implement a FileCleaningTracker (thread?) which cleans up the
     *     files when the File object is garbage collected.
     *
     * Shutdown
     *      This thread needs to add terminated during shutdown of the servlet
     *      container( web application).
     *      See http://bit.ly/1rmDy1f for additional information.
     *
     *       Adding the following the web.xml should shutdown the thread.
     *       <web-app>
     *         ...
     *         <listener>
     *           <listener-class>
     *             org.apache.commons.fileupload.servlet.FileCleanerCleanup
     *           </listener-class>
     *         </listener>
     *         ...
     *       </web-app>
     *
     */
    public KmList<FileItem> getUploadedFiles()
    {
        try
        {
            DiskFileItemFactory factory = createDiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(_getRequest());
            return new KmList<>(items);
        }
        catch ( FileUploadException ex )
        {
            KmLog.error(ex, "Cannot get uploaded files.");
            return new KmList<>();
        }
    }

    private DiskFileItemFactory createDiskFileItemFactory()
    {
        DiskFileItemFactory x = new DiskFileItemFactory();
        x.setFileCleaningTracker(new FileCleaningTracker());
        return x;

    }

    //##################################################
    //# request paths
    //##################################################

    /**
     * Returns the portion of the path that identifies the application
     * context.   Any leading or trailing slashes are removed.
     *
     * Request... http://localhost:8080/app/servlet/main/test?key=value
     *         => app
     */
    public String getContextPath()
    {
        return Kmu.trimSlashes(_getRequest().getContextPath());
    }

    /**
     * Returns the portion of the path that identifies the specific servlet
     * based on the configuration of the web.xml file. Any leading or trailing
     * slashes are removed.
     *
     * Request... http://localhost:8080/app/servlet/main/test?key=value
     *         => servlet/main
     */
    public String getServletPath()
    {
        return Kmu.trimSlashes(_getRequest().getServletPath());
    }

    /**
     * Returns the portion of the path AFTER the servlet path.
     * Any leading or trailing slashes are removed.
     *
     * Request... http://localhost:8080/app/servlet/main/test?key=value
     *         => test
     */
    public String getExtraPath()
    {
        return Kmu.trimSlashes(_getRequest().getPathInfo());
    }

    /**
     * Returns the entire path; everything after the machine
     * and before the query parameters.
     *
     * Request... http://localhost:8080/app/servlet/main/test?key=value
     *         => /app/servlet/main/test
     */
    public String getFullPath()
    {
        return getRequestUri();
    }

    //##################################################
    //# request (user agent)
    //##################################################

    public String getUserAgent()
    {
        return _request.getHeader("User-Agent");
    }

    public boolean isUserAgentFirefox()
    {
        return userAgentContains("firefox");
    }

    public boolean isUserAgentFirefox3()
    {
        return userAgentContains("firefox/3");
    }

    public boolean isUserAgentGoogleChrome()
    {
        return userAgentContains("chrome");
    }

    public boolean isUserAgentInternetExplorer()
    {
        return userAgentContains("msie");
    }

    public boolean isUserAgentMobile()
    {
        return isUserAgentWindowsCe() || isUserAgentWindowsPocketPc();
    }

    public boolean isUserAgentWindowsCe()
    {
        return userAgentContains("Windows CE");
    }

    public boolean isUserAgentWindowsPocketPc()
    {
        return userAgentContains("PPC");
    }

    public boolean userAgentContains(String s)
    {
        return getUserAgent().toLowerCase().indexOf(s.toLowerCase()) >= 0;
    }

    //##################################################
    //# request (parameters)
    //##################################################

    public String getParameter(String key)
    {
        return _parameters.getValue(key);
    }

    public boolean hasParameters()
    {
        return _parameters.isNotEmpty();
    }

    public boolean hasParameter(String key)
    {
        return _parameters.hasKey(key);
    }

    public ScParameterList getParameterList()
    {
        return _parameters;
    }

    public KmList<String> getParameterKeys()
    {
        return _parameters.getKeys();
    }

    public void setParameter(String key, String value)
    {
        _parameters.setValue(key, value);
    }

    public KmList<String> getParameterKeysStartingWith(String prefix)
    {
        KmList<String> v = new KmList<>();
        for ( String s : getParameterKeys() )
            if ( s.startsWith(prefix) )
                v.add(s);
        return v;
    }

    public KmList<String> getParametersStartingWith(String prefix)
    {
        KmList<String> v = new KmList<>();
        KmList<String> keys = getParameterKeysStartingWith(prefix);
        for ( String key : keys )
            v.add(getParameter(key));
        return v;
    }

    public KmList<String> getParameters(String key)
    {
        return _parameters.getValues(key);
    }

    public void printParameters()
    {
        KmList<String> keys;
        keys = getParameterKeys();
        keys.sort();

        System.out.println("Parameters: " + keys.size());
        for ( String key : keys )
            System.out.printf("    %s = %s%n", key, getParameters(key).format());
    }

    public String formatParametersAsQueryString()
    {
        return getParameterList().formatUrl();
    }

    //##################################################
    //# cookies
    //##################################################

    // Cookies are handled differently in IE.  In IE, if you are running local
    // (localhost), cookies can still be created and read even when the Privacy
    // slider is at the High setting (Block all cookies).  In order to change
    // this behavior, we have to tell IE to treat localhost as not part of our
    // intranet.  To do so, do the following:
    //   1.  Go to Tools|Internet Options|Security tab.
    //   2.  Click on the Local intranet image then click on the Sites button.
    //   3.  Uncheck everything in the Local intranet dialog.
    // There is no need to perform the steps if you're running remotely.
    // It is just a way to trick IE into thinking that we're running remotely
    // even if we're local.  Disabling cookies at this point should now yield
    // consistent results between local and remote testing.

    public void setCookie(String key, String value)
    {
        setCookie(key, value, null, false);
    }

    public void setCookie(String key, String value, Integer expireSeconds, boolean secure)
    {
        value = Kmu.encodeUtf8(value);

        Cookie cookie = new Cookie(key, value);

        if ( expireSeconds != null )
            cookie.setMaxAge(expireSeconds);

        if ( secure )
            cookie.setSecure(true);

        // share cookies across the domain, regardless of the [servlet] path.
        cookie.setPath("/");

        _setCookie(cookie);
    }

    public String getCookie(String key)
    {
        Cookie c = _getCookie(key);
        if ( c == null )
            return null;
        return Kmu.decodeUtf8(c.getValue());
    }

    public boolean hasCookie(String key)
    {
        return _getCookie(key) != null;
    }

    public void clearCookie(String key)
    {
        Cookie e = new Cookie(key, null);
        _clearCookie(e);
    }

    //##################################################
    //# cookie (support)
    //##################################################

    private KmList<Cookie> _getCookies()
    {
        KmMap<String,Cookie> m = new KmMap<>();

        Cookie[] cookies = _getRequest().getCookies();
        if ( cookies != null )
            for ( Cookie e : cookies )
                m.put(e.getName(), e);

        for ( Cookie e : _setCookies.getValues() )
            m.put(e.getName(), e);

        KmList<Cookie> v = new KmList<>();
        for ( Cookie e : m.getValues() )
            if ( Kmu.isNotEqual(e.getValue(), REMOVED_COOKIE_VALUE) )
                v.add(e);

        return v;
    }

    private Cookie _getCookie(String name)
    {
        for ( Cookie e : _getCookies() )
            if ( e.getName().equals(name) )
                return e;
        return null;
    }

    /**
     * The cookie should be a new instance that contains the correct
     * values for name, domain, and path.
     */
    public void _clearCookie(Cookie e)
    {
        e.setValue(REMOVED_COOKIE_VALUE);
        e.setMaxAge(0);
        _setCookie(e);
    }

    /**
     * The cookie should be a new instance that contains the correct
     * values for name, domain, and path.
     */
    public void _setCookie(Cookie c)
    {
        // Note: the http response is updated in flushResult()
        _setCookies.put(c.getName(), c);
    }

    public void setTimeoutCookie(String name, String value, int seconds)
    {
        value = Kmu.encodeUtf8(value);

        Cookie c;
        c = new Cookie(name, value);
        c.setMaxAge(seconds);

        _setCookie(c);
    }

    //##################################################
    //# request (attributes)
    //##################################################

    public boolean hasAttribute(String key)
    {
        return getAttribute(key) != null;
    }

    public Object getAttribute(String key)
    {
        return _getRequest().getAttribute(key);
    }

    public void setAttribute(String key, Object e)
    {
        _getRequest().setAttribute(key, e);
    }

    public void setAttribute(String key, int i)
    {
        Integer ii = Integer.valueOf(i);
        setAttribute(key, ii);
    }

    public String getStringAttribute(String key)
    {
        return (String)getAttribute(key);
    }

    public int getIntegerAttribute(String key)
    {
        return getIntegerAttribute(key, 0);
    }

    public int getIntegerAttribute(String key, int def)
    {
        try
        {
            return ((Integer)getAttribute(key)).intValue();
        }
        catch ( Exception ex )
        {
            return def;
        }
    }

    public KmDate getDateAttribute(String key)
    {
        return getDateAttribute(key, null);
    }

    public KmDate getDateAttribute(String key, KmDate def)
    {
        if ( !hasAttribute(key) )
            return def;

        return (KmDate)getAttribute(key);
    }

    //##################################################
    //# response
    //##################################################

    public void setHtmlContentType()
    {
        setContentType(CONTENT_TYPE_HTML);
    }

    public void setTextContentType()
    {
        setContentType(CONTENT_TYPE_TEXT);
    }

    public void setXmlContentType()
    {
        setContentType(CONTENT_TYPE_XML);
    }

    public void setPdfContentType()
    {
        setContentType(CONTENT_TYPE_PDF);
    }

    public void setOctetContentType()
    {
        setContentType(CONTENT_TYPE_OCTET);
    }

    public void setSerializedContentType()
    {
        setContentType(CONTENT_TYPE_SERIALIZED);
    }

    public void setJpegContentType()
    {
        setContentType(CONTENT_TYPE_JPEG);
    }

    public void setBinaryContentType()
    {
        setContentType(CONTENT_TYPE_BINARY);
    }

    public void setContentType(String s)
    {
        _getResponse().setContentType(s);
    }

    public void setContentLength(int i)
    {
        _getResponse().setContentLength(i);
    }

    public void setNoCacheHeaders()
    {
        _getResponse().setHeader("Cache-Control", "no-cache");
        _getResponse().setIntHeader("Expires", 0);
    }

    public void setAttachmentDisposition(String name)
    {
        setContentDisposition("attachment;filename=" + name);
    }

    public void setContentDisposition(String s)
    {
        setHeader("content-disposition", s);
    }

    public void setHeader(String key, String value)
    {
        _getResponse().setHeader(key, value);
    }

    public PrintWriter getWriter()
    {
        try
        {
            return _getResponse().getWriter();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public OutputStream getOutputStream()
    {
        try
        {
            return _getResponse().getOutputStream();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# result
    //##################################################

    public void setResult(ScResultIF e)
    {
        _result = e;
    }

    public boolean hasResult()
    {
        return _result != null;
    }

    public void flushResult()
    {
        for ( Cookie e : _setCookies.getValues() )
            _getResponse().addCookie(e);

        if ( _result == null )
            return;

        _result.applyTo(this);
        _responseSize += _result.getLength();
    }

    public void logResults(String e)
    {
        KmLog.debug("Servlet Results: %s bytes.", e.length());
    }

    public int getResponseSize()
    {
        return _responseSize;
    }

    //##################################################
    //# results (convenience)
    //##################################################

    public void setHtmlResult(KmHtmlBuilder out)
    {
        String html = out.toString();
        setHtmlResult(html);
    }

    public void setHtmlResult(String value)
    {
        boolean noCache = false;
        setHtmlResult(value, noCache);
    }

    public void setHtmlResult(String value, boolean noCache)
    {
        ScSimpleResult r;
        r = new ScSimpleResult();
        r.setValue(value);
        r.setHttpNoCache(noCache);
        r.setContentTypeHtml();

        setResult(r);
    }

    public void setEmptyHtmlResult()
    {
        setHtmlResult("");
    }

    public void setTextResult(String value)
    {
        ScSimpleResult r;
        r = new ScSimpleResult();
        r.setValue(value);
        r.setContentTypeText();
        setResult(r);
    }

    public void setCssResult(String value)
    {
        ScSimpleResult r;
        r = new ScSimpleResult();
        r.setValue(value);
        r.setContentTypeCss();
        setResult(r);
    }

    public void setXmlResult(String value)
    {
        ScSimpleResult r;
        r = new ScSimpleResult();
        r.setValue(value);
        r.setContentTypeXml();
        setResult(r);
    }

    public void setOctetResult(String value)
    {
        ScSimpleResult r;
        r = new ScSimpleResult();
        r.setValue(value);
        r.setContentTypeOctet();
        setResult(r);
    }

    public void setJsonResult(KmJsonObjectIF e)
    {
        setJsonResult(e.formatJson());
    }

    public void setJsonResult(String value)
    {
        ScSimpleResult r;
        r = new ScSimpleResult();
        r.setValue(value);
        r.setContentTypeJson();
        setResult(r);
    }

    public void setAttachmentResult(String name, String value)
    {
        ScSimpleResult r;
        r = new ScSimpleResult();
        r.setValue(value);
        r.setAttachmentName(name);
        setResult(r);
    }

    public void setAttachmentResult(String name, byte[] value)
    {
        ScSimpleResult r;
        r = new ScSimpleResult();
        r.setValue(value);
        r.setAttachmentName(name);
        setResult(r);
    }

    //##################################################
    //# redirect
    //##################################################

    public void redirectTo(String url)
    {
        try
        {
            _getResponse().sendRedirect(url);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void redirectWithPost()
    {
        redirectWithPost(getParameterList());
    }

    public void redirectWithPost(ScParameterList params)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();

        out.beginHtml();

        out.beginHead();
        out.printMetaCharsetUtf8();
        out.printMetaNoCache();
        out.printTitle("Loading...");
        out.endHead();

        out.openBody();
        out.printAttribute("onload", "document.f.submit();");
        out.close();

        out.openForm();
        out.printAttribute("name", "f");
        out.printAttribute("action", getRequestUri());
        out.printAttribute("method", "post");
        out.close();

        KmList<String> keys = params.getKeys();
        for ( String key : keys )
        {
            KmList<String> values = params.getValues(key);
            for ( String value : values )
                out.printHiddenField(key, value);
        }

        out.endForm();
        out.endBody();
        out.endHtml();

        String html = out.toString();
        boolean noCache = true;
        setHtmlResult(html, noCache);
    }

    //##################################################
    //# forward
    //##################################################

    public void forwardTo(String url)
    {
        try
        {
            _getRequest().getRequestDispatcher(url).forward(_getRequest(), _getResponse());
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# misc
    //##################################################

    public boolean hasSecureRequest()
    {
        return _request.isSecure();
    }

    public void flushBuffer()
    {
        try
        {
            _response.flushBuffer();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# errors
    //##################################################

    public KmList<KmErrorIF> getErrors()
    {
        return _errors;
    }

    public KmList<String> getErrorMessages()
    {
        KmList<String> v = new KmList<>();
        for ( KmErrorIF e : getErrors() )
            v.add(e.formatMessage());

        return v;
    }

    public void setError(String msg, Object... args)
    {
        clearErrors();
        addError(msg, args);
    }

    public void addError(String msg, Object... args)
    {
        KmGeneralError e = new KmGeneralError(msg, args);
        _errors.add(e);
    }

    public void addErrorMessages(KmList<String> v)
    {
        for ( String s : v )
            addError(s);
    }

    public void addErrors(KmList<KmErrorIF> v)
    {
        _errors.addAll(v);
    }

    public boolean isOk()
    {
        return _errors.isEmpty();
    }

    public boolean hasErrors()
    {
        return !isOk();
    }

    public void printErrors()
    {
        Iterator<KmErrorIF> i = getErrors().iterator();
        while ( i.hasNext() )
            System.out.println(i.next().formatMessage());
    }

    public KmErrorIF getError(String code)
    {
        for ( KmErrorIF e : getErrors() )
            if ( e.hasCode(code) )
                return e;
        return null;
    }

    public boolean hasError(String code)
    {
        return getError(code) != null;
    }

    public void removeError(String code)
    {
        Iterator<KmErrorIF> i = getErrors().iterator();
        while ( i.hasNext() )
            if ( i.next().hasCode(code) )
                i.remove();
    }

    public void clearErrors()
    {
        _errors.clear();
    }

    //##################################################
    //# resources
    //##################################################

    public String readStringResource(String path)
    {
        try ( InputStream is = _servlet.getServletContext().getResourceAsStream(path);
            StringWriter sw = new StringWriter(); )
        {
            while ( true )
            {
                int i = is.read();

                if ( i < 0 )
                    break;

                sw.write((char)i);
            }

            return sw.toString();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# private
    //##################################################

    public String _normalize(String s)
    {
        if ( !_normalizeParameterValues )
            return s;

        if ( s == null )
            return null;

        s = s.replaceAll(CRLF, LF);
        s = s.replaceAll(CR, LF);
        s = Kmu.stripNonFormPostable(s);
        s = s.trim();
        return s;
    }

    //##################################################
    //# abstract
    //##################################################

    public int getSessionTimeoutSeconds()
    {
        return 600;
    }

    public void releaseResources()
    {
        releaseLocal();
    }

    //##################################################
    //# static (thread local)
    //##################################################

    public static final ThreadLocal<ScServletData> _threadLocal = KmThreadLocalManager.newLocal();

    public static ScServletData getLocal()
    {
        return _threadLocal.get();
    }

    private static void setLocal(ScServletData data)
    {
        _threadLocal.set(data);
    }

    public static boolean hasLocal()
    {
        return getLocal() != null;
    }

    public static void releaseLocal()
    {
        _threadLocal.remove();
    }

    private void setLocal()
    {
        setLocal(this);
    }

    //##################################################
    //# write
    //##################################################

    public void writeBytes(byte[] value)
    {
        try ( OutputStream out = getOutputStream() )
        {
            setContentLength(value.length);
            out.write(value);
        }
        catch ( IOException ex )
        {
            KmLog.warn(ex, "Error writing http response.");
        }
    }

    public void writeFile(KmFile file)
    {
        try ( OutputStream out = getOutputStream() )
        {
            setContentLength((int)file.getLength());
            file.writeTo(out);
        }
        catch ( IOException ex )
        {
            KmLog.warn(ex, "Error writing http response.");
        }
    }

    public void writeAttachment(String name, byte[] value)
    {
        setAttachmentDisposition(name);
        writeBytes(value);
    }

    public void writeAttachmentFile(String name, KmFile file)
    {
        setAttachmentDisposition(name);
        writeFile(file);
    }

    //##################################################
    //# miscellaneous
    //##################################################

    public boolean supportsCopy()
    {
        return isUserAgentInternetExplorer();
    }

}
