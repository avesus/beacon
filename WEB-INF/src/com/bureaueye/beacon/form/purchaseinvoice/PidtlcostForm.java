package com.bureaueye.beacon.form.purchaseinvoice;

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
 * NT	2013-12-03		201300028		Purchase Invoice Cost allocation - make Text a mandatory field
 * 
 */
public final class PidtlcostForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	// primary key
	private java.lang.String pidtlcostId;
	private java.lang.String pidtlId;
	
	
	// fields
	private java.lang.String cstamtalloc="0.0";
	private java.lang.String cstamttotal="0.0";
	private java.lang.String ccykey;
	private java.lang.String vendoraddrkey;
	private java.lang.String costkey;
	private String unitId;
	
	private java.lang.String jobhdrId;
	private java.lang.String jobmovId;
	private java.lang.String jobcostId;
	
	private java.lang.String _txt1;
	private java.lang.String _txt2;
	private boolean _miscflag;
	
	// collections
	private java.util.List _vendorjobcosts;
	private java.util.List _pidtlcosts;	
	


	
	


	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PIDTLCOST_ID"
     */
	public String getPidtlcostId () {
		return pidtlcostId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param pidtlcostId the new ID
	 */
	public void setPidtlcostId (String pidtlcostId) {
		this.pidtlcostId = pidtlcostId;
	}


	public boolean isMiscflag() {
		return _miscflag;
	}
	public void setMiscflag(boolean _miscflag) {
		this._miscflag = _miscflag;
	}



	/**
	 * Return the value associated with the column: PIDTL_ID
	 */
	public String getPidtlId () {
		return pidtlId;
	}

	/**
	 * Set the value related to the column: PIDTL_ID
	 * @param pidtlId the PIDTL_ID value
	 */
	public void setPidtlId (String pidtlId) {
		this.pidtlId = pidtlId;
	}



	public String getJobhdrId () {return jobhdrId;}
	public void setJobhdrId (String jobhdrId) {this.jobhdrId = jobhdrId;}
	
	public String getJobmovId () {return jobmovId;}
	public void setJobmovId (String jobmovId) {this.jobmovId = jobmovId;}
	
	public String getJobcostId () {return jobcostId;}
	public void setJobcostId (String jobcostId) {this.jobcostId = jobcostId;}
	
	



	/**
	 * Return the value associated with the column: cstamtalloc
	 */
	public String getCstamtalloc () {
		return cstamtalloc;
	}

	/**
	 * Set the value related to the column: cstamtalloc
	 * @param cstamtalloc the cstamtalloc value
	 */
	public void setCstamtalloc (String cstamtalloc) {
		this.cstamtalloc = cstamtalloc;
	}



	/**
	 * Return the value associated with the column: cstamttotal
	 */
	public String getCstamttotal () {
		return cstamttotal;
	}

	/**
	 * Set the value related to the column: cstamttotal
	 * @param cstamttotal the cstamttotal value
	 */
	public void setCstamttotal (String cstamttotal) {
		this.cstamttotal = cstamttotal;
	}



	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
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



	/**
	 * Return the value associated with the column: costkey
	 */
	public java.lang.String getCostkey () {
		return costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCostkey (java.lang.String costkey) {
		this.costkey = costkey;
	}






	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public String getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (String unitId) {
		this.unitId = unitId;
	}


	
	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1 () {
		return _txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * @param _txt1 the txt1 value
	 */
	public void setTxt1 (java.lang.String _txt1) {
		this._txt1 = _txt1;
	}




	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2 () {
		return _txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * @param _txt2 the txt2 value
	 */
	public void setTxt2 (java.lang.String _txt2) {
		this._txt2 = _txt2;
	}
	
	
	
	public java.util.List getVendorjobcosts () {
		return this._vendorjobcosts;
	}
	public void setVendorjobcosts (java.util.List _vendorjobcosts) {
		this._vendorjobcosts = _vendorjobcosts;
	}	
	public void addToVendorjobcosts (Object obj) {
		if (null == this._vendorjobcosts) this._vendorjobcosts = new java.util.LinkedList();
		this._vendorjobcosts.add(obj);
	}
	
	
	public java.util.List getPidtlcosts () {
		return this._pidtlcosts;
	}
	public void setPidtlcosts (java.util.List _pidtlcosts) {
		this._pidtlcosts = _pidtlcosts;
	}	
	public void addToPidtlcosts (Object obj) {
		if (null == this._pidtlcosts) this._pidtlcosts = new java.util.LinkedList();
		this._pidtlcosts.add(obj);
	}
	
	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();	
		

		addErrorIfBlank(errors, "costkey", costkey, "error.cost.required");   
		addErrorIfBlank(errors, "_txt1", _txt1, "error.text.required"); //201300028		
		
		
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
