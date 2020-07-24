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

	//@FXML
	//public Button updateButton;
	
	//public static int count = 0;
	
	/*@FXML
	public void highScores(ActionEvent event) throws IOException {
		
		try {
			
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane scores = (AnchorPane)FXMLLoader.load(getClass().getResource("High Scores.fxml"));
		    Scene highScore = new Scene(scores,1200,750);
		    highScore.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    mainStage.setScene(highScore);  
		    mainStage.show();
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
	
	
			count++;
			
			for(int i = 0; i < HighScoreController.playerNameHighScore.size(); i++) {
				System.out.println(HighScoreController.playerNameHighScore.get(i));
				System.out.println(HighScoreController.playerHighScore.get(i));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
