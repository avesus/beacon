package com.bureaueye.beacon.form.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class OrderprodForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;

	private java.lang.String _orderprodId;

	// fields
	private java.lang.String _surftemp = "0.0";
	private boolean _deleted;
	private java.lang.String _volunit;
	private String _productkey;
	private java.lang.String _ldgtemp = "0.0";
	private java.lang.String _comprt = "0";
	private java.lang.String _volume = "0.0";
	private java.lang.String _tempunit;
	private java.lang.String _wghtunit;
	private java.lang.String _lqdtemp = "0.0";
	private java.lang.String _orderno;
	private java.lang.String _orderhdrId;
	private java.lang.String _weight = "0.0";
	private java.lang.String _imo;
	private java.lang.String _dchtemp = "0.0";
	private java.lang.String _productname;
	private java.lang.String _unno;



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
	public java.lang.String getOrderprodId () {
		return _orderprodId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _id the new ID
	 */
	public void setOrderprodId (java.lang.String _orderprodId) {
		this._orderprodId = _orderprodId;
	}





	/**
	 * Return the value associated with the column: SURFTEMP
	 */
	public java.lang.String getSurftemp () {
		return _surftemp;
	}

	/**
	 * Set the value related to the column: SURFTEMP
	 * @param _surftemp the SURFTEMP value
	 */
	public void setSurftemp (java.lang.String _surftemp) {
		this._surftemp = _surftemp;
	}





	/**
	 * Return the value associated with the column: DELETED
	 */
	public boolean isDeleted () {
		return _deleted;
	}

	/**
	 * Set the value related to the column: DELETED
	 * @param _deleted the DELETED value
	 */
	public void setDeleted (boolean _deleted) {
		this._deleted = _deleted;
	}



	/**
	 * Return the value associated with the column: VOLUNIT
	 */
	public java.lang.String getVolunit () {
		return _volunit;
	}

	/**
	 * Set the value related to the column: VOLUNIT
	 * @param _volunit the VOLUNIT value
	 */
	public void setVolunit (java.lang.String _volunit) {
		this._volunit = _volunit;
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
	 * Return the value associated with the column: LDGTEMP
	 */
	public java.lang.String getLdgtemp () {
		return _ldgtemp;
	}

	/**
	 * Set the value related to the column: LDGTEMP
	 * @param _ldgtemp the LDGTEMP value
	 */
	public void setLdgtemp (java.lang.String _ldgtemp) {
		this._ldgtemp = _ldgtemp;
	}


	/**
	 * Return the value associated with the column: COMPRT
	 */
	public java.lang.String getComprt () {
		return _comprt;
	}

	/**
	 * Set the value related to the column: COMPRT
	 * @param _comprt the COMPRT value
	 */
	public void setComprt (java.lang.String _comprt) {
		this._comprt = _comprt;
	}


	/**
	 * Return the value associated with the column: VOLUME
	 */
	public java.lang.String getVolume () {
		return _volume;
	}

	/**
	 * Set the value related to the column: VOLUME
	 * @param _volume the VOLUME value
	 */
	public void setVolume (java.lang.String _volume) {
		this._volume = _volume;
	}


	/**
	 * Return the value associated with the column: TEMPUNIT
	 */
	public java.lang.String getTempunit () {
		return _tempunit;
	}

	/**
	 * Set the value related to the column: TEMPUNIT
	 * @param _tempunit the TEMPUNIT value
	 */
	public void setTempunit (java.lang.String _tempunit) {
		this._tempunit = _tempunit;
	}


	/**
	 * Return the value associated with the column: WGHTUNIT
	 */
	public java.lang.String getWghtunit () {
		return _wghtunit;
	}

	/**
	 * Set the value related to the column: WGHTUNIT
	 * @param _wghtunit the WGHTUNIT value
	 */
	public void setWghtunit (java.lang.String _wghtunit) {
		this._wghtunit = _wghtunit;
	}


	/**
	 * Return the value associated with the column: LQDTEMP
	 */
	public java.lang.String getLqdtemp () {
		return _lqdtemp;
	}

	/**
	 * Set the value related to the column: LQDTEMP
	 * @param _lqdtemp the LQDTEMP value
	 */
	public void setLqdtemp (java.lang.String _lqdtemp) {
		this._lqdtemp = _lqdtemp;
	}


	/**
	 * Return the value associated with the column: ORDERNO
	 */
	public java.lang.String getOrderno () {
		return _orderno;
	}

	/**
	 * Set the value related to the column: ORDERNO
	 */
	public void setOrderno (java.lang.String _orderno) {
		this._orderno = _orderno;
	}


	/**
	 * Return the value associated with the column: ORDERHDR_ID
	 */
	public java.lang.String getOrderhdrId () {
		return _orderhdrId;
	}

	/**
	 * Set the value related to the column: ORDERHDR_ID
	 */
	public void setOrderhdrId (java.lang.String _orderhdrId) {
		this._orderhdrId = _orderhdrId;
	}


	/**
	 * Return the value associated with the column: WEIGHT
	 */
	public java.lang.String getWeight () {
		return _weight;
	}

	/**
	 * Set the value related to the column: WEIGHT
	 * @param _weight the WEIGHT value
	 */
	public void setWeight (java.lang.String _weight) {
		this._weight = _weight;
	}



	/**
	 * Return the value associated with the column: IMO
	 */
	public java.lang.String getImo () {
		return _imo;
	}

	/**
	 * Set the value related to the column: IMO
	 * @param _imo the IMO value
	 */
	public void setImo (java.lang.String _imo) {
		this._imo = _imo;
	}




	/**
	 * Return the value associated with the column: DCHTEMP
	 */
	public java.lang.String getDchtemp () {
		return _dchtemp;
	}

	/**
	 * Set the value related to the column: DCHTEMP
	 * @param _dchtemp the DCHTEMP value
	 */
	public void setDchtemp (java.lang.String _dchtemp) {
		this._dchtemp = _dchtemp;
	}


	/**
	 * Return the value associated with the column: productname
	 */
	public java.lang.String getProductname () {
		return _productname;
	}

	/**
	 * Set the value related to the column: productname
	 * @param _productname the productname value
	 */
	public void setProductname (java.lang.String _productname) {
		this._productname = _productname;
	}


	/**
	 * Return the value associated with the column: UNNO
	 */
	public java.lang.String getUnno () {
		return _unno;
	}

	/**
	 * Set the value related to the column: UNNO
	 * @param _unno the UNNO value
	 */
	public void setUnno (java.lang.String _unno) {
		this._unno = _unno;
	}


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();		


		addErrorIfBlank(errors, "Product", _productkey, "error.product.required");

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
