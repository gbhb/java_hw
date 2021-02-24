package com.gmail.andrewchouhs.model;

import java.time.LocalDateTime;

public class LongTermSchedule extends AbstractScheduleModel
{
	private final int priority = 2;

	@Override
	public int getPriority()
	{
		return priority;
	}
}
