package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the addresscontact table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="addresscontact"
 */

public abstract class BaseAddresscontact  implements Serializable {

	public static String REF = "Addresscontact";
	public static String PROP_PHONE = "Phone";
	public static String PROP_XTIME = "Xtime";
	public static String PROP_XDATE = "Xdate";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_ADDRESS3 = "Address3";
	public static String PROP_XPROG = "Xprog";
	public static String PROP_ADDRESS2 = "Address2";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_PAGER = "Pager";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_PHONE_EXTENSION = "PhoneExtension";
	public static String PROP_FAX = "Fax";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_CITY = "City";
	public static String PROP_TITLE = "Title";
	public static String PROP_NAME = "Name";
	public static String PROP_XUSERID = "Xuserid";
	public static String PROP_POSTAL_CODE = "PostalCode";
	public static String PROP_STATE = "State";
	public static String PROP_EMAIL = "Email";
	public static String PROP_ID = "Id";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_XACTION = "Xaction";


	// constructors
	public BaseAddresscontact () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAddresscontact (com.bureaueye.beacon.model.standard.AddresscontactPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.bureaueye.beacon.model.standard.AddresscontactPK id;

	// fields
	private java.lang.String xprog;
	private java.lang.String phoneExtension;
	private java.lang.String city;
	private java.util.Date xdate;
	private java.lang.String xtime;
	private java.lang.String pager;
	private java.lang.String xinactive;
	private java.lang.String xaction;
	private java.lang.String fax;
	private java.util.Date createdate;
	private java.lang.String name;
	private java.lang.String postalCode;
	private java.lang.String state;
	private java.lang.String address1;
	private java.lang.String createuserid;
	private java.lang.String phone;
	private java.lang.String email;
	private java.lang.String address3;
	private java.lang.Integer rowid;
	private java.lang.String xuserid;
	private java.lang.String country;
	private java.lang.String title;
	private java.lang.String createtime;
	private java.lang.String address2;
	private java.lang.String xlock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.bureaueye.beacon.model.standard.AddresscontactPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.bureaueye.beacon.model.standard.AddresscontactPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: xprog
	 */
	public java.lang.String getXprog () {
		return xprog;
	}

	/**
	 * Set the value related to the column: xprog
	 * @param xprog the xprog value
	 */
	public void setXprog (java.lang.String xprog) {
		this.xprog = xprog;
	}



	/**
	 * Return the value associated with the column: PhoneExtension
	 */
	public java.lang.String getPhoneExtension () {
		return phoneExtension;
	}

	/**
	 * Set the value related to the column: PhoneExtension
	 * @param phoneExtension the PhoneExtension value
	 */
	public void setPhoneExtension (java.lang.String phoneExtension) {
		this.phoneExtension = phoneExtension;
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
	 * Return the value associated with the column: xdate
	 */
	public java.util.Date getXdate () {
		return xdate;
	}

	/**
	 * Set the value related to the column: xdate
	 * @param xdate the xdate value
	 */
	public void setXdate (java.util.Date xdate) {
		this.xdate = xdate;
	}



	/**
	 * Return the value associated with the column: xtime
	 */
	public java.lang.String getXtime () {
		return xtime;
	}

	/**
	 * Set the value related to the column: xtime
	 * @param xtime the xtime value
	 */
	public void setXtime (java.lang.String xtime) {
		this.xtime = xtime;
	}



	/**
	 * Return the value associated with the column: Pager
	 */
	public java.lang.String getPager () {
		return pager;
	}

	/**
	 * Set the value related to the column: Pager
	 * @param pager the Pager value
	 */
	public void setPager (java.lang.String pager) {
		this.pager = pager;
	}



	/**
	 * Return the value associated with the column: xinactive
	 */
	public java.lang.String getXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (java.lang.String xinactive) {
		this.xinactive = xinactive;
	}



	/**
	 * Return the value associated with the column: xaction
	 */
	public java.lang.String getXaction () {
		return xaction;
	}

	/**
	 * Set the value related to the column: xaction
	 * @param xaction the xaction value
	 */
	public void setXaction (java.lang.String xaction) {
		this.xaction = xaction;
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
	 * Return the value associated with the column: Name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: Name
	 * @param name the Name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
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
	 * Return the value associated with the column: Address1
	 */
	public java.lang.String getAddress1 () {
		return address1;
	}

	/**
	 * Set the value related to the column: Address1
	 * @param address1 the Address1 value
	 */
	public void setAddress1 (java.lang.String address1) {
		this.address1 = address1;
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
	 * Return the value associated with the column: Address3
	 */
	public java.lang.String getAddress3 () {
		return address3;
	}

	/**
	 * Set the value related to the column: Address3
	 * @param address3 the Address3 value
	 */
	public void setAddress3 (java.lang.String address3) {
		this.address3 = address3;
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
	 * Return the value associated with the column: xuserid
	 */
	public java.lang.String getXuserid () {
		return xuserid;
	}

	/**
	 * Set the value related to the column: xuserid
	 * @param xuserid the xuserid value
	 */
	public void setXuserid (java.lang.String xuserid) {
		this.xuserid = xuserid;
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
	 * Return the value associated with the column: Title
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: Title
	 * @param title the Title value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
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
	 * Return the value associated with the column: Address2
	 */
	public java.lang.String getAddress2 () {
		return address2;
	}

	/**
	 * Set the value related to the column: Address2
	 * @param address2 the Address2 value
	 */
	public void setAddress2 (java.lang.String address2) {
		this.address2 = address2;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Addresscontact)) return false;
		else {
			com.bureaueye.beacon.model.standard.Addresscontact addresscontact = (com.bureaueye.beacon.model.standard.Addresscontact) obj;
			if (null == this.getId() || null == addresscontact.getId()) return false;
			else return (this.getId().equals(addresscontact.getId()));
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