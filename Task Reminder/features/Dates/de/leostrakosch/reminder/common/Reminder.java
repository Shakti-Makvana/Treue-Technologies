package de.leostrakosch.reminder.common;

import java.util.List;

import de.leostrakosch.reminder.common.Date;

public interface Reminder {
    public List getTasks(Date d);
    
    public long addTask(String name, Date dueDate);
}