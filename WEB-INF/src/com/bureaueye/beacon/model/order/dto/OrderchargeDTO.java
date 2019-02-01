package com.bureaueye.beacon.model.order.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Charge;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;





public final class OrderchargeDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public OrderchargeDTO(Ordercharge dao) throws ApplicationException {
		initialize(dao);		
	}
	public OrderchargeDTO(Ordercharge dao, SessionFactory _factory) throws ApplicationException {
		super(_factory);
		initialize(dao);
	}
	public OrderchargeDTO(Ordercharge dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	
	protected void initialize (Ordercharge dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setCustomeraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getCustomeraddrkey()));
		this.setChargekey(new ChargeBD(this.getSessionFactoryClusterMap()).read(dao.getChargekey()));
		this.setChargetype(dao.getChargetype());
		this.setCcykey(dao.getCcykey());
		this.setChgamt(dao.getChgamt());
		this.setTxt1(dao.getTxt1());
		this.setOrderchargeId(dao.getOrderchargeId());
		this.setOrderhdrId(dao.getOrderhdrId());
		this.setInvoicestatus(dao.getInvoicestatus());
		this.setCusttarfhdrId(dao.getCusttarfhdrId());
		this.setXratebase(dao.getXratebase());
		this.setXrateinv(dao.getXrateinv());
	}
	


	// primary key
	private java.lang.Integer orderchargeId;

	// fields
	private java.math.BigDecimal xrateinv;
	private boolean deleted;
	private java.lang.String invoicestatus;
	private java.lang.String invoicepref;
	private java.lang.String tariffkey;
	private java.lang.String departmentkey;
	private java.lang.String chargetype;
	private java.lang.String uname;
	private java.lang.String custtarfhdrId;
	private boolean dmrgflag;
	private java.lang.String invoiceccykey;
	private java.lang.String companykey;
	private java.math.BigDecimal xratebase;
	private java.lang.String txt1;
	private boolean maincharge;
	private java.lang.String createuserid;
	private java.lang.Integer orderhdrId;
	private java.lang.String txt2;
	private java.math.BigDecimal chgamt;
	private java.lang.String invoicegroupref;
	private java.lang.String activitykey;
	private java.math.BigDecimal units;
	private java.lang.String ccykey;
	private java.lang.String taxcode;
	private java.math.BigDecimal rate;
	private Address customeraddrkey;
	private Charge chargekey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ORDERCHARGE_ID"
     */
	public java.lang.Integer getOrderchargeId () {
		return orderchargeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param orderchargeId the new ID
	 */
	public void setOrderchargeId (java.lang.Integer orderchargeId) {
		this.orderchargeId = orderchargeId;
	}











	/**
	 * Return the value associated with the column: XRATEINV
	 */
	public java.math.BigDecimal getXrateinv () {
		return xrateinv;
	}

	/**
	 * Set the value related to the column: XRATEINV
	 * @param xrateinv the XRATEINV value
	 */
	public void setXrateinv (java.math.BigDecimal xrateinv) {
		this.xrateinv = xrateinv;
	}



	/**
	 * Return the value associated with the column: DELETED
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: DELETED
	 * @param deleted the DELETED value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: invoicepref
	 */
	public java.lang.String getInvoicepref () {
		return invoicepref;
	}

	/**
	 * Set the value related to the column: invoicepref
	 * @param invoicepref the invoicepref value
	 */
	public void setInvoicepref (java.lang.String invoicepref) {
		this.invoicepref = invoicepref;
	}



	/**
	 * Return the value associated with the column: TARIFFKEY
	 */
	public java.lang.String getTariffkey () {
		return tariffkey;
	}

	/**
	 * Set the value related to the column: TARIFFKEY
	 * @param tariffkey the TARIFFKEY value
	 */
	public void setTariffkey (java.lang.String tariffkey) {
		this.tariffkey = tariffkey;
	}



	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String departmentkey) {
		this.departmentkey = departmentkey;
	}



	/**
	 * Return the value associated with the column: chargetype
	 */
	public java.lang.String getChargetype () {
		return chargetype;
	}

	/**
	 * Set the value related to the column: chargetype
	 * @param chargetype the chargetype value
	 */
	public void setChargetype (java.lang.String chargetype) {
		this.chargetype = chargetype;
	}





	/**
	 * Return the value associated with the column: UNAME
	 */
	public java.lang.String getUname () {
		return uname;
	}

	/**
	 * Set the value related to the column: UNAME
	 * @param uname the UNAME value
	 */
	public void setUname (java.lang.String uname) {
		this.uname = uname;
	}



	/**
	 * Return the value associated with the column: CUSTTARFHDR_ID
	 */
	public java.lang.String getCusttarfhdrId () {
		return custtarfhdrId;
	}

	/**
	 * Set the value related to the column: CUSTTARFHDR_ID
	 * @param custtarfhdrId the CUSTTARFHDR_ID value
	 */
	public void setCusttarfhdrId (java.lang.String custtarfhdrId) {
		this.custtarfhdrId = custtarfhdrId;
	}



	/**
	 * Return the value associated with the column: DMRGFLAG
	 */
	public boolean isDmrgflag () {
		return dmrgflag;
	}

	/**
	 * Set the value related to the column: DMRGFLAG
	 * @param dmrgflag the DMRGFLAG value
	 */
	public void setDmrgflag (boolean dmrgflag) {
		this.dmrgflag = dmrgflag;
	}



	/**
	 * Return the value associated with the column: invoiceccykey
	 */
	public java.lang.String getInvoiceccykey () {
		return invoiceccykey;
	}

	/**
	 * Set the value related to the column: invoiceccykey
	 * @param invoiceccykey the invoiceccykey value
	 */
	public void setInvoiceccykey (java.lang.String invoiceccykey) {
		this.invoiceccykey = invoiceccykey;
	}



	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param companykey the companykey value
	 */
	public void setCompanykey (java.lang.String companykey) {
		this.companykey = companykey;
	}





	/**
	 * Return the value associated with the column: XRATEBASE
	 */
	public java.math.BigDecimal getXratebase () {
		return xratebase;
	}

	/**
	 * Set the value related to the column: XRATEBASE
	 * @param xratebase the XRATEBASE value
	 */
	public void setXratebase (java.math.BigDecimal xratebase) {
		this.xratebase = xratebase;
	}



	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1 () {
		return txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * @param txt1 the txt1 value
	 */
	public void setTxt1 (java.lang.String txt1) {
		this.txt1 = txt1;
	}



	/**
	 * Return the value associated with the column: MAINCHARGE
	 */
	public boolean isMaincharge () {
		return maincharge;
	}

	/**
	 * Set the value related to the column: MAINCHARGE
	 * @param maincharge the MAINCHARGE value
	 */
	public void setMaincharge (boolean maincharge) {
		this.maincharge = maincharge;
	}



	/**
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: CREATEUSERID
	 * @param createuserid the CREATEUSERID value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
	}



	/**
	 * Return the value associated with the column: ORDERHDR_ID
	 */
	public java.lang.Integer getOrderhdrId () {
		return orderhdrId;
	}

	/**
	 * Set the value related to the column: ORDERHDR_ID
	 * @param orderhdrId the ORDERHDR_ID value
	 */
	public void setOrderhdrId (java.lang.Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}



	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2 () {
		return txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * @param txt2 the txt2 value
	 */
	public void setTxt2 (java.lang.String txt2) {
		this.txt2 = txt2;
	}






	/**
	 * Return the value associated with the column: CHGAMT
	 */
	public java.math.BigDecimal getChgamt () {
		return chgamt;
	}

	/**
	 * Set the value related to the column: CHGAMT
	 * @param chgamt the CHGAMT value
	 */
	public void setChgamt (java.math.BigDecimal chgamt) {
		this.chgamt = chgamt;
	}









	/**
	 * Return the value associated with the column: INVOICEGROUPREF
	 */
	public java.lang.String getInvoicegroupref () {
		return invoicegroupref;
	}

	/**
	 * Set the value related to the column: INVOICEGROUPREF
	 * @param invoicegroupref the INVOICEGROUPREF value
	 */
	public void setInvoicegroupref (java.lang.String invoicegroupref) {
		this.invoicegroupref = invoicegroupref;
	}



	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String activitykey) {
		this.activitykey = activitykey;
	}



	/**
	 * Return the value associated with the column: UNITS
	 */
	public java.math.BigDecimal getUnits () {
		return units;
	}

	/**
	 * Set the value related to the column: UNITS
	 * @param units the UNITS value
	 */
	public void setUnits (java.math.BigDecimal units) {
		this.units = units;
	}



	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
	}



	/**
	 * Return the value associated with the column: TAXCODE
	 */
	public java.lang.String getTaxcode () {
		return taxcode;
	}

	/**
	 * Set the value related to the column: TAXCODE
	 * @param taxcode the TAXCODE value
	 */
	public void setTaxcode (java.lang.String taxcode) {
		this.taxcode = taxcode;
	}






	/**
	 * Return the value associated with the column: RATE
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param rate the RATE value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
	}



	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public Address getCustomeraddrkey () {
		return customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (Address customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}



	/**
	 * Return the value associated with the column: chargekey
	 */
	public Charge getChargekey () {
		return chargekey;
	}

	/**
	 * Set the value related to the column: chargekey
	 * @param chargekey the chargekey value
	 */
	public void setChargekey (Charge chargekey) {
		this.chargekey = chargekey;
	}

	/**
	 * Return the value associated with the column: invoicestatus
	 */
	public java.lang.String getInvoicestatus() {
		return invoicestatus;
	}

	/**
	 * Set the value related to the column: invoicestatus
	 * @param _invoicestatus the invoicestatus value
	 */
	public void setInvoicestatus(java.lang.String invoicestatus) {
		this.invoicestatus = invoicestatus;
	}
	
	
	
}
