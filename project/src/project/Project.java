package project;

import java.io.IOException;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;

public class Project extends Application {
	public static Stage mainStage;
	public static Scene mainScene;

	@Override

	public void start(Stage mainStage) throws Exception {
		
		Project.mainStage = mainStage;
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent main = loadder.load();

		mainScene = new Scene(main);

		mainStage.setTitle("just monika");
		mainStage.setScene(mainScene);
		mainStage.show();
		AudioClip plonkSound = new AudioClip(getClass().getResource("DokiDoki.mp3").toURI().toString());
		plonkSound.play();
	}
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		try{
			try {
			Runtime.getRuntime().exec("notepad");
			} catch (IOException e) {
			e.printStackTrace();
			}
			Robot rb=new Robot();
			rb.setAutoDelay(200);
			rb.keyRelease(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_I);
			rb.keyPress(KeyEvent.VK_SPACE);
			rb.keyPress(KeyEvent.VK_L);
			rb.keyPress(KeyEvent.VK_O);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_E);
			rb.keyPress(KeyEvent.VK_SPACE);
			rb.keyPress(KeyEvent.VK_Y);
			rb.keyPress(KeyEvent.VK_O);
			rb.keyPress(KeyEvent.VK_U);
			rb.keyPress(KeyEvent.VK_COMMA);
			rb.keyPress(KeyEvent.VK_B);
			rb.keyPress(KeyEvent.VK_Y);
			rb.keyPress(KeyEvent.VK_SPACE);
			rb.keyPress(KeyEvent.VK_M);
			rb.keyPress(KeyEvent.VK_O);
			rb.keyPress(KeyEvent.VK_N);
			rb.keyPress(KeyEvent.VK_I);
			rb.keyPress(KeyEvent.VK_K);
			rb.keyPress(KeyEvent.VK_A);
			} catch (AWTException e){
			e.printStackTrace();
			}
		launch(args);
	}

}
