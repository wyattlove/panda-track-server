package com.kodemore.meta;

import com.kodemore.time.KmTime;
import com.kodemore.validator.KmTimeValidator;

public abstract class KmMetaTimeProperty<T>
    extends KmMetaProperty<T,KmTime>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmTimeValidator getValidator()
    {
        return null;
    }

}
