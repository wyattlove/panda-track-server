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

public class MyMetaAction
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAction instance = new MyMetaAction();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAction()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "action";
    }

    public static MyActionValidator getValidator()
    {
        return MyActionValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Each action is assigned to a single person for a\nsingle purpose.  Each action has a relatively short\ntitle, and support for a longer free form description\nwhen needed.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAction_Uid Uid = new MyMetaAction_Uid();
    public static final MyMetaAction_Title Title = new MyMetaAction_Title();
    public static final MyMetaAction_Description Description = new MyMetaAction_Description();
    public static final MyMetaAction_TypeCode TypeCode = new MyMetaAction_TypeCode();
    public static final MyMetaAction_LockVersion LockVersion = new MyMetaAction_LockVersion();
    public static final MyMetaAction_TypeName TypeName = new MyMetaAction_TypeName();
    public static final MyMetaAction_SectionName SectionName = new MyMetaAction_SectionName();
    public static final MyMetaAction_OwnerUid OwnerUid = new MyMetaAction_OwnerUid();
    public static final MyMetaAction_OwnerName OwnerName = new MyMetaAction_OwnerName();
    public static final MyMetaAction_AssigneeUid AssigneeUid = new MyMetaAction_AssigneeUid();
    public static final MyMetaAction_AssigneeName AssigneeName = new MyMetaAction_AssigneeName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAction_Section Section = new MyMetaAction_Section();
    public static final MyMetaAction_Owner Owner = new MyMetaAction_Owner();
    public static final MyMetaAction_Assignee Assignee = new MyMetaAction_Assignee();
}
