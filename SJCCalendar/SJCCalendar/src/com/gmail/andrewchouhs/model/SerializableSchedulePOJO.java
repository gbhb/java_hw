package com.gmail.andrewchouhs.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SerializableSchedulePOJO  implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public LocalDateTime startDateTime;
	public LocalDateTime endDateTime;
	public String name;
	public boolean isDone;
	public double colorR;
	public double colorG;
	public double colorB;
	public int priority;
}
