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

public class MyMetaMember_User
    extends KmMetaDaoAssociation<MyMember,MyUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "user";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyUser getValueFor(MyMember model)
    {
        return model.getUser();
    }
    
    @Override
    public void setValueFor(MyMember model, MyUser value)
    {
        model.setUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyMember model, MyUser value)
    {
        return model.hasUser(value);
    }
}
