package com.kodemore.meta;

import com.kodemore.types.KmHtmlColor;
import com.kodemore.validator.KmHtmlColorValidator;

public abstract class KmMetaHtmlColorProperty<T>
    extends KmMetaProperty<T,KmHtmlColor>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmHtmlColorValidator getValidator()
    {
        return null;
    }

}
