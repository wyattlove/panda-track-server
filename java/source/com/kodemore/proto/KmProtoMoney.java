package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.hibernate.KmHibernateMoneyType;
import com.kodemore.meta.KmMetaMoneyProperty;
import com.kodemore.types.KmMoney;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmMoneyValidator;

public class KmProtoMoney
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "money";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmMoney.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return Kmu.format("decimal(%s,%s)", KmMoney.DATABASE_PRECISION, KmMoney.SCALE);
    }

    @Override
    public String getHibernateType()
    {
        return KmHibernateMoneyType.class.getName();
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmMoneyValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaMoneyProperty.class;
    }

}
