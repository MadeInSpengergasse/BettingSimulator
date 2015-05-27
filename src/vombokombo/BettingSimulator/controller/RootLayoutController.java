package vombokombo.BettingSimulator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import vombokombo.BettingSimulator.MainApp;
import vombokombo.BettingSimulator.util.PropertiesHelper;

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
        PropertiesHelper.newM();
    }

    @FXML
    private void openMenu() {
        PropertiesHelper.open();
    }

    @FXML
    private void saveMenu() {
        PropertiesHelper.save();
    }

    @FXML
    private void saveAsMenu() {
        PropertiesHelper.saveAs();
    }


}
