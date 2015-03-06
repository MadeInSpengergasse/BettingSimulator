package vombokombo.BettingSimulator;

import java.time.Duration;

import org.reactfx.util.Timer;
import org.reactfx.util.FxTimer;

import vombokombo.BettingSimulator.util.TimeStamp;
import javafx.scene.control.Label;


public class Counter
{
	private boolean status; //false == stopped, true == running
	
	Timer timer;

	private int timeSeconds;
	
	private Label timeLabel;

	public Counter(Label timeLabelP, int delay)
	{
		
		this.timeLabel = timeLabelP;
		
		timer = FxTimer.runPeriodically(
		        Duration.ofMillis(delay),
		        () -> scheduledTask());
		
		status = true;
	}
	
	public void scheduledTask(){
		increaseSecond();
		timeLabel.setText(TimeStamp.convert(timeSeconds));
	}
	
	public void increaseSecond(){
		timeSeconds++;
	}
	

	
	public void stopResume(){
		if(status == false){
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
