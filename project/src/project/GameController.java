package project;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameController {
	@FXML
	public GridPane grid;
	@FXML
	public Button next;
	@FXML
	public Button stop;
	@FXML
	public Button brother;
	@FXML
	public ImageView zero;
	@FXML
	public ImageView one;
	@FXML
	public ImageView two;
	@FXML
	public ImageView three;
	@FXML
	public ImageView four;
	@FXML
	public ImageView five;
	@FXML
	public ImageView six;
	@FXML
	public ImageView seven;
	@FXML
	public ImageView p0;
	@FXML
	public ImageView p1;
	@FXML
	public ImageView p2;
	@FXML
	public ImageView p3;
	@FXML
	public ImageView p4;
	@FXML
	public ImageView p5;
	@FXML
	public ImageView p6;
	@FXML
	public ImageView p7;

	public void stop() {
		if (last == 0 || last == 6) {
			p0.setVisible(false);
			p6.setVisible(false);
		}
		if (last == 1 || last == 4) {
			p1.setVisible(false);
			p4.setVisible(false);
		}
		if (last == 2 || last == 5) {
			p2.setVisible(false);
			p5.setVisible(false);
		}
		if (last == 3 || last == 7) {
			p3.setVisible(false);
			p7.setVisible(false);
		}
		if (all == 0) {
			grid.setVisible(false);
			next.setVisible(true);
			stop.setVisible(true);
			brother.setVisible(true);
		}
	}

	public void cover(int last) {
		if (last == 0) {
			zero.setVisible(true);
		}
		if (last == 1) {
			one.setVisible(true);
		}
		if (last == 2) {
			two.setVisible(true);
		}
		if (last == 3) {
			three.setVisible(true);
		}
		if (last == 4) {
			four.setVisible(true);
		}
		if (last == 5) {
			five.setVisible(true);
		}
		if (last == 6) {
			six.setVisible(true);
		}
		if (last == 7) {
			seven.setVisible(true);
		}
		if (now == 0) {
			zero.setVisible(true);
		}
		if (now == 1) {
			one.setVisible(true);
		}
		if (now == 2) {
			two.setVisible(true);
		}
		if (now == 3) {
			three.setVisible(true);
		}
		if (now == 4) {
			four.setVisible(true);
		}
		if (now == 5) {
			five.setVisible(true);
		}
		if (now == 6) {
			six.setVisible(true);
		}
		if (now == 7) {
			seven.setVisible(true);
		}
	}

	int times = 0, last = -1, key, all = 4, now = -1, detect = 0;
	Timeline timey = new Timeline(new KeyFrame(Duration.seconds(0.15), e -> stop()));
	Timeline timen = new Timeline(new KeyFrame(Duration.seconds(0.15), e -> cover(last)));
	@FXML
	private void _stop() throws ClassNotFoundException, URISyntaxException, IOException {
		AudioClip plonkSound = new AudioClip(getClass().getResource("DokiDoki.mp3").toURI().toString());
		plonkSound.stop();
	}
	@FXML
	public void brother() throws ClassNotFoundException,URISyntaxException {
		AudioClip plonkSound = new AudioClip(getClass().getResource("brother.mp3").toURI().toString());
		plonkSound.play();
	}

	@FXML
	private void _next() throws ClassNotFoundException, URISyntaxException, IOException {
		final Alert alert = new Alert(AlertType.INFORMATION); // �����Alert��ܮت���A�ê����b�غc�l�]�w��ܮت��T������
		alert.setTitle("monika"); // �]�w��ܮص��������D�C��r
		alert.setHeaderText("����:"); // �]�w��ܮص����̪����Y��r�C�Y�]���Ŧr��A�h��ܵL���Y
		alert.setContentText("�{�b�A���Ӫ��D�n��򰵤F�a ���n����F��C"); // �]�w��ܮت��T����r
		alert.showAndWait(); // ��ܹ�ܮءA�õ��ݹ�ܮسQ�����ɤ~�~����椧�᪺�{��
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("game2.fxml"));
		Parent game2 = loadder.load();
		Scene gameScene2 = new Scene(game2);
		GameController2 gameCtrl = loadder.getController();
		Project.mainStage.setScene(gameScene2);
		AudioClip plonkSound = new AudioClip(getClass().getResource("DokiDoki.mp3").toURI().toString());
		plonkSound.stop();
		AudioClip plonkSound2 = new AudioClip(getClass().getResource("bgm2.mp3").toURI().toString());
		plonkSound2.play();
	}
	@FXML
	private void touch1() throws ClassNotFoundException, URISyntaxException {
		AudioClip plonkSound = new AudioClip(getClass().getResource("wumum.mp3").toURI().toString());
		plonkSound.play();
	}
	@FXML
	private void zero() throws ClassNotFoundException {
		try {
			if (zero.isVisible()) {

				if (times == 1) {
					times = 0;
					now = 0;
					zero.setVisible(false);
					if (last == 6) {
						all--;
						timey.setCycleCount(1);
						timey.play();

					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					zero.setVisible(false);
					last = 0;
					times++;
				}
			}
		} catch (Exception e) {
		}
	}

	@FXML
	private void one() throws ClassNotFoundException {
		try {
			if (one.isVisible()) {

				if (times == 1) {
					times = 0;
					now = 1;
					one.setVisible(false);
					if (last == 4) {
						all--;
						timey.setCycleCount(1);
						timey.play();

					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					one.setVisible(false);
					last = 1;
					times++;
				}
			}
		} catch (Exception e) {
		}
	}

	@FXML
	private void two() throws ClassNotFoundException {
		try {
			if (two.isVisible()) {
				if (times == 1) {
					times = 0;
					now = 2;
					two.setVisible(false);
					if (last == 5) {
						all--;
						timey.setCycleCount(1);
						timey.play();

					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					last = 2;
					two.setVisible(false);
					times++;
				}
			}
		} catch (Exception e) {
		}
	}

	@FXML
	private void three() throws ClassNotFoundException {
		try {
			if (three.isVisible()) {
				if (times == 1) {
					times = 0;
					now = 3;
					three.setVisible(false);
					if (last == 7) {
						all--;
						timey.setCycleCount(1);
						timey.play();

					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					three.setVisible(false);
					last = 3;
					times++;
				}
			}
		} catch (Exception e) {
		}
	}

	@FXML
	private void four() throws ClassNotFoundException {

		try {
			if (four.isVisible()) {

				if (times == 1) {
					times = 0;
					now = 4;
					four.setVisible(false);
					if (last == 1) {
						all--;
						timey.setCycleCount(1);
						timey.play();

					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					four.setVisible(false);

					last = 4;
					times++;
				}
			}
		} catch (Exception e) {
		}
	}

	@FXML
	private void five() throws ClassNotFoundException {

		try {
			if (five.isVisible()) {

				if (times == 1) {
					times = 0;
					now = 5;
					five.setVisible(false);
					if (last == 2) {
						all--;
						timey.setCycleCount(1);
						timey.play();

					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					five.setVisible(false);

					last = 5;
					times++;
				}
			}
		} catch (Exception e) {
		}
	}

	@FXML
	private void six() throws ClassNotFoundException {

		try {
			if (six.isVisible()) {

				if (times == 1) {
					times = 0;
					now = 6;
					six.setVisible(false);
					if (last == 0) {
						all--;
						timey.setCycleCount(1);
						timey.play();

					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					six.setVisible(false);

					last = 6;
					times++;
				}
			}
		} catch (Exception e) {
		}
	}

	@FXML
	private void seven() throws ClassNotFoundException {

		try {
			if (seven.isVisible()) {

				if (times == 1) {
					times = 0;
					now = 7;
					seven.setVisible(false);
					if (last == 3) {
						all--;
						timey.setCycleCount(1);
						timey.play();

					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					seven.setVisible(false);

					last = 7;
					times++;
				}
			}
		} catch (Exception e) {
		}
	}

}
