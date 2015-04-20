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

public class MyMetaInvitation
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaInvitation instance = new MyMetaInvitation();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaInvitation()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "invitation";
    }

    public static MyInvitationValidator getValidator()
    {
        return MyInvitationValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "I coordinate user invitations.  The system generates an invitation, stores the record,\nand sends a corresponding email to the user.  The user can verify/accept the invitation\nby clicking on a hyperlink in the email.  The response is trusted as it includes a\nlarge randomly generated number.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaInvitation_Uid Uid = new MyMetaInvitation_Uid();
    public static final MyMetaInvitation_TypeCode TypeCode = new MyMetaInvitation_TypeCode();
    public static final MyMetaInvitation_StatusCode StatusCode = new MyMetaInvitation_StatusCode();
    public static final MyMetaInvitation_CreatedUtcTs CreatedUtcTs = new MyMetaInvitation_CreatedUtcTs();
    public static final MyMetaInvitation_ClosedUtcTs ClosedUtcTs = new MyMetaInvitation_ClosedUtcTs();
    public static final MyMetaInvitation_ToEmail ToEmail = new MyMetaInvitation_ToEmail();
    public static final MyMetaInvitation_RoleCode RoleCode = new MyMetaInvitation_RoleCode();
    public static final MyMetaInvitation_LockVersion LockVersion = new MyMetaInvitation_LockVersion();
    public static final MyMetaInvitation_TypeName TypeName = new MyMetaInvitation_TypeName();
    public static final MyMetaInvitation_StatusName StatusName = new MyMetaInvitation_StatusName();
    public static final MyMetaInvitation_CreatedLocalTs CreatedLocalTs = new MyMetaInvitation_CreatedLocalTs();
    public static final MyMetaInvitation_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaInvitation_CreatedLocalTsMessage();
    public static final MyMetaInvitation_CreatedLocalDate CreatedLocalDate = new MyMetaInvitation_CreatedLocalDate();
    public static final MyMetaInvitation_CreatedLocalTime CreatedLocalTime = new MyMetaInvitation_CreatedLocalTime();
    public static final MyMetaInvitation_ClosedLocalTs ClosedLocalTs = new MyMetaInvitation_ClosedLocalTs();
    public static final MyMetaInvitation_ClosedLocalTsMessage ClosedLocalTsMessage = new MyMetaInvitation_ClosedLocalTsMessage();
    public static final MyMetaInvitation_ClosedLocalDate ClosedLocalDate = new MyMetaInvitation_ClosedLocalDate();
    public static final MyMetaInvitation_ClosedLocalTime ClosedLocalTime = new MyMetaInvitation_ClosedLocalTime();
    public static final MyMetaInvitation_FromUserName FromUserName = new MyMetaInvitation_FromUserName();
    public static final MyMetaInvitation_ProjectName ProjectName = new MyMetaInvitation_ProjectName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaInvitation_FromUser FromUser = new MyMetaInvitation_FromUser();
    public static final MyMetaInvitation_Project Project = new MyMetaInvitation_Project();
}
