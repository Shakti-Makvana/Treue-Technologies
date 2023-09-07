package de.leostrakosch.reminder.ui;

import java.awt.Component;
import java.awt.event.ActionListener;

import de.leostrakosch.reminder.common.FeatureRuntimeError;

public class TaskInputPanel {

  protected Component createInputField() {
    throw new FeatureRuntimeError("Not implemented");
  }
  
  protected Component createAddButton() {
    throw new FeatureRuntimeError("Not implemented");
  }
  
  protected class AddTaskListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent event) {
      throw new FeatureRuntimeError("Not implemented");
    }
  }
}