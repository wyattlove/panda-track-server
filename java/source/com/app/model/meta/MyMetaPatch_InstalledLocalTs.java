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

public class MyMetaPatch_InstalledLocalTs
    extends KmMetaTimestampProperty<MyPatch>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "installedLocalTs";
    }

    @Override
    public String getLabel()
    {
        return "Installed";
    }

    @Override
    public String getHelp()
    {
        return "The date and time when the patch was installed in this database.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 16;
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
    public KmTimestamp getValueFor(MyPatch model)
    {
        return model.getInstalledLocalTs();
    }
    
    @Override
    public boolean hasValueFor(MyPatch model, KmTimestamp value)
    {
        return model.hasInstalledLocalTs(value);
    }
    
    @Override
    public int compareValues(MyPatch o1, MyPatch o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
