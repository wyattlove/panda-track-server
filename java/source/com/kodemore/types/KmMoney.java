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

import java.math.BigDecimal;

/**
 * I represent money.  Values are stored as fixed decimal, rounding
 * occurs to 2 decimals after each operation.
 *
 * I provide utility methods for calculating amounts.
 *
 * IMPORTANT: This class should NOT be used when running calculations
 * against large sets of data, as I wrap the KmDecimal. See KmDecimal
 * for more details.
 */
public class KmMoney
    extends KmFixedDecimal<KmMoney>
{
    //##################################################
    //# constants (database)
    //##################################################

    public static final KmMoney ZERO               = new KmMoney(0);

    public static final int     DATABASE_PRECISION = 20;
    public static final int     SCALE              = 2;

    //##################################################
    //# constructor
    //##################################################

    public KmMoney(double e)
    {
        super(e);
    }

    public KmMoney(int e)
    {
        super(e);
    }

    public KmMoney(BigDecimal e)
    {
        super(e);
    }

    //##################################################
    //# policy
    //##################################################

    @Override
    public int getScale()
    {
        return SCALE;
    }

    //##################################################
    //# support
    //##################################################

    @Override
    protected KmMoney newFixed(BigDecimal e)
    {
        return new KmMoney(e);
    }

    @Override
    public KmMoney getZero()
    {
        return ZERO;
    }

}
