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

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MySectionCriteria
    extends MyAbstractCriteria<MySection>
    implements MySectionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySectionCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MySectionCriteria(KmCriteria parent, KmAbstractCriteria context)
    {
        super(parent, context);
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
    //# sorts
    //##################################################

    public void sortOnUid()
    {
        parent().sortAscending(UID);
    }

    public void sortOnUidDescending()
    {
        parent().sortDescending(UID);
    }

    public void sortOnUid(boolean asc)
    {
        if ( asc )
            sortOnUid();
        else
            sortOnUidDescending();
    }

    public void sortOnName()
    {
        parent().sortAscending(NAME);
    }

    public void sortOnNameDescending()
    {
        parent().sortDescending(NAME);
    }

    public void sortOnName(boolean asc)
    {
        if ( asc )
            sortOnName();
        else
            sortOnNameDescending();
    }

    public void sortOnSequence()
    {
        parent().sortAscending(SEQUENCE);
    }

    public void sortOnSequenceDescending()
    {
        parent().sortDescending(SEQUENCE);
    }

    public void sortOnSequence(boolean asc)
    {
        if ( asc )
            sortOnSequence();
        else
            sortOnSequenceDescending();
    }

    public void sortOnLockVersion()
    {
        parent().sortAscending(LOCK_VERSION);
    }

    public void sortOnLockVersionDescending()
    {
        parent().sortDescending(LOCK_VERSION);
    }

    public void sortOnLockVersion(boolean asc)
    {
        if ( asc )
            sortOnLockVersion();
        else
            sortOnLockVersionDescending();
    }

    //##################################################
    //# projections (uid)
    //##################################################

    public void selectUid()
    {
        select(UID);
    }

    public void selectDistinctUid()
    {
        selectDistinct(UID);
    }

    public void selectCountDistinctUid()
    {
        selectCountDistinct(UID);
    }

    public void selectMinimumUid()
    {
        selectMinimum(UID);
    }

    public void selectMaximumUid()
    {
        selectMaximum(UID);
    }

    public void selectAverageUid()
    {
        selectAverage(UID);
    }

    public void selectSumUid()
    {
        selectSum(UID);
    }

    public void groupByUid()
    {
        groupBy(UID);
    }

    //##################################################
    //# projections (name)
    //##################################################

    public void selectName()
    {
        select(NAME);
    }

    public void selectDistinctName()
    {
        selectDistinct(NAME);
    }

    public void selectCountDistinctName()
    {
        selectCountDistinct(NAME);
    }

    public void selectMinimumName()
    {
        selectMinimum(NAME);
    }

    public void selectMaximumName()
    {
        selectMaximum(NAME);
    }

    public void selectAverageName()
    {
        selectAverage(NAME);
    }

    public void selectSumName()
    {
        selectSum(NAME);
    }

    public void groupByName()
    {
        groupBy(NAME);
    }

    //##################################################
    //# projections (sequence)
    //##################################################

    public void selectSequence()
    {
        select(SEQUENCE);
    }

    public void selectDistinctSequence()
    {
        selectDistinct(SEQUENCE);
    }

    public void selectCountDistinctSequence()
    {
        selectCountDistinct(SEQUENCE);
    }

    public void selectMinimumSequence()
    {
        selectMinimum(SEQUENCE);
    }

    public void selectMaximumSequence()
    {
        selectMaximum(SEQUENCE);
    }

    public void selectAverageSequence()
    {
        selectAverage(SEQUENCE);
    }

    public void selectSumSequence()
    {
        selectSum(SEQUENCE);
    }

    public void groupBySequence()
    {
        groupBy(SEQUENCE);
    }

    //##################################################
    //# projections (lockVersion)
    //##################################################

    public void selectLockVersion()
    {
        select(LOCK_VERSION);
    }

    public void selectDistinctLockVersion()
    {
        selectDistinct(LOCK_VERSION);
    }

    public void selectCountDistinctLockVersion()
    {
        selectCountDistinct(LOCK_VERSION);
    }

    public void selectMinimumLockVersion()
    {
        selectMinimum(LOCK_VERSION);
    }

    public void selectMaximumLockVersion()
    {
        selectMaximum(LOCK_VERSION);
    }

    public void selectAverageLockVersion()
    {
        selectAverage(LOCK_VERSION);
    }

    public void selectSumLockVersion()
    {
        selectSum(LOCK_VERSION);
    }

    public void groupByLockVersion()
    {
        groupBy(LOCK_VERSION);
    }

    //##################################################
    //# association (Topic)
    //##################################################

    public void selectTopicUid()
    {
        select(TOPIC_UID);
    }

    public void selectMinimumTopicUid()
    {
        selectMinimum(TOPIC_UID);
    }

    public void selectMaximumTopicUid()
    {
        selectMaximum(TOPIC_UID);
    }

    public void groupByTopicUid()
    {
        groupBy(TOPIC);
    }

    public MyTopicCriteria joinToTopic()
    {
        return new MyTopicCriteria(joinTo(TOPIC));
    }

    public MyTopicCriteria leftJoinToTopic()
    {
        return new MyTopicCriteria(leftJoinTo(TOPIC));
    }

    public KmStringCriteria whereTopicUid()
    {
        return new KmStringCriteria(parent(), fullName(TOPIC_UID));
    }

    public void whereTopicIs(MyTopic e)
    {
        if ( e == null )
            whereTopicUid().isNull();
        else
            whereTopicUid().is(e.getUid());
    }

    //##################################################
    //# collection (Actions)
    //##################################################

    public MyActionCriteria joinToActions()
    {
        return new MyActionCriteria(joinTo(ACTIONS));
    }

    public MyActionCriteria leftJoinToActions()
    {
        return new MyActionCriteria(leftJoinTo(ACTIONS));
    }

    //##################################################
    //# junction
    //##################################################

    public MySectionJunction addAnd()
    {
        return new MySectionJunction(parent().addAnd());
    }

    public MySectionJunction addOr()
    {
        return new MySectionJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public MySectionCriteria createOn(KmModelJunction junction)
    {
        return new MySectionCriteria(parent(), junction.context());
    }

}
