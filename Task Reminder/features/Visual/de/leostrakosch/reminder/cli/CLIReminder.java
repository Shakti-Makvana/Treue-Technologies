package de.leostrakosch.reminder.cli;

import de.leostrakosch.reminder.cli.updates.ReminderUpdate;

public class CLIReminder {

  private void sendReminderUpdate(List dueTasks) {
    setChanged();
    notifyObservers(new ReminderUpdate(dueTasks));
  }
}