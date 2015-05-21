//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public class MyActionFinder
    implements KmKeyFinderIF<MyAction,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAction staticFind(String key)
    {
        return new MyActionFinder().find(key);
    }

    public static MyAction staticFindDao(String key)
    {
        return new MyActionFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAction find(String key)
    {
        return new MyActionDao().findUid(key);
    }

    public MyAction findDao(String key)
    {
        MyDaoKeyFinder<MyAction,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
