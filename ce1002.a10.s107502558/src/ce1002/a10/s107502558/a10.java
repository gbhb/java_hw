/*
 * Assignment 10
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.a10.s107502558;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class a10 extends Application{
	public static Stage mainStage;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage mainStage) throws Exception{
		this.mainStage=mainStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent root =loader.load();
		Scene mainScene = new Scene(root);
		mainStage.setTitle("e10");
		mainStage.setScene(mainScene);
		mainStage.show();
		
	}

}
