//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.model.meta;

import java.util.*;

import com.kodemore.adaptor.*;
import com.kodemore.collection.*;
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
import com.kodemore.meta.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaEmail_RecipientSummary
    extends KmMetaStringProperty<MyEmail>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "recipientSummary";
    }

    @Override
    public String getLabel()
    {
        return "Recipient Summary";
    }

    @Override
    public String getHelp()
    {
        return "A summary of the recipients.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return false;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyEmail model)
    {
        return model.getRecipientSummary();
    }
    
    @Override
    public boolean hasValueFor(MyEmail model, String value)
    {
        return model.hasRecipientSummary(value);
    }
    
    @Override
    public int compareValues(MyEmail o1, MyEmail o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
