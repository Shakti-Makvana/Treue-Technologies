package de.leostrakosch.reminder.cli;

import de.leostrakosch.reminder.ui.UI;

public class CLIReminder {

  public static void main(String[] args) {
    if (args.length != 0) {
      original(args);
      return;
    }
    
    CLIReminder reminder = new CLIReminder();
    UI ui = new UI(reminder);
    
    reminder.addObserver(ui);
    ui.setVisible(true);
  }
}