package com.kodemore.meta;

import com.kodemore.validator.KmBooleanValidator;

public abstract class KmMetaBooleanProperty<T>
    extends KmMetaProperty<T,Boolean>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmBooleanValidator getValidator()
    {
        return null;
    }

}
