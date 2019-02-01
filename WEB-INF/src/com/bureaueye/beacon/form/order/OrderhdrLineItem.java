/*
 * $Id: OrderhdrLineItem.java 12/09/2005 ntankard
 */


package com.bureaueye.beacon.form.order;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.standard.Address;


/**
 */

public final class OrderhdrLineItem extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrderhdrLineItem (Orderhdr orderhdr, Address customerAddress) {
		this._id = orderhdr.getId().toString();
		this._quotno = orderhdr.getQuotno();
		this._orderno = orderhdr.getOrderno();
		this._orderdate = orderhdr.getOrderdate();		
		this._orderstatus = orderhdr.getOrderstatus();
		this._orderbyuserid = orderhdr.getOrderbyuserid();		
		this._companykey = orderhdr.getCompanykey();
		this._shipmethod = orderhdr.getShipmethod();	
		this._departmentkey = orderhdr.getDepartmentkey();	
		this._activitykey = orderhdr.getActivitykey();
		this._customerref = orderhdr.getCustomerref();	
		this._customername = customerAddress.getName();	
		this._invoicestatus = orderhdr.getInvoicestatus();	
		
		this._notes = orderhdr.getNotes();	
		
		//if (orderhdr.getJobhdrs().size() > 0) this._jobhdrsfound = "true";
		this._jobhdrsfound = "false";
/*		try {
			if (new OrderhdrBD(this.getSessionFactoryClusterMap()).getJobhdrs(orderhdr.getId()).size() > 0) this._jobhdrsfound = "true";
		} catch (ApplicationException ae) {}*/
	}	

    // --------------------------------------------------- Instance Variables

    /**
     * The unique id.
     */
    private String _id;
	private String _readonly = "false";
	private String _jobhdrsfound = "false";

    /**

     */
    private String _invoicestatus;
    private String _notes;
    private String _quotno;
    private String _orderno;
    private java.util.Date _orderdate;    
    private String _customername;     
    private String _orderbyuserid;    
    private String _orderstatus; 
    private String _companykey;  
    private String _departmentkey; 
    private String _activitykey;
    private String _shipmethod;     
    private String _ldglocationname; 
    private String _dchlocationname;
    private String _productname;    
    private String _customerref; 
    
    private boolean checked;
    
    
    // ----------------------------------------------------------- Properties


    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    
    
	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	public String getJobhdrsfound() {return _jobhdrsfound;}
	public void setJobhdrsfound(String _jobhdrsfound) {this._jobhdrsfound = _jobhdrsfound;}



    /**
     */
    public String getInvoicestatus() {
    	return (this._invoicestatus);
    }
    /**
     */
    public void setInvoicestatus(String _invoicestatus) {
        this._invoicestatus = _invoicestatus;
    }
    
    
    /**
     */
    public String getId() {
    	return (this._id);
    }
    /**
     */
    public void setOrderhdrId(String _id) {
        this._id = _id;
    }

    /**
     */
    public String getNotes() {
    	return (this._notes);
    }
    /**
     */
    public void setNotes(String _notes) {
        this._notes = _notes;
    }
    
    /**
     */
    public String getQuotno() {
    	return (this._quotno);
    }
    /**
     */
    public void setQuotno(String _quotno) {
        this._quotno = _quotno;
    }

    /**
     */
    public String getCustomerref() {
    	return (this._customerref);
    }
    /**
     */
    public void setCustomerref(String _customerref) {
        this._customerref = _customerref;
    }
    
    /**
     */
    public String getOrderno() {
    	return (this._orderno);
    }
    /**
     */
    public void setOrderno(String _orderno) {
        this._orderno = _orderno;
    }
    
    
    /**
     */
    public String getCustomername() {
    	return (this._customername);
    }
    /**
     */
    public void setCustomername(String _customername) {
        this._customername = _customername;
    }
    
 

	
	
    /**
     */
    public String getOrderbyuserid() {
    	return (this._orderbyuserid);
    }
    /**
     */
    public void setOrderbyuserid(String _orderbyuserid) {
        this._orderbyuserid = _orderbyuserid;
    }
    
    
    /**
     */
    public String getOrderstatus() {
    	return (this._orderstatus);
    }
    /**
     */
    public void setOrderstatus(String _orderstatus) {
        this._orderstatus = _orderstatus;
    }
    
    
    /**
     */
    public java.util.Date getOrderdate() {	return (this._orderdate); }
    public void setOrderdate(java.util.Date _orderdate) { this._orderdate = _orderdate; }
    
    /**
     */
    public String getCompanykey() {	return (this._companykey); }
    public void setCompanykey(String _companykey) { this._companykey = _companykey; }

    /**
     */
    public String getDepartmentkey() {	return (this._departmentkey); }
    public void setDepartmentkey(String _departmentkey) { this._departmentkey = _departmentkey; }

    /**
     */
    public String getActivitykey() {	return (this._activitykey); }
    public void setActivitykey(String _activitykey) { this._activitykey = _activitykey; }

    /**
     */
    public String getProductname() {	return (this._productname); }
    public void setProductname(String _productname) { this._productname = _productname; }

    /**
     */
    public String getLdglocationname() {	return (this._ldglocationname); }
    public void setLdglocationname(String _ldglocationname) { this._ldglocationname = _ldglocationname; }

    /**
     */
    public String getDchlocationname() {	return (this._dchlocationname); }
    public void setDchlocationname(String _dchlocationname) { this._dchlocationname = _dchlocationname; }

    
    /**
     */
    public String getShipmethod() {	return (this._shipmethod); }
    public void setShipmethod(String _shipmethod) { this._shipmethod = _shipmethod; }
    
    
	
    // --------------------------------------------------------- Public Methods


    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {         
        this.checked = false;        
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

        ActionErrors errors = new ActionErrors();

	return (errors);

    }


}

