/*
 * Created on 29-Nov-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bureaueye.beacon.formatter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;


/**
 * @author NTankard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CurrencyFormatter extends Formatter {
	/** The default scale for currency values */
	public final static int CURRENCY_SCALE = 2;
	/** The default format for currency values */
	public final static String CURRENCY_FORMAT = "#,##0.00";
	/**
	 * Returns a string representation of its argument, formatted as a
	 * currency value.
	 *
	 * @return a formatted String
	 */
	/* (non-Javadoc)
	 * @see com.bureaueye.beacon.formatter.Formatter#format(java.lang.Object)
	 */
	public String format(Object value) {
		if (value == null)
			return "";
		String stringValue = "";
		try {
			BigDecimal bigDecValue = (BigDecimal)value;
			bigDecValue = bigDecValue.setScale(CURRENCY_SCALE,
					BigDecimal.ROUND_HALF_UP);
			
//			stringValue = 
//				NumberFormat.getInstance().
//					format(bigDecValue.doubleValue());	
	        
			// We're not using DecimalFormat.getCurrencyInstance() here
	        // because it requires a leading currency symbol; we want
	        // the currency symbol to be optional.
	        NumberFormat formatter = DecimalFormat.getInstance();
	        formatter.setMinimumFractionDigits(CURRENCY_SCALE);
	        stringValue = formatter.format(bigDecValue.doubleValue());
		}
		catch (IllegalArgumentException iae) {
			throw new FormattingException("Unable to format " + value +
					"as a currency value", iae);
		}
		
		return stringValue;
	}
	
	
	/**
	 * Unformats its argument and returns a BigDecimal instance
	 * initialized with the resulting string value
	 *
	 * @return a BigDecimal initialized with the provided string
	 */
	public Object unformat(String target) {
		if (target == null || target.trim().length() < 1)
			return null;
		String errorMsg = "Unable to parse a currency value from " +
		target;
		BigDecimal value;
		try {
			DecimalFormat formatter =
				new DecimalFormat(CURRENCY_FORMAT);
			Number parsedNumber = formatter.parse(target.trim());
			value = new BigDecimal(parsedNumber.doubleValue());
		}
		catch (NumberFormatException nfe) {
			throw new FormattingException(errorMsg, nfe);
		}
		catch (ParseException pe) {
			throw new FormattingException(errorMsg, pe);
		}
		return value;
	}
	
}
