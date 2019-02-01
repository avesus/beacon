/*
 * Created on 29-Nov-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bureaueye.beacon.formatter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author NTankard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Formatter
{

	public static Formatter getFormatter(Class type) {
		if (BigDecimal.class.isAssignableFrom(type))
			return new CurrencyFormatter();
			else
				if (Date.class.isAssignableFrom(type))
					return new DateFormatter();
					else
						if (Integer.class.isAssignableFrom(type))
							return new IntegerFormatter();
							else						
			return new Formatter();
	}
	public String format(Object target) {
		return target == null ? "" : target.toString();
	}
	public Object unformat(String target) {
		return target;
	}	
}
