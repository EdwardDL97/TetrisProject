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

public class HighScoreController {

	public static ArrayList<String> playerNameHighScore = new ArrayList<String>();
	public static ArrayList<Integer> playerHighScore = new ArrayList<Integer>();

	@FXML
	public Label FirstPlace, FirstScore;		
	@FXML
	public Label SecondPlace, SecondScore;	
	@FXML
	public Label ThirdPlace, ThirdScore;	
	@FXML
	public Label FourthPlace, FourthScore;
	@FXML
	public Label FifthPlace, FifthScore;

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

	@FXML
	public void highScores() {

		try {		

			switch(playerNameHighScore.size()) {

			case 1: FirstPlace.setText(playerNameHighScore.get(0));
			FirstScore.setText(Integer.toString(playerHighScore.get(0)));
			break;

			case 2: FirstPlace.setText(playerNameHighScore.get(0));
			FirstScore.setText(Integer.toString(playerHighScore.get(0)));
			SecondPlace.setText(playerNameHighScore.get(1));
			SecondScore.setText(Integer.toString(playerHighScore.get(1)));
			break;		

			case 3: FirstPlace.setText(playerNameHighScore.get(0));
			FirstScore.setText(Integer.toString(playerHighScore.get(0)));
			SecondPlace.setText(playerNameHighScore.get(1));
			SecondScore.setText(Integer.toString(playerHighScore.get(1)));
			ThirdPlace.setText(playerNameHighScore.get(2));
			ThirdScore.setText(Integer.toString(playerHighScore.get(2)));
			break;

			case 4: FirstPlace.setText(playerNameHighScore.get(0));
			FirstScore.setText(Integer.toString(playerHighScore.get(0)));
			SecondPlace.setText(playerNameHighScore.get(1));
			SecondScore.setText(Integer.toString(playerHighScore.get(1)));
			ThirdPlace.setText(playerNameHighScore.get(2));
			ThirdScore.setText(Integer.toString(playerHighScore.get(2)));
			FourthPlace.setText(playerNameHighScore.get(3));
			FourthScore.setText(Integer.toString(playerHighScore.get(3)));
			break;

			case 5: FirstPlace.setText(playerNameHighScore.get(0));
			FirstScore.setText(Integer.toString(playerHighScore.get(0)));
			SecondPlace.setText(playerNameHighScore.get(1));
			SecondScore.setText(Integer.toString(playerHighScore.get(1)));
			ThirdPlace.setText(playerNameHighScore.get(2));
			ThirdScore.setText(Integer.toString(playerHighScore.get(2)));
			FourthPlace.setText(playerNameHighScore.get(3));
			FourthScore.setText(Integer.toString(playerHighScore.get(3)));
			FifthPlace.setText(playerNameHighScore.get(4));
			FifthScore.setText(Integer.toString(playerHighScore.get(4)));
			break;

			default: System.out.println("Empty");

			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
