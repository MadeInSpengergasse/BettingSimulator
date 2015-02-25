package vombokombo.BettingSimulator.view;


import vombokombo.BettingSimulator.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LivetickerViewController {

	@FXML
	private Label teamA;
	@FXML
	private Label teamB;
	
	@FXML
	private Label time;
	
	@FXML
	private TableColumn<String, String> timeStamp;
	
	@FXML
	private TableColumn<String, String> event;

	private MainApp mainApp;
	
	public LivetickerViewController(){
	}
	
	@FXML
	private void initialize(){
		
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}
	
}
