package vombokombo.BettingSimulator.view;

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

    private boolean won;
    private int wonMoney;

    @FXML
    private Text wonLost;

    @FXML
    private Text textWonLost;

    @FXML
    private Text balance;

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }


    public void setImportantThings(boolean won, int wonMoney) {
        setWon(won);
        setWonMoney(wonMoney);
        setBalance();
    }

    @FXML
    public void continueButton() {
        ((Stage) wonLost.getScene().getWindow()).close();
    }

    public void setWon(boolean won) {
        this.won = won;
        if (won)
            textWonLost.setText("won!!");
        else
            textWonLost.setText("lost.");
    }

    public void setWonMoney(int wonMoney) {
        this.wonMoney = wonMoney;
        DecimalFormat df = new DecimalFormat("0.00");
        wonLost.setText(df.format(wonMoney) + " " + MainApp.EURO);
        MainApp.mainapp.setMoney(MainApp.getMoney() + wonMoney);
    }

    public void setBalance() {
        DecimalFormat df = new DecimalFormat("0.00");
        balance.setText(df.format(MainApp.getMoney()) + " " + MainApp.EURO);
    }
}
