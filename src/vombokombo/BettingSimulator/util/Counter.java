package vombokombo.BettingSimulator.util;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.reactfx.util.FxTimer;
import org.reactfx.util.Timer;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.view.LivetickerViewController;

import java.time.Duration;

public class Counter {
    Timer timer;
    private boolean status; // false == stopped, true == running
    private int endMinutes;
    private int timeSeconds;

    private Label timeLabel;

    private LivetickerViewController controller;

    private MainApp mainapp;

    public Counter(Label timeLabelP, int delay,
                   LivetickerViewController controller, int endMinutes, MainApp mainapp) {

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
            controller.addEvent(EventHelper.generateEvent("Team A", "Team B", getTimeSeconds()));
        }
        if (TimeStamp.getTotalMinutes(timeSeconds) >= endMinutes) {
            handleEndOfMatch();
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

    public void handleEndOfMatch() {
        timer.stop();
        ((Stage) controller.getTimeLabel().getScene().getWindow()).close();
        Platform.runLater(() -> {
            mainapp.showEndOfMatchView(true, 100);
        });
    }

}
