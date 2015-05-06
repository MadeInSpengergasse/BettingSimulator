package vombokombo.BettingSimulator.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vombokombo.BettingSimulator.util.TimeStamp;

/**
 * Created by luca on 06.05.15.
 */
public class Match {


    private StringProperty timeStamp;
    private StringProperty event;

    public Match(int timeSeconds, String event) {
        this.timeStamp = new SimpleStringProperty(TimeStamp.convert(timeSeconds));
        this.event = new SimpleStringProperty(event);
    }

    public Match() {
        this(0, "empty");
    }

    public String getTimeStamp() {
        return timeStamp.get();
    }

    public String getEvent() {
        return event.get();
    }

    public StringProperty getTimeStampProperty() {
        return timeStamp;
    }

    public StringProperty getEventProperty() {
        return event;
    }

}
