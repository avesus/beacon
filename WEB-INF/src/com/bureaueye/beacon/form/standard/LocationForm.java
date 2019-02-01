package com.bureaueye.beacon.form.standard;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.util.Util;


/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-26		200900019		Add Validation
 * 
 * NT	2010-04-02		201000017		Location Maintenance - Sychronize update of Locationcode and portunicon fields
 *												
 */
public final class LocationForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String action;
	
	// primary key
	private java.lang.String _locationkey;
	
	// fields
	private java.lang.String _description2;
	private java.lang.String _city;
	private java.lang.String _fax;
	private java.lang.String _portUnicon;
	private java.lang.String _postalCode;
	private java.lang.String _description3;
	private java.lang.String _state;
	private java.lang.String _address1;
	private java.lang.String _createuserid;
	private java.lang.String _locationName;
	private java.lang.String _shortName;	
	private java.lang.String _phone;
	private java.lang.String _description1;
	private java.lang.String _plantCode;
	
	private java.lang.String _locationType;
	private String[] arraylocationtypelist;		
	
	private java.lang.String _locationcode;
	private java.lang.String _address3;
	private java.lang.String _contact;
	private java.lang.String _country;
	private java.lang.String _address2;
	
	private java.lang.String g1codekey;
	private java.lang.String g2codekey;
	private java.lang.String g3codekey;
	private java.lang.String g4codekey;
	
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="assigned"
	 *  column="Locationkey"
	 */
	public java.lang.String getLocationkey () {
		return _locationkey;
	}
	
	/**
	 * Set the unique identifier of this class
	 * @param _locationkey the new ID
	 */
	public void setLocationkey (java.lang.String _locationkey) {
		this._locationkey = _locationkey;
	}
	
	
	public java.lang.String getLocationcode () {
		return _locationcode;
	}
	/**
	 * Set the unique identifier of this class
	 * @param _locationcode the new ID
	 */
	public void setLocationcode (java.lang.String _locationcode) {
		this._locationcode = _locationcode;
	}
	
	
	/**
	 * Return the value associated with the column: Description2
	 */
	public java.lang.String getDescription2 () {
		return _description2;
	}
	
	/**
	 * Set the value related to the column: Description2
	 * @param _description2 the Description2 value
	 */
	public void setDescription2 (java.lang.String _description2) {
		this._description2 = _description2;
	}
	
	
	/**
	 * Return the value associated with the column: City
	 */
	public java.lang.String getCity () {
		return _city;
	}
	
	/**
	 * Set the value related to the column: City
	 * @param _city the City value
	 */
	public void setCity (java.lang.String _city) {
		this._city = _city;
	}
	
	
	
	/**
	 * Return the value associated with the column: Fax
	 */
	public java.lang.String getFax () {
		return _fax;
	}
	
	/**
	 * Set the value related to the column: Fax
	 * @param _fax the Fax value
	 */
	public void setFax (java.lang.String _fax) {
		this._fax = _fax;
	}
	
	/**
	 * Return the value associated with the column: PortUnicon
	 */
	public java.lang.String getPortUnicon () {
		return _portUnicon;
	}
	
	/**
	 * Set the value related to the column: PortUnicon
	 * @param _portUnicon the PortUnicon value
	 */
	public void setPortUnicon (java.lang.String _portUnicon) {
		this._portUnicon = _portUnicon;
	}
	
	
	/**
	 * Return the value associated with the column: PostalCode
	 */
	public java.lang.String getPostalCode () {
		return _postalCode;
	}
	
	/**
	 * Set the value related to the column: PostalCode
	 * @param _postalCode the PostalCode value
	 */
	public void setPostalCode (java.lang.String _postalCode) {
		this._postalCode = _postalCode;
	}
	
	
	/**
	 * Return the value associated with the column: Description3
	 */
	public java.lang.String getDescription3 () {
		return _description3;
	}
	
	/**
	 * Set the value related to the column: Description3
	 * @param _description3 the Description3 value
	 */
	public void setDescription3 (java.lang.String _description3) {
		this._description3 = _description3;
	}
	
	
	/**
	 * Return the value associated with the column: State
	 */
	public java.lang.String getState () {
		return _state;
	}
	
	/**
	 * Set the value related to the column: State
	 * @param _state the State value
	 */
	public void setState (java.lang.String _state) {
		this._state = _state;
	}
	
	
	/**
	 * Return the value associated with the column: Address1
	 */
	public java.lang.String getAddress1 () {
		return _address1;
	}
	
	/**
	 * Set the value related to the column: Address1
	 * @param _address1 the Address1 value
	 */
	public void setAddress1 (java.lang.String _address1) {
		this._address1 = _address1;
	}
	
	
	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return _createuserid;
	}
	
	/**
	 * Set the value related to the column: createuserid
	 * @param _createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String _createuserid) {
		this._createuserid = _createuserid;
	}
	
	
	/**
	 * Return the value associated with the column: LocationName
	 */
	public java.lang.String getLocationName () {
		return _locationName;
	}
	
	/**
	 * Set the value related to the column: LocationName
	 * @param _locationName the LocationName value
	 */
	public void setLocationName (java.lang.String _locationName) {
		this._locationName = _locationName;
	}
	
	/**
	 * Return the value associated with the column: ShortName
	 */
	public java.lang.String getShortName () {
		return _shortName;
	}
	
	/**
	 * Set the value related to the column: ShortName
	 * @param _shortName the ShortName value
	 */
	public void setShortName (java.lang.String _shortName) {
		this._shortName = _shortName;
	}
	
	
	/**
	 * Return the value associated with the column: Phone
	 */
	public java.lang.String getPhone () {
		return _phone;
	}
	
	/**
	 * Set the value related to the column: Phone
	 * @param _phone the Phone value
	 */
	public void setPhone (java.lang.String _phone) {
		this._phone = _phone;
	}
	
	
	/**
	 * Return the value associated with the column: Description1
	 */
	public java.lang.String getDescription1 () {
		return _description1;
	}
	
	/**
	 * Set the value related to the column: Description1
	 * @param _description1 the Description1 value
	 */
	public void setDescription1 (java.lang.String _description1) {
		this._description1 = _description1;
	}
	
	
	/**
	 * Return the value associated with the column: PlantCode
	 */
	public java.lang.String getPlantCode () {
		return _plantCode;
	}
	
	/**
	 * Set the value related to the column: PlantCode
	 * @param _plantCode the PlantCode value
	 */
	public void setPlantCode (java.lang.String _plantCode) {
		this._plantCode = _plantCode;
	}
	
	
	/**
	 * Return the value associated with the column: LocationType
	 */
	public java.lang.String getLocationType () {
		return _locationType;
	}
	
	/**
	 * Set the value related to the column: LocationType
	 * @param _locationType the LocationType value
	 */
	public void setLocationType (java.lang.String _locationType) {
		this._locationType = _locationType;
	}
	
	
	/**
	 * Return the value associated with the column: Address3
	 */
	public java.lang.String getAddress3 () {
		return _address3;
	}
	
	/**
	 * Set the value related to the column: Address3
	 * @param _address3 the Address3 value
	 */
	public void setAddress3 (java.lang.String _address3) {
		this._address3 = _address3;
	}
	
	
	/**
	 * Return the value associated with the column: Contact
	 */
	public java.lang.String getContact () {
		return _contact;
	}
	
	/**
	 * Set the value related to the column: Contact
	 * @param _contact the Contact value
	 */
	public void setContact (java.lang.String _contact) {
		this._contact = _contact;
	}
	
	
	
	/**
	 * Return the value associated with the column: Country
	 */
	public java.lang.String getCountry () {
		return _country;
	}
	
	/**
	 * Set the value related to the column: Country
	 * @param _country the Country value
	 */
	public void setCountry (java.lang.String _country) {
		this._country = _country;
	}
	
	
	/**
	 * Return the value associated with the column: Address2
	 */
	public java.lang.String getAddress2 () {
		return _address2;
	}
	
	/**
	 * Set the value related to the column: Address2
	 * @param _address2 the Address2 value
	 */
	public void setAddress2 (java.lang.String _address2) {
		this._address2 = _address2;
	}
	
	
	/**
	 */
	public java.lang.String getG1codekey () {
		return g1codekey;
	}
	/**
	 */
	public void setG1codekey (java.lang.String g1codekey) {
		this.g1codekey = g1codekey;
	}


	/**
	 */
	public java.lang.String getG2codekey () {
		return g2codekey;
	}

	/**
	 */
	public void setG2codekey (java.lang.String g2codekey) {
		this.g2codekey = g2codekey;
	}

	
	/**
	 */
	public java.lang.String getG3codekey () {
		return g3codekey;
	}
	/**
	 */
	public void setG3codekey (java.lang.String g3codekey) {
		this.g3codekey = g3codekey;
	}
	
	/**
	 */
	public java.lang.String getG4codekey () {
		return g4codekey;
	}
	/**
	 */
	public void setG4codekey (java.lang.String g4codekey) {
		this.g4codekey = g4codekey;
	}
	
	
	
	
	public String getLocationtypelist() {
		return concatArray(arraylocationtypelist);
	}

	public void setLocationtypelist(String locationtypelist) {
		if (locationtypelist != null) {
			arraylocationtypelist = locationtypelist.split("\\|");
		}
	}
	
	public void setArraylocationtypelist(String[] arraylocationtypelist) {
		this.arraylocationtypelist = arraylocationtypelist;
	}

	public String[] getArraylocationtypelist() {
		return arraylocationtypelist;
	}
	
	
	private String concatArray(String[] array) {
		StringBuffer concat = new StringBuffer();
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i].length() > 0) {
					concat.append(array[i]);
					if (i < array.length - 1) {
						concat.append("|");
					}
				}
			}
		}
		return concat.toString();
	}
	
	
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		// Do not vaildate if Delete Action
		if (action == null || action.equals("Delete")) {
			return null;
		}
		
		
		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();

		//default typekey to first element in typekeylist
		try {this._locationType=this.arraylocationtypelist[0];} catch (Exception e) {}

		
		addErrorIfBlank(errors, "locationkey", _locationkey, "error.code.required");
		addErrorIfBlank(errors, "locationName", _locationName, "error.name.required");
		addErrorIfBlank(errors, "locationType", _locationType, "error.type.required");
		addErrorIfBlank(errors, "shortName", _shortName, "error.shortname.required");
		addErrorIfBlank(errors, "g1codekey", g1codekey, "error.g1codekey.required");
		
		if (action.equals("Create")) {
			if (Util.invalidChars(this._locationkey)) errors.add("locationkey", new ActionMessage("error.code.invalidchars"));
		}

		//201000017
		if (this.getLocationtypelist().contains("PORT") || this._locationType.equals("PORT")) {
			addErrorIfBlank(errors, "Locationcode", _locationcode, "error.locationuncode.required");
		}
		
		
		return errors;
	}
	
	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}
	
}
