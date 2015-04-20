package com.kodemore.meta;

import com.kodemore.validator.KmStringValidator;

public abstract class KmMetaStringProperty<T>
    extends KmMetaProperty<T,String>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmStringValidator getValidator()
    {
        return null;
    }
}
