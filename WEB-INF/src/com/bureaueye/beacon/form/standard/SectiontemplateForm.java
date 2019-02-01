package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public final class SectiontemplateForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;
	private String readonly = "false";
	
	// primary key
	private java.lang.String sectiontemplateId;

	// fields
	private java.lang.String sectionkey;
	private java.lang.String shipmethod;
	private java.lang.String seqno;
	private java.lang.String fromlocationcode;
	private java.lang.String tolocationcode;
	private java.lang.String vendoraddrkey;
	
	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SECTIONTEMPLATE_ID"
     */
	public java.lang.String getSectiontemplateId () {
		return sectiontemplateId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param sectiontemplateId the new ID
	 */
	public void setSectiontemplateId (java.lang.String sectiontemplateId) {
		this.sectiontemplateId = sectiontemplateId;
	}




	/**
	 * Return the value associated with the column: sectionkey
	 */
	public java.lang.String getSectionkey () {
		return sectionkey;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param sectionkey the sectionkey value
	 */
	public void setSectionkey (java.lang.String sectionkey) {
		this.sectionkey = sectionkey;
	}



	/**
	 * Return the value associated with the column: SHIPMETHOD
	 */
	public java.lang.String getShipmethod () {
		return shipmethod;
	}

	/**
	 * Set the value related to the column: SHIPMETHOD
	 * @param shipmethodId the SHIPMETHOD value
	 */
	public void setShipmethod (java.lang.String shipmethod) {
		this.shipmethod = shipmethod;
	}



	/**
	 * Return the value associated with the column: seqno
	 */
	public java.lang.String getSeqno () {
		return seqno;
	}

	/**
	 * Set the value related to the column: seqno
	 * @param seqno the seqno value
	 */
	public void setSeqno (java.lang.String seqno) {
		this.seqno = seqno;
	}



	/**
	 * Return the value associated with the column: fromlocationcode
	 */
	public java.lang.String getFromlocationcode () {
		return fromlocationcode;
	}

	/**
	 * Set the value related to the column: fromlocationcode
	 * @param fromlocationcode the fromlocationcode value
	 */
	public void setFromlocationcode (java.lang.String fromlocationcode) {
		this.fromlocationcode = fromlocationcode;
	}



	/**
	 * Return the value associated with the column: tolocationcode
	 */
	public java.lang.String getTolocationcode () {
		return tolocationcode;
	}

	/**
	 * Set the value related to the column: tolocationcode
	 * @param tolocationcode the tolocationcode value
	 */
	public void setTolocationcode (java.lang.String tolocationcode) {
		this.tolocationcode = tolocationcode;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}






	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}

		ActionErrors errors = new ActionErrors();


		addErrorIfBlank(errors, "seqno", seqno,	"error.seqno.required");
		addErrorIfBlank(errors, "sectionkey", sectionkey,	"error.sectionkey.required");
		addErrorIfBlank(errors, "fromlocation", fromlocationcode, "error.fromlocation.required");
		addErrorIfBlank(errors, "tolocation", tolocationcode, "error.tolocation.required");
		
		
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

}
