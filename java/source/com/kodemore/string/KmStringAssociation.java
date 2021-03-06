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

package com.kodemore.string;

import java.io.Serializable;

import com.kodemore.utility.Kmu;

public class KmStringAssociation
    implements Serializable
{
    //##################################################
    //# constructor
    //##################################################

    public KmStringAssociation()
    {
        this(null, null);
    }

    public KmStringAssociation(String key, String value)
    {
        _key = key;
        _value = value;
    }

    //##################################################
    //# variables
    //##################################################

    private String _key;
    private String _value;

    //##################################################
    //# accessing
    //##################################################

    public String getKey()
    {
        return _key;
    }

    public void setKey(String e)
    {
        _key = e;
    }

    public boolean hasKey(String e)
    {
        return Kmu.isEqual(_key, e);
    }

    public String getValue()
    {
        return _value;
    }

    public void setValue(String e)
    {
        _value = e;
    }

    public boolean hasValue(String e)
    {
        return Kmu.isEqual(_value, e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("%s=%s", getKey(), getValue());
    }
}
