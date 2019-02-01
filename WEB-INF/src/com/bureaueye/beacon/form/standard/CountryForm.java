package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.util.Util;

public final class CountryForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;

	private String country;
	
	private String countrykey;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountrykey() {
		return countrykey;
	}

	public void setCountrykey(String countrykey) {
		this.countrykey = countrykey;
	}
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		if (countrykey == null || countrykey.length() == 0) {
			errors.add("countrykey", new ActionMessage("error.code.required"));
		}
		if (country == null || country.length() == 0) {
			errors.add("country", new ActionMessage("error.country.required"));
		}
		
		if (action.equals("Create")) {
			if (Util.invalidChars(this.countrykey)) errors.add("countrykey", new ActionMessage("error.code.invalidchars"));
		}
		
		return errors;

	}

}
