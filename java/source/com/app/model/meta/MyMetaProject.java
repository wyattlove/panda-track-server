//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.model.meta;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaProject
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaProject instance = new MyMetaProject();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaProject()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "project";
    }

    public static MyProjectValidator getValidator()
    {
        return MyProjectValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Almost everything is managed within the context of a project.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaProject_Uid Uid = new MyMetaProject_Uid();
    public static final MyMetaProject_Name Name = new MyMetaProject_Name();
    public static final MyMetaProject_LockVersion LockVersion = new MyMetaProject_LockVersion();

    //##################################################
    //# associations
    //##################################################

}
