package com.bureaueye.beacon.form.quotation;



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



/**
 * 
 * Amendments
 * ----------
 * 												
 * NT	2011-05-23		ITT-201105-0001		Quotation Exchange Rates Update 
 *
 * NT	2012-07-26		ITT-201207-0001		Add Contract Type 
 *   
 */
public final class QuohdrForm extends BaseForm  {


    // ----------------------------------------------------- Instance Variables


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * The maintenance action we are performing (Create or Edit).
     */
    private String action = "Create";
	private String forwardname = "";
	
	

	// primary key
	private java.lang.String _id;

	private java.lang.String _copyid = "";
	
	// fields	
	private java.lang.String _quotedatedd;
	private java.lang.String _quotedatemm;
	private java.lang.String _quotedateyyyy;

	private java.lang.String _exchgdatedd;
	private java.lang.String _exchgdatemm;
	private java.lang.String _exchgdateyyyy;

	private java.lang.String _effectivedatedd;
	private java.lang.String _effectivedatemm;
	private java.lang.String _effectivedateyyyy;
	
	
	private java.lang.String _departmentkey;
	private java.lang.String _dmrgdlyrate1 = "0.00";
	private java.lang.String _dmrgdlyrate2 = "0.00";
	private java.lang.String _dmrgdlyrate3 = "0.00";	
	private java.lang.String _dmrglocationkey;

	private java.lang.String _expirydatedd;
	private java.lang.String _expirydatemm;
	private java.lang.String _expirydateyyyy;
	
	private java.lang.String _dmrgccykey;
	
	private java.lang.String _quotebyuserid;
	private java.lang.String _shipperaddrkey;
	private java.lang.String _ccykey;
	private java.lang.String _quotestatus;
	
	private java.lang.String _ldglocationkey1;
	private java.lang.String _dchlocationkey1;	
	private java.lang.String _ldglocationkey2;
	private java.lang.String _dchlocationkey2;
	

	
	
	
	private java.lang.String _brokeraddrkey;
	private java.lang.String _productkey;	
	private java.lang.String _quotno;
	private java.lang.String _companykey;
	
	private java.lang.String _rejectreason;
	private java.lang.String _notes;
	
	private java.lang.String _consigneeaddrkey;
	private java.lang.String _fwdagentaddrkey;	
	private java.lang.String _customeraddrkey;
	
	private java.lang.String _dmrgfreedays = "0";
	private java.lang.String _dmrgdays1 = "0";
	private java.lang.String _dmrgdays2 = "0";
	private java.lang.String _activitykey;

	private java.lang.String _customerref;
	private java.lang.String _shipperref;
	private java.lang.String _fwdagentref;
	private java.lang.String _brokerref;
	private java.lang.String _consigneeref;	

	private java.lang.String _shipmethod;	
	

	private java.lang.String _incotermkey;	

	private java.lang.String _customername;
	private java.lang.String _customeraddr1;
	private java.lang.String _customeraddr2;
	private java.lang.String _customeraddr3;
	private java.lang.String _customeraddr4;
	private java.lang.String _customeraddr5;
	private java.lang.String _customercontact;
	private java.lang.String _customertelno;
	private java.lang.String _customerfaxno;
	private java.lang.String _customeremail;

	
	private java.lang.String _exchgrateupd;//ITT-201105-0001
	

	/**
	 */	
	private java.lang.String _ldgg1key1;
	private java.lang.String _ldgg2key1;
	private java.lang.String _ldgg3key1;
	private java.lang.String _ldgg4key1;	
	/**
	 */	
	private java.lang.String _ldgg1key2;
	private java.lang.String _ldgg2key2;
	private java.lang.String _ldgg3key2;
	private java.lang.String _ldgg4key2;
	/**
	 */	
	private java.lang.String _dchg1key1;
	private java.lang.String _dchg2key1;
	private java.lang.String _dchg3key1;
	private java.lang.String _dchg4key1;	
	/**
	 */	
	private java.lang.String _dchg1key2;
	private java.lang.String _dchg2key2;
	private java.lang.String _dchg3key2;
	private java.lang.String _dchg4key2;

	
	private java.lang.String _contracttype;//ITT-201207-0001
	
	
    // ----------------------------------------------------------- Properties


