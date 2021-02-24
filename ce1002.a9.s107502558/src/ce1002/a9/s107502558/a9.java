package ce1002.a9.s107502558;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class a9 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage mainStage)throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent root =loader.load();
		Scene mainScene = new Scene(root);
		mainStage.setTitle("Timer");
		mainStage.setScene(mainScene);
		mainStage.show();
		
	}
	
	
}
