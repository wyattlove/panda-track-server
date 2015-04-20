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

public class MyMetaServerSession_ClosedLocalTime
    extends KmMetaTimeProperty<MyServerSession>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "closedLocalTime";
    }

    @Override
    public String getLabel()
    {
        return "Closed";
    }

    @Override
    public String getHelp()
    {
        return "The date and time when the session was closed.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 10;
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
    public KmTime getValueFor(MyServerSession model)
    {
        return model.getClosedLocalTime();
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, KmTime value)
    {
        return model.hasClosedLocalTime(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
