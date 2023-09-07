package de.leostrakosch.reminder.format;

import java.util.Iterator;


public class SeparatorFormatter {

  private static final String FAVORITE_MARKER = "F";
  
  @Override
  public String getString(Task t) {
    String isFavorite = t.isFavorite() ? FAVORITE_MARKER : " ";
    
    return original(t) + isFavorite + separator;
  }
  
  @Override
  public Task getTask(String s) throws IllegalLineFormatException {
    Task task;
    boolean isFavorite;
    List attributes = splitInput(s, separator);
    String currString;
    String originalString = "";
    String newAttribute = (String) attributes.get(attributes.size() -1); // get last attribute
    
    for (Iterator it = attributes.iterator(); it.hasNext(); ) {
      currString = (String) it.next();
      
      if (!it.hasNext()) {
        continue; // don't take the last argument
      }
      
      originalString += currString + separator;
    }
    
    task = original(originalString);
    
    isFavorite = newAttribute.equals(FAVORITE_MARKER);
    task.setFavorite(isFavorite);
    
    return task;
  }
}