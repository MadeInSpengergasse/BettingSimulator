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

    /**
     * Constructor
     */
    public Event() {
        this(0, "empty", EventType.UNKNOWN);
    }

    /**
     * Get-method for timeStamp
     *
     * @return timeStamp.get
     */
    public String getTimeStamp() {
        return timeStamp.get();
    }

    /**
     * Get-method for event
     * @return event.get
     */
    public String getEvent() {
        return event.get();
    }

    /**
     * Get-method for the timeStamp property
     * @return timeStamp
     */
    public StringProperty getTimeStampProperty() {
        return timeStamp;
    }

    /**
     * Get-method for the event property
     * @return event
     */
    public StringProperty getEventProperty() {
        return event;
    }

    /**
     * Get-method for type
     * @return type
     */
    public EventType getType() {
        return type;
    }

    /**
     * Enums
     */
    public enum EventType {
        GOAL_A, GOAL_B, UNKNOWN
    }
}
