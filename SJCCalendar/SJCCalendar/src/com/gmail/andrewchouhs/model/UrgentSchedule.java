package com.gmail.andrewchouhs.model;

import java.time.LocalDateTime;

public class UrgentSchedule extends AbstractScheduleModel
{
	private final int priority = 0;

	@Override
	public int getPriority()
	{
		return priority;
	}
}