package de.leostrakosch.reminder.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class Configuration {

  private Configuration() {

  }
  
  public final static String APP_DIRECTORY = System.getProperty("user.home") + File.separator + ".reminder";
}
