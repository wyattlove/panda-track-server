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

public class MyMetaPasswordReset_CreatedUtcTs
    extends KmMetaTimestampProperty<MyPasswordReset>
    implements KmMetaDaoPropertyIF<MyPasswordReset,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Created Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The date and time when this request was created.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 16;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmTimestampValidator getValidator()
    {
        return MyPasswordResetValidator.instance.getCreatedUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "createdUtcTs";
    }

    @Override
    public MyPasswordResetDao getDao()
    {
        return getAccess().getPasswordResetDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyPasswordReset model)
    {
        return model.getCreatedUtcTs();
    }
    
    @Override
    public void setValueFor(MyPasswordReset model, KmTimestamp value)
    {
        model.setCreatedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPasswordReset model, KmTimestamp value)
    {
        return model.hasCreatedUtcTs(value);
    }
    
    @Override
    public int compareValues(MyPasswordReset o1, MyPasswordReset o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
