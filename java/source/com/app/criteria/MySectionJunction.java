//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.criteria;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.criteria.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MySectionJunction
    extends KmModelJunction
    implements MySectionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySectionJunction(KmJunction context)
    {
        super(context);
    }

    public MySectionJunction(KmJunction context, KmAbstractCriteria parent)
    {
        super(context, parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmStringCriteria whereUid()
    {
        return new KmStringCriteria(context(), fullName(UID));
    }

    public KmStringCriteria whereName()
    {
        return new KmStringCriteria(context(), fullName(NAME));
    }

    public KmIntegerCriteria whereSequence()
    {
        return new KmIntegerCriteria(context(), fullName(SEQUENCE));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    public MyTopicCriteria joinToTopic()
    {
        return join(new MyTopicCriteria(root().joinTo(TOPIC)));
    }

    public MyTopicCriteria leftJoinToTopic()
    {
        return join(new MyTopicCriteria(root().leftJoinTo(TOPIC)));
    }

    public KmStringCriteria whereTopicUid()
    {
        return new KmStringCriteria(context(), fullName(TOPIC_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MySectionJunction addAnd()
    {
        return new MySectionJunction(context().addAnd(), parent());
    }

    public MySectionJunction addOr()
    {
        return new MySectionJunction(context().addOr(), parent());
    }

}
