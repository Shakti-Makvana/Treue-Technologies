package de.leostrakosch.reminder.ui;

import java.util.List;
import java.util.Observable;

import de.leostrakosch.reminder.cli.updates.ReminderUpdate;
import de.leostrakosch.reminder.common.Task;

public class UI {

  @Override
  public void update(Observable observable, Object obj) {
    if (obj instanceof ReminderUpdate) {
      ReminderUpdate update = (ReminderUpdate) obj;
      List tasks = update.getTasks();
      String statusMessage;
      
      if (tasks.size() == 1) {
        String taskName = ((Task) tasks.get(0)).getName();
        
        if (taskName.length() > 20) {
          taskName = taskName.substring(18).trim() + "...";
        }
        
        statusMessage = "Task " + taskName + " is due!";
        
      } else {
        statusMessage = tasks.size() + " tasks are due!";
      }
      
      displayStatus(statusMessage);
      
    } else {
      original(observable, obj);
    }
  }
}