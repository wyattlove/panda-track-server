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
import com.kodemore.meta.*;
import com.kodemore.match.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaAction_Owner
    extends KmMetaDaoAssociation<MyAction,MyUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "owner";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyUser getValueFor(MyAction model)
    {
        return model.getOwner();
    }
    
    @Override
    public void setValueFor(MyAction model, MyUser value)
    {
        model.setOwner(value);
    }
    
    @Override
    public boolean hasValueFor(MyAction model, MyUser value)
    {
        return model.hasOwner(value);
    }
}
