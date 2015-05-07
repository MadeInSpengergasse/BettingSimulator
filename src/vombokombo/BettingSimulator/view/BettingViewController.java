package vombokombo.BettingSimulator.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.model.Match;

/**
 * Created by Luca on 04.05.2015.
 */
public class BettingViewController {

    private static final String NON_NUMERIC_REGEX = "[^\\d.]";

    private static final int INCREASEDECREASEBY = 100;
    private int amountInt;
    private MainApp mainapp;
    @FXML
    private Text teamA;
    @FXML
    private Text teamB;
    @FXML
    private Text teamA2;
    @FXML
    private Text teamB2;
    @FXML
    private Text oddsA;
    @FXML
    private Text oddsB;
    @FXML
    private TextField amount;

    @FXML
    private void initialize() {
        amount.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                System.out.println("focus lost");
                setAmount(Integer.parseInt(0 + amount.getText().replaceAll(NON_NUMERIC_REGEX, "")));
            }
        });
    }

    public void setImportantThings(Match match) {
        teamA.setText(match.getTeamA());
        teamA2.setText(match.getTeamA());
        teamB.setText(match.getTeamB());
        teamB2.setText(match.getTeamB());
        this.oddsA.setText(match.getOddsA() + "");
        this.oddsB.setText(match.getOddsB() + "");
    }

    public void setAmount(int amount) {
        this.amountInt = amount;
        this.amount.setText(amount + " " + MainApp.EURO);
    }


    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    @FXML
    private void betOnA() {
        //TODO: WRITE
    }

    @FXML
    private void betOnB() {
        //TODO: WRITE
    }

    @FXML
    private void increase() {
        if (!(amountInt + INCREASEDECREASEBY > MainApp.getMoney()))
            setAmount(amountInt + INCREASEDECREASEBY);
    }

    @FXML
    private void decrease() {
        if (!(amountInt - INCREASEDECREASEBY < 0))
            setAmount(amountInt - INCREASEDECREASEBY);
    }

    @FXML
    private void cancel() {
        ((Stage) amount.getScene().getWindow()).close();
    }

}
