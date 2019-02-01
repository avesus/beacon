package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class UnitfitForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
	
	// primary key
	private java.lang.Integer unitfitId;
	
	// fields
	private java.lang.String unitkey;
	private java.lang.String fitgrpkey;
	private java.lang.String fittypkey;
	private java.lang.String fitcodkey;
	private java.lang.String fitpos;
	private java.lang.String fitcoddes;
	private java.lang.Integer seqno;
	private java.lang.Integer recno;
	private java.lang.String recordkey;
	private java.lang.String mandrkey;
	private boolean deleted;
	private java.lang.Integer mandrlinkkey;
	private java.lang.Integer unitId;
	
	

	

	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="UNITFIT_ID"
     */
	public java.lang.Integer getUnitfitId () {
		return unitfitId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param unitfitId the new ID
	 */
	public void setUnitfitId (java.lang.Integer unitfitId) {
		this.unitfitId = unitfitId;
	}




	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String unitkey) {
		this.unitkey = unitkey;
	}



	/**
	 * Return the value associated with the column: fitgrpkey
	 */
	public java.lang.String getFitgrpkey () {
		return fitgrpkey;
	}

	/**
	 * Set the value related to the column: fitgrpkey
	 * @param fitgrpkey the fitgrpkey value
	 */
	public void setFitgrpkey (java.lang.String fitgrpkey) {
		this.fitgrpkey = fitgrpkey;
	}



	/**
	 * Return the value associated with the column: fittypkey
	 */
	public java.lang.String getFittypkey () {
		return fittypkey;
	}

	/**
	 * Set the value related to the column: fittypkey
	 * @param fittypkey the fittypkey value
	 */
	public void setFittypkey (java.lang.String fittypkey) {
		this.fittypkey = fittypkey;
	}



	/**
	 * Return the value associated with the column: fitcodkey
	 */
	public java.lang.String getFitcodkey () {
		return fitcodkey;
	}

	/**
	 * Set the value related to the column: fitcodkey
	 * @param fitcodkey the fitcodkey value
	 */
	public void setFitcodkey (java.lang.String fitcodkey) {
		this.fitcodkey = fitcodkey;
	}



	/**
	 * Return the value associated with the column: fitpos
	 */
	public java.lang.String getFitpos () {
		return fitpos;
	}

	/**
	 * Set the value related to the column: fitpos
	 * @param fitpos the fitpos value
	 */
	public void setFitpos (java.lang.String fitpos) {
		this.fitpos = fitpos;
	}






	/**
	 * Return the value associated with the column: fitcoddes
	 */
	public java.lang.String getFitcoddes () {
		return fitcoddes;
	}

	/**
	 * Set the value related to the column: fitcoddes
	 * @param fitcoddes the fitcoddes value
	 */
	public void setFitcoddes (java.lang.String fitcoddes) {
		this.fitcoddes = fitcoddes;
	}






	/**
	 * Return the value associated with the column: seqno
	 */
	public java.lang.Integer getSeqno () {
		return seqno;
	}

	/**
	 * Set the value related to the column: seqno
	 * @param seqno the seqno value
	 */
	public void setSeqno (java.lang.Integer seqno) {
		this.seqno = seqno;
	}



	/**
	 * Return the value associated with the column: recno
	 */
	public java.lang.Integer getRecno () {
		return recno;
	}

	/**
	 * Set the value related to the column: recno
	 * @param recno the recno value
	 */
	public void setRecno (java.lang.Integer recno) {
		this.recno = recno;
	}



	/**
	 * Return the value associated with the column: recordkey
	 */
	public java.lang.String getRecordkey () {
		return recordkey;
	}

	/**
	 * Set the value related to the column: recordkey
	 * @param recordkey the recordkey value
	 */
	public void setRecordkey (java.lang.String recordkey) {
		this.recordkey = recordkey;
	}







	/**
	 * Return the value associated with the column: mandrkey
	 */
	public java.lang.String getMandrkey () {
		return mandrkey;
	}

	/**
	 * Set the value related to the column: mandrkey
	 * @param mandrkey the mandrkey value
	 */
	public void setMandrkey (java.lang.String mandrkey) {
		this.mandrkey = mandrkey;
	}



	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param deleted the deleted value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: mandrlinkkey
	 */
	public java.lang.Integer getMandrlinkkey () {
		return mandrlinkkey;
	}

	/**
	 * Set the value related to the column: mandrlinkkey
	 * @param mandrlinkkey the mandrlinkkey value
	 */
	public void setMandrlinkkey (java.lang.Integer mandrlinkkey) {
		this.mandrlinkkey = mandrlinkkey;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.Integer getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.Integer unitId) {
		this.unitId = unitId;
	}

	
	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
        if ((fitgrpkey == null) || (fitgrpkey.length() < 1))
            errors.add("fitgrpkey",
                    new ActionMessage("error.fitgrp.required")); 
              	
        if ((fittypkey == null) || (fittypkey.length() < 1))
            errors.add("fittypekey",
                    new ActionMessage("error.fittyp.required")); 
      
		return errors;

	}

/*	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}*/

	
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
