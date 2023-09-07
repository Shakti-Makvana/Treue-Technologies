package de.leostrakosch.reminder.cli;

import java.beans.FeatureDescriptor;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Comparator;

import de.leostrakosch.reminder.common.Configuration;
import de.leostrakosch.reminder.common.FeatureRuntimeError;
import de.leostrakosch.reminder.common.Reminder;
import de.leostrakosch.reminder.common.Task;
import de.leostrakosch.reminder.common.Date;

/**
 * TODO description
 */
public class CLIReminder extends Observable implements Reminder {

	@Override
	public long addTask(String name, Date dueDate) {
		long id = this.getNextTaskID();
		this.addTask(new Task(name, dueDate, id));
		return id;
	}
	
	public long addTask(String name) {
		throw new FeatureRuntimeError("date", "In the feature date there are no "
				+ "tasks without date");
	}

	@Override
	public List getTasks(Date date) {
		List filteredList = new ArrayList();
		for(Object task : this.getTasks()) {
			// adds all task with due date after given date
			if(((Task) task).getDueDate().compareTo(date) > 0) {
				filteredList.add(task);
			}
		}
		return filteredList;
	}
}