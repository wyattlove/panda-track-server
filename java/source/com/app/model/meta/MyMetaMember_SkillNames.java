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

public class MyMetaMember_SkillNames
    extends KmMetaStringProperty<MyMember>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "skillNames";
    }

    @Override
    public String getLabel()
    {
        return "Skills";
    }

    @Override
    public String getHelp()
    {
        return "The list of skills assigned to this member.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 20;
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
    public String getValueFor(MyMember model)
    {
        return model.getSkillNames();
    }
    
    @Override
    public boolean hasValueFor(MyMember model, String value)
    {
        return model.hasSkillNames(value);
    }
    
    @Override
    public int compareValues(MyMember o1, MyMember o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
