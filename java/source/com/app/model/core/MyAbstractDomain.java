package com.app.model.core;

import java.io.Serializable;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmCodedEnumIF;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.KmCopyIF;
import com.kodemore.utility.KmReadOnlyException;
import com.kodemore.utility.KmReadOnlyIF;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.dao.core.MyDaoSession;
import com.app.dao.core.MyDaoSessionCache;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

public abstract class MyAbstractDomain
    implements KmConstantsIF, KmReadOnlyIF, KmCopyIF, Serializable, Cloneable
{
    //##################################################
    //# variables
    //##################################################

    private boolean _readOnly;

    //##################################################
    //# read only
    //##################################################

    @Override
    public boolean isReadOnly()
    {
        return _readOnly;
    }

    @Override
    public void setReadOnly(boolean e)
    {
        _readOnly = e;
    }

    public void checkReadOnly()
    {
        if ( _readOnly )
            throw new KmReadOnlyException(this);
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract void validate();

    public abstract void validateWarn();

    //##################################################
    //# support
    //##################################################

    protected KmTimestamp getNowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    protected KmDate getTodayUtc()
    {
        return getNowUtc().getDate();
    }

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected String newUid()
    {
        return Kmu.newUid();
    }

    //##################################################
    //# copy
    //##################################################

    /**
     * This method should be overridden by subclasses, but only
     * to specialize the return type.
     */
    @Override
    public MyAbstractDomain getCopy()
    {
        MyAbstractDomain e = getShallowCopy();
        e.postCopy();
        return e;
    }

    public MyAbstractDomain getShallowCopy()
    {
        try
        {
            return (MyAbstractDomain)clone();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * This method is responsible for any changes that need to be
     * made after the shallow copy, in order to guarantee a copy
     * that is independent of the original.  Typically, copies
     * of mutable instance variables will be made here.  All
     * subclasses should call super.postCopy().
     */
    protected void postCopy()
    {
        setReadOnly(false);
    }

    /**
     * Copy an instance of KmCopyIF, checking for null.
     */
    public <T extends KmCopyIF> T copy(T e)
    {
        return Kmu.copy(e);
    }

    //##################################################
    //# dao session
    //##################################################

    protected MyDaoSession getDaoSession()
    {
        return MyGlobals.getDaoSession();
    }

    protected MyDaoSessionCache getDaoCache()
    {
        return getDaoSession().getCache();
    }

    protected MyDaoRegistry getDaoRegistry()
    {
        return MyDaoRegistry.getInstance();
    }

    /**
     * Attach the object to hibernate for subsequent persistence.
     * Once attached, hibernate will take care of automatically saving
     * the object to the database when necessary.
     *
     * This only needs to be called once for any given object.  Thereafter,
     * hibernate will persist any changes automatically.  You should not need to
     * call this every time you modify the object, and doing do is misleading.
     *
     * The standard domain validation is run before attaching the instance to
     * hibernate.
     */
    public void attachDao()
    {
        attachDao(true);
    }

    /**
     * Attach the instance to hibernate, optionally disabling normal validation.
     */
    public void attachDao(boolean validate)
    {
        if ( validate )
            validate();

        getDaoSession().save(this);
    }

    /**
     * Use attachDao instead.
     */
    @Deprecated
    public void saveDao()
    {
        attachDao();
    }

    /**
     * Use attachDao instead.
     */
    @Deprecated
    public void saveDao(boolean validate)
    {
        attachDao(validate);
    }

    public void deleteDao()
    {
        getDaoSession().delete(this);
    }

    //##################################################
    //# convenience
    //##################################################

    protected String getCodeFor(KmCodedEnumIF e)
    {
        return e == null
            ? null
            : e.getCode();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
