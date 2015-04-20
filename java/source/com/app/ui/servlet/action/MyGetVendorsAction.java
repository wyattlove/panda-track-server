package com.app.ui.servlet.action;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;

import com.app.model.MyVendor;

public class MyGetVendorsAction
    extends MyAction
{
    //##################################################
    //# key
    //##################################################

    @Override
    public String getKey()
    {
        return "getVendors";
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    public KmJsonMap handle(KmJsonMap req)
    {
        String sessionUid = req.getString("sessionUid");
        touchSession(sessionUid);

        // remove_wyatt: print
        System.out.println("MyGetVendorsAction.handle");

        KmJsonMap res;
        res = newOkResponse();

        KmJsonArray arr;
        arr = res.setArray("vendors");

        KmList<MyVendor> v = getAccess().getVendorDao().findAll();
        System.out.println("    v.size(): " + v.size());
        for ( MyVendor e : v )
        {
            KmJsonMap map;
            map = arr.addMap();
            map.setString("uid", e.getUid());
            map.setString("name", e.getName());
        }

        return res;
    }

}
