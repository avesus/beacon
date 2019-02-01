package com.bureaueye.beacon.form.job;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class JobhdrForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	
	private String _action;
	private String _readonly = "false";

	// primary key
	private java.lang.String _jobhdrId;
	private java.lang.String _jobno;
	
	// fields
	private java.lang.String _movref;
	private java.lang.String _orderhdrId;
	private java.lang.String _unitId;	
	private java.lang.String _unitkey;
	private java.lang.String _sealnumbers;
	
	private java.lang.String sealnumber1;
	private java.lang.String sealnumber2;
	private java.lang.String sealnumber3;
	private java.lang.String sealnumber4;
	private java.lang.String sealnumber5;
	
	private java.lang.String _addinstruction;
	private java.lang.String _weightactualunit;
	private java.lang.String _weightactual = "0.0";
	
	private String _productkey;

	// collections
	private java.util.List _orderprods;
	
	
	
	public String getAction() {return _action;}

	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	
	public String getMovref() {
		return _movref;
	}

	public void setMovref(String _movref) {
		this._movref = _movref;
	}
	
	/**
	 * Return the value associated with the column: Orderprods
	 */
	public java.util.List getOrderprods () {
		return this._orderprods;
	}

	/**
	 * Set the value related to the column: Orderprods
	 * @param _orderprods the Orderprods value
	 */
	public void setOrderprods (java.util.List _orderprods) {
		this._orderprods = _orderprods;
	}
	
	public void addToOrderprods (Object obj) {
		if (null == this._orderprods) this._orderprods = new java.util.LinkedList();
		this._orderprods.add(obj);
	}

	
	
	/**
	 * Return the value associated with the column: productkey
	 */
	public String getProductkey () {
		return _productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param _productkey the productkey value
	 */
	public void setProductkey (String _productkey) {
		this._productkey = _productkey;
	}
	
	/**
	 */
	public java.lang.String getJobhdrId () {
		return _jobhdrId;
	}

	/**
	 */
	public void setJobhdrId (java.lang.String _jobhdrId) {
		this._jobhdrId = _jobhdrId;
	}

	
	/**
	 */
	public java.lang.String getJobno() {
		return _jobno;
	}

	/**
	 */
	public void setJobno(java.lang.String _jobno) {
		this._jobno = _jobno;
	}
	
	
	
	/**
	 */
	public java.lang.String getUnitId () {
		return _unitId;
	}

	/**
	 */
	public void setUnitId (java.lang.String _unitId) {
		this._unitId = _unitId;
	}

	/**
	 */
	public java.lang.String getUnitkey () {
		return _unitkey;
	}

	/**
	 */
	public void setUnitkey (java.lang.String _unitkey) {
		this._unitkey = _unitkey;
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
	 */
	public java.lang.String getSealnumbers() {return _sealnumbers;}
	/**
	 */
	public void setSealnumbers(java.lang.String _sealnumbers) {
		this._sealnumbers = _sealnumbers;
	}

	
	
	/**
	 */
	public java.lang.String getAddinstruction() {return _addinstruction;}
	/**
	 */
	public void setAddinstruction(java.lang.String _addinstruction) {
		this._addinstruction = _addinstruction;
	}

	/**
	 */
	public java.lang.String getWeightactualunit() {return _weightactualunit;}
	/**
	 */
	public void setWeightactualunit(java.lang.String _weightactualunit) {
		this._weightactualunit = _weightactualunit;
	}
	
	/**
	 */
	public java.lang.String getWeightactual() {return _weightactual;}
	/**
	 */
	public void setWeightactual(java.lang.String _weightactual) {
		this._weightactual = _weightactual;
	}
	

	

	/**
	 * Return the value associated with the column: sealnumber1
	 */
	public java.lang.String getSealnumber1 () {
		return sealnumber1;
	}

	/**
	 * Set the value related to the column: sealnumber1
	 * @param sealnumber1 the sealnumber1 value
	 */
	public void setSealnumber1 (java.lang.String sealnumber1) {
		this.sealnumber1 = sealnumber1;
	}



	/**
	 * Return the value associated with the column: sealnumber2
	 */
	public java.lang.String getSealnumber2 () {
		return sealnumber2;
	}

	/**
	 * Set the value related to the column: sealnumber2
	 * @param sealnumber2 the sealnumber2 value
	 */
	public void setSealnumber2 (java.lang.String sealnumber2) {
		this.sealnumber2 = sealnumber2;
	}



	/**
	 * Return the value associated with the column: sealnumber3
	 */
	public java.lang.String getSealnumber3 () {
		return sealnumber3;
	}

	/**
	 * Set the value related to the column: sealnumber3
	 * @param sealnumber3 the sealnumber3 value
	 */
	public void setSealnumber3 (java.lang.String sealnumber3) {
		this.sealnumber3 = sealnumber3;
	}



	/**
	 * Return the value associated with the column: sealnumber4
	 */
	public java.lang.String getSealnumber4 () {
		return sealnumber4;
	}

	/**
	 * Set the value related to the column: sealnumber4
	 * @param sealnumber4 the sealnumber4 value
	 */
	public void setSealnumber4 (java.lang.String sealnumber4) {
		this.sealnumber4 = sealnumber4;
	}



	/**
	 * Return the value associated with the column: sealnumber5
	 */
	public java.lang.String getSealnumber5 () {
		return sealnumber5;
	}

	/**
	 * Set the value related to the column: sealnumber5
	 * @param sealnumber5 the sealnumber5 value
	 */
	public void setSealnumber5 (java.lang.String sealnumber5) {
		this.sealnumber5 = sealnumber5;
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
		
		addErrorIfBlank(errors, "productkey", _productkey, "error.product.required");
		
		addErrorIfBlank(errors, "unitkey", _unitkey, "error.unit.required");

      
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
