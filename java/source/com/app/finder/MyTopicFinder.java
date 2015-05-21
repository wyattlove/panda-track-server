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

public class MyTopicFinder
    implements KmKeyFinderIF<MyTopic,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyTopic staticFind(String key)
    {
        return new MyTopicFinder().find(key);
    }

    public static MyTopic staticFindDao(String key)
    {
        return new MyTopicFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyTopic find(String key)
    {
        return new MyTopicDao().findUid(key);
    }

    public MyTopic findDao(String key)
    {
        MyDaoKeyFinder<MyTopic,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
