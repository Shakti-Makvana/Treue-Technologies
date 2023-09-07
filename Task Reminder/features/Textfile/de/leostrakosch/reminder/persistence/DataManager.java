package de.leostrakosch.reminder.persistence;

import java.io.File;

import de.leostrakosch.reminder.common.Configuration;
import de.leostrakosch.reminder.persistence.TextFileDataManager;
import de.leostrakosch.reminder.format.TaskFormat;

public class DataManager {
  
  private static final String SAVE_FILE_PATH = Configuration.APP_DIRECTORY + File.separator + "tasks.txt";
  private static final String SEPARATOR = "||";
  
  
  public static DataManager getInstance(TaskFormat formater) {
    return new TextFileDataManager(SAVE_FILE_PATH, formater);
  }
}