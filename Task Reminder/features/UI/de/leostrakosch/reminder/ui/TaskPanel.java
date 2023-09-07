package de.leostrakosch.reminder.ui;

import com.jgoodies.forms.layout.FormLayout;

import de.leostrakosch.reminder.common.FeatureRuntimeError;

/**
 * This class is just a stub for future features implementing a
 * GUI. It can be used for extending the task display across
 * multiple, independent features.
 */
public class TaskPanel {
  private LayoutManager createLayout() {
    throw new AssertionError("Should be overridden by feature");
  }
  
  private void addComponents(Task t) {
    throw new AssertionError("Should be overridden by feature");
  }
}