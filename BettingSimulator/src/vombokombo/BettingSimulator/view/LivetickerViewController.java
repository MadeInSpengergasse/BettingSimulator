package vombokombo.BettingSimulator.view;

import vombokombo.BettingSimulator.Counter;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.model.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class LivetickerViewController {

	Counter counter;

	@FXML
	private TextArea teamA;
	@FXML
	private TextArea teamB;
	
	@FXML
	private Label scoreTeamA;
	@FXML
	private Label scoreTeamB;

	@FXML
	private Label time;

	@FXML
	private TableView<Event> eventTable;
	
	@FXML
	private TableColumn<Event, String> timeStamp;

	@FXML
	private TableColumn<Event, String> event;

	private MainApp mainApp;
	
	private ObservableList<Event> events;

	public LivetickerViewController() {
		events = FXCollections.observableArrayList();
	}

	@FXML
	private void initialize() {
		event.setCellValueFactory(cellData -> cellData.getValue().getEventProperty());
		timeStamp.setCellValueFactory(cellData -> cellData.getValue().getTimeStampProperty());
		
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		eventTable.setItems(events);
	}

	@FXML
	public void closeButton() {
		((Stage)time.getScene().getWindow()).close();
		//System.exit(0);
	}

	@FXML
	public void skipButton() {
		System.out.println("Skip Button");

		addEvent(counter.getTimeSeconds(), "testevent");

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
	public void stop_resumeButton() {
		counter.stopResume();
		System.out.println("StopResume Button");
	}

	@FXML
	public void forwardButton() {
		System.out.println("Forward Button");
		if (counter == null) {
			counter = new Counter(time, 1);
		}
	}
	
	public void setTeamA(String text){
		teamA.setText(text);
	}
	
	public void setTeamB(String text){
		teamB.setText(text);
	}
	
	public void setScoreTeamA(String score){
		scoreTeamA.setText(score);
	}
	
	public void setScoreTeamB(String score){
		scoreTeamB.setText(score);
	}
	
	public void addEvent(int timeSeconds, String event){
		events.add(new Event(timeSeconds, event));
	}
}
