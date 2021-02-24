package ce1002.a8.s107502558;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
public class MainController{
	@FXML
	public Pane _Man;
	
	public void up(ActionEvent e) {
		int x = GridPane.getColumnIndex(_Man); // dont put it out from the function
		int y = GridPane.getRowIndex(_Man);
		y-=1;
		x = Math.max(Math.min(x, 4), 0);
		y = Math.max(Math.min(y, 4), 0);
		GridPane.setRowIndex(_Man, y);//return the change
		GridPane.setColumnIndex(_Man, x);
	}

	public void down(ActionEvent e) {
		int x = GridPane.getColumnIndex(_Man);
		int y = GridPane.getRowIndex(_Man);
		y+=1;
		x = Math.max(Math.min(x, 4), 0);
		y = Math.max(Math.min(y, 4), 0);
		GridPane.setRowIndex(_Man, y);
		GridPane.setColumnIndex(_Man, x);
	}

	public void left(ActionEvent e) {
		int x = GridPane.getColumnIndex(_Man);
		int y = GridPane.getRowIndex(_Man);
		x-=1;
		x = Math.max(Math.min(x, 4), 0);
		y = Math.max(Math.min(y, 4), 0);
		GridPane.setRowIndex(_Man, y);
		GridPane.setColumnIndex(_Man, x);
	}

	public void right(ActionEvent e) {
		int x = GridPane.getColumnIndex(_Man);
		int y = GridPane.getRowIndex(_Man);
		x+=1;
		x = Math.max(Math.min(x, 4), 0);
		y = Math.max(Math.min(y, 4), 0);
		GridPane.setRowIndex(_Man, y);
		GridPane.setColumnIndex(_Man, x);
	}
	public EventHandler<KeyEvent> onKeyPressed = (e) -> { // to use keyboard to control
		int x = GridPane.getColumnIndex(_Man);
		int y = GridPane.getRowIndex(_Man);
		
		if (e.getCode() == KeyCode.UP) {
			y -= 1;
		}
		if (e.getCode() == KeyCode.DOWN) {
			y += 1;
		}
		if (e.getCode() == KeyCode.LEFT) {
			x -= 1;
		}
		if (e.getCode() == KeyCode.RIGHT) {
			x += 1;
		}
		x = Math.max(Math.min(x, 4), 0);
		y = Math.max(Math.min(y, 4), 0);
		GridPane.setRowIndex(_Man, y);
		GridPane.setColumnIndex(_Man, x);
	};
}
