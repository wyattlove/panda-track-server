package com.app.utility;

import com.kodemore.utility.KmRandom;
import com.kodemore.utility.KmSha1;
import com.kodemore.utility.Kmu;

import com.app.property.MyPropertyRegistry;

public class MyUtility
{
    //##################################################
    //# support
    //##################################################

    /**
     * Use SHA-1 to create a password hash.
     * The results will be exactly 40 characters.
     * If password is null (or empty string), then return null.
     */
    public static String getPasswordHash(String salt, String password)
    {
        String appSalt = MyConstantsIF.APPLICATION_SHA_SALT;

        if ( Kmu.isEmpty(password) )
            return null;

        return KmSha1.hash(appSalt, salt, password);
    }

    //##################################################
    //# misc
    //##################################################

    public static String getRandomPassword()
    {
        KmRandom r = KmRandom.getInstance();

        String letters = r.getSafeString(8).toLowerCase();
        String digits = r.getDigits(3);
        return letters + digits;
    }

    /**
     * Format a integer in a format that is semi-random,
     * but still guaranteed to be unique.  That is, the
     * value returned for given i, is guaranteed to never
     * be the same as a value returned by a different i.
     *
     * However, the value returned by i is not guaranteed
     * to be the same each time this is called.
     *
     * The intent is to use this for things like order
     * confirmation numbers, where we want to avoid the
     * appears of sequentially generated values, but need
     * to ensure that each value is unique.  We also want
     * to ensure that the next numbers are not readily
     * guessable, even if a person knows the previous values
     * in the sequence.
     */
    public static String formatConfirmationNumber20(int i)
    {
        KmRandom r = new KmRandom();

        String body = "" + i + r.getDigit();
        int rot = r.getInteger(9) + 1;
        String rotated = Kmu.rotate(body, rot);
        String full = "" + rot + rotated;
        long ii = Kmu.parseLong(full);
        return Kmu.formatBase20(ii);
    }

    public static String formatConfirmationNumber10(int i)
    {
        KmRandom r = new KmRandom();

        String body = "" + i + r.getDigit();
        int rot = r.getInteger(9) + 1;
        String rotated = Kmu.rotate(body, rot);
        String full = "" + rot + rotated;
        long ii = Kmu.parseLong(full);
        return ii + "";
    }

    public static boolean isMaintenancePeriod()
    {
        int hour = MyGlobals.getNowUtc().getHour();

        MyPropertyRegistry p = MyGlobals.getProperties();
        int start = p.getMaintenancePeriodStartHour();
        int end = p.getMaintenancePeriodEndHour();

        if ( start <= end )
            return hour >= start && hour <= end;

        return hour >= start || hour <= end;
    }
}
