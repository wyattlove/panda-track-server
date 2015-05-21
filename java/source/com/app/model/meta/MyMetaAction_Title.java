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

public class MyMetaAction_Title
    extends KmMetaStringProperty<MyAction>
    implements KmMetaDaoPropertyIF<MyAction,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "title";
    }

    @Override
    public String getLabel()
    {
        return "Title";
    }

    @Override
    public String getHelp()
    {
        return "A short single line non-unique description.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyActionValidator.instance.getTitleValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "title";
    }

    @Override
    public MyActionDao getDao()
    {
        return getAccess().getActionDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAction model)
    {
        return model.getTitle();
    }
    
    @Override
    public void setValueFor(MyAction model, String value)
    {
        model.setTitle(value);
    }
    
    @Override
    public boolean hasValueFor(MyAction model, String value)
    {
        return model.hasTitle(value);
    }
    
    @Override
    public int compareValues(MyAction o1, MyAction o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
