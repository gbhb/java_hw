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
		final Alert alert = new Alert(AlertType.INFORMATION); // �����Alert��ܮت���A�ê����b�غc�l�]�w��ܮت��T������
		alert.setTitle("monika"); //�]�w��ܮص��������D�C��r
		alert.setHeaderText("�p����:"); //�]�w��ܮص����̪����Y��r�C�Y�]���Ŧr��A�h��ܵL���Y
		alert.setContentText("�Ч�A�̷R���H�d��̫�C"); //�]�w��ܮت��T����r
		alert.showAndWait(); //��ܹ�ܮءA�õ��ݹ�ܮسQ�����ɤ~�~����椧�᪺�{��
		
	}

	public void onExitPressed(ActionEvent e) {
		Project.mainStage.close();
	}
}
