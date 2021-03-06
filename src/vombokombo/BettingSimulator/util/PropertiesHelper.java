package vombokombo.BettingSimulator.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import vombokombo.BettingSimulator.MainApp;

import java.io.*;
import java.util.Properties;

/**
 * Created by luca on 05.05.15.
 */
public class PropertiesHelper {

    private static final String ORIGINAL_FILENAME = "BettingSimulator.db";

    /**
     * saves the properties from the MainApp class to the provided file
     *
     * @param file the file where to save in
     */
    private static void saveToFile(File file) {
        if (file == null)
            return;
        try {
            OutputStream os = new FileOutputStream(file);
            MainApp.getProperties().store(os, "This is a comment ;)");
            //TODO: SAVE
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainApp.currentFile = file;
    }

    /**
     * loads the save from the provided files and configures everything in the MainApp class
     *
     * @param file the file to load from
     */
    private static void loadSaveFromFile(File file) {
        if (file == null)
            return;
        Properties props = new Properties();
        InputStream is;
        try {
            is = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
            is = null;
        }
        try {
            if (is == null) {
                is = MainApp.class.getResourceAsStream(ORIGINAL_FILENAME);
            }
            props.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainApp.currentFile = file;
        MainApp.setProperties(props);
    }

    /**
     * can get called from the save menu, if the currentFile is null, the saveAs method will be called
     */
    public static void save() {
        if (MainApp.currentFile == null) {
            saveAs();
        } else {
            saveToFile(MainApp.currentFile);
        }
    }

    /**
     * can get called from the save menu, handles everything else
     */
    public static void saveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a location to save!");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Save files (*.save)", "*.save");
        fileChooser.getExtensionFilters().add(extFilter);
        saveToFile(fileChooser.showSaveDialog(new Stage()));
    }

    /**
     * can get called from the open menu, handles everything else
     */
    public static void open() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a location to load from!");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Save files (*.save)", "*.save");
        fileChooser.getExtensionFilters().add(extFilter);
        loadSaveFromFile(fileChooser.showOpenDialog(new Stage()));
    }

    /**
     * can get called from the new menu, handles everything else
     */
    public static void newM() {
        MainApp.currentFile = null;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Do you really want to create a new save?");
        alert.setContentText("Any unsaved changes will be lost!");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);

        alert.getButtonTypes().setAll(buttonTypeCancel, buttonTypeOk);

        if (alert.showAndWait().get() == buttonTypeOk)
            MainApp.mainapp.setSave(1000, 0, 0);
    }

}
