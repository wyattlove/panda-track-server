package com.kodemore.meta;

import com.kodemore.types.KmDayFrequency;
import com.kodemore.validator.KmDayFrequencyValidator;

public abstract class KmMetaDayFrequencyProperty<T>
    extends KmMetaProperty<T,KmDayFrequency>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmDayFrequencyValidator getValidator()
    {
        return null;
    }

}
