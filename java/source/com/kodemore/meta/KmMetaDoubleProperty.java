package com.kodemore.meta;

import com.kodemore.validator.KmDoubleValidator;

public abstract class KmMetaDoubleProperty<T>
    extends KmMetaProperty<T,Double>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmDoubleValidator getValidator()
    {
        return null;
    }

}
