package com.gmail.andrewchouhs.controllerAndView;

import com.gmail.andrewchouhs.Main;
import com.gmail.andrewchouhs.model.AbstractScheduleModel;
import com.gmail.andrewchouhs.storage.Storage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SettingsStage
{
	private static Stage stage;
	private static SettingsPageController controller;
	private SettingsStage()
	{
	}
	
	public static void callStage()
	{
		if(stage == null)
		{
			try
			{
				stage = new Stage();
				FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("controllerAndView/SettingsPage.fxml"),Storage.getBundle());
				stage.setScene(new Scene(fxmlLoader.load()));
				controller = (SettingsPageController) fxmlLoader.getController();
				controller.selectLocale();
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
			stage.show();
		}
	}
	
	public static void closeStage()
	{
		stage.hide();
	}
}
