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

public abstract class MySectionBase
    extends MyAbstractDomain
    implements KmSequenceIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaSection Meta = MyMetaSection.instance;
    public static final MySectionTools Tools = MySectionTools.instance;
    public static final MySectionValidator Validator = MySectionValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private Integer sequence;
    private Integer lockVersion;
    private MyTopic topic;
    private List<MyAction> actions;

    //##################################################
    //# constructor
    //##################################################

    public MySectionBase()
    {
        super();
        setUid(newUid());
        actions = new ArrayList<>();
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
    //# field (sequence)
    //##################################################

    @Override
    public Integer getSequence()
    {
        return sequence;
    }

    @Override
    public void setSequence(Integer e)
    {
        checkReadOnly();
        e = Validator.getSequenceValidator().convertOnly(e);
        sequence = e;
    }

    public void clearSequence()
    {
        setSequence(null);
    }

    public boolean hasSequence()
    {
        return getSequence() != null;
    }

    public boolean hasSequence(Integer e)
    {
        return Kmu.isEqual(getSequence(), e);
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
    //# topic
    //##################################################

    public MyTopic getTopic()
    {
        return topic;
    }

    public void setTopic(MyTopic e)
    {
        checkReadOnly();
        topic = e;
    }

    public void _setTopic(MyTopic e)
    {
        checkReadOnly();
        topic = e;
    }

    public void clearTopic()
    {
        setTopic(null);
    }

    public boolean hasTopic()
    {
        return getTopic() != null;
    }

    public boolean hasTopic(MyTopic e)
    {
        return Kmu.isEqual(getTopic(), e);
    }

    public String getTopicName()
    {
        if ( hasTopic() )
            return getTopic().getName();
        return null;
    }

    public void setTopicName(String e)
    {
        getTopic().setName(e);
    }

    public boolean hasTopicName()
    {
        return hasTopic() && getTopic().hasName();
    }

    public boolean hasTopicName(String e)
    {
        return hasTopic() && getTopic().hasName(e);
    }


    //##################################################
    //# Actions (collection)
    //##################################################

    public KmCollection<MyAction> getActions()
    {
        return new KmHibernateCollection<>(
            getBaseActions(),
            (MySection)this,
            MyAction.Meta.Section.getAdaptor());
    }

    public boolean hasActions()
    {
        return !getBaseActions().isEmpty();
    }

    public int getActionCount()
    {
        return getBaseActions().size();
    }

    public List<MyAction> getBaseActions()
    {
        return actions;
    }

    public MyAction addAction()
    {
        MyAction e;
        e = new MyAction();
        getActions().add(e);
        return e;
    }

    public void addAction(MyAction e)
    {
        getActions().add(e);
    }

    public boolean removeAction(MyAction e)
    {
        return getActions().remove(e);
    }

    public boolean removeActionUid(String myUid)
    {
        MyAction e = findActionUid(myUid);
        if ( e == null )
            return false;

        return removeAction(e);
    }

    public MyAction findActionUid(String myUid)
    {
        for ( MyAction e : getBaseActions() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearActions()
    {
        getActions().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MySection)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MySection)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MySection)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MySection getCopy()
    {
        return (MySection)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        topic = null;

        List<MyAction> old_actions = actions;
        actions = new ArrayList<>();
        for ( MyAction e : old_actions )
            addAction(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MySectionBase) )
            return false;

        MySectionBase e = (MySectionBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MySection e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MySection e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getSequence(), e.getSequence()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MySection e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MySection e)
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

        if ( p.hasKey("sequence") )
            setSequence(p.getInteger("sequence"));

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

        if ( hasSequence() )
            p.setInteger("sequence", getSequence());

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
        sb.append("MySection");
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
        System.out.println("    Sequence = " + sequence);
        System.out.println("    LockVersion = " + lockVersion);
    }
}
