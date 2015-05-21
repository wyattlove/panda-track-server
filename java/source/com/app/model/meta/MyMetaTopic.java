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

public class MyMetaTopic
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaTopic instance = new MyMetaTopic();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaTopic()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "topic";
    }

    public static MyTopicValidator getValidator()
    {
        return MyTopicValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Information is organized into topics within a project.\nEach topic may contain multiple sections.\nA topic is similar to a document.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaTopic_Uid Uid = new MyMetaTopic_Uid();
    public static final MyMetaTopic_Name Name = new MyMetaTopic_Name();
    public static final MyMetaTopic_LockVersion LockVersion = new MyMetaTopic_LockVersion();
    public static final MyMetaTopic_ProjectName ProjectName = new MyMetaTopic_ProjectName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaTopic_Project Project = new MyMetaTopic_Project();
}
