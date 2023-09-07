package de.leostrakosch.reminder.cli;

import java.util.List;
import java.net.URISyntaxException;

import de.leostrakosch.reminder.cli.updates.ReminderUpdate;
import de.leostrakosch.reminder.common.Date;
import de.leostrakosch.reminder.common.SoundAlarmClock;
import de.leostrakosch.reminder.common.Task;

public class CLIReminder extends Observable {
	private SoundAlarmClock soundAlarm;

	public CLIReminder() {
		try {
			soundAlarm = new SoundAlarmClock();
			this.addObserver(soundAlarm);
		} catch (URISyntaxException e) {

		}
	}

	private void sendReminderUpdate(List dueTasks) {
		setChanged();
		notifyObservers(new ReminderUpdate(dueTasks));
	}
	
}