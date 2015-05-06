package vombokombo.BettingSimulator.util;

import java.text.NumberFormat;

public class TimeStamp {

    public static final int MINUTES_IN_AN_HOUR = 60;
    public static final int SECONDS_IN_A_MINUTE = 60;


    public static String convert(int totalSeconds) {


        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setMinimumIntegerDigits(2);
        nf.setGroupingUsed(false);

        return nf.format(getHours(totalSeconds)) + ":" + nf.format(getMinutes(totalSeconds)) + ":" + nf.format(getSeconds(totalSeconds));
    }

    public static int getSeconds(int totalSeconds) {
        return totalSeconds % SECONDS_IN_A_MINUTE;
    }

    public static int getMinutes(int totalSeconds) {
        int totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        return totalMinutes % MINUTES_IN_AN_HOUR;
    }

    public static int getHours(int totalSeconds) {
        return getMinutes(totalSeconds) / MINUTES_IN_AN_HOUR;
    }


}
