package com.gmail.andrewchouhs.controllerAndView;

import java.util.ResourceBundle;
import com.gmail.andrewchouhs.Main;
import com.gmail.andrewchouhs.model.AbstractScheduleModel;
import com.gmail.andrewchouhs.storage.Storage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ScheduleEditingStage
{
	private static Stage stage;
	private static ScheduleEditingPageController controller;
	private ScheduleEditingStage()
	{
	}
	
	public static void callStage(AbstractScheduleModel model)
	{
		if(stage == null)
		{
			try
			{
				stage = new Stage();
				FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("controllerAndView/ScheduleEditingPage.fxml"),Storage.getBundle());
				stage.setScene(new Scene(fxmlLoader.load()));
				controller = (ScheduleEditingPageController) fxmlLoader.getController();
				stage.initOwner(Main.getMainStage());
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setResizable(false);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(stage.isShowing())
		{
			stage.requestFocus();
		}
		else
		{
			controller.refreshInformation(model);
			stage.show();
		}
	}
	
	public static void closeStage()
	{
		stage.hide();
	}
}
