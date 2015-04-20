package com.app.model;

import com.app.model.base.MyApplicationLogToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyApplicationLogTools
    extends MyApplicationLogToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyApplicationLogTools instance = new MyApplicationLogTools();

    //##################################################
    //# constructor
    //##################################################

    private MyApplicationLogTools()
    {
        // singleton
    }

}
