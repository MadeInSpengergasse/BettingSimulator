package vombokombo.BettingSimulator.util;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import vombokombo.BettingSimulator.MainApp;

import java.io.*;
import java.util.Properties;

/**
 * Created by luca on 05.05.15.
 */
public class PropertiesHelper {

    public static final String ORIGINAL_FILENAME = "BettingSimulator.db";

    public static void saveToFile(File file){
        try {

            OutputStream os = new FileOutputStream(file);
            MainApp.getProperties().store(os, "This is a comment ;)");
            //TODO: SAVE
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Properties loadSaveFromFile(String filename){
        Properties props = new Properties();
        InputStream is;
        try {
            is = new FileInputStream(new File(filename));
        } catch(Exception e){
            e.printStackTrace();
            is = null;
        }
        try {
            if(is == null){
                is = MainApp.class.getResourceAsStream(ORIGINAL_FILENAME);
            }
            props.load(is);
        } catch (Exception e){
            e.printStackTrace();
        }
        //TODO: LOAD
        return props;
    }

    public static void save(){


    }

    public static void saveAs(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a location to save!");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Save files (*.save)", "*.save");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.showSaveDialog(new Stage());
    }

    public static void open(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose the location to load from!");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Save files (*.save)", "*.save");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.showOpenDialog(new Stage());
    }

    public static void newM(){
        MainApp.mainapp.setSave(1000, 0, 0);
    }

    public static void main(String[] args){
        saveAs();
    }

}
