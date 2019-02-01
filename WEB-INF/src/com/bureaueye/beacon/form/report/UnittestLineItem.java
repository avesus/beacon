/*
 * $Id: UnittestLineItem.java 12/09/2005 ntankard
 */


package com.bureaueye.beacon.form.report;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.Unittest;


/**
 */

public final class UnittestLineItem extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/*[CONSTRUCTOR MARKER BEGIN]*/
	public UnittestLineItem (Unit unit, Unittest unittest) {
		this._unittestId = unittest.getUnittestId().toString();
		this._unitId = unit.getUnitId().toString();
		this._unitkey = unit.getUnitkey();
		this._duedate = unittest.getDuedate();
		this._lasttestdate = unittest.getLasttestdate();
		this._compdate = unittest.getCompdate();	
		this._testby = unittest.getTestby();		
		this._testtypekey = unittest.getTesttypekey();	
		
		//if (quohdr.getOrderhdrs().size() > 0) this._orderhdrsfound = "true";		
	}	

    // --------------------------------------------------- Instance Variables

    /**
     * The unique id.
     */
    private String _unittestId;
	private String _readonly = "false";
	private String _orderhdrsfound = "false";
	
    /**
     */
    private String _unitId;
    private String _unitkey;
    private java.util.Date _duedate;
    private java.util.Date _compdate;
    private java.util.Date _lasttestdate;    
    private String _testby;    
     private String _testtypekey;  

     
    private boolean checked;
    
    
    // ----------------------------------------------------------- Properties


    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	public String getOrderhdrsfound() {return _orderhdrsfound;}
	public void setOrderhdrsfound(String _orderhdrsfound) {this._orderhdrsfound = _orderhdrsfound;}



    /**
     */
    public String getUnitkey() {
    	return (this._unitkey);
    }
    /**
     */
    public void setUnitkey(String _unitkey) {
        this._unitkey = _unitkey;
    }

    /**
     */
    public String getUnitId() {
    	return (this._unitId);
    }
    /**
     */
    public void setUnitId(String _unitId) {
        this._unitId = _unitId;
    }
    
    /**
     */
    public String getUnittestId() {
    	return (this._unittestId);
    }
    /**
     */
    public void setUnittestId(String _unittestId) {
        this._unittestId = _unittestId;
    }
    



 
	/**
	 * Return the value associated with the column: duedate
	 */
	public java.util.Date getDuedate () {
		return _duedate;
	}

	/**
	 * Set the value related to the column: duedate
	 * @param _duedate the duedate value
	 */
	public void setDuedate (java.util.Date _duedate) {
		this._duedate = _duedate;
	}
	

	/**
	 * Return the value associated with the column: compdate
	 */
	public java.util.Date getCompdate () {
		return _compdate;
	}

	/**
	 * Set the value related to the column: duedate
	 * @param _duedate the duedate value
	 */
	public void setCompdate (java.util.Date _compdate) {
		this._compdate = _compdate;
	}
	
	
    /**
     */
    public String getTestby() {
    	return (this._testby);
    }
    /**
     */
    public void setTestby(String _testby) {
        this._testby = _testby;
    }
    
    
    
    
    /**
     */
    public java.util.Date getLasttestdate() {	return (this._lasttestdate); }
    public void setLasttestdate(java.util.Date _lasttestdate) { this._lasttestdate = _lasttestdate; }
    
    /**
     */
    public String getTesttypekey() {	return (this._testtypekey); }
    public void setTesttypekey(String _testtypekey) { this._testtypekey = _testtypekey; }

     
    
	
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

