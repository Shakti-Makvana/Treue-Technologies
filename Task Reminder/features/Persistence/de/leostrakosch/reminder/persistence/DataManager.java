package de.leostrakosch.reminder.persistence;

import de.leostrakosch.reminder.common.Task;
import de.leostrakosch.reminder.format.TaskFormat;

import java.io.IOException;
import java.util.List;

public abstract class DataManager {

    public static DataManager getInstance(TaskFormat formater) {
      
      // should be replaced in concrete feature implementation
      throw new AssertionError("getInstance() not overwritten by persistence feature");
    }

    public abstract void save(List tasks) throws IOException;

    public abstract List getTasks() throws IOException;

}
