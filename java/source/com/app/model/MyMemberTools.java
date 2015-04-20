package com.app.model;

import com.app.model.base.MyMemberToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyMemberTools
    extends MyMemberToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMemberTools instance = new MyMemberTools();

    //##################################################
    //# constructor
    //##################################################

    private MyMemberTools()
    {
        // singleton
    }

}
