package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	
	@FXML private javafx.scene.control.Button closeButton;
	
	@FXML
	private void closeButtonAction() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void displayHighScores(ActionEvent event) {

		try {
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane scores = (AnchorPane)FXMLLoader.load(getClass().getResource("HighScores.fxml"));
			Scene highScore = new Scene(scores,1200,750);
			mainStage.setScene(highScore);
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void displaySettings(ActionEvent event) {

		try {
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane scores = (AnchorPane)FXMLLoader.load(getClass().getResource("Settings.fxml"));
			Scene highScore = new Scene(scores,1200,750);
			mainStage.setScene(highScore);
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void displayGame(ActionEvent event) {

		try {
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane scores = (AnchorPane)FXMLLoader.load(getClass().getResource("PlayerMode.fxml"));
			Scene highScore = new Scene(scores,1200,750);
			mainStage.setScene(highScore);
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void displayMenu(ActionEvent event) {
		try {
			Parent view = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(view,1200,750);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
