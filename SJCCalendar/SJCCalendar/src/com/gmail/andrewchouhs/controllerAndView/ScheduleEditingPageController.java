package com.gmail.andrewchouhs.controllerAndView;

import java.time.LocalDateTime;
import java.time.LocalTime;
import com.gmail.andrewchouhs.Main;
import com.gmail.andrewchouhs.model.AbstractScheduleModel;
import com.gmail.andrewchouhs.model.LongTermSchedule;
import com.gmail.andrewchouhs.model.RoutineSchedule;
import com.gmail.andrewchouhs.model.TrivialSchedule;
import com.gmail.andrewchouhs.model.UrgentSchedule;
import com.gmail.andrewchouhs.storage.Storage;
import com.gmail.andrewchouhs.storage.Storage.Text;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class ScheduleEditingPageController
{
	@FXML
	private TextField nameTextField;
	@FXML
	private DatePicker startTimeDatePicker;
	@FXML
	private Spinner<Integer> startTimeHourSpinner;
	@FXML
	private Spinner<Integer> startTimeMinuteSpinner;
	@FXML
	private Spinner<Integer> startTimeSecondSpinner;
	@FXML
	private DatePicker endTimeDatePicker;
	@FXML
	private Spinner<Integer> endTimeHourSpinner;
	@FXML
	private Spinner<Integer> endTimeMinuteSpinner;
	@FXML
	private Spinner<Integer> endTimeSecondSpinner;
	@FXML
	private ChoiceBox<AbstractScheduleModel> scheduleTypeChoiceBox;
	@FXML
	private ColorPicker colorPicker;
	private AbstractScheduleModel currentModel;
	
	@FXML
	private void initialize()
	{
		startTimeHourSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
		        0, 23, 0));
		startTimeMinuteSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
		        0, 59, 0));
		startTimeSecondSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
		        0, 59, 0));
		endTimeHourSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
		        0, 23, 0));
		endTimeMinuteSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
		        0, 59, 0));
		endTimeSecondSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
		        0, 59, 0));
		

		scheduleTypeChoiceBox.setConverter(new StringConverter<AbstractScheduleModel>()
		{
			public AbstractScheduleModel fromString(String string)
			{
				return null;
			}
			public String toString(AbstractScheduleModel model)
			{
				switch(model.getPriority())
				{
					case 0:
						return Storage.text(Text.UrgentSchedule);
					case 1:
						return Storage.text(Text.RoutineSchedule);
					case 2:
						return Storage.text(Text.LongTermSchedule);
					case 3:
						return  Storage.text(Text.TrivialSchedule);
					default:
						return null;
				}
			}
		});
		scheduleTypeChoiceBox.getItems().addAll(new UrgentSchedule()
				, new RoutineSchedule(), new LongTermSchedule(), new TrivialSchedule());
		scheduleTypeChoiceBox.getSelectionModel().selectFirst();
	}
	
	@FXML
	private void okButton()
	{
		Storage.getScheduleList().remove(currentModel);
		switch(scheduleTypeChoiceBox.getValue().getPriority())
		{
			case 0:
				currentModel = new UrgentSchedule();
				break;
			case 1:
				currentModel = new RoutineSchedule();
				break;
			case 2:
				currentModel = new LongTermSchedule();
				break;
			case 3:
				currentModel = new TrivialSchedule();
				break;
		}
		currentModel.getNameProperty().set(nameTextField.getText());
		currentModel.getStartDateTimeProperty().set(
				LocalDateTime.of(startTimeDatePicker.getValue(), 
						LocalTime.of(startTimeHourSpinner.getValue()
								, startTimeMinuteSpinner.getValue(), startTimeSecondSpinner.getValue())));
		currentModel.getEndDateTimeProperty().set(
				LocalDateTime.of(endTimeDatePicker.getValue(), 
						LocalTime.of(endTimeHourSpinner.getValue()
								, endTimeMinuteSpinner.getValue(), endTimeSecondSpinner.getValue())));
		currentModel.getColorProperty().set(colorPicker.getValue());
//		Storage.getScheduleList().add(currentModel);
		ScheduleEditingStage.closeStage();
		Storage.getScheduleList().add(currentModel);
	}
	
	@FXML
	private void cancelButton()
	{
		ScheduleEditingStage.closeStage();
	}
	
	public void refreshInformation(AbstractScheduleModel model)
	{
		currentModel = model;
		nameTextField.setText(model.getNameProperty().get());
		startTimeDatePicker.setValue(model.getStartDateTimeProperty().get().toLocalDate());
		startTimeHourSpinner.getValueFactory().setValue(model.getStartDateTimeProperty().get().getHour());
		startTimeMinuteSpinner.getValueFactory().setValue(model.getStartDateTimeProperty().get().getMinute());
		startTimeSecondSpinner.getValueFactory().setValue(model.getStartDateTimeProperty().get().getSecond());
		endTimeDatePicker.setValue(model.getEndDateTimeProperty().get().toLocalDate());
		endTimeHourSpinner.getValueFactory().setValue(model.getEndDateTimeProperty().get().getHour());
		endTimeMinuteSpinner.getValueFactory().setValue(model.getEndDateTimeProperty().get().getMinute());
		endTimeSecondSpinner.getValueFactory().setValue(model.getEndDateTimeProperty().get().getSecond());
		scheduleTypeChoiceBox.getSelectionModel().select(model.getPriority());

		colorPicker.setValue(model.getColorProperty().get());
		
	}
}
