package ce1002.e10.s107502558;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class mainController {
	@FXML
	Label name;
	@FXML
	Label score;
	public void onclicked(ActionEvent e) throws IOException {
		FileChooser fc = new FileChooser();

		File openFile = fc.showOpenDialog(e10.mainStage);
		String openfilepath = openFile.getPath();
		if(openFile!=null) {
			FileInputStream fis = new FileInputStream(openFile.getPath());
			byte[] allByte = fis.readAllBytes();
			String content = new String(allByte, "UTF-8");
			String[] contentArr = content.split("\r\n");
			String setText = "Name\n-----\n";
			for(int i=0 ; i<contentArr.length ; i+=2) {
				setText += contentArr[i] + "\n";
			}
			String setText2 = "Score\n-----\n";
			for(int i=1 ; i<contentArr.length ; i+=2) {
				setText2 += contentArr[i] + "\n";
			}
			name.setText(setText);
			score.setText(setText2);
		}
		
	}
}
