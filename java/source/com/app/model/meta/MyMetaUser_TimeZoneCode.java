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

public class MyMetaUser_TimeZoneCode
    extends KmMetaStringProperty<MyUser>
    implements KmMetaDaoPropertyIF<MyUser,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "timeZoneCode";
    }

    @Override
    public String getLabel()
    {
        return "Time Zone Code";
    }

    @Override
    public String getHelp()
    {
        return "The user's preferred time zone.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 5;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyUserValidator.instance.getTimeZoneCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "timeZoneCode";
    }

    @Override
    public MyUserDao getDao()
    {
        return getAccess().getUserDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyUser model)
    {
        return model.getTimeZoneCode();
    }
    
    @Override
    public void setValueFor(MyUser model, String value)
    {
        model.setTimeZoneCode(value);
    }
    
    @Override
    public boolean hasValueFor(MyUser model, String value)
    {
        return model.hasTimeZoneCode(value);
    }
    
    @Override
    public int compareValues(MyUser o1, MyUser o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
