package vombokombo.BettingSimulator.util;

import java.text.NumberFormat;

public class TimeStamp {

    public static String convert(int totalSeconds) {
        final int MINUTES_IN_AN_HOUR = 60;
        final int SECONDS_IN_A_MINUTE = 60;
        int seconds = totalSeconds % SECONDS_IN_A_MINUTE;
        int totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        int minutes = totalMinutes % MINUTES_IN_AN_HOUR;
        int hours = totalMinutes / MINUTES_IN_AN_HOUR;

        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setMinimumIntegerDigits(2);
        nf.setGroupingUsed(false);

        return nf.format(hours) + ":" + nf.format(minutes) + ":" + nf.format(seconds);
    }


}
