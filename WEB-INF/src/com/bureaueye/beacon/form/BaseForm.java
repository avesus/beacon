/*
 * Created on 29-Nov-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bureaueye.beacon.form;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.validator.ValidatorForm;

import com.bureaueye.beacon.bean.Breadcrumb;
import com.bureaueye.beacon.formatter.Formatter;
import com.bureaueye.beacon.formatter.FormattingException;
import com.bureaueye.beacon.formatter.PercentageFormatter;

/**
 * @author NTankard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class BaseForm extends ValidatorForm {
	
	/** Indicates that conversion is from string to object */
	public final static int TO_OBJECT = 0;
	/** Indicates that conversion is from object to string */
	public final static int TO_STRING = 1;
	
	private Breadcrumb breadcrumb;
	
	
	/**
	 * The strings to display when null values are encountered.
	 * Keys correspond to fields in the Form. The presence of a given
	 * key indicates that the value provided in the map should be used
	 * instead of the normal default string.
	 */
	private Map defaultStringMap = new HashMap();
	/**
	 * The format to use instead of the default format
	 * for a given type.
	 */
	private Map formatMap = new HashMap();
	/**
	 * Transfers values to and from the given bean, depending on the
	 * value of <code>mode</code>. If the given mode is
	 * <code>TO_STRING</code>, populates
	 * the instance by introspecting the specified bean,
	 * converting any typed values to formatted strings, and
	 * then using reflection to invoke its own String-based setter
	 * methods. If the mode is <code>TO_OBJECT</code>, performs the
	 * inverse operation, unformatting and converting properties of
	 * the MyForm instance and populating the resulting values in the
	 * given bean.
	 * <p>
	 * If null values are encountered in the bean, MyForm will
	 * be populated with the default string associated with the given
	 * type. The default null values can be overridden by calling
	 * <code>setdefaultString(String key, String value)</code> and
	 * providing an alternative string.
	 *
	 * @param bean an object containing the values to be populated
	 * @param mode Whether conversion is to String or to Java type
	 */
	public void populate(Object bean, int mode) {
		String errorMsg = "Unable to format values from bean: " + bean;
		Object source = (mode == TO_STRING ? bean : this);
		Object target = (mode == TO_STRING ? this : bean);
		Map valueMap = mapRepresentation(source);
		Iterator keyIter = valueMap.keySet().iterator();
		while (keyIter.hasNext()) {
			String currKey = (String)keyIter.next();
			Object currValue = valueMap.get(currKey);
			if (currValue != null) {
			try {	
				Class type =
					PropertyUtils.getPropertyType(bean, currKey);
				Formatter formatter = getFormatter(currKey, type);
				Object value = null;
				switch (mode) {
				case TO_OBJECT:		
					value = formatter.unformat((String)currValue);
					break;
				case TO_STRING:
					if (currValue == null)
						value = (String) defaultStringMap.get(currKey);
					else
						value = formatter.format(currValue);
					break;
				default:
					throw new RuntimeException("Unknown mode: " +
							mode);
				}
				PropertyUtils.setSimpleProperty(target, currKey, value);
			}
			catch (IllegalAccessException iae) {
				throw new FormattingException(errorMsg, iae);
			}
			catch (InvocationTargetException ite) {
				throw new FormattingException(errorMsg, ite);
			}
			catch (NoSuchMethodException nsme) {
				throw new FormattingException(errorMsg, nsme);
			}
			}
		}
	}
	/**
	 * Sets the default value to display for the given key when the
	 * property value in the associated bean is <code>null</code>.
	 *
	 * @param key the name of the property
	 * @parm value the value to display
	 */
	public void setDefaultString(String key, String value) {
		defaultStringMap.put(key, value);
	}
	/**
	 * Sets the default Formatter class to use for the given key
	 *
	 * @param key the name of the property
	 * @param value the value to display
	 */
	public void setFormatterType(String key, Class type) {			
		if (!Formatter.class.isAssignableFrom(type))
			throw new FormattingException(type + "must be a Formatter");
		formatMap.put(key, type);
	}
	/**
	 * Returns a Map containing the values from the provided
	 * Java bean, keyed by field name. Entries having keys
	 * that match any of the strings returned by
	 * <code>keysToSkip()</code> will be removed.
	 *
	 * @param bean the Java bean from which to create the Map
	 * @return a Map containing values from the provided bean
	 */
	protected Map mapRepresentation(Object bean) {
		String errorMsg = "Unable to format values from bean: " + bean;
		Map valueMap = null;
		//	 PropertyUtils.describe() uses Introspection to generate a Map
		//	 of values from its argument, keyed by field name.
		try {
			valueMap = PropertyUtils.describe(bean);
		}
		catch (IllegalAccessException iae) {
			throw new FormattingException(errorMsg, iae);
		}
		catch (InvocationTargetException ite) {
			throw new FormattingException(errorMsg, ite);
		}
		catch (NoSuchMethodException nsme) {
			throw new FormattingException(errorMsg, nsme);
		}
		//	 Remove keys for values that shouldn’t be populated.
		//	 Subclasses can override keysToSkip() to customize.
		Iterator keyIter = keysToSkip().iterator();
		while (keyIter.hasNext()) {
			String key = (String)keyIter.next();
			valueMap.remove(key);
		}
		return valueMap;
	}
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = new ArrayList();
		//	 Don’t populate "class" field inherited from Object
		keysToSkip.add("class");
		keysToSkip.add("systemlogprogram");
		keysToSkip.add("systemlogaction");	
		keysToSkip.add("systemloguserid");	
		keysToSkip.add("systemlogdate");
		keysToSkip.add("systemlogtime");
		keysToSkip.add("systemloglock");		
		keysToSkip.add("createuserid");	
		keysToSkip.add("createdate");
		keysToSkip.add("createtime");
		keysToSkip.add("xinactive");
		keysToSkip.add("xlock");		
		keysToSkip.add("deleted");
		keysToSkip.add("rowid");
		keysToSkip.add("servletWrapper");
		keysToSkip.add("multipartRequestHandler");
		keysToSkip.add("resultValueMap");
		keysToSkip.add("validatorResults");
		keysToSkip.add("page");			
		return keysToSkip;
	}
	
	
	/**
	 Listing 2.14 (continued)
	 108 Chapter 2
	 c 449156 Ch02.qxd 6/16/03 8:49 AM Page 108
	 * Returns a Formatter for the provided type. If the provided key
	 * matches an entry in the formatMap, the Formatter type indicated
	 * by the entry is used instead of the default for the given type.
	 *
	 * @param key The name of the property to be formatted
	 * @param type The type of the property to be formatted
	 * @return A Formatter
	 */
	protected Formatter getFormatter(String key, Class type) {
		Class formatType = (Class) formatMap.get(key);		
		if (formatType == null)
			return Formatter.getFormatter(type);
		if (formatType.isAssignableFrom(PercentageFormatter.class)) {
			if (!BigDecimal.class.isAssignableFrom(type))
				throw new FormattingException("Unable to format value "
						+ "of type " + type + " as a percentage.");
			return new PercentageFormatter();
		}
		return null;
	}
	
	
	
	// breadcrumb
	public Breadcrumb getBreadcrumb() {
		return breadcrumb;
	}
	public void setBreadcrumb(String _value) {
		StringTokenizer _stringTokenizer = new StringTokenizer(_value, "|");
		Breadcrumb _breadcrumb = new Breadcrumb();
		_breadcrumb.setUrl(_stringTokenizer.nextToken());
		_breadcrumb.setLabel(_stringTokenizer.nextToken());
		_breadcrumb.setSequence(_stringTokenizer.nextToken());		
		this.breadcrumb = _breadcrumb;
	}
	
	
}



