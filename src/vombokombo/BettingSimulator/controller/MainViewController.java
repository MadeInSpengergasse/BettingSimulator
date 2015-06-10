package vombokombo.BettingSimulator.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.model.Match;
import vombokombo.BettingSimulator.util.TeamHelper;

import java.util.Random;

public class MainViewController {

    @FXML
    private Text moneyText;

    @FXML
    private Text matchesWonText;

    @FXML
    private Text matchesLostText;

    @FXML
    private TableView<Match> matchesTable;

    /*
      @FXML
      private TableColumn<Match, Number> oddsA;

      @FXML
      private TableColumn<Match, Number> oddsB;

      @FXML
      private TableColumn<Match, String> teamA;

      @FXML
      private TableColumn<Match, String> teamB;
  */
    @FXML
    private TableColumn<Match, String> odds;

    @FXML
    private TableColumn<Match, String> teams;

    private ObservableList<Match> matches;


    private MainApp mainapp;

    /**
     * Constructor
     */
    public MainViewController() {
        matches = FXCollections.observableArrayList();
    }

    /**
     * things which should be done as soon as you open the window
     */
    @FXML
    private void initialize() {
        //TODO: CHANGE AND INIT!!!
//        oddsA.setCellValueFactory(cellData -> cellData.getValue().oddsAProperty());
//        oddsB.setCellValueFactory(cellData -> cellData.getValue().oddsBProperty());
//        teamA.setCellValueFactory(cellData -> cellData.getValue().teamAProperty());
//        teamB.setCellValueFactory(cellData -> cellData.getValue().teamBProperty());
        odds.setCellValueFactory(cellData -> cellData.getValue().oddsProperty());
        teams.setCellValueFactory(cellData -> cellData.getValue().teamsProperty());
        generateMatches(40);
        matchesTable.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                if (mouseEvent.getClickCount() == 2) {
//                    System.out.println("double click");
                    mainapp.showBettingView(matchesTable.getSelectionModel().getSelectedItem());
                }
            }
        });
    }

    /**
     * Action which will be performed if you hit the Close button
     */
    @FXML
    private void closeButton() {
        System.exit(0);
    }

    /**
     * Action which will be performed if you hit the Moneyyyy button
     */
    @FXML
    private void moneyyyy() {
//        mainapp.setMoney(MainApp.getMoney() + 100);
        moneyText.setText(System.getProperty("user.home"));
    }

    /**
     * Action which will be performed if you hit the Open Liveticker button
     */
    @FXML
    private void openLiveticker() {
        mainapp.showLiveticker("Team A", "Team B", true, 100, 30);
    }

    /**
     * Action which will be performed if you hit the End of Match View button
     */
    @FXML
    private void openEndOfMatch() {
        mainapp.showEndOfMatchView(1, 100, 50);
    }

    /**
     * Action which will be performed if you hit the Betting View button
     */
    @FXML
    private void openBettingView() {
        mainapp.showBettingView(new Match("TeamA", "TeamB", 50, 50));
    }

    /**
     * Set-method for mainapp
     * @param mainapp the mainapp you want to merge with your attribute mainapp
     */
    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
        matchesTable.setItems(matches);

    }

    /**
     * Get-method for moneyText
     * @return moneyText
     */
    public Text getMoneyText() {
        return moneyText;
    }

    /**
     * Get-method for matchesWonText
     * @return matchesWonText
     */
    public Text getMatchesWonText() {
        return matchesWonText;
    }

    /**
     * Get-method for matchesLostText
     * @return matchesLostText
     */
    public Text getMatchesLostText() {
        return matchesLostText;
    }

    /**
     * Generates random matches
     * @param count amount of matches which are created
     */
    public void generateMatches(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int oddsA = random.nextInt(80) + 10;
            String teamA = TeamHelper.getRandomTeamName();
            String teamB = TeamHelper.getRandomTeamName();
            while (teamA.equalsIgnoreCase(teamB)) {
                teamB = TeamHelper.getRandomTeamName();
            }
            addMatch(teamA, teamB, oddsA, 100 - oddsA);
        }
    }

    /**
     * adds a match
     * @param teamA teamA
     * @param teamB teamB
     * @param oddsA oddsA
     * @param oddsB oddsB
     */
    public void addMatch(String teamA, String teamB, int oddsA, int oddsB) {
        //TODO: Add match!!
        matches.add(new Match(teamA, teamB, oddsA, oddsB));
    }

}
