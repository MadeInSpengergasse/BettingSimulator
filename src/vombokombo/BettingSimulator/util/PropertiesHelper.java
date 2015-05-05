package vombokombo.BettingSimulator.util;

import vombokombo.BettingSimulator.MainApp;

import java.io.*;
import java.util.Properties;

/**
 * Created by luca on 05.05.15.
 */
public class PropertiesHelper {

    public static final String ORIGINAL_FILENAME = "BettingSimulator.db";

    public static void saveToFile(Properties props, String filename){
        try {
            File file = new File(filename);
            OutputStream os = new FileOutputStream(file);
            props.store(os, "This is a comment ;)");
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

}
