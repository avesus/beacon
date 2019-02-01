package com.bureaueye.beacon.form.system;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;




public final class SystemcodeForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";


	// primary key
	private java.lang.String typekey;
	private java.lang.String codekey;
	
	// fields
	private java.lang.String descr;

	
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	
	
	/**
	 * Return the value associated with the column: typekey
	 */
	public java.lang.String getTypekey () {
		return typekey;
	}

	/**
	 * Set the value related to the column: typekey
	 * @param typekey the typekey value
	 */
	public void setTypekey (java.lang.String typekey) {
		this.typekey = typekey;
	}



	/**
	 * Return the value associated with the column: codekey
	 */
	public java.lang.String getCodekey () {
		return codekey;
	}

	/**
	 * Set the value related to the column: codekey
	 * @param codekey the codekey value
	 */
	public void setCodekey (java.lang.String codekey) {
		this.codekey = codekey;
	}







	/**
	 * Return the value associated with the column: descr
	 */
	public java.lang.String getDescr () {
		return descr;
	}

	/**
	 * Set the value related to the column: descr
	 * @param descr the descr value
	 */
	public void setDescr (java.lang.String descr) {
		this.descr = descr;
	}






	
	

	@Override
	public String toString () {
		return super.toString();
	}


	
	

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
       	

		addErrorIfBlank(errors, "codekey", codekey, "error.codekey.required");  
		addErrorIfBlank(errors, "typekey", typekey, "error.typekey.required");      
		addErrorIfBlank(errors, "descr", descr, "error.descr.required");     
		
      
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

	
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	@Override
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();
		
		return keysToSkip;
	}
	
	
}
