package vombokombo.BettingSimulator.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController {

	public RootLayoutController() {

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

}
