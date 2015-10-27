package vombokombo.BettingSimulator.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.model.Event;
import vombokombo.BettingSimulator.util.Counter;

public class LivetickerViewController {

    private final ObservableList<Event> events;
    private Counter counter;
    private String teamNameA;
    private String teamNameB;
    private boolean betOnA;
    private float moneyBet;
    private int oddsA;
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

    /**
     * Constructor
     */
    public LivetickerViewController() {
        events = FXCollections.observableArrayList();
    }

    /**
     * Get-method for TeamNameA
     *
     * @return teamNameA
     */
    public String getTeamNameA() {
        return teamNameA;
    }

    /**
     * Get-method for TeamNameB
     *
     * @return teamNameB
     */
    public String getTeamNameB() {
        return teamNameB;
    }

    /**
     * Some important things which have to be initialized at the beginning
     */
    @FXML
    private void initialize() {
        event.setCellValueFactory(cellData -> cellData.getValue().getEventProperty());
        timeStamp.setCellValueFactory(cellData -> cellData.getValue().getTimeStampProperty());
    }

    /**
     * Set-method for mainApp
     *
     * @param mainApp is the mainApp you want the attribute mainApp to be
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        eventTable.setItems(events);
    }

    /**
     * Action performed when hitting the Start button
     */
    @FXML
    public void startButton() {
        if (counter == null) {
            counter = new Counter(time, 1, this, 90, oddsA);
        }
    }

    /**
     * Action performed when hitting the Stop/Resume button
     */
    @FXML
    public void stop_resumeButton() {
        if (counter != null) {
            counter.stopResume();
        }
    }

    /**
     * Set-method for TeamA
     *
     * @param teamA is used for setting the text in teamA and for merging with the attribute teamNameA
     */
    private void setTeamA(String teamA) {
        this.teamA.setText(teamA);
        this.teamNameA = teamA;
    }

    /**
     * Set-method for TeamB
     *
     * @param teamB is used for setting the text in teamB and for merging with the attribute teamNameB
     */
    private void setTeamB(String teamB) {
        this.teamB.setText(teamB);
        this.teamNameB = teamB;
    }

    /**
     * Get-method for Team-Score A
     *
     * @return the Team-Score
     */
    private int getScoreTeamA() {
        return Integer.parseInt(scoreTeamA.getText());
    }

    /**
     * Set the Score of Team A
     *
     * @param score is used for setting the text of scoreTeamA
     */
    private void setScoreTeamA(String score) {
        scoreTeamA.setText(score);
    }

    /**
     * Get-method for Team-Score B
     *
     * @return the Team-Score
     */
    private int getScoreTeamB() {
        return Integer.parseInt(scoreTeamB.getText());
    }

    /**
     * Set the Score of Team B
     *
     * @param score is used for setting the text of scoreTeamA
     */
    private void setScoreTeamB(String score) {
        scoreTeamB.setText(score);
    }

    /*
        public void addEvent(int timeSeconds, String event, EventType type) {
            events.add(new Event(timeSeconds, event, type));
        }
    */

    /**
     * Adds an Event to the list
     *
     * @param event is the event you want to add
     */
    public void addEvent(Event event) {
//        Platform.runLater(() -> {
        if (event != null) {
            switch (event.getType()) {
                case GOAL_A:
                    setScoreTeamA(Integer.toString(getScoreTeamA() + 1));
                    //TODO: set right team!
                    break;
                case GOAL_B:
                    setScoreTeamB(Integer.toString(getScoreTeamB() + 1));
                    break;
                default:
                    break;
            }
            events.add(event);
        }


//        });
    }

    /**
     * Get-method for TimeLabel
     *
     * @return time
     */
    private Label getTimeLabel() {
        return time;
    }

    /**
     * Sets the teams, the bet, the money and the odds of team A
     *
     * @param teamA    teamA
     * @param teamB    teamB
     * @param betOnA   determines if you bet on A or B
     * @param moneyBet the amount you bet
     * @param oddsA    the odds of A (odds of B=100-oddsA)
     */
    public void setImportantThing(String teamA, String teamB, boolean betOnA, float moneyBet, int oddsA) {
        setTeamA(teamA);
        setTeamB(teamB);
        this.betOnA = betOnA;
        this.moneyBet = moneyBet;
        this.oddsA = oddsA;
    }

    /**
     * Describes what should happen after a match
     */
    public void handleEndOfMatch() {
        ((Stage) getTimeLabel().getScene().getWindow()).close();
        int status;

        if (getScoreTeamA() == getScoreTeamB()) {
            status = 1;
        } else if (((getScoreTeamA() > getScoreTeamB()) && betOnA) || ((getScoreTeamB() > getScoreTeamA()) && !betOnA)) {
            status = 2;
        } else {
            status = 0;
        }
        int oddsOfTeam;
        if (betOnA)
            oddsOfTeam = oddsA;
        else
            oddsOfTeam = 100 - oddsA;

        Platform.runLater(() -> mainApp.showEndOfMatchView(status, moneyBet, oddsOfTeam));
    }

}
