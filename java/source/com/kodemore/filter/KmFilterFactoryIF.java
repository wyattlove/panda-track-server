package com.kodemore.filter;

public interface KmFilterFactoryIF<T>
{
    KmFilterIF<T> createFilter();
}
