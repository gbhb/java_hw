package project;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.application.Application;

public class MainController {
	public void onStartPressed(ActionEvent e) throws Exception{
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("game.fxml"));
		Parent game = loadder.load();
		Scene gameScene = new Scene(game);
		GameController gameCtrl = loadder.getController();
		Project.mainStage.setScene(gameScene);
		AudioClip plonkSound = new AudioClip(getClass().getResource("hope.mp3").toURI().toString());
		plonkSound.play();
		final Alert alert = new Alert(AlertType.INFORMATION); // 實體化Alert對話框物件，並直接在建構子設定對話框的訊息類型
		alert.setTitle("monika"); //設定對話框視窗的標題列文字
		alert.setHeaderText("小提示:"); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
		alert.setContentText("請把你最愛的人留到最後。"); //設定對話框的訊息文字
		alert.showAndWait(); //顯示對話框，並等待對話框被關閉時才繼續執行之後的程式
		
	}

	public void onExitPressed(ActionEvent e) {
		Project.mainStage.close();
	}
}
