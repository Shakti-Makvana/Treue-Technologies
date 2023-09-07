package de.leostrakosch.reminder.common;

import java.util.StringTokenizer;

public class Date {
  public final static String FORMAT = "dd.MM.YYYY";
	private final String DELIM = ".";

	public void interpretDateRepresentation(StringTokenizer st)
			throws IllegalArgumentException {
		day = Byte.parseByte(st.nextToken());
		month = Byte.parseByte(st.nextToken());
		year = Short.parseShort(st.nextToken());
	}
	
	public String getStringRepresentation() {
		return String.valueOf("" + day + DELIM + month + DELIM + year);
	}

}