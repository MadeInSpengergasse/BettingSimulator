package vombokombo.BettingSimulator.view;

import vombokombo.BettingSimulator.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vombokombo.BettingSimulator.util.TeamHelper;

import java.util.Random;

public class MainViewController {

    @FXML
    private Label moneyLabel;

    private MainApp mainapp;

    public MainViewController() {

    }

    @FXML
    private void initialize() {
//        generateMatches(20);
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

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }


    public Label getMoneyLabel() {
        return moneyLabel;
    }

    public void generateMatches(int count){
        Random random = new Random();
        for(int i=0; i<count; i++){
            int oddsA = random.nextInt(80)+10;
            String teamA = TeamHelper.getRandomTeamName();
            String teamB = TeamHelper.getRandomTeamName();
            while(teamA.equalsIgnoreCase(teamB)){
                teamB = TeamHelper.getRandomTeamName();
            }
            addMatch(teamA, teamB, oddsA, 100-oddsA);

        }


    }

    public void addMatch(String teamA, String teamB, int oddsA, int oddsB){
        //TODO: Add match!!!!
    }

}
