package vombokombo.BettingSimulator.util;

import javafx.scene.control.Label;
import org.reactfx.util.FxTimer;
import org.reactfx.util.Timer;
import vombokombo.BettingSimulator.controller.LivetickerViewController;

import java.time.Duration;

public class Counter {
    private final Timer timer;
    private final int endMinutes;
    private final int oddsA;
    private final Label timeLabel;
    private final LivetickerViewController controller;
    /**
     * false = stopped
     * true = running
     */
    private boolean status;
    private int timeSeconds;

    /**
     * Initializes the counter with the provided values
     *
     * @param timeLabelP reference the the label to change (timelabel)
     * @param delay      the delay between the cicles = speed
     * @param controller a reference to the controller
     * @param endMinutes after how many minutes the match should end = when the endofmatchview opens
     * @param oddsA      the odds of team A
     */
    public Counter(Label timeLabelP, int delay,
                   LivetickerViewController controller, int endMinutes, int oddsA) {
        this.oddsA = oddsA;
        this.timeLabel = timeLabelP;
        this.endMinutes = endMinutes;

        timer = FxTimer.runPeriodically(Duration.ofMillis(delay), this::scheduledTask);

        status = true;

        this.controller = controller;
    }

    /**
     * runs at every cicle of the timer (configureable with the delay)
     */
    private void scheduledTask() {
        timeSeconds++;
        timeLabel.setText(TimeStamp.convert(timeSeconds));
        if (timeSeconds % 30 == 0) {
            controller.addEvent(EventHelper.generateEvent(controller.getTeamNameA(), controller.getTeamNameB(), oddsA, getTimeSeconds()));
        }
        if (TimeStamp.getTotalMinutes(timeSeconds) >= endMinutes) {
            controller.handleEndOfMatch();
            timer.stop();
        }
    }

    /**
     * gets called when the user clicks the stop/resume button
     */
    public void stopResume() {
        if (!status) {
            timer.restart();
            status = true;
        } else {
            timer.stop();
            status = false;
        }
    }

    /**
     * @return the total seconds
     */
    private int getTimeSeconds() {
        return timeSeconds;
    }


}
