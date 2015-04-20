package com.kodemore.command;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class KmDao
{
    public static void run(Runnable fn)
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                fn.run();
            }
        }.run();
    }

    public static <T> void run(Consumer<T> fn, T arg)
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                fn.accept(arg);
            }
        }.run();
    }

    public static <R> R fetch(Supplier<R> fn)
    {
        return new KmDaoResultCommand<R>()
        {
            @Override
            protected R handleResult()
            {
                return fn.get();
            }
        }.runResult();
    }

    public static <T, R> R fetch(Function<T,R> fn, T arg)
    {
        return new KmDaoResultCommand<R>()
        {
            @Override
            protected R handleResult()
            {
                return fn.apply(arg);
            }
        }.runResult();
    }

}
