package com.bureaueye.beacon.form.mandr;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;



public final class MandrdtlForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	
	
	// primary key
	private java.lang.String _mandrdtlId;

	// fields
	private java.lang.String _mandrhdrId;
	private java.lang.String _itemno;
	private java.lang.String _lastitemno;
	
	private java.lang.String _vendoraddrkey;
	private java.lang.String _ccykey;
	private java.lang.String _hdrccykey;
	private java.lang.String _costkey;
	private java.lang.String _damagecode;
	private java.lang.String _repaircode;
	private java.lang.String _componentcode;
	private java.lang.String _locationcode1;
	private java.lang.String _locationcode2;
	
	private java.lang.String _responsibilitycode;
	
	private String _xrate = "0.0";
	private String _laboramt = "0.0";
	private String _laborrate = "0.0";
	private String _laborhours = "0.0";
	private java.lang.String _materialtypecode;
	private String _materialamt = "0.0";
	private String _totalamt = "0.0";
	private java.lang.String _txt1;
	private java.lang.String _txt2;
	private java.lang.String _mandrstatus;

	private String _length = "0.0";
	private String _width = "0.0";
	private String _quantity = "0.0";
	private java.lang.String _unitmeasurecode;

	private boolean _hdrcancelflag;
	

	
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
     *  column="MANDRDTL_ID"
     */
	public java.lang.String getMandrdtlId () {
		return _mandrdtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param mandrdtlId the new ID
	 */
	public void setMandrdtlId (java.lang.String _mandrdtlId) {
		this._mandrdtlId = _mandrdtlId;
	}


	/**
	 * Return the value associated with the column: cancelflag
	 */
	public boolean isHdrcancelflag () {
		return _hdrcancelflag;
	}

	/**
	 * Set the value related to the column: cancelflag
	 * @param cancelflag the cancelflag value
	 */
	public void setHdrcancelflag (boolean _hdrcancelflag) {
		this._hdrcancelflag = _hdrcancelflag;
	}
	
	
	public java.lang.String getLastitemno () {
		return _lastitemno;
	}
	public void setLastitemno (java.lang.String _lastitemno) {
		this._lastitemno = _lastitemno;
	}
	

	/**
	 * Return the value associated with the column: MANDRHDR_ID
	 */
	public java.lang.String getMandrhdrId () {
		return _mandrhdrId;
	}

	/**
	 * Set the value related to the column: MANDRHDR_ID
	 * @param mandrhdrId the MANDRHDR_ID value
	 */
	public void setMandrhdrId (java.lang.String _mandrhdrId) {
		this._mandrhdrId = _mandrhdrId;
	}



	/**
	 * Return the value associated with the column: itemno
	 */
	public java.lang.String getItemno () {
		return _itemno;
	}

	/**
	 * Set the value related to the column: itemno
	 * @param itemno the itemno value
	 */
	public void setItemno (java.lang.String _itemno) {
		this._itemno = _itemno;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return _vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String _vendoraddrkey) {
		this._vendoraddrkey = _vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: respparty
	 */
	public java.lang.String getResponsibilitycode () {
		return _responsibilitycode;
	}

	/**
	 * Set the value related to the column: respparty
	 * @param respparty the respparty value
	 */
	public void setResponsibilitycode (java.lang.String _responsibilitycode) {
		this._responsibilitycode = _responsibilitycode;
	}



	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return _ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String _ccykey) {
		this._ccykey = _ccykey;
	}


	

	public java.lang.String getHdrccykey () {return _hdrccykey;}
	public void setHdrccykey (java.lang.String _hdrccykey) {this._hdrccykey = _hdrccykey;}
	
	

	/**
	 * Return the value associated with the column: costkey
	 */
	public java.lang.String getCostkey () {
		return _costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCostkey (java.lang.String _costkey) {
		this._costkey = _costkey;
	}



	/**
	 * Return the value associated with the column: damagekey
	 */
	public java.lang.String getDamagecode () {
		return _damagecode;
	}

	/**
	 * Set the value related to the column: damagekey
	 * @param damagekey the damagekey value
	 */
	public void setDamagecode (java.lang.String _damagecode) {
		this._damagecode = _damagecode;
	}



	/**
	 * Return the value associated with the column: repairkey
	 */
	public java.lang.String getRepaircode () {
		return _repaircode;
	}

	/**
	 * Set the value related to the column: repairkey
	 * @param repairkey the repairkey value
	 */
	public void setRepaircode (java.lang.String _repaircode) {
		this._repaircode = _repaircode;
	}

	
	
	


	/**
	 * Return the value associated with the column: xrate
	 */
	public String getXrate () {
		return _xrate;
	}

	/**
	 * Set the value related to the column: xrate
	 * @param xrate the xrate value
	 */
	public void setXrate (String _xrate) {
		this._xrate = _xrate;
	}



	/**
	 * Return the value associated with the column: laboramt
	 */
	public String getLaboramt () {
		return _laboramt;
	}

	/**
	 * Set the value related to the column: laboramt
	 * @param laboramt the laboramt value
	 */
	public void setLaboramt (String _laboramt) {
		this._laboramt = _laboramt;
	}



	/**
	 * Return the value associated with the column: laborrate
	 */
	public String getLaborrate () {
		return _laborrate;
	}

	/**
	 * Set the value related to the column: laborrate
	 * @param laborrate the laborrate value
	 */
	public void setLaborrate (String _laborrate) {
		this._laborrate = _laborrate;
	}



	/**
	 * Return the value associated with the column: laborhours
	 */
	public String getLaborhours () {
		return _laborhours;
	}

	/**
	 * Set the value related to the column: laborhours
	 * @param laborhours the laborhours value
	 */
	public void setLaborhours (String _laborhours) {
		this._laborhours = _laborhours;
	}



	/**
	 * Return the value associated with the column: materialkey
	 */
	public java.lang.String getMaterialtypecode () {
		return _materialtypecode;
	}

	/**
	 * Set the value related to the column: materialkey
	 * @param materialkey the materialkey value
	 */
	public void setMaterialtypecode (java.lang.String _materialtypecode) {
		this._materialtypecode = _materialtypecode;
	}



	/**
	 * Return the value associated with the column: materialamt
	 */
	public String getMaterialamt () {
		return _materialamt;
	}

	/**
	 * Set the value related to the column: materialamt
	 * @param materialamt the materialamt value
	 */
	public void setMaterialamt (String _materialamt) {
		this._materialamt = _materialamt;
	}



	/**
	 * Return the value associated with the column: totalamt
	 */
	public String getTotalamt () {
		return _totalamt;
	}

	/**
	 * Set the value related to the column: totalamt
	 * @param totalamt the totalamt value
	 */
	public void setTotalamt (String _totalamt) {
		this._totalamt = _totalamt;
	}



	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1 () {
		return _txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * @param txt1 the txt1 value
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
	 * @param txt2 the txt2 value
	 */
	public void setTxt2 (java.lang.String _txt2) {
		this._txt2 = _txt2;
	}



	/**
	 * Return the value associated with the column: mandrstatus
	 */
	public java.lang.String getMandrstatus () {
		return _mandrstatus;
	}

	/**
	 * Set the value related to the column: mandrstatus
	 * @param mandrstatus the mandrstatus value
	 */
	public void setMandrstatus (java.lang.String _mandrstatus) {
		this._mandrstatus = _mandrstatus;
	}






	/**
	 * Return the value associated with the column: materiallength
	 */
	public String getLength () {
		return _length;
	}

	/**
	 * Set the value related to the column: materiallength
	 * @param materiallength the materiallength value
	 */
	public void setLength (String _length) {
		this._length = _length;
	}



	/**
	 * Return the value associated with the column: materialwidth
	 */
	public String getWidth () {
		return _width;
	}

	/**
	 * Set the value related to the column: materialwidth
	 * @param materialwidth the materialwidth value
	 */
	public void setWidth (String _width) {
		this._width = _width;
	}



	/**
	 * Return the value associated with the column: materialquantity
	 */
	public String getQuantity () {
		return _quantity;
	}

	/**
	 * Set the value related to the column: materialquantity
	 * @param materialquantity the materialquantity value
	 */
	public void setQuantity (String _quantity) {
		this._quantity = _quantity;
	}




	public java.lang.String getUnitmeasurecode () {
		return _unitmeasurecode;
	}
	public void setUnitmeasurecode (java.lang.String _unitmeasurecode) {
		this._unitmeasurecode = _unitmeasurecode;
	}


	
	
	/**
	 * Return the value associated with the column: locationcode1
	 */
	public java.lang.String getLocationcode1 () {
		return _locationcode1;
	}

	/**
	 * Set the value related to the column: locationcode1
	 * @param locationcode1 the locationcode1 value
	 */
	public void setLocationcode1 (java.lang.String _locationcode1) {
		this._locationcode1 = _locationcode1;
	}



	/**
	 * Return the value associated with the column: locationcode2
	 */
	public java.lang.String getLocationcode2 () {
		return _locationcode2;
	}

	/**
	 * Set the value related to the column: locationcode2
	 * @param locationcode2 the locationcode2 value
	 */
	public void setLocationcode2 (java.lang.String _locationcode2) {
		this._locationcode2 = _locationcode2;
	}



	/**
	 * Return the value associated with the column: componentcode
	 */
	public java.lang.String getComponentcode () {
		return _componentcode;
	}

	/**
	 * Set the value related to the column: componentcode
	 * @param componentcode the componentcode value
	 */
	public void setComponentcode (java.lang.String _componentcode) {
		this._componentcode = _componentcode;
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
		
		addErrorIfBlank(errors, "_itemno", _itemno, "error.itemno.required");
		addErrorIfBlank(errors, "_vendoraddrkey", _vendoraddrkey, "error.vendor.required");
		addErrorIfBlank(errors, "_costkey", _costkey, "error.costcode.required");
		addErrorIfBlank(errors, "_ccykey", _ccykey, "error.ccykey.required");
		addErrorIfBlank(errors, "_damagecode", _damagecode, "error.damagecode.required");
		addErrorIfBlank(errors, "_repaircode", _repaircode, "error.repaircode.required");
		
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
