package de.leostrakosch.reminder.common;

import java.util.Comparator;

import de.leostrakosch.reminder.common.TaskIDComparator;

public class Task implements Comparable {

    private String name;
    private long id;

    public Task(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final long getTaskID() {
        return id;
    }

    @Override
    public int compareTo(Object obj) {
        Task task;
        long difference;
        Comparator comp = new TaskIDComparator();
        
        if (!(obj instanceof Task)) {
            throw new AssertionError("Task not compareable to " + obj);
        }
        
        task = (Task) obj;
        return comp.compare(this, obj);
    }
    
    @Override
    public String toString() {
      return "Task ID: [" + id + "]" + ", Name: [" + name + "]";
    }
    
    @Override
    public boolean equals(Object o) {
      if (o.getClass() != getClass()) {
        return false;
      }
      
      Task t = (Task) o;
      
      return id == t.id;
    }
    
    @Override
    public int hashCode() {
      return (int) id; // unique
    }
}
