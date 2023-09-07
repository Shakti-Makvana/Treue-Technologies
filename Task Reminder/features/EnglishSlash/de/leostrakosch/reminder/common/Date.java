package de.leostrakosch.reminder.common;

import java.util.StringTokenizer;

public class Date {
  public final static String FORMAT = "MM/dd/YYYY";
  
	private final String DELIM = "/";

	public void interpretDateRepresentation(StringTokenizer st)
			throws IllegalArgumentException {
		
		month = Byte.parseByte(st.nextToken());
		day = Byte.parseByte(st.nextToken());
		year = Short.parseShort(st.nextToken());
	}
	
	public String getStringRepresentation() {
		return String.valueOf("" + month + DELIM + day + DELIM + year);
	}
}