package vombokombo.BettingSimulator.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import vombokombo.BettingSimulator.Counter;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.model.Event;
import vombokombo.BettingSimulator.model.Event.EventType;

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
        System.out.println("init livetickerviewcontroller");

        event.setCellValueFactory(cellData -> cellData.getValue().getEventProperty());
        timeStamp.setCellValueFactory(cellData -> cellData.getValue().getTimeStampProperty());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        eventTable.setItems(events);
    }

    @FXML
    public void closeButton() {
        ((Stage) time.getScene().getWindow()).close();
        // System.exit(0);
    }

    @FXML
    public void skipButton() {
        System.out.println("Skip Button");
        if (counter != null) {
            addEvent(new Event(counter.getTimeSeconds(), "testevent", EventType.UNKNOWN));
        }
    }

    @FXML
    public void startButton() {
        System.out.println("Start Button");
        if (counter == null) {
            System.out.println("Real Start");
            counter = new Counter(time, 20, this, 5, mainApp);
        }
    }

    @FXML
    public void stop_resumeButton() {
        if (counter != null) {
            counter.stopResume();
        }
        System.out.println("StopResume Button");
    }

    @FXML
    public void forwardButton() {
        System.out.println("Forward Button, NOTHING HAPPENS!!");
        /*
        if (counter == null) {
            counter = new Counter(time, 1, this, 10);
        }
        */
    }

    public void setTeamA(String text) {
        teamA.setText(text);
    }

    public void setTeamB(String text) {
        teamB.setText(text);
    }

    public void setScoreTeamA(String score) {
        scoreTeamA.setText(score);
    }

    public void setScoreTeamB(String score) {
        scoreTeamB.setText(score);
    }

    public int getScoreTeamA() {
        return Integer.parseInt(scoreTeamA.getText());
    }

    public int getScoreTeamB() {
        return Integer.parseInt(scoreTeamB.getText());
    }

    /*
        public void addEvent(int timeSeconds, String event, EventType type) {
            events.add(new Event(timeSeconds, event, type));
        }
    */
    public void addEvent(Event event) {
//        Platform.runLater(() -> {
        if (event != null) {
            switch (event.getType()) {
                case GOAL:
                    setScoreTeamA(Integer.toString(getScoreTeamA() + 1));
                    //TODO: set right team!
                    break;
                default:
                    break;
            }
            events.add(event);
        }


//        });
    }

    public Label getTimeLabel() {
        return time;
    }


}
