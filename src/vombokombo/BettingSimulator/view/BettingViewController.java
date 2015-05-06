package vombokombo.BettingSimulator.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vombokombo.BettingSimulator.MainApp;

/**
 * Created by Luca on 04.05.2015.
 */
public class BettingViewController {

    private MainApp mainapp;

    @FXML
    private Label teamA;

    @FXML
    private Label teamB;

    @FXML
    private Label quoteA;

    @FXML
    private Label quoteB;

    @FXML
    private TextField amount;

    public void setMainApp(MainApp mainapp){
        this.mainapp = mainapp;
    }

    @FXML
    private void betOnA(){

    }

    @FXML
    private void betOnB(){

    }

    @FXML
    private void increase(){

    }

    @FXML
    private void decrease(){

    }

}
