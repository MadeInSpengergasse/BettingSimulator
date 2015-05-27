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

    public MainViewController() {
        matches = FXCollections.observableArrayList();
    }

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

    @FXML
    private void closeButton() {
        System.exit(0);
    }

    @FXML
    private void moneyyyy() {
//        mainapp.setMoney(MainApp.getMoney() + 100);
        moneyText.setText(System.getProperty("user.home"));
    }

    @FXML
    private void openLiveticker() {
        mainapp.showLiveticker("Team A", "Team B", true, 100, 30);
    }

    @FXML
    private void openEndOfMatch() {
        mainapp.showEndOfMatchView(1, 100);
    }

    @FXML
    private void openBettingView() {
        mainapp.showBettingView(new Match("TeamA", "TeamB", 50, 50));
    }

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
        matchesTable.setItems(matches);

    }

    public Text getMoneyText() {
        return moneyText;
    }

    public Text getMatchesWonText() {
        return matchesWonText;
    }

    public Text getMatchesLostText() {
        return matchesLostText;
    }

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

    public void addMatch(String teamA, String teamB, int oddsA, int oddsB) {
        //TODO: Add match!!
        matches.add(new Match(teamA, teamB, oddsA, oddsB));
    }

}
