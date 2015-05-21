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

public class MyMetaSection
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSection instance = new MyMetaSection();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSection()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "section";
    }

    public static MySectionValidator getValidator()
    {
        return MySectionValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Each topic (doc) is organized into a list of sections.\nEach section is composed of a title and body.\nActions are always attached to sections.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaSection_Uid Uid = new MyMetaSection_Uid();
    public static final MyMetaSection_Name Name = new MyMetaSection_Name();
    public static final MyMetaSection_Sequence Sequence = new MyMetaSection_Sequence();
    public static final MyMetaSection_LockVersion LockVersion = new MyMetaSection_LockVersion();
    public static final MyMetaSection_TopicName TopicName = new MyMetaSection_TopicName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaSection_Topic Topic = new MyMetaSection_Topic();
}
