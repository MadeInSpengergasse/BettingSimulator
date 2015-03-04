package vombokombo.BettingSimulator.view;

import vombokombo.BettingSimulator.Counter;
import vombokombo.BettingSimulator.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;

public class LivetickerViewController {

	Counter counter;

	@FXML
	private TextArea teamA;
	@FXML
	private TextArea teamB;

	@FXML
	private Label time;

	@FXML
	private TableColumn<String, String> timeStamp;

	@FXML
	private TableColumn<String, String> event;

	private MainApp mainApp;

	public LivetickerViewController() {
	}

	@FXML
	private void initialize() {

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	public void closeButton() {
		System.exit(0);
	}

	@FXML
	public void skipButton() {
		time.setText("SKIP!!");
		System.out.println("Skip Button");
	}

	@FXML
	public void startButton() {
		System.out.println("Start Button");
		if (counter == null) {
			System.out.println("Real Start");
			counter = new Counter(time, 1000);
		}
	}
	
	@FXML
	public void stop_resumeButton(){
		counter.stopResume();
		System.out.println("StopResume Button");
	}
	
	@FXML
	public void forwardButton(){
		System.out.println("Forward Button");
	}
}
