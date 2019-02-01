package com.bureaueye.beacon.form.agent;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.model.agent.dto.AgentJobmovDTO;





public final class AgentjobForm extends BaseForm  {


    // ----------------------------------------------------- Instance Variables


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
     * The maintenance action we are performing (Create or Edit).
     */
    private String action;


	
	// key fields
	private java.lang.String _orderhdrId;
	private java.lang.String _orderno;
	private java.lang.String _quohdrId;
	private java.lang.String _quotno;
	private java.lang.String _jobhdrId;
	private java.lang.String _jobno;
	
	
	// fields
	private java.lang.String _ordertype;
	private boolean _deleted;
	
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
	

	
	private java.lang.String _dmrgdlyrate1;
	private java.lang.String _dmrgdlyrate2;
	private java.lang.String _dmrgdlyrate3;	
	private java.lang.String _dmrglocationkey;
	private java.lang.String _dmrgccykey;
	private java.lang.String _dmrgbilltoaddrkey;
	private java.lang.String _dmrgfreedaysleft;
	private java.lang.String _dmrgfreedays;
	private java.lang.String _dmrgdays1;
	private java.lang.String _dmrgdays2;
	

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
	


	// product fields
	private java.lang.String _surftemp;
	private java.lang.String _volunit;
	private String _productkey;
	private java.lang.String _ldgtemp;
	private java.lang.String _comprt;
	private java.lang.String _volume;
	private java.lang.String _tempunit;
	private java.lang.String _wghtunit;
	private java.lang.String _lqdtemp;
	private java.lang.String _weight;
	private java.lang.String _imo;
	private java.lang.String _dchtemp;
	private java.lang.String _productname;
	private java.lang.String _unno;
	private java.lang.String _tradname;
	

	// job fields
	private java.lang.String _movref;
	private java.lang.String _unitId;	
	private java.lang.String _unitkey;
	private java.lang.String _sealnumbers;
	private java.lang.String _addinstruction;
	private java.lang.String _weightactualunit;
	private java.lang.String _weightactual;
	
	
	// collections
	private Hashtable<Integer,AgentJobmovDTO> jobmovs; 
	
	
	
    // ----------------------------------------------------------- Properties

    
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
	public String getOrderhdrId () {
		return _orderhdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _orderhdrid the new ID
	 */
	public void setOrderhdrId (String _orderhdrId) {
		this._orderhdrId = _orderhdrId;
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

	
	
	
	

	   // --------------------------------------------- Product Methods
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
	 * Return the value associated with the column: tradname
	 */
	public java.lang.String getTradname () {
		return _tradname;
	}

	/**
	 * Set the value related to the column: tradname
	 * @param tradname the tradname value
	 */
	public void setTradname (java.lang.String _tradname) {
		this._tradname = _tradname;
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



    // --------------------------------------------- Job Methods	
	public String getMovref() {
		return _movref;
	}

	public void setMovref(String _movref) {
		this._movref = _movref;
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
	
	
	

    // --------------------------------------------- Collection Methods	

	public java.util.Hashtable getJobmovs () {
		return this.jobmovs;
	}

	public void setJobmovs_ (Hashtable<Integer,AgentJobmovDTO> jobmovs) {
		this.jobmovs = jobmovs;
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

    
    public void clear(ActionMapping mapping, HttpServletRequest request) {

        this.action = "Create";
        
    	this._orderhdrId = "";
    	this._orderno = "";
    	this._quohdrId = "";
    	this._quotno = "";
    	this._jobhdrId = "";
    	this._jobno = "";
    	
    	
    	// fields
    	this._ordertype = "";
    	
    	this._bookingnumber = "";
    	
    	this._orderdatedd ="00";
    	this._orderdatemm ="00";
    	this._orderdateyyyy = "0000";
    	
    	this._documentclosingdatedd ="00";
    	this._documentclosingdatemm ="00";
    	this._documentclosingdateyyyy = "0000";
    	this._tankclosingdatedd ="00";
    	this._tankclosingdatemm ="00";
    	this._tankclosingdateyyyy = "0000";
    	this._deliveryterminaltext = "";
    	
    	this._incotermkey = "";
    	
    	
    	this._exchgdatedd ="00";
    	this._exchgdatemm ="00";
    	this._exchgdateyyyy = "0000";
    	
    	this._ldgfromdatedd ="00";
    	this._ldgfromdatemm ="00";
    	this._ldgfromdateyyyy = "0000";
    	this._ldgfromtimehh ="00";
    	this._ldgfromtimemm ="00";
    	
    	this._ldgtodatedd ="00";
    	this._ldgtodatemm ="00";
    	this._ldgtodateyyyy = "0000";
    	this._ldgtotimehh ="00";
    	this._ldgtotimemm ="00";
    	
    	this._dchfromdatedd ="00";
    	this._dchfromdatemm ="00";
    	this._dchfromdateyyyy = "0000";
    	this._dchfromtimehh ="00";
    	this._dchfromtimemm ="00";
    	
    	this._dchtodatedd ="00";
    	this._dchtodatemm ="00";
    	this._dchtodateyyyy = "0000";
    	this._dchtotimehh ="00";
    	this._dchtotimemm ="00";
    	
    	this._orderstatus = "";
    	this._invoicestatus = "";
    	

    	
    	this._dmrgdlyrate1 = "0.00";
    	this._dmrgdlyrate2 = "0.00";
    	this._dmrgdlyrate3 = "0.00";	
    	this._dmrglocationkey = "";
    	this._dmrgccykey = "";
    	this._dmrgbilltoaddrkey = "";
    	this._dmrgfreedaysleft = "0";
    	this._dmrgfreedays = "0";
    	this._dmrgdays1 = "0";
    	this._dmrgdays2 = "0";
    	

    	this._ldglocationkey1 = "";
    	this._dchlocationkey1 = "";
    	this._ldglocationkey2 = "";
    	this._dchlocationkey2 = "";

    	

    	this._delterm = "";


    	this._orderbyuserid = "";


    	this._shipperaddrkey = "";



    	this._ccykey = "";
    	this._systemloguserid = "";

    	this._notes = "";



    	
    	this._brokeraddrkey = "";
    	this._fwdagentaddrkey = "";
    	this._consigneeaddrkey = "";
    	this._customeraddrkey = "";

    	
    	

    	this._companykey = "";
    	this._departmentkey = "";
    	this._activitykey = "";
    	
    	this._createuserid = "";



    	this._customerref = "";
    	this._shipperref = "";
    	this._fwdagentref = "";
    	this._brokerref = "";
    	this._consigneeref = "";	

    	this._shipmethod = "";	
    	


    	// product fields
    	this._surftemp = "0.0";
    	this._volunit = "";
    	this._productkey = "";
    	this._ldgtemp = "0.0";
    	this._comprt = "0";
    	this._volume = "0.0";
    	this._tempunit = "";
    	this._wghtunit = "";
    	this._lqdtemp = "0.0";
    	this._weight = "0.0";
    	this._imo = "";
    	this._dchtemp = "0.0";
    	this._productname = "";
    	this._unno = "";
    	this._tradname = "";
    	

    	// job fields
    	this._movref = "";
    	this._unitId = "";	
    	this._unitkey = "";
    	this._sealnumbers = "";
    	this._addinstruction = "";
    	this._weightactualunit = "";
    	this._weightactual = "0.0";
    	
    	
    	// collections
    	this.jobmovs = null;
	

    	
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
      
        return errors;

    }

    
/*	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}*/
	
    
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
