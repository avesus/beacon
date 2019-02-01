package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.util.Util;

public final class ChargeForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;
	private String chargekey;
	
	private String ldesc;
	private boolean tax;

		
	private java.lang.String accracct;
	private java.lang.String incacct;	
	private java.lang.String actlacct;
	
	private java.lang.String accsysitemid;
	
	
	
	public java.lang.String getAccsysitemid () {
		return accsysitemid;
	}
	public void setAccsysitemid (java.lang.String accsysitemid) {
		this.accsysitemid = accsysitemid;
	}
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getChargekey() {
		return chargekey;
	}

	public void setChargekey(String chargekey) {
		this.chargekey = chargekey;
	}

	public String getLdesc() {
		return ldesc;
	}

	public void setLdesc(String ldesc) {
		this.ldesc = ldesc;
	}

	public boolean isTax() {
		return tax;
	}

	public void setTax(boolean tax) {
		this.tax = tax;
	}

	
	
	
	
	
	/**
	 * Return the value associated with the column: ACTLACCT
	 */
	public java.lang.String getActlacct () {
		return actlacct;
	}
	/**
	 * Set the value related to the column: ACTLACCT
	 * @param actlacct the ACTLACCT value
	 */
	public void setActlacct (java.lang.String actlacct) {
		this.actlacct = actlacct;
	}
	
	/**
	 * Return the value associated with the column: ACCRACCT
	 */
	public java.lang.String getAccracct () {
		return accracct;
	}
	/**
	 * Set the value related to the column: ACCRACCT
	 * @param accracct the ACCRACCT value
	 */
	public void setAccracct (java.lang.String accracct) {
		this.accracct = accracct;
	}
	
	/**
	 * Return the value associated with the column: INCACCT
	 */
	public java.lang.String getIncacct () {
		return incacct;
	}
	/**
	 * Set the value related to the column: INCACCT
	 * @param incacct the INCACCT value
	 */
	public void setIncacct (java.lang.String incacct) {
		this.incacct = incacct;
	}
	
	
	
	
	
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		ActionErrors errors = new ActionErrors();

		addErrorIfBlank(errors, "chargekey", chargekey,
				"error.chargekey.required");
		addErrorIfBlank(errors, "ldesc", ldesc, "error.description.required");

		if (action.equals("Create")) {
			if (Util.invalidChars(this.chargekey)) errors.add("chargekey", new ActionMessage("error.code.invalidchars"));
		}
		
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

}
