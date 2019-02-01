/*
 * Created on 29-Nov-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bureaueye.beacon.formatter;

/**
 * @author NTankard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class IntegerFormatter extends Formatter
{
	/**
	 * Returns an object representation of its argument.
	 *
	 * @return an object
	 */
	public Object unformat(String string) {
		if (string == null || string.trim().length() < 1)
			return null;
		return new Integer(string);
	}	
	/**
	 * Returns a formatted version of its argument.
	 *
	 * @return a formatted String
	 */
	public String format(Integer anInteger) {
		return (anInteger == null ? "" : anInteger.toString());
	}
}

