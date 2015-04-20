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

package com.kodemore.validator;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.types.KmQuantity;

public class KmQuantityValidator
    extends KmValidator<KmQuantity>
{
    //##################################################
    //# variables
    //##################################################

    private boolean _allowNegative;

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validateModel(KmQuantity value, KmList<KmErrorIF> errors)
    {
        //
    }

    public boolean allowsNegative()
    {
        return _allowNegative;
    }

    public void setAllowNegative(boolean e)
    {
        _allowNegative = e;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public KmQuantityValidator getCopy()
    {
        return (KmQuantityValidator)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        // add local variables
    }

}
