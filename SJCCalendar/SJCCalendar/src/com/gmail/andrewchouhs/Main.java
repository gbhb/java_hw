package com.gmail.andrewchouhs;

import java.util.Locale;
import java.util.ResourceBundle;
import com.gmail.andrewchouhs.controllerAndView.MainGridController;
import com.gmail.andrewchouhs.controllerAndView.ScheduleEditingPageController;
import com.gmail.andrewchouhs.storage.Storage;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application
{
	//自動判斷應用程式是否有最新的版本可供更新。
	//i18n。
	private static Stage mainStage;
	private static MainGridController controller;
	@Override
	public void start(Stage stage)
	{
		try
		{
			mainStage = stage;
			BorderPane mainPage = FXMLLoader.load(Main.class.getResource("controllerAndView/MainPage.fxml"), Storage.getBundle());
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("controllerAndView/MainGrid.fxml"), Storage.getBundle());
			AnchorPane mainCalendar = fxmlLoader.load();
			MainGridController controller = (MainGridController) fxmlLoader.getController();
			mainPage.setCenter(mainCalendar);
			stage.setScene(new Scene(mainPage));
			stage.setTitle("SJCCalendar");
			stage.show();
			stage.setOnCloseRequest((e)->
			{
				Storage.savePrefs();
				Storage.saveSchedules();
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
	
	public static Stage getMainStage()
	{
		return mainStage;
	}
}
