
/*
 * Exercise 7
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.e7.s107502558;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class e7 extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
    	Media media = new Media("01.mp3"); //replace /Movies/test.mp3 with your file
        MediaPlayer player = new MediaPlayer(media); 
        player.play();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("yuri");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}
