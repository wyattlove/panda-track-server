package com.kodemore.meta;

import com.kodemore.time.KmDate;
import com.kodemore.validator.KmDateValidator;

public abstract class KmMetaDateProperty<T>
    extends KmMetaProperty<T,KmDate>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmDateValidator getValidator()
    {
        return null;
    }
}
