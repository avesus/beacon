package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the location table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="location"
 */

public abstract class BaseLocation  implements Serializable {

	public static String REF = "Location";
	public static String PROP_PHONE = "Phone";
	public static String PROP_G1CODEKEY = "G1codekey";
	public static String PROP_COUNTRYKEY = "Countrykey";
	public static String PROP_XTIME = "Xtime";
	public static String PROP_LOCATIONKEY = "Locationkey";
	public static String PROP_XDATE = "Xdate";
	public static String PROP_DESCRIPTION1 = "Description1";
	public static String PROP_DESCRIPTION3 = "Description3";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_DESCRIPTION2 = "Description2";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_LOCATION_NAME = "LocationName";
	public static String PROP_ADDRESS3 = "Address3";
	public static String PROP_ADDRESS2 = "Address2";
	public static String PROP_XPROG = "Xprog";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_LOCATION_TYPE = "LocationType";
	public static String PROP_LOCATIONTYPELIST = "Locationtypelist";
	public static String PROP_PORT_UNICON = "PortUnicon";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_FAX = "Fax";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_CONTACT = "Contact";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_CITY = "City";
	public static String PROP_PLANT_CODE = "PlantCode";
	public static String PROP_XUSERID = "Xuserid";
	public static String PROP_LOCATIONCODE = "Locationcode";
	public static String PROP_POSTAL_CODE = "PostalCode";
	public static String PROP_STATE = "State";
	public static String PROP_SHORT_NAME = "ShortName";
	public static String PROP_G4CODEKEY = "G4codekey";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_G2CODEKEY = "G2codekey";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_G3CODEKEY = "G3codekey";
	public static String PROP_XACTION = "Xaction";


