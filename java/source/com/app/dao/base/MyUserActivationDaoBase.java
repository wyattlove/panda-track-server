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

public abstract class MyUserActivationDaoBase
    extends KmAbstractDao<MyUserActivation,String>
    implements MyUserActivationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserActivationDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyUserActivation> getPersistentClass()
    {
        return MyUserActivation.class;
    }

    @Override
    protected String getTableName()
    {
        return "userActivation";
    }

    @Override
    public MyUserActivationCriteria createCriteria()
    {
        return new MyUserActivationCriteria(createGenericCriteria());
    }

    protected MyMetaUserActivation getMeta()
    {
        return MyUserActivation.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyUserActivation findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyUserActivation m = findUid(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
