// Group 1 Team Tetris
package application;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

/*
 * Main Class is used to launch the game tetris. 
 * The game starts by opening the menu screen where the player can go to start, settings, high scores, and exit
 */

public class Main extends Application {
	
	/*
	 * Start method creates the main menu screen where the player can navigate through the game
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,1200,750);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("T E A M    T E T R I S");
			primaryStage.show();
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent event) {
					HighScoreController.saveScores("PlayerScores.txt", HighScoreController.playerHighScore);
					HighScoreController.saveNames("PlayerNames.txt", HighScoreController.playerNameHighScore);
				};
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/*
	 * main method launches the program 
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
