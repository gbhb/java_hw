/*
 * Assignment 8
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.a8.s107502558;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class a8 extends Application {
	public static Stage mainStage;// for all window to control and it is a empty body
	public static Scene mainScene;
	
	@Override
	public void start(Stage mainStage) throws IOException {
		a8.mainStage = mainStage;
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent main = loadder.load();
		MainController mainCtrl = loadder.getController();
		mainScene = new Scene(main);
		mainScene.setOnKeyPressed(mainCtrl.onKeyPressed); // to register keyboard control
		a8.mainStage.setScene(mainScene); //return the set
		mainStage.setTitle("Ball");
		mainStage.setScene(mainScene);
		mainStage.show();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
