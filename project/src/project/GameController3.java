package project;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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

public class GameController3{
	
	@FXML
	public GridPane grid;
	@FXML
	public Button next;
	@FXML
	public Button next2;
	@FXML
	public Button stop;
	@FXML
	public Button touch1;
	@FXML
	public Button touch2;
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
	public ImageView eight;
	@FXML
	public ImageView nine;
	@FXML
	public ImageView magic;
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
	@FXML
	public ImageView p8;
	@FXML
	public ImageView p9;
	@FXML
	public ImageView yuri;
	@FXML
	public ImageView yurideath;

	public void stop() throws URISyntaxException {
		if (last == 0 || last == 7) {
			p0.setVisible(false);
			p7.setVisible(false);
		}
		if (last == 1 || last == 8) {
			p1.setVisible(false);
			p8.setVisible(false);
		}
		if (last == 2 || last == 4) {
			p2.setVisible(false);
			p4.setVisible(false);
		}
		if (last == 3 || last == 6) {
			p3.setVisible(false);
			p6.setVisible(false);
		}
		if (last == 5 || last == 9) {
			p5.setVisible(false);
			p9.setVisible(false);
		}
		if(all==0) {
			if(key!=1) {
				touch1.setVisible(false);
				touch2.setVisible(false);
				AudioClip plonkSound = new AudioClip(getClass().getResource("scare2.mp3").toURI().toString());
				plonkSound.play();
				grid.setVisible(false);
				next2.setVisible(true);
				stop.setVisible(true);
				yurideath.setVisible(true);
			}else {
			grid.setVisible(false);
			next.setVisible(true);
			stop.setVisible(true);
			}
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
		if (last == 8) {
			eight.setVisible(true);
		}
		if (last == 9) {
			nine.setVisible(true);
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
		if (now == 8) {
			eight.setVisible(true);
		}
		if (now == 9) {
			nine.setVisible(true);
		}
		
	}
	int times = 0, last = -1, key=-1, all = 5, now = -1,detect=0;
	Timeline timey = new Timeline(new KeyFrame(Duration.seconds(0.15), e -> {
		try {
			stop();
		} catch (URISyntaxException e1) {
			// TODO 自動產生的 catch 區塊
			e1.printStackTrace();
		}
	}));
	Timeline timen = new Timeline(new KeyFrame(Duration.seconds(0.15), e -> cover(last)));
	@FXML
	private void _stop() throws ClassNotFoundException, URISyntaxException, IOException {
		AudioClip plonkSound = new AudioClip(getClass().getResource("bgm3.mp3").toURI().toString());
		plonkSound.stop();
	}
	@FXML
	private void magic() throws ClassNotFoundException, URISyntaxException, IOException {
		AudioClip plonkSound = new AudioClip(getClass().getResource("toobad.mp3").toURI().toString());
		plonkSound.play();
		final Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("monika"); //設定對話框視窗的標題列文字
		alert.setHeaderText("哎呀:"); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
		alert.setContentText("被你發現了 \n那我先走了 \n我在結局等你喔 "); //設定對話框的訊息文字
		alert.showAndWait(); //顯示對話框，並等待對話框被關閉時才繼續執行之後的程式
		magic.setVisible(false);
	}
	@FXML
	public void touch1() throws ClassNotFoundException,URISyntaxException {
		AudioClip plonkSound = new AudioClip(getClass().getResource("feelgood.mp3").toURI().toString());
		plonkSound.play();
	}
	@FXML
	public void touch2() throws ClassNotFoundException,URISyntaxException {
		AudioClip plonkSound = new AudioClip(getClass().getResource("godie.mp3").toURI().toString());
		plonkSound.play();
	}
	@FXML
	private void _next() throws ClassNotFoundException, URISyntaxException, IOException {
		AudioClip plonkSound = new AudioClip(getClass().getResource("forever.mp3").toURI().toString());
		plonkSound.play();
		String cmd = "reg add \"HKEY_CURRENT_USER\\Control Panel\\Desktop\" /v Wallpaper /t REG_SZ /d C:\\Users\\msn71\\OneDrive\\桌面\\java-workspace\\project\\src\\project\\cbay2-bykic.bmp /f";
        String cmd2 = "RUNDLL32.EXE user32.dll,UpdatePerUserSystemParameters";
        for(int a=0;a<=10;a++) {
        Runtime.getRuntime().exec( new String[] {"cmd.exe", "/c", cmd} );	
        Runtime.getRuntime().exec( new String[] {"cmd.exe", "/c", cmd2} );
        }
        final Alert alert = new Alert(AlertType.INFORMATION); // 實體化Alert對話框物件，並直接在建構子設定對話框的訊息類型
		alert.setTitle("monika"); //設定對話框視窗的標題列文字
		alert.setHeaderText("恭喜:"); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
		alert.setContentText("我知道你是最愛我的 \n在結束遊戲後 我也準備了一個驚喜給你\n我將繼續陪伴你"); //設定對話框的訊息文字
		alert.showAndWait(); //顯示對話框，並等待對話框被關閉時才繼續執行之後的程式
		
		
		
        Project.mainStage.close();
	}
	@FXML
	private void _next2() throws ClassNotFoundException, URISyntaxException, IOException {
		AudioClip plonkSound = new AudioClip(getClass().getResource("forever.mp3").toURI().toString());
		plonkSound.play();
		String cmd = "reg add \"HKEY_CURRENT_USER\\Control Panel\\Desktop\" /v Wallpaper /t REG_SZ /d C:\\Users\\msn71\\OneDrive\\桌面\\java-workspace\\project\\src\\project\\cbay2-bykic.bmp /f";	
        String cmd2 = "RUNDLL32.EXE user32.dll,UpdatePerUserSystemParameters";
        for(int a=0;a<=10;a++) {
            Runtime.getRuntime().exec( new String[] {"cmd.exe", "/c", cmd} );	
            Runtime.getRuntime().exec( new String[] {"cmd.exe", "/c", cmd2} );
            }
		final Alert alert = new Alert(AlertType.INFORMATION); // 實體化Alert對話框物件，並直接在建構子設定對話框的訊息類型
		alert.setTitle("monika"); //設定對話框視窗的標題列文字
		alert.setHeaderText("節哀:"); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
		alert.setContentText("你可能只是不小心選錯 \n但我知道你還是愛我的 \n遊戲已經到了尾聲\n但我還是會繼續陪伴你"); //設定對話框的訊息文字
		alert.showAndWait(); //顯示對話框，並等待對話框被關閉時才繼續執行之後的程式
		
		
		
        Project.mainStage.close();
	}
	@FXML
	private void zero() throws ClassNotFoundException {
		try {
			if (zero.isVisible()) {

				if (times == 1) {
					times = 0;
					now = 0;
					zero.setVisible(false);
					if (last == 7) {
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
					if (last == 8) {
						all--;
						key=0;
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
					if (last == 4) {
						all--;
						key=0;

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
					if (last == 6) {
						all--;
						key=0;
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
					if (last == 2) {
						all--;
						key=0;
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
					if (last == 9) {
						all--;
						key=1;
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
					if (last == 3) {
						all--;
						key=0;
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
					if (last == 0) {
						all--;
						key=0;
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
	@FXML
	private void eight() throws ClassNotFoundException {

		try {
			if (eight.isVisible()) {

				if (times == 1) {
					times = 0;
					now = 8;
					eight.setVisible(false);
					if (last == 1) {
						all--;
						key=0;
						timey.setCycleCount(1);
						timey.play();

						
					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					eight.setVisible(false);

					last = 8;
					times++;
				}
			}
		} catch (Exception e) {
		}
	}
	@FXML
	private void nine() throws ClassNotFoundException {

		try {
			if (nine.isVisible()) {

				if (times == 1) {
					times = 0;
					now = 9;
					nine.setVisible(false);
					if (last == 5) {
						all--;
						key=1;
						timey.setCycleCount(1);
						timey.play();

						
					} else {
						timen.setCycleCount(1);
						timen.play();
					}
				} else {
					nine.setVisible(false);

					last = 9;
					times++;
				}
			}
		} catch (Exception e) {
		}
	}
	
}
