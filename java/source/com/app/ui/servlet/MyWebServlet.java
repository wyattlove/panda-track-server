package com.app.ui.servlet;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.KmClock;

import com.app.ui.core.MyServletData;

/**
 * Handle entry into the application, typically initiated
 * from an HTTP GET.
 *
 * -- Redirect to a standard url.
 * -- Redirect the GET with a POST (to avoid caching).
 * -- Begin the server session and register the cookie.
 * -- Generate the minimal html page, just enough to bootstrap the first ajax request.
 */
public class MyWebServlet
    extends MyServlet
    implements MyServletConstantsIF
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        handle();
    }

    @Override
    protected void doPost()
    {
        handle();
    }

    //##################################################
    //# handle
    //##################################################

    private void handle()
    {
        MyServletData data = getData();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.beginHtml();
        out.beginBody();
        out.println(getClass().getSimpleName());
        out.println(KmClock.getNowLocal().format_m_d_yyyy_hh_mm_ss());

        out.println();
        out.println("Request");
        out.println("uri: " + data.getRequestUri());
        out.println("uri: " + data.getRequestUriAndQueryString());

        out.println();
        out.println("Parameters");
        KmList<String> keys = data.getParameterKeys();
        for ( String key : keys )
            out.printfln("%s = %s", key, data.getParameters(key).format());

        out.endBody();
        out.endHtml();

        data.setHtmlResult(out);
    }
}
