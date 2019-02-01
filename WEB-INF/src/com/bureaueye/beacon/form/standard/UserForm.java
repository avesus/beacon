package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.util.Util;



public final class UserForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	// primary key
	private java.lang.String _userid;

    private String copyId = "";
    
	// fields
	private java.lang.String _password;
	private java.lang.String _securitylevel;
	private java.lang.String _mailhost;
	private java.lang.String _activitykey;
	private java.lang.String _departmentkey;
	private java.lang.String _email;
	private java.lang.String _phone;
	private java.lang.String _fax;	
	private java.lang.String _companykey;
	private java.lang.String _pagesize;
	private java.lang.String _name;
	private java.lang.String _language;
	private java.lang.String _country;
	private java.lang.String _locale;	
	private java.lang.String _usergroupid;

	private String[] arraytypekeylist;
	private String[] arraylocationtypelist;	

	private String[] arraycompanykeylist;	
	private String[] arraydepartmentkeylist;	
	private String[] arrayactivitykeylist;	
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	
	public String getLocale() {return _locale;}
	public void setLocale(String _locale) {this._locale = _locale;}

    /**
     */
    public String getCopyId() {return (this.copyId);}
    public void setCopyId(String copyId) {this.copyId = copyId;}
    
	
	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return _password;
	}

	/**
	 * Set the value related to the column: password
	 * @param _password the password value
	 */
	public void setPassword (java.lang.String _password) {
		this._password = _password;
	}


	/**
	 * Return the value associated with the column: securitylevel
	 */
	public java.lang.String getSecuritylevel () {
		return _securitylevel;
	}

	/**
	 * Set the value related to the column: securitylevel
	 * @param _securitylevel the securitylevel value
	 */
	public void setSecuritylevel (java.lang.String _securitylevel) {
		this._securitylevel = _securitylevel;
	}


	/**
	 * Return the value associated with the column: mailhost
	 */
	public java.lang.String getMailhost () {
		return _mailhost;
	}

	/**
	 * Set the value related to the column: mailhost
	 * @param _mailhost the mailhost value
	 */
	public void setMailhost (java.lang.String _mailhost) {
		this._mailhost = _mailhost;
	}


	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return _activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param _activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String _activitykey) {
		this._activitykey = _activitykey;
	}


	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return _departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param _departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String _departmentkey) {
		this._departmentkey = _departmentkey;
	}


	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return _email;
	}

	/**
	 * Set the value related to the column: email
	 * @param _email the email value
	 */
	public void setEmail (java.lang.String _email) {
		this._email = _email;
	}

	
	
	/**
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhone () {
		return _phone;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phone the phone value
	 */
	public void setPhone (java.lang.String phone) {
		this._phone = phone;
	}



	/**
	 * Return the value associated with the column: fax
	 */
	public java.lang.String getFax () {
		return _fax;
	}

	/**
	 * Set the value related to the column: fax
	 * @param fax the fax value
	 */
	public void setFax (java.lang.String fax) {
		this._fax = fax;
	}
	
	
	

	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return _companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param _companykey the companykey value
	 */
	public void setCompanykey (java.lang.String _companykey) {
		this._companykey = _companykey;
	}


	/**
	 * Return the value associated with the column: pagesize
	 */
	public java.lang.String getPagesize () {
		return _pagesize;
	}

	/**
	 * Set the value related to the column: pagesize
	 * @param _pagesize the pagesize value
	 */
	public void setPagesize (java.lang.String _pagesize) {
		this._pagesize = _pagesize;
	}


	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return _name;
	}

	/**
	 * Set the value related to the column: name
	 * @param _name the name value
	 */
	public void setName (java.lang.String _name) {
		this._name = _name;
	}


	/**
	 * Return the value associated with the column: language
	 */
	public java.lang.String getLanguage () {
		return _language;
	}

	/**
	 * Set the value related to the column: language
	 * @param _language the language value
	 */
	public void setLanguage (java.lang.String _language) {
		this._language = _language;
	}


	/**
	 * Return the value associated with the column: country
	 */
	public java.lang.String getCountry () {
		return _country;
	}

	/**
	 * Set the value related to the column: country
	 * @param _country the country value
	 */
	public void setCountry (java.lang.String _country) {
		this._country = _country;
	}


	/**
	 * Return the value associated with the column: usergroupid
	 */
	public java.lang.String getUsergroupid () {
		return _usergroupid;
	}

	/**
	 * Set the value related to the column: usergroupid
	 * @param _usergroupid the usergroupid value
	 */
	public void setUsergroupid (java.lang.String _usergroupid) {
		this._usergroupid = _usergroupid;
	}

	

	

	/**
	 */
	public java.lang.String getUserid () {return _userid;}

	/**
	 */
	public void setUserid (java.lang.String _userid) {this._userid = _userid;}



	
	public String getTypekeylist() {
		return concatArray(arraytypekeylist);
	}

	public void setTypekeylist(String typekeylist) {
		if (typekeylist != null) {
			arraytypekeylist = typekeylist.split("\\|");
		}
	}
	
	public void setArraytypekeylist(String[] arraytypekeylist) {
		this.arraytypekeylist = arraytypekeylist;
	}

	public String[] getArraytypekeylist() {
		return arraytypekeylist;
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
	

	
	//valid companys for user
	public String getCompanykeylist() {
		return concatArray(arraycompanykeylist);
	}
	public void setCompanykeylist(String companykeylist) {
		if (companykeylist != null) {
			arraycompanykeylist = companykeylist.split("\\|");
		}
	}	
	public void setArraycompanykeylist(String[] arraycompanykeylist) {
		this.arraycompanykeylist = arraycompanykeylist;
	}
	public String[] getArraycompanykeylist() {
		return arraycompanykeylist;
	}
	

	//valid departments for user
	public String getDepartmentkeylist() {
		return concatArray(arraydepartmentkeylist);
	}
	public void setDepartmentkeylist(String departmentkeylist) {
		if (departmentkeylist != null) {
			arraydepartmentkeylist = departmentkeylist.split("\\|");
		}
	}	
	public void setArraydepartmentkeylist(String[] arraydepartmentkeylist) {
		this.arraydepartmentkeylist = arraydepartmentkeylist;
	}
	public String[] getArraydepartmentkeylist() {
		return arraydepartmentkeylist;
	}
	
	
	//valid activitys for user
	public String getActivitykeylist() {
		return concatArray(arrayactivitykeylist);
	}
	public void setActivitykeylist(String activitykeylist) {
		if (activitykeylist != null) {
			arrayactivitykeylist = activitykeylist.split("\\|");
		}
	}	
	public void setArrayactivitykeylist(String[] arrayactivitykeylist) {
		this.arrayactivitykeylist = arrayactivitykeylist;
	}
	public String[] getArrayactivitykeylist() {
		return arrayactivitykeylist;
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
	
	
	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
        if ((_userid == null) || (_userid.length() < 1))
            errors.add("userid",
                    new ActionMessage("error.userid.required"));        	

		if (_action.equals("Create")) {
			if (Util.invalidChars(this._userid)) errors.add("userid", new ActionMessage("error.userid.invalidchars"));
		}

        if ((_companykey == null) || (_companykey.length() < 1))
            errors.add("companykey",
                    new ActionMessage("error.company.required"));       
        
		addErrorIfBlank(errors, "password", _password, "error.password.required");      
        
      
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

	
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();
		
		return keysToSkip;
	}
	
	
}
