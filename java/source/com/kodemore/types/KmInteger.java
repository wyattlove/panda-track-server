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

package com.kodemore.types;

import com.kodemore.utility.KmConstantsIF;

/**
 * I act as a value holder for the int primitive.  You might use this
 * class instead of Java.lang.Integer when you want to be able to change
 * the value.
 */
public class KmInteger
    implements KmConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private int _value;

    //##################################################
    //# constructor
    //##################################################

    public KmInteger()
    {
        _value = 0;
    }

    public KmInteger(int value)
    {
        _value = value;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getValue()
    {
        return _value;
    }

    public void setValue(int e)
    {
        _value = e;
    }

    public void clear()
    {
        _value = UNDEFINED_INT;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public void increment()
    {
        _value++;
    }

    public void decrement()
    {
        _value--;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isZero()
    {
        return _value == 0;
    }

    public boolean isDefined()
    {
        return _value != UNDEFINED_INT;
    }

    public boolean isUndefined()
    {
        return _value == UNDEFINED_INT;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return _value + "";
    }
}
