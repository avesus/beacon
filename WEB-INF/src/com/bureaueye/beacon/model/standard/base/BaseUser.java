package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the userx table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="userx"
 */

public abstract class BaseUser  implements Serializable {

	public static String REF = "User";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_USERID = "Userid";
	public static String PROP_PHONE = "Phone";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_COMPID = "Compid";
	public static String PROP_SECURITYLEVEL = "Securitylevel";
	public static String PROP_ACTIVITYKEYLIST = "Activitykeylist";
	public static String PROP_DEPTID = "Deptid";
	public static String PROP_DEPARTMENTKEYLIST = "Departmentkeylist";
	public static String PROP_LOCATIONTYPELIST = "Locationtypelist";
	public static String PROP_PAGESIZE = "Pagesize";
	public static String PROP_MAILHOST = "Mailhost";
	public static String PROP_COMPANYKEYLIST = "Companykeylist";
	public static String PROP_FAX = "Fax";
	public static String PROP_LOCALE = "Locale";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_USERGROUPID = "Usergroupid";
	public static String PROP_SALESINVOICEPRINTCLASS = "Salesinvoiceprintclass";
	public static String PROP_NAME = "Name";
	public static String PROP_ACTVID = "Actvid";
	public static String PROP_TYPEKEYLIST = "Typekeylist";
	public static String PROP_EMAIL = "Email";
	public static String PROP_LANGUAGE = "Language";
	public static String PROP_COMPANYKEY = "Companykey";


