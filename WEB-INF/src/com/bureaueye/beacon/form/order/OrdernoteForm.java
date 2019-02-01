package com.bureaueye.beacon.form.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;

public final class OrdernoteForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;

	private java.lang.String _ordernoteId;

	// fields
	private java.lang.String _note2;
	private java.lang.String _category;
	private java.lang.String _status;
	private java.lang.String _orderhdrId;
	private java.lang.String _createuserid;
	private java.lang.String _orderno;
	private java.lang.String _note1;
	private java.util.Date _createdate;
	private java.lang.String _createtime;
	private java.lang.String _priority;


	

	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public java.lang.String getOrdernoteId () {
		return _ordernoteId;
	}

	/**
	 * Set the unique identifier of this class
	 */
	public void setOrdernoteId (java.lang.String _ordernoteId) {
		this._ordernoteId = _ordernoteId;
	}



	/**
	 * Return the value associated with the column: note2
	 */
	public java.lang.String getNote2 () {
		return _note2;
	}

	/**
	 * Set the value related to the column: note2
	 * @param _note2 the note2 value
	 */
	public void setNote2 (java.lang.String _note2) {
		this._note2 = _note2;
	}




	/**
	 * Return the value associated with the column: category
	 */
	public java.lang.String getCategory () {
		return _category;
	}

	/**
	 * Set the value related to the column: category
	 * @param _category the category value
	 */
	public void setCategory (java.lang.String _category) {
		this._category = _category;
	}


	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return _status;
	}

	/**
	 * Set the value related to the column: status
	 * @param _status the status value
	 */
	public void setStatus (java.lang.String _status) {
		this._status = _status;
	}



	/**
	 */
	public java.lang.String getOrderhdrId () {
		return _orderhdrId;
	}

	/**
	 */
	public void setOrderhdrId (java.lang.String _orderhdrId) {
		this._orderhdrId = _orderhdrId;
	}


	/**
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid_ () {
		return _createuserid;
	}

	/**
	 * Set the value related to the column: CREATEUSERID
	 * @param _createuserid the CREATEUSERID value
	 */
	public void setCreateuserid (java.lang.String _createuserid) {
		this._createuserid = _createuserid;
	}


	/**
	 * Return the value associated with the column: orderno
	 */
	public java.lang.String getOrderno () {
		return _orderno;
	}

	/**
	 */
	public void setOrderno (java.lang.String _orderno) {
		this._orderno = _orderno;
	}


	/**
	 * Return the value associated with the column: note1
	 */
	public java.lang.String getNote1 () {
		return _note1;
	}

	/**
	 * Set the value related to the column: note1
	 * @param _note1 the note1 value
	 */
	public void setNote1 (java.lang.String _note1) {
		this._note1 = _note1;
	}


	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate_ () {
		return _createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param _createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date _createdate) {
		this._createdate = _createdate;
	}




	/**
	 * Return the value associated with the column: CREATETIME
	 */
	public java.lang.String getCreatetime_ () {
		return _createtime;
	}

	/**
	 * Set the value related to the column: CREATETIME
	 * @param _createtime the CREATETIME value
	 */
	public void setCreatetime (java.lang.String _createtime) {
		this._createtime = _createtime;
	}



	/**
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return _priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param _priority the priority value
	 */
	public void setPriority (java.lang.String _priority) {
		this._priority = _priority;
	}


	






	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();

		addErrorIfBlank(errors, "note1", _note1, "error.notes.required");

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
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();		
		
		return keysToSkip;
	}
	
	
}
