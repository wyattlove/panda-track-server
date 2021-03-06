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

public class MyMetaApplicationLogTrace_Id
    extends KmMetaIntegerProperty<MyApplicationLogTrace>
    implements KmMetaDaoPropertyIF<MyApplicationLogTrace,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "id";
    }

    @Override
    public String getLabel()
    {
        return "Id";
    }

    @Override
    public String getHelp()
    {
        return "The global unique identifier.  This is a big ugly number and is usually not displayed.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 7;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmIntegerValidator getValidator()
    {
        return MyApplicationLogTraceValidator.instance.getIdValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "id";
    }

    @Override
    public MyApplicationLogTraceDao getDao()
    {
        return getAccess().getApplicationLogTraceDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyApplicationLogTrace model)
    {
        return model.getId();
    }
    
    @Override
    public void setValueFor(MyApplicationLogTrace model, Integer value)
    {
        model.setId(value);
    }
    
    @Override
    public boolean hasValueFor(MyApplicationLogTrace model, Integer value)
    {
        return model.hasId(value);
    }
    
    @Override
    public int compareValues(MyApplicationLogTrace o1, MyApplicationLogTrace o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
