//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.dao.base;

import com.kodemore.collection.*;
import com.kodemore.dao.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.criteria.*;
import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MyTopicDaoBase
    extends KmAbstractDao<MyTopic,String>
    implements MyTopicDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyTopicDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyTopic> getPersistentClass()
    {
        return MyTopic.class;
    }

    @Override
    protected String getTableName()
    {
        return "topic";
    }

    @Override
    public MyTopicCriteria createCriteria()
    {
        return new MyTopicCriteria(createGenericCriteria());
    }

    protected MyMetaTopic getMeta()
    {
        return MyTopic.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyTopic findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyTopic m = findUid(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
