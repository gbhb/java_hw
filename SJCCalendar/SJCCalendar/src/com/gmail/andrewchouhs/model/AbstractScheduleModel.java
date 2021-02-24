package com.gmail.andrewchouhs.model;

import java.time.LocalDateTime;

import com.gmail.andrewchouhs.storage.Storage;
import com.gmail.andrewchouhs.storage.Storage.Text;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public abstract class AbstractScheduleModel
{
	//銋迂銝�閬� abstract
	private ObjectProperty<LocalDateTime> startDateTimeProperty = new SimpleObjectProperty<LocalDateTime>();
	private ObjectProperty<LocalDateTime> endDateTimeProperty = new SimpleObjectProperty<LocalDateTime>();
	private StringProperty nameProperty = new SimpleStringProperty(Storage.text(Text.Schedule));
	private BooleanProperty isDoneProperty = new SimpleBooleanProperty(false);
	private ObjectProperty<Color> colorProperty = new SimpleObjectProperty<Color>(Color.RED);
	public boolean isOnSchedule(LocalDateTime localDateTime)
	{
		if((localDateTime.isAfter(startDateTimeProperty.get()) && localDateTime.isBefore(endDateTimeProperty.get())) 
				|| (localDateTime.isEqual(startDateTimeProperty.get()) && localDateTime.isEqual(endDateTimeProperty.get())))
			return true;
		return false;
	}
	
	public ObjectProperty<LocalDateTime> getStartDateTimeProperty()
	{
		return startDateTimeProperty;
	}
	public ObjectProperty<LocalDateTime> getEndDateTimeProperty()
	{
		return endDateTimeProperty;
	}
	public BooleanProperty getIsDoneProperty()
	{
		return isDoneProperty;
	}
	public ObjectProperty<Color> getColorProperty()
	{
		return colorProperty;
	}
	
	public StringProperty getNameProperty()
	{
		return nameProperty;
	}
	public abstract int getPriority();
}
