package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.util.Util;


/**
 *
 * Amendments
 * ----------
 *
 * NT	2010-05-05		201000023			Add Vessel Flag to Vessel Maintenance
 *    
 */
public final class VesselForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String action;
	
	private String vesselkey;
	
	private String regno;
	
	private String vesselname;
	
	private java.lang.String vesselflag;
	
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getVesselkey() {
		return vesselkey;
	}
	
	public void setVesselkey(String vesselkey) {
		this.vesselkey = vesselkey;
	}
	
	public String getVesselname() {
		return vesselname;
	}
	
	public void setVesselname(String vesselname) {
		this.vesselname = vesselname;
	}
	
	
	
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	

	
	/**
	 * Return the value associated with the column: vesselflag
	 */
	public java.lang.String getVesselflag () {
		return vesselflag;
	}

	/**
	 * Set the value related to the column: vesselflag
	 * @param vesselflag the vesselflag value
	 */
	public void setVesselflag (java.lang.String vesselflag) {
		this.vesselflag = vesselflag;
	}
	
	
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}
		
		ActionErrors errors = new ActionErrors();
		
		addErrorIfBlank(errors, "vesselkey", vesselkey, "error.vesselkey.required");
		addErrorIfBlank(errors, "vesselname", vesselname, "error.name.required");
		
		if (action.equals("Create")) {
			if (Util.invalidChars(this.vesselkey)) errors.add("vesselkey", new ActionMessage("error.code.invalidchars"));
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