	// constructors
	public BaseLocation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLocation (java.lang.String locationkey) {
		this.setLocationkey(locationkey);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String locationkey;

	// fields
	private java.lang.String xprog;
	private java.lang.String description2;
	private java.lang.String city;
	private java.util.Date xdate;
	private java.lang.String xtime;
	private boolean xinactive;
	private java.lang.String xaction;
	private java.lang.String fax;
	private java.util.Date createdate;
	private java.lang.String portUnicon;
	private java.lang.String postalCode;
	private java.lang.String description3;
	private java.lang.String state;
	private java.lang.String address1;
	private java.lang.String createuserid;
	private java.lang.String locationName;
	private java.lang.String shortName;
	private java.lang.String phone;
	private java.lang.String description1;
	private java.lang.String plantCode;
	private java.lang.String locationType;
	private java.lang.String address3;
	private java.lang.String contact;
	private java.lang.Integer rowid;
	private java.lang.String xuserid;
	private java.lang.String country;
	private java.lang.String createtime;
	private java.lang.String address2;
	private java.lang.String xlock;
	private java.lang.String countrykey;
	private java.lang.String locationcode;
	private java.lang.String locationtypelist;
	private java.lang.String g1codekey;
	private java.lang.String g2codekey;
	private java.lang.String g3codekey;
	private java.lang.String g4codekey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="Locationkey"
     */
	public java.lang.String getLocationkey () {
		return locationkey;
	}

	/**
	 * Set the unique identifier of this class
	 * @param locationkey the new ID
	 */
	public void setLocationkey (java.lang.String locationkey) {
		this.locationkey = locationkey;
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
	 * Return the value associated with the column: Description2
	 */
	public java.lang.String getDescription2 () {
		return description2;
	}

	/**
	 * Set the value related to the column: Description2
	 * @param description2 the Description2 value
	 */
	public void setDescription2 (java.lang.String description2) {
		this.description2 = description2;
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
	 * Return the value associated with the column: PortUnicon
	 */
	public java.lang.String getPortUnicon () {
		return portUnicon;
	}

	/**
	 * Set the value related to the column: PortUnicon
	 * @param portUnicon the PortUnicon value
	 */
	public void setPortUnicon (java.lang.String portUnicon) {
		this.portUnicon = portUnicon;
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
	 * Return the value associated with the column: Description3
	 */
	public java.lang.String getDescription3 () {
		return description3;
	}

	/**
	 * Set the value related to the column: Description3
	 * @param description3 the Description3 value
	 */
	public void setDescription3 (java.lang.String description3) {
		this.description3 = description3;
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
	 * Return the value associated with the column: LocationName
	 */
	public java.lang.String getLocationName () {
		return locationName;
	}

	/**
	 * Set the value related to the column: LocationName
	 * @param locationName the LocationName value
	 */
	public void setLocationName (java.lang.String locationName) {
		this.locationName = locationName;
	}



	/**
	 * Return the value associated with the column: ShortName
	 */
	public java.lang.String getShortName () {
		return shortName;
	}

	/**
	 * Set the value related to the column: ShortName
	 * @param shortName the ShortName value
	 */
	public void setShortName (java.lang.String shortName) {
		this.shortName = shortName;
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
	 * Return the value associated with the column: Description1
	 */
	public java.lang.String getDescription1 () {
		return description1;
	}

	/**
	 * Set the value related to the column: Description1
	 * @param description1 the Description1 value
	 */
	public void setDescription1 (java.lang.String description1) {
		this.description1 = description1;
	}



	/**
	 * Return the value associated with the column: PlantCode
	 */
	public java.lang.String getPlantCode () {
		return plantCode;
	}

	/**
	 * Set the value related to the column: PlantCode
	 * @param plantCode the PlantCode value
	 */
	public void setPlantCode (java.lang.String plantCode) {
		this.plantCode = plantCode;
	}



	/**
	 * Return the value associated with the column: LocationType
	 */
	public java.lang.String getLocationType () {
		return locationType;
	}

	/**
	 * Set the value related to the column: LocationType
	 * @param locationType the LocationType value
	 */
	public void setLocationType (java.lang.String locationType) {
		this.locationType = locationType;
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



	/**
	 * Return the value associated with the column: countrykey
	 */
	public java.lang.String getCountrykey () {
		return countrykey;
	}

	/**
	 * Set the value related to the column: countrykey
	 * @param countrykey the countrykey value
	 */
	public void setCountrykey (java.lang.String countrykey) {
		this.countrykey = countrykey;
	}



	/**
	 * Return the value associated with the column: locationcode
	 */
	public java.lang.String getLocationcode () {
		return locationcode;
	}

	/**
	 * Set the value related to the column: locationcode
	 * @param locationcode the locationcode value
	 */
	public void setLocationcode (java.lang.String locationcode) {
		this.locationcode = locationcode;
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
	 * Return the value associated with the column: g1codekey
	 */
	public java.lang.String getG1codekey () {
		return g1codekey;
	}

	/**
	 * Set the value related to the column: g1codekey
	 * @param g1codekey the g1codekey value
	 */
	public void setG1codekey (java.lang.String g1codekey) {
		this.g1codekey = g1codekey;
	}



	/**
	 * Return the value associated with the column: g2codekey
	 */
	public java.lang.String getG2codekey () {
		return g2codekey;
	}

	/**
	 * Set the value related to the column: g2codekey
	 * @param g2codekey the g2codekey value
	 */
	public void setG2codekey (java.lang.String g2codekey) {
		this.g2codekey = g2codekey;
	}



	/**
	 * Return the value associated with the column: g3codekey
	 */
	public java.lang.String getG3codekey () {
		return g3codekey;
	}

	/**
	 * Set the value related to the column: g3codekey
	 * @param g3codekey the g3codekey value
	 */
	public void setG3codekey (java.lang.String g3codekey) {
		this.g3codekey = g3codekey;
	}



	/**
	 * Return the value associated with the column: g4codekey
	 */
	public java.lang.String getG4codekey () {
		return g4codekey;
	}

	/**
	 * Set the value related to the column: g4codekey
	 * @param g4codekey the g4codekey value
	 */
	public void setG4codekey (java.lang.String g4codekey) {
		this.g4codekey = g4codekey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Location)) return false;
		else {
			com.bureaueye.beacon.model.standard.Location location = (com.bureaueye.beacon.model.standard.Location) obj;
			if (null == this.getLocationkey() || null == location.getLocationkey()) return false;
			else return (this.getLocationkey().equals(location.getLocationkey()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getLocationkey()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getLocationkey().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}