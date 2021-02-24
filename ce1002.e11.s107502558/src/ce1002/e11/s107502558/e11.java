
/*
 * Exercise *
 * Course: ce1002
 * Name: 呂旻翰
 * Student ID: 107502558
 */
package ce1002.e11.s107502558;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class e11 extends Application {
	MediaPlayer _player;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO 自動產生的方法 Stub
		Button btn_Play = new Button("Play");
		Button btn_Pause = new Button("Pause");
		Button btn_Stop = new Button("Stop");
		Button btn_Volume_Up = new Button("Volume Up");
		Button btn_Volume_Down = new Button("Volume Down");
		Button btn_Load = new Button("Load");
		btn_Load.setOnAction(e -> {
			try {
				FileChooser fc = new FileChooser();
				ExtensionFilter music_ext_filter = new ExtensionFilter("Music File", "*.mp3", "*.mp4");
				ExtensionFilter all_ext_filter = new ExtensionFilter("All File", "*.*");
				fc.getExtensionFilters().add(music_ext_filter);
				fc.getExtensionFilters().add(all_ext_filter);

				File file = null;
				if ((file = fc.showOpenDialog(primaryStage)) == null)
					return;
				URL url = file.toURI().toURL();
				Media media = new Media(url.toString());
				_player = new MediaPlayer(media);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		});
		btn_Play.setOnAction(e -> {
			if (_player == null)
				return;
			_player.play();

		});
		btn_Stop.setOnAction(e -> {
			if (_player == null)
				return;
			_player.stop();

		});
		btn_Pause.setOnAction(e -> {
			if (_player == null)
				return;

			_player.pause();
			// _player.getVolume();
			// _player.setVolume();
		});
		btn_Volume_Up.setOnAction(e -> {
			if (_player == null)
				return;
			// _player.stop();
			// _player.pause();
			// _player.getVolume();
			_player.setVolume(_player.getVolume() - 0.05);
		});
		btn_Volume_Down.setOnAction(e -> {
			if (_player == null)
				return;
			// _player.play();
			// _player.stop();
			// _player.pause();
			// _player.getVolume();
			_player.setVolume(_player.getVolume() + 0.05);
		});
		VBox vBox = new VBox(btn_Load, btn_Play, btn_Pause, btn_Stop, btn_Volume_Up, btn_Volume_Down);
		vBox.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

		Scene scene = new Scene(vBox);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}
}
