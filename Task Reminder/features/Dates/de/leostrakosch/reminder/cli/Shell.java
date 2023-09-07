package de.leostrakosch.reminder.cli;

import de.leostrakosch.reminder.common.Date;
import de.leostrakosch.reminder.common.FeatureRuntimeError;
import de.leostrakosch.reminder.common.NoDateException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import de.leostrakosch.reminder.cli.WrongArgumentException;
import de.leostrakosch.reminder.common.Task;

public class Shell {
	private CLIReminder model;

	public long addTask(String[] args) throws WrongArgumentException, NoDateException,
			ParseException {
		if (args.length != 3) {
			throw new WrongArgumentException("Invalid amount of arguments");
		}
		Date dueDate = Date.valueOf(args[2]);
		return this.model.addTask(args[1], dueDate);
	}
	
	public void displayTasks(String[] args) throws ParseException {
		try {
			List tasks;
			if (args.length == 2) {

				Date dueDate = Date.valueOf(args[1]);
				tasks = this.model.getTasks(dueDate);

			} else if (args.length == 1) {
				tasks = this.model.getTasks();
			} else {
				throw new IllegalArgumentException();
			}

			for (Object task : tasks) {
				display(model.getTaskFormatter().getString(((Task) task)));
			}
		} catch (NoDateException e) {
			System.err.println("Invalid Date inserted. Cannot display task");
		}
	}

	private void display(String message) {
		System.out.println(message);
	}
}