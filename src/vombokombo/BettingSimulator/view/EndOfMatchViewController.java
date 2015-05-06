package vombokombo.BettingSimulator.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vombokombo.BettingSimulator.MainApp;

/**
 * Created by Luca on 04.05.2015.
 */
public class EndOfMatchViewController {

    private MainApp mainapp;

    private boolean won;
    private int wonMoney;

    @FXML
    private TextField wonLost;

    @FXML
    private Label textWonLost;

    @FXML
    private TextField balance;

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }


    public void setImportantThings(boolean won, int wonMoney) {
        this.won = won;
        this.wonMoney = wonMoney;
    }

    @FXML
    public void continueButton() {
        ((Stage) wonLost.getScene().getWindow()).close();
    }
}
