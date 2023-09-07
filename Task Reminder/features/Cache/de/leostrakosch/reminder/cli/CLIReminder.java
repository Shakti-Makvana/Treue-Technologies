package de.leostrakosch.reminder.cli;

import java.io.IOException;
import java.util.List;

import de.leostrakosch.reminder.common.Task;
import de.leostrakosch.reminder.persistence.DataManager;
import de.leostrakosch.reminder.persistence.TaskCache;


public class CLIReminder {

  private TaskCache cache;

  @Override
  public List getTasks() {
    if (cache == null) {
      createCache(original());
    }

    return cache.getTasks();
  }

  private boolean commit(List tasks) {
    if (cache == null) {
      createCache(getTasks());
    }

    cache.updateCache(tasks);
    
    return original(tasks);
  }

  private void createCache(List tasks) {
    cache = new TaskCache(tasks);
  }
}