package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;


public class TetrisController {

	@FXML
	private Label scoretext;
	private int score;
	
	public void display(ActionEvent event){
		scoretext.setText("Score: " + Integer.toString(score));
	}

	
	
	
	@FXML
	public void startGame(ActionEvent event) {
		try {
			Parent view = (SplitPane)FXMLLoader.load(getClass().getResource("Tetris.fxml"));
			Scene scene = new Scene(view,1200,750);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void displayMenu(ActionEvent event) {

		try {
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane scores = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene highScore = new Scene(scores,1200,750);
			mainStage.setScene(highScore);
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
