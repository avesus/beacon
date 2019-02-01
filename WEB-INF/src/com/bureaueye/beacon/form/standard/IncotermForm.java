package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.util.Util;

public final class IncotermForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;

	private String incotermkey;

	private String description;

	private String txt;
	

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="incotermkey"
     */
	public java.lang.String getIncotermkey () {
		return incotermkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param incotermkey the new ID
	 */
	public void setIncotermkey (java.lang.String incotermkey) {
		this.incotermkey = incotermkey;
	}







	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: txt
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: txt
	 * @param txt the txt value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}




	
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		ActionErrors errors = new ActionErrors();

		
		addErrorIfBlank(errors, "incotermkey", incotermkey,
				"error.incoterm.required");
		addErrorIfBlank(errors, "descr", description, "error.description.required");


		if (action.equals("Create")) {
			if (Util.invalidChars(this.incotermkey)) errors.add("incotermkey", new ActionMessage("error.code.invalidchars"));
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
