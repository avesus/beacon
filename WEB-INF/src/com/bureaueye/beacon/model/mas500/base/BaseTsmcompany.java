package com.bureaueye.beacon.model.mas500.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tsmcompany table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tsmcompany"
 */

public abstract class BaseTsmcompany  implements Serializable {

	public static String REF = "Tsmcompany";
	public static String PROP_LAST_ARCHIVE = "LastArchive";
	public static String PROP_PATH_TO_LOG = "PathToLog";
	public static String PROP_USE_MULT_LANG = "UseMultLang";
	public static String PROP_V1099_COMB_STATE_FED = "V1099CombStateFed";
	public static String PROP_PHONE = "Phone";
	public static String PROP_INCLUDE_IN_O_L_A_P = "IncludeInOLAP";
	public static String PROP_FED_I_D = "FedID";
	public static String PROP_LOGO_BLOB_KEY = "LogoBlobKey";
	public static String PROP_E_MAIL_ADDR = "EMailAddr";
	public static String PROP_PATH_TO_D_BASE = "PathToDBase";
	public static String PROP_FULL_G_L = "FullGL";
	public static String PROP_COUNTRY_I_D = "CountryID";
	public static String PROP_V1099_XMIT_CTRL_CODE = "V1099XmitCtrlCode";
	public static String PROP_LAST_RECOVER = "LastRecover";
	public static String PROP_CURR_LOCALE = "CurrLocale";
	public static String PROP_CURR_I_D = "CurrID";
	public static String PROP_STATE_TAX_I_D = "StateTaxID";
	public static String PROP_COMPANY_I_D = "CompanyID";
	public static String PROP_D_B_SERVER_NAME = "DBServerName";
	public static String PROP_F_A_X_EXT = "FAXExt";
	public static String PROP_FAX = "Fax";
	public static String PROP_CONTACT = "Contact";
	public static String PROP_PATH_TO_ARCHIVE = "PathToArchive";
	public static String PROP_PHONE_EXT = "PhoneExt";
	public static String PROP_COUNTRY_CURR_LOCALE = "CountryCurrLocale";
	public static String PROP_COMPANY_NAME = "CompanyName";
	public static String PROP_CITY = "City";
	public static String PROP_V1099_PAYER_NAME_CTRL = "V1099PayerNameCtrl";
	public static String PROP_DEMO_DATA = "DemoData";
	public static String PROP_ADDR_LINE3 = "AddrLine3";
	public static String PROP_ADDR_LINE4 = "AddrLine4";
	public static String PROP_ADDR_LINE1 = "AddrLine1";
	public static String PROP_ADDR_LINE2 = "AddrLine2";
	public static String PROP_POSTAL_CODE = "PostalCode";
	public static String PROP_STATE_I_D = "StateID";


