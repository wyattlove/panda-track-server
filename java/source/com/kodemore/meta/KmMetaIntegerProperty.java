package com.kodemore.meta;

import com.kodemore.validator.KmIntegerValidator;

public abstract class KmMetaIntegerProperty<T>
    extends KmMetaProperty<T,Integer>
{
    //##################################################
    //# validator
    //##################################################

    @Override
    public KmIntegerValidator getValidator()
    {
        return null;
    }

}
