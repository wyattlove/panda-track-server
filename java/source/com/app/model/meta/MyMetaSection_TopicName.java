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

public class MyMetaSection_TopicName
    extends KmMetaStringProperty<MySection>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "topicName";
    }

    @Override
    public String getLabel()
    {
        return "Topic Name";
    }

    @Override
    public String getHelp()
    {
        return "The display name.";
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

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MySection model)
    {
        return model.getTopicName();
    }
    
    @Override
    public void setValueFor(MySection model, String value)
    {
        model.setTopicName(value);
    }
    
    @Override
    public boolean hasValueFor(MySection model, String value)
    {
        return model.hasTopicName(value);
    }
    
    @Override
    public int compareValues(MySection o1, MySection o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
}
