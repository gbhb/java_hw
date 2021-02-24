package ce1002.e9.s107502558;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class MainController implements Initializable {
	@FXML
	Pane _field;
	@FXML
	Label _bullet;
	@FXML
	Label _plane;
	LinkedList<Label> _bullets = new LinkedList<Label>();
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Timeline fps = new Timeline(new KeyFrame(Duration.millis(1000/60),(e)-> {
		    ArrayList<Label> tBullets = new ArrayList<Label>(_bullets);
		    for(var b : tBullets) {
		      b.setLayoutX(b.getLayoutX() + 5);
		      if(b.getLayoutX() > _field.getWidth()) {
		          _bullets.remove(b);
		          _field.getChildren().remove(b);
		      }}}));
		  fps.setCycleCount(Timeline.INDEFINITE);
		  fps.play();

	}
	public EventHandler<KeyEvent> OnKeyPressed = (e)->{
		if(e.getCode()==KeyCode.E) {
			 Timeline barrel_roll = new Timeline(
			    new KeyFrame(Duration.millis(1),
			        (ee)-> {
			            _plane.setRotate(_plane.getRotate()+1);
			        }
			        ));
			  barrel_roll.setCycleCount(360);
			  barrel_roll.play();
			}
		if(e.getCode()==KeyCode.W) {
		    _plane.setLayoutY(_plane.getLayoutY()-5);
		}
		if(e.getCode()==KeyCode.A) {
		    _plane.setLayoutX(_plane.getLayoutX()-5);
		}
		if(e.getCode()==KeyCode.S) {
		    _plane.setLayoutY(_plane.getLayoutY()+5);
		}
		if(e.getCode()==KeyCode.D) {
		    _plane.setLayoutX(_plane.getLayoutX()+5);
		}
		if(e.getCode()==KeyCode.SPACE) {
			  Label newBullet = new Label(_bullet.getText());
			  newBullet.setLayoutX(
			    _plane.getLayoutX() + _plane.getWidth());
			  newBullet.setLayoutY(
			    _plane.getLayoutY() +
			    _plane.getHeight() / 2 -
			    _bullet.getHeight() / 2);
			  _bullets.push(newBullet);
			  _field.getChildren().add(newBullet);
			}

	};
}
