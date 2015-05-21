//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.criteria.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MyActionFilterBase
    extends MyBasicFilter<MyAction>
    implements MyActionDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyAction> c)
    {
        applyConditionsTo((MyActionCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyAction> c)
    {
        applySortsTo((MyActionCriteria)c);
    }

    protected abstract void applyConditionsTo(MyActionCriteria c);

    protected abstract void applySortsTo(MyActionCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAction getMeta()
    {
        return MyAction.Meta;
    }

    @Override
    protected MyActionDao getDao()
    {
        return getAccess().getActionDao();
    }

    @Override
    protected MyActionCriteria createCriteria()
    {
        return new MyActionCriteria(createGenericCriteria());
    }
}
