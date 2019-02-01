package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.util.Util;

public final class CcyForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;

	private String ccykey;

	private String ccyname;

	private String ccyshort;

	private boolean euro;

	private boolean prtpre;

	private String prtchr;

	private String decpl;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCcykey() {
		return ccykey;
	}

	public void setCcykey(String ccykey) {
		this.ccykey = ccykey;
	}

	public String getCcyname() {
		return ccyname;
	}

	public void setCcyname(String ccyname) {
		this.ccyname = ccyname;
	}

	public String getCcyshort() {
		return ccyshort;
	}

	public void setCcyshort(String ccyshort) {
		this.ccyshort = ccyshort;
	}

	public String getDecpl() {
		return decpl;
	}

	public void setDecpl(String decpl) {
		this.decpl = decpl;
	}

	public boolean isEuro() {
		return euro;
	}

	public void setEuro(boolean euro) {
		this.euro = euro;
	}

	public String getPrtchr() {
		return prtchr;
	}

	public void setPrtchr(String prtchr) {
		this.prtchr = prtchr;
	}

	public boolean isPrtpre() {
		return prtpre;
	}

	public void setPrtpre(boolean prtpre) {
		this.prtpre = prtpre;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete"))
			return null;

		ActionErrors errors = new ActionErrors();

		addErrorIfBlank(errors, "ccykey", ccykey, "error.ccykey.required");
		addErrorIfBlank(errors, "ccyname", ccyname, "error.name.required");
		addErrorIfBlank(errors, "ccyshort", ccyshort, "error.shortname.required");

		if (decpl == null || decpl.length() == 0) {
			decpl = "0";
		}

		if (action.equals("Create")) {
			if (Util.invalidChars(this.ccykey)) errors.add("ccykey", new ActionMessage("error.code.invalidchars"));
		}
		
		try {
			Integer.valueOf(decpl);
		} catch (NumberFormatException nfe) {
			errors.add("decpl", new ActionMessage("error.field.numeric"));
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
