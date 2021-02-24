/*
 * Assignment 7
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.a7.s107502558;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class a7 extends Application {
		@Override 
	    public void start(Stage primaryStage) throws Exception{
	        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
	        primaryStage.setTitle("yuri");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	    }
	    public static void main(String[] args) {
	        launch(args);
	    }

}
