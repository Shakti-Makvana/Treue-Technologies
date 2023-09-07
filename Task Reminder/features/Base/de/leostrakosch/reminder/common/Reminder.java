package de.leostrakosch.reminder.common;

import java.util.List;
import de.leostrakosch.reminder.format.TaskFormat;

public interface Reminder {

    long addTask(Task t);
    
    long addTask(String name);

    void deleteTask(long taskID);

    List getTasks();

    String getHelp();
    
    TaskFormat getTaskFormatter();

}
