package com.kodemore.json;

public interface KmJsonObjectIF
    extends CharSequence
{
    String formatJson();

    String prettyPrint();

    int size();

    boolean isEmpty();

    boolean isNotEmpty();
}
