package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public final class AddresscontactForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	private String action;

	private String addrkey;

	private String contactkey;

	private String name;

	private String email;

	private String phone;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAddrkey() {
		return addrkey;
	}

	public void setAddrkey(String addrkey) {
		this.addrkey = addrkey;
	}

	public String getContactkey() {
		return contactkey;
	}

	public void setContactkey(String contactkey) {
		this.contactkey = contactkey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (action == null || action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();

		addErrorIfBlank(errors, "contactkey", contactkey, "error.code.required");
		addErrorIfBlank(errors, "name", name, "error.name.required");

		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

}
