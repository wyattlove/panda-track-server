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

public class MyActionJunction
    extends KmModelJunction
    implements MyActionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyActionJunction(KmJunction context)
    {
        super(context);
    }

    public MyActionJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmStringCriteria whereTitle()
    {
        return new KmStringCriteria(context(), fullName(TITLE));
    }

    public KmStringCriteria whereDescription()
    {
        return new KmStringCriteria(context(), fullName(DESCRIPTION));
    }

    public KmStringCriteria whereTypeCode()
    {
        return new KmStringCriteria(context(), fullName(TYPE_CODE));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    public MySectionCriteria joinToSection()
    {
        return join(new MySectionCriteria(root().joinTo(SECTION)));
    }

    public MySectionCriteria leftJoinToSection()
    {
        return join(new MySectionCriteria(root().leftJoinTo(SECTION)));
    }

    public KmStringCriteria whereSectionUid()
    {
        return new KmStringCriteria(context(), fullName(SECTION_UID));
    }

    public MyUserCriteria joinToOwner()
    {
        return join(new MyUserCriteria(root().joinTo(OWNER)));
    }

    public MyUserCriteria leftJoinToOwner()
    {
        return join(new MyUserCriteria(root().leftJoinTo(OWNER)));
    }

    public KmStringCriteria whereOwnerUid()
    {
        return new KmStringCriteria(context(), fullName(OWNER_UID));
    }

    public MyUserCriteria joinToAssignee()
    {
        return join(new MyUserCriteria(root().joinTo(ASSIGNEE)));
    }

    public MyUserCriteria leftJoinToAssignee()
    {
        return join(new MyUserCriteria(root().leftJoinTo(ASSIGNEE)));
    }

    public KmStringCriteria whereAssigneeUid()
    {
        return new KmStringCriteria(context(), fullName(ASSIGNEE_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyActionJunction addAnd()
    {
        return new MyActionJunction(context().addAnd(), parent());
    }

    public MyActionJunction addOr()
    {
        return new MyActionJunction(context().addOr(), parent());
    }

}
