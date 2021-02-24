package com.gmail.andrewchouhs.model;

import java.time.LocalDateTime;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class RoutineSchedule extends AbstractScheduleModel
{
	// 以課表舉例 有時段性的 根據設定的時段直接對localDateTime比較 星期幾用list存 先不要做太複雜的
	//或者應該使用一個工廠模式產出固定的 RoutineSchedule 
	private final int priority = 1;

	@Override
	public int getPriority()
	{
		return priority;
	}
	@Override
	public boolean isOnSchedule(LocalDateTime localDateTime)
	{
		if(super.isOnSchedule(localDateTime))
		{
			
			return true;
		}
		return false;
	}
}
