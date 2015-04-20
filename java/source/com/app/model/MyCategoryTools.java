package com.app.model;

import com.app.model.base.MyCategoryToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyCategoryTools
    extends MyCategoryToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyCategoryTools instance = new MyCategoryTools();

    //##################################################
    //# constructor
    //##################################################

    private MyCategoryTools()
    {
        // singleton
    }

}
