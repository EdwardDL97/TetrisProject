// Group 1 Team Tetris
package application;

import java.io.File;	

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.Node;

/*
 * The SettingsController class functionality is used to make changes. In the settings screen, player
 * can choose between three soundtracks, change difficulty, go back to main menu, and exit game
 */

public class SettingsController extends Tetris{

	@FXML private javafx.scene.control.Button exitButton; // This button is used to exit the game
	MediaPlayer newSong;


	public static int speed = 900;
	
	/*
	 * firstTrack method is used to play tetris-gameboy-03.mp3. If another track is playing,
	 * then it will stop the original track, else it will just play the track.
	 */

	@FXML
	public void firstTrack(ActionEvent event){
		if(newSong != null)
			newSong.stop();
		String path = new File("src/soundtracks/tetris-gameboy-01.mp3").getAbsolutePath();
		Media media = new Media(new File(path).toURI().toString());
		newSong = new MediaPlayer(media);
		newSong.setCycleCount(MediaPlayer.INDEFINITE);
		newSong.setVolume(0.3);
		newSong.play();
	}
	
	/*
	 * secondTrack method is used to play 01 - continuum.mp3. If another track is playing,
	 * then it will stop the original track, else it will just play the track.
	 */

	@FXML
	public void secondTrack(ActionEvent event){
		if(newSong != null)
			newSong.stop();
		String path = new File("src/soundtracks/01 - continuum.mp3").getAbsolutePath();
		Media media = new Media(new File(path).toURI().toString());
		newSong = new MediaPlayer(media);
		newSong.setCycleCount(MediaPlayer.INDEFINITE);
		newSong.setVolume(0.3);
		newSong.play();
	}
	
	/*
	 * thirdTrack method is used to play 02. Game Theme.mp3. If another track is playing,
	 * then it will stop the original track, else it will just play the track.
	 */

	@FXML
	public void thirdTrack(ActionEvent event){
		if(newSong != null)
			newSong.stop();
		String path = new File("src/soundtracks/02. Game Theme.mp3").getAbsolutePath();
		Media media = new Media(new File(path).toURI().toString());
		newSong = new MediaPlayer(media);
		newSong.setCycleCount(MediaPlayer.INDEFINITE);
		newSong.setVolume(0.3);
		newSong.play();
		//	oldSong = newSong;
	}

	// easyMode method changes the speed to set the difficulty
	@FXML
	public void easyMode(){
		new Alert(Alert.AlertType.CONFIRMATION, "baby mode activated").show(); // alert to show difficulty has changed to easy
		speed = 500;


	}


	// hardMode method changes the speed to set the difficulty
	@FXML
	public void hardMode(){
		new Alert(Alert.AlertType.CONFIRMATION, "Get ready for HELL").show(); // alert to show difficulty has changed to hard
		speed = 150;


	}
	
	// getSpeed construct is used to get the speed and return it to Tetris.java
	public static int getSpeed(){
		return speed;
	}
	
	/*
	 * toMain method is a method to transition screens from the settings scene to the main menu scene
	 */

	@FXML
	public void toMain(ActionEvent event){
		try {
			Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene main = new Scene(pane,1200,750);
			mainStage.setScene(main);
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * exitGame method is used to save all the player names and scores and then close out of the screen
	 */
	@FXML
	public void exitGame(){
		HighScoreController.saveScores("PlayerScores.txt", HighScoreController.playerHighScore);
		HighScoreController.saveNames("PlayerNames.txt", HighScoreController.playerNameHighScore);
		Stage stage = (Stage) exitButton.getScene().getWindow();
		stage.close();
	}

}
