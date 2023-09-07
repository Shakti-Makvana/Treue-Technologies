package de.leostrakosch.reminder.cli;

import de.leostrakosch.reminder.common.Task;

public class CLIReminder {

  public void setFavorite(long taskID, boolean isFavorite) {
    List tasks = getTasks();
    Task currentTask = null;
    boolean found = false;
    
    for (Object obj : tasks) {
      currentTask = (Task) obj;
      
      if (currentTask.getTaskID() == taskID) {
        found = true;
        break;
      }
    }
    
    if (found) {
      currentTask.setFavorite(isFavorite);
      commit(tasks);
      
    } else {
      updateError("No task with ID found");
    }
  }
}