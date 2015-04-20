package com.kodemore.meta;

import com.kodemore.validator.KmLongValidator;

public abstract class KmMetaLongProperty<T>
    extends KmMetaProperty<T,Long>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmLongValidator getValidator()
    {
        return null;
    }

}
