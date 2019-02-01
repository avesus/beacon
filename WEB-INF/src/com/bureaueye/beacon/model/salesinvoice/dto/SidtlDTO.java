package com.bureaueye.beacon.model.salesinvoice.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Charge;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2013-12-01 WSI-201312-0001 BEACON LAKER (WSI LINER) - Sales Report (changes not commented)
 * 
 */
public final class SidtlDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// constructors
	public SidtlDTO() throws ApplicationException {
	}

	public SidtlDTO(Sidtl dao) throws ApplicationException {
		initialize(dao);
	}

	public SidtlDTO(Sidtl dao, Map<String, SessionFactory> sfcm)
			throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	protected void initialize(Sidtl dao) throws ApplicationException {

		// populate data-transfer-object from data-access-object
		this.setSihdrId(dao.getSihdrId());
		this.setSidtlId(dao.getSidtlId());
		this.setOrderhdrId(dao.getOrderhdrId());

		this.setChargetype(dao.getChargetype());
		this.setUnits(dao.getUnits());
		this.setRate(dao.getRate());
		this.setChgamt(dao.getChgamt());
		this.setInvoiceccykey(dao.getInvoiceccykey());
		this.setUname(dao.getUname());
		this.setTxt1(dao.getTxt1());

		ChargeBD chargebd = new ChargeBD(this.getSessionFactoryClusterMap());
		this.setChargekey(chargebd.read(dao.getChargekey()));
		chargebd = null;

	}

	public SidtlDTO(BigDecimal _invoiceamt, String _txt1, String _chargekey,
			Integer _sidtlId, Integer _sihdrId, String _customeraddrkey,
			String _invoiceccykey, String _invoiceno, String _baseccykey,
			String _orderno) {

		this.invoiceamt = _invoiceamt;
		this.invoiceno = _invoiceno;
		this.orderno = _orderno;
		this.txt1 = _txt1;
		this.chargekey2 = _chargekey;
		this.customeraddrkey2 = _customeraddrkey;

		this.invoiceccykey = _invoiceccykey;
		this.baseccykey = _baseccykey;

		this.sidtlId = _sidtlId;
		this.sihdrId = _sihdrId;

		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		ChargeBD chargebd = new ChargeBD(this.getSessionFactoryClusterMap());
		try {
			this.setChargekey(chargebd.read(_chargekey));
		} catch (Exception e) {
		}
		try {
			this.setCustomeraddrkey(addressbd.read(_customeraddrkey));
		} catch (Exception e) {
		}
		addressbd = null;
		chargebd = null;

		// exrate lookup
		CcyexBD ccyexbd = new CcyexBD(this.getSessionFactoryClusterMap());
		ListForm ccyexListForm = new ListForm();
		ccyexListForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
		ccyexListForm.setGotoPage(0);
		ccyexListForm.setSearchDate1(new Date());
		ccyexListForm.setOrderBy("Exdate");
		ccyexListForm.setOrderByDesc("Desc");
		// to base ccy
		ccyexListForm.setSearchString2(_baseccykey);
		this.baseexrate = new BigDecimal(1);
		this.invoiceamtbase = _invoiceamt;
		try {
			ccyexListForm.setSearchString1(_invoiceccykey);// from ccy
			this.baseexrate = new BigDecimal(ccyexbd.getExrate(ccyexListForm));
			this.invoiceamtbase = (_invoiceamt.multiply(this.baseexrate));
		} catch (Exception ae) {
		}
		ccyexbd = null;

	}

	
	
	public SidtlDTO(
			BigDecimal _invoiceamt, 
			String _txt1, 
			String _chargekey,
			Integer _sidtlId, 
			Integer _sihdrId, 
			String _customeraddrkey,
			String _invoiceccykey, 
			String _invoiceno,
			String _sihdradddata3, 
			String _sihdradddata4,
			String _adddata2, 
			String _adddata6, 
			String _adddata3,
			String _adddata4, 
			String _companykey,
			Date _printdate
			) {

		this.invoiceamt = _invoiceamt;
		this.invoiceno = _invoiceno;
		this.orderno = "";
		this.txt1 = _txt1;
		this.chargekey2 = _chargekey;
		this.customeraddrkey2 = _customeraddrkey;
		this.printdate= _printdate;
		
		this.invoiceccykey = _invoiceccykey;
		this.baseccykey = "";

		this.sidtlId = _sidtlId;
		this.sihdrId = _sihdrId;

		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		ChargeBD chargebd = new ChargeBD(this.getSessionFactoryClusterMap());
		try {
			this.setChargekey(chargebd.read(_chargekey));
		} catch (Exception e) {
		}
		try {
			this.setCustomeraddrkey(addressbd.read(_customeraddrkey));
		} catch (Exception e) {
		}
		addressbd = null;
		chargebd = null;

		this.baseexrate = new BigDecimal(1);
		this.invoiceamtbase = _invoiceamt;

		this.sihdradddata3=_sihdradddata3; 
		this.sihdradddata4=_sihdradddata4;
		this.adddata2= _adddata2; 
		this.adddata6= _adddata6; 
		this.adddata3= _adddata3;
		this.adddata4= _adddata4; 
		this.companykey= _companykey;	
		
	}


	
	
	
	// primary key
	private java.lang.Integer sidtlId;

	// fields
	private java.lang.String invoiceno;
	private java.math.BigDecimal chgamt;
	private boolean mainchargeflag;
	private java.math.BigDecimal units;
	private java.util.Date sapbookdate;
	private java.lang.Integer sihdrId;
	private java.lang.String chargetype;
	private java.lang.Integer demurragedays;
	private java.lang.String unitkey;
	private java.math.BigDecimal rate;
	private java.lang.String invoicegroupref;
	private java.math.BigDecimal xrateinv;
	private java.lang.String invoiceref;
	private boolean printedflag;
	private java.lang.String sapbookperiod;
	private boolean deleteflag;
	private java.lang.String txt1;
	private java.math.BigDecimal xratebase;
	private java.util.Date printdate;
	private java.lang.String uname;
	private java.lang.String txt2;
	private java.lang.String printtime;
	private java.lang.String ccykey;
	private java.lang.String orderno;

	private java.lang.String invoiceccykey;
	private java.lang.String baseccykey;

	private java.math.BigDecimal invoiceamt;
	private java.math.BigDecimal invoiceamtbase;
	private java.math.BigDecimal baseexrate;

	private java.lang.Integer orderhdrId;
	private java.lang.Integer orderchargeId;

	private Charge chargekey;
	private String chargekey2;

	private Address customeraddrkey;
	private String customeraddrkey2;

	private java.lang.String sihdradddata1;
	private java.lang.String sihdradddata2;
	private java.lang.String sihdradddata3;
	private java.lang.String sihdradddata4;
	private java.lang.String sihdradddata5;
	private java.lang.String sihdradddata6;
	private java.lang.String sihdradddata7;
	private java.lang.String sihdradddata8;
	private java.lang.String sihdradddata9;
	private java.lang.String sihdradddata10;
	
	private java.lang.String adddata1;
	private java.lang.String adddata2;
	private java.lang.String adddata3;
	private java.lang.String adddata4;
	private java.lang.String adddata5;
	private java.lang.String adddata6;
	private java.lang.String adddata7;
	private java.lang.String adddata8;
	private java.lang.String adddata9;
	private java.lang.String adddata10;
	
	private java.lang.String companykey;
	private java.lang.String departmentkey;
	private java.lang.String activitykey;
	
	
	
	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="SIDTL_ID"
	 */
	public java.lang.Integer getSidtlId() {
		return sidtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param sidtlId
	 *            the new ID
	 */
	public void setSidtlId(java.lang.Integer sidtlId) {
		this.sidtlId = sidtlId;
	}

	/**
	 * Return the value associated with the column: chgamt
	 */
	public java.math.BigDecimal getChgamt() {
		return chgamt;
	}

	/**
	 * Set the value related to the column: chgamt
	 * 
	 * @param chgamt
	 *            the chgamt value
	 */
	public void setChgamt(java.math.BigDecimal chgamt) {
		this.chgamt = chgamt;
	}

	/**
	 * Return the value associated with the column: mainchargeflag
	 */
	public boolean isMainchargeflag() {
		return mainchargeflag;
	}

	/**
	 * Set the value related to the column: mainchargeflag
	 * 
	 * @param mainchargeflag
	 *            the mainchargeflag value
	 */
	public void setMainchargeflag(boolean mainchargeflag) {
		this.mainchargeflag = mainchargeflag;
	}

	/**
	 * Return the value associated with the column: units
	 */
	public java.math.BigDecimal getUnits() {
		return units;
	}

	/**
	 * Set the value related to the column: units
	 * 
	 * @param units
	 *            the units value
	 */
	public void setUnits(java.math.BigDecimal units) {
		this.units = units;
	}

	/**
	 * Return the value associated with the column: sapbookdate
	 */
	public java.util.Date getSapbookdate() {
		return sapbookdate;
	}

	/**
	 * Set the value related to the column: sapbookdate
	 * 
	 * @param sapbookdate
	 *            the sapbookdate value
	 */
	public void setSapbookdate(java.util.Date sapbookdate) {
		this.sapbookdate = sapbookdate;
	}

	/**
	 * Return the value associated with the column: SIHDR_ID
	 */
	public java.lang.Integer getSihdrId() {
		return sihdrId;
	}

	/**
	 * Set the value related to the column: SIHDR_ID
	 * 
	 * @param sihdrId
	 *            the SIHDR_ID value
	 */
	public void setSihdrId(java.lang.Integer sihdrId) {
		this.sihdrId = sihdrId;
	}

	/**
	 * Return the value associated with the column: chargetype
	 */
	public java.lang.String getChargetype() {
		return chargetype;
	}

	/**
	 * Set the value related to the column: chargetype
	 * 
	 * @param chargetype
	 *            the chargetype value
	 */
	public void setChargetype(java.lang.String chargetype) {
		this.chargetype = chargetype;
	}

	/**
	 * Return the value associated with the column: demurragedays
	 */
	public java.lang.Integer getDemurragedays() {
		return demurragedays;
	}

	/**
	 * Set the value related to the column: demurragedays
	 * 
	 * @param demurragedays
	 *            the demurragedays value
	 */
	public void setDemurragedays(java.lang.Integer demurragedays) {
		this.demurragedays = demurragedays;
	}

	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey() {
		return unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * 
	 * @param unitkey
	 *            the unitkey value
	 */
	public void setUnitkey(java.lang.String unitkey) {
		this.unitkey = unitkey;
	}

	/**
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate() {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * 
	 * @param rate
	 *            the rate value
	 */
	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * Return the value associated with the column: invoicegroupref
	 */
	public java.lang.String getInvoicegroupref() {
		return invoicegroupref;
	}

	/**
	 * Set the value related to the column: invoicegroupref
	 * 
	 * @param invoicegroupref
	 *            the invoicegroupref value
	 */
	public void setInvoicegroupref(java.lang.String invoicegroupref) {
		this.invoicegroupref = invoicegroupref;
	}

	/**
	 * Return the value associated with the column: xrateinv
	 */
	public java.math.BigDecimal getXrateinv() {
		return xrateinv;
	}

	/**
	 * Set the value related to the column: xrateinv
	 * 
	 * @param xrateinv
	 *            the xrateinv value
	 */
	public void setXrateinv(java.math.BigDecimal xrateinv) {
		this.xrateinv = xrateinv;
	}

	/**
	 * Return the value associated with the column: invoiceref
	 */
	public java.lang.String getInvoiceref() {
		return invoiceref;
	}

	/**
	 * Set the value related to the column: invoiceref
	 * 
	 * @param invoiceref
	 *            the invoiceref value
	 */
	public void setInvoiceref(java.lang.String invoiceref) {
		this.invoiceref = invoiceref;
	}

	/**
	 * Return the value associated with the column: printedflag
	 */
	public boolean isPrintedflag() {
		return printedflag;
	}

	/**
	 * Set the value related to the column: printedflag
	 * 
	 * @param printedflag
	 *            the printedflag value
	 */
	public void setPrintedflag(boolean printedflag) {
		this.printedflag = printedflag;
	}

	/**
	 * Return the value associated with the column: sapbookperiod
	 */
	public java.lang.String getSapbookperiod() {
		return sapbookperiod;
	}

	/**
	 * Set the value related to the column: sapbookperiod
	 * 
	 * @param sapbookperiod
	 *            the sapbookperiod value
	 */
	public void setSapbookperiod(java.lang.String sapbookperiod) {
		this.sapbookperiod = sapbookperiod;
	}

	/**
	 * Return the value associated with the column: deleteflag
	 */
	public boolean isDeleteflag() {
		return deleteflag;
	}

	/**
	 * Set the value related to the column: deleteflag
	 * 
	 * @param deleteflag
	 *            the deleteflag value
	 */
	public void setDeleteflag(boolean deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1() {
		return txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * 
	 * @param txt1
	 *            the txt1 value
	 */
	public void setTxt1(java.lang.String txt1) {
		this.txt1 = txt1;
	}

	/**
	 * Return the value associated with the column: xratebase
	 */
	public java.math.BigDecimal getXratebase() {
		return xratebase;
	}

	/**
	 * Set the value related to the column: xratebase
	 * 
	 * @param xratebase
	 *            the xratebase value
	 */
	public void setXratebase(java.math.BigDecimal xratebase) {
		this.xratebase = xratebase;
	}

	/**
	 * Return the value associated with the column: printdate
	 */
	public java.util.Date getPrintdate() {
		return printdate;
	}

	/**
	 * Set the value related to the column: printdate
	 * 
	 * @param printdate
	 *            the printdate value
	 */
	public void setPrintdate(java.util.Date printdate) {
		this.printdate = printdate;
	}

	/**
	 * Return the value associated with the column: uname
	 */
	public java.lang.String getUname() {
		return uname;
	}

	/**
	 * Set the value related to the column: uname
	 * 
	 * @param uname
	 *            the uname value
	 */
	public void setUname(java.lang.String uname) {
		this.uname = uname;
	}

	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2() {
		return txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * 
	 * @param txt2
	 *            the txt2 value
	 */
	public void setTxt2(java.lang.String txt2) {
		this.txt2 = txt2;
	}

	/**
	 * Return the value associated with the column: printtime
	 */
	public java.lang.String getPrinttime() {
		return printtime;
	}

	/**
	 * Set the value related to the column: printtime
	 * 
	 * @param printtime
	 *            the printtime value
	 */
	public void setPrinttime(java.lang.String printtime) {
		this.printtime = printtime;
	}

	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey() {
		return ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * 
	 * @param ccykey
	 *            the ccykey value
	 */
	public void setCcykey(java.lang.String ccykey) {
		this.ccykey = ccykey;
	}

	/**
	 * Return the value associated with the column: orderno
	 */
	public java.lang.String getOrderno() {
		return orderno;
	}

	/**
	 * Set the value related to the column: orderno
	 * 
	 * @param orderno
	 *            the orderno value
	 */
	public void setOrderno(java.lang.String orderno) {
		this.orderno = orderno;
	}

	public java.lang.String getInvoiceccykey() {
		return invoiceccykey;
	}

	public void setInvoiceccykey(java.lang.String invoiceccykey) {
		this.invoiceccykey = invoiceccykey;
	}

	public java.lang.String getBaseccykey() {
		return baseccykey;
	}

	public void setBaseccykey(java.lang.String baseccykey) {
		this.baseccykey = baseccykey;
	}

	public java.math.BigDecimal getInvoiceamt() {
		return invoiceamt;
	}

	public void setInvoiceamt(java.math.BigDecimal invoiceamt) {
		this.invoiceamt = invoiceamt;
	}

	public java.math.BigDecimal getInvoiceamtbase() {
		return invoiceamtbase;
	}

	public void setInvoiceamtbase(java.math.BigDecimal invoiceamtbase) {
		this.invoiceamtbase = invoiceamtbase;
	}

	public java.math.BigDecimal getBaseexrate() {
		return baseexrate;
	}

	public void setBaserate(java.math.BigDecimal baseexrate) {
		this.baseexrate = baseexrate;
	}

	/**
	 * Return the value associated with the column: ORDERHDR_ID
	 */
	public java.lang.Integer getOrderhdrId() {
		return orderhdrId;
	}

	/**
	 * Set the value related to the column: ORDERHDR_ID
	 * 
	 * @param orderhdrId
	 *            the ORDERHDR_ID value
	 */
	public void setOrderhdrId(java.lang.Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}

	/**
	 * Return the value associated with the column: ORDERCHARGE_ID
	 */
	public java.lang.Integer getOrderchargeId() {
		return orderchargeId;
	}

	/**
	 * Set the value related to the column: ORDERCHARGE_ID
	 * 
	 * @param orderchargeId
	 *            the ORDERCHARGE_ID value
	 */
	public void setOrderchargeId(java.lang.Integer orderchargeId) {
		this.orderchargeId = orderchargeId;
	}

	public Charge getChargekey() {
		return chargekey;
	}

	public void setChargekey(Charge chargekey) {
		this.chargekey = chargekey;
	}

	public String getChargekey2() {
		return chargekey2;
	}

	public void setChargekey2(String chargekey2) {
		this.chargekey2 = chargekey2;
	}

	public Address getCustomeraddrkey() {
		return customeraddrkey;
	}

	public void setCustomeraddrkey(Address customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}

	public String getCustomeraddrkey2() {
		return customeraddrkey2;
	}

	public void setCustomeraddrkey2(String customeraddrkey2) {
		this.customeraddrkey2 = customeraddrkey2;
	}

	public java.lang.String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(java.lang.String invoiceno) {
		this.invoiceno = invoiceno;
	}

	
	
	/**
	 * Return the value associated with the column: adddata1
	 */
	public java.lang.String getAdddata1 () {
		return adddata1;
	}

	/**
	 * Set the value related to the column: adddata1
	 * @param adddata1 the adddata1 value
	 */
	public void setAdddata1 (java.lang.String adddata1) {
		this.adddata1 = adddata1;
	}



	/**
	 * Return the value associated with the column: adddata2
	 */
	public java.lang.String getAdddata2 () {
		return adddata2;
	}

	/**
	 * Set the value related to the column: adddata2
	 * @param adddata2 the adddata2 value
	 */
	public void setAdddata2 (java.lang.String adddata2) {
		this.adddata2 = adddata2;
	}



	/**
	 * Return the value associated with the column: adddata3
	 */
	public java.lang.String getAdddata3 () {
		return adddata3;
	}

	/**
	 * Set the value related to the column: adddata3
	 * @param adddata3 the adddata3 value
	 */
	public void setAdddata3 (java.lang.String adddata3) {
		this.adddata3 = adddata3;
	}



	/**
	 * Return the value associated with the column: adddata4
	 */
	public java.lang.String getAdddata4 () {
		return adddata4;
	}

	/**
	 * Set the value related to the column: adddata4
	 * @param adddata4 the adddata4 value
	 */
	public void setAdddata4 (java.lang.String adddata4) {
		this.adddata4 = adddata4;
	}



	/**
	 * Return the value associated with the column: adddata5
	 */
	public java.lang.String getAdddata5 () {
		return adddata5;
	}

	/**
	 * Set the value related to the column: adddata5
	 * @param adddata5 the adddata5 value
	 */
	public void setAdddata5 (java.lang.String adddata5) {
		this.adddata5 = adddata5;
	}



	/**
	 * Return the value associated with the column: adddata6
	 */
	public java.lang.String getAdddata6 () {
		return adddata6;
	}

	/**
	 * Set the value related to the column: adddata6
	 * @param adddata6 the adddata6 value
	 */
	public void setAdddata6 (java.lang.String adddata6) {
		this.adddata6 = adddata6;
	}



	/**
	 * Return the value associated with the column: adddata7
	 */
	public java.lang.String getAdddata7 () {
		return adddata7;
	}

	/**
	 * Set the value related to the column: adddata7
	 * @param adddata7 the adddata7 value
	 */
	public void setAdddata7 (java.lang.String adddata7) {
		this.adddata7 = adddata7;
	}



	/**
	 * Return the value associated with the column: adddata8
	 */
	public java.lang.String getAdddata8 () {
		return adddata8;
	}

	/**
	 * Set the value related to the column: adddata8
	 * @param adddata8 the adddata8 value
	 */
	public void setAdddata8 (java.lang.String adddata8) {
		this.adddata8 = adddata8;
	}



	/**
	 * Return the value associated with the column: adddata9
	 */
	public java.lang.String getAdddata9 () {
		return adddata9;
	}

	/**
	 * Set the value related to the column: adddata9
	 * @param adddata9 the adddata9 value
	 */
	public void setAdddata9 (java.lang.String adddata9) {
		this.adddata9 = adddata9;
	}



	/**
	 * Return the value associated with the column: adddata10
	 */
	public java.lang.String getAdddata10 () {
		return adddata10;
	}

	/**
	 * Set the value related to the column: adddata10
	 * @param adddata10 the adddata10 value
	 */
	public void setAdddata10 (java.lang.String adddata10) {
		this.adddata10 = adddata10;
	}



	
	/**
	 * Return the value associated with the column: adddata1
	 */
	public java.lang.String getSihdradddata1 () {
		return sihdradddata1;
	}

	/**
	 * Set the value related to the column: adddata1
	 * @param adddata1 the adddata1 value
	 */
	public void setSihdradddata1 (java.lang.String adddata1) {
		this.sihdradddata1 = adddata1;
	}



	/**
	 * Return the value associated with the column: adddata2
	 */
	public java.lang.String getSihdradddata2 () {
		return sihdradddata2;
	}

	/**
	 * Set the value related to the column: adddata2
	 * @param adddata2 the adddata2 value
	 */
	public void setSihdradddata2 (java.lang.String adddata2) {
		this.sihdradddata2 = adddata2;
	}



	/**
	 * Return the value associated with the column: adddata3
	 */
	public java.lang.String getSihdradddata3 () {
		return sihdradddata3;
	}

	/**
	 * Set the value related to the column: adddata3
	 * @param adddata3 the adddata3 value
	 */
	public void setSihdradddata3 (java.lang.String adddata3) {
		this.sihdradddata3 = adddata3;
	}



	/**
	 * Return the value associated with the column: adddata4
	 */
	public java.lang.String getSihdradddata4 () {
		return sihdradddata4;
	}

	/**
	 * Set the value related to the column: adddata4
	 * @param adddata4 the adddata4 value
	 */
	public void setSihdradddata4 (java.lang.String adddata4) {
		this.sihdradddata4 = adddata4;
	}



	/**
	 * Return the value associated with the column: adddata5
	 */
	public java.lang.String getSihdradddata5 () {
		return sihdradddata5;
	}

	/**
	 * Set the value related to the column: adddata5
	 * @param adddata5 the adddata5 value
	 */
	public void setSihdradddata5 (java.lang.String adddata5) {
		this.sihdradddata5 = adddata5;
	}



	/**
	 * Return the value associated with the column: adddata6
	 */
	public java.lang.String getSihdradddata6 () {
		return sihdradddata6;
	}

	/**
	 * Set the value related to the column: adddata6
	 * @param adddata6 the adddata6 value
	 */
	public void setSihdradddata6 (java.lang.String adddata6) {
		this.sihdradddata6 = adddata6;
	}



	/**
	 * Return the value associated with the column: adddata7
	 */
	public java.lang.String getSihdradddata7 () {
		return sihdradddata7;
	}

	/**
	 * Set the value related to the column: adddata7
	 * @param adddata7 the adddata7 value
	 */
	public void setSihdradddata7 (java.lang.String adddata7) {
		this.sihdradddata7 = adddata7;
	}



	/**
	 * Return the value associated with the column: adddata8
	 */
	public java.lang.String getSihdradddata8 () {
		return sihdradddata8;
	}

	/**
	 * Set the value related to the column: adddata8
	 * @param adddata8 the adddata8 value
	 */
	public void setSihdradddata8 (java.lang.String adddata8) {
		this.sihdradddata8 = adddata8;
	}



	/**
	 * Return the value associated with the column: adddata9
	 */
	public java.lang.String getSihdradddata9 () {
		return sihdradddata9;
	}

	/**
	 * Set the value related to the column: adddata9
	 * @param adddata9 the adddata9 value
	 */
	public void setSihdradddata9 (java.lang.String adddata9) {
		this.sihdradddata9 = adddata9;
	}



	/**
	 * Return the value associated with the column: adddata10
	 */
	public java.lang.String getSihdradddata10 () {
		return sihdradddata10;
	}

	/**
	 * Set the value related to the column: adddata10
	 * @param adddata10 the adddata10 value
	 */
	public void setSihdradddata10 (java.lang.String adddata10) {
		this.sihdradddata10 = adddata10;
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
	
	
	
	
	
}
