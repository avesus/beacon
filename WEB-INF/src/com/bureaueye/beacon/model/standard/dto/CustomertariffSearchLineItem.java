package com.bureaueye.beacon.model.standard.dto;


import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Charge;
import com.bureaueye.beacon.model.standard.Customertariffdtl;
import com.bureaueye.beacon.model.standard.Location;




/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-04		200900014		Add Customer, Ccy and charge code to return parameter list
 * 												
 *
 */

public final class CustomertariffSearchLineItem extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6690646898818856216L;


	/*[CONSTRUCTOR MARKER BEGIN]*/
	public CustomertariffSearchLineItem (
						CustomertariffhdrDTO hdr,
						Customertariffdtl dtl,
						String unittype,
						String units
						) {

		this._custtarfhdrId = hdr.getCusttarfhdrId();
		
		this._customeraddrkey = hdr.getCustomeraddrkey();
		
		this._fromlocationkey = hdr.getFromlocationkey ();
		this._fromlocationkey2 = hdr.getFromlocationkey2 ();
		this._tolocationkey2   = hdr.getTolocationkey2();
		this._tolocationkey   = hdr.getTolocationkey();
		
		this._chargekey = hdr.getChargekey();
		
		this._ccykey = hdr.getCcykey();	
		this._productkey = hdr.getProductkey();			
		this._validto = hdr.getValidto();
		//this._validfrom = hdr.getValidfrom();
		this._unittype = hdr.getUnittype();
		
		// init detail fields
		this._custtarfdtlId = new Integer(0);
		this._fromvalue = new Integer(0);
		this._tovalue = new Integer(0);
		this._unitrate = new BigDecimal(0.00);
		this._lumpsum = new BigDecimal(0.00);
			
		if (unittype.equals("LUMPSUM") || unittype.equals("PTOP")) {
			try{this._unitrate = new BigDecimal(hdr.getLumpsum());}catch(Exception e){}
			try{this._lumpsum = new BigDecimal(hdr.getLumpsum());}catch(Exception e){}
		}
		// if dtl exists then init values with tariff detail 
		if (dtl != null) {
			this._custtarfdtlId = dtl.getCusttarfdtlId();
			this._fromvalue = dtl.getFromvalue();	
			this._tovalue = dtl.getTovalue();
			this._unitrate = dtl.getUnitrate();
			try{this._lumpsum = (new BigDecimal(units).multiply(this._unitrate));}catch(Exception e){}
		}		
		this._returnParams = 
			this._custtarfhdrId+"|"+
			this._unitrate+"|"+
			this._lumpsum+"|"+
			this._customeraddrkey.getAddrkey()+"|"+//200900014
			this._chargekey.getChargekey()+"|"+//200900014
			this._ccykey//200900014
			;		
	}	

    // --------------------------------------------------- Instance Variables

    /**
     * The unique id.
     */
    private String _id;

	// fields
	private String _custtarfhdrId;
	private java.lang.Integer _custtarfdtlId;	
	    
	private Address _customeraddrkey;

	private Location _fromlocationkey;
	private Location _fromlocationkey2;	
	private Location _tolocationkey2;
	private Location _tolocationkey;

	private String _productkey;
	
	private java.lang.String _unittype;
	private java.lang.String _uname;

	private java.lang.String _txt1;
	private java.lang.String _txt2;

	private Date _validto;
	private Date _validfrom;
	
	private Charge _chargekey;
	//private java.lang.String _costdescr;
	
	private java.math.BigDecimal _units;
	private java.lang.String _ccykey;

	private java.math.BigDecimal _unitrate;
	private java.math.BigDecimal _lumpsum;

	private Integer _fromvalue;
	private Integer _tovalue;

	private String _returnParams;
	
    private boolean checked;
    
    
    // ----------------------------------------------------------- Properties


    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    
    /**
     */
    public String getReturnParams() {
    	return (this._returnParams);
    }
    /**
     */
    public void setReturnParams(String _returnParams) {
        this._returnParams = _returnParams;
    }
    

    /**
     */
    public String getProductkey() {
    	return (this._productkey);
    }
    /**
     */
    public void setProductkey(String _productkey) {
        this._productkey = _productkey;
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
     *  column=""
     */
	public String getCusttarfhdrId () {
		return _custtarfhdrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _ the new ID
	 */
	public void setCusttarfhdrId (String _custtarfhdrId) {
		this._custtarfhdrId = _custtarfhdrId;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column=""
     */
	public java.lang.Integer getCusttarfdtlId () {
		return _custtarfdtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param the new ID
	 */
	public void setCusttarfdtlId (java.lang.Integer _custtarfdtlId) {
		this._custtarfdtlId = _custtarfdtlId;
	}


	/**
	 * Return the value associated with the column: validfrom
	 */
	public java.util.Date getValidfrom () {
		return _validfrom;
	}

	/**
	 * Set the value related to the column: validfrom
	 * @param _validfrom the validfrom value
	 */
	public void setValidfrom (java.util.Date _validfrom) {
		this._validfrom = _validfrom;
	}
	
	/**
	 * Return the value associated with the column: validto
	 */
	public java.util.Date getValidto () {
		return _validto;
	}

	/**
	 * Set the value related to the column: validto
	 * @param _validto the validto value
	 */
	public void setValidto (java.util.Date _validto) {
		this._validto = _validto;
	}
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column=""
     */
	public java.lang.Integer getFromvalue () {
		return _fromvalue;
	}

	/**
	 * Set the unique identifier of this class
	 * @param the new ID
	 */
	public void setFromvalue (java.lang.Integer _fromvalue) {
		this._fromvalue = _fromvalue;
	}
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column=""
     */
	public java.lang.Integer getTovalue () {
		return _tovalue;
	}

	/**
	 * Set the unique identifier of this class
	 * @param the new ID
	 */
	public void setTovalue (java.lang.Integer _tovalue) {
		this._tovalue = _tovalue;
	}
	
	

	/**
	 * Return the value associated with the column: _unittype
	 */
	public java.lang.String getUnittype () {
		return _unittype;
	}

	/**
	 * Set the value related to the column: costtype
	 * @param __unittype the costtype value
	 */
	public void setUnittype (java.lang.String _unittype) {
		this._unittype = _unittype;
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
	 * Return the value associated with the column: custoraddrkey
	 */
	public Address getCustomeraddrkey () {
		return _customeraddrkey;
	}

	/**
	 * Set the value related to the column: custoraddrkey
	 * @param _custoraddrkey the custoraddrkey value
	 */
	public void setCustomeraddrkey (Address _customeraddrkey) {
		this._customeraddrkey = _customeraddrkey;
	}


	/**
	 * Return the value associated with the column: locationkey
	 */
	public Location getFromlocationkey() {
		return _fromlocationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param _locationkey the locationkey value
	 */
	public void setFromlocationkey (Location _fromlocationkey) {
		this._fromlocationkey = _fromlocationkey;
	}

	/**
	 * Return the value associated with the column: locationkey
	 */
	public Location getFromlocationkey2() {
		return _fromlocationkey2;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param _locationkey the locationkey value
	 */
	public void setFromlocationkey2 (Location _fromlocationkey2) {
		this._fromlocationkey2 = _fromlocationkey2;
	}
	
	/**
	 * Return the value associated with the column: locationkey
	 */
	public Location getTolocationkey2() {
		return _tolocationkey2;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param _locationkey the locationkey value
	 */
	public void setTolocationkey2 (Location _tolocationkey2) {
		this._tolocationkey2 = _tolocationkey2;
	}
	
	/**
	 * Return the value associated with the column: locationkey
	 */
	public Location getTolocationkey() {
		return _tolocationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param _locationkey the locationkey value
	 */
	public void setTolocationkey (Location _tolocationkey) {
		this._tolocationkey = _tolocationkey;
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
	 * Return the value associated with the column: chargekey
	 */
	public Charge getChargekey () {
		return _chargekey;
	}

	/**
	 * Set the value related to the column: chargekey
	 * @param _chargekey the chargekey value
	 */
	public void setChargekey (Charge _chargekey) {
		this._chargekey = _chargekey;
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
	public java.math.BigDecimal getUnitrate () {
		return _unitrate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param _rate the RATE value
	 */
	public void setUnitrate (java.math.BigDecimal _unitrate) {
		this._unitrate = _unitrate;
	}


	/**
	 * Return the value associated with the column: RATE
	 */
	public java.math.BigDecimal getLumpsum () {
		return _lumpsum;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param _rate the RATE value
	 */
	public void setLumpsum(java.math.BigDecimal _lumpsum) {
		this._lumpsum = _lumpsum;
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

