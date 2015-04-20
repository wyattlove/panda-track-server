package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.meta.KmMetaLongProperty;
import com.kodemore.validator.KmLongValidator;

public class KmProtoLong
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "long";
    }

    @Override
    public Class<?> getJavaType()
    {
        return Long.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return "bigint";
    }

    @Override
    public String getHibernateType()
    {
        return "long";
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmLongValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaLongProperty.class;
    }

}
