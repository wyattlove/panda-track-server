package com.kodemore.meta;

import com.kodemore.comparator.KmComparator;
import com.kodemore.validator.KmValidator;

public abstract class KmMetaProperty<T, V>
    extends KmMetaAttribute<T,V>
{
    //##################################################
    //# attributes
    //##################################################

    public abstract String getLabel();

    public abstract String getHelp();

    public abstract boolean isEditable();

    public abstract int getColumnWidth();

    //##################################################
    //# validator
    //##################################################

    public abstract KmValidator<V> getValidator();

    public boolean hasValidator()
    {
        return getValidator() != null;
    }

    //##################################################
    //# compare
    //##################################################

    public KmComparator<T> getComparator()
    {
        return new KmComparator<T>()
        {
            @Override
            public int compare(T o1, T o2)
            {
                return compareValues(o1, o2, getNullsOnTop());
            }
        };
    }

    //##################################################
    //# value
    //##################################################

    public abstract int compareValues(T o1, T o2, boolean nullsOnTop);
}
