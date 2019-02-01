/*
 * $Id: OrdersummaryChargeDTO.java 12/09/2005 ntankard
 */


package com.bureaueye.beacon.model.order.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Charge;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;



/**
 */

public final class OrdersummaryChargeDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public OrdersummaryChargeDTO(Ordercharge dao) throws ApplicationException {
		initialize(dao);		
	}
	public OrdersummaryChargeDTO(Ordercharge dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	
	
	
	
	protected void initialize (Ordercharge dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this._orderchargeId = dao.getOrderchargeId();
		this._orderhdrId = dao.getOrderhdrId();	

		this._custtarfhdrId = dao.getCusttarfhdrId();
		
		this._customeraddrkey = new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getCustomeraddrkey());		
		this._chargekey = new ChargeBD(this.getSessionFactoryClusterMap()).read(dao.getChargekey());	

		this.setInvoicestatus(dao.getInvoicestatus());
		this._ccykey = dao.getCcykey();			
		this._xratebase = dao.getXratebase();
		this._chgamt = dao.getChgamt();
		try {
			this._chgamtbase = (this._chgamt.multiply(this._xratebase));
		} catch (Exception e) {
			this._chgamtbase = new BigDecimal(0);	
		}
	}
	



    // --------------------------------------------------- Instance Variables

    /**
     * The unique id.
     */
    private String _id;

	// fields
	private java.lang.Integer _orderhdrId;
	private java.lang.Integer _orderchargeId;
	
    private String _customername;     
	private Address _customeraddrkey;
	
	private java.lang.String _chargetype;
	private java.lang.String _uname;
	
	private java.lang.String _invoicestatus;
	
	private java.lang.String _custtarfhdrId;
	private java.lang.String _custtarfhdrnotes;

	private java.math.BigDecimal _xrateinv;
	private java.lang.String _invoiceccykey;
	private java.lang.String _txt1;
	private java.lang.String _txt2;
	
	private java.math.BigDecimal _chgamt;
	private java.math.BigDecimal _xratebase;	
	private java.math.BigDecimal _chgamtbase;
	private java.math.BigDecimal _chgamtbasetotal;
	
	private Charge _chargekey;
	private java.lang.String _chargedescr;
	
	private java.math.BigDecimal _units;
	private java.lang.String _ccykey;
	private java.lang.String _taxcode;
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
     *  column="ORDERCHARGE_ID"
     */
	public java.lang.Integer getOrderchargeId () {
		return _orderchargeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _orderchargeId the new ID
	 */
	public void setOrderchargeId (java.lang.Integer _orderchargeId) {
		this._orderchargeId = _orderchargeId;
	}



	/**
	 * Return the value associated with the column: XRATEINV
	 */
	public java.math.BigDecimal getXrateinv () {
		return _xrateinv;
	}

	/**
	 * Set the value related to the column: XRATEINV
	 * @param _xrateinv the XRATEINV value
	 */
	public void setXrateinv (java.math.BigDecimal _xrateinv) {
		this._xrateinv = _xrateinv;
	}


	/**
	 * Return the value associated with the column: invoicestatus
	 */
	public java.lang.String getInvoicestatus() {
		return _invoicestatus;
	}

	/**
	 * Set the value related to the column: invoicestatus
	 * @param _invoicestatus the invoicestatus value
	 */
	public void setInvoicestatus(java.lang.String _invoicestatus) {
		this._invoicestatus = _invoicestatus;
	}
	

	/**
	 * Return the value associated with the column: chargetype
	 */
	public java.lang.String getChargetype () {
		return _chargetype;
	}

	/**
	 * Set the value related to the column: chargetype
	 * @param _chargetype the chargetype value
	 */
	public void setChargetype (java.lang.String _chargetype) {
		this._chargetype = _chargetype;
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
	 * Return the value associated with the column: CUSTTARFHDR_ID
	 */
	public java.lang.String getCusttarfhdrId () {
		return _custtarfhdrId;
	}

	/**
	 * Set the value related to the column: CUSTTARFHDR_ID
	 * @param _custtarfhdrId the CUSTTARFHDR_ID value
	 */
	public void setCusttarfhdrId (java.lang.String _custtarfhdrId) {
		this._custtarfhdrId = _custtarfhdrId;
	}

	/**
	 * Return the value associated with the column: CUSTTARFHDRNOTES
	 */
	public String getCusttarfhdrnotes () {
		return _custtarfhdrnotes;
	}

	/**
	 * Set the value related to the column: CUSTTARFHDR_ID
	 * @param _custtarfhdrId the CUSTTARFHDR_ID value
	 */
	public void setCusttarfhdrnotes (String _custtarfhdrnotes) {
		this._custtarfhdrnotes = _custtarfhdrnotes;
	}
	
	

	/**
	 * Return the value associated with the column: invoiceccykey
	 */
	public java.lang.String getInvoiceccykey () {
		return _invoiceccykey;
	}

	/**
	 * Set the value related to the column: invoiceccykey
	 * @param _invoiceccykey the invoiceccykey value
	 */
	public void setInvoiceccykey (java.lang.String _invoiceccykey) {
		this._invoiceccykey = _invoiceccykey;
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
	 * Return the value associated with the column: customeraddrkey
	 */
	public Address getCustomeraddrkey () {
		return _customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param _customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (Address _customeraddrkey) {
		this._customeraddrkey = _customeraddrkey;
	}



	/**
	 * Return the value associated with the column: ORDERHDR_ID
	 */
	public java.lang.Integer getOrderhdrId () {
		return _orderhdrId;
	}

	/**
	 * Set the value related to the column: ORDERHDR_ID
	 * @param _orderhdrId the ORDERHDR_ID value
	 */
	public void setOrderhdrId (java.lang.Integer _orderhdrId) {
		this._orderhdrId = _orderhdrId;
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
	public java.math.BigDecimal getChgamt () {
		return _chgamt;
	}

	/**
	 * Set the value related to the column: CHGAMT
	 * @param _chgamt the CHGAMT value
	 */
	public void setChgamt (java.math.BigDecimal _chgamt) {
		this._chgamt = _chgamt;
	}


	/**
	 * Return the value associated with the column: CHGAMTBASE
	 */
	public java.math.BigDecimal getChgamtbase () {
		return _chgamtbase;
	}

	/**
	 * Set the value related to the column: CHGAMTBASE
	 * @param _chgamt the CHGAMT value
	 */
	public void setChgamtbase (java.math.BigDecimal _chgamtbase) {
		this._chgamtbase = _chgamtbase;
	}
	
	/**
	 * Return the value associated with the column: CHGAMTBASETOTAL
	 */
	public java.math.BigDecimal getChgamtbasetotal () {
		return _chgamtbasetotal;
	}

	/**
	 * Set the value related to the column: CHGAMTBASE
	 * @param _chgamt the CHGAMT value
	 */
	public void setChgamtbasetotal (java.math.BigDecimal _chgamtbasetotal) {
		this._chgamtbasetotal = _chgamtbasetotal;
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
	 * Return the value associated with the column: TAXCODE
	 */
	public java.lang.String getTaxcode () {
		return _taxcode;
	}

	/**
	 * Set the value related to the column: TAXCODE
	 * @param _taxcode the TAXCODE value
	 */
	public void setTaxcode (java.lang.String _taxcode) {
		this._taxcode = _taxcode;
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
    public String getChargedescr() {
    	return (this._chargedescr);
    }
    /**
     */
    public void setChargedescr(String _chargedescr) {
        this._chargedescr = _chargedescr;
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

