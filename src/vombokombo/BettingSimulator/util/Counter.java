package vombokombo.BettingSimulator.util;

import javafx.scene.control.Label;
import org.reactfx.util.FxTimer;
import org.reactfx.util.Timer;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.view.LivetickerViewController;

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

    public int getTimeSeconds() {
        return timeSeconds;
    }


}
