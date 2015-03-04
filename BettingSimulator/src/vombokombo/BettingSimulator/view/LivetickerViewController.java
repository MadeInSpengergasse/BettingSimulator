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
		System.exit(1);
	}

	@FXML
	public void skipButton() {
		time.setText("hi");
	}

	@FXML
	public void startButton() {
		if (counter == null) {
			System.out.println("start");
			counter = new Counter(time);
			System.out.println("teststart");
		}
	}
	
	@FXML
	public void stop_resumeButton(){
		counter.stopResume();
	}
}
