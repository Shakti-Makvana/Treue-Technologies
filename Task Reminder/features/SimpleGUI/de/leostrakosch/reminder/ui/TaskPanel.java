package de.leostrakosch.reminder.ui;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.leostrakosch.reminder.cli.CLIReminder;
import de.leostrakosch.reminder.common.Task;

public class TaskPanel extends JPanel {

  protected static final String DEFAULT_COL_SPEC = "fill:pref:grow, 3dlu, fill:pref";
  protected static final String DEFAULT_ROW_SPEC = "fill:pref";
  
  private final CLIReminder reminder;
  private final long taskID;
  
  public TaskPanel(Task t, CLIReminder reminder) {
    this.reminder = reminder;
    taskID = t.getTaskID();
    
    setLayout(createLayout());
    addComponents(t);
  }
  
  private void addComponents(Task t) {
    CellConstraints cc = new CellConstraints();
    
    add(new JLabel(t.getName()), cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    add(createDeleteButton(), cc.xy(3, 1));
  }
  
  private Component createDeleteButton() {
    JButton button = new JButton("Delete");
    
    button.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        reminder.deleteTask(taskID);
      }
    });
    
    return button;
  }
  
  private FormLayout createLayout() {
    return new FormLayout(DEFAULT_COL_SPEC, DEFAULT_ROW_SPEC);
    
  }
}