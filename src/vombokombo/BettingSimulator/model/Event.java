package vombokombo.BettingSimulator.model;

import vombokombo.BettingSimulator.util.TimeStamp;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Event {

    public enum EventType {
        GOAL, UNKNOWN
    }

    private final StringProperty timeStamp;
    private final StringProperty event;
    private final EventType type;

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
}
