package utils;

import java.util.Date;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

public class TimeUtils {

    public static final long MS_PER_SEC = 1000;

    public static final long SECS_PER_MIN = 60L;
    public static final long SECS_PER_HOUR = 60L * SECS_PER_MIN;
    public static final long SECS_PER_DAY = 24L * SECS_PER_HOUR;
    public static final long SECS_PER_WEEK = 7L * SECS_PER_DAY;
    public static final long SECS_PER_MONTH = 30L * SECS_PER_DAY;
    public static final long SECS_PER_YEAR = 12L * SECS_PER_MONTH;

    public static final long MS_PER_MIN = SECS_PER_MIN * MS_PER_SEC;
    public static final long MS_PER_HOUR = SECS_PER_HOUR * MS_PER_SEC;
    public static final long MS_PER_DAY = SECS_PER_DAY * MS_PER_SEC;
    public static final long MS_PER_MONTH = SECS_PER_MONTH * MS_PER_SEC;
    public static final long MS_PER_YEAR = SECS_PER_YEAR * MS_PER_SEC;

    public static long getCurrentTimeInMilliSec() {
        return new Date().getTime();
    }

    public static long getCurrentTimeInSec() {
        return getCurrentTimeInMilliSec() / MS_PER_SEC;
    }

    public static long getCurrentHour() {
        return getCurrentTimeInMilliSec() / MS_PER_HOUR;
    }

    public static long getPreviousHour() {
        return (getCurrentTimeInMilliSec() - MS_PER_HOUR) / MS_PER_HOUR;
    }
    
    public static String getFormattedSQLDateStrFromDateStr(String dateStr) {
        try {
            return String.valueOf(new java.sql.Date(new ISO8601DateFormat().parse(dateStr).getTime()));
        } catch (Exception ex) {
            // NO-OP
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("CurrentTimeInSecs: " + getCurrentTimeInSec());
        System.out.println("CurrentTimeInMilliSec: " + getCurrentTimeInMilliSec());
        System.out.println("CurrentHour: " + getCurrentHour());
        System.out.println("PreviousHour: " + getPreviousHour());
    }
}
