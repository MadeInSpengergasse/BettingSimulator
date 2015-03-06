package vombokombo.BettingSimulator.model;

import vombokombo.BettingSimulator.util.TimeStamp;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Event {
	
	private final StringProperty timeStamp;
	private final StringProperty event;
	
	public Event(int timeSeconds, String event){
		this.timeStamp = new SimpleStringProperty(TimeStamp.convert(timeSeconds));
		this.event = new SimpleStringProperty(event);
	}
	
	public Event(){
		this(0, "empty");
	}

	public String getTimeStamp() {
		return timeStamp.get();
	}

	public String getEvent() {
		return event.get();
	}
	
	public StringProperty getTimeStampProperty(){
		return timeStamp;
	}
	
	public StringProperty getEventProperty(){
		return event;
	}
}
