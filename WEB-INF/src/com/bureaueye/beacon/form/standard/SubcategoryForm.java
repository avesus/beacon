package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;



/**
 *
 * Amendments
 * ----------
 *  
 */
public final class SubcategoryForm extends BaseForm {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";



	// primary key
	private java.lang.String subcategoryId;
	
	// fields
	private java.lang.String description;
	private java.lang.String subcategorycode;
	private java.lang.String categorycode;

	
	


	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}


	
	/**
     */
	public java.lang.String getSubcategoryId () {
		return subcategoryId;
	}

	/**
	 */
	public void setSubcategoryId (java.lang.String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	
	

	/**
     */
	public java.lang.String getCategorycode () {
		return categorycode;
	}

	/**
	 */
	public void setCategorycode (java.lang.String categorycode) {
		this.categorycode = categorycode;
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
	 * Return the value associated with the column: subcategorycode
	 */
	public java.lang.String getSubcategorycode () {
		return subcategorycode;
	}

	/**
	 * Set the value related to the column: subcategorycode
	 * @param subcategorycode the subcategorycode value
	 */
	public void setSubcategorycode (java.lang.String subcategorycode) {
		this.subcategorycode = subcategorycode;
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


		addErrorIfBlank(errors, "subcategorycode", subcategorycode, "error.subcategorycode.required"); 
		addErrorIfBlank(errors, "categorycode", categorycode, "error.categorycode.required");
		addErrorIfBlank(errors, "description", description, "error.description.required");         


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
