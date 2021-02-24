package ce1002.e8.s107502558;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class MainController {
	public void onStartPressed(ActionEvent e) throws Exception{
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("Maze.fxml"));
		Parent maze = loadder.load();
		Scene mazeScene = new Scene(maze);
		MazeController mazeCtrl = loadder.getController();
		mazeScene.setOnKeyPressed(mazeCtrl.onKeyPressed);
		e8.mainStage.setScene(mazeScene);

	}

	public void onExitPressed(ActionEvent e) {
		e8.mainStage.close();
	}

}
