package com.gmail.andrewchouhs.model;

import java.time.LocalDateTime;

public class TrivialSchedule extends AbstractScheduleModel
{
	private final int priority = 3;

	@Override
	public int getPriority()
	{
		return priority;
	}
}
