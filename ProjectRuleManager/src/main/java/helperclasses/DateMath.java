package helperclasses;

import java.util.Date;
import java.math.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateMath {
	
	public static Integer calculateDateDistanceInDays(Date d1, Date d2) {
		Long diff = Math.abs( d1.getTime() - d2.getTime() );
		
		return (int) (diff / (24 * 60 * 60 * 1000));
	}
	
	public static Date getDateFromString(String dateString) {
		try {
			return (new SimpleDateFormat("dd/MM/yyyy")).parse(dateString);
		} catch (ParseException e) {
			return new Date();
		}
	}
	
}
