package com.bureaueye.genesys.form.contract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.util.Util;


public final class ContractForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
    
    
	// primary key
	private java.lang.String _contractId;


	// fields
	private java.lang.String _comments;
	
	private java.lang.String _billfreqtype = "DAY";
	private java.lang.String _billtype = "ARREAR";
	private String _billfreqnum = "30";
	private java.lang.String _billccykey;
	//private boolean _billamend;
	
	private java.lang.String _companykey;
	private java.lang.String _departmentkey;
	private java.lang.String _activitykey;
	
	private java.lang.String _periodenddatedd;
	private java.lang.String _periodenddatemm;
	private java.lang.String _periodenddateyyyy;
		
	private java.lang.String _periodstartdatedd;
	private java.lang.String _periodstartdatemm;
	private java.lang.String _periodstartdateyyyy;
	
	private java.lang.String _contractdatedd;
	private java.lang.String _contractdatemm;
	private java.lang.String _contractdateyyyy;
	
	private java.lang.String _submittedby;
	private java.lang.String _submitteddatedd;
	private java.lang.String _submitteddatemm;
	private java.lang.String _submitteddateyyyy;
	
	private String _noticedays = "0";
	private java.lang.String _notes;

	private java.lang.String _signeddatedd;
	private java.lang.String _signeddatemm;
	private java.lang.String _signeddateyyyy;
	
	private java.lang.String _leasetypekey;
	
	private java.lang.String _versiondatedd;
	private java.lang.String _versiondatemm;
	private java.lang.String _versiondateyyyy;
	
	private String _versionno = "1";
	

	private java.lang.String _createuserid;
	private java.util.Date _createdate;
	
	private java.lang.String _contractno;



	// many to one
	private String _lesseeaddrkey;
	//private Address _lessoraddrkey = new Address();
	
	
	
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
     *  column="CONTRACT_ID"
     */
	public String getId () {
		return _contractId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _contractId the new ID
	 */
	public void setId (String _contractId) {
		this._contractId = _contractId;
	}


	
	
	/**
	 * Return the value associated with the column: contractno
	 */
	public java.lang.String getContractno () {
		return _contractno;
	}

	/**
	 * Set the value related to the column: contractno
	 * @param _contractno the contractno value
	 */
	public void setContractno (java.lang.String _contractno) {
		this._contractno = _contractno;
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

	
	public Date getContractdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getContractdateyyyy()), Integer
						.parseInt(getContractdatemm()) - 1, Integer
						.parseInt(getContractdatedd()));
		return c.getTime();
	}
	public void setContractdate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setContractdateyyyy(c.get(Calendar.YEAR) + "");
		setContractdatemm((month < 10 ? "0" : "") + month);
		setContractdatedd((day < 10 ? "0" : "") + day);
	}
	public String getContractdatedd () {return _contractdatedd;}
	public void setContractdatedd (String _contractdatedd) {this._contractdatedd = _contractdatedd;}
	public String getContractdatemm () {return _contractdatemm;}
	public void setContractdatemm (String _contractdatemm) {this._contractdatemm = _contractdatemm;}
	public String getContractdateyyyy () {return _contractdateyyyy;}
	public void setContractdateyyyy (String _contractdateyyyy) {this._contractdateyyyy = _contractdateyyyy;}

	
	public Date getPeriodenddate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getPeriodenddateyyyy()), Integer
						.parseInt(getPeriodenddatemm()) - 1, Integer
						.parseInt(getPeriodenddatedd()));
		return c.getTime();
	}
	public void setPeriodenddate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setPeriodenddateyyyy(c.get(Calendar.YEAR) + "");
		setPeriodenddatemm((month < 10 ? "0" : "") + month);
		setPeriodenddatedd((day < 10 ? "0" : "") + day);
	}
	public String getPeriodenddatedd () {return _periodenddatedd;}
	public void setPeriodenddatedd (String _periodenddatedd) {this._periodenddatedd = _periodenddatedd;}
	public String getPeriodenddatemm () {return _periodenddatemm;}
	public void setPeriodenddatemm (String _periodenddatemm) {this._periodenddatemm = _periodenddatemm;}
	public String getPeriodenddateyyyy () {return _periodenddateyyyy;}
	public void setPeriodenddateyyyy (String _periodenddateyyyy) {this._periodenddateyyyy = _periodenddateyyyy;}

	
	public Date getPeriodstartdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getPeriodstartdateyyyy()), Integer
						.parseInt(getPeriodstartdatemm()) - 1, Integer
						.parseInt(getPeriodstartdatedd()));
		return c.getTime();
	}
	public void setPeriodstartdate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setPeriodstartdateyyyy(c.get(Calendar.YEAR) + "");
		setPeriodstartdatemm((month < 10 ? "0" : "") + month);
		setPeriodstartdatedd((day < 10 ? "0" : "") + day);
	}
	public String getPeriodstartdatedd () {return _periodstartdatedd;}
	public void setPeriodstartdatedd (String _periodstartdatedd) {this._periodstartdatedd = _periodstartdatedd;}
	public String getPeriodstartdatemm () {return _periodstartdatemm;}
	public void setPeriodstartdatemm (String _periodstartdatemm) {this._periodstartdatemm = _periodstartdatemm;}
	public String getPeriodstartdateyyyy () {return _periodstartdateyyyy;}
	public void setPeriodstartdateyyyy (String _periodstartdateyyyy) {this._periodstartdateyyyy = _periodstartdateyyyy;}
	

	public Date getSigneddate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getSigneddateyyyy()), Integer
						.parseInt(getSigneddatemm()) - 1, Integer
						.parseInt(getSigneddatedd()));
		return c.getTime();
	}
	public void setSigneddate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setSigneddateyyyy(c.get(Calendar.YEAR) + "");
		setSigneddatemm((month < 10 ? "0" : "") + month);
		setSigneddatedd((day < 10 ? "0" : "") + day);
	}
	public String getSigneddatedd () {return _signeddatedd;}
	public void setSigneddatedd (String _signeddatedd) {this._signeddatedd = _signeddatedd;}
	public String getSigneddatemm () {return _signeddatemm;}
	public void setSigneddatemm (String _signeddatemm) {this._signeddatemm = _signeddatemm;}
	public String getSigneddateyyyy () {return _signeddateyyyy;}
	public void setSigneddateyyyy (String _signeddateyyyy) {this._signeddateyyyy = _signeddateyyyy;}

	
	public Date getVersiondate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getVersiondateyyyy()), Integer
						.parseInt(getVersiondatemm()) - 1, Integer
						.parseInt(getVersiondatedd()));
		return c.getTime();
	}
	public void setVersiondate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setVersiondateyyyy(c.get(Calendar.YEAR) + "");
		setVersiondatemm((month < 10 ? "0" : "") + month);
		setVersiondatedd((day < 10 ? "0" : "") + day);
	}
	public String getVersiondatedd () {return _versiondatedd;}
	public void setVersiondatedd (String _versiondatedd) {this._versiondatedd = _versiondatedd;}
	public String getVersiondatemm () {return _versiondatemm;}
	public void setVersiondatemm (String _versiondatemm) {this._versiondatemm = _versiondatemm;}
	public String getVersiondateyyyy () {return _versiondateyyyy;}
	public void setVersiondateyyyy (String _versiondateyyyy) {this._versiondateyyyy = _versiondateyyyy;}

	
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
	 * Return the value associated with the column: billfreqtype
	 */
	public java.lang.String getBillfreqtype () {
		return _billfreqtype;
	}

	/**
	 * Set the value related to the column: billfreqtype
	 * @param _billfreqtype the billfreqtype value
	 */
	public void setBillfreqtype (java.lang.String _billfreqtype) {
		this._billfreqtype = _billfreqtype;
	}





	/**
	 * Return the value associated with the column: billtype
	 */
	public java.lang.String getBilltype () {
		return _billtype;
	}

	/**
	 * Set the value related to the column: billtype
	 * @param _billtype the billtype value
	 */
	public void setBilltype (java.lang.String _billtype) {
		this._billtype = _billtype;
	}


	/**
	 * Return the value associated with the column: billfreqnum
	 */
	public String getBillfreqnum () {
		return _billfreqnum;
	}

	/**
	 * Set the value related to the column: billfreqnum
	 * @param _billfreqnum the billfreqnum value
	 */
	public void setBillfreqnum (String _billfreqnum) {
		this._billfreqnum = _billfreqnum;
	}









	/**
	 * Return the value associated with the column: billccykey
	 */
	public java.lang.String getBillccykey () {
		return _billccykey;
	}

	/**
	 * Set the value related to the column: billccykey
	 * @param _billccykey the billccykey value
	 */
	public void setBillccykey (java.lang.String _billccykey) {
		this._billccykey = _billccykey;
	}













	/**
	 * Return the value associated with the column: noticedays
	 */
	public String getNoticedays () {
		return _noticedays;
	}

	/**
	 * Set the value related to the column: noticedays
	 * @param _noticedays the noticedays value
	 */
	public void setNoticedays (String _noticedays) {
		this._noticedays = _noticedays;
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
	 * Return the value associated with the column: leasetypekey
	 */
	public java.lang.String getLeasetypekey () {
		return _leasetypekey;
	}

	/**
	 * Set the value related to the column: leasetypekey
	 * @param _leasetypekey the leasetypekey value
	 */
	public void setLeasetypekey (java.lang.String _leasetypekey) {
		this._leasetypekey = _leasetypekey;
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
	 * Return the value associated with the column: versionno
	 */
	public String getVersionno () {
		return _versionno;
	}

	/**
	 * Set the value related to the column: versionno
	 * @param _versionno the versionno value
	 */
	public void setVersionno (String _versionno) {
		this._versionno = _versionno;
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


	

	


	
	

	
	
	
	/*	*//**
     * @hibernate.property
     *  column=lessoraddrkey
	 *//*
	public com.bureaueye.beacon.model.standard.Address getLessoraddrkey () {
		return this._lessoraddrkey;
	}

	*//**
	 * Set the value related to the column: lessoraddrkey
	 * @param _lessoraddrkey the lessoraddrkey value
	 *//*
	public void setLessoraddrkey (com.bureaueye.beacon.model.standard.Address _lessoraddrkey) {
		this._lessoraddrkey = _lessoraddrkey;
	}
*/
	
/*	*//**
	 * Return the value associated with the column: billamend
	 *//*
	public boolean isBillamend () {
		return _billamend;
	}

	*//**
	 * Set the value related to the column: billamend
	 * @param _billamend the billamend value
	 *//*
	public void setBillamend (boolean _billamend) {
		this._billamend = _billamend;
	}*/


	
	

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


        
        if ((_contractno == null) || (_contractno.length() < 1))
            errors.add("contractno",
                    new ActionMessage("error.contractno.required"));        	

		if (_action.equals("Create")) {
			if (Util.invalidChars(this._contractno)) errors.add("contractno", new ActionMessage("error.contractno.invalidchars"));
		}
		
		addErrorIfBlank(errors, "companykey", _companykey, "error.company.required");      
		addErrorIfBlank(errors, "leasetypekey", _leasetypekey, "error.leasetype.required");         	      
		
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_contractdateyyyy+"-"+
    								_contractdatemm+"-"+ 
    								_contractdatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("contractdatedd", new ActionMessage("error.contractdate.required"));        	

        
        date = null;
    	dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_periodstartdateyyyy+"-"+
    								_periodstartdatemm+"-"+ 
    								_periodstartdatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("periodstartdatedd", new ActionMessage("error.periodstartdate.required")); 
        

        date = null;
    	dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_periodenddateyyyy+"-"+
    								_periodenddatemm+"-"+ 
    								_periodenddatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("periodenddatedd", new ActionMessage("error.periodenddate.required")); 
 

		addErrorIfBlank(errors, "leaseaddrkey", _lesseeaddrkey, "error.lessee.required");
		addErrorIfBlank(errors, "billtype", _billtype, "error.billtype.required");
		addErrorIfBlank(errors, "billfreqtype", _billfreqtype, "error.billfreqtype.required");
		addErrorIfBlank(errors, "billfreqnum", _billfreqnum, "error.billfreqnum.required");		
		addErrorIfBlank(errors, "billccykey", _billccykey, "error.billccy.required");
		
		
		
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
