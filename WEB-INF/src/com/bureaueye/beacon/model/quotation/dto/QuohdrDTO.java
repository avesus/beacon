package com.bureaueye.beacon.model.quotation.dto;
 
import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.bd.QuofileBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuonoteBD;
import com.bureaueye.beacon.model.quotation.bd.QuonotecustBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;

/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-05-31		ITT-200905-0003		Add Logistic Location details to Quohdr List
 * 
 * NT	2009-10-12		200900045			Add GP% and Department to Quotation List Report
 * 												
 * NT	2009-12-10		200900058			Use Quotno to find Order headers
 *
 * NT	2011-03-01		ITT-201103-0002		Quotation Matrix Report 
 *
 */

public final class QuohdrDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public QuohdrDTO(Quohdr dao) throws ApplicationException {
		initialize(dao);		
	}
	public QuohdrDTO(Quohdr dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Quohdr dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		
/*		Address customer = new Address();
		customer = new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getCustomeraddrkey());
		if (customer == null) {
			customer = new Address();
			customer.setName(dao.getCustomername());
		}*/
		Address customer = new Address();
		customer.setName(dao.getCustomername());
		this.setCustomeraddrkey(customer);
		this.setCustomername(dao.getCustomername());
		
		this.setId(dao.getId());
		this.setQuotno(dao.getQuotno());
		this.setExpirydate(dao.getExpirydate());
		this.setQuotebyuserid(dao.getQuotebyuserid());
		this.setQuotedate(dao.getQuotedate());
		this.setQuotestatus(dao.getQuotestatus());
		this.setRejectreason(dao.getRejectreason());
		this.setShipmethod(dao.getShipmethod());

		this.setCompanykey(dao.getCompanykey());//200900045
		this.setDepartmentkey(dao.getDepartmentkey());//200900045
		this.setActivitykey(dao.getActivitykey());//200900045

		
		this.setDmrgccykey(dao.getDmrgccykey());//ITT-201103-0002
		this.setCcykey(dao.getCcykey());//ITT-201103-0002
		this.setDmrgfreedays(dao.getDmrgfreedays());//ITT-201103-0002
		this.setDmrgdlyrate3(dao.getDmrgdlyrate3());//ITT-201103-0002
		
		
		//sITT-200905-0003
		this.setEffectivedate(dao.getEffectivedate());
		
		Location location = new Location();
		location = new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getLdglocationkey1());
		if (location == null) location = new Location();
		this.setLdglocationkey1(location);
		
		location = new Location();
		location = new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getLdglocationkey2());
		if (location == null) location = new Location();
		this.setLdglocationkey2(location);

		location = new Location();
		location = new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getDchlocationkey2());
		if (location == null) location = new Location();
		this.setDchlocationkey2(location);

		location = new Location();
		location = new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getDchlocationkey1());
		if (location == null) location = new Location();
		this.setDchlocationkey1(location);
		
		Product product = new Product();
		product = new ProductBD(this.getSessionFactoryClusterMap()).read(dao.getProductkey());
		if (product == null) product = new Product();
		this.setProductkey(product);
		//eITT-200905-0003
		
		
		this.setOrderhdrsfound("false");
		try {
			if (
					//new QuohdrBD(this.getSessionFactoryClusterMap()).getOrderhdrs(dao.getId()).size() > 0 //200900058
					new QuohdrBD(this.getSessionFactoryClusterMap()).getOrderhdrsByQuotno(dao.getQuotno()).size() > 0 //200900058
			) this.setOrderhdrsfound("true");
		} catch (ApplicationException ae) {}
		
		this.setNotesfound("0");
		try {
			this.setNotesfound(new QuonoteBD(this.getSessionFactoryClusterMap()).findQuonotesTotalResults(dao.getId().toString())+"");
		} catch (ApplicationException ae) {}	
		
		this.setNotecustsfound("0");
		try {
			this.setNotecustsfound(new QuonotecustBD(this.getSessionFactoryClusterMap()).findQuonotecustsTotalResults(dao.getId().toString())+"");
		} catch (ApplicationException ae) {}	

		this.setDocumentsfound("0");
		try {
			this.setDocumentsfound(new QuofileBD(this.getSessionFactoryClusterMap()).findQuofilesTotalResults(dao.getId().toString())+"");
		} catch (ApplicationException ae) {}
		
	}
	
	
	
	// primary key
	private java.lang.Integer id;
	
	// fields
	private String readonly = "false";
	private String orderhdrsfound = "false";	
	private String notesfound = "false";	
	private String notecustsfound = "false";
	private String documentsfound = "false";
	
	
	private java.lang.String shipmethod;
	private java.lang.String eqpidkey4;
	private boolean deleted;
	private java.util.Date quotedate;
	private java.util.Date effectivedate;
	private java.lang.String dchg4key1;
	private java.lang.String eqpidkey2;
	private java.lang.String contract;
	private java.util.Date expirydate;
	private Product productkey;
	private java.lang.String ldgg1key1;
	private java.lang.String eqpidkey1;
	private java.lang.String shipperaddrkey;
	private java.lang.String invpref;
	private java.lang.String dchport;
	private java.lang.String dchg2key1;
	private java.util.Date approvaldate;
	private Location ldglocationkey1;//ITT-200905-0003
	private java.lang.String ccykey;
	private java.lang.String ldgg3key2;
	private Location ldglocationkey2;//ITT-200905-0003
	private java.lang.Integer dmrgdays2;
	private Location dchlocationkey1;//ITT-200905-0003
	private java.lang.String eqpidkey5;
	private java.lang.String dchg3key1;
	private java.lang.String brokerref;
	private boolean ownregion;
	private java.lang.Integer datumDays;
	private java.lang.String shipperref;
	private java.lang.String quotno;
	private java.lang.String companykey;
	private java.lang.String rejectreason;
	private java.lang.String mainchargeccykey;
	private java.lang.String ldgg1key2;
	private Location dchlocationkey2;//ITT-200905-0003
	private java.lang.String dchg4key2;
	private java.lang.String dchg3key2;
	private java.lang.String contact;
	private java.lang.String telno;
	private java.lang.Integer dmrgfreedaysleft;
	private java.lang.String faxno;
	private java.lang.Integer dmrgdays1;
	private java.lang.String eqpidkey3;
	private java.lang.String dmrglocationkey;
	private java.lang.String ldgg4key2;
	private java.lang.String ldgport;
	private java.lang.String quotype;
	private java.lang.String departmentkey;
	private java.lang.String ldgg2key1;
	private java.lang.Integer dmrgfreedays;
	private boolean prepaid;
	private boolean rtmFlag;
	private java.lang.String dchg1key2;
	private java.lang.String systemlogtime;
	private java.lang.String dmrgccykey;
	private java.util.Date exchgdate;
	private java.math.BigDecimal dmrgdlyrate2;
	private java.lang.String delterm;
	private java.lang.String quotebyuserid;
	private java.lang.String ldgg4key1;
	private java.math.BigDecimal dmrgdlyrate3;
	private java.lang.String createtime;
	private java.lang.String ldgg3key1;
	private java.lang.String customercontactkey;
	private java.lang.String dchg1key1;
	private java.lang.String notes;
	private java.lang.String quotestatus;
	private java.lang.String brokeraddrkey;
	private boolean dedicode;
	private java.lang.String consigneeref;
	private boolean heating;
	private boolean minProfAcceptFlag;
	private java.lang.String trmode;
	private java.lang.String liaison;
	private java.lang.String mainchargekey;
	private java.lang.String consigneeaddrkey;
	private java.math.BigDecimal dmrgdlyrate1;
	private java.lang.String fwdagentaddrkey;
	private java.lang.String ldgg2key2;
	private java.lang.String rtmReason;
	private java.lang.String createuserid;
	private java.lang.String customerref;
	private boolean clncert;
	private java.lang.String invoicegroupref;
	private java.lang.String activitykey;
	private java.lang.String dchg2key2;
	private java.lang.String fwdagentref;
	private java.lang.String emailno;
	private Address customeraddrkey;
	
	private java.lang.String customername;
	private java.lang.String customeraddr1;
	private java.lang.String customeraddr2;
	private java.lang.String customeraddr3;
	private java.lang.String customeraddr4;
	private java.lang.String customeraddr5;
	private java.lang.String customercontact;
	private java.lang.String customertelno;
	private java.lang.String customerfaxno;
	private java.lang.String customeremail;
	
	
	
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public String getOrderhdrsfound() {return orderhdrsfound;}
	public void setOrderhdrsfound(String orderhdrsfound) {this.orderhdrsfound = orderhdrsfound;}
	
	public String getNotesfound() {return notesfound;}
	public void setNotesfound(String notesfound) {this.notesfound = notesfound;}
	
	public String getNotecustsfound() {return notecustsfound;}
	public void setNotecustsfound(String notecustsfound) {this.notecustsfound = notecustsfound;}
	
	public String getDocumentsfound() {return documentsfound;}
	public void setDocumentsfound(String documentsfound) {this.documentsfound = documentsfound;}
	
	
	
	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="native"
	 *  column="QUOHDR_ID"
	 */
	public java.lang.Integer getId () {
		return id;
	}
	
	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: shipmethod
	 */
	public java.lang.String getShipmethod () {
		return shipmethod;
	}
	
	/**
	 * Set the value related to the column: shipmethod
	 * @param shipmethod the shipmethod value
	 */
	public void setShipmethod (java.lang.String shipmethod) {
		this.shipmethod = shipmethod;
	}
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: EQPIDKEY4
	 */
	public java.lang.String getEqpidkey4 () {
		return eqpidkey4;
	}
	
	/**
	 * Set the value related to the column: EQPIDKEY4
	 * @param eqpidkey4 the EQPIDKEY4 value
	 */
	public void setEqpidkey4 (java.lang.String eqpidkey4) {
		this.eqpidkey4 = eqpidkey4;
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
	 * Return the value associated with the column: quotedate
	 */
	public java.util.Date getQuotedate () {
		return quotedate;
	}
	
	/**
	 * Set the value related to the column: quotedate
	 * @param quotedate the quotedate value
	 */
	public void setQuotedate (java.util.Date quotedate) {
		this.quotedate = quotedate;
	}
	
	
	
	/**
	 * Return the value associated with the column: DCHG4KEY1
	 */
	public java.lang.String getDchg4key1 () {
		return dchg4key1;
	}
	
	/**
	 * Set the value related to the column: DCHG4KEY1
	 * @param dchg4key1 the DCHG4KEY1 value
	 */
	public void setDchg4key1 (java.lang.String dchg4key1) {
		this.dchg4key1 = dchg4key1;
	}
	
	
	
	/**
	 * Return the value associated with the column: EQPIDKEY2
	 */
	public java.lang.String getEqpidkey2 () {
		return eqpidkey2;
	}
	
	/**
	 * Set the value related to the column: EQPIDKEY2
	 * @param eqpidkey2 the EQPIDKEY2 value
	 */
	public void setEqpidkey2 (java.lang.String eqpidkey2) {
		this.eqpidkey2 = eqpidkey2;
	}
	
	
	
	/**
	 * Return the value associated with the column: CONTRACT
	 */
	public java.lang.String getContract () {
		return contract;
	}
	
	/**
	 * Set the value related to the column: CONTRACT
	 * @param contract the CONTRACT value
	 */
	public void setContract (java.lang.String contract) {
		this.contract = contract;
	}
	
	
	
	/**
	 * Return the value associated with the column: expirydate
	 */
	public java.util.Date getExpirydate () {
		return expirydate;
	}
	
	/**
	 * Set the value related to the column: expirydate
	 * @param expirydate the expirydate value
	 */
	public void setExpirydate (java.util.Date expirydate) {
		this.expirydate = expirydate;
	}
	
	

	/**
	 * Return the value associated with the column: effectivedate
	 */
	public java.util.Date getEffectivedate () {
		return effectivedate;
	}
	
	/**
	 * Set the value related to the column: expirydate
	 * @param expirydate the expirydate value
	 */
	public void setEffectivedate (java.util.Date effectivedate) {
		this.effectivedate = effectivedate;
	}
	
	
	
	/**
	 * Return the value associated with the column: productkey
	 */
	public Product getProductkey () {
		return productkey;
	}
	
	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (Product productkey) {
		this.productkey = productkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: LDGG1KEY1
	 */
	public java.lang.String getLdgg1key1 () {
		return ldgg1key1;
	}
	
	/**
	 * Set the value related to the column: LDGG1KEY1
	 * @param ldgg1key1 the LDGG1KEY1 value
	 */
	public void setLdgg1key1 (java.lang.String ldgg1key1) {
		this.ldgg1key1 = ldgg1key1;
	}
	
	
	
	/**
	 * Return the value associated with the column: EQPIDKEY1
	 */
	public java.lang.String getEqpidkey1 () {
		return eqpidkey1;
	}
	
	/**
	 * Set the value related to the column: EQPIDKEY1
	 * @param eqpidkey1 the EQPIDKEY1 value
	 */
	public void setEqpidkey1 (java.lang.String eqpidkey1) {
		this.eqpidkey1 = eqpidkey1;
	}
	
	
	
	/**
	 * Return the value associated with the column: shipperaddrkey
	 */
	public java.lang.String getShipperaddrkey () {
		return shipperaddrkey;
	}
	
	/**
	 * Set the value related to the column: shipperaddrkey
	 * @param shipperaddrkey the shipperaddrkey value
	 */
	public void setShipperaddrkey (java.lang.String shipperaddrkey) {
		this.shipperaddrkey = shipperaddrkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: INVPREF
	 */
	public java.lang.String getInvpref () {
		return invpref;
	}
	
	/**
	 * Set the value related to the column: INVPREF
	 * @param invpref the INVPREF value
	 */
	public void setInvpref (java.lang.String invpref) {
		this.invpref = invpref;
	}
	
	
	
	/**
	 * Return the value associated with the column: DCHPORT
	 */
	public java.lang.String getDchport () {
		return dchport;
	}
	
	/**
	 * Set the value related to the column: DCHPORT
	 * @param dchport the DCHPORT value
	 */
	public void setDchport (java.lang.String dchport) {
		this.dchport = dchport;
	}
	
	
	
	/**
	 * Return the value associated with the column: DCHG2KEY1
	 */
	public java.lang.String getDchg2key1 () {
		return dchg2key1;
	}
	
	/**
	 * Set the value related to the column: DCHG2KEY1
	 * @param dchg2key1 the DCHG2KEY1 value
	 */
	public void setDchg2key1 (java.lang.String dchg2key1) {
		this.dchg2key1 = dchg2key1;
	}
	
	
	
	/**
	 * Return the value associated with the column: approvaldate
	 */
	public java.util.Date getApprovaldate () {
		return approvaldate;
	}
	
	/**
	 * Set the value related to the column: approvaldate
	 * @param approvaldate the approvaldate value
	 */
	public void setApprovaldate (java.util.Date approvaldate) {
		this.approvaldate = approvaldate;
	}
	
	
	
	/**
	 * Return the value associated with the column: ldglocationkey1
	 */
	public Location getLdglocationkey1 () {
		return ldglocationkey1;
	}
	
	/**
	 * Set the value related to the column: ldglocationkey1
	 * @param ldglocationkey1 the ldglocationkey1 value
	 */
	public void setLdglocationkey1 (Location ldglocationkey1) {
		this.ldglocationkey1 = ldglocationkey1;
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
	 * Return the value associated with the column: ldgg3key2
	 */
	public java.lang.String getLdgg3key2 () {
		return ldgg3key2;
	}
	
	/**
	 * Set the value related to the column: ldgg3key2
	 * @param ldgg3key2 the ldgg3key2 value
	 */
	public void setLdgg3key2 (java.lang.String ldgg3key2) {
		this.ldgg3key2 = ldgg3key2;
	}
	
	
	
	/**
	 * Return the value associated with the column: ldglocationkey2
	 */
	public Location getLdglocationkey2 () {
		return ldglocationkey2;
	}
	
	/**
	 * Set the value related to the column: ldglocationkey2
	 * @param ldglocationkey2 the ldglocationkey2 value
	 */
	public void setLdglocationkey2 (Location ldglocationkey2) {
		this.ldglocationkey2 = ldglocationkey2;
	}
	
	
	
	/**
	 * Return the value associated with the column: dmrgdays2
	 */
	public java.lang.Integer getDmrgdays2 () {
		return dmrgdays2;
	}
	
	/**
	 * Set the value related to the column: dmrgdays2
	 * @param dmrgdays2 the dmrgdays2 value
	 */
	public void setDmrgdays2 (java.lang.Integer dmrgdays2) {
		this.dmrgdays2 = dmrgdays2;
	}
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: dchlocationkey1
	 */
	public Location getDchlocationkey1 () {
		return dchlocationkey1;
	}
	
	/**
	 * Set the value related to the column: dchlocationkey1
	 * @param dchlocationkey1 the dchlocationkey1 value
	 */
	public void setDchlocationkey1 (Location dchlocationkey1) {
		this.dchlocationkey1 = dchlocationkey1;
	}
	
	
	
	/**
	 * Return the value associated with the column: EQPIDKEY5
	 */
	public java.lang.String getEqpidkey5 () {
		return eqpidkey5;
	}
	
	/**
	 * Set the value related to the column: EQPIDKEY5
	 * @param eqpidkey5 the EQPIDKEY5 value
	 */
	public void setEqpidkey5 (java.lang.String eqpidkey5) {
		this.eqpidkey5 = eqpidkey5;
	}
	
	
	
	/**
	 * Return the value associated with the column: DCHG3KEY1
	 */
	public java.lang.String getDchg3key1 () {
		return dchg3key1;
	}
	
	/**
	 * Set the value related to the column: DCHG3KEY1
	 * @param dchg3key1 the DCHG3KEY1 value
	 */
	public void setDchg3key1 (java.lang.String dchg3key1) {
		this.dchg3key1 = dchg3key1;
	}
	
	
	
	/**
	 * Return the value associated with the column: brokerref
	 */
	public java.lang.String getBrokerref () {
		return brokerref;
	}
	
	/**
	 * Set the value related to the column: brokerref
	 * @param brokerref the brokerref value
	 */
	public void setBrokerref (java.lang.String brokerref) {
		this.brokerref = brokerref;
	}
	
	
	
	/**
	 * Return the value associated with the column: OWNREGION
	 */
	public boolean isOwnregion () {
		return ownregion;
	}
	
	/**
	 * Set the value related to the column: OWNREGION
	 * @param ownregion the OWNREGION value
	 */
	public void setOwnregion (boolean ownregion) {
		this.ownregion = ownregion;
	}
	
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: DATUM_DAYS
	 */
	public java.lang.Integer getDatumDays () {
		return datumDays;
	}
	
	/**
	 * Set the value related to the column: DATUM_DAYS
	 * @param datumDays the DATUM_DAYS value
	 */
	public void setDatumDays (java.lang.Integer datumDays) {
		this.datumDays = datumDays;
	}
	
	
	
	/**
	 * Return the value associated with the column: shipperref
	 */
	public java.lang.String getShipperref () {
		return shipperref;
	}
	
	/**
	 * Set the value related to the column: shipperref
	 * @param shipperref the shipperref value
	 */
	public void setShipperref (java.lang.String shipperref) {
		this.shipperref = shipperref;
	}
	
	
	
	/**
	 * Return the value associated with the column: quotno
	 */
	public java.lang.String getQuotno () {
		return quotno;
	}
	
	/**
	 * Set the value related to the column: quotno
	 * @param quotno the quotno value
	 */
	public void setQuotno (java.lang.String quotno) {
		this.quotno = quotno;
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
	 * Return the value associated with the column: rejectreason
	 */
	public java.lang.String getRejectreason () {
		return rejectreason;
	}
	
	/**
	 * Set the value related to the column: rejectreason
	 * @param rejectreason the rejectreason value
	 */
	public void setRejectreason (java.lang.String rejectreason) {
		this.rejectreason = rejectreason;
	}
	
	
	
	/**
	 * Return the value associated with the column: mainchargeccykey
	 */
	public java.lang.String getMainchargeccykey () {
		return mainchargeccykey;
	}
	
	/**
	 * Set the value related to the column: mainchargeccykey
	 * @param mainchargeccykey the mainchargeccykey value
	 */
	public void setMainchargeccykey (java.lang.String mainchargeccykey) {
		this.mainchargeccykey = mainchargeccykey;
	}
	
	
	
	/**
	 * Return the value associated with the column: ldgg1key2
	 */
	public java.lang.String getLdgg1key2 () {
		return ldgg1key2;
	}
	
	/**
	 * Set the value related to the column: ldgg1key2
	 * @param ldgg1key2 the ldgg1key2 value
	 */
	public void setLdgg1key2 (java.lang.String ldgg1key2) {
		this.ldgg1key2 = ldgg1key2;
	}
	
	
	
	/**
	 * Return the value associated with the column: dchlocationkey2
	 */
	public Location getDchlocationkey2 () {
		return dchlocationkey2;
	}
	
	/**
	 * Set the value related to the column: dchlocationkey2
	 * @param dchlocationkey2 the dchlocationkey2 value
	 */
	public void setDchlocationkey2 (Location dchlocationkey2) {
		this.dchlocationkey2 = dchlocationkey2;
	}
	
	
	
	/**
	 * Return the value associated with the column: dchg4key2
	 */
	public java.lang.String getDchg4key2 () {
		return dchg4key2;
	}
	
	/**
	 * Set the value related to the column: dchg4key2
	 * @param dchg4key2 the dchg4key2 value
	 */
	public void setDchg4key2 (java.lang.String dchg4key2) {
		this.dchg4key2 = dchg4key2;
	}
	
	
	
	/**
	 * Return the value associated with the column: dchg3key2
	 */
	public java.lang.String getDchg3key2 () {
		return dchg3key2;
	}
	
	/**
	 * Set the value related to the column: dchg3key2
	 * @param dchg3key2 the dchg3key2 value
	 */
	public void setDchg3key2 (java.lang.String dchg3key2) {
		this.dchg3key2 = dchg3key2;
	}
	
	
	
	/**
	 * Return the value associated with the column: CONTACT
	 */
	public java.lang.String getContact () {
		return contact;
	}
	
	/**
	 * Set the value related to the column: CONTACT
	 * @param contact the CONTACT value
	 */
	public void setContact (java.lang.String contact) {
		this.contact = contact;
	}
	
	
	
	/**
	 * Return the value associated with the column: TELNO
	 */
	public java.lang.String getTelno () {
		return telno;
	}
	
	/**
	 * Set the value related to the column: TELNO
	 * @param telno the TELNO value
	 */
	public void setTelno (java.lang.String telno) {
		this.telno = telno;
	}
	
	
	
	/**
	 * Return the value associated with the column: dmrgfreedaysleft
	 */
	public java.lang.Integer getDmrgfreedaysleft () {
		return dmrgfreedaysleft;
	}
	
	/**
	 * Set the value related to the column: dmrgfreedaysleft
	 * @param dmrgfreedaysleft the dmrgfreedaysleft value
	 */
	public void setDmrgfreedaysleft (java.lang.Integer dmrgfreedaysleft) {
		this.dmrgfreedaysleft = dmrgfreedaysleft;
	}
	
	
	
	/**
	 * Return the value associated with the column: FAXNO
	 */
	public java.lang.String getFaxno () {
		return faxno;
	}
	
	/**
	 * Set the value related to the column: FAXNO
	 * @param faxno the FAXNO value
	 */
	public void setFaxno (java.lang.String faxno) {
		this.faxno = faxno;
	}
	
	
	
	/**
	 * Return the value associated with the column: dmrgdays1
	 */
	public java.lang.Integer getDmrgdays1 () {
		return dmrgdays1;
	}
	
	/**
	 * Set the value related to the column: dmrgdays1
	 * @param dmrgdays1 the dmrgdays1 value
	 */
	public void setDmrgdays1 (java.lang.Integer dmrgdays1) {
		this.dmrgdays1 = dmrgdays1;
	}
	
	
	
	/**
	 * Return the value associated with the column: EQPIDKEY3
	 */
	public java.lang.String getEqpidkey3 () {
		return eqpidkey3;
	}
	
	/**
	 * Set the value related to the column: EQPIDKEY3
	 * @param eqpidkey3 the EQPIDKEY3 value
	 */
	public void setEqpidkey3 (java.lang.String eqpidkey3) {
		this.eqpidkey3 = eqpidkey3;
	}
	
	
	
	/**
	 * Return the value associated with the column: dmrglocationkey
	 */
	public java.lang.String getDmrglocationkey () {
		return dmrglocationkey;
	}
	
	/**
	 * Set the value related to the column: dmrglocationkey
	 * @param dmrglocationkey the dmrglocationkey value
	 */
	public void setDmrglocationkey (java.lang.String dmrglocationkey) {
		this.dmrglocationkey = dmrglocationkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: ldgg4key2
	 */
	public java.lang.String getLdgg4key2 () {
		return ldgg4key2;
	}
	
	/**
	 * Set the value related to the column: ldgg4key2
	 * @param ldgg4key2 the ldgg4key2 value
	 */
	public void setLdgg4key2 (java.lang.String ldgg4key2) {
		this.ldgg4key2 = ldgg4key2;
	}
	
	
	
	/**
	 * Return the value associated with the column: LDGPORT
	 */
	public java.lang.String getLdgport () {
		return ldgport;
	}
	
	/**
	 * Set the value related to the column: LDGPORT
	 * @param ldgport the LDGPORT value
	 */
	public void setLdgport (java.lang.String ldgport) {
		this.ldgport = ldgport;
	}
	
	
	
	/**
	 * Return the value associated with the column: QUOTYPE
	 */
	public java.lang.String getQuotype () {
		return quotype;
	}
	
	/**
	 * Set the value related to the column: QUOTYPE
	 * @param quotype the QUOTYPE value
	 */
	public void setQuotype (java.lang.String quotype) {
		this.quotype = quotype;
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
	 * Return the value associated with the column: LDGG2KEY1
	 */
	public java.lang.String getLdgg2key1 () {
		return ldgg2key1;
	}
	
	/**
	 * Set the value related to the column: LDGG2KEY1
	 * @param ldgg2key1 the LDGG2KEY1 value
	 */
	public void setLdgg2key1 (java.lang.String ldgg2key1) {
		this.ldgg2key1 = ldgg2key1;
	}
	
	
	
	/**
	 * Return the value associated with the column: dmrgfreedays
	 */
	public java.lang.Integer getDmrgfreedays () {
		return dmrgfreedays;
	}
	
	/**
	 * Set the value related to the column: dmrgfreedays
	 * @param dmrgfreedays the dmrgfreedays value
	 */
	public void setDmrgfreedays (java.lang.Integer dmrgfreedays) {
		this.dmrgfreedays = dmrgfreedays;
	}
	
	
	
	/**
	 * Return the value associated with the column: PREPAID
	 */
	public boolean isPrepaid () {
		return prepaid;
	}
	
	/**
	 * Set the value related to the column: PREPAID
	 * @param prepaid the PREPAID value
	 */
	public void setPrepaid (boolean prepaid) {
		this.prepaid = prepaid;
	}
	
	
	
	/**
	 * Return the value associated with the column: RTM_FLAG
	 */
	public boolean isRtmFlag () {
		return rtmFlag;
	}
	
	/**
	 * Set the value related to the column: RTM_FLAG
	 * @param rtmFlag the RTM_FLAG value
	 */
	public void setRtmFlag (boolean rtmFlag) {
		this.rtmFlag = rtmFlag;
	}
	
	
	
	/**
	 * Return the value associated with the column: dchg1key2
	 */
	public java.lang.String getDchg1key2 () {
		return dchg1key2;
	}
	
	/**
	 * Set the value related to the column: dchg1key2
	 * @param dchg1key2 the dchg1key2 value
	 */
	public void setDchg1key2 (java.lang.String dchg1key2) {
		this.dchg1key2 = dchg1key2;
	}
	
	
	
	/**
	 * Return the value associated with the column: systemlogtime
	 */
	public java.lang.String getSystemlogtime () {
		return systemlogtime;
	}
	
	/**
	 * Set the value related to the column: systemlogtime
	 * @param systemlogtime the systemlogtime value
	 */
	public void setSystemlogtime (java.lang.String systemlogtime) {
		this.systemlogtime = systemlogtime;
	}
	
	
	
	/**
	 * Return the value associated with the column: DMRGCCYKEY
	 */
	public java.lang.String getDmrgccykey () {
		return dmrgccykey;
	}
	
	/**
	 * Set the value related to the column: DMRGCCYKEY
	 * @param dmrgccykey the DMRGCCYKEY value
	 */
	public void setDmrgccykey (java.lang.String dmrgccykey) {
		this.dmrgccykey = dmrgccykey;
	}
	
	
	
	/**
	 * Return the value associated with the column: EXCHGDATE
	 */
	public java.util.Date getExchgdate () {
		return exchgdate;
	}
	
	/**
	 * Set the value related to the column: EXCHGDATE
	 * @param exchgdate the EXCHGDATE value
	 */
	public void setExchgdate (java.util.Date exchgdate) {
		this.exchgdate = exchgdate;
	}
	
	
	
	/**
	 * Return the value associated with the column: dmrgdlyrate2
	 */
	public java.math.BigDecimal getDmrgdlyrate2 () {
		return dmrgdlyrate2;
	}
	
	/**
	 * Set the value related to the column: dmrgdlyrate2
	 * @param dmrgdlyrate2 the dmrgdlyrate2 value
	 */
	public void setDmrgdlyrate2 (java.math.BigDecimal dmrgdlyrate2) {
		this.dmrgdlyrate2 = dmrgdlyrate2;
	}
	
	
	
	/**
	 * Return the value associated with the column: DELTERM
	 */
	public java.lang.String getDelterm () {
		return delterm;
	}
	
	/**
	 * Set the value related to the column: DELTERM
	 * @param delterm the DELTERM value
	 */
	public void setDelterm (java.lang.String delterm) {
		this.delterm = delterm;
	}
	
	
	
	/**
	 * Return the value associated with the column: quotebyuserid
	 */
	public java.lang.String getQuotebyuserid () {
		return quotebyuserid;
	}
	
	/**
	 * Set the value related to the column: quotebyuserid
	 * @param quotebyuserid the quotebyuserid value
	 */
	public void setQuotebyuserid (java.lang.String quotebyuserid) {
		this.quotebyuserid = quotebyuserid;
	}
	
	
	
	/**
	 * Return the value associated with the column: LDGG4KEY1
	 */
	public java.lang.String getLdgg4key1 () {
		return ldgg4key1;
	}
	
	/**
	 * Set the value related to the column: LDGG4KEY1
	 * @param ldgg4key1 the LDGG4KEY1 value
	 */
	public void setLdgg4key1 (java.lang.String ldgg4key1) {
		this.ldgg4key1 = ldgg4key1;
	}
	
	
	
	/**
	 * Return the value associated with the column: dmrgdlyrate3
	 */
	public java.math.BigDecimal getDmrgdlyrate3 () {
		return dmrgdlyrate3;
	}
	
	/**
	 * Set the value related to the column: dmrgdlyrate3
	 * @param dmrgdlyrate3 the dmrgdlyrate3 value
	 */
	public void setDmrgdlyrate3 (java.math.BigDecimal dmrgdlyrate3) {
		this.dmrgdlyrate3 = dmrgdlyrate3;
	}
	
	
	
	/**
	 * Return the value associated with the column: CREATETIME
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}
	
	/**
	 * Set the value related to the column: CREATETIME
	 * @param createtime the CREATETIME value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}
	
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: LDGG3KEY1
	 */
	public java.lang.String getLdgg3key1 () {
		return ldgg3key1;
	}
	
	/**
	 * Set the value related to the column: LDGG3KEY1
	 * @param ldgg3key1 the LDGG3KEY1 value
	 */
	public void setLdgg3key1 (java.lang.String ldgg3key1) {
		this.ldgg3key1 = ldgg3key1;
	}
	
	
	
	/**
	 * Return the value associated with the column: customercontactkey
	 */
	public java.lang.String getCustomercontactkey () {
		return customercontactkey;
	}
	
	/**
	 * Set the value related to the column: customercontactkey
	 * @param customercontactkey the customercontactkey value
	 */
	public void setCustomercontactkey (java.lang.String customercontactkey) {
		this.customercontactkey = customercontactkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: DCHG1KEY1
	 */
	public java.lang.String getDchg1key1 () {
		return dchg1key1;
	}
	
	/**
	 * Set the value related to the column: DCHG1KEY1
	 * @param dchg1key1 the DCHG1KEY1 value
	 */
	public void setDchg1key1 (java.lang.String dchg1key1) {
		this.dchg1key1 = dchg1key1;
	}
	
	
	
	/**
	 * Return the value associated with the column: NOTES
	 */
	public java.lang.String getNotes () {
		return notes;
	}
	
	/**
	 * Set the value related to the column: NOTES
	 * @param notes the NOTES value
	 */
	public void setNotes (java.lang.String notes) {
		this.notes = notes;
	}
	
	
	
	/**
	 * Return the value associated with the column: quotestatus
	 */
	public java.lang.String getQuotestatus () {
		return quotestatus;
	}
	
	/**
	 * Set the value related to the column: quotestatus
	 * @param quotestatus the quotestatus value
	 */
	public void setQuotestatus (java.lang.String quotestatus) {
		this.quotestatus = quotestatus;
	}
	
	
	
	/**
	 * Return the value associated with the column: brokeraddrkey
	 */
	public java.lang.String getBrokeraddrkey () {
		return brokeraddrkey;
	}
	
	/**
	 * Set the value related to the column: brokeraddrkey
	 * @param brokeraddrkey the brokeraddrkey value
	 */
	public void setBrokeraddrkey (java.lang.String brokeraddrkey) {
		this.brokeraddrkey = brokeraddrkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: DEDICODE
	 */
	public boolean isDedicode () {
		return dedicode;
	}
	
	/**
	 * Set the value related to the column: DEDICODE
	 * @param dedicode the DEDICODE value
	 */
	public void setDedicode (boolean dedicode) {
		this.dedicode = dedicode;
	}
	
	
	
	/**
	 * Return the value associated with the column: consigneeref
	 */
	public java.lang.String getConsigneeref () {
		return consigneeref;
	}
	
	/**
	 * Set the value related to the column: consigneeref
	 * @param consigneeref the consigneeref value
	 */
	public void setConsigneeref (java.lang.String consigneeref) {
		this.consigneeref = consigneeref;
	}
	
	
	
	/**
	 * Return the value associated with the column: HEATING
	 */
	public boolean isHeating () {
		return heating;
	}
	
	/**
	 * Set the value related to the column: HEATING
	 * @param heating the HEATING value
	 */
	public void setHeating (boolean heating) {
		this.heating = heating;
	}
	
	
	
	/**
	 * Return the value associated with the column: MIN_PROF_ACCEPT_FLAG
	 */
	public boolean isMinProfAcceptFlag () {
		return minProfAcceptFlag;
	}
	
	/**
	 * Set the value related to the column: MIN_PROF_ACCEPT_FLAG
	 * @param minProfAcceptFlag the MIN_PROF_ACCEPT_FLAG value
	 */
	public void setMinProfAcceptFlag (boolean minProfAcceptFlag) {
		this.minProfAcceptFlag = minProfAcceptFlag;
	}
	
	
	
	/**
	 * Return the value associated with the column: TRMODE
	 */
	public java.lang.String getTrmode () {
		return trmode;
	}
	
	/**
	 * Set the value related to the column: TRMODE
	 * @param trmode the TRMODE value
	 */
	public void setTrmode (java.lang.String trmode) {
		this.trmode = trmode;
	}
	
	
	
	/**
	 * Return the value associated with the column: LIAISON
	 */
	public java.lang.String getLiaison () {
		return liaison;
	}
	
	/**
	 * Set the value related to the column: LIAISON
	 * @param liaison the LIAISON value
	 */
	public void setLiaison (java.lang.String liaison) {
		this.liaison = liaison;
	}
	
	
	
	/**
	 * Return the value associated with the column: mainchargekey
	 */
	public java.lang.String getMainchargekey () {
		return mainchargekey;
	}
	
	/**
	 * Set the value related to the column: mainchargekey
	 * @param mainchargekey the mainchargekey value
	 */
	public void setMainchargekey (java.lang.String mainchargekey) {
		this.mainchargekey = mainchargekey;
	}
	
	
	
	/**
	 * Return the value associated with the column: consigneeaddrkey
	 */
	public java.lang.String getConsigneeaddrkey () {
		return consigneeaddrkey;
	}
	
	/**
	 * Set the value related to the column: consigneeaddrkey
	 * @param consigneeaddrkey the consigneeaddrkey value
	 */
	public void setConsigneeaddrkey (java.lang.String consigneeaddrkey) {
		this.consigneeaddrkey = consigneeaddrkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: dmrgdlyrate1
	 */
	public java.math.BigDecimal getDmrgdlyrate1 () {
		return dmrgdlyrate1;
	}
	
	/**
	 * Set the value related to the column: dmrgdlyrate1
	 * @param dmrgdlyrate1 the dmrgdlyrate1 value
	 */
	public void setDmrgdlyrate1 (java.math.BigDecimal dmrgdlyrate1) {
		this.dmrgdlyrate1 = dmrgdlyrate1;
	}
	
	
	
	/**
	 * Return the value associated with the column: fwdagentaddrkey
	 */
	public java.lang.String getFwdagentaddrkey () {
		return fwdagentaddrkey;
	}
	
	/**
	 * Set the value related to the column: fwdagentaddrkey
	 * @param fwdagentaddrkey the fwdagentaddrkey value
	 */
	public void setFwdagentaddrkey (java.lang.String fwdagentaddrkey) {
		this.fwdagentaddrkey = fwdagentaddrkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: ldgg2key2
	 */
	public java.lang.String getLdgg2key2 () {
		return ldgg2key2;
	}
	
	/**
	 * Set the value related to the column: ldgg2key2
	 * @param ldgg2key2 the ldgg2key2 value
	 */
	public void setLdgg2key2 (java.lang.String ldgg2key2) {
		this.ldgg2key2 = ldgg2key2;
	}
	
	
	
	/**
	 * Return the value associated with the column: RTM_REASON
	 */
	public java.lang.String getRtmReason () {
		return rtmReason;
	}
	
	/**
	 * Set the value related to the column: RTM_REASON
	 * @param rtmReason the RTM_REASON value
	 */
	public void setRtmReason (java.lang.String rtmReason) {
		this.rtmReason = rtmReason;
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
	 * Return the value associated with the column: customerref
	 */
	public java.lang.String getCustomerref () {
		return customerref;
	}
	
	/**
	 * Set the value related to the column: customerref
	 * @param customerref the customerref value
	 */
	public void setCustomerref (java.lang.String customerref) {
		this.customerref = customerref;
	}
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: CLNCERT
	 */
	public boolean isClncert () {
		return clncert;
	}
	
	/**
	 * Set the value related to the column: CLNCERT
	 * @param clncert the CLNCERT value
	 */
	public void setClncert (boolean clncert) {
		this.clncert = clncert;
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
	 * Return the value associated with the column: dchg2key2
	 */
	public java.lang.String getDchg2key2 () {
		return dchg2key2;
	}
	
	/**
	 * Set the value related to the column: dchg2key2
	 * @param dchg2key2 the dchg2key2 value
	 */
	public void setDchg2key2 (java.lang.String dchg2key2) {
		this.dchg2key2 = dchg2key2;
	}
	
	
	
	/**
	 * Return the value associated with the column: fwdagentref
	 */
	public java.lang.String getFwdagentref () {
		return fwdagentref;
	}
	
	/**
	 * Set the value related to the column: fwdagentref
	 * @param fwdagentref the fwdagentref value
	 */
	public void setFwdagentref (java.lang.String fwdagentref) {
		this.fwdagentref = fwdagentref;
	}
	
	
	
	/**
	 * Return the value associated with the column: EMAILNO
	 */
	public java.lang.String getEmailno () {
		return emailno;
	}
	
	/**
	 * Set the value related to the column: EMAILNO
	 * @param emailno the EMAILNO value
	 */
	public void setEmailno (java.lang.String emailno) {
		this.emailno = emailno;
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
	 * Return the value associated with the column: customername
	 */
	public java.lang.String getCustomername () {
		return customername;
	}

	/**
	 * Set the value related to the column: customername
	 * @param customername the customername value
	 */
	public void setCustomername (java.lang.String customername) {
		this.customername = customername;
	}



	/**
	 * Return the value associated with the column: customeraddr1
	 */
	public java.lang.String getCustomeraddr1 () {
		return customeraddr1;
	}

	/**
	 * Set the value related to the column: customeraddr1
	 * @param customeraddr1 the customeraddr1 value
	 */
	public void setCustomeraddr1 (java.lang.String customeraddr1) {
		this.customeraddr1 = customeraddr1;
	}



	/**
	 * Return the value associated with the column: customeraddr2
	 */
	public java.lang.String getCustomeraddr2 () {
		return customeraddr2;
	}

	/**
	 * Set the value related to the column: customeraddr2
	 * @param customeraddr2 the customeraddr2 value
	 */
	public void setCustomeraddr2 (java.lang.String customeraddr2) {
		this.customeraddr2 = customeraddr2;
	}



	/**
	 * Return the value associated with the column: customeraddr3
	 */
	public java.lang.String getCustomeraddr3 () {
		return customeraddr3;
	}

	/**
	 * Set the value related to the column: customeraddr3
	 * @param customeraddr3 the customeraddr3 value
	 */
	public void setCustomeraddr3 (java.lang.String customeraddr3) {
		this.customeraddr3 = customeraddr3;
	}



	/**
	 * Return the value associated with the column: customeraddr4
	 */
	public java.lang.String getCustomeraddr4 () {
		return customeraddr4;
	}

	/**
	 * Set the value related to the column: customeraddr4
	 * @param customeraddr4 the customeraddr4 value
	 */
	public void setCustomeraddr4 (java.lang.String customeraddr4) {
		this.customeraddr4 = customeraddr4;
	}



	/**
	 * Return the value associated with the column: customeraddr5
	 */
	public java.lang.String getCustomeraddr5 () {
		return customeraddr5;
	}

	/**
	 * Set the value related to the column: customeraddr5
	 * @param customeraddr5 the customeraddr5 value
	 */
	public void setCustomeraddr5 (java.lang.String customeraddr5) {
		this.customeraddr5 = customeraddr5;
	}



	/**
	 * Return the value associated with the column: customercontact
	 */
	public java.lang.String getCustomercontact () {
		return customercontact;
	}

	/**
	 * Set the value related to the column: customercontact
	 * @param customercontact the customercontact value
	 */
	public void setCustomercontact (java.lang.String customercontact) {
		this.customercontact = customercontact;
	}



	/**
	 * Return the value associated with the column: customertelno
	 */
	public java.lang.String getCustomertelno () {
		return customertelno;
	}

	/**
	 * Set the value related to the column: customertelno
	 * @param customertelno the customertelno value
	 */
	public void setCustomertelno (java.lang.String customertelno) {
		this.customertelno = customertelno;
	}



	/**
	 * Return the value associated with the column: customerfaxno
	 */
	public java.lang.String getCustomerfaxno () {
		return customerfaxno;
	}

	/**
	 * Set the value related to the column: customerfaxno
	 * @param customerfaxno the customerfaxno value
	 */
	public void setCustomerfaxno (java.lang.String customerfaxno) {
		this.customerfaxno = customerfaxno;
	}



	/**
	 * Return the value associated with the column: customeremail
	 */
	public java.lang.String getCustomeremail () {
		return customeremail;
	}

	/**
	 * Set the value related to the column: customeremail
	 * @param customeremail the customeremail value
	 */
	public void setCustomeremail (java.lang.String customeremail) {
		this.customeremail = customeremail;
	}

	
	
}
