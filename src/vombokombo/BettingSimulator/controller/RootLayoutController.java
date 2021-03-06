package vombokombo.BettingSimulator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import vombokombo.BettingSimulator.util.PropertiesHelper;

public class RootLayoutController {

    public RootLayoutController() {

    }

    /**
     * Closes the program
     */
    @FXML
    public void closeMenu() {
        System.exit(0);
    }

    /**
     * The about Menu
     */
    @FXML
    public void aboutMenu() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About: Betting Simulator");
        alert.setHeaderText("Programming, Design & Idea");
        alert.setContentText("   Faltl Philipp\n   Weber Lukas\n   Weiss Luca");
        alert.showAndWait();

    }


    /**
     * Method to create a new file
     */
    @FXML
    private void newMenu() {
        PropertiesHelper.newM();
    }

    /**
     * Method to open a file
     */
    @FXML
    private void openMenu() {
        PropertiesHelper.open();
    }

    /**
     * Method to save your file
     */
    @FXML
    private void saveMenu() {
        PropertiesHelper.save();
    }

    /**
     * Method to save your file as something specific
     */
    @FXML
    private void saveAsMenu() {
        PropertiesHelper.saveAs();
    }


}
