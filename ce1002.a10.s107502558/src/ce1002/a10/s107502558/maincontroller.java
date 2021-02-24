package ce1002.a10.s107502558;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

public class maincontroller {//to resize the textarea plz use anchorpane and set constraints
	@FXML
	TextArea text;
	public void open(ActionEvent e) throws IOException {
		FileChooser fc = new FileChooser();
		File openFile = fc.showOpenDialog(a10.mainStage);
		String openfilepath = openFile.getPath();
		if(openFile!=null) {
			FileInputStream fis = new FileInputStream(openFile.getPath());
			byte[] allByte = fis.readAllBytes();//read all bytes into byte[]
			String content = new String(allByte, "UTF-8");//encode in UTF-8
			text.setText(content);
			a10.mainStage.setTitle(openFile.getName());		// set name to title 
			}
	}
	public void save(ActionEvent e) throws IOException {
		FileChooser fc = new FileChooser();
		File saveFile = fc.showSaveDialog(a10.mainStage);
		String savefilepath = saveFile.getPath();
		if(saveFile!=null) {
			FileOutputStream fos = new FileOutputStream(saveFile.getPath()); // fos if savefile
			fos.write(text.getText().getBytes("UTF-8"));//write the content from text in UTF-8 to fos
			
		}
	}
	public void insert(ActionEvent e) throws IOException {
		Date date =new Date(System.currentTimeMillis());
		DateFormat dd = new SimpleDateFormat("yyyy/MM/dd  aaKK:mm");// aa=am pm KK=hour mm=minute
		text.appendText(dd.format(date));
	}
	
}
