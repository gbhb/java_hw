package ce1002.e8.s107502558;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class MazeController {
	@FXML
	public Pane _Man;
	@FXML
	public Pane _Exit;
	@FXML
	public Label _SuccessText;
	@FXML
	public Button _ReturnBtn;
	public EventHandler<KeyEvent> onKeyPressed = (e) -> {
		int x = GridPane.getColumnIndex(_Man);
		int y = GridPane.getRowIndex(_Man);
		int exit_x = GridPane.getColumnIndex(_Exit);
		int exit_y = GridPane.getRowIndex(_Exit);
		if (x == exit_x && y == exit_y)
			return;
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
		x = Math.max(Math.min(x, 8), 1);
		y = Math.max(Math.min(y, 8), 1);
		GridPane.setRowIndex(_Man, y);
		GridPane.setColumnIndex(_Man, x);
		if (x == exit_x && y == exit_y) {
		    _SuccessText.setVisible(true);
		    _ReturnBtn.setFocusTraversable(false);
		    _ReturnBtn.setVisible(true);
		}
	};
	public void onBackPressed(ActionEvent e) {
	    e8.mainStage.setScene(e8.mainScene);
	}
}
