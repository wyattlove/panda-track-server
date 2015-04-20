package com.app.model;

import com.kodemore.time.KmTimestamp;

import com.app.model.base.MyPasswordResetBase;

public class MyPasswordReset
    extends MyPasswordResetBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyPasswordReset()
    {
        super();

        setExpirationUtcTs(getCreatedUtcTs().addDays(3));
    }

    //##################################################
    //# accessing
    //##################################################

    public void setUser(MyUser u)
    {
        setEmail(u.getEmail());
    }

    public boolean isExpired()
    {
        if ( !hasExpirationUtcTs() )
            return false;

        KmTimestamp expiration = getExpirationUtcTs();
        KmTimestamp now = getNowUtc();

        return now.isAfter(expiration);
    }

    public MyUser findUser()
    {
        return getAccess().getUserDao().findEmail(getEmail());
    }

}
