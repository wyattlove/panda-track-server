package com.kodemore.meta;

import com.kodemore.types.KmRate;
import com.kodemore.validator.KmRateValidator;

public abstract class KmMetaRateProperty<T>
    extends KmMetaProperty<T,KmRate>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmRateValidator getValidator()
    {
        return null;
    }
}
