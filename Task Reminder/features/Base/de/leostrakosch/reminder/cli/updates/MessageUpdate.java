package de.leostrakosch.reminder.cli.updates;

public class MessageUpdate {

  public enum Type { ERROR, STATUS }
  
  private String msg;
  private Type type;
  
  public MessageUpdate(Type type, String msg) {
    this.type = type;
    this.msg = msg;
  }

  public Type getType() {
    return type;
  }
  
  public String getMsg() {
    return msg;
  }
}