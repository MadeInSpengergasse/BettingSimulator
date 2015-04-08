package vombokombo.BettingSimulator.view;

import java.io.File;

import vombokombo.BettingSimulator.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController {

    private MainApp mainapp;

    public RootLayoutController() {

    }

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    @FXML
    private void initialize() {

    }

    @FXML
    public void closeMenu() {
        System.exit(0);
    }

    @FXML
    public void aboutMenu() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About: Betting Simulator");
        alert.setHeaderText("Programming, Design & Idea");
        alert.setContentText("   Faltl Philipp\n   Weber Lukas\n   Weiss Luca");

        alert.showAndWait();

    }


    @FXML
    private void newMenu() {

    }

    @FXML
    private void openMenu() {
        mainapp.loadDataFromFile(new File("save1.save"));
    }

    @FXML
    private void saveMenu() {
        mainapp.saveDataToFile(new File("save1.save"));
    }

    @FXML
    private void saveAsMenu() {

    }


}
