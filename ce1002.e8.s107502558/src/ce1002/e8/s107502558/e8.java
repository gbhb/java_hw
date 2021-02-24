/*
 * Exercise 8
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.e8.s107502558;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class e8 extends Application {
	public static Stage mainStage;
	public static Scene mainScene;

	@Override
	public void start(Stage mainStage) throws Exception {
		e8.mainStage = mainStage;
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent main = loadder.load();
		mainScene = new Scene(main);
		mainStage.setTitle("Walk To Exit");
		mainStage.setScene(mainScene);
		mainStage.show();
	}

	

	public static void main(String[] args) {
		launch(args);
	}
}
