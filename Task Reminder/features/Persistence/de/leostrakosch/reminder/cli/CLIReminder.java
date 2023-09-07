package de.leostrakosch.reminder.cli;

import java.io.IOException;
import java.util.List;

import de.leostrakosch.reminder.persistence.DataManager;

public class CLIReminder {

  private DataManager manager = DataManager.getInstance(getTaskFormatter());

  private List getTaskList() {
    try {
      return manager.getTasks();
      
    } catch (IOException e) {
      updateError("Error while getting tasks: " + e.getMessage());
      return createList();
    }
  }

  private boolean commit(List tasks) {
    try {
      manager.save(tasks);

    } catch (IOException e) {
      updateError("Error while committing: " + e.getMessage() + "\nContinuing with commit.");
      original(tasks);
      return false;
    }

    return original(tasks);
  }
}