package vombokombo.BettingSimulator.util;

import java.text.NumberFormat;

public class TimeStamp {

    private static final int MINUTES_IN_AN_HOUR = 60;
    private static final int SECONDS_IN_A_MINUTE = 60;

    /**
     * Converts the total seconds provided into a human-readable string in the format HH:MM:SS
     *
     * @param totalSeconds the total seconds to convert
     * @return a string in the format HH:MM:SS
     */
    public static String convert(int totalSeconds) {
        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setMinimumIntegerDigits(2);
        nf.setGroupingUsed(false);
        return nf.format(getHours(totalSeconds)) + ":" + nf.format(getMinutes(totalSeconds)) + ":" + nf.format(getSeconds(totalSeconds));
    }

    /**
     * Returns the seconds in the minute without everything else
     *
     * @param totalSeconds the total seconds to convert
     * @return the seconds in the minute
     */
    private static int getSeconds(int totalSeconds) {
        return totalSeconds % SECONDS_IN_A_MINUTE;
    }

    /**
     * Returns the minutes in the hour without everything else
     *
     * @param totalSeconds the total seconds to convert
     * @return the minutes in the hour
     */
    private static int getMinutes(int totalSeconds) {
        int totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        return totalMinutes % MINUTES_IN_AN_HOUR;
    }

    /**
     * Returns the total minutes (without the hour thing) without everything else
     *
     * @param totalSeconds the total seconds to convert
     * @return the minutes (without subtracted hours)
     */
    public static int getTotalMinutes(int totalSeconds) {
        return totalSeconds / SECONDS_IN_A_MINUTE;
    }

    /**
     * Returns the hours without everything else
     *
     * @param totalSeconds the total seconds to convert
     * @return the hours
     */
    private static int getHours(int totalSeconds) {
        return getTotalMinutes(totalSeconds) / MINUTES_IN_AN_HOUR;
    }


}
