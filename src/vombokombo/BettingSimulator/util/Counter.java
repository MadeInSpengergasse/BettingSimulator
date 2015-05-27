package vombokombo.BettingSimulator.util;

import javafx.scene.control.Label;
import org.reactfx.util.FxTimer;
import org.reactfx.util.Timer;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.controller.LivetickerViewController;

import java.time.Duration;

public class Counter {
    Timer timer;
    /**
     * false = stopped
     * true = running
     */
    private boolean status;
    private int endMinutes;
    private int timeSeconds;

    private int oddsA;

    private Label timeLabel;

    private LivetickerViewController controller;

    private MainApp mainapp;

    /**
     * Initializes the counter with the provided values
     *
     * @param timeLabelP reference the the label to change (timelabel)
     * @param delay      the delay between the cicles = speed
     * @param controller a reference to the controller
     * @param endMinutes after how many minutes the match should end = when the endofmatchview opens
     * @param mainapp    reference to the main app
     * @param oddsA      the odds of team A
     */
    public Counter(Label timeLabelP, int delay,
                   LivetickerViewController controller, int endMinutes, MainApp mainapp, int oddsA) {
        this.oddsA = oddsA;
        this.timeLabel = timeLabelP;
        this.endMinutes = endMinutes;
        this.mainapp = mainapp;

        timer = FxTimer.runPeriodically(Duration.ofMillis(delay), () -> scheduledTask());

        status = true;

        this.controller = controller;
    }

    /**
     * runs at every cicle of the timer (configureable with the delay)
     */
    public void scheduledTask() {
        timeSeconds++;
        timeLabel.setText(TimeStamp.convert(timeSeconds));
        if (timeSeconds % 30 == 0) {
            controller.addEvent(EventHelper.generateEvent(controller.getTeamNameA(), controller.getTeamNameB(), oddsA, getTimeSeconds()));
        }
        if (TimeStamp.getTotalMinutes(timeSeconds) >= endMinutes) {
            controller.handleEndOfMatch();
            timer.stop();
        }
//        System.out.println(timeSeconds);
    }

    /**
     * gets called when the user clicks the stop/resume button
     */
    public void stopResume() {
        if (!status) {
            System.out.println("Timer stopped, now started!");
            timer.restart();
            status = true;
        } else {
            System.out.println("Timer started, now stopped!");
            timer.stop();
            status = false;
        }
    }

    /**
     * @return the total seconds
     */
    public int getTimeSeconds() {
        return timeSeconds;
    }


}
