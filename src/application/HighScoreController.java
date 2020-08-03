// Group 1 Team Tetris
package application;

import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;

public class HighScoreController implements Initializable {

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
	
	/*
	 * saveNames is used to save the player's name
	 */


	public static void saveNames(String fileName, ArrayList<String> a) {

		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("");
			FileOutputStream out = new FileOutputStream(fileName);
			BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(out));
			for(int i = 0; i < a.size(); i++) {
				buffer.write(a.get(i));
				buffer.newLine();
			}
			buffer.close();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	/*
	 * saveScores is used to save the player's score
	 */

	public static void saveScores(String fileName, ArrayList<Integer> a) {

		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("");
			FileOutputStream out = new FileOutputStream(fileName);
			BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(out));
			ArrayList <String> aStr = new ArrayList<String>();
			for(int i = 0; i < a.size(); i++) {
				aStr.add(Integer.toString(a.get(i)));
				buffer.write(aStr.get(i));
				buffer.newLine();
			}
			buffer.close();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}		
	}

	/*
	 * displayMenu method has a parameter ActionEvent called event.
	 * This method is used to switch from the High Score screen back to the Main Menu.
	 */
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
	
	/*
	 * highScores method is used to print out the names of people placed first-fifth
	 */

	@FXML
	public void highScores() {

		try {		

			switch(playerNameHighScore.size()) {
			case 0:
				break;

			case 1: 
				if(FirstPlace != null && FirstPlace.getText().isEmpty()) {
					FirstPlace.setText(playerNameHighScore.get(0));
					FirstScore.setText(Integer.toString(playerHighScore.get(0)));
				}
				break;

			case 2: 
				FirstPlace.setText(playerNameHighScore.get(0));
				FirstScore.setText(Integer.toString(playerHighScore.get(0)));
				SecondPlace.setText(playerNameHighScore.get(1));
				SecondScore.setText(Integer.toString(playerHighScore.get(1)));
				break;		

			case 3: 
				FirstPlace.setText(playerNameHighScore.get(0));
				FirstScore.setText(Integer.toString(playerHighScore.get(0)));
				SecondPlace.setText(playerNameHighScore.get(1));
				SecondScore.setText(Integer.toString(playerHighScore.get(1)));
				ThirdPlace.setText(playerNameHighScore.get(2));
				ThirdScore.setText(Integer.toString(playerHighScore.get(2)));
				break;

			case 4: 
				FirstPlace.setText(playerNameHighScore.get(0));
				FirstScore.setText(Integer.toString(playerHighScore.get(0)));
				SecondPlace.setText(playerNameHighScore.get(1));
				SecondScore.setText(Integer.toString(playerHighScore.get(1)));
				ThirdPlace.setText(playerNameHighScore.get(2));
				ThirdScore.setText(Integer.toString(playerHighScore.get(2)));
				FourthPlace.setText(playerNameHighScore.get(3));
				FourthScore.setText(Integer.toString(playerHighScore.get(3)));
				break;

			case 5: 
				FirstPlace.setText(playerNameHighScore.get(0));
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

			default: 
				FirstPlace.setText(playerNameHighScore.get(0));
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

			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * updateHighScores method is used to update the player name and scores when a player beats the score.
	 */

	public void updateHighScores(int score, String name) {

		int i;

		if(!playerHighScore.isEmpty()) {
			for(i = 0; i < playerNameHighScore.size(); i++) {
				if(i > 4) {
					break;
				}
				else if(score > playerHighScore.get(i)) {
					playerHighScore.add(i, score);
					playerNameHighScore.add(i, name);
					break;
				}
				else if(i == playerHighScore.size() - 1) {
					playerHighScore.add(score);
					playerNameHighScore.add(name);
					break;
				}
			}	
		}
		else {
			playerHighScore.add(score);
			playerNameHighScore.add(name);
		}

	}
	
	/*
	 * initialize method is used to save the name and score of the people with the high scores
	 */

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			if(HighScoreController.playerNameHighScore.isEmpty() && HighScoreController.playerHighScore.isEmpty()) {
				FileInputStream name = new FileInputStream("PlayerNames.txt");
				BufferedReader nameBuffer = new BufferedReader(new InputStreamReader(name));
				String nameLine = nameBuffer.readLine();
				while(nameLine != null) {
					playerNameHighScore.add(nameLine);
					nameLine = nameBuffer.readLine();
				}
				nameBuffer.close();

				FileInputStream score = new FileInputStream("PlayerScores.txt");
				BufferedReader scoreBuffer = new BufferedReader(new InputStreamReader(score));
				String scoreLine = scoreBuffer.readLine();
				while(scoreLine != null) {
					playerHighScore.add(Integer.parseInt(scoreLine));
					scoreLine = scoreBuffer.readLine();
				}
				scoreBuffer.close();					
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
