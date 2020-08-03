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

public class SettingsController extends Tetris{

	@FXML private javafx.scene.control.Button exitButton;
	MediaPlayer newSong;


	public static int speed = 900;

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
		//	newSong = newSong;
	}

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
		//	oldSong = newSong;
	}

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

	@FXML
	public void easyMode(){
		new Alert(Alert.AlertType.CONFIRMATION, "baby mode activated").show();
		speed = 500;


	}



	@FXML
	public void hardMode(){
		new Alert(Alert.AlertType.CONFIRMATION, "Get ready for HELL").show();
		speed = 150;


	}

	public static int getSpeed(){
		return speed;
	}

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

	@FXML
	public void exitGame(){
		HighScoreController.saveScores("PlayerScores.txt", HighScoreController.playerHighScore);
		HighScoreController.saveNames("PlayerNames.txt", HighScoreController.playerNameHighScore);
		Stage stage = (Stage) exitButton.getScene().getWindow();
		stage.close();
	}

}
