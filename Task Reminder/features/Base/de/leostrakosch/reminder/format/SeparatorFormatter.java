package de.leostrakosch.reminder.format;

import de.leostrakosch.reminder.common.Task;
import de.leostrakosch.reminder.common.Configuration;
import de.leostrakosch.reminder.common.IllegalLineFormatException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class SeparatorFormatter implements TaskFormat {

  private String separator;

  public SeparatorFormatter(String separator) {
    this.separator = separator;
  }

  @Override
  public String getString(Task t) {
    return t.getTaskID() + separator + t.getName() + separator;
  }

  @Override
  public Task getTask(String s) throws IllegalLineFormatException {

    List attributes = splitInput(s, separator);

    if (attributes.size() != 2) { // at least taskID and name needed
      throw new IllegalLineFormatException("Illegal format: " + s);
    }

    long id = Long.valueOf((String) attributes.get(0));
    String name = (String) attributes.get(1);
    return new Task(name, id);
  }

  private List splitInput(String input, String separator) {
    ArrayList output = new ArrayList(5);
    int pointer = 0;
    int separatorSize = separator.length();
    String currString = input;
    String currPeek;

    while (pointer < currString.length()) {
      currPeek = currString.substring(pointer, pointer + separatorSize);

      if (currPeek.equals(separator)) {
        output.add(currString.substring(0, pointer));
        currString = currString.substring(pointer + separatorSize);
        pointer = 0;

      } else {
        pointer++;
      }
    }

    return output;
  }
}
