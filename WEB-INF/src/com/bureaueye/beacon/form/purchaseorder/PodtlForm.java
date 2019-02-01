package com.bureaueye.beacon.form.purchaseorder;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;




public final class PodtlForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
	
	
	// primary key
	private java.lang.String _podtlId;
	private java.lang.String _pohdrId;
	
	
	// fields
	private java.lang.String _eqpkeyp5;
	private java.lang.String _eqpkeyp2;
	private java.lang.String _eqpkeyp6;	
	private java.lang.String _eqpkeyp7;
	private java.lang.String _eqpkeyp3;
	private java.lang.String _eqpkeyp4;
	private java.lang.String _eqpkeyp9;
	private java.lang.String _eqpkeyp8;
	private java.lang.String _eqpkeyp10;
	private java.lang.String _eqpkeyp1;
	
	private java.lang.String _glcode1;
	private java.lang.String _totalamt = "0.0";
	private java.lang.String _rateamt = "0.0";
	private java.lang.String _qtyrcvd = "0";
	private java.lang.String _qty = "0";;
	private java.lang.String _txt1;
	private java.lang.String _txt2;
	private java.lang.String _glcode4;
	private java.lang.String _glcode3;
	private java.lang.String _glcode2;

	

	
	
	// collections

	
    public String getCopyId() {return (this._copyId);}
    public void setCopyId(String _copyId) {this._copyId = _copyId;}
    
    
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
     *  column="PODTL_ID"
     */
	public java.lang.String getPodtlId () {
		return _podtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param __podtlId the new ID
	 */
	public void setPodtlId (java.lang.String _podtlId) {
		this._podtlId = _podtlId;
	}


	/**
	 * Return the value associated with the column: POHDR_ID
	 */
	public java.lang.String getPohdrId () {
		return _pohdrId;
	}

	/**
	 * Set the value related to the column: POHDR_ID
	 * @param __pohdrId the POHDR_ID value
	 */
	public void setPohdrId (java.lang.String _pohdrId) {
		this._pohdrId = _pohdrId;
	}
	
	
	
	

	/**
	 * Return the value associated with the column: eqpkeyp5
	 */
	public java.lang.String getEqpkeyp5 () {
		return _eqpkeyp5;
	}

	/**
	 * Set the value related to the column: eqpkeyp5
	 * @param _eqpkeyp5 the eqpkeyp5 value
	 */
	public void setEqpkeyp5 (java.lang.String _eqpkeyp5) {
		this._eqpkeyp5 = _eqpkeyp5;
	}





	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return _eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param _eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String _eqpkeyp2) {
		this._eqpkeyp2 = _eqpkeyp2;
	}



	/**
	 * Return the value associated with the column: eqpkeyp7
	 */
	public java.lang.String getEqpkeyp7 () {
		return _eqpkeyp7;
	}

	/**
	 * Set the value related to the column: eqpkeyp7
	 * @param _eqpkeyp7 the eqpkeyp7 value
	 */
	public void setEqpkeyp7 (java.lang.String _eqpkeyp7) {
		this._eqpkeyp7 = _eqpkeyp7;
	}



	/**
	 * Return the value associated with the column: eqpkeyp3
	 */
	public java.lang.String getEqpkeyp3 () {
		return _eqpkeyp3;
	}

	/**
	 * Set the value related to the column: eqpkeyp3
	 * @param _eqpkeyp3 the eqpkeyp3 value
	 */
	public void setEqpkeyp3 (java.lang.String _eqpkeyp3) {
		this._eqpkeyp3 = _eqpkeyp3;
	}




	/**
	 * Return the value associated with the column: eqpkeyp4
	 */
	public java.lang.String getEqpkeyp4 () {
		return _eqpkeyp4;
	}

	/**
	 * Set the value related to the column: eqpkeyp4
	 * @param _eqpkeyp4 the eqpkeyp4 value
	 */
	public void setEqpkeyp4 (java.lang.String _eqpkeyp4) {
		this._eqpkeyp4 = _eqpkeyp4;
	}




	/**
	 * Return the value associated with the column: eqpkeyp9
	 */
	public java.lang.String getEqpkeyp9 () {
		return _eqpkeyp9;
	}

	/**
	 * Set the value related to the column: eqpkeyp9
	 * @param _eqpkeyp9 the eqpkeyp9 value
	 */
	public void setEqpkeyp9 (java.lang.String _eqpkeyp9) {
		this._eqpkeyp9 = _eqpkeyp9;
	}





	/**
	 * Return the value associated with the column: eqpkeyp8
	 */
	public java.lang.String getEqpkeyp8 () {
		return _eqpkeyp8;
	}

	/**
	 * Set the value related to the column: eqpkeyp8
	 * @param _eqpkeyp8 the eqpkeyp8 value
	 */
	public void setEqpkeyp8 (java.lang.String _eqpkeyp8) {
		this._eqpkeyp8 = _eqpkeyp8;
	}


	/**
	 * Return the value associated with the column: eqpkeyp10
	 */
	public java.lang.String getEqpkeyp10 () {
		return _eqpkeyp10;
	}

	/**
	 * Set the value related to the column: eqpkeyp10
	 * @param _eqpkeyp10 the eqpkeyp10 value
	 */
	public void setEqpkeyp10 (java.lang.String _eqpkeyp10) {
		this._eqpkeyp10 = _eqpkeyp10;
	}



	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return _eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param _eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String _eqpkeyp1) {
		this._eqpkeyp1 = _eqpkeyp1;
	}




	/**
	 * Return the value associated with the column: eqpkeyp6
	 */
	public java.lang.String getEqpkeyp6 () {
		return _eqpkeyp6;
	}

	/**
	 * Set the value related to the column: eqpkeyp6
	 * @param _eqpkeyp6 the eqpkeyp6 value
	 */
	public void setEqpkeyp6 (java.lang.String _eqpkeyp6) {
		this._eqpkeyp6 = _eqpkeyp6;
	}






	/**
	 * Return the value associated with the column: glcode1
	 */
	public java.lang.String getGlcode1 () {
		return _glcode1;
	}

	/**
	 * Set the value related to the column: glcode1
	 * @param _glcode1 the glcode1 value
	 */
	public void setGlcode1 (java.lang.String _glcode1) {
		this._glcode1 = _glcode1;
	}




	/**
	 * Return the value associated with the column: totalamt
	 */
	public java.lang.String getTotalamt () {
		return _totalamt;
	}

	/**
	 * Set the value related to the column: totalamt
	 * @param _totalamt the totalamt value
	 */
	public void setTotalamt (java.lang.String _totalamt) {
		this._totalamt = _totalamt;
	}



	/**
	 * Return the value associated with the column: rateamt
	 */
	public java.lang.String getRateamt () {
		return _rateamt;
	}

	/**
	 * Set the value related to the column: rateamt
	 * @param _rateamt the rateamt value
	 */
	public void setRateamt (java.lang.String _rateamt) {
		this._rateamt = _rateamt;
	}




	/**
	 * Return the value associated with the column: qtyrcvd
	 */
	public java.lang.String getQtyrcvd () {
		return _qtyrcvd;
	}

	/**
	 * Set the value related to the column: qtyrcvd
	 * @param _qtyrcvd the qtyrcvd value
	 */
	public void setQtyrcvd (java.lang.String _qtyrcvd) {
		this._qtyrcvd = _qtyrcvd;
	}




	/**
	 * Return the value associated with the column: qty
	 */
	public java.lang.String getQty () {
		return _qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param _qty the qty value
	 */
	public void setQty (java.lang.String _qty) {
		this._qty = _qty;
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


	/**
	 * Return the value associated with the column: glcode4
	 */
	public java.lang.String getGlcode4 () {
		return _glcode4;
	}

	/**
	 * Set the value related to the column: glcode4
	 * @param _glcode4 the glcode4 value
	 */
	public void setGlcode4 (java.lang.String _glcode4) {
		this._glcode4 = _glcode4;
	}




	/**
	 * Return the value associated with the column: glcode3
	 */
	public java.lang.String getGlcode3 () {
		return _glcode3;
	}

	/**
	 * Set the value related to the column: glcode3
	 * @param _glcode3 the glcode3 value
	 */
	public void setGlcode3 (java.lang.String _glcode3) {
		this._glcode3 = _glcode3;
	}


	/**
	 * Return the value associated with the column: glcode2
	 */
	public java.lang.String getGlcode2 () {
		return _glcode2;
	}

	/**
	 * Set the value related to the column: glcode2
	 * @param _glcode2 the glcode2 value
	 */
	public void setGlcode2 (java.lang.String _glcode2) {
		this._glcode2 = _glcode2;
	}



	
	
	
	
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
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
		
		//addErrorIfBlank(errors, "eqpkeyp1", _eqpkeyp1, "error.eqpkeyp1.required");      
		//addErrorIfBlank(errors, "eqpkeyp2", _eqpkeyp2, "error.eqpkeyp2.required"); 
		addErrorIfBlank(errors, "txt1", _txt1, "error.description.required");    
		
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
