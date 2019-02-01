/*
 * Created on 29-Nov-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bureaueye.beacon.formatter;

import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import com.bureaueye.beacon.bean.DMY;

/**
 * @author NTankard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/**
 * A Formatter for date values
 */
public class DateDMYFormatter extends Formatter {
	
	/**
	 * The default date format string
	 */
	public final static String DATE_FORMAT_DMY = "dd/MM/yyyy";
	public final static String DATE_FORMAT_YMD = "yyyy-MM-dd";
	public final static String DATE_FORMAT_DD = "dd";
	public final static String DATE_FORMAT_MM= "MM";
	public final static String DATE_FORMAT_YYYY = "yyyy";    	

	
	/**
	 * Unformats its argument and returns a java.util.Date instance
	 * initialized with the resulting string.
	 *
	 * @return a java.util.Date intialized with the provided string
	 */
	public Object unformat(String string) {
		if (string == null || string.trim().length() < 1)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_YMD);
		formatter.setLenient(false);
		return formatter.parse(string, new ParsePosition(0));
	}
	/**
	 * Returns a string representation of its argument, formatted as a
	 * date with the “MM/dd/yyyy” format.
	 *
	 * @return a formatted String
	 */
	public String format(Object value) {
		if (value == null)
			return "";
		StringBuffer buf = new StringBuffer();
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_YMD);		
		formatter.setLenient(false);
		formatter.format(value, buf, new FieldPosition(0));	
		return buf.toString();
	}
	
	
	/**
	 * Returns a string representation of its argument, formatted as a
	 * date with the “MM/dd/yyyy” format.
	 *
	 * @return a formatted String
	 */
	public DMY formatDMY(Object value) {
		DMY dmy = new DMY();
		if (value == null)
			return dmy;
		
		SimpleDateFormat twoDigitMonth = new SimpleDateFormat(DATE_FORMAT_MM);
	    SimpleDateFormat twoDigitDay = new SimpleDateFormat(DATE_FORMAT_DD);
	    SimpleDateFormat fourDigitYear = new SimpleDateFormat(DATE_FORMAT_YYYY);
	    dmy.setDD(twoDigitDay.toString());
	    dmy.setMM(twoDigitMonth.toString());
	    dmy.setYYYY(fourDigitYear.toString());
	    
		return dmy;
	}
	
	
}
