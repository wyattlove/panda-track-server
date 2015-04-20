package com.app.ui.servlet.action;

import java.util.HashMap;
import java.util.Map;

public final class MyActionRegistry
{
    //##################################################
    //# variables
    //##################################################

    private static final Map<String,MyAction> _values = new HashMap<>();

    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        install(new MyAppInfoAction());
        install(new MyLoginAction());
        // todo_wyatt: test error handling
        install(new MyGetVendorsAction());
    }

    private static void install(MyAction e)
    {
        _values.put(e.getKey(), e);
    }

    //##################################################
    //# accessing
    //##################################################

    public static MyAction getAction(String key)
    {
        return _values.get(key);
    }

    //##################################################
    //# constructor
    //##################################################

    private MyActionRegistry()
    {
        // private
    }

}
