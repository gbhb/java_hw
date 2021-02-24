package ce1002.a9.s107502558;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

public class MainController implements Initializable {
	@FXML
	Label _label;
	@FXML
	TextArea _text;
	long m = 0, s = 0, ms = 0, temp1 = 0, temp2 = 0, times = 0;
	// m= ms ;s=second ;m =minute
	Timeline fps = new Timeline(new KeyFrame(Duration.millis(1000 / 100), (e) -> { //dont need to put into initialize method
		ms = System.currentTimeMillis();
		ms = ms - temp1+temp2; //it is a temp to accumulate after press start and pause
		
		_label.setText(String.format("%02d:%02d.%03d", ms/1000/60,ms/1000%60,ms%1000));
	}));

	public void start(ActionEvent e) {
		temp1 = System.currentTimeMillis();
		temp2=ms;
		fps.play();

	}

	public void pause(ActionEvent e) {
		temp2=ms;
		fps.pause();
	}

	public void reset(ActionEvent e) {
		fps.pause();
		_label.setText("00:00.000");
		ms = 0;
		s = 0;
		m = 0;
		temp2=0;
		_text.setText("");//clear the textarea
	}

	public void record(ActionEvent e) {
		_text.setText(_text.getText() + "\n" + _label.getText());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		fps.setCycleCount(Timeline.INDEFINITE);
	}

}