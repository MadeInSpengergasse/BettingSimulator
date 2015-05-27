package vombokombo.BettingSimulator.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.model.Match;

import java.text.DecimalFormat;

/**
 * Created by Luca on 04.05.2015.
 */
public class BettingViewController {

    private static final String NON_NUMERIC_REGEX = "[^\\d.]";

    private static final int INCREASEDECREASEBY = 100;
    private float amountInt = 100;
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
                setAmount(Float.parseFloat(0 + amount.getText().replaceAll(NON_NUMERIC_REGEX, "")));
                String bet = amount.getText().replaceAll(NON_NUMERIC_REGEX, "");
                if (Float.parseFloat(bet) > MainApp.getMoney()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Invalid amount!");
                    alert.setHeaderText("Wrong input!");
                    alert.setContentText("Too high input!");

                    alert.showAndWait();
                    setAmount(MainApp.getMoney());
                }
            }
        });
    }

    /**
     * Sets the textfields to the given match
     * @param match match data
     */
    public void setImportantThings(Match match) {
        teamA.setText(match.getTeamA());
        teamA2.setText(match.getTeamA());
        teamB.setText(match.getTeamB());
        teamB2.setText(match.getTeamB());
        this.oddsA.setText(match.getOddsA() + "");
        this.oddsB.setText(match.getOddsB() + "");
    }

    /**
     * Sets the amount to bet
     * @param amount amount to bet
     */
    public void setAmount(float amount) {
        DecimalFormat df = new DecimalFormat("0.00");
        this.amountInt = amount;
        this.amount.setText(df.format(amount) + " " + MainApp.EURO);
    }

    /**
     * Sets the mainapp
     * @param mainapp is the mainapp you want to merge with the attribute mainapp
     */
    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    /**
     * Action which occurs if you press the big "A" button
     */
    @FXML
    private void betOnA() {
        //TODO: WRITE
//        System.out.println(amountInt);
        closeWindow();
        Platform.runLater(() -> MainApp.mainapp.showLiveticker(teamA.getText(), teamB.getText(), true, amountInt, Integer.parseInt(oddsA.getText())));
    }

    /**
     * Action which occurs if you press the big "B" button
     */
    @FXML
    private void betOnB() {
        //TODO: WRITE
//        System.out.println(amountInt);
        closeWindow();
        Platform.runLater(() -> MainApp.mainapp.showLiveticker(teamA.getText(), teamB.getText(), false, amountInt, Integer.parseInt(oddsA.getText())));
    }

    /**
     * Increases the amount to bet by 100
     */
    @FXML
    private void increase() {
        if (!(amountInt + INCREASEDECREASEBY > MainApp.getMoney()))
            setAmount(amountInt + INCREASEDECREASEBY);
    }

    /**
     * Decreases th amount to bet by 100
     */
    @FXML
    private void decrease() {
        if (!(amountInt - INCREASEDECREASEBY < 0))
            setAmount(amountInt - INCREASEDECREASEBY);
    }

    /**
     * Goes back to the main window and closes this window
     */
    @FXML
    private void cancel() {
        closeWindow();
    }

    /**
     * Closes the Window
     */
    private void closeWindow() {
        ((Stage) amount.getScene().getWindow()).close();
    }

}
