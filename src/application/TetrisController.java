package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;


public class TetrisController {

	@FXML
	public Button updateButton;
	
	public static int count = 0;
	
	@FXML
	public void highScores(ActionEvent event) throws IOException {
		
		try {
			/*
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane scores = (AnchorPane)FXMLLoader.load(getClass().getResource("High Scores.fxml"));
		    Scene highScore = new Scene(scores,1200,750);
		    highScore.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    mainStage.setScene(highScore);  
		    mainStage.show();*/
			FXMLLoader loader = new FXMLLoader(getClass().getResource("High Scores.fxml"));
	        Parent root = loader.load();
			HighScoreController highscore = loader.getController();
			highscore.displayHighScores();
	        updateButton.getScene().setRoot(root);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void updateHighScores(ActionEvent event) {
		
		try {		
			
			switch(count) {
			case 0: HighScoreController.playerNameHighScore.add("P1");
					HighScoreController.playerHighScore.add(500);
					break;
					
			case 1:	HighScoreController.playerNameHighScore.add("P2");
					HighScoreController.playerHighScore.add(400);
					break;
					
			case 2:	HighScoreController.playerNameHighScore.add("P3");
					HighScoreController.playerHighScore.add(300);
					break;
					
			case 3:	HighScoreController.playerNameHighScore.add("P4");
					HighScoreController.playerHighScore.add(200);
					break;
					
			case 4:	HighScoreController.playerNameHighScore.add("P5");
					HighScoreController.playerHighScore.add(100);
					break;
					
			case 5:	HighScoreController.playerNameHighScore.set(0, "P6");
					HighScoreController.playerHighScore.set(0, 600);
					break;
	
			
			default: System.out.println("Hello");
					
			}
			
			count++;
			
/*			for(int i = 0; i < HighScoreController.playerNameHighScore.size(); i++) {
				System.out.println(HighScoreController.playerNameHighScore.get(i));
				System.out.println(HighScoreController.playerHighScore.get(i));
			}*/
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
