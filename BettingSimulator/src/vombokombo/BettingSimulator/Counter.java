package vombokombo.BettingSimulator;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import org.reactfx.util.FxTimer;

import javafx.scene.control.Label;


public class Counter
{
	Timer timer;

	private int timeSeconds;
	
	private Label timeLabel;

	public Counter(Label timeLabelP)
	{
		this.timeLabel = timeLabelP;
		
		timer = FxTimer.runPeriodically(
		        Duration.ofMillis(1000),
		        () -> scheduledTask());
		
	}
	
	public void 
	
	public void scheduledTask(){
		increaseSecond();
		timeLabel.setText(getTime(timeSeconds));
	}
	
	public void increaseSecond(){
		timeSeconds++;
	}
	
	public String getTime(int totalSeconds){
		
		final int MINUTES_IN_AN_HOUR = 60;
		final int SECONDS_IN_A_MINUTE = 60;
		int seconds = totalSeconds % SECONDS_IN_A_MINUTE;
		int totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
		int minutes = totalMinutes % MINUTES_IN_AN_HOUR;
		int hours = totalMinutes / MINUTES_IN_AN_HOUR;
		
		return hours + ":" + minutes + ":" + seconds;
	}
	
}
