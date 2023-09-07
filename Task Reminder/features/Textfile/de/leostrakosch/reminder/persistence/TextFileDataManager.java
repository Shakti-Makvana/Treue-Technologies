package de.leostrakosch.reminder.persistence;

import de.leostrakosch.reminder.format.SeparatorFormatter;
import de.leostrakosch.reminder.common.Task;
import de.leostrakosch.reminder.format.TaskFormat;
import de.leostrakosch.reminder.common.Configuration;
import de.leostrakosch.reminder.common.IllegalLineFormatException;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class TextFileDataManager extends DataManager {

  private final File saveFile;
  private final TaskFormat formater;

  public TextFileDataManager(String saveFilePath, TaskFormat formater) {
    File saveFile= new File(saveFilePath);
    File appDir = saveFile.getParentFile();
    
    if (!appDir.exists()) {
      appDir.mkdirs();
    }
    
    this.saveFile= saveFile;
    this.formater = formater;
  }

  @Override
  public void save(List tasks) throws IOException {
    FileWriter fileWriter = null;
    Task currentTask; 
    
    try {
      fileWriter = new FileWriter(saveFile);

      fileWriter.write("");

      for (Iterator it = tasks.iterator(); it.hasNext();) {
        currentTask = (Task) it.next();
        fileWriter.append(formater.getString(currentTask) + "\n");
      }
    } finally {
      if (fileWriter != null)
          fileWriter.close();
    }
  }

  @Override
  public List getTasks() {
    List tasks = new LinkedList();
    int lineNumber = 0;

    try {
      BufferedReader reader = new BufferedReader(new FileReader(saveFile));
      String line;

      while ((line = reader.readLine()) != null) {
        lineNumber++;
        tasks.add(formater.getTask(line));
      }

    } catch (IOException e) {
      // return existing empty list

    } catch (IllegalLineFormatException e) {
      System.err.println("Illegal format in line " + lineNumber);
    }

    return tasks;
  }
}
