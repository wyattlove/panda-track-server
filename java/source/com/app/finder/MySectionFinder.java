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

public class MySectionFinder
    implements KmKeyFinderIF<MySection,String>
{
    //##################################################
    //# static
    //##################################################

    public static MySection staticFind(String key)
    {
        return new MySectionFinder().find(key);
    }

    public static MySection staticFindDao(String key)
    {
        return new MySectionFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySection find(String key)
    {
        return new MySectionDao().findUid(key);
    }

    public MySection findDao(String key)
    {
        MyDaoKeyFinder<MySection,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
