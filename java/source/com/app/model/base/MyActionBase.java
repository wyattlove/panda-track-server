//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.utility.*;

public abstract class MyActionBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAction Meta = MyMetaAction.instance;
    public static final MyActionTools Tools = MyActionTools.instance;
    public static final MyActionValidator Validator = MyActionValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String title;
    private String description;
    private String typeCode;
    private Integer lockVersion;
    private MySection section;
    private MyUser owner;
    private MyUser assignee;

    //##################################################
    //# constructor
    //##################################################

    public MyActionBase()
    {
        super();
        setUid(newUid());
        setTypeCode(MyActionType.Task.getCode());
    }

    //##################################################
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        checkReadOnly();
        e = Validator.getUidValidator().convertOnly(e);
        uid = e;
    }

    public void clearUid()
    {
        setUid(null);
    }

    public boolean hasUid()
    {
        return Kmu.hasValue(getUid());
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getUid(), e);
    }

    public void truncateUid()
    {
        truncateUid(false);
    }

    public void truncateUid(boolean ellipses)
    {
        uid = Kmu.truncate(uid, 30, ellipses);
    }

    //##################################################
    //# field (title)
    //##################################################

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String e)
    {
        checkReadOnly();
        e = Validator.getTitleValidator().convertOnly(e);
        title = e;
    }

    public void clearTitle()
    {
        setTitle(null);
    }

    public boolean hasTitle()
    {
        return Kmu.hasValue(getTitle());
    }

    public boolean hasTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getTitle(), e);
    }

    public void truncateTitle()
    {
        truncateTitle(false);
    }

    public void truncateTitle(boolean ellipses)
    {
        title = Kmu.truncate(title, 50, ellipses);
    }

    //##################################################
    //# field (description)
    //##################################################

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String e)
    {
        checkReadOnly();
        e = Validator.getDescriptionValidator().convertOnly(e);
        description = e;
    }

    public void clearDescription()
    {
        setDescription(null);
    }

    public boolean hasDescription()
    {
        return Kmu.hasValue(getDescription());
    }

    public boolean hasDescription(String e)
    {
        return Kmu.isEqualIgnoreCase(getDescription(), e);
    }

    public void truncateDescription()
    {
        truncateDescription(false);
    }

    public void truncateDescription(boolean ellipses)
    {
        description = Kmu.truncate(description, 100, ellipses);
    }

    //##################################################
    //# field (typeCode)
    //##################################################

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String e)
    {
        checkReadOnly();
        e = Validator.getTypeCodeValidator().convertOnly(e);
        typeCode = e;
    }

    public void clearTypeCode()
    {
        setTypeCode(null);
    }

    public boolean hasTypeCode()
    {
        return Kmu.hasValue(getTypeCode());
    }

    public boolean hasTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getTypeCode(), e);
    }

    public void truncateTypeCode()
    {
        truncateTypeCode(false);
    }

    public void truncateTypeCode(boolean ellipses)
    {
        typeCode = Kmu.truncate(typeCode, 1, ellipses);
    }

    public MyActionType getType()
    {
        return MyActionType.findCode(getTypeCode());
    }

    public void setType(MyActionType e)
    {
        if ( e == null )
            setTypeCode(null);
        else
            setTypeCode(e.getCode());
    }

    public boolean hasType()
    {
        return getType() != null;
    }

    public boolean hasType(MyActionType e)
    {
        return getType() == e;
    }

    public void setTypeAlert()
    {
        setType(MyActionType.Alert);
    }

    public boolean isTypeAlert()
    {
        return hasType(MyActionType.Alert);
    }

    public boolean isNotTypeAlert()
    {
        return !isTypeAlert();
    }

    public void setTypeComment()
    {
        setType(MyActionType.Comment);
    }

    public boolean isTypeComment()
    {
        return hasType(MyActionType.Comment);
    }

    public boolean isNotTypeComment()
    {
        return !isTypeComment();
    }

    public void setTypeFyi()
    {
        setType(MyActionType.Fyi);
    }

    public boolean isTypeFyi()
    {
        return hasType(MyActionType.Fyi);
    }

    public boolean isNotTypeFyi()
    {
        return !isTypeFyi();
    }

    public void setTypeNotify()
    {
        setType(MyActionType.Notify);
    }

    public boolean isTypeNotify()
    {
        return hasType(MyActionType.Notify);
    }

    public boolean isNotTypeNotify()
    {
        return !isTypeNotify();
    }

    public void setTypeQuestion()
    {
        setType(MyActionType.Question);
    }

    public boolean isTypeQuestion()
    {
        return hasType(MyActionType.Question);
    }

    public boolean isNotTypeQuestion()
    {
        return !isTypeQuestion();
    }

    public void setTypeTask()
    {
        setType(MyActionType.Task);
    }

    public boolean isTypeTask()
    {
        return hasType(MyActionType.Task);
    }

    public boolean isNotTypeTask()
    {
        return !isTypeTask();
    }

    //##################################################
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        checkReadOnly();
        e = Validator.getLockVersionValidator().convertOnly(e);
        lockVersion = e;
    }

    public void clearLockVersion()
    {
        setLockVersion(null);
    }

    public boolean hasLockVersion()
    {
        return getLockVersion() != null;
    }

    public boolean hasLockVersion(Integer e)
    {
        return Kmu.isEqual(getLockVersion(), e);
    }

    //##################################################
    //# field (typeName)
    //##################################################

    public final String getTypeName()
    {
        return Kmu.getName(getType());
    }

    public boolean hasTypeName()
    {
        return Kmu.hasValue(getTypeName());
    }

    public boolean hasTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getTypeName(), e);
    }

    //##################################################
    //# section
    //##################################################

    public MySection getSection()
    {
        return section;
    }

    public void setSection(MySection e)
    {
        checkReadOnly();
        section = e;
    }

    public void _setSection(MySection e)
    {
        checkReadOnly();
        section = e;
    }

    public void clearSection()
    {
        setSection(null);
    }

    public boolean hasSection()
    {
        return getSection() != null;
    }

    public boolean hasSection(MySection e)
    {
        return Kmu.isEqual(getSection(), e);
    }

    public String getSectionName()
    {
        if ( hasSection() )
            return getSection().getName();
        return null;
    }

    public void setSectionName(String e)
    {
        getSection().setName(e);
    }

    public boolean hasSectionName()
    {
        return hasSection() && getSection().hasName();
    }

    public boolean hasSectionName(String e)
    {
        return hasSection() && getSection().hasName(e);
    }

    //##################################################
    //# owner
    //##################################################

    public MyUser getOwner()
    {
        return owner;
    }

    public void setOwner(MyUser e)
    {
        checkReadOnly();
        owner = e;
    }

    public void _setOwner(MyUser e)
    {
        checkReadOnly();
        owner = e;
    }

    public void clearOwner()
    {
        setOwner(null);
    }

    public boolean hasOwner()
    {
        return getOwner() != null;
    }

    public boolean hasOwner(MyUser e)
    {
        return Kmu.isEqual(getOwner(), e);
    }

    public String getOwnerUid()
    {
        if ( hasOwner() )
            return getOwner().getUid();
        return null;
    }

    public void setOwnerUid(String e)
    {
        getOwner().setUid(e);
    }

    public boolean hasOwnerUid()
    {
        return hasOwner() && getOwner().hasUid();
    }

    public boolean hasOwnerUid(String e)
    {
        return hasOwner() && getOwner().hasUid(e);
    }

    public String getOwnerName()
    {
        if ( hasOwner() )
            return getOwner().getName();
        return null;
    }

    public void setOwnerName(String e)
    {
        getOwner().setName(e);
    }

    public boolean hasOwnerName()
    {
        return hasOwner() && getOwner().hasName();
    }

    public boolean hasOwnerName(String e)
    {
        return hasOwner() && getOwner().hasName(e);
    }

    //##################################################
    //# assignee
    //##################################################

    public MyUser getAssignee()
    {
        return assignee;
    }

    public void setAssignee(MyUser e)
    {
        checkReadOnly();
        assignee = e;
    }

    public void _setAssignee(MyUser e)
    {
        checkReadOnly();
        assignee = e;
    }

    public void clearAssignee()
    {
        setAssignee(null);
    }

    public boolean hasAssignee()
    {
        return getAssignee() != null;
    }

    public boolean hasAssignee(MyUser e)
    {
        return Kmu.isEqual(getAssignee(), e);
    }

    public String getAssigneeUid()
    {
        if ( hasAssignee() )
            return getAssignee().getUid();
        return null;
    }

    public void setAssigneeUid(String e)
    {
        getAssignee().setUid(e);
    }

    public boolean hasAssigneeUid()
    {
        return hasAssignee() && getAssignee().hasUid();
    }

    public boolean hasAssigneeUid(String e)
    {
        return hasAssignee() && getAssignee().hasUid(e);
    }

    public String getAssigneeName()
    {
        if ( hasAssignee() )
            return getAssignee().getName();
        return null;
    }

    public void setAssigneeName(String e)
    {
        getAssignee().setName(e);
    }

    public boolean hasAssigneeName()
    {
        return hasAssignee() && getAssignee().hasName();
    }

    public boolean hasAssigneeName(String e)
    {
        return hasAssignee() && getAssignee().hasName(e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyAction)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyAction)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyAction)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAction getCopy()
    {
        return (MyAction)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        section = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyActionBase) )
            return false;

        MyActionBase e = (MyActionBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAction e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAction e)
    {
        if ( !Kmu.isEqual(getTitle(), e.getTitle()) ) return false;
        if ( !Kmu.isEqual(getDescription(), e.getDescription()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyAction e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAction e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# property
    //##################################################

    public void importPropertyMap(KmMap<String,String> map)
    {
        KmProperties p;
        p = new KmProperties();
        p.setMap(map);

        if ( p.hasKey("uid") )
            setUid(p.getString("uid"));

        if ( p.hasKey("title") )
            setTitle(p.getString("title"));

        if ( p.hasKey("description") )
            setDescription(p.getString("description"));

        if ( p.hasKey("typeCode") )
            setTypeCode(p.getString("typeCode"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasTitle() )
            p.setString("title", getTitle());

        if ( hasDescription() )
            p.setString("description", getDescription());

        if ( hasTypeCode() )
            p.setString("typeCode", getTypeCode());

        if ( hasLockVersion() )
            p.setInteger("lockVersion", getLockVersion());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyAction");
        sb.append("(");
        sb.append("Uid=");
        sb.append(uid);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Uid = " + uid);
        System.out.println("    Title = " + title);
        System.out.println("    Description = " + description);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    LockVersion = " + lockVersion);
    }
}
