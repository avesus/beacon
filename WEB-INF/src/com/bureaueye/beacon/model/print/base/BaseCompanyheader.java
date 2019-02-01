package com.bureaueye.beacon.model.print.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the companyheader table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="companyheader"
 */

public abstract class BaseCompanyheader  implements Serializable {

	public static String REF = "Companyheader";
	public static String PROP_PHONE = "Phone";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_LOGO = "Logo";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_COMPANYHEADER_ID = "CompanyheaderId";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_SIGNATUREIMAGE = "Signatureimage";
	public static String PROP_HEADER_NAME = "HeaderName";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_OFFICENAME = "Officename";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_WEBSITE = "Website";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_FAX = "Fax";
	public static String PROP_CITY_POSTALCODE = "CityPostalcode";
	public static String PROP_COMPANY_NAME = "CompanyName";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_CITY = "City";
	public static String PROP_POSTAL_CODE = "PostalCode";
	public static String PROP_EMAIL = "Email";
	public static String PROP_STATE = "State";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseCompanyheader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCompanyheader (java.lang.Integer companyheaderId) {
		this.setCompanyheaderId(companyheaderId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer companyheaderId;

	// fields
	private java.lang.String postalCode;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String systemloguserid;
	private java.lang.String state;
	private java.util.Date systemlogdate;
	private java.lang.String createuserid;
	private java.lang.String city;
	private java.lang.String logo;
	private java.lang.String phone;
	private java.lang.String headerName;
	private boolean xinactive;
	private java.lang.String email;
	private java.lang.String description;
	private java.lang.String fax;
	private java.lang.String address;
	private java.util.Date createdate;
	private java.lang.String systemlogtime;
	private java.lang.String country;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.lang.String companyName;
	private java.lang.String signatureimage;
	private java.lang.String cityPostalcode;
	private java.lang.String officename;
	private java.lang.String website;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="COMPANYHEADER_ID"
     */
	public java.lang.Integer getCompanyheaderId () {
		return companyheaderId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param companyheaderId the new ID
	 */
	public void setCompanyheaderId (java.lang.Integer companyheaderId) {
		this.companyheaderId = companyheaderId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: State
	 */
	public java.lang.String getState () {
		return state;
	}

	/**
	 * Set the value related to the column: State
	 * @param state the State value
	 */
	public void setState (java.lang.String state) {
		this.state = state;
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
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
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
	 * Return the value associated with the column: logo
	 */
	public java.lang.String getLogo () {
		return logo;
	}

	/**
	 * Set the value related to the column: logo
	 * @param logo the logo value
	 */
	public void setLogo (java.lang.String logo) {
		this.logo = logo;
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
	 * Return the value associated with the column: HeaderName
	 */
	public java.lang.String getHeaderName () {
		return headerName;
	}

	/**
	 * Set the value related to the column: HeaderName
	 * @param headerName the HeaderName value
	 */
	public void setHeaderName (java.lang.String headerName) {
		this.headerName = headerName;
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
	 * Return the value associated with the column: Email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: Email
	 * @param email the Email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: Description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: Description
	 * @param description the Description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: Fax
	 */
	public java.lang.String getFax () {
		return fax;
	}

	/**
	 * Set the value related to the column: Fax
	 * @param fax the Fax value
	 */
	public void setFax (java.lang.String fax) {
		this.fax = fax;
	}



	/**
	 * Return the value associated with the column: Address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: Address
	 * @param address the Address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
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
	 * Return the value associated with the column: Country
	 */
	public java.lang.String getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: Country
	 * @param country the Country value
	 */
	public void setCountry (java.lang.String country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
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
	 * Return the value associated with the column: signatureimage
	 */
	public java.lang.String getSignatureimage () {
		return signatureimage;
	}

	/**
	 * Set the value related to the column: signatureimage
	 * @param signatureimage the signatureimage value
	 */
	public void setSignatureimage (java.lang.String signatureimage) {
		this.signatureimage = signatureimage;
	}



	/**
	 * Return the value associated with the column: CityPostalcode
	 */
	public java.lang.String getCityPostalcode () {
		return cityPostalcode;
	}

	/**
	 * Set the value related to the column: CityPostalcode
	 * @param cityPostalcode the CityPostalcode value
	 */
	public void setCityPostalcode (java.lang.String cityPostalcode) {
		this.cityPostalcode = cityPostalcode;
	}



	/**
	 * Return the value associated with the column: officename
	 */
	public java.lang.String getOfficename () {
		return officename;
	}

	/**
	 * Set the value related to the column: officename
	 * @param officename the officename value
	 */
	public void setOfficename (java.lang.String officename) {
		this.officename = officename;
	}



	/**
	 * Return the value associated with the column: website
	 */
	public java.lang.String getWebsite () {
		return website;
	}

	/**
	 * Set the value related to the column: website
	 * @param website the website value
	 */
	public void setWebsite (java.lang.String website) {
		this.website = website;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.print.Companyheader)) return false;
		else {
			com.bureaueye.beacon.model.print.Companyheader companyheader = (com.bureaueye.beacon.model.print.Companyheader) obj;
			if (null == this.getCompanyheaderId() || null == companyheader.getCompanyheaderId()) return false;
			else return (this.getCompanyheaderId().equals(companyheader.getCompanyheaderId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCompanyheaderId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCompanyheaderId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}