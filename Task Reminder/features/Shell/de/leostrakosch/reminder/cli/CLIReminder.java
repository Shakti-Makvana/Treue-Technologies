package de.leostrakosch.reminder.cli;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Observable;

import de.leostrakosch.reminder.cli.Command;
import de.leostrakosch.reminder.common.Configuration;
import de.leostrakosch.reminder.common.Reminder;
import de.leostrakosch.reminder.common.Task;
import de.leostrakosch.reminder.cli.WrongArgumentException;
import de.leostrakosch.reminder.cli.Shell;

public class CLIReminder extends Observable implements Reminder {

  public static void main(String[] args) {
    CLIReminder reminder = new CLIReminder();

    if (args.length == 0) {
      original(args);
      
    } else {
      Shell shellUI = new Shell(reminder);

      reminder.addObserver(shellUI);
      shellUI.execute(args);
    }
  }
}