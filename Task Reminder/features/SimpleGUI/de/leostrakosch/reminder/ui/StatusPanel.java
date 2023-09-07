package de.leostrakosch.reminder.ui;

import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.JPanel;
import javax.swing.JLabel;

public class StatusPanel extends JPanel implements StatusDisplay {

  JLabel textLabel;
  
  public StatusPanel() {
    BorderLayout layout = new BorderLayout();

    setLayout(layout);
    
    textLabel = new JLabel();
    add(textLabel, BorderLayout.EAST);
  }
  
  @Override
  public void displayStatus(String msg) {
    textLabel.setForeground(Color.BLACK);
    textLabel.setText(msg);
  }
  
  @Override
  public void displayError(String msg) {
    textLabel.setForeground(Color.RED);
    textLabel.setText(msg);
    
  }
  
}