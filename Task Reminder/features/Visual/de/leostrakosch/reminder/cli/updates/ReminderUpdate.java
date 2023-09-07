package de.leostrakosch.reminder.cli.updates;

import java.util.LinkedList;
import java.util.List;

import de.leostrakosch.reminder.common.Task;

public class ReminderUpdate {

  private List tasks;
  
  public ReminderUpdate(Task task) {
    tasks = new LinkedList();
    tasks.add(task);
  }
  
  public ReminderUpdate(List tasks) {
    this.tasks = new LinkedList(tasks);
  }
  
  public List getTasks() {
    return tasks;
  }
}