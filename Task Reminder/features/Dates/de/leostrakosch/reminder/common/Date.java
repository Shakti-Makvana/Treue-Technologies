package de.leostrakosch.reminder.common;

import java.io.Serializable;
import java.text.ParseException;
import java.util.StringTokenizer;

import de.leostrakosch.reminder.common.FeatureRuntimeError;
import de.leostrakosch.reminder.common.NoDateException;

/**
*
*/
public class Date implements Serializable {

	private static final long serialVersionUID = 2623834575450619003L;

	private final String DELIM = "";
	private byte day;
	private byte month;
	private short year;

	public Date(String dateRepresentation) throws NoDateException {
		StringTokenizer st = new StringTokenizer(dateRepresentation, DELIM);
		interpretDateRepresentation(st);

		if (!(day > 0 && day < 32)) {
			throw new NoDateException(day + " is no date in the calendar");
		}
		if (!(month > 0 && month < 13)) {
			throw new NoDateException(month + " is no month in the calendar");
		}
		if (!(year > 0)) {
			throw new NoDateException(year + " is no year");
		}

		// check if month has 31 days
		{
			switch (month) {
			case 4:
			case 6:
			case 9:
			case 11:
				if (day >= 31) {
					throw new NoDateException("month " + month
							+ "has not 31 days");
				}
				break;
			case 2:
				if (day == 29) {
					if (year % 4 != 0) {
						throw new NoDateException("");
					}
				}
				if (day > 29) {
					throw new NoDateException("");
				}

				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				break;
			default:
				throw new AssertionError("Unknown date: "
						+ this.getStringRepresentation());
			}
		}
	}

	public void interpretDateRepresentation(StringTokenizer st)
			throws NoDateException {

		throw new FeatureRuntimeError("date",
				"Date format must be spezified by different features");
	}

	public static Date valueOf(String dateRepresentation)
			throws NoDateException {
		return new Date(dateRepresentation);
	}

	public int compareTo(Date date) {
		return this.getDateRepresentation() - date.getDateRepresentation();
	}

	private int getDateRepresentation() {
		return ((int) this.year) * 10000 + ((int) month) * 100 + ((int) day);
	}

	public String getStringRepresentation() {
		throw new FeatureRuntimeError("date",
				"Date format must be spezified by different features");
	}
}