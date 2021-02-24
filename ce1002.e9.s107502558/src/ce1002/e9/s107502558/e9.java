package ce1002.e9.s107502558;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class e9 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage mainStage)throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent root =loader.load();
		MainController mainCrtl = loader.getController();
		Scene mainScene = new Scene(root);
		mainScene.setOnKeyPressed(mainCrtl.OnKeyPressed);
		mainStage.setTitle("Plane");
		mainStage.setScene(mainScene);
		mainStage.show();
		
		
		
	}

}
