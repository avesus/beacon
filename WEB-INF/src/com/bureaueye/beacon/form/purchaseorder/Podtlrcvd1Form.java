package com.bureaueye.beacon.form.purchaseorder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.formatter.DateFormatter;



public final class Podtlrcvd1Form extends BaseForm {

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
	private java.lang.String _txt1;
	
	private  java.lang.String _rcvddatedd;
	private  java.lang.String _rcvddatemm;
	private  java.lang.String _rcvddateyyyy;
	
	private java.lang.String _createuserid;

	
	

	// many to one


	// extra
	private int _qtygenerated;
	
	

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





	public Date getRcvddate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getRcvddateyyyy()), Integer
						.parseInt(getRcvddatemm()) - 1, Integer
						.parseInt(getRcvddatedd()));
		return c.getTime();
	}
	public void setRcvddate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setRcvddateyyyy(c.get(Calendar.YEAR) + "");
		setRcvddatemm((month < 10 ? "0" : "") + month);
		setRcvddatedd((day < 10 ? "0" : "") + day);
	}
	public String getRcvddatedd () {return _rcvddatedd;}
	public void setRcvddatedd (String _rcvddatedd) {this._rcvddatedd = _rcvddatedd;}
	public String getRcvddatemm () {return _rcvddatemm;}
	public void setRcvddatemm (String _rcvddatemm) {this._rcvddatemm = _rcvddatemm;}
	public String getRcvddateyyyy () {return _rcvddateyyyy;}
	public void setRcvddateyyyy (String _rcvddateyyyy) {this._rcvddateyyyy = _rcvddateyyyy;}






	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return _createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param _createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String _createuserid) {
		this._createuserid = _createuserid;
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
		
		
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_rcvddateyyyy+"-"+
    								_rcvddatemm+"-"+ 
    								_rcvddatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("rcvddatedd", new ActionMessage("error.receiveddate.required"));        	



		
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
