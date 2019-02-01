package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Location;





public final class LocationDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public LocationDTO(Location dao) throws ApplicationException {
		initialize(dao);		
	}
	public LocationDTO(Location dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Location dao) throws ApplicationException {

		this.setLocationkey(dao.getLocationkey());
		this.setShortName(dao.getShortName());
		this.setLocationName(dao.getLocationName());
		this.setAddress1(dao.getAddress1());
		this.setAddress2(dao.getAddress2());
		this.setAddress3(dao.getAddress3());
		this.setCountrykey(dao.getCountrykey());
		this.setCity(dao.getCity());
		this.setPostalcode(dao.getPostalCode());
		this.setLocationType(dao.getLocationType());

		this.setState(dao.getState());
		this.setTelno1(dao.getPhone());
		this.setFaxno1(dao.getFax());
		this.setCountry(dao.getCountry());
		
		//convert string list to list collection
		this.setLocationTypelist	(dao.getLocationtypelist());	
		if (this.getLocationTypelist().size()==0) this.setLocationTypelist(dao.getLocationType());		

		
		try {this.setLocationName(this.getLocationName().substring(0,30));}catch(Exception e){}
		this.setLongLabel(dao.getShortName()+" > "+dao.getCity()+" > "+dao.getCountry());

		this.setShortName(dao.getShortName());
		try {this.setShortName(this.getShortName().substring(0,18));}catch(Exception e){}
/*		String locationtype = dao.getLocationType();
		try {locationtype = dao.getLocationType().substring(0,3);}catch(Exception e){}*/

		
		String locationName = dao.getLocationName();
		if (locationName.equals("")) locationName = "BLANK NAME";
		try {locationName = dao.getLocationName().substring(0,20);}catch(Exception e){}
		this.setLabelProperty(locationName+
								" > "+dao.getCity()+
								" ["+dao.getLocationType().toLowerCase()+"]");

		String shortcity = dao.getCity();
		try {shortcity = shortcity.substring(0,8);}catch(Exception e){}
		String shortcountry = dao.getCountry();
		try {shortcountry = shortcountry.substring(0,10);}catch(Exception e){}		

		this.setShortLabel(shortName+" > "+shortcity);
		
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	
	
	
	// primary key
	private java.lang.String locationkey;

	// fields
	private java.lang.String shortName;
	private java.lang.String locationName;
	private java.lang.String address1;
	private java.lang.String address2;
	private java.lang.String address3;	
	private java.lang.String address4;
	private java.lang.String address5;
	private java.lang.String countrykey;
	private java.lang.String city;	
	private java.lang.String postalcode;
	private java.lang.String state;
	private java.lang.String telno1;
	private java.lang.String emailno;
	private java.lang.String faxno1;
	private java.lang.String country;
	private java.lang.String ccykey;
	
	private java.lang.String locationtype;
	private List<String> locationtypelist;

	private java.lang.String longLabel;
	private java.lang.String shortLabel;	

	private java.lang.String labelProperty;
	
	


	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}


	/**
     */
	public java.lang.String getLabelProperty () {
		return labelProperty;
	}
	/**
	 */
	public void setLabelProperty (java.lang.String labelProperty) {
		this.labelProperty = labelProperty;
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
	 * Return the value associated with the column: emailno
	 */
	public java.lang.String getEmailno () {
		return emailno;
	}

	/**
	 * Set the value related to the column: emailno
	 * @param emailno the emailno value
	 */
	public void setEmailno (java.lang.String emailno) {
		this.emailno = emailno;
	}
	
	
	/**
	 * Return the value associated with the column: state
	 */
	public java.lang.String getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * @param state the state value
	 */
	public void setState (java.lang.String state) {
		this.state = state;
	}
	
	/**
	 * Return the value associated with the column: telno1
	 */
	public java.lang.String getTelno1 () {
		return telno1;
	}

	/**
	 * Set the value related to the column: telno1
	 * @param telno1 the telno1 value
	 */
	public void setTelno1 (java.lang.String telno1) {
		this.telno1 = telno1;
	}
	
	/**
	 * Return the value associated with the column: faxno1
	 */
	public java.lang.String getFaxno1 () {
		return faxno1;
	}

	/**
	 * Set the value related to the column: faxno1
	 * @param faxno1 the faxno1 value
	 */
	public void setFaxno1 (java.lang.String faxno1) {
		this.faxno1 = faxno1;
	}
	
	
	/**
     */
	public java.lang.String getLongLabel () {
		return longLabel;
	}
	/**
	 */
	public void setLongLabel (java.lang.String _longLabel) {
		this.longLabel = _longLabel;
	}

	/**
     */
	public java.lang.String getShortLabel () {
		return shortLabel;
	}
	/**
	 */
	public void setShortLabel (java.lang.String _shortLabel) {
		this.shortLabel = _shortLabel;
	}
	
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="locationkey"
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
	}








	/**
	 * Return the value associated with the column: postalcode
	 */
	public java.lang.String getPostalcode () {
		return postalcode;
	}

	/**
	 * Set the value related to the column: postalcode
	 * @param postalcode the postalcode value
	 */
	public void setPostalcode (java.lang.String postalcode) {
		this.postalcode = postalcode;
	}




	/**
	 * Return the value associated with the column: address1
	 */
	public java.lang.String getAddress1 () {
		return address1;
	}

	/**
	 * Set the value related to the column: address1
	 * @param address1 the address1 value
	 */
	public void setAddress1 (java.lang.String address1) {
		this.address1 = address1;
	}



	/**
	 * Return the value associated with the column: locationtype
	 */
	public java.lang.String getLocationType () {
		return locationtype;
	}

	/**
	 * Set the value related to the column: locationtype
	 * @param locationtype the locationtype value
	 */
	public void setLocationType (java.lang.String locationtype) {
		this.locationtype = locationtype;
	}




	/**
	 * Return the value associated with the column: locationName
	 */
	public java.lang.String getLocationName () {
		return locationName;
	}

	/**
	 * Set the value related to the column: locationName
	 * @param locationName the locationName value
	 */
	public void setLocationName (java.lang.String locationName) {
		this.locationName = locationName;
	}



	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}









	/**
	 * Return the value associated with the column: shortname
	 */
	public java.lang.String getShortName () {
		return shortName;
	}

	/**
	 * Set the value related to the column: shortname
	 * @param shortname the shortname value
	 */
	public void setShortName (java.lang.String shortName) {
		this.shortName = shortName;
	}






	/**
	 * Return the value associated with the column: address2
	 */
	public java.lang.String getAddress2 () {
		return address2;
	}

	/**
	 * Set the value related to the column: address2
	 * @param address2 the address2 value
	 */
	public void setAddress2 (java.lang.String address2) {
		this.address2 = address2;
	}


	/**
	 * Return the value associated with the column: address3
	 */
	public java.lang.String getAddress3 () {
		return address3;
	}

	/**
	 * Set the value related to the column: address3
	 * @param address3 the address3 value
	 */
	public void setAddress3 (java.lang.String address3) {
		this.address3 = address3;
	}
	

	/**
	 * Return the value associated with the column: address4
	 */
	public java.lang.String getAddress4 () {
		return address4;
	}

	/**
	 * Set the value related to the column: address4
	 * @param address4 the address4 value
	 */
	public void setAddress4 (java.lang.String address4) {
		this.address4 = address4;
	}






	/**
	 * Return the value associated with the column: address5
	 */
	public java.lang.String getAddress5 () {
		return address5;
	}

	/**
	 * Set the value related to the column: address5
	 * @param address5 the address5 value
	 */
	public void setAddress5 (java.lang.String address5) {
		this.address5 = address5;
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
	 * Return the value associated with the column: locationtypelist
	 */
	public List getLocationTypelist () {
		return locationtypelist;
	}

	/**
	 * Set the value related to the column: locationtypelist
	 * @param locationtypelist the locationtypelist value
	 */
	public void setLocationTypelist(String _locationtypelist) {
		locationtypelist = new LinkedList<String>();
		try {
			StringTokenizer st = new StringTokenizer(_locationtypelist, "\\|");
			while (st.hasMoreTokens())
				locationtypelist.add(st.nextToken());
		} catch (Exception e) {
		}
	}







	
}
