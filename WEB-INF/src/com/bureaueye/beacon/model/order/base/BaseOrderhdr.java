package com.bureaueye.beacon.model.order.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the orderhdr table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="orderhdr"
 */

public abstract class BaseOrderhdr  implements Serializable {

	public static String REF = "Orderhdr";
	public static String PROP_DMRGDLYRATE3 = "Dmrgdlyrate3";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_LDGTOTIMEINMILLIS = "Ldgtotimeinmillis";
	public static String PROP_DCHTOTIMEINMILLIS = "Dchtotimeinmillis";
	public static String PROP_LDGLOCATIONKEY2 = "Ldglocationkey2";
	public static String PROP_LDGLOCATIONKEY1 = "Ldglocationkey1";
	public static String PROP_LDGFROMTIMEINMILLIS = "Ldgfromtimeinmillis";
	public static String PROP_LDGTODATE = "Ldgtodate";
	public static String PROP_CONSIGNEEADDRKEY = "Consigneeaddrkey";
	public static String PROP_DCHFROMTIMEINMILLIS = "Dchfromtimeinmillis";
	public static String PROP_INVOICESTATUS = "Invoicestatus";
	public static String PROP_CONSIGNEEREF = "Consigneeref";
	public static String PROP_NUMBEROFTANKS = "Numberoftanks";
	public static String PROP_MAINCHARGEKEY = "Mainchargekey";
	public static String PROP_MIN_PROF_ACCEPT_FLAG = "MinProfAcceptFlag";
	public static String PROP_EMPTYTANKREPOFLAG = "Emptytankrepoflag";
	public static String PROP_QUOHDR_ID = "QuohdrId";
	public static String PROP_LDGFROMTIME = "Ldgfromtime";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_DMRGFREEDAYS = "Dmrgfreedays";
	public static String PROP_MAINCHARGECCYKEY = "Mainchargeccykey";
	public static String PROP_QUOTNO = "Quotno";
	public static String PROP_TRMODE = "Trmode";
	public static String PROP_DOCUMENTCLOSINGDATE = "Documentclosingdate";
	public static String PROP_SHIPVOYAGE = "Shipvoyage";
	public static String PROP_DCHPORT = "Dchport";
	public static String PROP_CUTOFFTIME = "Cutofftime";
	public static String PROP_INCOTERMKEY = "Incotermkey";
	public static String PROP_ORDERSTATUS = "Orderstatus";
	public static String PROP_DCHG2KEY1 = "Dchg2key1";
	public static String PROP_CONSIGNMENTNO = "Consignmentno";
	public static String PROP_DCHG2KEY2 = "Dchg2key2";
	public static String PROP_DCHG1KEY2 = "Dchg1key2";
	public static String PROP_ORDERDATE = "Orderdate";
	public static String PROP_DCHG1KEY1 = "Dchg1key1";
	public static String PROP_DMRGDLYRATE1 = "Dmrgdlyrate1";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_DMRGDLYRATE2 = "Dmrgdlyrate2";
	public static String PROP_INVPREF = "Invpref";
	public static String PROP_HBLTYPE = "Hbltype";
	public static String PROP_PREPAID = "Prepaid";
	public static String PROP_ORDERBYUSERID = "Orderbyuserid";
	public static String PROP_DCHG4KEY1 = "Dchg4key1";
	public static String PROP_COMPLETEFLAG = "Completeflag";
	public static String PROP_DCHG4KEY2 = "Dchg4key2";
	public static String PROP_COMPLETEUSERID = "Completeuserid";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_RTM_REASON = "RtmReason";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_CLNCERT = "Clncert";
	public static String PROP_LDGG2KEY1 = "Ldgg2key1";
	public static String PROP_LDGG2KEY2 = "Ldgg2key2";
	public static String PROP_EXCHGDATE = "Exchgdate";
	public static String PROP_ITNUMBER = "Itnumber";
	public static String PROP_DCHLOCATIONKEY1 = "Dchlocationkey1";
	public static String PROP_DCHLOCATIONKEY2 = "Dchlocationkey2";
	public static String PROP_LDGTOTIME = "Ldgtotime";
	public static String PROP_BOOKINGNUMBER = "Bookingnumber";
	public static String PROP_COSTTOTAL = "Costtotal";
	public static String PROP_SHIPVESSEL = "Shipvessel";
	public static String PROP_SHIPVENDORADDRKEY = "Shipvendoraddrkey";
	public static String PROP_CUSTOMERCONTACTKEY = "Customercontactkey";
	public static String PROP_DCHTOTIME = "Dchtotime";
	public static String PROP_COMPLETEDATE = "Completedate";
	public static String PROP_DMRGLOCATIONKEY = "Dmrglocationkey";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_DCHFROMTIME = "Dchfromtime";
	public static String PROP_LDGG1KEY1 = "Ldgg1key1";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_INVOICEGROUPREF = "Invoicegroupref";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_LDGG4KEY2 = "Ldgg4key2";
	public static String PROP_DCHG3KEY2 = "Dchg3key2";
	public static String PROP_LDGG1KEY2 = "Ldgg1key2";
	public static String PROP_LDGG4KEY1 = "Ldgg4key1";
	public static String PROP_LDGG3KEY1 = "Ldgg3key1";
	public static String PROP_DCHG3KEY1 = "Dchg3key1";
	public static String PROP_LDGG3KEY2 = "Ldgg3key2";
	public static String PROP_OHBLFLAG = "Ohblflag";
	public static String PROP_CHARGETOTAL = "Chargetotal";
	public static String PROP_DCHFROMDATE = "Dchfromdate";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CUSTOMERREF = "Customerref";
	public static String PROP_OVRHDPCTG = "Ovrhdpctg";
	public static String PROP_DMRGBILLTOADDRKEY = "Dmrgbilltoaddrkey";
	public static String PROP_EQPIDKEY4 = "Eqpidkey4";
	public static String PROP_EQPIDKEY5 = "Eqpidkey5";
	public static String PROP_EQPIDKEY2 = "Eqpidkey2";
	public static String PROP_DMRGCCYKEY = "Dmrgccykey";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_EQPIDKEY3 = "Eqpidkey3";
	public static String PROP_COMPLETETIME = "Completetime";
	public static String PROP_EQPIDKEY1 = "Eqpidkey1";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_DATUM_DAYS = "DatumDays";
	public static String PROP_DELTERM = "Delterm";
	public static String PROP_SHIPMETHOD = "Shipmethod";
	public static String PROP_DELIVERYTERMINALTEXT = "Deliveryterminaltext";
	public static String PROP_DMRGFREEDAYSLEFT = "Dmrgfreedaysleft";
	public static String PROP_NOTES = "Notes";
	public static String PROP_LIAISON = "Liaison";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_DMRGDAYS1 = "Dmrgdays1";
	public static String PROP_DMRGDAYS2 = "Dmrgdays2";
	public static String PROP_BROKERREF = "Brokerref";
	public static String PROP_CUSTOMERADDRKEY = "Customeraddrkey";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_LDGFROMDATE = "Ldgfromdate";
	public static String PROP_FAXNO = "Faxno";
	public static String PROP_FWDAGENTADDRKEY = "Fwdagentaddrkey";
	public static String PROP_OWNREGION = "Ownregion";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CUTOFFDATE = "Cutoffdate";
	public static String PROP_RTM_FLAG = "RtmFlag";
	public static String PROP_SHIPPERADDRKEY = "Shipperaddrkey";
	public static String PROP_BROKERADDRKEY = "Brokeraddrkey";
	public static String PROP_PRODUCTKEY = "Productkey";
	public static String PROP_DCHTODATE = "Dchtodate";
	public static String PROP_CONTRACTTYPE = "Contracttype";
	public static String PROP_DEDICODE = "Dedicode";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_SHIPPERREF = "Shipperref";
	public static String PROP_TANKCLOSINGDATE = "Tankclosingdate";
	public static String PROP_MAINCHARGEAMOUNT = "Mainchargeamount";
	public static String PROP_HEATING = "Heating";
	public static String PROP_OBLFLAG = "Oblflag";
	public static String PROP_FWDAGENTREF = "Fwdagentref";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_LDGPORT = "Ldgport";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_ORDERTYPE = "Ordertype";


