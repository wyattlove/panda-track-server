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

public class MyMetaServerSession_LastTouchedUtcTs
    extends KmMetaTimestampProperty<MyServerSession>
    implements KmMetaDaoPropertyIF<MyServerSession,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchedUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Last Touched Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The date and time when the session was last touched. Used to support automatic timeouts.";
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
        return MyServerSessionValidator.instance.getLastTouchedUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "lastTouchedUtcTs";
    }

    @Override
    public MyServerSessionDao getDao()
    {
        return getAccess().getServerSessionDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyServerSession model)
    {
        return model.getLastTouchedUtcTs();
    }
    
    @Override
    public void setValueFor(MyServerSession model, KmTimestamp value)
    {
        model.setLastTouchedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, KmTimestamp value)
    {
        return model.hasLastTouchedUtcTs(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
