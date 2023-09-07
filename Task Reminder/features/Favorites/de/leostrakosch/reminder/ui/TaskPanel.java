package de.leostrakosch.reminder.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;

import de.leostrakosch.reminder.cli.CLIReminder;
import de.leostrakosch.reminder.common.Reminder;

public class TaskPanel extends JPanel {

  private CLIReminder reminder; // stub
  private long taskID; // stub

  private void addComponents(Task t) {
    original(t);

    CellConstraints cc = new CellConstraints();
    int colCount = ((FormLayout) getLayout()).getColumnCount();

    add(createFavButton(t), cc.xy(colCount, 1));
  }

  private Component createFavButton(Task t) {
    final JToggleButton button = new JToggleButton("Favorite", t.isFavorite());

    button.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        JToggleButton button = (JToggleButton) e.getSource();

        reminder.setFavorite(taskID, button.isSelected());
      }
    });

    return button;
  }

  private FormLayout createLayout() {
    FormLayout layout = original();

    layout.appendColumn(ColumnSpec.decode("2dlu"));
    layout.appendColumn(ColumnSpec.decode("fill:pref"));

    return layout;
  }
}