	// constructors
	public BaseOrderhdr () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrderhdr (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer quohdrId;
	private java.lang.String invoicestatus;
	private java.lang.String systemlogprogram;
	private java.lang.String eqpidkey4;
	private java.lang.String systemlogaction;
	private boolean deleted;
	private java.util.Date systemlogdate;
	private java.lang.String dchg4key1;
	private java.lang.String eqpidkey2;
	private java.lang.String orderbyuserid;
	private java.lang.String productkey;
	private java.lang.String ldgg1key1;
	private java.lang.String eqpidkey1;
	private java.util.Date cutoffdate;
	private java.lang.String shipperaddrkey;
	private java.lang.String invpref;
	private java.lang.String dchg2key1;
	private java.lang.String dchport;
	private java.math.BigDecimal mainchargeamount;
	private java.util.Date dchtodate;
	private java.math.BigDecimal chargetotal;
	private java.lang.String ldglocationkey1;
	private java.lang.String ccykey;
	private java.lang.String ldglocationkey2;
	private java.lang.String ldgg3key2;
	private boolean ohblflag;
	private java.lang.Integer dmrgdays2;
	private java.lang.String systemloguserid;
	private java.lang.String dchlocationkey1;
	private boolean emptytankrepoflag;
	private java.lang.String eqpidkey5;
	private java.lang.String dchg3key1;
	private java.lang.String brokerref;
	private boolean ownregion;
	private boolean xinactive;
	private java.lang.String orderstatus;
	private java.lang.Integer datumDays;
	private java.lang.String shipperref;
	private java.lang.String quotno;
	private java.lang.String companykey;
	private java.lang.String mainchargeccykey;
	private java.lang.String ldgg1key2;
	private java.lang.String dchlocationkey2;
	private java.lang.String dchg4key2;
	private java.lang.String dchg3key2;
	private java.lang.Integer dmrgfreedaysleft;
	private java.lang.String faxno;
	private java.lang.String ldgtotime;
	private java.math.BigDecimal costtotal;
	private boolean oblflag;
	private java.lang.String dmrgccykey;
	private java.lang.Integer dmrgdays1;
	private java.lang.String eqpidkey3;
	private java.lang.String cutofftime;
	private java.lang.String dmrglocationkey;
	private java.util.Date ldgfromdate;
	private java.lang.String ldgg4key2;
	private java.lang.String ldgport;
	private java.util.Date dchfromdate;
	private java.lang.String departmentkey;
	private java.lang.String ldgg2key1;
	private java.util.Date orderdate;
	private java.lang.Integer numberoftanks;
	private java.lang.Long dchtotimeinmillis;
	private java.lang.Integer dmrgfreedays;
	private boolean prepaid;
	private boolean rtmFlag;
	private java.lang.String dchg1key2;
	private java.lang.String systemlogtime;
	private java.util.Date exchgdate;
	private java.math.BigDecimal dmrgdlyrate2;
	private java.lang.Long dchfromtimeinmillis;
	private java.lang.String delterm;
	private java.math.BigDecimal ovrhdpctg;
	private java.lang.String ldgg4key1;
	private java.math.BigDecimal dmrgdlyrate3;
	private java.lang.String createtime;
	private java.lang.String bookingnumber;
	private java.lang.String consignmentno;
	private java.lang.String xlock;
	private java.lang.String ldgg3key1;
	private java.lang.String customercontactkey;
	private java.lang.String dchg1key1;
	private java.lang.String notes;
	private java.lang.String ordertype;
	private java.lang.String brokeraddrkey;
	private java.lang.String dedicode;
	private java.lang.String consigneeref;
	private java.lang.String dchfromtime;
	private boolean heating;
	private boolean minProfAcceptFlag;
	private java.lang.String trmode;
	private java.lang.Long ldgfromtimeinmillis;
	private java.lang.String hbltype;
	private java.lang.String ldgfromtime;
	private java.util.Date ldgtodate;
	private java.lang.String liaison;
	private java.lang.String mainchargekey;
	private java.lang.String consigneeaddrkey;
	private java.lang.Long ldgtotimeinmillis;
	private java.lang.String shipmethod;
	private java.math.BigDecimal dmrgdlyrate1;
	private java.lang.String fwdagentaddrkey;
	private java.lang.String rtmReason;
	private java.lang.String ldgg2key2;
	private java.lang.String createuserid;
	private java.lang.String itnumber;
	private java.lang.String customerref;
	private java.util.Date createdate;
	private java.lang.String dchtotime;
	private boolean clncert;
	private java.lang.Integer rowid;
	private java.lang.String invoicegroupref;
	private java.lang.String activitykey;
	private java.lang.String dchg2key2;
	private java.lang.String fwdagentref;
	private java.lang.String orderno;
	private java.lang.String customeraddrkey;
	private java.lang.String dmrgbilltoaddrkey;
	private java.lang.String incotermkey;
	private java.util.Date documentclosingdate;
	private java.util.Date tankclosingdate;
	private java.lang.String deliveryterminaltext;
	private java.lang.String contracttype;
	private java.lang.String shipvendoraddrkey;
	private java.lang.String shipvessel;
	private java.lang.String shipvoyage;
	private boolean completeflag;
	private java.util.Date completedate;
	private java.lang.String completeuserid;
	private java.lang.String completetime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ORDERHDR_ID"
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
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: QUOHDR_ID
	 */
	public java.lang.Integer getQuohdrId () {
		return quohdrId;
	}

	/**
	 * Set the value related to the column: QUOHDR_ID
	 * @param quohdrId the QUOHDR_ID value
	 */
	public void setQuohdrId (java.lang.Integer quohdrId) {
		this.quohdrId = quohdrId;
	}



	/**
	 * Return the value associated with the column: invoicestatus
	 */
	public java.lang.String getInvoicestatus () {
		return invoicestatus;
	}

	/**
	 * Set the value related to the column: invoicestatus
	 * @param invoicestatus the invoicestatus value
	 */
	public void setInvoicestatus (java.lang.String invoicestatus) {
		this.invoicestatus = invoicestatus;
	}



	/**
	 * Return the value associated with the column: systemlogprogram
	 */
	public java.lang.String getSystemlogprogram () {
		return systemlogprogram;
	}

	/**
	 * Set the value related to the column: systemlogprogram
	 * @param systemlogprogram the systemlogprogram value
	 */
	public void setSystemlogprogram (java.lang.String systemlogprogram) {
		this.systemlogprogram = systemlogprogram;
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
	 * Return the value associated with the column: systemlogaction
	 */
	public java.lang.String getSystemlogaction () {
		return systemlogaction;
	}

	/**
	 * Set the value related to the column: systemlogaction
	 * @param systemlogaction the systemlogaction value
	 */
	public void setSystemlogaction (java.lang.String systemlogaction) {
		this.systemlogaction = systemlogaction;
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
	 * Return the value associated with the column: systemlogdate
	 */
	public java.util.Date getSystemlogdate () {
		return systemlogdate;
	}

	/**
	 * Set the value related to the column: systemlogdate
	 * @param systemlogdate the systemlogdate value
	 */
	public void setSystemlogdate (java.util.Date systemlogdate) {
		this.systemlogdate = systemlogdate;
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
	 * Return the value associated with the column: orderbyuserid
	 */
	public java.lang.String getOrderbyuserid () {
		return orderbyuserid;
	}

	/**
	 * Set the value related to the column: orderbyuserid
	 * @param orderbyuserid the orderbyuserid value
	 */
	public void setOrderbyuserid (java.lang.String orderbyuserid) {
		this.orderbyuserid = orderbyuserid;
	}



	/**
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (java.lang.String productkey) {
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
	 * Return the value associated with the column: cutoffdate
	 */
	public java.util.Date getCutoffdate () {
		return cutoffdate;
	}

	/**
	 * Set the value related to the column: cutoffdate
	 * @param cutoffdate the cutoffdate value
	 */
	public void setCutoffdate (java.util.Date cutoffdate) {
		this.cutoffdate = cutoffdate;
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
	 * Return the value associated with the column: mainchargeamount
	 */
	public java.math.BigDecimal getMainchargeamount () {
		return mainchargeamount;
	}

	/**
	 * Set the value related to the column: mainchargeamount
	 * @param mainchargeamount the mainchargeamount value
	 */
	public void setMainchargeamount (java.math.BigDecimal mainchargeamount) {
		this.mainchargeamount = mainchargeamount;
	}



	/**
	 * Return the value associated with the column: dchtodate
	 */
	public java.util.Date getDchtodate () {
		return dchtodate;
	}

	/**
	 * Set the value related to the column: dchtodate
	 * @param dchtodate the dchtodate value
	 */
	public void setDchtodate (java.util.Date dchtodate) {
		this.dchtodate = dchtodate;
	}



	/**
	 * Return the value associated with the column: CHARGETOTAL
	 */
	public java.math.BigDecimal getChargetotal () {
		return chargetotal;
	}

	/**
	 * Set the value related to the column: CHARGETOTAL
	 * @param chargetotal the CHARGETOTAL value
	 */
	public void setChargetotal (java.math.BigDecimal chargetotal) {
		this.chargetotal = chargetotal;
	}



	/**
	 * Return the value associated with the column: ldglocationkey1
	 */
	public java.lang.String getLdglocationkey1 () {
		return ldglocationkey1;
	}

	/**
	 * Set the value related to the column: ldglocationkey1
	 * @param ldglocationkey1 the ldglocationkey1 value
	 */
	public void setLdglocationkey1 (java.lang.String ldglocationkey1) {
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
	 * Return the value associated with the column: ldglocationkey2
	 */
	public java.lang.String getLdglocationkey2 () {
		return ldglocationkey2;
	}

	/**
	 * Set the value related to the column: ldglocationkey2
	 * @param ldglocationkey2 the ldglocationkey2 value
	 */
	public void setLdglocationkey2 (java.lang.String ldglocationkey2) {
		this.ldglocationkey2 = ldglocationkey2;
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
	 * Return the value associated with the column: ohblflag
	 */
	public boolean isOhblflag () {
		return ohblflag;
	}

	/**
	 * Set the value related to the column: ohblflag
	 * @param ohblflag the ohblflag value
	 */
	public void setOhblflag (boolean ohblflag) {
		this.ohblflag = ohblflag;
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
	 * Return the value associated with the column: systemloguserid
	 */
	public java.lang.String getSystemloguserid () {
		return systemloguserid;
	}

	/**
	 * Set the value related to the column: systemloguserid
	 * @param systemloguserid the systemloguserid value
	 */
	public void setSystemloguserid (java.lang.String systemloguserid) {
		this.systemloguserid = systemloguserid;
	}



	/**
	 * Return the value associated with the column: dchlocationkey1
	 */
	public java.lang.String getDchlocationkey1 () {
		return dchlocationkey1;
	}

	/**
	 * Set the value related to the column: dchlocationkey1
	 * @param dchlocationkey1 the dchlocationkey1 value
	 */
	public void setDchlocationkey1 (java.lang.String dchlocationkey1) {
		this.dchlocationkey1 = dchlocationkey1;
	}



	/**
	 * Return the value associated with the column: emptytankrepoflag
	 */
	public boolean isEmptytankrepoflag () {
		return emptytankrepoflag;
	}

	/**
	 * Set the value related to the column: emptytankrepoflag
	 * @param emptytankrepoflag the emptytankrepoflag value
	 */
	public void setEmptytankrepoflag (boolean emptytankrepoflag) {
		this.emptytankrepoflag = emptytankrepoflag;
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
	 * Return the value associated with the column: xinactive
	 */
	public boolean isXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (boolean xinactive) {
		this.xinactive = xinactive;
	}



	/**
	 * Return the value associated with the column: orderstatus
	 */
	public java.lang.String getOrderstatus () {
		return orderstatus;
	}

	/**
	 * Set the value related to the column: orderstatus
	 * @param orderstatus the orderstatus value
	 */
	public void setOrderstatus (java.lang.String orderstatus) {
		this.orderstatus = orderstatus;
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
	public java.lang.String getDchlocationkey2 () {
		return dchlocationkey2;
	}

	/**
	 * Set the value related to the column: dchlocationkey2
	 * @param dchlocationkey2 the dchlocationkey2 value
	 */
	public void setDchlocationkey2 (java.lang.String dchlocationkey2) {
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
	 * Return the value associated with the column: ldgtotime
	 */
	public java.lang.String getLdgtotime () {
		return ldgtotime;
	}

	/**
	 * Set the value related to the column: ldgtotime
	 * @param ldgtotime the ldgtotime value
	 */
	public void setLdgtotime (java.lang.String ldgtotime) {
		this.ldgtotime = ldgtotime;
	}



	/**
	 * Return the value associated with the column: COSTTOTAL
	 */
	public java.math.BigDecimal getCosttotal () {
		return costtotal;
	}

	/**
	 * Set the value related to the column: COSTTOTAL
	 * @param costtotal the COSTTOTAL value
	 */
	public void setCosttotal (java.math.BigDecimal costtotal) {
		this.costtotal = costtotal;
	}



	/**
	 * Return the value associated with the column: oblflag
	 */
	public boolean isOblflag () {
		return oblflag;
	}

	/**
	 * Set the value related to the column: oblflag
	 * @param oblflag the oblflag value
	 */
	public void setOblflag (boolean oblflag) {
		this.oblflag = oblflag;
	}



	/**
	 * Return the value associated with the column: dmrgccykey
	 */
	public java.lang.String getDmrgccykey () {
		return dmrgccykey;
	}

	/**
	 * Set the value related to the column: dmrgccykey
	 * @param dmrgccykey the dmrgccykey value
	 */
	public void setDmrgccykey (java.lang.String dmrgccykey) {
		this.dmrgccykey = dmrgccykey;
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
	 * Return the value associated with the column: cutofftime
	 */
	public java.lang.String getCutofftime () {
		return cutofftime;
	}

	/**
	 * Set the value related to the column: cutofftime
	 * @param cutofftime the cutofftime value
	 */
	public void setCutofftime (java.lang.String cutofftime) {
		this.cutofftime = cutofftime;
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
	 * Return the value associated with the column: ldgfromdate
	 */
	public java.util.Date getLdgfromdate () {
		return ldgfromdate;
	}

	/**
	 * Set the value related to the column: ldgfromdate
	 * @param ldgfromdate the ldgfromdate value
	 */
	public void setLdgfromdate (java.util.Date ldgfromdate) {
		this.ldgfromdate = ldgfromdate;
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
	 * Return the value associated with the column: dchfromdate
	 */
	public java.util.Date getDchfromdate () {
		return dchfromdate;
	}

	/**
	 * Set the value related to the column: dchfromdate
	 * @param dchfromdate the dchfromdate value
	 */
	public void setDchfromdate (java.util.Date dchfromdate) {
		this.dchfromdate = dchfromdate;
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
	 * Return the value associated with the column: orderdate
	 */
	public java.util.Date getOrderdate () {
		return orderdate;
	}

	/**
	 * Set the value related to the column: orderdate
	 * @param orderdate the orderdate value
	 */
	public void setOrderdate (java.util.Date orderdate) {
		this.orderdate = orderdate;
	}



	/**
	 * Return the value associated with the column: numberoftanks
	 */
	public java.lang.Integer getNumberoftanks () {
		return numberoftanks;
	}

	/**
	 * Set the value related to the column: numberoftanks
	 * @param numberoftanks the numberoftanks value
	 */
	public void setNumberoftanks (java.lang.Integer numberoftanks) {
		this.numberoftanks = numberoftanks;
	}



	/**
	 * Return the value associated with the column: dchtotimeinmillis
	 */
	public java.lang.Long getDchtotimeinmillis () {
		return dchtotimeinmillis;
	}

	/**
	 * Set the value related to the column: dchtotimeinmillis
	 * @param dchtotimeinmillis the dchtotimeinmillis value
	 */
	public void setDchtotimeinmillis (java.lang.Long dchtotimeinmillis) {
		this.dchtotimeinmillis = dchtotimeinmillis;
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
	 * Return the value associated with the column: dchfromtimeinmillis
	 */
	public java.lang.Long getDchfromtimeinmillis () {
		return dchfromtimeinmillis;
	}

	/**
	 * Set the value related to the column: dchfromtimeinmillis
	 * @param dchfromtimeinmillis the dchfromtimeinmillis value
	 */
	public void setDchfromtimeinmillis (java.lang.Long dchfromtimeinmillis) {
		this.dchfromtimeinmillis = dchfromtimeinmillis;
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
	 * Return the value associated with the column: OVRHDPCTG
	 */
	public java.math.BigDecimal getOvrhdpctg () {
		return ovrhdpctg;
	}

	/**
	 * Set the value related to the column: OVRHDPCTG
	 * @param ovrhdpctg the OVRHDPCTG value
	 */
	public void setOvrhdpctg (java.math.BigDecimal ovrhdpctg) {
		this.ovrhdpctg = ovrhdpctg;
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
	 * Return the value associated with the column: bookingnumber
	 */
	public java.lang.String getBookingnumber () {
		return bookingnumber;
	}

	/**
	 * Set the value related to the column: bookingnumber
	 * @param bookingnumber the bookingnumber value
	 */
	public void setBookingnumber (java.lang.String bookingnumber) {
		this.bookingnumber = bookingnumber;
	}



	/**
	 * Return the value associated with the column: consignmentno
	 */
	public java.lang.String getConsignmentno () {
		return consignmentno;
	}

	/**
	 * Set the value related to the column: consignmentno
	 * @param consignmentno the consignmentno value
	 */
	public void setConsignmentno (java.lang.String consignmentno) {
		this.consignmentno = consignmentno;
	}



	/**
	 * Return the value associated with the column: xlock
	 */
	public java.lang.String getXlock () {
		return xlock;
	}

	/**
	 * Set the value related to the column: xlock
	 * @param xlock the xlock value
	 */
	public void setXlock (java.lang.String xlock) {
		this.xlock = xlock;
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
	 * Return the value associated with the column: ordertype
	 */
	public java.lang.String getOrdertype () {
		return ordertype;
	}

	/**
	 * Set the value related to the column: ordertype
	 * @param ordertype the ordertype value
	 */
	public void setOrdertype (java.lang.String ordertype) {
		this.ordertype = ordertype;
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
	public java.lang.String getDedicode () {
		return dedicode;
	}

	/**
	 * Set the value related to the column: DEDICODE
	 * @param dedicode the DEDICODE value
	 */
	public void setDedicode (java.lang.String dedicode) {
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
	 * Return the value associated with the column: dchfromtime
	 */
	public java.lang.String getDchfromtime () {
		return dchfromtime;
	}

	/**
	 * Set the value related to the column: dchfromtime
	 * @param dchfromtime the dchfromtime value
	 */
	public void setDchfromtime (java.lang.String dchfromtime) {
		this.dchfromtime = dchfromtime;
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
	 * Return the value associated with the column: ldgfromtimeinmillis
	 */
	public java.lang.Long getLdgfromtimeinmillis () {
		return ldgfromtimeinmillis;
	}

	/**
	 * Set the value related to the column: ldgfromtimeinmillis
	 * @param ldgfromtimeinmillis the ldgfromtimeinmillis value
	 */
	public void setLdgfromtimeinmillis (java.lang.Long ldgfromtimeinmillis) {
		this.ldgfromtimeinmillis = ldgfromtimeinmillis;
	}



	/**
	 * Return the value associated with the column: hbltype
	 */
	public java.lang.String getHbltype () {
		return hbltype;
	}

	/**
	 * Set the value related to the column: hbltype
	 * @param hbltype the hbltype value
	 */
	public void setHbltype (java.lang.String hbltype) {
		this.hbltype = hbltype;
	}



	/**
	 * Return the value associated with the column: ldgfromtime
	 */
	public java.lang.String getLdgfromtime () {
		return ldgfromtime;
	}

	/**
	 * Set the value related to the column: ldgfromtime
	 * @param ldgfromtime the ldgfromtime value
	 */
	public void setLdgfromtime (java.lang.String ldgfromtime) {
		this.ldgfromtime = ldgfromtime;
	}



	/**
	 * Return the value associated with the column: ldgtodate
	 */
	public java.util.Date getLdgtodate () {
		return ldgtodate;
	}

	/**
	 * Set the value related to the column: ldgtodate
	 * @param ldgtodate the ldgtodate value
	 */
	public void setLdgtodate (java.util.Date ldgtodate) {
		this.ldgtodate = ldgtodate;
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
	 * Return the value associated with the column: ldgtotimeinmillis
	 */
	public java.lang.Long getLdgtotimeinmillis () {
		return ldgtotimeinmillis;
	}

	/**
	 * Set the value related to the column: ldgtotimeinmillis
	 * @param ldgtotimeinmillis the ldgtotimeinmillis value
	 */
	public void setLdgtotimeinmillis (java.lang.Long ldgtotimeinmillis) {
		this.ldgtotimeinmillis = ldgtotimeinmillis;
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
	 * Return the value associated with the column: itnumber
	 */
	public java.lang.String getItnumber () {
		return itnumber;
	}

	/**
	 * Set the value related to the column: itnumber
	 * @param itnumber the itnumber value
	 */
	public void setItnumber (java.lang.String itnumber) {
		this.itnumber = itnumber;
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
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: dchtotime
	 */
	public java.lang.String getDchtotime () {
		return dchtotime;
	}

	/**
	 * Set the value related to the column: dchtotime
	 * @param dchtotime the dchtotime value
	 */
	public void setDchtotime (java.lang.String dchtotime) {
		this.dchtotime = dchtotime;
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
	 * Return the value associated with the column: rowid
	 */
	public java.lang.Integer getRowid () {
		return rowid;
	}

	/**
	 * Set the value related to the column: rowid
	 * @param rowid the rowid value
	 */
	public void setRowid (java.lang.Integer rowid) {
		this.rowid = rowid;
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
	 * Return the value associated with the column: orderno
	 */
	public java.lang.String getOrderno () {
		return orderno;
	}

	/**
	 * Set the value related to the column: orderno
	 * @param orderno the orderno value
	 */
	public void setOrderno (java.lang.String orderno) {
		this.orderno = orderno;
	}



	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public java.lang.String getCustomeraddrkey () {
		return customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (java.lang.String customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}



	/**
	 * Return the value associated with the column: dmrgbilltoaddrkey
	 */
	public java.lang.String getDmrgbilltoaddrkey () {
		return dmrgbilltoaddrkey;
	}

	/**
	 * Set the value related to the column: dmrgbilltoaddrkey
	 * @param dmrgbilltoaddrkey the dmrgbilltoaddrkey value
	 */
	public void setDmrgbilltoaddrkey (java.lang.String dmrgbilltoaddrkey) {
		this.dmrgbilltoaddrkey = dmrgbilltoaddrkey;
	}



	/**
	 * Return the value associated with the column: incotermkey
	 */
	public java.lang.String getIncotermkey () {
		return incotermkey;
	}

	/**
	 * Set the value related to the column: incotermkey
	 * @param incotermkey the incotermkey value
	 */
	public void setIncotermkey (java.lang.String incotermkey) {
		this.incotermkey = incotermkey;
	}



	/**
	 * Return the value associated with the column: documentclosingdate
	 */
	public java.util.Date getDocumentclosingdate () {
		return documentclosingdate;
	}

	/**
	 * Set the value related to the column: documentclosingdate
	 * @param documentclosingdate the documentclosingdate value
	 */
	public void setDocumentclosingdate (java.util.Date documentclosingdate) {
		this.documentclosingdate = documentclosingdate;
	}



	/**
	 * Return the value associated with the column: tankclosingdate
	 */
	public java.util.Date getTankclosingdate () {
		return tankclosingdate;
	}

	/**
	 * Set the value related to the column: tankclosingdate
	 * @param tankclosingdate the tankclosingdate value
	 */
	public void setTankclosingdate (java.util.Date tankclosingdate) {
		this.tankclosingdate = tankclosingdate;
	}



	/**
	 * Return the value associated with the column: deliveryterminaltext
	 */
	public java.lang.String getDeliveryterminaltext () {
		return deliveryterminaltext;
	}

	/**
	 * Set the value related to the column: deliveryterminaltext
	 * @param deliveryterminaltext the deliveryterminaltext value
	 */
	public void setDeliveryterminaltext (java.lang.String deliveryterminaltext) {
		this.deliveryterminaltext = deliveryterminaltext;
	}



	/**
	 * Return the value associated with the column: contracttype
	 */
	public java.lang.String getContracttype () {
		return contracttype;
	}

	/**
	 * Set the value related to the column: contracttype
	 * @param contracttype the contracttype value
	 */
	public void setContracttype (java.lang.String contracttype) {
		this.contracttype = contracttype;
	}



	/**
	 * Return the value associated with the column: shipvendoraddrkey
	 */
	public java.lang.String getShipvendoraddrkey () {
		return shipvendoraddrkey;
	}

	/**
	 * Set the value related to the column: shipvendoraddrkey
	 * @param shipvendoraddrkey the shipvendoraddrkey value
	 */
	public void setShipvendoraddrkey (java.lang.String shipvendoraddrkey) {
		this.shipvendoraddrkey = shipvendoraddrkey;
	}



	/**
	 * Return the value associated with the column: shipvessel
	 */
	public java.lang.String getShipvessel () {
		return shipvessel;
	}

	/**
	 * Set the value related to the column: shipvessel
	 * @param shipvessel the shipvessel value
	 */
	public void setShipvessel (java.lang.String shipvessel) {
		this.shipvessel = shipvessel;
	}



	/**
	 * Return the value associated with the column: shipvoyage
	 */
	public java.lang.String getShipvoyage () {
		return shipvoyage;
	}

	/**
	 * Set the value related to the column: shipvoyage
	 * @param shipvoyage the shipvoyage value
	 */
	public void setShipvoyage (java.lang.String shipvoyage) {
		this.shipvoyage = shipvoyage;
	}



	/**
	 * Return the value associated with the column: completeflag
	 */
	public boolean isCompleteflag () {
		return completeflag;
	}

	/**
	 * Set the value related to the column: completeflag
	 * @param completeflag the completeflag value
	 */
	public void setCompleteflag (boolean completeflag) {
		this.completeflag = completeflag;
	}



	/**
	 * Return the value associated with the column: completedate
	 */
	public java.util.Date getCompletedate () {
		return completedate;
	}

	/**
	 * Set the value related to the column: completedate
	 * @param completedate the completedate value
	 */
	public void setCompletedate (java.util.Date completedate) {
		this.completedate = completedate;
	}



	/**
	 * Return the value associated with the column: completeuserid
	 */
	public java.lang.String getCompleteuserid () {
		return completeuserid;
	}

	/**
	 * Set the value related to the column: completeuserid
	 * @param completeuserid the completeuserid value
	 */
	public void setCompleteuserid (java.lang.String completeuserid) {
		this.completeuserid = completeuserid;
	}



	/**
	 * Return the value associated with the column: completetime
	 */
	public java.lang.String getCompletetime () {
		return completetime;
	}

	/**
	 * Set the value related to the column: completetime
	 * @param completetime the completetime value
	 */
	public void setCompletetime (java.lang.String completetime) {
		this.completetime = completetime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.order.Orderhdr)) return false;
		else {
			com.bureaueye.beacon.model.order.Orderhdr orderhdr = (com.bureaueye.beacon.model.order.Orderhdr) obj;
			if (null == this.getId() || null == orderhdr.getId()) return false;
			else return (this.getId().equals(orderhdr.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}