	/**
	 */
	public java.lang.String getLdgg1key1 () {return _ldgg1key1;}
	public void setLdgg1key1 (java.lang.String _ldgg1key1) {this._ldgg1key1 = _ldgg1key1;}
	public java.lang.String getLdgg2key1 () {return _ldgg2key1;}
	public void setLdgg2key1 (java.lang.String _ldgg2key1) {this._ldgg2key1 = _ldgg2key1;}	
	public java.lang.String getLdgg3key1 () {return _ldgg3key1;}
	public void setLdgg3key1 (java.lang.String _ldgg3key1) {this._ldgg3key1 = _ldgg3key1;}
	public java.lang.String getLdgg4key1 () {return _ldgg4key1;}
	public void setLdgg4key1 (java.lang.String _ldgg4key1) {this._ldgg4key1 = _ldgg4key1;}	
	/**
	 */
	public java.lang.String getLdgg1key2 () {return _ldgg1key2;}
	public void setLdgg1key2 (java.lang.String _ldgg1key2) {this._ldgg1key2 = _ldgg1key2;}
	public java.lang.String getLdgg2key2 () {return _ldgg2key2;}
	public void setLdgg2key2 (java.lang.String _ldgg2key2) {this._ldgg2key2 = _ldgg2key2;}	
	public java.lang.String getLdgg3key2 () {return _ldgg3key2;}
	public void setLdgg3key2 (java.lang.String _ldgg3key2) {this._ldgg3key2 = _ldgg3key2;}
	public java.lang.String getLdgg4key2 () {return _ldgg4key2;}
	public void setLdgg4key2 (java.lang.String _ldgg4key2) {this._ldgg4key2 = _ldgg4key2;}	
	/**
	 */
	public java.lang.String getDchg1key1 () {return _dchg1key1;}
	public void setDchg1key1 (java.lang.String _dchg1key1) {this._dchg1key1 = _dchg1key1;}
	public java.lang.String getDchg2key1 () {return _dchg2key1;}
	public void setDchg2key1 (java.lang.String _dchg2key1) {this._dchg2key1 = _dchg2key1;}	
	public java.lang.String getDchg3key1 () {return _dchg3key1;}
	public void setDchg3key1 (java.lang.String _dchg3key1) {this._dchg3key1 = _dchg3key1;}
	public java.lang.String getDchg4key1 () {return _dchg4key1;}
	public void setDchg4key1 (java.lang.String _dchg4key1) {this._dchg4key1 = _dchg4key1;}	
	/**
	 */
	public java.lang.String getDchg1key2 () {return _dchg1key2;}
	public void setDchg1key2 (java.lang.String _dchg1key2) {this._dchg1key2 = _dchg1key2;}
	public java.lang.String getDchg2key2 () {return _dchg2key2;}
	public void setDchg2key2 (java.lang.String _dchg2key2) {this._dchg2key2 = _dchg2key2;}	
	public java.lang.String getDchg3key2 () {return _dchg3key2;}
	public void setDchg3key2 (java.lang.String _dchg3key2) {this._dchg3key2 = _dchg3key2;}
	public java.lang.String getDchg4key2 () {return _dchg4key2;}
	public void setDchg4key2 (java.lang.String _dchg4key2) {this._dchg4key2 = _dchg4key2;}	
	
	
	
	
	public String getForwardname() {return forwardname;}
	public void setForwardname(String forwardname) {this.forwardname=forwardname;}
	
	
    /**
     * Return the maintenance action.
     */
    public String getAction() {

	return (this.action);

    }


