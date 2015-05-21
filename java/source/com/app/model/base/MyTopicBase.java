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

public abstract class MyTopicBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaTopic Meta = MyMetaTopic.instance;
    public static final MyTopicTools Tools = MyTopicTools.instance;
    public static final MyTopicValidator Validator = MyTopicValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private Integer lockVersion;
    private MyProject project;
    private List<MySection> sections;

    //##################################################
    //# constructor
    //##################################################

    public MyTopicBase()
    {
        super();
        setUid(newUid());
        sections = new ArrayList<>();
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
    //# field (name)
    //##################################################

    public String getName()
    {
        return name;
    }

    public void setName(String e)
    {
        checkReadOnly();
        e = Validator.getNameValidator().convertOnly(e);
        name = e;
    }

    public void clearName()
    {
        setName(null);
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    public boolean hasName(String e)
    {
        return Kmu.isEqualIgnoreCase(getName(), e);
    }

    public void truncateName()
    {
        truncateName(false);
    }

    public void truncateName(boolean ellipses)
    {
        name = Kmu.truncate(name, 50, ellipses);
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
    //# project
    //##################################################

    public MyProject getProject()
    {
        return project;
    }

    public void setProject(MyProject e)
    {
        checkReadOnly();
        project = e;
    }

    public void _setProject(MyProject e)
    {
        checkReadOnly();
        project = e;
    }

    public void clearProject()
    {
        setProject(null);
    }

    public boolean hasProject()
    {
        return getProject() != null;
    }

    public boolean hasProject(MyProject e)
    {
        return Kmu.isEqual(getProject(), e);
    }

    public String getProjectName()
    {
        if ( hasProject() )
            return getProject().getName();
        return null;
    }

    public void setProjectName(String e)
    {
        getProject().setName(e);
    }

    public boolean hasProjectName()
    {
        return hasProject() && getProject().hasName();
    }

    public boolean hasProjectName(String e)
    {
        return hasProject() && getProject().hasName(e);
    }


    //##################################################
    //# Sections (collection)
    //##################################################

    public KmCollection<MySection> getSections()
    {
        return new KmHibernateCollection<>(
            getBaseSections(),
            (MyTopic)this,
            MySection.Meta.Topic.getAdaptor());
    }

    public KmList<MySection> getSortedSections()
    {
        KmList<MySection> v;
        v = getSections().toList();
        v.sortOn(MySection.Meta.Sequence);
        return v;
    }

    public boolean hasSections()
    {
        return !getBaseSections().isEmpty();
    }

    public int getSectionCount()
    {
        return getBaseSections().size();
    }

    public List<MySection> getBaseSections()
    {
        return sections;
    }

    public MySection addSection()
    {
        MySection e;
        e = new MySection();
        e.setSequence(getSections().getNextSequence());
        getSections().add(e);
        return e;
    }

    public void addSection(MySection e)
    {
        getSections().add(e);
    }

    public boolean removeSection(MySection e)
    {
        return getSections().remove(e);
    }

    public boolean removeSectionUid(String myUid)
    {
        MySection e = findSectionUid(myUid);
        if ( e == null )
            return false;

        return removeSection(e);
    }

    public MySection findSectionUid(String myUid)
    {
        for ( MySection e : getBaseSections() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearSections()
    {
        getSections().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyTopic)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyTopic)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyTopic)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyTopic getCopy()
    {
        return (MyTopic)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        project = null;

        List<MySection> old_sections = sections;
        sections = new ArrayList<>();
        for ( MySection e : old_sections )
            addSection(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyTopicBase) )
            return false;

        MyTopicBase e = (MyTopicBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyTopic e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyTopic e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyTopic e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyTopic e)
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

        if ( p.hasKey("name") )
            setName(p.getString("name"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasName() )
            p.setString("name", getName());

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
        sb.append("MyTopic");
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
        System.out.println("    Name = " + name);
        System.out.println("    LockVersion = " + lockVersion);
    }
}
