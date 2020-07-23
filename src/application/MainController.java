package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

	@FXML
	public void displayHighScores(ActionEvent event) {

		try {
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
}
