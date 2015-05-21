package com.app.ui.servlet.action;

import com.kodemore.command.KmDao;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.json.KmJsonMap;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyServerSession;
import com.app.ui.core.MyServletData;
import com.app.ui.servlet.MyApiUtility;
import com.app.utility.MyGlobals;

public abstract class MyAction
{
    //##################################################
    //# abstract
    //##################################################

    public abstract String getKey();

    protected abstract KmJsonMap handle(KmJsonMap req);

    //##################################################
    //# run
    //##################################################

    public void run(KmJsonMap req)
    {
        try
        {
            KmJsonMap res = getResponse(req);
            getData().setJsonResult(res);
        }
        catch ( KmApplicationException ex )
        {
            KmJsonMap res = newErrorResponse(ex.getMessage());
            getData().setJsonResult(res);
        }
    }

    private KmJsonMap getResponse(KmJsonMap req)
    {
        if ( autoDao() )
            return KmDao.fetch(this::handle, req);

        return handle(req);
    }

    protected boolean autoDao()
    {
        return true;
    }

    //##################################################
    //# support
    //##################################################

    protected MyServletData getData()
    {
        return MyServletData.getLocal();
    }

    protected KmApplicationException newError(String msg, Object... args)
    {
        return Kmu.newError(msg, args);
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected MyServerSession touchSession(String uid)
    {
        MyServerSession ss = getAccess().getServerSessionDao().findUid(uid);

        if ( ss == null )
            throw newError("Session timeout (none)");

        if ( ss.isStale() )
            throw newError("Session timeout (stale)");

        ss.touch();
        return ss;
    }

    protected KmJsonMap newOkResponse()
    {
        return MyApiUtility.newOkResponse();
    }

    protected KmJsonMap newErrorResponse(String msg, Object... args)
    {
        return MyApiUtility.newErrorResponse(msg, args);
    }

}
