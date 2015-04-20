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

import com.kodemore.utility.KmConstantsIF;

/**
 * I provide a common location for constants used by this package.
 */
public interface ScConstantsIF
    extends KmConstantsIF
{
    //##################################################
    //# parameters
    //##################################################

    /**
     * Some implementations of browsers or servlet engines
     * may not correctly remove cookies upon request so we
     * set the cookie value to well known value that we later
     * check for in getCookies().
     */
    String REMOVED_COOKIE_VALUE    = "[[#REMOVED#]]";

    //##################################################
    //# content types
    //##################################################

    String CONTENT_TYPE_BINARY     = "application/octet-stream";
    String CONTENT_TYPE_HTML       = "text/html";
    String CONTENT_TYPE_JPEG       = "image/jpeg";
    String CONTENT_TYPE_JSON       = "application/json";
    String CONTENT_TYPE_OCTET      = "application/octet-stream";
    String CONTENT_TYPE_PDF        = "application/pdf";
    String CONTENT_TYPE_SERIALIZED = "application/x-java-serialized-object";
    String CONTENT_TYPE_TEXT       = "text/plain";
    String CONTENT_TYPE_CSS        = "text/css";
    String CONTENT_TYPE_XML        = "text/xml";

}
