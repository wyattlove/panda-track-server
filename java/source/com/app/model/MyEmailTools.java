package com.app.model;

import com.app.model.base.MyEmailToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyEmailTools
    extends MyEmailToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEmailTools instance = new MyEmailTools();

    //##################################################
    //# constructor
    //##################################################

    private MyEmailTools()
    {
        // singleton
    }
}
