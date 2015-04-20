package com.app.ui.servlet;

import com.kodemore.json.KmJsonMap;
import com.kodemore.utility.Kmu;

public class MyApiUtility
{
    public static KmJsonMap newOkResponse()
    {
        KmJsonMap res;
        res = new KmJsonMap();
        res.setTrue("ok");
        return res;
    }

    public static KmJsonMap newErrorResponse(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);

        KmJsonMap res;
        res = new KmJsonMap();
        res.setFalse("ok");
        res.setString("message", s);
        return res;
    }
}
