package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public final class RegistrationForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String password;

	private String password2;

	private String pagesize;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();

		addErrorIfBlank(errors, "password", password, "error.password.required");
		addErrorIfBlank(errors, "pageSize", pagesize, "error.pageSize.required");

		if (!password.equals(password2)) {
			errors.add("password2", new ActionMessage("error.password.match"));
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
