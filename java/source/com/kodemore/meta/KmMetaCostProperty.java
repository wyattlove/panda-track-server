package com.kodemore.meta;

import com.kodemore.types.KmCost;
import com.kodemore.validator.KmCostValidator;

public abstract class KmMetaCostProperty<T>
    extends KmMetaProperty<T,KmCost>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmCostValidator getValidator()
    {
        return null;
    }
}
