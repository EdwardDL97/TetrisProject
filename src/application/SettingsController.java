package application;

import java.io.File;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;

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
		String path = new File("src/soundtracks/Tetris.mp3").getAbsolutePath();
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
		
		speed = 900;
		
		
	}
	
	
	
	@FXML
	public void hardMode(){
	
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
		Stage stage = (Stage) exitButton.getScene().getWindow();
		stage.close();
	}

}
