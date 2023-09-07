package de.leostrakosch.reminder.common;

public class Task {

  private boolean isFavorite = false;
  
  public void setFavorite(boolean favorite) {
    isFavorite = favorite;
  }
  
  public boolean isFavorite() {
    return isFavorite;
  }
  
  @Override
  public int compareTo(Object obj) {
    Task t;
    
    if (!(obj instanceof Task)) {
      throw new AssertionError("Task not compareable to " + obj);
    }
    
    t = (Task) obj;
    
    if (t.isFavorite == isFavorite) {
      return original(obj);
      
    } else if (t.isFavorite) {
      return -1;
      
    } else {
      return 1;
    }
  }
}