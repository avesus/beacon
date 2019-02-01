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




public final class OnhireeqpForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
	
	
	// primary key
	private java.lang.String _onhireeqpId;
	private java.lang.String _onhireId;
	
	
	// fields
	private java.lang.String _mindays = "0";
	private java.lang.String _dppfreedays = "0";
	private java.lang.String _freedays = "0";

	private java.lang.String _productkey;
	
	private java.lang.String _unitId;
	private java.lang.String _unitkey;
	
	private java.lang.String _onhiredatedd;
	private java.lang.String _onhiredatemm;
	private java.lang.String _onhiredateyyyy;
	private java.lang.String _onhiretimehh;
	private java.lang.String _onhiretimemm;
	private java.lang.String _onhiretimess;
	private java.lang.String _onhiretimeinmillis;	

	private java.lang.String _reservedatedd;
	private java.lang.String _reservedatemm;
	private java.lang.String _reservedateyyyy;
	private java.lang.String _reservetimehh;
	private java.lang.String _reservetimemm;
	private java.lang.String _reservetimeinmillis;		

	private java.util.Date _billstartdate;
	
	private boolean _msdsflag;
	private boolean _cleanflag;
	private boolean _diflag;
	private boolean _reserveflag;
	private boolean _actualflag;	
	private boolean _billstart;	
	
	
	// collections

	
    public String getCopyId() {return (this._copyId);}
    public void setCopyId(String _copyId) {this._copyId = _copyId;}
    
    
	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ONHIREEQP_ID"
     */
	public java.lang.String getOnhireeqpId () {
		return _onhireeqpId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _onhireeqpId the new ID
	 */
	public void setOnhireeqpId (java.lang.String _onhireeqpId) {
		this._onhireeqpId = _onhireeqpId;
	}


	/**
	 * Return the value associated with the column: ONHIRE_ID
	 */
	public java.lang.String getOnhireId () {
		return _onhireId;
	}

	/**
	 * Set the value related to the column: CONTRACT_ID
	 * @param _onhireId the ONHIRE_ID value
	 */
	public void setOnhireId (java.lang.String _onhireId) {
		this._onhireId = _onhireId;
	}
	
	
	public Date getOnhiredate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getOnhiredateyyyy()), Integer
						.parseInt(getOnhiredatemm()) - 1, Integer
						.parseInt(getOnhiredatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setOnhiredate(Date estfromdate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(estfromdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setOnhiredateyyyy(c.get(Calendar.YEAR) + "");
		setOnhiredatemm((month < 10 ? "0" : "") + month);
		setOnhiredatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setOnhiredateyyyy("0000");
			setOnhiredatemm("00");
			setOnhiredatedd("00");			
		}
	}
	public String getOnhiredatedd () {return _onhiredatedd;}
	public void setOnhiredatedd (String _onhiredatedd) {this._onhiredatedd = _onhiredatedd;}
	public String getOnhiredatemm () {return _onhiredatemm;}
	public void setOnhiredatemm (String _onhiredatemm) {this._onhiredatemm = _onhiredatemm;}
	public String getOnhiredateyyyy () {return _onhiredateyyyy;}
	public void setOnhiredateyyyy (String _onhiredateyyyy) {this._onhiredateyyyy = _onhiredateyyyy;}

	public String getOnhiretime() {
		try {
		String time = getOnhiretimehh()+":"+getOnhiretimemm();
		return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setOnhiretime(String onhiretime) {
		try {
		String hh = "00";
		try{hh = onhiretime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = onhiretime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setOnhiretimehh(hh);
		setOnhiretimemm(mm);
		} catch (Exception e) {
			setOnhiretimehh("00");
			setOnhiretimemm("00");			
		}
	}
	public String getOnhiretimehh () {return _onhiretimehh;}
	public void setOnhiretimehh (String _onhiretimehh) {this._onhiretimehh = _onhiretimehh;}
	public String getOnhiretimemm () {return _onhiretimemm;}
	public void setOnhiretimemm (String _onhiretimemm) {this._onhiretimemm = _onhiretimemm;}
	public String getOnhiretimess () {return _onhiretimess;}
	public void setOnhiretimess (String _onhiretimess) {this._onhiretimess = _onhiretimess;}
	
	public long getOnhiretimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getOnhiredateyyyy()), 
					Integer.parseInt(getOnhiredatemm()) - 1, 
					Integer.parseInt(getOnhiredatedd()),
					Integer.parseInt(getOnhiretimehh()),
					Integer.parseInt(getOnhiretimemm()),
					Integer.parseInt(getOnhiretimess())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setOnhiretimeinmillis(String _onhiretimeinmillis)	{
		this._onhiretimeinmillis = _onhiretimeinmillis;	
	}
	

	
	
	public Date getReservedate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getReservedateyyyy()), Integer
						.parseInt(getReservedatemm()) - 1, Integer
						.parseInt(getReservedatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setReservedate(Date reservedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(reservedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setReservedateyyyy(c.get(Calendar.YEAR) + "");
		setReservedatemm((month < 10 ? "0" : "") + month);
		setReservedatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setReservedateyyyy("0000");
			setReservedatemm("00");
			setReservedatedd("00");			
		}
	}
	public String getReservedatedd () {return _reservedatedd;}
	public void setReservedatedd (String _reservedatedd) {this._reservedatedd = _reservedatedd;}
	public String getReservedatemm () {return _reservedatemm;}
	public void setReservedatemm (String _reservedatemm) {this._reservedatemm = _reservedatemm;}
	public String getReservedateyyyy () {return _reservedateyyyy;}
	public void setReservedateyyyy (String _reservedateyyyy) {this._reservedateyyyy = _reservedateyyyy;}

	public String getReservetime() {
		try {
		String time = getReservetimehh()+":"+getReservetimemm();
		return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setReservetime(String reservetime) {
		try {
		String hh = "00";
		try{hh = reservetime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = reservetime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setReservetimehh(hh);
		setReservetimemm(mm);
		} catch (Exception e) {
			setReservetimehh("00");
			setReservetimemm("00");			
		}
	}
	public String getReservetimehh () {return _reservetimehh;}
	public void setReservetimehh (String _reservetimehh) {this._reservetimehh = _reservetimehh;}
	public String getReservetimemm () {return _reservetimemm;}
	public void setReservetimemm (String _reservetimemm) {this._reservetimemm = _reservetimemm;}
	
	public long getReservetimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getReservedateyyyy()), 
					Integer.parseInt(getReservedatemm()) - 1, 
					Integer.parseInt(getReservedatedd()),
					Integer.parseInt(getReservetimehh()),
					Integer.parseInt(getReservetimemm())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setReservetimeinmillis(String _reservetimeinmillis)	{
		this._reservetimeinmillis = _reservetimeinmillis;	
	}
	
	
	
	
	/**
	 * Return the value associated with the column: diflag
	 */
	public boolean isDiflag () {
		return _diflag;
	}

	/**
	 * Set the value related to the column: diflag
	 * @param _diflag the diflag value
	 */
	public void setDiflag (boolean _diflag) {
		this._diflag = _diflag;
	}




	/**
	 * Return the value associated with the column: reserveflag
	 */
	public boolean isReserveflag () {
		return _reserveflag;
	}

	/**
	 * Set the value related to the column: reserveflag
	 * @param _reserveflag the reserveflag value
	 */
	public void setReserveflag (boolean _reserveflag) {
		this._reserveflag = _reserveflag;
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
	 * Return the value associated with the column: actualflag
	 */
	public boolean isActualflag () {
		return _actualflag;
	}

	/**
	 * Set the value related to the column: actualflag
	 * @param _actualflag the actualflag value
	 */
	public void setActualflag (boolean _actualflag) {
		this._actualflag = _actualflag;
	}



	/**
	 * Return the value associated with the column: billstart
	 */
	public boolean isBillstart () {
		return _billstart;
	}

	/**
	 * Set the value related to the column: billstart
	 * @param _billstart the billstart value
	 */
	public void setBillstart (boolean _billstart) {
		this._billstart = _billstart;
	}
	
	

	/**
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return _productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param _productkey the productkey value
	 */
	public void setProductkey (java.lang.String _productkey) {
		this._productkey = _productkey;
	}




	/**
	 * Return the value associated with the column: dppfreedays
	 */
	public java.lang.String getDppfreedays () {
		return _dppfreedays;
	}

	/**
	 * Set the value related to the column: dppfreedays
	 * @param _dppfreedays the dppfreedays value
	 */
	public void setDppfreedays (java.lang.String _dppfreedays) {
		this._dppfreedays = _dppfreedays;
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
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.String getUnitId () {
		return _unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param _unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.String _unitId) {
		this._unitId = _unitId;
	}



	/**
	 * Return the value associated with the column: cleanflag
	 */
	public boolean isCleanflag () {
		return _cleanflag;
	}

	/**
	 * Set the value related to the column: cleanflag
	 * @param _cleanflag the cleanflag value
	 */
	public void setCleanflag (boolean _cleanflag) {
		this._cleanflag = _cleanflag;
	}





	/**
	 * Return the value associated with the column: billstartdate
	 */
	public java.util.Date getBillstartdate () {
		return _billstartdate;
	}

	/**
	 * Set the value related to the column: billstartdate
	 * @param _billstartdate the billstartdate value
	 */
	public void setBillstartdate (java.util.Date _billstartdate) {
		this._billstartdate = _billstartdate;
	}


	/**
	 * Return the value associated with the column: msdsflag
	 */
	public boolean isMsdsflag () {
		return _msdsflag;
	}

	/**
	 * Set the value related to the column: msdsflag
	 * @param _msdsflag the msdsflag value
	 */
	public void setMsdsflag (boolean _msdsflag) {
		this._msdsflag = _msdsflag;
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
		
		addErrorIfBlank(errors, "unitkey", _unitkey, "error.unitkey.required");      

        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_reservedateyyyy+"-"+
    								_reservedatemm+"-"+ 
    								_reservedatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("reservedatedd", new ActionMessage("error.reservedate.required"));

        
		if (this.isActualflag()) {			
	        date = null;
	        try {
	    		date = (java.util.Date)dateFormatter.unformat(
	    								_onhiredateyyyy+"-"+
	    								_onhiredatemm+"-"+ 
	    								_onhiredatedd
										);
	        } catch (Exception e) {}	        	
	        if (date == null) {
	        	errors.add("onhiredatedd", new ActionMessage("error.onhiredate.required"));
		        this.setActualflag(false);	
	        }	
		}
		
		
        
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
