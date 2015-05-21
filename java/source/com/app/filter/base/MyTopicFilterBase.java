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

public abstract class MyTopicFilterBase
    extends MyBasicFilter<MyTopic>
    implements MyTopicDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyTopic> c)
    {
        applyConditionsTo((MyTopicCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyTopic> c)
    {
        applySortsTo((MyTopicCriteria)c);
    }

    protected abstract void applyConditionsTo(MyTopicCriteria c);

    protected abstract void applySortsTo(MyTopicCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaTopic getMeta()
    {
        return MyTopic.Meta;
    }

    @Override
    protected MyTopicDao getDao()
    {
        return getAccess().getTopicDao();
    }

    @Override
    protected MyTopicCriteria createCriteria()
    {
        return new MyTopicCriteria(createGenericCriteria());
    }
}
