//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.model;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

public enum MyActionType
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Alert("A", "Alert"),
    Comment("C", "Comment"),
    Fyi("F", "Fyi"),
    Notify("N", "Notify"),
    Question("Q", "Question"),
    Task("T", "Task"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyActionType> _values;
    private static final KmMap<String,MyActionType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyActionType e : EnumSet.allOf(MyActionType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyActionType> getValues()
    {
        return _values;
    }

    public static MyActionType findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _name;

    //##################################################
    //# constructor
    //##################################################

    private MyActionType(String code, String name)
    {
        _code = code;
        _name = name;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getCode()
    {
        return _code;
    }

    @Override
    public String getName()
    {
        return _name;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isAlert()
    {
        return this == Alert;
    }

    public boolean isComment()
    {
        return this == Comment;
    }

    public boolean isFyi()
    {
        return this == Fyi;
    }

    public boolean isNotify()
    {
        return this == Notify;
    }

    public boolean isQuestion()
    {
        return this == Question;
    }

    public boolean isTask()
    {
        return this == Task;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyActionType getAt(int index)
    {
        return values()[index];
    }

    public static MyActionType getFirst()
    {
        return values()[0];
    }

    public static MyActionType getLast()
    {
        return values()[values().length - 1];
    }

    public MyActionType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyActionType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
