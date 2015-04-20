package com.kodemore.meta;

import com.kodemore.types.KmQuantity;
import com.kodemore.validator.KmQuantityValidator;

public abstract class KmMetaQuantityProperty<T>
    extends KmMetaProperty<T,KmQuantity>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmQuantityValidator getValidator()
    {
        return null;
    }
}
