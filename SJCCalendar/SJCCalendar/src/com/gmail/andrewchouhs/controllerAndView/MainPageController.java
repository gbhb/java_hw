package com.gmail.andrewchouhs.controllerAndView;

import java.time.LocalDateTime;
import com.gmail.andrewchouhs.model.UrgentSchedule;
import com.gmail.andrewchouhs.storage.Storage;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

public class MainPageController
{
	@FXML
	private void addScheduleButton()
	{
		UrgentSchedule schedule = new UrgentSchedule();
		schedule.getStartDateTimeProperty().set(LocalDateTime.now());
		schedule.getEndDateTimeProperty().set(LocalDateTime.now().plusHours(1));
		ScheduleEditingStage.callStage(schedule);
	}
	
	@FXML
	private void showSettingsPage()
	{
		SettingsStage.callStage();
	}
	
	@FXML
	private void scaleUp()
	{
		Storage.setRowCount(Storage.getRowCountProperty().get() - 1);
	}
	
	@FXML
	private void scaleDown()
	{
		Storage.setRowCount(Storage.getRowCountProperty().get() + 1);
	}
	
	@FXML
	private void moveUp()
	{
		Storage.adjustNowTime(-1);
	}
	
	@FXML
	private void moveDown()
	{
		Storage.adjustNowTime(1);
	}
}
