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

public class MyMetaSection_Topic
    extends KmMetaDaoAssociation<MySection,MyTopic>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "topic";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyTopic getValueFor(MySection model)
    {
        return model.getTopic();
    }
    
    @Override
    public void setValueFor(MySection model, MyTopic value)
    {
        model.setTopic(value);
    }
    
    @Override
    public boolean hasValueFor(MySection model, MyTopic value)
    {
        return model.hasTopic(value);
    }
}
