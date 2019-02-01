/*
 * $Id: QuosummaryCostLineItem.java 12/09/2005 ntankard
 */


package com.bureaueye.beacon.model.quotation.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.quotation.Quocost;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Cost;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CostBD;



/**
 */

public final class QuosummaryCostDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public QuosummaryCostDTO(Quocost dao) throws ApplicationException {
		initialize(dao);		
	}
	public QuosummaryCostDTO(Quocost quocost, Quomov quomov) throws ApplicationException {
		initialize(quomov, quocost);		
	}	
	public QuosummaryCostDTO(Quocost dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}		
	public QuosummaryCostDTO(Quocost quocost, Quomov quomov, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(quomov, quocost);
	}

	
	
	
	protected void initialize (Quocost dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this._quocostId = dao.getQuocostId();

		this._vendtarfhdrId = dao.getVendtarfhdrId();
		
		this._vendoraddrkey = new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getVendoraddrkey());		
		this._costkey = new CostBD(this.getSessionFactoryClusterMap()).read(dao.getCostkey());
		
		this._ccykey = dao.getCcykey();			
		this._cstamt = dao.getCstamt();			
		this._xratebase = dao.getXrate();
		try {
			this._cstamtbase = (this._cstamt.multiply(this._xratebase));
		} catch (Exception e) {
			this._cstamtbase = new BigDecimal(0);	
		}
	}
	
	protected void initialize (Quomov quomov,
			Quocost quocost) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this._quomovId = quomov.getQuomovId();
		this._quocostId = quocost.getQuocostId();

		this._vendtarfhdrId = quocost.getVendtarfhdrId();
		
		this._vendoraddrkey = new AddressBD(this.getSessionFactoryClusterMap()).read(quocost.getVendoraddrkey());
		this._costkey = new CostBD(this.getSessionFactoryClusterMap()).read(quocost.getCostkey());
		
		this._ccykey = quocost.getCcykey();			
		this._cstamt = quocost.getCstamt();			
		this._xratebase = quocost.getXrate();
		try {
			this._cstamtbase = (this._cstamt.multiply(this._xratebase));
		} catch (Exception e) {
			this._cstamtbase = new BigDecimal(0);	
		}
	}
	
	

	
    // --------------------------------------------------- Instance Variables

    /**
     * The unique id.
     */
    private String _id;

	// fields
	private java.lang.Integer _quohdrId;
	private java.lang.Integer _quocostId;
	private java.lang.Integer _quomovId;	
	
    private String _vendorname;     
	private Address _vendoraddrkey;
	
	private java.lang.String _costtype;
	private java.lang.String _uname;
	
	private java.lang.String _vendtarfhdrId;
	private java.lang.String _vendtarfhdrnotes;

	private java.lang.String _txt1;
	private java.lang.String _txt2;
	
	private java.math.BigDecimal _cstamt;
	private java.math.BigDecimal _xratebase;	
	private java.math.BigDecimal _cstamtbase;
	
	private Cost _costkey;
	private java.lang.String _costdescr;
	
	private java.math.BigDecimal _units;
	private java.lang.String _ccykey;
	private java.math.BigDecimal _rate;
	
    
    private boolean checked;
    
    
    // ----------------------------------------------------------- Properties


    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    
    




    /**
     */
    public String getId() {
    	return (this._id);
    }
    /**
     */
    public void setId(String _id) {
        this._id = _id;
    }

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="QUOCHARGE_ID"
     */
	public java.lang.Integer getQuocostId () {
		return _quocostId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _quocostId the new ID
	 */
	public void setQuocostId (java.lang.Integer _quocostId) {
		this._quocostId = _quocostId;
	}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="QUOMOV_ID"
     */
	public java.lang.Integer getQuomovId () {
		return _quomovId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param __quomovId the new ID
	 */
	public void setQuomovId (java.lang.Integer _quomovId) {
		this._quomovId = _quomovId;
	}
	
	

	/**
	 * Return the value associated with the column: costtype
	 */
	public java.lang.String getCosttype () {
		return _costtype;
	}

	/**
	 * Set the value related to the column: costtype
	 * @param _costtype the costtype value
	 */
	public void setCosttype (java.lang.String _costtype) {
		this._costtype = _costtype;
	}




	/**
	 * Return the value associated with the column: UNAME
	 */
	public java.lang.String getUname () {
		return _uname;
	}

	/**
	 * Set the value related to the column: UNAME
	 * @param _uname the UNAME value
	 */
	public void setUname (java.lang.String _uname) {
		this._uname = _uname;
	}


	/**
	 * Return the value associated with the column: VENDTARFHDR_ID
	 */
	public java.lang.String getVendtarfhdrId () {
		return _vendtarfhdrId;
	}

	/**
	 * Set the value related to the column: VENDTARFHDR_ID
	 * @param _vendtarfhdrId the VENDTARFHDR_ID value
	 */
	public void setVendtarfhdrId (java.lang.String _vendtarfhdrId) {
		this._vendtarfhdrId = _vendtarfhdrId;
	}

	/**
	 * Return the value associated with the column: VENDTARFHDRNOTES
	 */
	public String getVendtarfhdrnotes () {
		return _vendtarfhdrnotes;
	}

	/**
	 * Set the value related to the column: VENDTARFHDR_ID
	 * @param _vendtarfhdrId the VENDTARFHDR_ID value
	 */
	public void setVendtarfhdrnotes (String _vendtarfhdrnotes) {
		this._vendtarfhdrnotes = _vendtarfhdrnotes;
	}
	
	


	/**
	 * Return the value associated with the column: XRATEBASE
	 */
	public java.math.BigDecimal getXratebase () {
		return _xratebase;
	}

	/**
	 * Set the value related to the column: XRATEBASE
	 * @param _xratebase the XRATEBASE value
	 */
	public void setXratebase (java.math.BigDecimal _xratebase) {
		this._xratebase = _xratebase;
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
	 * Return the value associated with the column: vendoraddrkey
	 */
	public Address getVendoraddrkey () {
		return _vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param _vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (Address _vendoraddrkey) {
		this._vendoraddrkey = _vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: QUOHDR_ID
	 */
	public java.lang.Integer getQuohdrId () {
		return _quohdrId;
	}

	/**
	 * Set the value related to the column: QUOHDR_ID
	 * @param _quohdrId the QUOHDR_ID value
	 */
	public void setQuohdrId (java.lang.Integer _quohdrId) {
		this._quohdrId = _quohdrId;
	}


	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2 () {
		return _txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * @param _txt2 the txt2 value
	 */
	public void setTxt2 (java.lang.String _txt2) {
		this._txt2 = _txt2;
	}



	/**
	 * Return the value associated with the column: CHGAMT
	 */
	public java.math.BigDecimal getCstamt () {
		return _cstamt;
	}

	/**
	 * Set the value related to the column: CHGAMT
	 * @param _cstamt the CHGAMT value
	 */
	public void setCstamt (java.math.BigDecimal _cstamt) {
		this._cstamt = _cstamt;
	}


	/**
	 * Return the value associated with the column: CHGAMTBASE
	 */
	public java.math.BigDecimal getCstamtbase () {
		return _cstamtbase;
	}

	/**
	 * Set the value related to the column: CHGAMTBASE
	 * @param _cstamt the CHGAMT value
	 */
	public void setCstamtbase (java.math.BigDecimal _cstamtbase) {
		this._cstamtbase = _cstamtbase;
	}
	
	

	/**
	 * Return the value associated with the column: costkey
	 */
	public Cost getCostkey () {
		return _costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param _costkey the costkey value
	 */
	public void setCostkey (Cost _costkey) {
		this._costkey = _costkey;
	}



	/**
	 * Return the value associated with the column: UNITS
	 */
	public java.math.BigDecimal getUnits () {
		return _units;
	}

	/**
	 * Set the value related to the column: UNITS
	 * @param _units the UNITS value
	 */
	public void setUnits (java.math.BigDecimal _units) {
		this._units = _units;
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
	 * Return the value associated with the column: RATE
	 */
	public java.math.BigDecimal getRate () {
		return _rate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param _rate the RATE value
	 */
	public void setRate (java.math.BigDecimal _rate) {
		this._rate = _rate;
	}


    /**
     */
    public String getVendorname() {
    	return (this._vendorname);
    }
    /**
     */
    public void setVendorname(String _vendorname) {
        this._vendorname = _vendorname;
    }
    

    /**
     */
    public String getCostdescr() {
    	return (this._costdescr);
    }
    /**
     */
    public void setCostdescr(String _costdescr) {
        this._costdescr = _costdescr;
    }
    

	
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

