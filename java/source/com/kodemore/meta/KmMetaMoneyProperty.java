package com.kodemore.meta;

import com.kodemore.types.KmMoney;
import com.kodemore.validator.KmMoneyValidator;

public abstract class KmMetaMoneyProperty<T>
    extends KmMetaProperty<T,KmMoney>
{
    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmMoneyValidator getValidator()
    {
        return null;
    }

}
