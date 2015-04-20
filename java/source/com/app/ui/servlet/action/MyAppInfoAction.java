package com.app.ui.servlet.action;

import com.kodemore.json.KmJsonMap;

import com.app.utility.MyConstantsIF;

public class MyAppInfoAction
    extends MyAction
{
    //##################################################
    //# setup
    //##################################################

    @Override
    public String getKey()
    {
        return "appInfo";
    }

    @Override
    protected boolean autoDao()
    {
        return false;
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    public KmJsonMap handle(KmJsonMap req)
    {
        KmJsonMap res;
        res = newOkResponse();
        res.setString("name", MyConstantsIF.APPLICATION_NAME);
        res.setString("version", MyConstantsIF.APPLICATION_VERSION);
        return res;
    }

}