	// constructors
	public BaseTsmcompany () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTsmcompany (java.lang.String companyID) {
		this.setCompanyID(companyID);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String companyID;

	// fields
	private java.lang.Short useMultLang;
	private java.lang.String pathToLog;
	private java.util.Date lastArchive;
	private java.lang.Short v1099CombStateFed;
	private java.lang.String phone;
	private java.lang.Short includeInOLAP;
	private java.lang.String fedID;
	private java.lang.String eMailAddr;
	private java.lang.Integer logoBlobKey;
	private java.lang.String pathToDBase;
	private java.lang.Short fullGL;
	private java.lang.String v1099XmitCtrlCode;
	private java.lang.String countryID;
	private java.util.Date lastRecover;
	private java.lang.Integer currLocale;
	private java.lang.String currID;
	private java.lang.String fax;
	private java.lang.String stateTaxID;
	private java.lang.String dBServerName;
	private java.lang.String fAXExt;
	private java.lang.String contact;
	private java.lang.String pathToArchive;
	private java.lang.String phoneExt;
	private java.lang.Integer countryCurrLocale;
	private java.lang.String companyName;
	private java.lang.String city;
	private java.lang.String v1099PayerNameCtrl;
	private java.lang.String addrLine3;
	private java.lang.String demoData;
	private java.lang.String addrLine4;
	private java.lang.String addrLine1;
	private java.lang.String postalCode;
	private java.lang.String addrLine2;
	private java.lang.String stateID;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CompanyID"
     */
	public java.lang.String getCompanyID () {
		return companyID;
	}

	/**
	 * Set the unique identifier of this class
	 * @param companyID the new ID
	 */
	public void setCompanyID (java.lang.String companyID) {
		this.companyID = companyID;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: UseMultLang
	 */
	public java.lang.Short getUseMultLang () {
		return useMultLang;
	}

	/**
	 * Set the value related to the column: UseMultLang
	 * @param useMultLang the UseMultLang value
	 */
	public void setUseMultLang (java.lang.Short useMultLang) {
		this.useMultLang = useMultLang;
	}



	/**
	 * Return the value associated with the column: PathToLog
	 */
	public java.lang.String getPathToLog () {
		return pathToLog;
	}

	/**
	 * Set the value related to the column: PathToLog
	 * @param pathToLog the PathToLog value
	 */
	public void setPathToLog (java.lang.String pathToLog) {
		this.pathToLog = pathToLog;
	}



	/**
	 * Return the value associated with the column: LastArchive
	 */
	public java.util.Date getLastArchive () {
		return lastArchive;
	}

	/**
	 * Set the value related to the column: LastArchive
	 * @param lastArchive the LastArchive value
	 */
	public void setLastArchive (java.util.Date lastArchive) {
		this.lastArchive = lastArchive;
	}



	/**
	 * Return the value associated with the column: V1099CombStateFed
	 */
	public java.lang.Short getV1099CombStateFed () {
		return v1099CombStateFed;
	}

	/**
	 * Set the value related to the column: V1099CombStateFed
	 * @param v1099CombStateFed the V1099CombStateFed value
	 */
	public void setV1099CombStateFed (java.lang.Short v1099CombStateFed) {
		this.v1099CombStateFed = v1099CombStateFed;
	}



	/**
	 * Return the value associated with the column: Phone
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: Phone
	 * @param phone the Phone value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the value associated with the column: IncludeInOLAP
	 */
	public java.lang.Short getIncludeInOLAP () {
		return includeInOLAP;
	}

	/**
	 * Set the value related to the column: IncludeInOLAP
	 * @param includeInOLAP the IncludeInOLAP value
	 */
	public void setIncludeInOLAP (java.lang.Short includeInOLAP) {
		this.includeInOLAP = includeInOLAP;
	}



	/**
	 * Return the value associated with the column: FedID
	 */
	public java.lang.String getFedID () {
		return fedID;
	}

	/**
	 * Set the value related to the column: FedID
	 * @param fedID the FedID value
	 */
	public void setFedID (java.lang.String fedID) {
		this.fedID = fedID;
	}



	/**
	 * Return the value associated with the column: EMailAddr
	 */
	public java.lang.String getEMailAddr () {
		return eMailAddr;
	}

	/**
	 * Set the value related to the column: EMailAddr
	 * @param eMailAddr the EMailAddr value
	 */
	public void setEMailAddr (java.lang.String eMailAddr) {
		this.eMailAddr = eMailAddr;
	}



	/**
	 * Return the value associated with the column: LogoBlobKey
	 */
	public java.lang.Integer getLogoBlobKey () {
		return logoBlobKey;
	}

	/**
	 * Set the value related to the column: LogoBlobKey
	 * @param logoBlobKey the LogoBlobKey value
	 */
	public void setLogoBlobKey (java.lang.Integer logoBlobKey) {
		this.logoBlobKey = logoBlobKey;
	}



	/**
	 * Return the value associated with the column: PathToDBase
	 */
	public java.lang.String getPathToDBase () {
		return pathToDBase;
	}

	/**
	 * Set the value related to the column: PathToDBase
	 * @param pathToDBase the PathToDBase value
	 */
	public void setPathToDBase (java.lang.String pathToDBase) {
		this.pathToDBase = pathToDBase;
	}



	/**
	 * Return the value associated with the column: FullGL
	 */
	public java.lang.Short getFullGL () {
		return fullGL;
	}

	/**
	 * Set the value related to the column: FullGL
	 * @param fullGL the FullGL value
	 */
	public void setFullGL (java.lang.Short fullGL) {
		this.fullGL = fullGL;
	}



	/**
	 * Return the value associated with the column: V1099XmitCtrlCode
	 */
	public java.lang.String getV1099XmitCtrlCode () {
		return v1099XmitCtrlCode;
	}

	/**
	 * Set the value related to the column: V1099XmitCtrlCode
	 * @param v1099XmitCtrlCode the V1099XmitCtrlCode value
	 */
	public void setV1099XmitCtrlCode (java.lang.String v1099XmitCtrlCode) {
		this.v1099XmitCtrlCode = v1099XmitCtrlCode;
	}



	/**
	 * Return the value associated with the column: CountryID
	 */
	public java.lang.String getCountryID () {
		return countryID;
	}

	/**
	 * Set the value related to the column: CountryID
	 * @param countryID the CountryID value
	 */
	public void setCountryID (java.lang.String countryID) {
		this.countryID = countryID;
	}



	/**
	 * Return the value associated with the column: LastRecover
	 */
	public java.util.Date getLastRecover () {
		return lastRecover;
	}

	/**
	 * Set the value related to the column: LastRecover
	 * @param lastRecover the LastRecover value
	 */
	public void setLastRecover (java.util.Date lastRecover) {
		this.lastRecover = lastRecover;
	}



	/**
	 * Return the value associated with the column: CurrLocale
	 */
	public java.lang.Integer getCurrLocale () {
		return currLocale;
	}

	/**
	 * Set the value related to the column: CurrLocale
	 * @param currLocale the CurrLocale value
	 */
	public void setCurrLocale (java.lang.Integer currLocale) {
		this.currLocale = currLocale;
	}



	/**
	 * Return the value associated with the column: CurrID
	 */
	public java.lang.String getCurrID () {
		return currID;
	}

	/**
	 * Set the value related to the column: CurrID
	 * @param currID the CurrID value
	 */
	public void setCurrID (java.lang.String currID) {
		this.currID = currID;
	}



	/**
	 * Return the value associated with the column: FAX
	 */
	public java.lang.String getFax () {
		return fax;
	}

	/**
	 * Set the value related to the column: FAX
	 * @param fax the FAX value
	 */
	public void setFax (java.lang.String fax) {
		this.fax = fax;
	}



	/**
	 * Return the value associated with the column: StateTaxID
	 */
	public java.lang.String getStateTaxID () {
		return stateTaxID;
	}

	/**
	 * Set the value related to the column: StateTaxID
	 * @param stateTaxID the StateTaxID value
	 */
	public void setStateTaxID (java.lang.String stateTaxID) {
		this.stateTaxID = stateTaxID;
	}



	/**
	 * Return the value associated with the column: DBServerName
	 */
	public java.lang.String getDBServerName () {
		return dBServerName;
	}

	/**
	 * Set the value related to the column: DBServerName
	 * @param dBServerName the DBServerName value
	 */
	public void setDBServerName (java.lang.String dBServerName) {
		this.dBServerName = dBServerName;
	}



	/**
	 * Return the value associated with the column: FAXExt
	 */
	public java.lang.String getFAXExt () {
		return fAXExt;
	}

	/**
	 * Set the value related to the column: FAXExt
	 * @param fAXExt the FAXExt value
	 */
	public void setFAXExt (java.lang.String fAXExt) {
		this.fAXExt = fAXExt;
	}



	/**
	 * Return the value associated with the column: Contact
	 */
	public java.lang.String getContact () {
		return contact;
	}

	/**
	 * Set the value related to the column: Contact
	 * @param contact the Contact value
	 */
	public void setContact (java.lang.String contact) {
		this.contact = contact;
	}



	/**
	 * Return the value associated with the column: PathToArchive
	 */
	public java.lang.String getPathToArchive () {
		return pathToArchive;
	}

	/**
	 * Set the value related to the column: PathToArchive
	 * @param pathToArchive the PathToArchive value
	 */
	public void setPathToArchive (java.lang.String pathToArchive) {
		this.pathToArchive = pathToArchive;
	}



	/**
	 * Return the value associated with the column: PhoneExt
	 */
	public java.lang.String getPhoneExt () {
		return phoneExt;
	}

	/**
	 * Set the value related to the column: PhoneExt
	 * @param phoneExt the PhoneExt value
	 */
	public void setPhoneExt (java.lang.String phoneExt) {
		this.phoneExt = phoneExt;
	}



	/**
	 * Return the value associated with the column: CountryCurrLocale
	 */
	public java.lang.Integer getCountryCurrLocale () {
		return countryCurrLocale;
	}

	/**
	 * Set the value related to the column: CountryCurrLocale
	 * @param countryCurrLocale the CountryCurrLocale value
	 */
	public void setCountryCurrLocale (java.lang.Integer countryCurrLocale) {
		this.countryCurrLocale = countryCurrLocale;
	}



	/**
	 * Return the value associated with the column: CompanyName
	 */
	public java.lang.String getCompanyName () {
		return companyName;
	}

	/**
	 * Set the value related to the column: CompanyName
	 * @param companyName the CompanyName value
	 */
	public void setCompanyName (java.lang.String companyName) {
		this.companyName = companyName;
	}



	/**
	 * Return the value associated with the column: City
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: City
	 * @param city the City value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: V1099PayerNameCtrl
	 */
	public java.lang.String getV1099PayerNameCtrl () {
		return v1099PayerNameCtrl;
	}

	/**
	 * Set the value related to the column: V1099PayerNameCtrl
	 * @param v1099PayerNameCtrl the V1099PayerNameCtrl value
	 */
	public void setV1099PayerNameCtrl (java.lang.String v1099PayerNameCtrl) {
		this.v1099PayerNameCtrl = v1099PayerNameCtrl;
	}



	/**
	 * Return the value associated with the column: AddrLine3
	 */
	public java.lang.String getAddrLine3 () {
		return addrLine3;
	}

	/**
	 * Set the value related to the column: AddrLine3
	 * @param addrLine3 the AddrLine3 value
	 */
	public void setAddrLine3 (java.lang.String addrLine3) {
		this.addrLine3 = addrLine3;
	}



	/**
	 * Return the value associated with the column: DemoData
	 */
	public java.lang.String getDemoData () {
		return demoData;
	}

	/**
	 * Set the value related to the column: DemoData
	 * @param demoData the DemoData value
	 */
	public void setDemoData (java.lang.String demoData) {
		this.demoData = demoData;
	}



	/**
	 * Return the value associated with the column: AddrLine4
	 */
	public java.lang.String getAddrLine4 () {
		return addrLine4;
	}

	/**
	 * Set the value related to the column: AddrLine4
	 * @param addrLine4 the AddrLine4 value
	 */
	public void setAddrLine4 (java.lang.String addrLine4) {
		this.addrLine4 = addrLine4;
	}



	/**
	 * Return the value associated with the column: AddrLine1
	 */
	public java.lang.String getAddrLine1 () {
		return addrLine1;
	}

	/**
	 * Set the value related to the column: AddrLine1
	 * @param addrLine1 the AddrLine1 value
	 */
	public void setAddrLine1 (java.lang.String addrLine1) {
		this.addrLine1 = addrLine1;
	}



	/**
	 * Return the value associated with the column: PostalCode
	 */
	public java.lang.String getPostalCode () {
		return postalCode;
	}

	/**
	 * Set the value related to the column: PostalCode
	 * @param postalCode the PostalCode value
	 */
	public void setPostalCode (java.lang.String postalCode) {
		this.postalCode = postalCode;
	}



	/**
	 * Return the value associated with the column: AddrLine2
	 */
	public java.lang.String getAddrLine2 () {
		return addrLine2;
	}

	/**
	 * Set the value related to the column: AddrLine2
	 * @param addrLine2 the AddrLine2 value
	 */
	public void setAddrLine2 (java.lang.String addrLine2) {
		this.addrLine2 = addrLine2;
	}



	/**
	 * Return the value associated with the column: StateID
	 */
	public java.lang.String getStateID () {
		return stateID;
	}

	/**
	 * Set the value related to the column: StateID
	 * @param stateID the StateID value
	 */
	public void setStateID (java.lang.String stateID) {
		this.stateID = stateID;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mas500.Tsmcompany)) return false;
		else {
			com.bureaueye.beacon.model.mas500.Tsmcompany tsmcompany = (com.bureaueye.beacon.model.mas500.Tsmcompany) obj;
			if (null == this.getCompanyID() || null == tsmcompany.getCompanyID()) return false;
			else return (this.getCompanyID().equals(tsmcompany.getCompanyID()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCompanyID()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCompanyID().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}