	// constructors
	public BaseUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUser (java.lang.String userid) {
		this.setUserid(userid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String userid;

	// fields
	private java.lang.String password;
	private java.lang.String securitylevel;
	private java.lang.String mailhost;
	private java.lang.String email;
	private java.lang.String phone;
	private java.lang.String fax;
	private java.lang.String companykey;
	private java.lang.String activitykey;
	private java.lang.String departmentkey;
	private java.lang.String actvid;
	private java.lang.String deptid;
	private java.lang.String compid;
	private java.lang.String pagesize;
	private java.lang.String name;
	private java.lang.String language;
	private java.lang.String country;
	private java.lang.String locale;
	private java.lang.String usergroupid;
	private java.lang.String salesinvoiceprintclass;
	private java.lang.String typekeylist;
	private java.lang.String locationtypelist;
	private java.lang.String companykeylist;
	private java.lang.String departmentkeylist;
	private java.lang.String activitykeylist;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="userid"
     */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param userid the new ID
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: securitylevel
	 */
	public java.lang.String getSecuritylevel () {
		return securitylevel;
	}

	/**
	 * Set the value related to the column: securitylevel
	 * @param securitylevel the securitylevel value
	 */
	public void setSecuritylevel (java.lang.String securitylevel) {
		this.securitylevel = securitylevel;
	}



	/**
	 * Return the value associated with the column: mailhost
	 */
	public java.lang.String getMailhost () {
		return mailhost;
	}

	/**
	 * Set the value related to the column: mailhost
	 * @param mailhost the mailhost value
	 */
	public void setMailhost (java.lang.String mailhost) {
		this.mailhost = mailhost;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phone the phone value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the value associated with the column: fax
	 */
	public java.lang.String getFax () {
		return fax;
	}

	/**
	 * Set the value related to the column: fax
	 * @param fax the fax value
	 */
	public void setFax (java.lang.String fax) {
		this.fax = fax;
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
	 * Return the value associated with the column: actvid
	 */
	public java.lang.String getActvid () {
		return actvid;
	}

	/**
	 * Set the value related to the column: actvid
	 * @param actvid the actvid value
	 */
	public void setActvid (java.lang.String actvid) {
		this.actvid = actvid;
	}



	/**
	 * Return the value associated with the column: deptid
	 */
	public java.lang.String getDeptid () {
		return deptid;
	}

	/**
	 * Set the value related to the column: deptid
	 * @param deptid the deptid value
	 */
	public void setDeptid (java.lang.String deptid) {
		this.deptid = deptid;
	}



	/**
	 * Return the value associated with the column: compid
	 */
	public java.lang.String getCompid () {
		return compid;
	}

	/**
	 * Set the value related to the column: compid
	 * @param compid the compid value
	 */
	public void setCompid (java.lang.String compid) {
		this.compid = compid;
	}



	/**
	 * Return the value associated with the column: pagesize
	 */
	public java.lang.String getPagesize () {
		return pagesize;
	}

	/**
	 * Set the value related to the column: pagesize
	 * @param pagesize the pagesize value
	 */
	public void setPagesize (java.lang.String pagesize) {
		this.pagesize = pagesize;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: language
	 */
	public java.lang.String getLanguage () {
		return language;
	}

	/**
	 * Set the value related to the column: language
	 * @param language the language value
	 */
	public void setLanguage (java.lang.String language) {
		this.language = language;
	}



	/**
	 * Return the value associated with the column: country
	 */
	public java.lang.String getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * @param country the country value
	 */
	public void setCountry (java.lang.String country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: locale
	 */
	public java.lang.String getLocale () {
		return locale;
	}

	/**
	 * Set the value related to the column: locale
	 * @param locale the locale value
	 */
	public void setLocale (java.lang.String locale) {
		this.locale = locale;
	}



	/**
	 * Return the value associated with the column: usergroupid
	 */
	public java.lang.String getUsergroupid () {
		return usergroupid;
	}

	/**
	 * Set the value related to the column: usergroupid
	 * @param usergroupid the usergroupid value
	 */
	public void setUsergroupid (java.lang.String usergroupid) {
		this.usergroupid = usergroupid;
	}



	/**
	 * Return the value associated with the column: salesinvoiceprintclass
	 */
	public java.lang.String getSalesinvoiceprintclass () {
		return salesinvoiceprintclass;
	}

	/**
	 * Set the value related to the column: salesinvoiceprintclass
	 * @param salesinvoiceprintclass the salesinvoiceprintclass value
	 */
	public void setSalesinvoiceprintclass (java.lang.String salesinvoiceprintclass) {
		this.salesinvoiceprintclass = salesinvoiceprintclass;
	}



	/**
	 * Return the value associated with the column: typekeylist
	 */
	public java.lang.String getTypekeylist () {
		return typekeylist;
	}

	/**
	 * Set the value related to the column: typekeylist
	 * @param typekeylist the typekeylist value
	 */
	public void setTypekeylist (java.lang.String typekeylist) {
		this.typekeylist = typekeylist;
	}



	/**
	 * Return the value associated with the column: locationtypelist
	 */
	public java.lang.String getLocationtypelist () {
		return locationtypelist;
	}

	/**
	 * Set the value related to the column: locationtypelist
	 * @param locationtypelist the locationtypelist value
	 */
	public void setLocationtypelist (java.lang.String locationtypelist) {
		this.locationtypelist = locationtypelist;
	}



	/**
	 * Return the value associated with the column: companykeylist
	 */
	public java.lang.String getCompanykeylist () {
		return companykeylist;
	}

	/**
	 * Set the value related to the column: companykeylist
	 * @param companykeylist the companykeylist value
	 */
	public void setCompanykeylist (java.lang.String companykeylist) {
		this.companykeylist = companykeylist;
	}



	/**
	 * Return the value associated with the column: departmentkeylist
	 */
	public java.lang.String getDepartmentkeylist () {
		return departmentkeylist;
	}

	/**
	 * Set the value related to the column: departmentkeylist
	 * @param departmentkeylist the departmentkeylist value
	 */
	public void setDepartmentkeylist (java.lang.String departmentkeylist) {
		this.departmentkeylist = departmentkeylist;
	}



	/**
	 * Return the value associated with the column: activitykeylist
	 */
	public java.lang.String getActivitykeylist () {
		return activitykeylist;
	}

	/**
	 * Set the value related to the column: activitykeylist
	 * @param activitykeylist the activitykeylist value
	 */
	public void setActivitykeylist (java.lang.String activitykeylist) {
		this.activitykeylist = activitykeylist;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.User)) return false;
		else {
			com.bureaueye.beacon.model.standard.User user = (com.bureaueye.beacon.model.standard.User) obj;
			if (null == this.getUserid() || null == user.getUserid()) return false;
			else return (this.getUserid().equals(user.getUserid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUserid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUserid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}