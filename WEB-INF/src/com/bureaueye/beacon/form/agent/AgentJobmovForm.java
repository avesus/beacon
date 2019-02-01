package com.bureaueye.beacon.form.agent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.job.dto.JobmovDTO;



public final class AgentJobmovForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	
	
	private String _action;
	private String _readonly = "false";

	
	// multiple update
	private java.util.List mmuList;
	private int[] selectedObjects;
	private Object mmuHeader;
	
	
	// primary key
	private java.lang.String _jobmovId;

	// fields
	private java.lang.String _vendorFax;
	private java.lang.String _vendorName;
	private java.lang.String _tog2key;
	private java.lang.String _vendorContact;
	private java.lang.String _vendorAddr1;
	private java.lang.String _departmentkey;
	private String _fromlocationkey;
	private String _tolocationkey;
	private java.lang.String _vendorEmail;
	private java.lang.String _tog3key;
	private java.lang.String _companykey;
	private java.lang.String _movcost;
	private String _vendoraddrkey;
	private java.lang.String _tog4key;
	private java.lang.String _tog1key;
	private String _sectionkey;
	private java.lang.String _vendorAddr2;
	private java.lang.String _fromg3key;
	private boolean _stdCostsGenerated;
	private java.lang.String _fromg2key;
	private java.lang.String _orderno;
	private java.lang.String _jobhdrId;
	private java.lang.String _unitId;
	private java.lang.String _fromg1key;
	private java.lang.String _activitykey;
	private java.lang.String _fromg4key;
	private java.lang.String _vendorPhone;


	private java.lang.String _invsts;
	private java.lang.String _movests;
	
	private java.lang.String _estfromdatedd;
	private java.lang.String _estfromdatemm;
	private java.lang.String _estfromdateyyyy;
	private java.lang.String _estfromtimehh;
	private java.lang.String _estfromtimemm;
	private java.lang.String _estfromtimeinmillis;
	
	private java.lang.String _esttodatedd;
	private java.lang.String _esttodatemm;
	private java.lang.String _esttodateyyyy;
	private java.lang.String _esttotimehh;
	private java.lang.String _esttotimemm;
	private java.lang.String _esttotimeinmillis;
	
	private java.lang.String _actfromdatedd;
	private java.lang.String _actfromdatemm;
	private java.lang.String _actfromdateyyyy;
	private java.lang.String _actfromtimehh;
	private java.lang.String _actfromtimemm;
	private java.lang.String _actfromtimeinmillis;	

	private java.lang.String _acttodatedd;
	private java.lang.String _acttodatemm;
	private java.lang.String _acttodateyyyy;
	private java.lang.String _acttotimehh;
	private java.lang.String _acttotimemm;
	private java.lang.String _acttotimeinmillis;		
	
	private String _section;

	private java.lang.String _numberofcosts;
	private java.lang.String _movref;
	private java.lang.String _txt;
	
	private java.lang.String _vessel;

	private java.lang.String _mmulink;

	private String _lloydsnumber;
	private String _billoflading;
	private java.lang.String _voyage;	
	private java.lang.String _vsbkcontact;
	private java.lang.String _vsbkref;
	
	
	// collections

	
	
	public Date getEstfromdate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getEstfromdateyyyy()), Integer
						.parseInt(getEstfromdatemm()) - 1, Integer
						.parseInt(getEstfromdatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setEstfromdate(Date estfromdate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(estfromdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setEstfromdateyyyy(c.get(Calendar.YEAR) + "");
		setEstfromdatemm((month < 10 ? "0" : "") + month);
		setEstfromdatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setEstfromdateyyyy("0000");
			setEstfromdatemm("00");
			setEstfromdatedd("00");			
		}
	}
	public String getEstfromdatedd () {return _estfromdatedd;}
	public void setEstfromdatedd (String _estfromdatedd) {this._estfromdatedd = _estfromdatedd;}
	public String getEstfromdatemm () {return _estfromdatemm;}
	public void setEstfromdatemm (String _estfromdatemm) {this._estfromdatemm = _estfromdatemm;}
	public String getEstfromdateyyyy () {return _estfromdateyyyy;}
	public void setEstfromdateyyyy (String _estfromdateyyyy) {this._estfromdateyyyy = _estfromdateyyyy;}

	public String getEstfromtime() {
		try {
		String time = getEstfromtimehh()+":"+getEstfromtimemm();
		return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setEstfromtime(String estfromtime) {
		try {
		String hh = "00";
		try{hh = estfromtime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = estfromtime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setEstfromtimehh(hh);
		setEstfromtimemm(mm);
		} catch (Exception e) {
			setEstfromtimehh("00");
			setEstfromtimemm("00");			
		}
	}
	public String getEstfromtimehh () {return _estfromtimehh;}
	public void setEstfromtimehh (String _estfromtimehh) {this._estfromtimehh = _estfromtimehh;}
	public String getEstfromtimemm () {return _estfromtimemm;}
	public void setEstfromtimemm (String _estfromtimemm) {this._estfromtimemm = _estfromtimemm;}
	
	public long getEstfromtimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getEstfromdateyyyy()), 
					Integer.parseInt(getEstfromdatemm()) - 1, 
					Integer.parseInt(getEstfromdatedd()),
					Integer.parseInt(getEstfromtimehh()),
					Integer.parseInt(getEstfromtimemm())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setEstfromtimeinmillis(String _estfromtimeinmillis)	{
		this._estfromtimeinmillis = _estfromtimeinmillis;	
	}
	
	


	public Date getEsttodate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getEsttodateyyyy()), Integer
						.parseInt(getEsttodatemm()) - 1, Integer
						.parseInt(getEsttodatedd()));
		return c.getTime();
	} catch(Exception e) { return null; }
	}
	public void setEsttodate(Date esttodate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(esttodate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setEsttodateyyyy(c.get(Calendar.YEAR) + "");
		setEsttodatemm((month < 10 ? "0" : "") + month);
		setEsttodatedd((day < 10 ? "0" : "") + day);
	} catch (Exception e) {
		setEsttodateyyyy("0000");
		setEsttodatemm("00");
		setEsttodatedd("00");			
	}		
	}
	public String getEsttodatedd () {return _esttodatedd;}
	public void setEsttodatedd (String _esttodatedd) {this._esttodatedd = _esttodatedd;}
	public String getEsttodatemm () {return _esttodatemm;}
	public void setEsttodatemm (String _esttodatemm) {this._esttodatemm = _esttodatemm;}
	public String getEsttodateyyyy () {return _esttodateyyyy;}
	public void setEsttodateyyyy (String _esttodateyyyy) {this._esttodateyyyy = _esttodateyyyy;}

	public String getEsttotime() {
		try {
		String time = getEsttotimehh()+":"+getEsttotimemm();
		return time;
	} catch(Exception e) { return "00:00"; }
	}
	public void setEsttotime(String esttotime) {
		try {
		String hh = "00";
		try{hh = esttotime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = esttotime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setEsttotimehh(hh);
		setEsttotimemm(mm);
	} catch (Exception e) {
		setEsttotimehh("00");
		setEsttotimemm("00");			
	}
	}
	public String getEsttotimehh () {return _esttotimehh;}
	public void setEsttotimehh (String _esttotimehh) {this._esttotimehh = _esttotimehh;}
	public String getEsttotimemm () {return _esttotimemm;}
	public void setEsttotimemm (String _esttotimemm) {this._esttotimemm = _esttotimemm;}

	public long getEsttotimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getEsttodateyyyy()), 
					Integer.parseInt(getEsttodatemm()) - 1, 
					Integer.parseInt(getEsttodatedd()),
					Integer.parseInt(getEsttotimehh()),
					Integer.parseInt(getEsttotimemm())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setEsttotimeinmillis(String _esttotimeinmillis)	{
		this._esttotimeinmillis = _esttotimeinmillis;	
	}
	
	
	
	


	public long getActfromdateinmillis() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(
			Integer.parseInt(getActfromdateyyyy()), 
			Integer.parseInt(getActfromdatemm()) - 1, 
			Integer.parseInt(getActfromdatedd()),
			Integer.parseInt(getActfromtimehh()),
			Integer.parseInt(getActfromtimemm())
			);
		return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}	
	public Date getActfromdate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getActfromdateyyyy()), Integer
						.parseInt(getActfromdatemm()) - 1, Integer
						.parseInt(getActfromdatedd()));
		return c.getTime();
	} catch(Exception e) { return null; }
	}
	public void setActfromdate(Date actfromdate)	{
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(actfromdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setActfromdateyyyy(c.get(Calendar.YEAR) + "");
		setActfromdatemm((month < 10 ? "0" : "") + month);
		setActfromdatedd((day < 10 ? "0" : "") + day);
	} catch (Exception e) {
		setActfromdateyyyy("0000");
		setActfromdatemm("00");
		setActfromdatedd("00");			
	}		
	}
	public String getActfromdatedd () {return _actfromdatedd;}
	public void setActfromdatedd (String _actfromdatedd) {this._actfromdatedd = _actfromdatedd;}
	public String getActfromdatemm () {return _actfromdatemm;}
	public void setActfromdatemm (String _actfromdatemm) {this._actfromdatemm = _actfromdatemm;}
	public String getActfromdateyyyy () {return _actfromdateyyyy;}
	public void setActfromdateyyyy (String _actfromdateyyyy) {this._actfromdateyyyy = _actfromdateyyyy;}

	public String getActfromtime() {
		try {
		String time = getActfromtimehh()+":"+getActfromtimemm();
		return time;
	} catch(Exception e) { return "00:00"; }
	}
	public void setActfromtime(String actfromtime) {
	try {
		String hh = "00";
		try{hh = actfromtime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = actfromtime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setActfromtimehh(hh);
		setActfromtimemm(mm);
	} catch (Exception e) {
		setActfromtimehh("00");
		setActfromtimemm("00");			
	}		
	}
	public String getActfromtimehh () {return _actfromtimehh;}
	public void setActfromtimehh (String _actfromtimehh) {this._actfromtimehh = _actfromtimehh;}
	public String getActfromtimemm () {return _actfromtimemm;}
	public void setActfromtimemm (String _actfromtimemm) {this._actfromtimemm = _actfromtimemm;}
	
	
	public long getActfromtimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getActfromdateyyyy()), 
					Integer.parseInt(getActfromdatemm()) - 1, 
					Integer.parseInt(getActfromdatedd()),
					Integer.parseInt(getActfromtimehh()),
					Integer.parseInt(getActfromtimemm())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setActfromtimeinmillis(String _actfromtimeinmillis)	{
		this._actfromtimeinmillis = _actfromtimeinmillis;	
	}	
	
	
	public long getActtodateinmillis() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(
			Integer.parseInt(getActtodateyyyy()), 
			Integer.parseInt(getActtodatemm()) - 1, 
			Integer.parseInt(getActtodatedd()),
			Integer.parseInt(getActtotimehh()),
			Integer.parseInt(getActtotimemm())
			);
		return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public Date getActtodate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getActtodateyyyy()), Integer
						.parseInt(getActtodatemm()) - 1, Integer
						.parseInt(getActtodatedd()));
		return c.getTime();
	} catch(Exception e) { return null; }
	}
	public void setActtodate(Date acttodate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(acttodate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setActtodateyyyy(c.get(Calendar.YEAR) + "");
		setActtodatemm((month < 10 ? "0" : "") + month);
		setActtodatedd((day < 10 ? "0" : "") + day);
	} catch (Exception e) {
		setActtodateyyyy("0000");
		setActtodatemm("00");
		setActtodatedd("00");			
	}		
	}
	public String getActtodatedd () {return _acttodatedd;}
	public void setActtodatedd (String _acttodatedd) {this._acttodatedd = _acttodatedd;}
	public String getActtodatemm () {return _acttodatemm;}
	public void setActtodatemm (String _acttodatemm) {this._acttodatemm = _acttodatemm;}
	public String getActtodateyyyy () {return _acttodateyyyy;}
	public void setActtodateyyyy (String _acttodateyyyy) {this._acttodateyyyy = _acttodateyyyy;}

	public String getActtotime() {
		try {
		String time = getActtotimehh()+":"+getActtotimemm();
		return time;
	} catch(Exception e) { return "00:00"; }
	}
	public void setActtotime(String acttotime) {
		try {
		String hh = "00";
		try{hh = acttotime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = acttotime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setActtotimehh(hh);
		setActtotimemm(mm);
	} catch (Exception e) {
		setActtotimehh("00");
		setActtotimemm("00");			
	}
	}
	public String getActtotimehh () {return _acttotimehh;}
	public void setActtotimehh (String _acttotimehh) {this._acttotimehh = _acttotimehh;}
	public String getActtotimemm () {return _acttotimemm;}
	public void setActtotimemm (String _acttotimemm) {this._acttotimemm = _acttotimemm;}


	public long getActtotimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getActtodateyyyy()), 
					Integer.parseInt(getActtodatemm()) - 1, 
					Integer.parseInt(getActtodatedd()),
					Integer.parseInt(getActtotimehh()),
					Integer.parseInt(getActtotimemm())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setActtotimeinmillis(String _acttotimeinmillis)	{
		this._acttotimeinmillis = _acttotimeinmillis;	
	}	
	
	
	
	
	
	public String getSection() {
		return _section;
	}
	public void setSection(String _section) {
		this._section = _section;
	}
	

	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	
	// derived field methods
	public String getNumberofcosts() { return _numberofcosts;	}
	public void setNumberofcosts(String _numberofcosts) { this._numberofcosts = _numberofcosts;	}

	

	public String getInvsts() {return _invsts;}
	public void setInvsts(String _invsts) {this._invsts = _invsts;}
	
	public String getMovests() {return _movests;}
	public void setMovests(String _movests) {this._movests = _movests;}
	
	
	/**
     */
	public java.lang.String getMmulink() {
		return _mmulink;
	}

	/**
	 */
	public void setMmulink(java.lang.String _mmulink) {
		this._mmulink = _mmulink;
	}
	

	/**
	 * Return the value associated with the column: lloydsnumber
	 */
	public java.lang.String getLloydsnumber () {
		return _lloydsnumber;
	}

	/**
	 * Set the value related to the column: lloydsnumber
	 * @param lloydsnumber the lloydsnumber value
	 */
	public void setLloydsnumber (java.lang.String _lloydsnumber) {
		this._lloydsnumber = _lloydsnumber;
	}

	
	/**
	 * Return the value associated with the column: billoflading
	 */
	public java.lang.String getBilloflading () {
		return _billoflading;
	}

	/**
	 * Set the value related to the column: billoflading
	 * @param billoflading the billoflading value
	 */
	public void setBilloflading (java.lang.String _billoflading) {
		this._billoflading = _billoflading;
	}
	
	
	/**
     */
	public java.lang.String getJobmovId () {
		return _jobmovId;
	}

	/**
	 */
	public void setJobmovId (java.lang.String _jobmovId) {
		this._jobmovId = _jobmovId;
	}





	/**
	 * Return the value associated with the column: VENDOR_FAX
	 */
	public java.lang.String getVendorFax () {
		return _vendorFax;
	}

	/**
	 * Set the value related to the column: VENDOR_FAX
	 * @param _vendorFax the VENDOR_FAX value
	 */
	public void setVendorFax (java.lang.String _vendorFax) {
		this._vendorFax = _vendorFax;
	}



	/**
	 * Return the value associated with the column: VENDOR_NAME
	 */
	public java.lang.String getVendorName () {
		return _vendorName;
	}

	/**
	 * Set the value related to the column: VENDOR_NAME
	 * @param _vendorName the VENDOR_NAME value
	 */
	public void setVendorName (java.lang.String _vendorName) {
		this._vendorName = _vendorName;
	}





	/**
	 * Return the value associated with the column: tog2key
	 */
	public java.lang.String getTog2key () {
		return _tog2key;
	}

	/**
	 * Set the value related to the column: tog2key
	 * @param _tog2key the tog2key value
	 */
	public void setTog2key (java.lang.String _tog2key) {
		this._tog2key = _tog2key;
	}


	/**
	 * Return the value associated with the column: VENDOR_CONTACT
	 */
	public java.lang.String getVendorContact () {
		return _vendorContact;
	}

	/**
	 * Set the value related to the column: VENDOR_CONTACT
	 * @param _vendorContact the VENDOR_CONTACT value
	 */
	public void setVendorContact (java.lang.String _vendorContact) {
		this._vendorContact = _vendorContact;
	}


	/**
	 * Return the value associated with the column: VENDOR_ADDR1
	 */
	public java.lang.String getVendorAddr1 () {
		return _vendorAddr1;
	}

	/**
	 * Set the value related to the column: VENDOR_ADDR1
	 * @param _vendorAddr1 the VENDOR_ADDR1 value
	 */
	public void setVendorAddr1 (java.lang.String _vendorAddr1) {
		this._vendorAddr1 = _vendorAddr1;
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
	 * Return the value associated with the column: fromlocationkey
	 */
	public String getFromlocationkey () {
		return _fromlocationkey;
	}

	/**
	 * Set the value related to the column: fromlocationkey
	 * @param _fromlocationkey the fromlocationkey value
	 */
	public void setFromlocationkey (String _fromlocationkey) {
		this._fromlocationkey = _fromlocationkey;
	}


	/**
	 * Return the value associated with the column: tolocationkey
	 */
	public String getTolocationkey () {
		return _tolocationkey;
	}

	/**
	 * Set the value related to the column: tolocationkey
	 * @param _tolocationkey the tolocationkey value
	 */
	public void setTolocationkey (String _tolocationkey) {
		this._tolocationkey = _tolocationkey;
	}


	/**
	 * Return the value associated with the column: VENDOR_EMAIL
	 */
	public java.lang.String getVendorEmail () {
		return _vendorEmail;
	}

	/**
	 * Set the value related to the column: VENDOR_EMAIL
	 * @param _vendorEmail the VENDOR_EMAIL value
	 */
	public void setVendorEmail (java.lang.String _vendorEmail) {
		this._vendorEmail = _vendorEmail;
	}


	/**
	 * Return the value associated with the column: tog3key
	 */
	public java.lang.String getTog3key () {
		return _tog3key;
	}

	/**
	 * Set the value related to the column: tog3key
	 * @param _tog3key the tog3key value
	 */
	public void setTog3key (java.lang.String _tog3key) {
		this._tog3key = _tog3key;
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
	 * Return the value associated with the column: MOVCOST
	 */
	public java.lang.String getMovcost () {
		return _movcost;
	}

	/**
	 * Set the value related to the column: MOVCOST
	 * @param _movcost the MOVCOST value
	 */
	public void setMovcost (java.lang.String _movcost) {
		this._movcost = _movcost;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public String getVendoraddrkey () {
		return _vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param _vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (String _vendoraddrkey) {
		this._vendoraddrkey = _vendoraddrkey;
	}


	/**
	 * Return the value associated with the column: tog4key
	 */
	public java.lang.String getTog4key () {
		return _tog4key;
	}

	/**
	 * Set the value related to the column: tog4key
	 * @param _tog4key the tog4key value
	 */
	public void setTog4key (java.lang.String _tog4key) {
		this._tog4key = _tog4key;
	}


	/**
	 * Return the value associated with the column: tog1key
	 */
	public java.lang.String getTog1key () {
		return _tog1key;
	}

	/**
	 * Set the value related to the column: tog1key
	 * @param _tog1key the tog1key value
	 */
	public void setTog1key (java.lang.String _tog1key) {
		this._tog1key = _tog1key;
	}


	/**
	 * Return the value associated with the column: sectionkey
	 */
	public String getSectionkey () {
		return _sectionkey;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param _sectionkey the sectionkey value
	 */
	public void setSectionkey (String _sectionkey) {
		this._sectionkey = _sectionkey;
	}


	/**
	 * Return the value associated with the column: VENDOR_ADDR2
	 */
	public java.lang.String getVendorAddr2 () {
		return _vendorAddr2;
	}

	/**
	 * Set the value related to the column: VENDOR_ADDR2
	 * @param _vendorAddr2 the VENDOR_ADDR2 value
	 */
	public void setVendorAddr2 (java.lang.String _vendorAddr2) {
		this._vendorAddr2 = _vendorAddr2;
	}



	/**
	 * Return the value associated with the column: fromg3key
	 */
	public java.lang.String getFromg3key () {
		return _fromg3key;
	}

	/**
	 * Set the value related to the column: fromg3key
	 * @param _fromg3key the fromg3key value
	 */
	public void setFromg3key (java.lang.String _fromg3key) {
		this._fromg3key = _fromg3key;
	}




	/**
	 * Return the value associated with the column: STD_COSTS_GENERATED
	 */
	public boolean isStdCostsGenerated () {
		return _stdCostsGenerated;
	}

	/**
	 * Set the value related to the column: STD_COSTS_GENERATED
	 * @param _stdCostsGenerated the STD_COSTS_GENERATED value
	 */
	public void setStdCostsGenerated (boolean _stdCostsGenerated) {
		this._stdCostsGenerated = _stdCostsGenerated;
	}


	/**
	 * Return the value associated with the column: fromg2key
	 */
	public java.lang.String getFromg2key () {
		return _fromg2key;
	}

	/**
	 * Set the value related to the column: fromg2key
	 * @param _fromg2key the fromg2key value
	 */
	public void setFromg2key (java.lang.String _fromg2key) {
		this._fromg2key = _fromg2key;
	}


	/**
	 */
	public java.lang.String getOrderno () {
		return _orderno;
	}

/**
	 */
	public void setOrderno (java.lang.String _orderno) {
		this._orderno = _orderno;
	}




	/**
	 */
	public java.lang.String getJobhdrId () {return _jobhdrId;}
	/**
	 */
	public void setJobhdrId (java.lang.String _jobhdrId) {this._jobhdrId = _jobhdrId;}

	/**
	 */
	public java.lang.String getUnitId () {return _unitId;}
	/**
	 */
	public void setUnitId (java.lang.String _unitId) {this._unitId = _unitId;}


	/**
	 * Return the value associated with the column: fromg1key
	 */
	public java.lang.String getFromg1key () {
		return _fromg1key;
	}

	/**
	 * Set the value related to the column: fromg1key
	 * @param _fromg1key the fromg1key value
	 */
	public void setFromg1key (java.lang.String _fromg1key) {
		this._fromg1key = _fromg1key;
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
	 * Return the value associated with the column: fromg4key
	 */
	public java.lang.String getFromg4key () {
		return _fromg4key;
	}

	/**
	 * Set the value related to the column: fromg4key
	 * @param _fromg4key the fromg4key value
	 */
	public void setFromg4key (java.lang.String _fromg4key) {
		this._fromg4key = _fromg4key;
	}


	/**
	 * Return the value associated with the column: VENDOR_PHONE
	 */
	public java.lang.String getVendorPhone () {
		return _vendorPhone;
	}

	/**
	 * Set the value related to the column: VENDOR_PHONE
	 * @param _vendorPhone the VENDOR_PHONE value
	 */
	public void setVendorPhone (java.lang.String _vendorPhone) {
		this._vendorPhone = _vendorPhone;
	}


	
	/**
	 * Return the value associated with the column: movref
	 */
	public java.lang.String getMovref () {
		return _movref;
	}
	/**
	 * Set the value related to the column: movref
	 * @param _movref the _movref value
	 */
	public void setMovref (java.lang.String _movref) {
		this._movref = _movref;
	}
	
	/**
	 * Return the value associated with the column: txt
	 */
	public java.lang.String getTxt() {
		return _txt;
	}
	/**
	 * Set the value related to the column: txt
	 * @param _txt the _txt value
	 */
	public void setTxt(java.lang.String _txt) {
		this._txt = _txt;
	}
	
	
	/**
	 * Return the value associated with the column: vessel
	 */
	public java.lang.String getVessel () {
		return _vessel;
	}
	/**
	 * Set the value related to the column: vessel
	 * @param _vessel the vessel value
	 */
	public void setVessel (java.lang.String _vessel) {
		this._vessel = _vessel;
	}


	/**
	 * Return the value associated with the column: VOYAGE
	 */
	public java.lang.String getVoyage () {
		return _voyage;
	}

	/**
	 * Set the value related to the column: VOYAGE
	 * @param voyage the VOYAGE value
	 */
	public void setVoyage (java.lang.String _voyage) {
		this._voyage = _voyage;
	}

	
	/**
	 * Return the value associated with the column: VSBKCONTACT
	 */
	public java.lang.String getVsbkcontact () {
		return _vsbkcontact;
	}

	/**
	 * Set the value related to the column: VSBKCONTACT
	 * @param vsbkcontact the VSBKCONTACT value
	 */
	public void setVsbkcontact (java.lang.String _vsbkcontact) {
		this._vsbkcontact = _vsbkcontact;
	}
	
	/**
	 * Return the value associated with the column: VSBKREF
	 */
	public java.lang.String getVsbkref () {
		return _vsbkref;
	}

	/**
	 * Set the value related to the column: VSBKREF
	 * @param vsbkref the VSBKREF value
	 */
	public void setVsbkref (java.lang.String _vsbkref) {
		this._vsbkref = _vsbkref;
	}
	
	
	/**
	 * multiple update function
	 * 
	 */
	public Object getMmuHeader() {
		return mmuHeader;
	}

	public void setMmuHeader(Object mmuHeader) {
		this.mmuHeader = mmuHeader;
	}


	public List getMmuList() {
		return mmuList;
	}
	public void setMmuList(List mmuList) {
		this.mmuList = mmuList;
	}

	public int[] getSelectedObjects() {
		return selectedObjects;
	}
	public void setSelectedObjects(int[] selectedObjects) {
		this.selectedObjects = selectedObjects;
	}
	
	public JobmovDTO getJobmovDTO(int i) {
		if (getMmuList() == null) {
			setMmuList(new ArrayList());
		}
		while (getMmuList().size() <= i) {
			getMmuList().add(new JobmovDTO());
		}
		return (JobmovDTO) getMmuList().get(i);
	}
	/**
	 * 
	 * 
	 */
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
		addErrorIfBlank(errors, "sectionkey", _sectionkey, "error.section.required");		
		addErrorIfBlank(errors, "fromlocationkey", _fromlocationkey, "error.fromlocation.required");
		addErrorIfBlank(errors, "tolocationkey", _tolocationkey, "error.tolocation.required");
		addErrorIfBlank(errors, "vendoraddrkey", _vendoraddrkey, "error.vendoraddrkey.required");
		
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_estfromdateyyyy+"-"+
    								_estfromdatemm+"-"+ 
    								_estfromdatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("estfromdatedd", new ActionMessage("error.estfromdate.required"));        	

        date = null;
    	dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_esttodateyyyy+"-"+
    								_esttodatemm+"-"+ 
    								_esttodatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("esttodatedd", new ActionMessage("error.esttodate.required"));        	

        
       try {
		Calendar calendarEstfromDate = Calendar.getInstance();
		calendarEstfromDate.set(
				Integer.parseInt(getEstfromdateyyyy()), 
				Integer.parseInt(getEstfromdatemm()) - 1, 
				Integer.parseInt(getEstfromdatedd()),
				Integer.parseInt(getEstfromtimehh()),
				Integer.parseInt(getEstfromtimemm()),
				0
				);		
		Calendar calendarEsttoDate = Calendar.getInstance();
		calendarEsttoDate.set(
				Integer.parseInt(getEsttodateyyyy()), 
				Integer.parseInt(getEsttodatemm()) - 1, 
				Integer.parseInt(getEsttodatedd()),
				Integer.parseInt(getEsttotimehh()),
				Integer.parseInt(getEsttotimemm()),
				0
				);	
        if (calendarEsttoDate.before(calendarEstfromDate))
            errors.add("esttodatedd",
                    new ActionMessage("error.esttodate.afterestfromdate"));  
	
       } catch(Exception e) {}
       
       try {
		Calendar calendarActfromDate = Calendar.getInstance();
		calendarActfromDate.set(
				Integer.parseInt(getActfromdateyyyy()), 
				Integer.parseInt(getActfromdatemm()) - 1, 
				Integer.parseInt(getActfromdatedd()),
				Integer.parseInt(getActfromtimehh()),
				Integer.parseInt(getActfromtimemm()),
				0
				);		
		Calendar calendarActtoDate = Calendar.getInstance();
		calendarActtoDate.set(
				Integer.parseInt(getActtodateyyyy()), 
				Integer.parseInt(getActtodatemm()) - 1, 
				Integer.parseInt(getActtodatedd()),
				Integer.parseInt(getActtotimehh()),
				Integer.parseInt(getActtotimemm()),
				0
				);	
        if (calendarActtoDate.before(calendarActfromDate))
            errors.add("acttodatedd",
                    new ActionMessage("error.acttodate.afteractfromdate")); 
       
      } catch(Exception e) {}

      
      
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
