package de.leostrakosch.reminder.ui;

import java.util.List;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.leostrakosch.reminder.cli.CLIReminder;
import de.leostrakosch.reminder.common.Reminder;
import de.leostrakosch.reminder.common.Task;

public class MainPanel extends JScrollPane implements TaskDisplay {

  private static final String LAYOUT_COL_SPEC = "fill:pref:grow";

  private Reminder reminder;

  public MainPanel(Reminder reminder) {
    this.reminder = reminder;

    displayTasks();
  }

  public void displayTasks() {
    List tasks = reminder.getTasks();
    Task currentTask;

    JPanel mainPanel;
    FormLayout layout = new FormLayout(LAYOUT_COL_SPEC);
    CellConstraints cc = new CellConstraints();

    for (int i = 0; i < tasks.size(); i++) {
      layout.appendRow(RowSpec.decode("fill:[pref, 15dlu]"));
      layout.appendRow(RowSpec.decode("2dlu"));
    }

    mainPanel = new JPanel(layout);

    int i = 1;
    for (Object o : tasks) {
      currentTask = (Task) o;
      mainPanel.add(createTaskPanel(currentTask), cc.xy(1, i));
      i += 2;
    }

    getViewport().setView(mainPanel);
  }

  private Component createTaskPanel(Task task) {
    return new TaskPanel(task, (CLIReminder) reminder);
  }
}