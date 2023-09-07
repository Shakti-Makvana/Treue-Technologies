package de.leostrakosch.reminder.cli;

import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Set;
import java.util.HashSet;

import de.leostrakosch.reminder.cli.updates.ReminderUpdate;
import de.leostrakosch.reminder.common.Date;
import de.leostrakosch.reminder.common.NoDateException;
import de.leostrakosch.reminder.common.Task;


public class CLIReminder extends Observable {

  private final Set remindedTasks = new HashSet();
  
  public List getTasks() {
    List allTasks = original();
    List dueTasks = new ArrayList();
    
    Task currTask;
    Date today = getTodaysDate();
    Date currTaskDate;
    
    for (Object o : allTasks) {
      currTask = (Task) o;
      
      currTaskDate = currTask.getDueDate();
      
      if (currTaskDate.compareTo(today) <= 0 && !remindedTasks.contains(currTask)) {
          dueTasks.add(currTask);
          remindedTasks.add(currTask);
      }
    }
    
    if (!dueTasks.isEmpty()) {
      sendReminderUpdate(dueTasks);
    }
    
    return allTasks;
  }
  
  private Date getTodaysDate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat(Date.FORMAT);
    java.util.Date today = new java.util.Date();
    
    Date currentDate = null;
    try {
    	currentDate = new Date(dateFormat.format(today));
    } catch (NoDateException e) {
    	throw new AssertionError(e);
    }
    return currentDate;
  }
  
  private void sendReminderUpdate(List dueTasks) {
    // do nothing
  }
}
