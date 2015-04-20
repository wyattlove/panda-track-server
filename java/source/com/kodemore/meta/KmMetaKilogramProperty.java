package com.kodemore.meta;

import com.kodemore.types.KmKilogram;
import com.kodemore.validator.KmKilogramValidator;

public abstract class KmMetaKilogramProperty<T>
    extends KmMetaProperty<T,KmKilogram>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmKilogramValidator getValidator()
    {
        return null;
    }
}
