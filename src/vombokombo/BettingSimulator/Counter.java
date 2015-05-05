package vombokombo.BettingSimulator;

import java.time.Duration;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.reactfx.util.Timer;
import org.reactfx.util.FxTimer;

import vombokombo.BettingSimulator.util.EventHelper;
import vombokombo.BettingSimulator.util.TimeStamp;
import vombokombo.BettingSimulator.view.LivetickerViewController;
import javafx.scene.control.Label;

import javax.swing.*;

public class Counter {
    private boolean status; // false == stopped, true == running

    private int endMinutes;

    Timer timer;

    private int timeSeconds;

    private Label timeLabel;

    private LivetickerViewController controller;

    private MainApp mainapp;

    public Counter(Label timeLabelP, int delay,
                   LivetickerViewController controller, int endMinutes, MainApp mainapp) {

        this.timeLabel = timeLabelP;
        this.endMinutes = endMinutes;
        this.mainapp = mainapp;

        timer = FxTimer.runPeriodically(Duration.ofMillis(delay),
                () -> scheduledTask());

        status = true;

        this.controller = controller;
    }

    public void scheduledTask() {
        timeSeconds++;
        timeLabel.setText(TimeStamp.convert(timeSeconds));
//        if (timeSeconds % 60 == 0) {
            controller.addEvent(EventHelper.generateEvent("Team A", "Team B", getTimeSeconds()));
//        }
        if(TimeStamp.getMinutes(timeSeconds) >= endMinutes){
            handleEndOfMatch();
        }
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

    public void handleEndOfMatch(){
        timer.stop();
        ((Stage) controller.getTimeLabel().getScene().getWindow()).close();
        Platform.runLater(() -> {
            mainapp.showEndOfMatchView(true, 100);
        });
    }

}
