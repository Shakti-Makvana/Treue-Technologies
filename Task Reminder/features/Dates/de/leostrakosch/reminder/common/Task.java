package de.leostrakosch.reminder.common;

import de.leostrakosch.reminder.common.FeatureRuntimeError;
import de.leostrakosch.reminder.common.Date;

public class Task {

	private Date dueDate;

	public Task(String name, Date dueDate, long id) {
		this.name = name;
		this.dueDate = dueDate;
		this.id = id;
	}
	
	public void setDate(Date dueDate) {
	  this.dueDate = dueDate;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj == null) {
			throw new AssertionError("Task not compareable to " + "null");
			
		} else if (!(obj instanceof Task)) {
			throw new AssertionError("Task not compareable to "
					+ obj.getClass());
		}
		Task compareTask = (Task) obj;
		return dueDate.compareTo(compareTask.getDueDate());
	}

	public Date getDueDate() {
		return dueDate;
	}
}