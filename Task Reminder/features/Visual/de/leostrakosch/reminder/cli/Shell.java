package de.leostrakosch.reminder.cli;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import de.leostrakosch.reminder.cli.updates.ReminderUpdate;
import de.leostrakosch.reminder.common.Task;

public class Shell implements Observer {
  
  @Override
  public void update(Observable arg0, Object arg1) {
    
    if (arg1 instanceof ReminderUpdate) {
      ReminderUpdate update = (ReminderUpdate) arg1;
      List dueTasks = update.getTasks();
      Task currentTask;

      for (Object o : dueTasks) {
        currentTask = (Task) o;
        String taskName = currentTask.getName();
        
        if (taskName.length() > 20) {
          taskName = taskName.substring(18).trim() + "...";
        }
        
        display("Task '" + taskName + "' is due!"); 
      }
      
    } else {
      original(arg0, arg1);
    }
  }
}