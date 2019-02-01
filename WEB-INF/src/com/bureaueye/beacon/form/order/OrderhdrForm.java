package com.bureaueye.beacon.form.order;



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
 * NT	2012-07-26		ITT-201207-0001		Add Contract Type 
 *  
 */
public final class OrderhdrForm extends BaseForm  {


    // ----------------------------------------------------- Instance Variables


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * The maintenance action we are performing (Create or Edit).
     */
    private String action = "Create";
    private String copyQuoteId = "";
    private String copyId = "";
    private String copyQuotationButton;
	private String forwardname = "";
	
	// primary key
	private java.lang.String _id;

	// fields
	private java.lang.String _quohdrId;
	private java.lang.String _ordertype;
	private boolean _deleted;
	
	private java.lang.String _orderno;
	private java.lang.String _bookingnumber;
	
	private java.lang.String _orderdatedd;
	private java.lang.String _orderdatemm;
	private java.lang.String _orderdateyyyy;

	
	private java.lang.String _documentclosingdatedd;
	private java.lang.String _documentclosingdatemm;
	private java.lang.String _documentclosingdateyyyy;
	private java.lang.String _tankclosingdatedd;
	private java.lang.String _tankclosingdatemm;
	private java.lang.String _tankclosingdateyyyy;
	private java.lang.String _deliveryterminaltext;
	
	private java.lang.String _incotermkey;
	
	
	private java.lang.String _exchgdatedd;
	private java.lang.String _exchgdatemm;
	private java.lang.String _exchgdateyyyy;
	
	private java.lang.String _ldgfromdatedd;
	private java.lang.String _ldgfromdatemm;
	private java.lang.String _ldgfromdateyyyy;
	private java.lang.String _ldgfromtimehh;
	private java.lang.String _ldgfromtimemm;
	
	private java.lang.String _ldgtodatedd;
	private java.lang.String _ldgtodatemm;
	private java.lang.String _ldgtodateyyyy;
	private java.lang.String _ldgtotimehh;
	private java.lang.String _ldgtotimemm;
	
	private java.lang.String _dchfromdatedd;
	private java.lang.String _dchfromdatemm;
	private java.lang.String _dchfromdateyyyy;
	private java.lang.String _dchfromtimehh;
	private java.lang.String _dchfromtimemm;
	
	private java.lang.String _dchtodatedd;
	private java.lang.String _dchtodatemm;
	private java.lang.String _dchtodateyyyy;
	private java.lang.String _dchtotimehh;
	private java.lang.String _dchtotimemm;
	
	private java.lang.String _orderstatus;
	private java.lang.String _invoicestatus;
	
	private java.lang.String _quotno;
	
	
	private java.lang.String _dmrgdlyrate1 = "0.00";
	private java.lang.String _dmrgdlyrate2 = "0.00";
	private java.lang.String _dmrgdlyrate3 = "0.00";	
	private java.lang.String _dmrglocationkey;
	private java.lang.String _dmrgccykey;
	private java.lang.String _dmrgbilltoaddrkey;
	private java.lang.String _dmrgfreedaysleft = "0";
	private java.lang.String _dmrgfreedays = "0";
	private java.lang.String _dmrgdays1 = "0";
	private java.lang.String _dmrgdays2 = "0";
	

	private java.lang.String _ldglocationkey1;
	private java.lang.String _dchlocationkey1;
	private java.lang.String _ldglocationkey2;
	private java.lang.String _dchlocationkey2;

	

	private java.lang.String _delterm;


	private java.lang.String _orderbyuserid;


	private java.lang.String _shipperaddrkey;



	private java.lang.String _ccykey;
	private java.lang.String _systemloguserid;

	private java.lang.String _notes;



	
	private java.lang.String _brokeraddrkey;
	private java.lang.String _fwdagentaddrkey;
	private java.lang.String _consigneeaddrkey;
	private String _customeraddrkey;
	
	private java.lang.String _productkey;	


	private java.lang.String _companykey;
	private java.lang.String _departmentkey;
	private java.lang.String _activitykey;
	
	private java.lang.String _createuserid;



