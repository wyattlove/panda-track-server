package com.kodemore.meta;

import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmTimestampValidator;

public abstract class KmMetaTimestampProperty<T>
    extends KmMetaProperty<T,KmTimestamp>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmTimestampValidator getValidator()
    {
        return null;
    }

}
