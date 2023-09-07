package de.leostrakosch.reminder.format;

import java.text.ParseException;
import java.util.List;

import de.leostrakosch.reminder.common.Configuration;
import de.leostrakosch.reminder.common.IllegalLineFormatException;
import de.leostrakosch.reminder.common.NoDateException;
import de.leostrakosch.reminder.common.Task;
import de.leostrakosch.reminder.common.Date;

import java.util.Iterator;

public class SeparatorFormatter {

	@Override
	public String getString(Task t) {
		String dueDate = t.getDueDate().getStringRepresentation();

		return original(t) + dueDate + separator;
	}

	@Override
	public Task getTask(String s) throws IllegalLineFormatException {
		Task task;
		Date dueDate;
		List attributes = splitInput(s, separator);
		String currString;
		String originalString = "";
		String newAttribute = (String) attributes.get(attributes.size() - 1); // get
																				// last
																				// attribute

		for (Iterator it = attributes.iterator(); it.hasNext();) {
			currString = (String) it.next();

			if (!it.hasNext()) {
				continue; // don't take the last argument
			}

			originalString += currString + separator;
		}

		task = original(originalString);
		try {
			dueDate = Date.valueOf(newAttribute);
		} catch (NoDateException e) {
			throw new IllegalLineFormatException(e);
		}

		task.setDate(dueDate);

		return task;
	}
}