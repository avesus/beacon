/*
 * Created on 29-Nov-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bureaueye.beacon.formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;


/**
 * @author NTankard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PercentageFormatter extends Formatter {
	/** The default scale for currency values */
	public final static int CURRENCY_SCALE = 2;
	/** The default format for currency values */
	public final static String CURRENCY_FORMAT = "##0.00";
	/**
	 * Returns a string representation of its argument, formatted as a
	 * currency value.
	 *
	 * @return a formatted String
	 */
	public String format(Object value) {
		if (value == null)
			return "";
		String stringValue = "";
		try {
			BigDecimal bigDecValue = (BigDecimal)value;
			bigDecValue = bigDecValue.setScale(CURRENCY_SCALE,
					BigDecimal.ROUND_HALF_UP);
			stringValue = NumberFormat.getInstance().
			format(bigDecValue.doubleValue());
		}
		catch (IllegalArgumentException iae) {
			throw new FormattingException("Unable to format " + value +
					"as a currency value", iae);
		}
		return stringValue;
	}
}
