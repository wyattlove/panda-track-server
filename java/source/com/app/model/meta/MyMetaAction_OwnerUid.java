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

public class MyMetaAction_OwnerUid
    extends KmMetaStringProperty<MyAction>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "ownerUid";
    }

    @Override
    public String getLabel()
    {
        return "Owner Uid";
    }

    @Override
    public String getHelp()
    {
        return "The global unique key.  This is a big ugly number and is usually not displayed.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAction model)
    {
        return model.getOwnerUid();
    }
    
    @Override
    public void setValueFor(MyAction model, String value)
    {
        model.setOwnerUid(value);
    }
    
    @Override
    public boolean hasValueFor(MyAction model, String value)
    {
        return model.hasOwnerUid(value);
    }
    
    @Override
    public int compareValues(MyAction o1, MyAction o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
