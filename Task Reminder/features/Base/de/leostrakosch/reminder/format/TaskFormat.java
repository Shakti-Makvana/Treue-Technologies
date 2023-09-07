package de.leostrakosch.reminder.format;

import de.leostrakosch.reminder.common.Task;
import de.leostrakosch.reminder.common.IllegalLineFormatException;

public interface TaskFormat {
  
  /**
   * Returns a string representation of the given @{link Task}.
   * 
   * Different attributes of the task should be divided by a uniform separator.
   * Each representation has to end with the same separator to allow for multiple
   * features to extend this method.
   * 
   * Following condition has to be fulfilled:
   * 
   * getTask(getString(t)) == t.
   * 
   * @param t the task to return a representation of
   * @return string representation of the given task
   */
  String getString(Task t);

  /**
   * Returns a task for the given string representation.
   * 
   * Following condition has to be fulfilled:
   * 
   * getTask(getString(t)) == t.
   * 
   * @param s
   * @return
   * @throws IllegalLineFormatException
   */
  Task getTask(String s) throws IllegalLineFormatException;
}
