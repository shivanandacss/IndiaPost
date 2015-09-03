package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * DateValidation() to perform validation of the Date input by the user.
 * 
 * This method accepts two arguments i.e., the current date/Time and 
 * 		the date/time that is taken as input from the user
 */
public class DateValidation {

	public static int status;

	static public int compareDates(String date1, String date2) {

		try {

			SimpleDateFormat dateFormatter = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm");
			Date dateParam1 = dateFormatter.parse(date1);
			Date dateParam2 = dateFormatter.parse(date2);

			if (dateParam1.after(dateParam2)) {
				status = 1;
			}

			if (dateParam1.before(dateParam2)) {
				status = -1;
			}

			if (dateParam1.equals(dateParam2)) {
				status = 0;
			}

			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		}

	}

}
