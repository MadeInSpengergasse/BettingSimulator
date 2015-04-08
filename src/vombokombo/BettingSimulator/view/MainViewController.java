package vombokombo.BettingSimulator.view;

import vombokombo.BettingSimulator.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainViewController {

    @FXML
    private Label moneyLabel;

    private MainApp mainapp;

    public MainViewController() {

    }

    @FXML
    private void initialize() {

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
}
