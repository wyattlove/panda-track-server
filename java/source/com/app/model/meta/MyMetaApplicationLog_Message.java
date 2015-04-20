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

public class MyMetaApplicationLog_Message
    extends KmMetaStringProperty<MyApplicationLog>
    implements KmMetaDaoPropertyIF<MyApplicationLog,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "message";
    }

    @Override
    public String getLabel()
    {
        return "Message";
    }

    @Override
    public String getHelp()
    {
        return "The plain text message describing the log event.";
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

    @Override
    public KmStringValidator getValidator()
    {
        return MyApplicationLogValidator.instance.getMessageValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "message";
    }

    @Override
    public MyApplicationLogDao getDao()
    {
        return getAccess().getApplicationLogDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyApplicationLog model)
    {
        return model.getMessage();
    }
    
    @Override
    public void setValueFor(MyApplicationLog model, String value)
    {
        model.setMessage(value);
    }
    
    @Override
    public boolean hasValueFor(MyApplicationLog model, String value)
    {
        return model.hasMessage(value);
    }
    
    @Override
    public int compareValues(MyApplicationLog o1, MyApplicationLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
