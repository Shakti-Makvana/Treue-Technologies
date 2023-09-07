package de.leostrakosch.reminder.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.SimpleFormatter;

import de.leostrakosch.reminder.common.Task;

public class BinaryDataManager extends DataManager {
  private static final String SUFFIX = ".ser";

  private File savePath;

  public BinaryDataManager(String savePathString) {
    File savePath = new File(savePathString);

    if (!savePath.exists()) {
      savePath.mkdirs();
    }

    this.savePath = savePath;
  }

  @Override
  public void save(List tasks) throws IOException {
    Task t;

    for (Object o : tasks) {
      t = (Task) o;
      serialize(t);
    }
  }

  private void serialize(Task t) throws IOException {
    String fileName = "task" + t.getTaskID() + SUFFIX;
    File saveFile = new File(savePath, fileName);
    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(saveFile));

    try {
      output.writeObject(t);

    } finally {
      output.close();
    }
  }

  @Override
  public List getTasks() throws IOException {
    List tasks = new ArrayList();

    File[] files = savePath.listFiles();

    for (File f : files) {
      if (f.getName().endsWith(SUFFIX)) {
        tasks.add(deserialize(f));
      }
    }

    return tasks;
  }

  private Task deserialize(File f) throws IOException {
    ObjectInputStream input = new ObjectInputStream(new FileInputStream(f));

    try {
      return (Task) input.readObject();

    } catch (ClassNotFoundException e) {
      throw new AssertionError(e);

    } finally {
      input.close();
    }
  }
}