	private java.lang.String _customerref;
	private java.lang.String _shipperref;
	private java.lang.String _fwdagentref;
	private java.lang.String _brokerref;
	private java.lang.String _consigneeref;	

	private java.lang.String _shipmethod;	
	private java.lang.String _consignmentno;
	

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

	
	private java.lang.String shipvendoraddrkey;
	private java.lang.String shipvessel;
	private java.lang.String shipvoyage;
	
	private boolean completeflag;
	
	
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
	
	
	
    /**
     */
    public String getCopyId() {return (this.copyId);}
    public void setCopyId(String copyId) {this.copyId = copyId;}
    
    /**
     */
    public String getCopyQuoteId() {return (this.copyQuoteId);}
    public void setCopyQuoteId(String copyQuoteId) {this.copyQuoteId = copyQuoteId;}
    /**
     */
    public String getCopyQuotationButton() {return (this.copyQuotationButton);}
    public void setCopyQuotationButton(String copyQuotationButton) {this.copyQuotationButton = copyQuotationButton;}    
 


	public String getForwardname() {return forwardname;}
	public void setForwardname(String forwardname) {this.forwardname=forwardname;}
	
	
    /**
     * Return the maintenance action.
     */
    public String getAction() {return (this.action);}
    /**
     * Set the maintenance action.
     *
     * @param action The new maintenance action.
     */
    public void setAction(String action) {this.action = action;}


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="vm"
     *  column="ORDERHDR_ID"
     */
	public String getId () {
		return _id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _orderhdrid the new ID
	 */
	public void setId (String _id) {
		this._id = _id;
	}


	/**
     *  get column="QUOHDR_ID"
     */
	public String getQuohdrId () {
		return _quohdrId;
	}

	/**
     *  set column="QUOHDR_ID"
     */
	public void setQuohdrId (String _quohdrId) {
		this._quohdrId = _quohdrId;
	}
	
	

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="vm"
     *  column="ORDERNO"
     */
	public String getOrderno () {
		return _orderno;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _orderhdrid the new ID
	 */
	public void setOrderno (String _orderno) {
		this._orderno = _orderno;
	}
	
	

	/**
     */
	public String getBookingnumber() {return _bookingnumber;}
	/**
	 */
	public void setBookingnumber (String _bookingnumber) {
		this._bookingnumber = _bookingnumber;
	}
	
	


	/**
	 * Return the value associated with the column: ordertype
	 */
	public java.lang.String getOrdertype () {
		return _ordertype;
	}

	/**
	 * Set the value related to the column: ordertype
	 * @param _ordertype the ordertype value
	 */
	public void setOrdertype (java.lang.String _ordertype) {
		this._ordertype = _ordertype;
	}


	/**
	 * Return the value associated with the column: DELETED
	 */
	public boolean getDeleted () {
		return _deleted;
	}

	/**
	 * Set the value related to the column: DELETED
	 * @param _deleted the DELETED value
	 */
	public void setDeleted (boolean _deleted) {
		this._deleted = _deleted;
	}



	public Date getDocumentclosingdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getDocumentclosingdateyyyy()), Integer
						.parseInt(getDocumentclosingdatemm()) - 1, Integer
						.parseInt(getDocumentclosingdatedd()));
		return c.getTime();
	}
	public void setDocumentclosingdate(Date documentclosingdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(documentclosingdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setDocumentclosingdateyyyy(c.get(Calendar.YEAR) + "");
		setDocumentclosingdatemm((month < 10 ? "0" : "") + month);
		setDocumentclosingdatedd((day < 10 ? "0" : "") + day);
	}
	public String getDocumentclosingdatedd () {return _documentclosingdatedd;}
	public void setDocumentclosingdatedd (String _documentclosingdatedd) {this._documentclosingdatedd = _documentclosingdatedd;}
	public String getDocumentclosingdatemm () {return _documentclosingdatemm;}
	public void setDocumentclosingdatemm (String _documentclosingdatemm) {this._documentclosingdatemm = _documentclosingdatemm;}
	public String getDocumentclosingdateyyyy () {return _documentclosingdateyyyy;}
	public void setDocumentclosingdateyyyy (String _documentclosingdateyyyy) {this._documentclosingdateyyyy = _documentclosingdateyyyy;}
	

	public Date getTankclosingdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getTankclosingdateyyyy()), Integer
						.parseInt(getTankclosingdatemm()) - 1, Integer
						.parseInt(getTankclosingdatedd()));
		return c.getTime();
	}
	public void setTankclosingdate(Date tankclosingdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(tankclosingdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setTankclosingdateyyyy(c.get(Calendar.YEAR) + "");
		setTankclosingdatemm((month < 10 ? "0" : "") + month);
		setTankclosingdatedd((day < 10 ? "0" : "") + day);
	}
	public String getTankclosingdatedd () {return _tankclosingdatedd;}
	public void setTankclosingdatedd (String _tankclosingdatedd) {this._tankclosingdatedd = _tankclosingdatedd;}
	public String getTankclosingdatemm () {return _tankclosingdatemm;}
	public void setTankclosingdatemm (String _tankclosingdatemm) {this._tankclosingdatemm = _tankclosingdatemm;}
	public String getTankclosingdateyyyy () {return _tankclosingdateyyyy;}
	public void setTankclosingdateyyyy (String _tankclosingdateyyyy) {this._tankclosingdateyyyy = _tankclosingdateyyyy;}

	/**
	 * Return the value associated with the column: deliveryterminaltext
	 */
	public java.lang.String getDeliveryterminaltext () {
		return _deliveryterminaltext;
	}

	/**
	 * Set the value related to the column: deliveryterminaltext
	 * @param deliveryterminaltext the deliveryterminaltext value
	 */
	public void setDeliveryterminaltext (java.lang.String _deliveryterminaltext) {
		this._deliveryterminaltext = _deliveryterminaltext;
	}
	
	
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
	
	
	

	
	public Date getOrderdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getOrderdateyyyy()), Integer
						.parseInt(getOrderdatemm()) - 1, Integer
						.parseInt(getOrderdatedd()));
		return c.getTime();
	}
	public void setOrderdate(Date orderdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(orderdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setOrderdateyyyy(c.get(Calendar.YEAR) + "");
		setOrderdatemm((month < 10 ? "0" : "") + month);
		setOrderdatedd((day < 10 ? "0" : "") + day);
	}
	public String getOrderdatedd () {return _orderdatedd;}
	public void setOrderdatedd (String _orderdatedd) {this._orderdatedd = _orderdatedd;}
	public String getOrderdatemm () {return _orderdatemm;}
	public void setOrderdatemm (String _orderdatemm) {this._orderdatemm = _orderdatemm;}
	public String getOrderdateyyyy () {return _orderdateyyyy;}
	public void setOrderdateyyyy (String _orderdateyyyy) {this._orderdateyyyy = _orderdateyyyy;}


	
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

	
	
	public Date getLdgfromdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getLdgfromdateyyyy()), Integer
						.parseInt(getLdgfromdatemm()) - 1, Integer
						.parseInt(getLdgfromdatedd()));
		return c.getTime();
	}
	public void setLdgfromdate(Date ldgfromdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(ldgfromdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setLdgfromdateyyyy(c.get(Calendar.YEAR) + "");
		setLdgfromdatemm((month < 10 ? "0" : "") + month);
		setLdgfromdatedd((day < 10 ? "0" : "") + day);
	}
	public String getLdgfromdatedd () {return _ldgfromdatedd;}
	public void setLdgfromdatedd (String _ldgfromdatedd) {this._ldgfromdatedd = _ldgfromdatedd;}
	public String getLdgfromdatemm () {return _ldgfromdatemm;}
	public void setLdgfromdatemm (String _ldgfromdatemm) {this._ldgfromdatemm = _ldgfromdatemm;}
	public String getLdgfromdateyyyy () {return _ldgfromdateyyyy;}
	public void setLdgfromdateyyyy (String _ldgfromdateyyyy) {this._ldgfromdateyyyy = _ldgfromdateyyyy;}

	public String getLdgfromtime() {
		String time = getLdgfromtimehh()+":"+getLdgfromtimemm();
		return time;
	}
	public void setLdgfromtime(String ldgfromtime) {
		String hh = "00";
		try{hh = ldgfromtime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = ldgfromtime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setLdgfromtimehh(hh);
		setLdgfromtimemm(mm);
	}
	public String getLdgfromtimehh () {return _ldgfromtimehh;}
	public void setLdgfromtimehh (String _ldgfromtimehh) {this._ldgfromtimehh = _ldgfromtimehh;}
	public String getLdgfromtimemm () {return _ldgfromtimemm;}
	public void setLdgfromtimemm (String _ldgfromtimemm) {this._ldgfromtimemm = _ldgfromtimemm;}
	
	
	
	public Date getLdgtodate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getLdgtodateyyyy()), Integer
						.parseInt(getLdgtodatemm()) - 1, Integer
						.parseInt(getLdgtodatedd()));
		return c.getTime();
	}
	public void setLdgtodate(Date ldgtodate) {
		Calendar c = Calendar.getInstance();
		c.setTime(ldgtodate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setLdgtodateyyyy(c.get(Calendar.YEAR) + "");
		setLdgtodatemm((month < 10 ? "0" : "") + month);
		setLdgtodatedd((day < 10 ? "0" : "") + day);
	}
	public String getLdgtodatedd () {return _ldgtodatedd;}
	public void setLdgtodatedd (String _ldgtodatedd) {this._ldgtodatedd = _ldgtodatedd;}
	public String getLdgtodatemm () {return _ldgtodatemm;}
	public void setLdgtodatemm (String _ldgtodatemm) {this._ldgtodatemm = _ldgtodatemm;}
	public String getLdgtodateyyyy () {return _ldgtodateyyyy;}
	public void setLdgtodateyyyy (String _ldgtodateyyyy) {this._ldgtodateyyyy = _ldgtodateyyyy;}

	public String getLdgtotime() {
		String time = getLdgtotimehh()+":"+getLdgtotimemm();
		return time;
	}
	public void setLdgtotime(String ldgtotime) {
		String hh = "00";
		try{hh = ldgtotime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = ldgtotime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setLdgtotimehh(hh);
		setLdgtotimemm(mm);
	}
	public String getLdgtotimehh () {return _ldgtotimehh;}
	public void setLdgtotimehh (String _ldgtotimehh) {this._ldgtotimehh = _ldgtotimehh;}
	public String getLdgtotimemm () {return _ldgtotimemm;}
	public void setLdgtotimemm (String _ldgtotimemm) {this._ldgtotimemm = _ldgtotimemm;}
	
	
	
	public Date getDchfromdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getDchfromdateyyyy()), Integer
						.parseInt(getDchfromdatemm()) - 1, Integer
						.parseInt(getDchfromdatedd()));
		return c.getTime();
	}
	public void setDchfromdate(Date dchfromdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(dchfromdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setDchfromdateyyyy(c.get(Calendar.YEAR) + "");
		setDchfromdatemm((month < 10 ? "0" : "") + month);
		setDchfromdatedd((day < 10 ? "0" : "") + day);
	}
	public String getDchfromdatedd () {return _dchfromdatedd;}
	public void setDchfromdatedd (String _dchfromdatedd) {this._dchfromdatedd = _dchfromdatedd;}
	public String getDchfromdatemm () {return _dchfromdatemm;}
	public void setDchfromdatemm (String _dchfromdatemm) {this._dchfromdatemm = _dchfromdatemm;}
	public String getDchfromdateyyyy () {return _dchfromdateyyyy;}
	public void setDchfromdateyyyy (String _dchfromdateyyyy) {this._dchfromdateyyyy = _dchfromdateyyyy;}

	public String getDchtotime() {
		String time = getDchtotimehh()+":"+getDchtotimemm();
		return time;
	}
	public void setDchtotime(String dchtotime) {
		String hh = "00";
		try{hh = dchtotime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = dchtotime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setDchtotimehh(hh);
		setDchtotimemm(mm);
	}
	public String getDchtotimehh () {return _dchtotimehh;}
	public void setDchtotimehh (String _dchtotimehh) {this._dchtotimehh = _dchtotimehh;}
	public String getDchtotimemm () {return _dchtotimemm;}
	public void setDchtotimemm (String _dchtotimemm) {this._dchtotimemm = _dchtotimemm;}

	
	
	public Date getDchtodate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getDchtodateyyyy()), Integer
						.parseInt(getDchtodatemm()) - 1, Integer
						.parseInt(getDchtodatedd()));
		return c.getTime();
	}
	public void setDchtodate(Date dchtodate) {
		Calendar c = Calendar.getInstance();
		c.setTime(dchtodate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setDchtodateyyyy(c.get(Calendar.YEAR) + "");
		setDchtodatemm((month < 10 ? "0" : "") + month);
		setDchtodatedd((day < 10 ? "0" : "") + day);
	}
	public String getDchtodatedd () {return _dchtodatedd;}
	public void setDchtodatedd (String _dchtodatedd) {this._dchtodatedd = _dchtodatedd;}
	public String getDchtodatemm () {return _dchtodatemm;}
	public void setDchtodatemm (String _dchtodatemm) {this._dchtodatemm = _dchtodatemm;}
	public String getDchtodateyyyy () {return _dchtodateyyyy;}
	public void setDchtodateyyyy (String _dchtodateyyyy) {this._dchtodateyyyy = _dchtodateyyyy;}

	public String getDchfromtime() {
		String time = getDchfromtimehh()+":"+getDchfromtimemm();
		return time;
	}
	public void setDchfromtime(String dchfromtime) {
		String hh = "00";
		try{hh = dchfromtime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = dchfromtime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setDchfromtimehh(hh);
		setDchfromtimemm(mm);
	}
	public String getDchfromtimehh () {return _dchfromtimehh;}
	public void setDchfromtimehh (String _dchfromtimehh) {this._dchfromtimehh = _dchfromtimehh;}
	public String getDchfromtimemm () {return _dchfromtimemm;}
	public void setDchfromtimemm (String _dchfromtimemm) {this._dchfromtimemm = _dchfromtimemm;}

	
	
	
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
	 */
	public java.lang.String getDmrgbilltoaddrkey () {
		return _dmrgbilltoaddrkey;
	}

	/**
	 */
	public void setDmrgbilltoaddrkey (java.lang.String _dmrgbilltoaddrkey) {
		this._dmrgbilltoaddrkey = _dmrgbilltoaddrkey;
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
	 * Return the value associated with the column: DMRGfreedaysleft
	 */
	public String getDmrgfreedaysleft () {
		return _dmrgfreedaysleft;
	}

	/**
	 * Set the value related to the column: DMRGfreedaysleft
	 * @param _dmrgfreedaysleft the DMRGfreedaysleft value
	 */
	public void setDmrgfreedaysleft (String _dmrgfreedaysleft) {
		this._dmrgfreedaysleft = _dmrgfreedaysleft;
	}


	/**
	 * Return the value associated with the column: DELTERM
	 */
	public java.lang.String getDelterm () {
		return _delterm;
	}

	/**
	 * Set the value related to the column: DELTERM
	 * @param _delterm the DELTERM value
	 */
	public void setDelterm (java.lang.String _delterm) {
		this._delterm = _delterm;
	}






	/**
	 * Return the value associated with the column: orderbyuserid
	 */
	public java.lang.String getOrderbyuserid () {
		return _orderbyuserid;
	}

	/**
	 * Set the value related to the column: orderbyuserid
	 * @param _orderbyuserid the orderbyuserid value
	 */
	public void setOrderbyuserid (java.lang.String _orderbyuserid) {
		this._orderbyuserid = _orderbyuserid;
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
	 * Return the value associated with the column: systemloguserid
	 */
	public java.lang.String getSystemloguserid () {
		return _systemloguserid;
	}

	/**
	 * Set the value related to the column: systemloguserid
	 * @param _systemloguserid the systemloguserid value
	 */
	public void setSystemloguserid (java.lang.String _systemloguserid) {
		this._systemloguserid = _systemloguserid;
	}




	/**
	 * Return the value associated with the column: NOTES
	 */
	public java.lang.String getNotes () {
		return _notes;
	}

	/**
	 * Set the value related to the column: NOTES
	 * @param _notes the NOTES value
	 */
	public void setNotes (java.lang.String _notes) {
		this._notes = _notes;
	}




	/**
	 * Return the value associated with the column: orderstatus
	 */
	public java.lang.String getOrderstatus () {
		return _orderstatus;
	}

	/**
	 * Set the value related to the column: orderstatus
	 * @param _orderstatus the orderstatus value
	 */
	public void setOrderstatus (java.lang.String _orderstatus) {
		this._orderstatus = _orderstatus;
	}


	/**
	 * Return the value associated with the column: invoicestatus
	 */
	public java.lang.String getInvoicestatus () {
		return _invoicestatus;
	}

	/**
	 * Set the value related to the column: invoicestatus
	 * @param _invoicestatus the invoicestatus value
	 */
	public void setInvoicestatus (java.lang.String _invoicestatus) {
		this._invoicestatus = _invoicestatus;
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
	public String getCustomeraddrkey () {
		return _customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param _customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (String _customeraddrkey) {
		this._customeraddrkey = _customeraddrkey;
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
	 */
	public java.lang.String getConsignmentno() {	return _consignmentno; }
	/**
	 */
	public void setConsignmentno(java.lang.String _consignmentno) {this._consignmentno = _consignmentno;	}
	
	
	
	
	/**
	 * Return the value associated with the column: product
	 */
	public java.lang.String getProductkey() {	return _productkey; }
	/**
	 * Set the value related to the column: product
	 * @param __productkey the product value
	 */
	public void setProductkey(java.lang.String _productkey) {this._productkey = _productkey;	}



	public String getContracttype () { return _contracttype; }//ITT-201207-0001
	public void setContracttype (String _contracttype) { this._contracttype = _contracttype; }//ITT-201207-0001
	
	
	

	public java.lang.String getShipvendoraddrkey () {
		return shipvendoraddrkey;
	}
	public void setShipvendoraddrkey (java.lang.String shipvendoraddrkey) {
		this.shipvendoraddrkey = shipvendoraddrkey;
	}
	
	public java.lang.String getShipvessel () {
		return shipvessel;
	}
	public void setShipvessel (java.lang.String shipvessel) {
		this.shipvessel = shipvessel;
	}

	public java.lang.String getShipvoyage () {
		return shipvoyage;
	}
	public void setShipvoyage (java.lang.String shipvoyage) {
		this.shipvoyage = shipvoyage;
	}
	

	public boolean isCompleteflag () {
		return completeflag;
	}
	public void setCompleteflag (boolean completeflag) {
		this.completeflag = completeflag;
	}
	

    // --------------------------------------------- Public Lookup Methods

 

	
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
        
        
        if ((_orderno == null) || (_orderno.length() < 1))
            errors.add("orderno",
                    new ActionMessage("error.orderno.required"));        	

		if (action.equals("Create")) {
			if (Util.invalidChars(this._orderno)) errors.add("orderno", new ActionMessage("error.orderno.invalidchars"));
		}
		
        if ((_companykey == null) || (_companykey.length() < 1))
            errors.add("companykey",
                    new ActionMessage("error.company.required"));        	

        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_orderdateyyyy+"-"+
									_orderdatemm+"-"+ 
									_orderdatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("orderdatedd", new ActionMessage("error.orderdate.required"));        	

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
        
        if (
        	copyQuotationButton != null &&
			!copyQuotationButton.equals("") &&
			copyQuoteId.equals("")
			) {
        		errors.add("copyQuote",
                    new ActionMessage("error.quotno.required"));        	
        }

           		
        
        
        if (copyQuotationButton == null) {  
    		addErrorIfBlank(errors, "customeraddrkey", _customeraddrkey, "error.customeraddrkey.required");        	
        	
    		addErrorIfBlank(errors, "ccykey", _ccykey, "error.ccykey.required");  
    		
    		addErrorIfBlank(errors, "contracttype", _contracttype, "error.contracttype.required");//ITT-201207-0001  
    		
        	if ((_ldglocationkey2 == null) || (_ldglocationkey2.length() < 1))
        		errors.add("ldglocationkey2",
                    new ActionMessage("error.ldgport.required"));
        	if ((_dchlocationkey2 == null) || (_dchlocationkey2.length() < 1))
        		errors.add("dchlocationkey2",
                    new ActionMessage("error.dchport.required"));        	
        }
        
        date = null;
    	dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_ldgfromdateyyyy+"-"+
    								_ldgfromdatemm+"-"+ 
    								_ldgfromdatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("ldgfromdatedd", new ActionMessage("error.ldgfromdate.required"));        	

        date = null;
    	dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_ldgtodateyyyy+"-"+
    								_ldgtodatemm+"-"+ 
    								_ldgtodatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("ldgtodatedd", new ActionMessage("error.ldgtodate.required"));        	

        
        date = null;
    	dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_dchfromdateyyyy+"-"+
    								_dchfromdatemm+"-"+ 
    								_dchfromdatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("dchfromdatedd", new ActionMessage("error.dchfromdate.required"));        	

        date = null;
    	dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_dchtodateyyyy+"-"+
    								_dchtodatemm+"-"+ 
    								_dchtodatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("dchtodatedd", new ActionMessage("error.dchtodate.required"));        	

       try {
		Calendar calendarLdgfromDate = Calendar.getInstance();
		calendarLdgfromDate.set(
				Integer.parseInt(getLdgfromdateyyyy()), 
				Integer.parseInt(getLdgfromdatemm()) - 1, 
				Integer.parseInt(getLdgfromdatedd()),
				Integer.parseInt(getLdgfromtimehh()),
				Integer.parseInt(getLdgfromtimemm()),
				0
				);		
		Calendar calendarLdgtoDate = Calendar.getInstance();
		calendarLdgtoDate.set(
				Integer.parseInt(getLdgtodateyyyy()), 
				Integer.parseInt(getLdgtodatemm()) - 1, 
				Integer.parseInt(getLdgtodatedd()),
				Integer.parseInt(getLdgtotimehh()),
				Integer.parseInt(getLdgtotimemm()),
				0
				);	
        if (calendarLdgtoDate.before(calendarLdgfromDate))
            errors.add("ldgtodatedd",
                    new ActionMessage("error.ldgtodate.afterldgfromdate"));  
		
		Calendar calendarDchfromDate = Calendar.getInstance();
		calendarDchfromDate.set(
				Integer.parseInt(getDchfromdateyyyy()), 
				Integer.parseInt(getDchfromdatemm()) - 1, 
				Integer.parseInt(getDchfromdatedd()),
				Integer.parseInt(getDchfromtimehh()),
				Integer.parseInt(getDchfromtimemm()),
				0
				);		
		Calendar calendarDchtoDate = Calendar.getInstance();
		calendarDchtoDate.set(
				Integer.parseInt(getDchtodateyyyy()), 
				Integer.parseInt(getDchtodatemm()) - 1, 
				Integer.parseInt(getDchtodatedd()),
				Integer.parseInt(getDchtotimehh()),
				Integer.parseInt(getDchtotimemm()),
				0
				);	
        if (calendarDchtoDate.before(calendarDchfromDate))
            errors.add("dchtodatedd",
                    new ActionMessage("error.dchtodate.afterdchfromdate")); 

       
       if (calendarDchfromDate.before(calendarLdgtoDate))
           errors.add("dchtodatedd",
                   new ActionMessage("error.dchfromdate.afterldgtodate")); 
       
      } catch(Exception e) {}
      
 
      date = null;
  	dateFormatter = new DateFormatter();
      try {
  		date = (java.util.Date)dateFormatter.unformat(
  								_documentclosingdateyyyy+"-"+
  								_documentclosingdatemm+"-"+ 
  								_documentclosingdatedd
									);
      } catch (Exception e) {}	        	
      if (date == null) errors.add("_documentclosingdatedd", new ActionMessage("error.documentclosingdate.required"));

      
      date = null;
    	dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_tankclosingdateyyyy+"-"+
    								_tankclosingdatemm+"-"+ 
    								_tankclosingdatedd
  									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("_tankclosingdatedd", new ActionMessage("error.tankclosingdate.required"));
                
      
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
