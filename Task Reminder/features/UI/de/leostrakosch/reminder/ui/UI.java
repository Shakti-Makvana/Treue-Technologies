package de.leostrakosch.reminder.ui;

import java.util.Observable;
import java.util.Observer;

import de.leostrakosch.reminder.common.FeatureRuntimeError;

/**
 * Stub for GUI implementations of a feature
 */
public class UI implements Observer {
  
  private void displayError(String msg) {
    throw new FeatureRuntimeError("Not implemented");
  }
  
  private void displayStatus(String msg) {
    throw new FeatureRuntimeError("Not implemented");
  }
  
  @Override
  public void update(Observable observable, Object obj) {
    throw new AssertionError("Unsupported update received");
  }
}