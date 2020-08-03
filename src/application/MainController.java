package application;

import javafx.event.ActionEvent;	
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * The MainController class functionality is used for switching screens. Both PlayerMode.fxml and Main.fxml use this controller to switch 
 * between settings, high scores, player mode, tetris game, and exiting.
 */

public class MainController {

	@FXML private javafx.scene.control.Button closeButton; // Button set to close window

	/*
	 * closeButtonAction is a method to close the window when the exit button is pressed
	 */

	@FXML
	private void closeButtonAction() {
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
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane scores = (AnchorPane)FXMLLoader.load(getClass().getResource("HighScores.fxml"));
			Scene highScore = new Scene(scores,1200,750);
			mainStage.setTitle("T E A M    T E T R I S");
			mainStage.setScene(highScore);
			mainStage.show();
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
}
