package vombokombo.BettingSimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vombokombo.BettingSimulator.util.ExceptionDialog;
import vombokombo.BettingSimulator.util.PropertiesHelper;
import vombokombo.BettingSimulator.util.Save;
import vombokombo.BettingSimulator.view.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.prefs.Preferences;


public class MainApp extends Application {

    public static MainApp mainapp;

    public static Stage primaryStage;
    private BorderPane rootLayout;

    private MainViewController mainViewController;


    private Label moneyLabel;
    private Label matchesWonLabel;
    private Label matchesLostLabel;

    public static String currentFileName = null;
    private static float money;
    private static int matchesWon;
    private static int matchesLost;

    public static Properties getProperties(){
        Properties props = new Properties();
        props.put("money", money);
        props.put("matchesWon", matchesWon);
        props.put("matchesLost", matchesLost);
        return props;
    }

    public void setSave(float money, int matchesWon, int matchesLost) {
        setMoney(money);
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
    }

    @Override
    public void start(Stage primaryStage) {
//        Exception ex = new FileNotFoundException("File xyz.txt could not be found!");
//        ExceptionDialog.showExceptionDialog(ex);

//        PropertiesHelper.open();

        this.mainapp = this;

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Main");
        this.primaryStage.getIcons().add(new Image("icon.png"));

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
            rootLayout = loader.load();

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
            AnchorPane livetickerView = loader.load();

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
            AnchorPane mainView = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(mainView);

            mainViewController = loader.getController();
            mainViewController.setMainApp(this);
            moneyLabel = mainViewController.getMoneyLabel();
            matchesWonLabel = mainViewController.getMatchesWonLabel();
            matchesLostLabel = mainViewController.getMatchesLostLabel();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEndOfMatchView(boolean won, int wonMoney) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EndOfMatchView.fxml"));
            BorderPane endOfMatchView = loader.load();

            Stage endOfMatchStage = new Stage();
            endOfMatchStage.setTitle("End of match!");

            endOfMatchStage.initModality(Modality.WINDOW_MODAL);
            endOfMatchStage.initOwner(primaryStage);
            Scene scene = new Scene(endOfMatchView);
            endOfMatchStage.setScene(scene);

            EndOfMatchViewController controller = loader.getController();
            controller.setMainApp(this);
            controller.setImportantThings(won, wonMoney);

            endOfMatchStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBettingView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BettingView.fxml"));
            AnchorPane bettingView = loader.load();

            Stage bettingViewStage = new Stage();
            bettingViewStage.setTitle("End of match!");

            bettingViewStage.initModality(Modality.WINDOW_MODAL);
            bettingViewStage.initOwner(primaryStage);
            Scene scene = new Scene(bettingView);
            bettingViewStage.setScene(scene);

            BettingViewController controller = loader.getController();
            controller.setMainApp(this);

            bettingViewStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }



    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
        DecimalFormat df = new DecimalFormat("0.00");
        moneyLabel.setText(df.format(money) + " €");
    }

    public void setMatchesWon(int matchesWon){
        this.matchesWon = matchesWon;

    }

    public void setMatchesLost(int matchesLost){
        this.matchesLost = matchesLost;

    }
}