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

public abstract class MyActionDaoBase
    extends KmAbstractDao<MyAction,String>
    implements MyActionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyActionDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAction> getPersistentClass()
    {
        return MyAction.class;
    }

    @Override
    protected String getTableName()
    {
        return "action";
    }

    @Override
    public MyActionCriteria createCriteria()
    {
        return new MyActionCriteria(createGenericCriteria());
    }

    protected MyMetaAction getMeta()
    {
        return MyAction.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAction findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAction m = findUid(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
