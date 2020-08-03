// Group 1 Team Tetris
package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;	
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * The MainController class functionality is used for switching screens. Both PlayerMode.fxml and Main.fxml use this controller to switch 
 * between settings, high scores, player mode, tetris game, and exiting.
 */

public class MainController implements Initializable {

	@FXML private javafx.scene.control.Button closeButton; // Button set to close window
	@FXML private TextField playerName;
	public static String name;
	
	/*
	 * readName method reads and stores the player's name into a string that is used for high scores.
	 */

	public void readName(ActionEvent e) {
		name = playerName.getText();
		new Alert(Alert.AlertType.CONFIRMATION, "Name Saved!").show();
	}

	/*
	 * closeButtonAction is a method to close the window when the exit button is pressed
	 */

	@FXML
	private void closeButtonAction() {
		HighScoreController.saveScores("PlayerScores.txt", HighScoreController.playerHighScore);
		HighScoreController.saveNames("PlayerNames.txt", HighScoreController.playerNameHighScore);
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	/*
	 * displayHighScores method has a parameter ActionEvent called event.
	 * This method is used to switch from the Main Menu to the High Score screen.
	 */

	@FXML
	public void displayHighScores(ActionEvent event) {

		try {
			Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("HighScores.fxml"));
			Parent root = loader.load();
			HighScoreController highscore = loader.getController();
			highscore.highScores();
			stage.getScene().setRoot(root);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * displaySettings method has a parameter ActionEvent called event.
	 * This method is used to switch from the Main Menu to the Settings screen.
	 */

	@FXML
	public void displaySettings(ActionEvent event) {

		try {
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane settings = (AnchorPane)FXMLLoader.load(getClass().getResource("Settings.fxml"));
			Scene settingScreen = new Scene(settings,1200,750);
			mainStage.setScene(settingScreen);
			mainStage.setTitle("T E A M    T E T R I S");
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * displayGame method has a parameter ActionEvent called event.
	 * This method is used to switch from the Main Menu to the Select Players screen.
	 */

	@FXML
	public void displayGame(ActionEvent event) {

		try {
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane select = (AnchorPane)FXMLLoader.load(getClass().getResource("PlayerMode.fxml"));
			Scene selectScreen = new Scene(select,1200,750);
			mainStage.setScene(selectScreen);
			mainStage.setTitle("T E A M    T E T R I S");
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * displayMenu method has a parameter ActionEvent called event.
	 * This method is used to switch from the Select Mode screen back to the Main Menu.
	 */

	@FXML
	public void displayMenu(ActionEvent event) {

		try {
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane menu = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene mainMenu = new Scene(menu,1200,750);
			mainStage.setScene(mainMenu);
			mainStage.setTitle("T E A M    T E T R I S");
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * startGame method has a parameter ActionEvent called event.
	 * This method is used to switch from the Select Mode screen to the actual Tetris game.
	 */

	public void startGame(ActionEvent event) {
		try {
			Tetris t = new Tetris();
			Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			t.start(currStage);
		}
		catch(Exception e) {
			e.printStackTrace();
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
					HighScoreController.playerNameHighScore.add(nameLine);
					nameLine = nameBuffer.readLine();
				}
				nameBuffer.close();

				FileInputStream score = new FileInputStream("PlayerScores.txt");
				BufferedReader scoreBuffer = new BufferedReader(new InputStreamReader(score));
				String scoreLine = scoreBuffer.readLine();
				while(scoreLine != null) {
					HighScoreController.playerHighScore.add(Integer.parseInt(scoreLine));
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
