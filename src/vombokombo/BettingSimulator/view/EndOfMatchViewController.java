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

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }


    public void setImportantThings(int status, float betMoney) {
        setWon(status);
        setWonMoney(betMoney, status);
        setBalance();
        setMainWonLost(status);
    }

    private void setMainWonLost(int status) {
        if (status == 0) {
            MainApp.mainapp.increaseMatchesLost();
        } else if (status == 2) {
            MainApp.mainapp.increaseMatchesWon();
        }
    }

    @FXML
    public void continueButton() {
        ((Stage) wonLost.getScene().getWindow()).close();

    }

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

    public void setBalance() {
        DecimalFormat df = new DecimalFormat("0.00");
        balance.setText(df.format(MainApp.getMoney()) + " " + MainApp.EURO);
    }
}
