package vombokombo.BettingSimulator.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vombokombo.BettingSimulator.MainApp;

import java.text.DecimalFormat;

/**
 * Created by Luca on 04.05.2015.
 */
public class EndOfMatchViewController {

    private MainApp mainapp;

    /**
     * 0 = lost
     * 1 = draw
     * 2 = win
     */
    private int won;

    private int wonMoney = 0;

    @FXML
    private Text wonLost;

    @FXML
    private Text textWonLost;

    @FXML
    private Text balance;

    /**
     * Sets the mainapp
     * @param mainapp is the mainapp you want to merge with the attribute mainapp
     */
    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    /**
     * Sets the information which will be displayed after the outcome of a match
     * @param status describes either if you have won, lost or if it is a draw
     * @param betMoney is the money you bet
     */
    public void setImportantThings(int status, float betMoney) {
        setWon(status);
        setWonMoney(betMoney, status);
        setBalance();
        setMainWonLost(status);
    }

    /**
     * Increases the amount of Wins/Losses you have made
     * @param status determines if you either have lost or won
     */
    private void setMainWonLost(int status) {
        if (status == 0) {
            MainApp.mainapp.increaseMatchesLost();
        } else if (status == 2) {
            MainApp.mainapp.increaseMatchesWon();
        }
    }

    /**
     * The action which will be performed if you press the "Continue" Button
     */
    @FXML
    public void continueButton() {
        ((Stage) wonLost.getScene().getWindow()).close();

    }

    /**
     * displays if you have either won or lost the match, or if it is a draw
     * @param status determines the outcome of the match
     */
    public void setWon(int status) {
        this.won = status;
        if (status == 0)
            textWonLost.setText("lost.");
        else if (status == 1)
            textWonLost.setText("draw.");
        else if (status == 2)
            textWonLost.setText("won!");
        else
            textWonLost.setText("there was some sort of error...");
    }

    /**
     * Sets the Money you win/lose after a match
     * @param betMoney the money you win/lose
     * @param status outcome of the match
     */
    public void setWonMoney(float betMoney, int status) {
        System.out.println("Bet money: " + betMoney);
        if (status == 0) {
            this.wonMoney -= betMoney;
        } else if (status == 2) {
            this.wonMoney += betMoney;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        wonLost.setText(df.format(wonMoney) + " " + MainApp.EURO);
        MainApp.mainapp.setMoney(MainApp.getMoney() + wonMoney);
    }

    /**
     * Formats your balance right
     */
    public void setBalance() {
        DecimalFormat df = new DecimalFormat("0.00");
        balance.setText(df.format(MainApp.getMoney()) + " " + MainApp.EURO);
    }
}
