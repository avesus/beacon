package com.bureaueye.beacon.form.purchaseorder;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;




public final class Podtlrcvd2Form extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
    
    
	// primary key
	private java.lang.String _podtlrcvdId;
	private java.lang.String _podtlId;
	

	// fields
	private java.lang.String _shipmentno;
	private java.lang.String _qtyrcvd = "0";	
	private java.lang.String _qtytogenerate = "0";
	private java.lang.String _unitkeyprefix;
	private java.lang.String _unitkeysuffix = "0";
	private java.lang.String _unitkey;
	private java.lang.String _unitId;
	
	

	// many to one
	

	// extra
	private int _qtygenerated;
	

	private List _lineItems;
	
	

	
	public List getLineItems_() {
		return _lineItems;
	}

	public void setLineItems(List _lineItems) {
		this._lineItems = _lineItems;
	}
	
	
    /**
     */
    public String getCopyId() {return (this._copyId);}
    public void setCopyId(String _copyId) {this._copyId = _copyId;}
    

	public String getActionX() {
		return _action;
	}

	public void setActionX(String _action) {
		this._action = _action;
	}

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	public int getQtygenerated() {return _qtygenerated;}
	public void setQtygenerated(int _qtygenerated) {this._qtygenerated = _qtygenerated;}
	
	
	/**
	 * Return the unique identifier of this class
     */
	public java.lang.String getPodtlrcvdId () {
		return _podtlrcvdId;
	}

	/**
	 */
	public void setPodtlrcvdId (java.lang.String _podtlrcvdId) {
		this._podtlrcvdId = _podtlrcvdId;
	}


	/**
	 */
	public java.lang.String getPodtlId () {
		return _podtlId;
	}

	/**
	 */
	public void setPodtlId (java.lang.String _podtlId) {
		this._podtlId = _podtlId;
	}
	
	
	
	/**
	 * Return the value associated with the column: shipmentno
	 */
	public java.lang.String getShipmentno () {
		return _shipmentno;
	}

	/**
	 * Set the value related to the column: shipmentno
	 * @param _shipmentno the shipmentno value
	 */
	public void setShipmentno (java.lang.String _shipmentno) {
		this._shipmentno = _shipmentno;
	}
	

	/**
	 * Return the value associated with the column: unitkeyprefix
	 */
	public java.lang.String getUnitkeyprefix() {
		return _unitkeyprefix;
	}

	/**
	 * Set the value related to the column: shipmentno
	 * @param _shipmentno the shipmentno value
	 */
	public void setUnitkeyprefix (java.lang.String _unitkeyprefix) {
		this._unitkeyprefix = _unitkeyprefix;
	}
	
	
	/**
	 * Return the value associated with the column: unitkeysuffix
	 */
	public java.lang.String getUnitkeysuffix() {
		return _unitkeysuffix;
	}

	/**
	 * Set the value related to the column: unitkeysuffix
	 * @param _unitkeysuffix the unitkeysuffix value
	 */
	public void setUnitkeysuffix (java.lang.String _unitkeysuffix) {
		this._unitkeysuffix = _unitkeysuffix;
	}
	
	
	/**
	 * Return the value associated with the column: _unitkey
	 */
	public java.lang.String getUnitkey () {
		return _unitkey;
	}

	/**
	 * Set the value related to the column: _unitkey
	 * @param __unitkey the _unitkey value
	 */
	public void setUnitkey (java.lang.String _unitkey) {
		this._unitkey = _unitkey;
	}
	

	/**
	 * Return the value associated with the column: unitId
	 */
	public java.lang.String getUnitId () {
		return _unitId;
	}

	/**
	 * Set the value related to the column: shipmentno
	 * @param _unitId the unitId value
	 */
	public void setUnitId (java.lang.String _unitId) {
		this._unitId = _unitId;
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
	 * Return the value associated with the column: qtytogenerate
	 */
	public java.lang.String getQtytogenerate () {
		return _qtytogenerate;
	}

	/**
	 * Set the value related to the column: qtytogenerate
	 * @param _qtytogenerate the qtytogenerate value
	 */
	public void setQtytogenerate (java.lang.String _qtytogenerate) {
		this._qtytogenerate = _qtytogenerate;
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

	
	public String toString() {
		return 
" _action="+_action+
" _readonly="+_readonly+
" _copyId="+_copyId+
" _podtlrcvdId="+_podtlrcvdId+
" _podtlId="+_podtlId+
" _shipmentno="+_shipmentno+
" _qtyrcvd="+_qtyrcvd+
" _qtytogenerate="+_qtytogenerate+
" _unitkeyprefix="+_unitkeyprefix+
" _unitkeysuffix="+_unitkeysuffix+
" _unitkey="+_unitkey+
" _unitId="+_unitId+
" _qtygenerated="+_qtygenerated;
	}
	
}
