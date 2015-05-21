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

public abstract class MySectionDaoBase
    extends KmAbstractDao<MySection,String>
    implements MySectionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySectionDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySection> getPersistentClass()
    {
        return MySection.class;
    }

    @Override
    protected String getTableName()
    {
        return "section";
    }

    @Override
    public MySectionCriteria createCriteria()
    {
        return new MySectionCriteria(createGenericCriteria());
    }

    protected MyMetaSection getMeta()
    {
        return MySection.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySection findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MySection m = findUid(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
