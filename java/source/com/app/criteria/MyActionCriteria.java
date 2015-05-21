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

public class MyActionCriteria
    extends MyAbstractCriteria<MyAction>
    implements MyActionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyActionCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyActionCriteria(KmCriteria parent, KmAbstractCriteria context)
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

    public void whereTypeIs(MyActionType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyActionType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsAlert()
    {
        whereTypeIs(MyActionType.Alert);
    }

    public void whereTypeIsNotAlert()
    {
        whereTypeIsNot(MyActionType.Alert);
    }

    public void whereTypeIsAlert(boolean e)
    {
        if ( e )
            whereTypeIsAlert();
        else
            whereTypeIsNotAlert();
    }

    public void whereTypeIsComment()
    {
        whereTypeIs(MyActionType.Comment);
    }

    public void whereTypeIsNotComment()
    {
        whereTypeIsNot(MyActionType.Comment);
    }

    public void whereTypeIsComment(boolean e)
    {
        if ( e )
            whereTypeIsComment();
        else
            whereTypeIsNotComment();
    }

    public void whereTypeIsFyi()
    {
        whereTypeIs(MyActionType.Fyi);
    }

    public void whereTypeIsNotFyi()
    {
        whereTypeIsNot(MyActionType.Fyi);
    }

    public void whereTypeIsFyi(boolean e)
    {
        if ( e )
            whereTypeIsFyi();
        else
            whereTypeIsNotFyi();
    }

    public void whereTypeIsNotify()
    {
        whereTypeIs(MyActionType.Notify);
    }

    public void whereTypeIsNotNotify()
    {
        whereTypeIsNot(MyActionType.Notify);
    }

    public void whereTypeIsNotify(boolean e)
    {
        if ( e )
            whereTypeIsNotify();
        else
            whereTypeIsNotNotify();
    }

    public void whereTypeIsQuestion()
    {
        whereTypeIs(MyActionType.Question);
    }

    public void whereTypeIsNotQuestion()
    {
        whereTypeIsNot(MyActionType.Question);
    }

    public void whereTypeIsQuestion(boolean e)
    {
        if ( e )
            whereTypeIsQuestion();
        else
            whereTypeIsNotQuestion();
    }

    public void whereTypeIsTask()
    {
        whereTypeIs(MyActionType.Task);
    }

    public void whereTypeIsNotTask()
    {
        whereTypeIsNot(MyActionType.Task);
    }

    public void whereTypeIsTask(boolean e)
    {
        if ( e )
            whereTypeIsTask();
        else
            whereTypeIsNotTask();
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

    public void sortOnTitle()
    {
        parent().sortAscending(TITLE);
    }

    public void sortOnTitleDescending()
    {
        parent().sortDescending(TITLE);
    }

    public void sortOnTitle(boolean asc)
    {
        if ( asc )
            sortOnTitle();
        else
            sortOnTitleDescending();
    }

    public void sortOnDescription()
    {
        parent().sortAscending(DESCRIPTION);
    }

    public void sortOnDescriptionDescending()
    {
        parent().sortDescending(DESCRIPTION);
    }

    public void sortOnDescription(boolean asc)
    {
        if ( asc )
            sortOnDescription();
        else
            sortOnDescriptionDescending();
    }

    public void sortOnTypeCode()
    {
        parent().sortAscending(TYPE_CODE);
    }

    public void sortOnTypeCodeDescending()
    {
        parent().sortDescending(TYPE_CODE);
    }

    public void sortOnTypeCode(boolean asc)
    {
        if ( asc )
            sortOnTypeCode();
        else
            sortOnTypeCodeDescending();
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
    //# projections (title)
    //##################################################

    public void selectTitle()
    {
        select(TITLE);
    }

    public void selectDistinctTitle()
    {
        selectDistinct(TITLE);
    }

    public void selectCountDistinctTitle()
    {
        selectCountDistinct(TITLE);
    }

    public void selectMinimumTitle()
    {
        selectMinimum(TITLE);
    }

    public void selectMaximumTitle()
    {
        selectMaximum(TITLE);
    }

    public void selectAverageTitle()
    {
        selectAverage(TITLE);
    }

    public void selectSumTitle()
    {
        selectSum(TITLE);
    }

    public void groupByTitle()
    {
        groupBy(TITLE);
    }

    //##################################################
    //# projections (description)
    //##################################################

    public void selectDescription()
    {
        select(DESCRIPTION);
    }

    public void selectDistinctDescription()
    {
        selectDistinct(DESCRIPTION);
    }

    public void selectCountDistinctDescription()
    {
        selectCountDistinct(DESCRIPTION);
    }

    public void selectMinimumDescription()
    {
        selectMinimum(DESCRIPTION);
    }

    public void selectMaximumDescription()
    {
        selectMaximum(DESCRIPTION);
    }

    public void selectAverageDescription()
    {
        selectAverage(DESCRIPTION);
    }

    public void selectSumDescription()
    {
        selectSum(DESCRIPTION);
    }

    public void groupByDescription()
    {
        groupBy(DESCRIPTION);
    }

    //##################################################
    //# projections (typeCode)
    //##################################################

    public void selectTypeCode()
    {
        select(TYPE_CODE);
    }

    public void selectDistinctTypeCode()
    {
        selectDistinct(TYPE_CODE);
    }

    public void selectCountDistinctTypeCode()
    {
        selectCountDistinct(TYPE_CODE);
    }

    public void selectMinimumTypeCode()
    {
        selectMinimum(TYPE_CODE);
    }

    public void selectMaximumTypeCode()
    {
        selectMaximum(TYPE_CODE);
    }

    public void selectAverageTypeCode()
    {
        selectAverage(TYPE_CODE);
    }

    public void selectSumTypeCode()
    {
        selectSum(TYPE_CODE);
    }

    public void groupByTypeCode()
    {
        groupBy(TYPE_CODE);
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
    //# association (Section)
    //##################################################

    public void selectSectionUid()
    {
        select(SECTION_UID);
    }

    public void selectMinimumSectionUid()
    {
        selectMinimum(SECTION_UID);
    }

    public void selectMaximumSectionUid()
    {
        selectMaximum(SECTION_UID);
    }

    public void groupBySectionUid()
    {
        groupBy(SECTION);
    }

    public MySectionCriteria joinToSection()
    {
        return new MySectionCriteria(joinTo(SECTION));
    }

    public MySectionCriteria leftJoinToSection()
    {
        return new MySectionCriteria(leftJoinTo(SECTION));
    }

    public KmStringCriteria whereSectionUid()
    {
        return new KmStringCriteria(parent(), fullName(SECTION_UID));
    }

    public void whereSectionIs(MySection e)
    {
        if ( e == null )
            whereSectionUid().isNull();
        else
            whereSectionUid().is(e.getUid());
    }

    //##################################################
    //# association (Owner)
    //##################################################

    public void selectOwnerUid()
    {
        select(OWNER_UID);
    }

    public void selectMinimumOwnerUid()
    {
        selectMinimum(OWNER_UID);
    }

    public void selectMaximumOwnerUid()
    {
        selectMaximum(OWNER_UID);
    }

    public void groupByOwnerUid()
    {
        groupBy(OWNER);
    }

    public MyUserCriteria joinToOwner()
    {
        return new MyUserCriteria(joinTo(OWNER));
    }

    public MyUserCriteria leftJoinToOwner()
    {
        return new MyUserCriteria(leftJoinTo(OWNER));
    }

    public KmStringCriteria whereOwnerUid()
    {
        return new KmStringCriteria(parent(), fullName(OWNER_UID));
    }

    public void whereOwnerIs(MyUser e)
    {
        if ( e == null )
            whereOwnerUid().isNull();
        else
            whereOwnerUid().is(e.getUid());
    }

    //##################################################
    //# association (Assignee)
    //##################################################

    public void selectAssigneeUid()
    {
        select(ASSIGNEE_UID);
    }

    public void selectMinimumAssigneeUid()
    {
        selectMinimum(ASSIGNEE_UID);
    }

    public void selectMaximumAssigneeUid()
    {
        selectMaximum(ASSIGNEE_UID);
    }

    public void groupByAssigneeUid()
    {
        groupBy(ASSIGNEE);
    }

    public MyUserCriteria joinToAssignee()
    {
        return new MyUserCriteria(joinTo(ASSIGNEE));
    }

    public MyUserCriteria leftJoinToAssignee()
    {
        return new MyUserCriteria(leftJoinTo(ASSIGNEE));
    }

    public KmStringCriteria whereAssigneeUid()
    {
        return new KmStringCriteria(parent(), fullName(ASSIGNEE_UID));
    }

    public void whereAssigneeIs(MyUser e)
    {
        if ( e == null )
            whereAssigneeUid().isNull();
        else
            whereAssigneeUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyActionJunction addAnd()
    {
        return new MyActionJunction(parent().addAnd());
    }

    public MyActionJunction addOr()
    {
        return new MyActionJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public MyActionCriteria createOn(KmModelJunction junction)
    {
        return new MyActionCriteria(parent(), junction.context());
    }

}
