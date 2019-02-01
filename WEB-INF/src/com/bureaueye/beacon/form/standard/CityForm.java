package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-01-07 201400002 Remove 'Invalid Character' validation check from 'Add
 * City' Maintenance Option
 * 
 */
public final class CityForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;

	private String city;

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		ActionErrors errors = new ActionErrors();

		if (city == null || city.length() == 0) {
			errors.add("city", new ActionMessage("error.field.required"));
		}

		if (action.equals("Create")) {
			// if (Util.invalidChars(city)) errors.add("city", new
			// ActionMessage("error.code.invalidchars"));//201400002
		}

		return errors;

	}

}
