package vombokombo.BettingSimulator.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    @FXML
    private TableColumn<Match, String> oddsA;

    @FXML
    private TableColumn<Match, String> oddsB;

    @FXML
    private TableColumn<Match, String> teamA;

    @FXML
    private TableColumn<Match, String> teamB;



    private MainApp mainapp;

    public MainViewController() {

    }

    @FXML
    private void initialize() {
//        generateMatches(20);
        //TODO: CHANGE AND INIT!!!
//        oddsA.setCellValueFactory(cellData -> cellData.getValue().get);
//        timeStamp.setCellValueFactory(cellData -> cellData.getValue().getTimeStampProperty());
    }

    @FXML
    private void closeButton() {
        System.exit(0);
    }

    @FXML
    private void moneyyyy() {
        mainapp.setMoney(mainapp.getMoney() + 100);
    }

    @FXML
    private void openLiveticker() {
        mainapp.showLiveticker();
    }

    @FXML
    private void openEndOfMatch() {
        mainapp.showEndOfMatchView(true, 100);
    }

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
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
    }

}
