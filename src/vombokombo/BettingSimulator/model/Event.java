package vombokombo.BettingSimulator.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vombokombo.BettingSimulator.util.TimeStamp;

public class Event {

    private StringProperty timeStamp;
    private StringProperty event;
    private EventType type;

    public Event(int timeSeconds, String event, EventType type) {
        this.timeStamp = new SimpleStringProperty(TimeStamp.convert(timeSeconds));
        this.event = new SimpleStringProperty(event);
        this.type = type;
    }

    public Event() {
        this(0, "empty", EventType.UNKNOWN);
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

    public EventType getType() {
        return type;
    }

    public enum EventType {
        GOAL_A, GOAL_B, UNKNOWN
    }
}
