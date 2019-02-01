package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.formatter.DateFormatter;


public final class UnittestForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
	
	// primary key
	private java.lang.String _unittestId;
	private java.lang.String _unitId;
	
	// fields
	private java.lang.String _duedatedd;
	private java.lang.String _duedatemm;
	private java.lang.String _duedateyyyy;

	private java.lang.String _compdatedd;
	private java.lang.String _compdatemm;
	private java.lang.String _compdateyyyy;
	
	private java.lang.String _lasttestdatedd;
	private java.lang.String _lasttestdatemm;
	private java.lang.String _lasttestdateyyyy;
		
	private boolean _deleted;
	private boolean _completed;
	private boolean _maintest;
	
	private java.lang.String _mandrlinkkey;
	private java.lang.String _period = "0";
	private java.lang.String _testtypekey;
	private java.lang.String _frequency;	
	private java.lang.String _mandrkey;
	private java.lang.String _testby;
	private java.lang.String _descr;
	private java.lang.String _unitkey;
	private java.lang.String _xrate = "0.0";
	private java.lang.String _reading = "0.0";
	
	private String _depotaddrkey;
	
	

	

	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	

	/**
	 */
	public java.lang.String getUnitId () {return _unitId;}
	/**
	 */
	public void setUnitId (java.lang.String _unitId) {this._unitId = _unitId;}
	
	/**
	 */
	public java.lang.String getUnittestId () {return _unittestId;}
	/**
	 */
	public void setUnittestId (java.lang.String _unittestId) {this._unittestId = _unittestId;}
	
	
	
	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return _deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param _deleted the deleted value
	 */
	public void setDeleted (boolean _deleted) {
		this._deleted = _deleted;
	}


	/**
	 * Return the value associated with the column: mandrlinkkey
	 */
	public String getMandrlinkkey () {
		return _mandrlinkkey;
	}

	/**
	 * Set the value related to the column: mandrlinkkey
	 * @param _mandrlinkkey the mandrlinkkey value
	 */
	public void setMandrlinkkey (String _mandrlinkkey) {
		this._mandrlinkkey = _mandrlinkkey;
	}


	/**
	 * Return the value associated with the column: period
	 */
	public String getPeriod () {
		return _period;
	}

	/**
	 * Set the value related to the column: period
	 * @param _period the period value
	 */
	public void setPeriod (String _period) {
		this._period = _period;
	}




	/**
	 * Return the value associated with the column: testtypekey
	 */
	public java.lang.String getTesttypekey () {
		return _testtypekey;
	}

	/**
	 * Set the value related to the column: testtypekey
	 * @param _testtypekey the testtypekey value
	 */
	public void setTesttypekey (java.lang.String _testtypekey) {
		this._testtypekey = _testtypekey;
	}


	/**
	 * Return the value associated with the column: frequency
	 */
	public java.lang.String getFrequency () {
		return _frequency;
	}

	/**
	 * Set the value related to the column: frequency
	 * @param _frequency the frequency value
	 */
	public void setFrequency (java.lang.String _frequency) {
		this._frequency = _frequency;
	}




	/**
	 * Return the value associated with the column: mandrkey
	 */
	public java.lang.String getMandrkey () {
		return _mandrkey;
	}

	/**
	 * Set the value related to the column: mandrkey
	 * @param _mandrkey the mandrkey value
	 */
	public void setMandrkey (java.lang.String _mandrkey) {
		this._mandrkey = _mandrkey;
	}


	/**
	 * Return the value associated with the column: completed
	 */
	public boolean isCompleted () {
		return _completed;
	}

	/**
	 * Set the value related to the column: completed
	 * @param _completed the completed value
	 */
	public void setCompleted (boolean _completed) {
		this._completed = _completed;
	}


	/**
	 * Return the value associated with the column: maintest
	 */
	public boolean isMaintest () {
		return _maintest;
	}

	/**
	 * Set the value related to the column: maintest
	 * @param _maintest the maintest value
	 */
	public void setMaintest (boolean _maintest) {
		this._maintest = _maintest;
	}


	/**
	 * Return the value associated with the column: testby
	 */
	public java.lang.String getTestby () {
		return _testby;
	}

	/**
	 * Set the value related to the column: testby
	 * @param _testby the testby value
	 */
	public void setTestby (java.lang.String _testby) {
		this._testby = _testby;
	}


	/**
	 * Return the value associated with the column: descr
	 */
	public java.lang.String getDescr () {
		return _descr;
	}

	/**
	 * Set the value related to the column: descr
	 * @param _descr the descr value
	 */
	public void setDescr (java.lang.String _descr) {
		this._descr = _descr;
	}


	/**
	 * Return the value associated with the column: depotaddrkey
	 */
	public String getDepotaddrkey () {
		return _depotaddrkey;
	}

	/**
	 * Set the value related to the column: depotaddrkey
	 * @param _depotaddrkey the depotaddrkey value
	 */
	public void setDepotaddrkey (String _depotaddrkey) {
		this._depotaddrkey = _depotaddrkey;
	}


	/**
	 * Return the value associated with the column: reading
	 */
	public String getReading () {
		return _reading;
	}

	/**
	 * Set the value related to the column: reading
	 * @param _reading the reading value
	 */
	public void setReading (String _reading) {
		this._reading = _reading;
	}






	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return _unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param _unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String _unitkey) {
		this._unitkey = _unitkey;
	}


	/**
	 * Return the value associated with the column: xrate
	 */
	public String getXrate () {
		return _xrate;
	}

	/**
	 * Set the value related to the column: xrate
	 * @param _xrate the xrate value
	 */
	public void setXrate (String _xrate) {
		this._xrate = _xrate;
	}

	
	
	
	
	public Date getDuedate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getDuedateyyyy()), Integer
						.parseInt(getDuedatemm()) - 1, Integer
						.parseInt(getDuedatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setDuedate(Date _duedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(_duedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setDuedateyyyy(c.get(Calendar.YEAR) + "");
		setDuedatemm((month < 10 ? "0" : "") + month);
		setDuedatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setDuedateyyyy("0000");
			setDuedatemm("00");
			setDuedatedd("00");			
		}
	}
	public String getDuedatedd () {return _duedatedd;}
	public void setDuedatedd (String _duedatedd) {this._duedatedd = _duedatedd;}
	public String getDuedatemm () {return _duedatemm;}
	public void setDuedatemm (String _duedatemm) {this._duedatemm = _duedatemm;}
	public String getDuedateyyyy () {return _duedateyyyy;}
	public void setDuedateyyyy (String _duedateyyyy) {this._duedateyyyy = _duedateyyyy;}


	public Date getCompdate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getCompdateyyyy()), Integer
						.parseInt(getCompdatemm()) - 1, Integer
						.parseInt(getCompdatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setCompdate(Date _duedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(_duedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setCompdateyyyy(c.get(Calendar.YEAR) + "");
		setCompdatemm((month < 10 ? "0" : "") + month);
		setCompdatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setCompdateyyyy("0000");
			setCompdatemm("00");
			setCompdatedd("00");			
		}
	}
	public String getCompdatedd () {return _compdatedd;}
	public void setCompdatedd (String _compdatedd) {this._compdatedd = _compdatedd;}
	public String getCompdatemm () {return _compdatemm;}
	public void setCompdatemm (String _compdatemm) {this._compdatemm = _compdatemm;}
	public String getCompdateyyyy () {return _compdateyyyy;}
	public void setCompdateyyyy (String _compdateyyyy) {this._compdateyyyy = _compdateyyyy;}

	
	public Date getLasttestdate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getLasttestdateyyyy()), Integer
						.parseInt(getLasttestdatemm()) - 1, Integer
						.parseInt(getLasttestdatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setLasttestdate(Date _duedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(_duedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setLasttestdateyyyy(c.get(Calendar.YEAR) + "");
		setLasttestdatemm((month < 10 ? "0" : "") + month);
		setLasttestdatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setLasttestdateyyyy("0000");
			setLasttestdatemm("00");
			setLasttestdatedd("00");			
		}
	}
	public String getLasttestdatedd () {return _lasttestdatedd;}
	public void setLasttestdatedd (String _lasttestdatedd) {this._lasttestdatedd = _lasttestdatedd;}
	public String getLasttestdatemm () {return _lasttestdatemm;}
	public void setLasttestdatemm (String _lasttestdatemm) {this._lasttestdatemm = _lasttestdatemm;}
	public String getLasttestdateyyyy () {return _lasttestdateyyyy;}
	public void setLasttestdateyyyy (String _lasttestdateyyyy) {this._lasttestdateyyyy = _lasttestdateyyyy;}

	
	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
        if ((_testtypekey == null) || (_testtypekey.length() < 1))
            errors.add("testtypekey",
                    new ActionMessage("error.testtype.required")); 
        
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_duedateyyyy+"-"+
    								_duedatemm+"-"+ 
    								_duedatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("duedatedd", new ActionMessage("error.duedate.required"));        	

      
		return errors;

	}

/*	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}*/

	
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
