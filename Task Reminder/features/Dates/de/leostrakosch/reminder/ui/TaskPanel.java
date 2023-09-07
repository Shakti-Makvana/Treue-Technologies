package de.leostrakosch.reminder.ui;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;

import de.leostrakosch.reminder.ui.TaskPanel;
import de.leostrakosch.reminder.common.Task;

public class TaskPanel extends JPanel {

  private FormLayout createLayout() {
    return original();
  }
  
  private void addComponents(Task t) {
    original(t);
    
    CellConstraints cc = new CellConstraints();
    FormLayout currLayout = (FormLayout) getLayout();
    
    currLayout.insertColumn(1, ColumnSpec.decode("fill:pref"));
    currLayout.insertColumn(2, ColumnSpec.decode("4dlu"));
    
    add(new JLabel(t.getDueDate().getStringRepresentation()), cc.xy(1, 1));
  }
}