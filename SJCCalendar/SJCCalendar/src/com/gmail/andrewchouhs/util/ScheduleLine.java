package com.gmail.andrewchouhs.util;

import com.gmail.andrewchouhs.model.AbstractScheduleModel;
import javafx.scene.shape.Rectangle;

public class ScheduleLine extends Rectangle
{
	private AbstractScheduleModel model;
	
	public ScheduleLine (AbstractScheduleModel model)
	{
		this.model = model;
	}
	
	public void setModel(AbstractScheduleModel model)
	{
		this.model = model;
	}
	
	public AbstractScheduleModel getModel()
	{
		return model;
	}
}
