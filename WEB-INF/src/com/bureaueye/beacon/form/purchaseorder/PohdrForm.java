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
import com.bureaueye.beacon.util.Util;


public final class PohdrForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
    
    
	// primary key
	private java.lang.String _pohdrId;


	// fields	
	private java.lang.String _createuserid;
	private java.util.Date _createdate;
	
	private java.lang.String _pono;

	private java.lang.String _workorderno;
	private java.lang.String _workordertype;
	
	private java.lang.String _companykey;
	private java.lang.String _departmentkey;
	private java.lang.String _activitykey;

	private java.lang.String _deliverydatedd;
	private java.lang.String _deliverydatemm;
	private java.lang.String _deliverydateyyyy;
	
	private java.lang.String _ccykey;
	private java.lang.String _totalamt = "0.0";
	private java.lang.String _subtotalamt = "0.0";	
	private java.lang.String _taxamt = "0.0";
	private java.lang.String _shippingamt = "0.0";	
	private java.lang.String _taxcode;	

	private java.lang.String _shipvia;	
	private java.lang.String _paymentterm;
	private java.lang.String _submittedfor;
	
	private java.lang.String _txt1;
	
	
	private java.lang.String _vendoraddrkey;
	private java.lang.String _shiptolocationkey;
	
	
	
	// collections
	

	
    /**
     */
    public String getCopyId() {return (this._copyId);}
    public void setCopyId(String _copyId) {this._copyId = _copyId;}
    
	
	public String getAction() {return _action;}

	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	

	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="_ID"
     */
	public String getId () {
		return _pohdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _Id the new ID
	 */
	public void setId (String _pohdrId) {
		this._pohdrId = _pohdrId;
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
	 * Return the value associated with the column: shipvia
	 */
	public java.lang.String getShipvia () {
		return _shipvia;
	}

	/**
	 * Set the value related to the column: shipvia
	 * @param _shipvia the shipvia value
	 */
	public void setShipvia (java.lang.String _shipvia) {
		this._shipvia = _shipvia;
	}
	
	
	/**
	 * Return the value associated with the column: submittedfor
	 */
	public java.lang.String getSubmittedfor () {
		return _submittedfor;
	}

	/**
	 * Set the value related to the column: submittedfor
	 * @param _submittedfor the submittedfor value
	 */
	public void setSubmittedfor (java.lang.String _submittedfor) {
		this._submittedfor = _submittedfor;
	}
	
	
	/**
	 * Return the value associated with the column: pono
	 */
	public java.lang.String getPono () {
		return _pono;
	}

	/**
	 * Set the value related to the column: pono
	 * @param _pono the pono value
	 */
	public void setPono (java.lang.String _pono) {
		this._pono = _pono;
	}


	/**
	 * Return the value associated with the column: workorderno
	 */
	public java.lang.String getWorkorderno () {
		return _workorderno;
	}

	/**
	 * Set the value related to the column: workorderno
	 * @param _workorderno the workorderno value
	 */
	public void setWorkorderno (java.lang.String _workorderno) {
		this._workorderno = _workorderno;
	}


	/**
	 * Return the value associated with the column: workordertype
	 */
	public java.lang.String getWorkordertype () {
		return _workordertype;
	}

	/**
	 * Set the value related to the column: workordertype
	 * @param _workordertype the workordertype value
	 */
	public void setWorkordertype (java.lang.String _workordertype) {
		this._workordertype = _workordertype;
	}
	
	
	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return _activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param _activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String _activitykey) {
		this._activitykey = _activitykey;
	}

	
	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return _departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param _departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String _departmentkey) {
		this._departmentkey = _departmentkey;
	}
	

	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return _companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param _companykey the companykey value
	 */
	public void setCompanykey (java.lang.String _companykey) {
		this._companykey = _companykey;
	}	
	
	

	


	public Date getDeliverydate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getDeliverydateyyyy()), Integer
						.parseInt(getDeliverydatemm()) - 1, Integer
						.parseInt(getDeliverydatedd()));
		return c.getTime();
	}
	public void setDeliverydate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setDeliverydateyyyy(c.get(Calendar.YEAR) + "");
		setDeliverydatemm((month < 10 ? "0" : "") + month);
		setDeliverydatedd((day < 10 ? "0" : "") + day);
	}
	public String getDeliverydatedd () {return _deliverydatedd;}
	public void setDeliverydatedd (String _deliverydatedd) {this._deliverydatedd = _deliverydatedd;}
	public String getDeliverydatemm () {return _deliverydatemm;}
	public void setDeliverydatemm (String _deliverydatemm) {this._deliverydatemm = _deliverydatemm;}
	public String getDeliverydateyyyy () {return _deliverydateyyyy;}
	public void setDeliverydateyyyy (String _deliverydateyyyy) {this._deliverydateyyyy = _deliverydateyyyy;}

	

	
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
	 * Return the value associated with the column: _ccykey
	 */
	public java.lang.String getCcykey () {
		return _ccykey;
	}

	/**
	 * Set the value related to the column: _ccykey
	 * @param __ccykey the _ccykey value
	 */
	public void setCcykey (java.lang.String _ccykey) {
		this._ccykey = _ccykey;
	}






	/**
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid () {
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
	 * Return the value associated with the column: shippingamt
	 */
	public String getShippingamt () {
		return _shippingamt;
	}

	/**
	 * Set the value related to the column: shippingamt
	 * @param _shippingamt the shippingamt value
	 */
	public void setShippingamt (String _shippingamt) {
		this._shippingamt = _shippingamt;
	}
	
	/**
	 * Return the value associated with the column: totalamt
	 */
	public String getTotalamt () {return _totalamt;}
	/**
	 * Set the value related to the column: totalamt
	 * @param _totalamt the totalamt value
	 */
	public void setTotalamt (String _totalamt) {this._totalamt = _totalamt;}
	

	/**
	 * Return the value associated with the column: subtotalamt
	 */
	public String getSubtotalamt () {return _subtotalamt;}
	/**
	 * Set the value related to the column: subtotalamt
	 * @param _subtotalamt the subtotalamt value
	 */
	public void setSubtotalamt (String _subtotalamt) {this._subtotalamt = _subtotalamt;}


	/**
	 * Return the value associated with the column: taxamt
	 */
	public String getTaxamt () {return _taxamt;}
	/**
	 * Set the value related to the column: _taxamt
	 * @param __taxamt the _taxamt value
	 */
	public void setTaxamt (String _taxamt) {this._taxamt = _taxamt;}

	
	/**
	 * Return the value associated with the column: taxcode
	 */
	public String getTaxcode () {return _taxcode;}
	/**
	 * Set the value related to the column: __taxcode
	 * @param _taxcode the _taxcode value
	 */
	public void setTaxcode(String _taxcode) {this._taxcode = _taxcode;}
	
	
	/**
	 * Return the value associated with the column: paymentterm
	 */
	public java.lang.String getPaymentterm () {
		return _paymentterm;
	}

	/**
	 * Set the value related to the column: paymentterm
	 * @param _paymentterm the paymentterm value
	 */
	public void setPaymentterm (java.lang.String _paymentterm) {
		this._paymentterm = _paymentterm;
	}	
	
	
	
	/**
     * @hibernate.property
     *  column=vendoraddrkey
	 */
	public String getVendoraddrkey () {
		return this._vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (String _vendoraddrkey) {
		this._vendoraddrkey = _vendoraddrkey;
	}


	/**
     * @hibernate.property
     *  column=shiptoaddrkey
	 */
	public String getShiptolocationkey () {
		return this._shiptolocationkey;
	}

	/**
	 * Set the value related to the column: shiptoaddrkey
	 * @param shiptoaddrkey the shiptoaddrkey value
	 */
	public void setShiptolocationkey (String _shiptolocationkey) {
		this._shiptolocationkey = _shiptolocationkey;
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


        
        if ((_pono == null) || (_pono.length() < 1))
            errors.add("pono",
                    new ActionMessage("error.pono.required"));        	

		if (_action.equals("Create")) {
			if (Util.invalidChars(this._pono)) errors.add("pono", new ActionMessage("error.pono.invalidchars"));
		}
		
		addErrorIfBlank(errors, "companykey", _companykey, "error.company.required");               	      
		
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_deliverydateyyyy+"-"+
    								_deliverydatemm+"-"+ 
    								_deliverydatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("deliverydatedd", new ActionMessage("error.deliverydate.required"));        	

 

		addErrorIfBlank(errors, "vendoraddrkey", _vendoraddrkey, "error.vendor.required");	
		addErrorIfBlank(errors, "shiptolocationkey", _shiptolocationkey, "error.shipto.required");	

		addErrorIfBlank(errors, "ccykey", _ccykey, "error.ccykey.required");
		
		
		
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
