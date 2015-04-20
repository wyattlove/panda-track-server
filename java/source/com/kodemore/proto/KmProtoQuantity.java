package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.meta.KmMetaQuantityProperty;
import com.kodemore.types.KmQuantity;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmQuantityValidator;

public class KmProtoQuantity
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "quantity";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmQuantity.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return Kmu.format("decimal(%s,%s)", KmQuantity.DATABASE_PRECISION, KmQuantity.SCALE);
    }

    @Override
    public String getHibernateType()
    {
        return null;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmQuantityValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaQuantityProperty.class;
    }

}