    /**
     * Set the maintenance action.
     *
     * @param action The new maintenance action.
     */
    public void setAction(String action) {

        this.action = action;

    }


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="vm"
     *  column="QUOHDR_ID"
     */
	public String getId () {
		return _id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _quohdrid the new ID
	 */
	public void setId (String _id) {
		this._id = _id;
	}


	/**
     */
	public String getCopyId () {
		return _copyid;
	}
	/**
	 */
	public void setCopyId (String _copyid) {
		this._copyid = _copyid;
	}
	
	
	public Date getExpirydate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getExpirydateyyyy()), Integer
						.parseInt(getExpirydatemm()) - 1, Integer
						.parseInt(getExpirydatedd()));
		return c.getTime();
	}
	public void setExpirydate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setExpirydateyyyy(c.get(Calendar.YEAR) + "");
		setExpirydatemm((month < 10 ? "0" : "") + month);
		setExpirydatedd((day < 10 ? "0" : "") + day);
	}
	public String getExpirydatedd () {return _expirydatedd;}
	public void setExpirydatedd (String _expirydatedd) {this._expirydatedd = _expirydatedd;}
	public String getExpirydatemm () {return _expirydatemm;}
	public void setExpirydatemm (String _expirydatemm) {this._expirydatemm = _expirydatemm;}
	public String getExpirydateyyyy () {return _expirydateyyyy;}
	public void setExpirydateyyyy (String _expirydateyyyy) {this._expirydateyyyy = _expirydateyyyy;}
	


	public Date getQuotedate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getQuotedateyyyy()), Integer
						.parseInt(getQuotedatemm()) - 1, Integer
						.parseInt(getQuotedatedd()));
		return c.getTime();
	}
	public void setQuotedate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setQuotedateyyyy(c.get(Calendar.YEAR) + "");
		setQuotedatemm((month < 10 ? "0" : "") + month);
		setQuotedatedd((day < 10 ? "0" : "") + day);
	}
	public String getQuotedatedd () {return _quotedatedd;}
	public void setQuotedatedd (String _quotedatedd) {this._quotedatedd = _quotedatedd;}
	public String getQuotedatemm () {return _quotedatemm;}
	public void setQuotedatemm (String _quotedatemm) {this._quotedatemm = _quotedatemm;}
	public String getQuotedateyyyy () {return _quotedateyyyy;}
	public void setQuotedateyyyy (String _quotedateyyyy) {this._quotedateyyyy = _quotedateyyyy;}


	
	public Date getExchgdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getExchgdateyyyy()), Integer
						.parseInt(getExchgdatemm()) - 1, Integer
						.parseInt(getExchgdatedd()));
		return c.getTime();
	}
	public void setExchgdate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setExchgdateyyyy(c.get(Calendar.YEAR) + "");
		setExchgdatemm((month < 10 ? "0" : "") + month);
		setExchgdatedd((day < 10 ? "0" : "") + day);
	}
	public String getExchgdatedd () {return _exchgdatedd;}
	public void setExchgdatedd (String _exchgdatedd) {this._exchgdatedd = _exchgdatedd;}
	public String getExchgdatemm () {return _exchgdatemm;}
	public void setExchgdatemm (String _exchgdatemm) {this._exchgdatemm = _exchgdatemm;}
	public String getExchgdateyyyy () {return _exchgdateyyyy;}
	public void setExchgdateyyyy (String _exchgdateyyyy) {this._exchgdateyyyy = _exchgdateyyyy;}

	
	public Date getEffectivedate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getEffectivedateyyyy()), Integer
						.parseInt(getEffectivedatemm()) - 1, Integer
						.parseInt(getEffectivedatedd()));
		return c.getTime();
	}
	public void setEffectivedate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setEffectivedateyyyy(c.get(Calendar.YEAR) + "");
		setEffectivedatemm((month < 10 ? "0" : "") + month);
		setEffectivedatedd((day < 10 ? "0" : "") + day);
	}
	public String getEffectivedatedd () {return _effectivedatedd;}
	public void setEffectivedatedd (String _effectivedatedd) {this._effectivedatedd = _effectivedatedd;}
	public String getEffectivedatemm () {return _effectivedatemm;}
	public void setEffectivedatemm (String _effectivedatemm) {this._effectivedatemm = _effectivedatemm;}
	public String getEffectivedateyyyy () {return _effectivedateyyyy;}
	public void setEffectivedateyyyy (String _effectivedateyyyy) {this._effectivedateyyyy = _effectivedateyyyy;}



	/**
	 * Return the value associated with the column: incoterms
	 */
	public java.lang.String getIncotermkey () {
		return _incotermkey;
	}

	/**
	 * Set the value related to the column: incoterms
	 * @param incoterms the incoterms value
	 */
	public void setIncotermkey (java.lang.String _incotermkey) {
		this._incotermkey = _incotermkey;
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
	 * Return the value associated with the column: DMRGdlyrate1
	 */
	public String getDmrgdlyrate1 () {
		return _dmrgdlyrate1;
	}

	/**
	 * Set the value related to the column: DMRGdlyrate1
	 * @param _dmrgdlyrate1 the DMRGdlyrate1 value
	 */
	public void setDmrgdlyrate1 (String _dmrgdlyrate1) {
		this._dmrgdlyrate1 = _dmrgdlyrate1;
	}
	/**
	 * Return the value associated with the column: DMRGdlyrate2
	 */
	public String getDmrgdlyrate2 () {
		return _dmrgdlyrate2;
	}

	/**
	 * Set the value related to the column: DMRGdlyrate2
	 * @param _dmrgdlyrate2 the DMRGdlyrate2 value
	 */
	public void setDmrgdlyrate2 (String _dmrgdlyrate2) {
		this._dmrgdlyrate2 = _dmrgdlyrate2;
	}
	/**
	 * Return the value associated with the column: DMRGdlyrate3
	 */
	public String getDmrgdlyrate3 () {
		return _dmrgdlyrate3;
	}

	/**
	 * Set the value related to the column: DMRGdlyrate3
	 * @param _dmrgdlyrate3 the DMRGdlyrate3 value
	 */
	public void setDmrgdlyrate3 (String _dmrgdlyrate3) {
		this._dmrgdlyrate3 = _dmrgdlyrate3;
	}
	



	/**
	 * Return the value associated with the column: DMRGlocationkey
	 */
	public java.lang.String getDmrglocationkey () {
		return _dmrglocationkey;
	}

	/**
	 * Set the value related to the column: DMRGlocationkey
	 * @param _dmrglocationkey the DMRGlocationkey value
	 */
	public void setDmrglocationkey (java.lang.String _dmrglocationkey) {
		this._dmrglocationkey = _dmrglocationkey;
	}



	

	/**
	 * Return the value associated with the column: DMRGCCYKEY
	 */
	public java.lang.String getDmrgccykey () {
		return _dmrgccykey;
	}

	/**
	 * Set the value related to the column: DMRGCCYKEY
	 * @param _dmrgccykey the DMRGCCYKEY value
	 */
	public void setDmrgccykey (java.lang.String _dmrgccykey) {
		this._dmrgccykey = _dmrgccykey;
	}








	/**
	 * Return the value associated with the column: quotebyuserid
	 */
	public java.lang.String getQuotebyuserid () {
		return _quotebyuserid;
	}

	/**
	 * Set the value related to the column: quotebyuserid
	 * @param _quotebyuserid the quotebyuserid value
	 */
	public void setQuotebyuserid (java.lang.String _quotebyuserid) {
		this._quotebyuserid = _quotebyuserid;
	}



	/**
	 * Return the value associated with the column: shipperaddrkey
	 */
	public java.lang.String getShipperaddrkey () {
		return _shipperaddrkey;
	}

	/**
	 * Set the value related to the column: shipperaddrkey
	 * @param _shipperaddrkey the shipperaddrkey value
	 */
	public void setShipperaddrkey (java.lang.String _shipperaddrkey) {
		this._shipperaddrkey = _shipperaddrkey;
	}





	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return _ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param _ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String _ccykey) {
		this._ccykey = _ccykey;
	}




	/**
	 * Return the value associated with the column: ldglocationkey
	 */
	public java.lang.String getLdglocationkey1 () {
		return _ldglocationkey1;
	}

	/**
	 * Set the value related to the column: ldglocationkey
	 * @param _ldglocationkey the ldglocationkey value
	 */
	public void setLdglocationkey1 (java.lang.String _ldglocationkey1) {
		this._ldglocationkey1 = _ldglocationkey1;
	}

	/**
	 * Return the value associated with the column: ldglocationkey
	 */
	public java.lang.String getLdglocationkey2 () {
		return _ldglocationkey2;
	}

	/**
	 * Set the value related to the column: ldglocationkey
	 * @param _ldglocationkey the ldglocationkey value
	 */
	public void setLdglocationkey2 (java.lang.String _ldglocationkey2) {
		this._ldglocationkey2 = _ldglocationkey2;
	}
	
	





	/**
	 * Return the value associated with the column: quotestatus
	 */
	public java.lang.String getQuotestatus () {
		return _quotestatus;
	}

	/**
	 * Set the value related to the column: quotestatus
	 * @param _quotestatus the quotestatus value
	 */
	public void setQuotestatus (java.lang.String _quotestatus) {
		this._quotestatus = _quotestatus;
	}


	/**
	 * Return the value associated with the column: dchlocationkey
	 */
	public java.lang.String getDchlocationkey1 () {
		return _dchlocationkey1;
	}

	/**
	 * Set the value related to the column: dchlocationkey
	 * @param _dchlocationkey the dchlocationkey value
	 */
	public void setDchlocationkey1 (java.lang.String _dchlocationkey1) {
		this._dchlocationkey1 = _dchlocationkey1;
	}

	/**
	 * Return the value associated with the column: dchlocationkey
	 */
	public java.lang.String getDchlocationkey2 () {
		return _dchlocationkey2;
	}

	/**
	 * Set the value related to the column: dchlocationkey
	 * @param _dchlocationkey the dchlocationkey value
	 */
	public void setDchlocationkey2 (java.lang.String _dchlocationkey2) {
		this._dchlocationkey2 = _dchlocationkey2;
	}
	
	

	/**
	 * Return the value associated with the column: brokeraddrkey
	 */
	public java.lang.String getBrokeraddrkey () {
		return _brokeraddrkey;
	}

	/**
	 * Set the value related to the column: brokeraddrkey
	 * @param _brokeraddrkey the brokeraddrkey value
	 */
	public void setBrokeraddrkey (java.lang.String _brokeraddrkey) {
		this._brokeraddrkey = _brokeraddrkey;
	}



	/**
	 * Return the value associated with the column: quotno
	 */
	public java.lang.String getQuotno () {
		return _quotno;
	}

	/**
	 * Set the value related to the column: quotno
	 * @param _quotno the quotno value
	 */
	public void setQuotno (java.lang.String _quotno) {
		this._quotno = _quotno;
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
	 * Return the value associated with the column: rejectreason
	 */
	public java.lang.String getRejectreason () {
		return _rejectreason;
	}

	/**
	 * Set the value related to the column: rejectreason
	 * @param _rejectreason the rejectreason value
	 */
	public void setRejectreason (java.lang.String _rejectreason) {
		this._rejectreason = _rejectreason;
	}

	/**
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return _notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param _rejectreason the rejectreason value
	 */
	public void setNotes(java.lang.String _notes) {
		this._notes = _notes;
	}
	


	/**
	 * Return the value associated with the column: consigneeaddrkey
	 */
	public java.lang.String getConsigneeaddrkey () {
		return _consigneeaddrkey;
	}

	/**
	 * Set the value related to the column: consigneeaddrkey
	 * @param _consigneeaddrkey the consigneeaddrkey value
	 */
	public void setConsigneeaddrkey (java.lang.String _consigneeaddrkey) {
		this._consigneeaddrkey = _consigneeaddrkey;
	}




	/**
	 * Return the value associated with the column: fwdagentaddrkey
	 */
	public java.lang.String getFwdagentaddrkey () {
		return _fwdagentaddrkey;
	}

	/**
	 * Set the value related to the column: fwdagentaddrkey
	 * @param _fwdagentaddrkey the fwdagentaddrkey value
	 */
	public void setFwdagentaddrkey (java.lang.String _fwdagentaddrkey) {
		this._fwdagentaddrkey = _fwdagentaddrkey;
	}




	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public java.lang.String getCustomeraddrkey () {
		return _customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param _customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (java.lang.String _customeraddrkey) {
		this._customeraddrkey = _customeraddrkey;
	}




	/**
	 * Return the value associated with the column: DMRGfreedays
	 */
	public String getDmrgfreedays () {
		return _dmrgfreedays;
	}

	/**
	 * Set the value related to the column: DMRGfreedays
	 * @param _dmrgfreedays the DMRGfreedays value
	 */
	public void setDmrgfreedays (String _dmrgfreedays) {
		this._dmrgfreedays = _dmrgfreedays;
	}
	/**
	 * Return the value associated with the column: DMRGdays1
	 */
	public String getDmrgdays1 () {
		return _dmrgdays1;
	}

	/**
	 * Set the value related to the column: DMRGdays1
	 * @param _dmrgdays1 the DMRGdays1 value
	 */
	public void setDmrgdays1 (String _dmrgdays1) {
		this._dmrgdays1 = _dmrgdays1;
	}
	/**
	 * Return the value associated with the column: DMRGdays2
	 */
	public String getDmrgdays2 () {
		return _dmrgdays2;
	}

	/**
	 * Set the value related to the column: DMRGdays2
	 * @param _dmrgdays2 the DMRGdays2 value
	 */
	public void setDmrgdays2 (String _dmrgdays2) {
		this._dmrgdays2 = _dmrgdays2;
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
	 * Return the value associated with the column: ref
	 */
	public java.lang.String getCustomerref () {	return _customerref; }
	/**
	 * Set the value related to the column: ref
	 * @param _customerref the customerref value
	 */
	public void setCustomerref (java.lang.String _customerref) {this._customerref = _customerref;	}
	
	/**
	 * Return the value associated with the column: ref
	 */
	public java.lang.String getShipperref() {	return _shipperref; }
	/**
	 * Set the value related to the column: ref
	 * @param _customerref the customerref value
	 */
	public void setShipperref(java.lang.String _shipperref) {this._shipperref = _shipperref;	}
	
	/**
	 * Return the value associated with the column: ref
	 */
	public java.lang.String getBrokerref() {	return _brokerref; }
	/**
	 * Set the value related to the column: ref
	 * @param _customerref the customerref value
	 */
	public void setBrokerref(java.lang.String _brokerref) {this._brokerref = _brokerref;	}

	/**
	 * Return the value associated with the column: ref
	 */
	public java.lang.String getConsigneeref() {	return _consigneeref; }
	/**
	 * Set the value related to the column: ref
	 * @param _customerref the customerref value
	 */
	public void setConsigneeref(java.lang.String _consigneeref) {this._consigneeref = _consigneeref;	}
	
	/**
	 * Return the value associated with the column: ref
	 */
	public java.lang.String getFwdagentref() {	return _fwdagentref; }
	/**
	 * Set the value related to the column: ref
	 * @param _customerref the customerref value
	 */
	public void setFwdagentref(java.lang.String _fwdagentref) {this._fwdagentref = _fwdagentref;	}
	
	
	/**
	 * Return the value associated with the column: ship method
	 */
	public java.lang.String getShipmethod() {	return _shipmethod; }
	/**
	 * Set the value related to the column: ref
	 * @param _shipmethod the shipmethod value
	 */
	public void setShipmethod(java.lang.String _shipmethod) {this._shipmethod = _shipmethod;	}

	
	/**
	 * Return the value associated with the column: product
	 */
	public java.lang.String getProductkey() {	return _productkey; }
	/**
	 * Set the value related to the column: product
	 * @param __productkey the product value
	 */
	public void setProductkey(java.lang.String _productkey) {this._productkey = _productkey;	}


	

	/**
	 * Return the value associated with the column: customername
	 */
	public java.lang.String getCustomername () {
		return _customername;
	}

	/**
	 * Set the value related to the column: customername
	 * @param customername the customername value
	 */
	public void setCustomername (java.lang.String _customername) {
		this._customername = _customername;
	}



	/**
	 * Return the value associated with the column: customeraddr1
	 */
	public java.lang.String getCustomeraddr1 () {
		return _customeraddr1;
	}

	/**
	 * Set the value related to the column: customeraddr1
	 * @param customeraddr1 the customeraddr1 value
	 */
	public void setCustomeraddr1 (java.lang.String _customeraddr1) {
		this._customeraddr1 = _customeraddr1;
	}



	/**
	 * Return the value associated with the column: customeraddr2
	 */
	public java.lang.String getCustomeraddr2 () {
		return _customeraddr2;
	}

	/**
	 * Set the value related to the column: customeraddr2
	 * @param customeraddr2 the customeraddr2 value
	 */
	public void setCustomeraddr2 (java.lang.String _customeraddr2) {
		this._customeraddr2 = _customeraddr2;
	}



	/**
	 * Return the value associated with the column: customeraddr3
	 */
	public java.lang.String getCustomeraddr3 () {
		return _customeraddr3;
	}

	/**
	 * Set the value related to the column: customeraddr3
	 * @param customeraddr3 the customeraddr3 value
	 */
	public void setCustomeraddr3 (java.lang.String _customeraddr3) {
		this._customeraddr3 = _customeraddr3;
	}



	/**
	 * Return the value associated with the column: customeraddr4
	 */
	public java.lang.String getCustomeraddr4 () {
		return _customeraddr4;
	}

	/**
	 * Set the value related to the column: customeraddr4
	 * @param customeraddr4 the customeraddr4 value
	 */
	public void setCustomeraddr4 (java.lang.String _customeraddr4) {
		this._customeraddr4 = _customeraddr4;
	}



	/**
	 * Return the value associated with the column: customeraddr5
	 */
	public java.lang.String getCustomeraddr5 () {
		return _customeraddr5;
	}

	/**
	 * Set the value related to the column: customeraddr5
	 * @param customeraddr5 the customeraddr5 value
	 */
	public void setCustomeraddr5 (java.lang.String _customeraddr5) {
		this._customeraddr5 = _customeraddr5;
	}




	/**
	 * Return the value associated with the column: customercontact
	 */
	public java.lang.String getCustomercontact () {
		return _customercontact;
	}

	/**
	 * Set the value related to the column: customercontact
	 * @param customercontact the customercontact value
	 */
	public void setCustomercontact (java.lang.String _customercontact) {
		this._customercontact = _customercontact;
	}



	/**
	 * Return the value associated with the column: customertelno
	 */
	public java.lang.String getCustomertelno () {
		return _customertelno;
	}

	/**
	 * Set the value related to the column: customertelno
	 * @param customertelno the customertelno value
	 */
	public void setCustomertelno (java.lang.String _customertelno) {
		this._customertelno = _customertelno;
	}



	/**
	 * Return the value associated with the column: customerfaxno
	 */
	public java.lang.String getCustomerfaxno () {
		return _customerfaxno;
	}

	/**
	 * Set the value related to the column: customerfaxno
	 * @param customerfaxno the customerfaxno value
	 */
	public void setCustomerfaxno (java.lang.String _customerfaxno) {
		this._customerfaxno = _customerfaxno;
	}



	/**
	 * Return the value associated with the column: customeremail
	 */
	public java.lang.String getCustomeremail () {
		return _customeremail;
	}

	/**
	 * Set the value related to the column: customeremail
	 * @param customeremail the customeremail value
	 */
	public void setCustomeremail (java.lang.String _customeremail) {
		this._customeremail = _customeremail;
	}
	
	

	public String getExchgrateupd () { return _exchgrateupd; }//ITT-201105-0001
	public void setExchgrateupd (String _exchgrateupd) { this._exchgrateupd = _exchgrateupd; }//ITT-201105-0001
	
	
	public String getContracttype () { return _contracttype; }//ITT-201207-0001
	public void setContracttype (String _contracttype) { this._contracttype = _contracttype; }//ITT-201207-0001
	

	
    // --------------------------------------------------------- Public Methods

	
    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        this.action = "Create"; 
        
    }


    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation errors that have been found.  If no errors are found, return
     * <code>null</code> or an <code>ActionErrors</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Perform validator framework validations
        ActionErrors errors = super.validate(mapping, request);
        
        // do not validate if Delete Action
        if (action.equals("Delete")) return errors;

        // do not validate if Navigate to Foward Name 
        if (!forwardname.equals("")) return errors;
        
        
        if ((_quotno == null) || (_quotno.length() < 1))
            errors.add("quotno",
                    new ActionMessage("error.quotno.required"));        	

		if (action.equals("Create")) {
			if (Util.invalidChars(this._quotno)) errors.add("quotno", new ActionMessage("error.quotno.invalidchars"));
		}
		
        if ((_companykey == null) || (_companykey.length() < 1))
            errors.add("companykey",
                    new ActionMessage("error.company.required"));        	  
    	
    	
        
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_expirydateyyyy+"-"+
									_expirydatemm+"-"+ 
									_expirydatedd
									);
        } catch (Exception e) {}	        	
        if (date == null)
            errors.add("expirydatedd",
                    new ActionMessage("error.expirydate.required"));        	

        date = null;
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_quotedateyyyy+"-"+
									_quotedatemm+"-"+ 
									_quotedatedd
									);
        } catch (Exception e) {}	        	
        if (date == null)
            errors.add("quotedatedd",
                    new ActionMessage("error.quotedate.required"));        	

        date = null;
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_effectivedateyyyy+"-"+
									_effectivedatemm+"-"+ 
									_effectivedatedd
									);
        } catch (Exception e) {}	        	
        if (date == null)
            errors.add("effectivedatedd",
                    new ActionMessage("error.effectivedate.required")); 
        
        date = null;
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_exchgdateyyyy+"-"+
									_exchgdatemm+"-"+ 
									_exchgdatedd
									);
        } catch (Exception e) {}	        	
        if (date == null)
            errors.add("exchgdatedd",
                    new ActionMessage("error.exchangedate.required"));  
        

		addErrorIfBlank(errors, "contracttype", _contracttype, "error.contracttype.required");//ITT-201207-0001  
		
        
		addErrorIfBlank(errors, "ccykey", _ccykey, "error.ccykey.required");  
		
    	if (
    			((_customeraddrkey == null) || (_customeraddrkey.length() < 1)) 
    			&& 
    			((_customername == null) || (_customername.length() < 1))
    			)
    		errors.add("customeraddrkey",
                new ActionMessage("error.customerorproposedcustomer.required")); 
    	
//		addErrorIfBlank(errors, "customeraddrkey", _customeraddrkey, "error.customeraddrkey.required");
		
    	if ((_ldglocationkey2 == null) || (_ldglocationkey2.length() < 1))
    		errors.add("ldglocationkey2",
                new ActionMessage("error.ldgport.required"));
    	if ((_dchlocationkey2 == null) || (_dchlocationkey2.length() < 1))
    		errors.add("dchlocationkey2",
                new ActionMessage("error.dchport.required")); 
        
        
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
