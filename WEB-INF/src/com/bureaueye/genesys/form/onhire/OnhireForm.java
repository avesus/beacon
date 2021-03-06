package com.bureaueye.genesys.form.onhire;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.util.Util;


public final class OnhireForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
    
    
	// primary key
	private java.lang.String _onhireId;


	// fields
	private java.lang.String _contractId;
	private java.lang.String _contracteqpId;
	private java.lang.String _contracteqplocId;
	
	
	private java.lang.String _companykey;
	private java.lang.String _departmentkey;
	private java.lang.String _activitykey;
	
	
	private java.lang.String _submittedby;
	private java.lang.String _submitteddatedd;
	private java.lang.String _submitteddatemm;
	private java.lang.String _submitteddateyyyy;

	private java.lang.String _estreldatedd;
	private java.lang.String _estreldatemm;
	private java.lang.String _estreldateyyyy;

	private java.lang.String _releaseref;
	
	private java.lang.String _notes;
	private java.lang.String _other;
	private java.lang.String _comments;
	
	private java.lang.String _eqpkey;
	private java.lang.String _eqpkeyp5;
	private java.lang.String _eqpkeyp2;	
	private java.lang.String _eqpkeyp6;	
	private java.lang.String _eqpkeyp7;
	private java.lang.String _eqpkeyp3;
	private java.lang.String _eqpkeyp4;
	private java.lang.String _eqpkeyp9;
	private java.lang.String _eqpkeyp8;
	private java.lang.String _eqpkeyp10;
	private java.lang.String _eqpkeyp1;
	
	private java.lang.String _freedays = "0";
	private java.lang.String _mindays = "0";
	private java.lang.String _qtyofunits = "0";	

	private java.lang.String _createuserid;
	private java.util.Date _createdate;
	
	private java.lang.String _onhireno;
	private java.lang.String _contractno;
	


	// many to one
	private String _lesseeaddrkey;
	private String _locationkey;
	private Address _lesseeaddr;
	private Location _location;	
	
	
	// collections
	

	
    /**
     */
    public String getCopyId() {return (this._copyId);}
    public void setCopyId(String _copyId) {this._copyId = _copyId;}
    
	
	public String getAction() {return _action;}

	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	

	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ONHIRE_ID"
     */
	public String getId () {
		return _onhireId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _onhireId the new ID
	 */
	public void setId (String _onhireId) {
		this._onhireId = _onhireId;
	}


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CONTRACT_ID"
     */
	public String getContractId () {
		return _contractId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param __contractId the new ID
	 */
	public void setContractId (String _contractId) {
		this._contractId = _contractId;
	}
	
	

    /**
     *  column="CONTRACTEQP_ID"
     */
	public String getContracteqpId () {
		return _contracteqpId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param __contracteqpId the new ID
	 */
	public void setContracteqpId (String _contracteqpId) {
		this._contracteqpId = _contracteqpId;
	}	
	
	

    /**
     *  column="CONTRACTEQPLOC_ID"
     */
	public String getContracteqplocId () {
		return _contracteqplocId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param ___contracteqplocId the new ID
	 */
	public void setContracteqplocId (String _contracteqplocId) {
		this._contracteqplocId = _contracteqplocId;
	}
	
	
	/**
	 * Return the value associated with the column: onhireno
	 */
	public java.lang.String getOnhireno () {
		return _onhireno;
	}

	/**
	 * Set the value related to the column: onhireno
	 * @param _onhireno the onhireno value
	 */
	public void setOnhireno (java.lang.String _onhireno) {
		this._onhireno = _onhireno;
	}

	
	/**
	 * Return the value associated with the column: _contractno
	 */
	public java.lang.String getContractno_ () {
		return _contractno;
	}

	/**
	 * Set the value related to the column: _contractno
	 * @param __contractno the _contractno value
	 */
	public void setContractno (java.lang.String _contractno) {
		this._contractno = _contractno;
	}
	

	/**
	 * Return the value associated with the column: eqpkeyp5
	 */
	public java.lang.String getEqpkeyp5 () {
		return _eqpkeyp5;
	}

	/**
	 * Set the value related to the column: eqpkeyp5
	 * @param _eqpkeyp5 the eqpkeyp5 value
	 */
	public void setEqpkeyp5 (java.lang.String _eqpkeyp5) {
		this._eqpkeyp5 = _eqpkeyp5;
	}





	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2_ () {
		return _eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp2
	 * @param _eqpkeyp2 the eqpkeyp2 value
	 */
	public void setEqpkeyp2 (java.lang.String _eqpkeyp2) {
		this._eqpkeyp2 = _eqpkeyp2;
	}




	/**
	 * Return the value associated with the column: eqpkey
	 */
	public java.lang.String getEqpkey () {
		return _eqpkey;
	}

	/**
	 * Set the value related to the column: eqpkey
	 * @param _eqpkey the eqpkey value
	 */
	public void setEqpkey (java.lang.String _eqpkey) {
		this._eqpkey = _eqpkey;
	}


	/**
	 * Return the value associated with the column: eqpkeyp7
	 */
	public java.lang.String getEqpkeyp7 () {
		return _eqpkeyp7;
	}

	/**
	 * Set the value related to the column: eqpkeyp7
	 * @param _eqpkeyp7 the eqpkeyp7 value
	 */
	public void setEqpkeyp7 (java.lang.String _eqpkeyp7) {
		this._eqpkeyp7 = _eqpkeyp7;
	}



	/**
	 * Return the value associated with the column: eqpkeyp3
	 */
	public java.lang.String getEqpkeyp3 () {
		return _eqpkeyp3;
	}

	/**
	 * Set the value related to the column: eqpkeyp3
	 * @param _eqpkeyp3 the eqpkeyp3 value
	 */
	public void setEqpkeyp3 (java.lang.String _eqpkeyp3) {
		this._eqpkeyp3 = _eqpkeyp3;
	}




	/**
	 * Return the value associated with the column: eqpkeyp4
	 */
	public java.lang.String getEqpkeyp4 () {
		return _eqpkeyp4;
	}

	/**
	 * Set the value related to the column: eqpkeyp4
	 * @param _eqpkeyp4 the eqpkeyp4 value
	 */
	public void setEqpkeyp4 (java.lang.String _eqpkeyp4) {
		this._eqpkeyp4 = _eqpkeyp4;
	}




	/**
	 * Return the value associated with the column: eqpkeyp9
	 */
	public java.lang.String getEqpkeyp9 () {
		return _eqpkeyp9;
	}

	/**
	 * Set the value related to the column: eqpkeyp9
	 * @param _eqpkeyp9 the eqpkeyp9 value
	 */
	public void setEqpkeyp9 (java.lang.String _eqpkeyp9) {
		this._eqpkeyp9 = _eqpkeyp9;
	}



	/**
	 * Return the value associated with the column: eqpkeyp8
	 */
	public java.lang.String getEqpkeyp8 () {
		return _eqpkeyp8;
	}

	/**
	 * Set the value related to the column: eqpkeyp8
	 * @param _eqpkeyp8 the eqpkeyp8 value
	 */
	public void setEqpkeyp8 (java.lang.String _eqpkeyp8) {
		this._eqpkeyp8 = _eqpkeyp8;
	}


	/**
	 * Return the value associated with the column: eqpkeyp10
	 */
	public java.lang.String getEqpkeyp10 () {
		return _eqpkeyp10;
	}

	/**
	 * Set the value related to the column: eqpkeyp10
	 * @param _eqpkeyp10 the eqpkeyp10 value
	 */
	public void setEqpkeyp10 (java.lang.String _eqpkeyp10) {
		this._eqpkeyp10 = _eqpkeyp10;
	}



	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1_ () {
		return _eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param _eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String _eqpkeyp1) {
		this._eqpkeyp1 = _eqpkeyp1;
	}



	/**
	 * Return the value associated with the column: freedays
	 */
	public java.lang.String getFreedays () {
		return _freedays;
	}

	/**
	 * Set the value related to the column: freedays
	 * @param _freedays the freedays value
	 */
	public void setFreedays (java.lang.String _freedays) {
		this._freedays = _freedays;
	}


	/**
	 * Return the value associated with the column: eqpkeyp6
	 */
	public java.lang.String getEqpkeyp6 () {
		return _eqpkeyp6;
	}

	/**
	 * Set the value related to the column: eqpkeyp6
	 * @param _eqpkeyp6 the eqpkeyp6 value
	 */
	public void setEqpkeyp6 (java.lang.String _eqpkeyp6) {
		this._eqpkeyp6 = _eqpkeyp6;
	}






	/**
	 * Return the value associated with the column: mindays
	 */
	public java.lang.String getMindays () {
		return _mindays;
	}

	/**
	 * Set the value related to the column: mindays
	 * @param _mindays the mindays value
	 */
	public void setMindays (java.lang.String _mindays) {
		this._mindays = _mindays;
	}



	/**
	 * Return the value associated with the column: qtyofunits
	 */
	public java.lang.String getQtyofunits () {
		return _qtyofunits;
	}

	/**
	 * Set the value related to the column: qtyofunits
	 * @param _qtyofunits the qtyofunits value
	 */
	public void setQtyofunits (java.lang.String _qtyofunits) {
		this._qtyofunits = _qtyofunits;
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
	
	

	
	public Date getSubmitteddate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getSubmitteddateyyyy()), Integer
						.parseInt(getSubmitteddatemm()) - 1, Integer
						.parseInt(getSubmitteddatedd()));
		return c.getTime();
	}
	public void setSubmitteddate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setSubmitteddateyyyy(c.get(Calendar.YEAR) + "");
		setSubmitteddatemm((month < 10 ? "0" : "") + month);
		setSubmitteddatedd((day < 10 ? "0" : "") + day);
	}
	public String getSubmitteddatedd () {return _submitteddatedd;}
	public void setSubmitteddatedd (String _submitteddatedd) {this._submitteddatedd = _submitteddatedd;}
	public String getSubmitteddatemm () {return _submitteddatemm;}
	public void setSubmitteddatemm (String _submitteddatemm) {this._submitteddatemm = _submitteddatemm;}
	public String getSubmitteddateyyyy () {return _submitteddateyyyy;}
	public void setSubmitteddateyyyy (String _submitteddateyyyy) {this._submitteddateyyyy = _submitteddateyyyy;}

	
	public Date getEstreldate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getEstreldateyyyy()), Integer
						.parseInt(getEstreldatemm()) - 1, Integer
						.parseInt(getEstreldatedd()));
		return c.getTime();
	}
	public void setEstreldate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setEstreldateyyyy(c.get(Calendar.YEAR) + "");
		setEstreldatemm((month < 10 ? "0" : "") + month);
		setEstreldatedd((day < 10 ? "0" : "") + day);
	}
	public String getEstreldatedd () {return _estreldatedd;}
	public void setEstreldatedd (String _estreldatedd) {this._estreldatedd = _estreldatedd;}
	public String getEstreldatemm () {return _estreldatemm;}
	public void setEstreldatemm (String _estreldatemm) {this._estreldatemm = _estreldatemm;}
	public String getEstreldateyyyy () {return _estreldateyyyy;}
	public void setEstreldateyyyy (String _estreldateyyyy) {this._estreldateyyyy = _estreldateyyyy;}

	


	
	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate_ () {
		return _createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param _createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date _createdate) {
		this._createdate = _createdate;
	}
	
	
	

	
	
	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return _comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param _comments the comments value
	 */
	public void setComments (java.lang.String _comments) {
		this._comments = _comments;
	}


	/**
	 * Return the value associated with the column: other
	 */
	public java.lang.String getOther() {
		return _other;
	}

	/**
	 * Set the value related to the column: other
	 * @param _other the comments value
	 */
	public void setOther (java.lang.String _other) {
		this._other = _other;
	}
	

	/**
	 * Return the value associated with the column: releaseref
	 */
	public java.lang.String getReleaseref () {
		return _releaseref;
	}

	/**
	 * Set the value related to the column: releaseref
	 * @param _releaseref the releaseref value
	 */
	public void setReleaseref (java.lang.String _releaseref) {
		this._releaseref = _releaseref;
	}
	
	
	/**
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return _notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param _notes the notes value
	 */
	public void setNotes (java.lang.String _notes) {
		this._notes = _notes;
	}


	/**
	 * Return the value associated with the column: submittedby
	 */
	public java.lang.String getSubmittedby () {
		return _submittedby;
	}

	/**
	 * Set the value related to the column: submittedby
	 * @param _submittedby the submittedby value
	 */
	public void setSubmittedby (java.lang.String _submittedby) {
		this._submittedby = _submittedby;
	}





	/**
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid () {
		return _createuserid;
	}

	/**
	 * Set the value related to the column: CREATEUSERID
	 * @param _createuserid the CREATEUSERID value
	 */
	public void setCreateuserid (java.lang.String _createuserid) {
		this._createuserid = _createuserid;
	}







	/**
     * @hibernate.property
     *  column=lesseeaddrkey
	 */
	public String getLesseeaddrkey () {
		return this._lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param _lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (String _lesseeaddrkey) {
		this._lesseeaddrkey = _lesseeaddrkey;
	}


	
		/**
     * @hibernate.property
     *  column=locationkey
	 */
	public String getLocationkey () {
		return this._locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param _locationkey the locationkey value
	 */
	public void setLocationkey (String _locationkey) {
		this._locationkey = _locationkey;
	}

	
	/**
	 */
	public Address getLesseeaddr () {
		return this._lesseeaddr;
	}

	/**
	 */
	public void setLesseeaddr (Address _lesseeaddr) {
		this._lesseeaddr = _lesseeaddr;
	}


	/**
	 */
	public Location getLocation () {
		return this._location;
	}

	/**
	 */
	public void setLocation (Location _location) {
		this._location = _location;
	}

	
	
	

	
	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();	


        if ((_onhireno == null) || (_onhireno.length() < 1))
            errors.add("onhireno",
                    new ActionMessage("error.onhireno.required")); 


		if (_action.equals("Create")) {
			if (Util.invalidChars(this._onhireno)) errors.add("onhireno", new ActionMessage("error.onhireno.invalidchars"));
		}


        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_submitteddateyyyy+"-"+
    								_submitteddatemm+"-"+ 
    								_submitteddatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("submitteddatedd", new ActionMessage("error.submitteddate.required"));

		addErrorIfBlank(errors,"submittedby",this._submittedby,"error.submittedby.required");
		
        date = null;
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_estreldateyyyy+"-"+
    								_estreldatemm+"-"+ 
    								_estreldatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("estreldatedd", new ActionMessage("error.estreldate.required"));   


		addErrorIfBlank(errors,"lesseeaddrkey",this._lesseeaddrkey,"error.lessee.required"); 
		addErrorIfBlank(errors,"contractId",this._contractId,"error.contractno.required");        	       			
		addErrorIfBlank(errors,"contracteqpId",this._contracteqpId,"error.eqpkeyp1.required"); 
		addErrorIfBlank(errors,"contracteqplocId",this._contracteqplocId,"error.location.required"); 
		        
 
		
		
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
