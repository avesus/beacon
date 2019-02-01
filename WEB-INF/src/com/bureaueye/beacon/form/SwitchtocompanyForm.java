/*
 */

package com.bureaueye.beacon.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-02-25 201400004 Add 'Switch To' Company Function (DO NOT RELEASE TO BASE AT THE MOMENT - IT DOES WORK!!!)
 *
 */
public final class SwitchtocompanyForm extends ValidatorForm {

	// ----------------------------------------------------- Instance Variables

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 */
	private String companykey = null;

	// ----------------------------------------------------------- Properties

	/**
	 */
	public String getCompanykey() {
		return (this.companykey);
	}

	public void setCompanykey(String companykey) {
		this.companykey = companykey;
	}

	// --------------------------------------------------------- Public Methods

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.companykey = null;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		return errors;

	}

}
