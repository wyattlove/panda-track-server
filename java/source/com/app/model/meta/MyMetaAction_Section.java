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

public class MyMetaAction_Section
    extends KmMetaDaoAssociation<MyAction,MySection>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "section";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MySection getValueFor(MyAction model)
    {
        return model.getSection();
    }
    
    @Override
    public void setValueFor(MyAction model, MySection value)
    {
        model.setSection(value);
    }
    
    @Override
    public boolean hasValueFor(MyAction model, MySection value)
    {
        return model.hasSection(value);
    }
}
