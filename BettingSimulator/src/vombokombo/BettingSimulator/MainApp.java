package vombokombo.BettingSimulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import vombokombo.BettingSimulator.util.ExceptionDialog;
import vombokombo.BettingSimulator.util.Save;
import vombokombo.BettingSimulator.view.LivetickerViewController;
import vombokombo.BettingSimulator.view.MainViewController;
import vombokombo.BettingSimulator.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private MainViewController mainViewController;
    
    private float money;
    
    private Label moneyLabel;

    @Override
    public void start(Stage primaryStage) {
    	
    	Exception ex = new FileNotFoundException("File xyz.txt could not be found!");
    	ExceptionDialog.showExceptionDialog(ex);
    	
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Main");

        initRootLayout();

        showMainView();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showLiveticker() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LivetickerView.fxml"));
            AnchorPane livetickerView = (AnchorPane) loader.load();
            
            Stage livetickerStage = new Stage();
            livetickerStage.setTitle("Liveticker");

            livetickerStage.initModality(Modality.WINDOW_MODAL);
            livetickerStage.initOwner(primaryStage);
            Scene scene = new Scene(livetickerView);
            livetickerStage.setScene(scene);
            
            LivetickerViewController controller = loader.getController();
            controller.setMainApp(this);
            
            livetickerStage.showAndWait();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void showMainView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));
            AnchorPane mainView = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(mainView);
            
            mainViewController = loader.getController();
            mainViewController.setMainApp(this);
            moneyLabel = mainViewController.getMoneyLabel();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean loadDataFromFile(File file){
    	
    	try {
			JAXBContext context = JAXBContext.newInstance(Save.class);
			Unmarshaller um = context.createUnmarshaller();
			
			Save save = (Save) um.unmarshal(file);
			setMoney(save.getMoney());
			setFilePath(file);
			
		} catch (JAXBException e) {
			ExceptionDialog.showExceptionDialog(e);
		}
    	
    	
    	//TODO: Get everything from the file
    	
    	
    	
    	return false;
    }
    
    public boolean saveDataToFile(File file){
    	
        try {
            JAXBContext context = JAXBContext
                    .newInstance(Save.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            Save save = new Save();
            save.setMoney(money);

            // Marshalling and saving XML to the file.
            m.marshal(save, file);

            // Save the file path to the registry.
            setFilePath(file);
        } catch (Exception e) { // catches ANY exception
        	ExceptionDialog.showExceptionDialog(e);
        }
    	
    	
    	
    	return false;
    }
    
    public void setFilePath(File file){
    	Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
    	
    	if(file != null){
    		prefs.put("filePath", file.getPath());
    	} else {
    		prefs.remove("filePath");
    	}
    }
    
    public File getFilePath(){
    	Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
    	String filePath = prefs.get("filePath", null);
    	if(filePath != null){
    		return new File(filePath);
    	} else {
    		return null;
    	}
    }

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
		DecimalFormat df = new DecimalFormat("0.00");
		moneyLabel.setText(df.format(money) + " €");
	}
}