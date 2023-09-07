package de.leostrakosch.reminder.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.leostrakosch.reminder.persistence.DataManager;

public class TaskCache {
  private List cache;

  public TaskCache(List tasks) {
    cache = new ArrayList(tasks);
  }

  public void updateCache(List tasks) {
    cache = new ArrayList(tasks);
  }

  public List getTasks() {
    return new ArrayList(cache);
  }
}