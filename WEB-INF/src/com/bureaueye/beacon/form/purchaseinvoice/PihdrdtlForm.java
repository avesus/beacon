package com.bureaueye.beacon.form.purchaseinvoice;

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



public final class PihdrdtlForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
    
    
	//PIHDR FIELDS============================================
	private java.lang.String _pihdrId;

	// fields	
	private java.lang.String _createuserid;
	private java.util.Date _createdate;	
	

	private java.lang.String _invoicedatedd;
	private java.lang.String _invoicedatemm;
	private java.lang.String _invoicedateyyyy;
	
	private java.lang.String _ccykey;
	private java.lang.String _pino;
	private java.lang.String _grossamt = "0.0";
	private java.lang.String _netamt = "0.0";	
	private java.lang.String _taxamt = "0.0";
	private java.lang.String _taxcode;	
	private java.lang.String _taxrate = "0.0";	
	
	private java.lang.String _txt1;
	private java.lang.String _invoicestatus;	
	
	private java.lang.String _vendoraddrkey;
	private java.lang.String _vendorref;
	
	private java.lang.String _batchno;
	private java.lang.String _financialmonth;	
	private java.lang.String _financialyear;
	
	private java.lang.String _linesentered = "0";
	private java.lang.String _disputes = "0";
	private java.lang.String _inputtotal = "0.0";
	private java.lang.String _alloctotal = "0.0";
	
	private java.lang.String _companykey;
	private java.lang.String _departmentkey;
	private java.lang.String _activitykey;
	
	private boolean _approvedflag;
	
	private java.util.Date _posteddate;
	private java.lang.String _postedtime;
	private boolean _postedflag;
	
	private boolean _miscflag;
	
	
	
	
	//PIDTL FIELDS==============================================
	private java.lang.String _pidtlId;
	// fields	
	private java.lang.String _jobno;
	private java.lang.String _jobhdrId;
	private java.lang.String _orderno;
	
	// collections
	private java.util.List _pidtlcosts;	
	



	
	

	
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
		return _pihdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _Id the new ID
	 */
	public void setId (String _pihdrId) {
		this._pihdrId = _pihdrId;
	}


	public boolean isApprovedflag() {
		return _approvedflag;
	}
	public void setApprovedflag(boolean _approvedflag) {
		this._approvedflag = _approvedflag;
	}

	public boolean isPostedflag() {
		return _postedflag;
	}
	public void setPostedflag(boolean _postedflag) {
		this._postedflag = _postedflag;
	}

	
	public boolean isMiscflag() {
		return _miscflag;
	}
	public void setMiscflag(boolean _miscflag) {
		this._miscflag = _miscflag;
	}
	
	
	
	/**
	 */
	public java.lang.String getInvoicestatus () {
		return _invoicestatus;
	}
	/**
	 */
	public void setInvoicestatus (java.lang.String _invoicestatus) {
		this._invoicestatus = _invoicestatus;
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
	 * Return the value associated with the column: pino
	 */
	public java.lang.String getPino() {
		return _pino;
	}

	/**
	 */
	public void setPino(java.lang.String _pino) {
		this._pino = _pino;
	}
	

	/**
	 */
	public java.lang.String getFinancialyear () {
		return _financialyear;
	}

	/**
	 */
	public void setFinancialyear (java.lang.String _financialyear) {
		this._financialyear = _financialyear;
	}
	
	
	/**
	 */
	public java.lang.String getFinancialmonth () {
		return _financialmonth;
	}

	/**
	 */
	public void setFinancialmonth (java.lang.String _financialmonth) {
		this._financialmonth = _financialmonth;
	}	

	/**
	 */
	public java.lang.String getBatchno () {
		return _batchno;
	}

	/**
	 */
	public void setBatchno (java.lang.String _batchno) {
		this._batchno = _batchno;
	}

	/**
	 */
	public java.lang.String getVendorref () {
		return _vendorref;
	}

	/**
	 */
	public void setVendorref (java.lang.String _vendorref) {
		this._vendorref = _vendorref;
	}	
	
	


	public Date getInvoicedate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getInvoicedateyyyy()), Integer
						.parseInt(getInvoicedatemm()) - 1, Integer
						.parseInt(getInvoicedatedd()));
		return c.getTime();
	}
	public void setInvoicedate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setInvoicedateyyyy(c.get(Calendar.YEAR) + "");
		setInvoicedatemm((month < 10 ? "0" : "") + month);
		setInvoicedatedd((day < 10 ? "0" : "") + day);
	}
	public String getInvoicedatedd () {return _invoicedatedd;}
	public void setInvoicedatedd (String _invoicedatedd) {this._invoicedatedd = _invoicedatedd;}
	public String getInvoicedatemm () {return _invoicedatemm;}
	public void setInvoicedatemm (String _invoicedatemm) {this._invoicedatemm = _invoicedatemm;}
	public String getInvoicedateyyyy () {return _invoicedateyyyy;}
	public void setInvoicedateyyyy (String _invoicedateyyyy) {this._invoicedateyyyy = _invoicedateyyyy;}

	

	
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
	 */
	public String getNetamt () {return _netamt;}
	/**
	 */
	public void setNetamt (String _netamt) {this._netamt = _netamt;}

	/**
	 */
	public String getTaxrate() {return _taxrate;}
	/**
	 */
	public void setTaxrate (String _taxrate) {this._taxrate = _taxrate;}
	
	/**
	 */
	public String getGrossamt () {return _grossamt;}
	/**
	 */
	public void setGrossamt (String _grossamt) {this._grossamt = _grossamt;}


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
	
	
	
	public java.util.Date getPosteddate_ () {	return _posteddate;	}
	public void setPosteddate (java.util.Date _posteddate) {	this._posteddate = _posteddate;	}

	public java.lang.String getPostedtime_ () {	return _postedtime;}
	public void setPostedtime (java.lang.String _postedtime) {	this._postedtime = _postedtime;}

	
	
	
	
	/**
	 */
	public java.lang.String getInputtotal () {
		return _inputtotal;
	}
	/**
	 */
	public void setInputtotal (java.lang.String _inputtotal) {
		this._inputtotal = _inputtotal;
	}
	

	/**
	 */
	public java.lang.String getAlloctotal () {
		return _alloctotal;
	}
	/**
	 */
	public void setAlloctotal (java.lang.String _alloctotal) {
		this._alloctotal = _alloctotal;
	}
	
	
	/**
	 */
	public java.lang.String getLinesentered () {
		return _linesentered;
	}
	/**
	 */
	public void setLinesentered (java.lang.String _linesentered) {
		this._linesentered = _linesentered;
	}
	
	
	/**
	 */
	public java.lang.String getDisputes () {
		return _disputes;
	}
	/**
	 */
	public void setDisputes (java.lang.String _disputes) {
		this._disputes = _disputes;
	}
	
	
	
	
	//PIDTL FIELDS
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
	
	public java.lang.String getPidtlId () {
		return _pidtlId;
	}
	public void setPidtlId (java.lang.String _pidtlId) {
		this._pidtlId = _pidtlId;
	}
	
	


	public java.lang.String getJobhdrId() {
		return _jobhdrId;
	}
	public void setJobhdrId(java.lang.String _jobhdrId) {
		this._jobhdrId = _jobhdrId;
	}
	
	public java.lang.String getJobno() {
		return _jobno;
	}
	public void setJobno(java.lang.String _jobno) {
		this._jobno = _jobno;
	}

	public java.lang.String getOrderno() {
		return _orderno;
	}
	public void setOrderno(java.lang.String _orderno) {
		this._orderno = _orderno;
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


	       if ((_pino == null) || (_pino.length() < 1))
	            errors.add("pino",
	                    new ActionMessage("error.pino.required"));        	

			if (Util.invalidChars(this._pino)) errors.add("pino", new ActionMessage("error.pino.invalidchars"));

	        if ((_companykey == null) || (_companykey.length() < 1))
	            errors.add("companykey",
	                    new ActionMessage("error.company.required"));   
	        
	        
			
			if (_action.equals("Create")) {
				addErrorIfBlank(errors, "vendoraddrkey", _vendoraddrkey, "error.vendor.required");	
				addErrorIfBlank(errors, "ccykey", _ccykey, "error.ccykey.required");
				
				//if not a miscellaneous invoice job is required
				if (!isMiscflag()) addErrorIfBlank(errors, "jobno", _jobno, "error.jobno.required");				
			}
         
		
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_invoicedateyyyy+"-"+
    								_invoicedatemm+"-"+ 
    								_invoicedatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("invoicedatedd", new ActionMessage("error.invoicedate.required"));        	

			
		
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
