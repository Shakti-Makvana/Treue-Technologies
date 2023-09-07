package de.leostrakosch.reminder.common;

import java.util.Comparator;

public class TaskIDComparator implements Comparator {

  @Override
  public int compare(Object arg0, Object arg1) {
    Task t0, t1;
    long difference;
    
    if (!(arg0 instanceof Task) || !(arg1 instanceof Task)) {
      throw new AssertionError("Args not of type Task");
    }
    
    t0 = (Task) arg0;
    t1 = (Task) arg1;
    
    
    difference = t1.getTaskID() - t0.getTaskID();

    if (difference > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;

    } else if (difference < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;

    } else {
        return (int) difference;
    }
  }
}