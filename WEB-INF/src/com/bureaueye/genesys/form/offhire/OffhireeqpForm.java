package com.bureaueye.genesys.form.offhire;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.formatter.DateFormatter;




public final class OffhireeqpForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
	
	
	// primary key
	private java.lang.String _offhireeqpId;
	private java.lang.String _offhireId;
	private java.lang.String _onhireeqpId;	
	private java.lang.String _onhireId;	
	
	// fields

	private java.lang.String _productkey;
	
	private java.lang.String _unitId;
	private java.lang.String _unitkey;
	
	private java.lang.String _offhiredatedd;
	private java.lang.String _offhiredatemm;
	private java.lang.String _offhiredateyyyy;
	private java.lang.String _offhiretimehh;
	private java.lang.String _offhiretimemm;
	private java.lang.String _offhiretimess;	
	private java.lang.String _offhiretimeinmillis;	

	private java.lang.String _reservedatedd;
	private java.lang.String _reservedatemm;
	private java.lang.String _reservedateyyyy;
	private java.lang.String _reservetimehh;
	private java.lang.String _reservetimemm;
	private java.lang.String _reservetimeinmillis;		

	private java.util.Date _billstopdate;
	
	private boolean _msdsflag;
	private boolean _cleanflag;
	private boolean _diflag;
	private boolean _reserveflag;
	private boolean _actualflag;	
	private boolean _billfinish;	
	
	
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
     *  column="OFFHIREEQP_ID"
     */
	public java.lang.String getOffhireeqpId () {
		return _offhireeqpId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _offhireeqpId the new ID
	 */
	public void setOffhireeqpId (java.lang.String _offhireeqpId) {
		this._offhireeqpId = _offhireeqpId;
	}


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
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ONHIRE_ID"
     */
	public java.lang.String getOnhireId () {
		return _onhireId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _onhireId the new ID
	 */
	public void setOnhireId (java.lang.String _onhireId) {
		this._onhireId = _onhireId;
	}
	
	
	/**
	 * Return the value associated with the column: OFFHIRE_ID
	 */
	public java.lang.String getOffhireId () {
		return _offhireId;
	}

	/**
	 * Set the value related to the column: OFFHIRE_ID
	 * @param _offhireId the OFFHIRE_ID value
	 */
	public void setOffhireId (java.lang.String _offhireId) {
		this._offhireId = _offhireId;
	}
	
	
	public Date getOffhiredate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getOffhiredateyyyy()), Integer
						.parseInt(getOffhiredatemm()) - 1, Integer
						.parseInt(getOffhiredatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setOffhiredate(Date estfromdate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(estfromdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setOffhiredateyyyy(c.get(Calendar.YEAR) + "");
		setOffhiredatemm((month < 10 ? "0" : "") + month);
		setOffhiredatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setOffhiredateyyyy("0000");
			setOffhiredatemm("00");
			setOffhiredatedd("00");			
		}
	}
	public String getOffhiredatedd () {return _offhiredatedd;}
	public void setOffhiredatedd (String _offhiredatedd) {this._offhiredatedd = _offhiredatedd;}
	public String getOffhiredatemm () {return _offhiredatemm;}
	public void setOffhiredatemm (String _offhiredatemm) {this._offhiredatemm = _offhiredatemm;}
	public String getOffhiredateyyyy () {return _offhiredateyyyy;}
	public void setOffhiredateyyyy (String _offhiredateyyyy) {this._offhiredateyyyy = _offhiredateyyyy;}

	public String getOffhiretime() {
		try {
		String time = getOffhiretimehh()+":"+getOffhiretimemm();
		return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setOffhiretime(String offhiretime) {
		try {
		String hh = "00";
		try{hh = offhiretime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = offhiretime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setOffhiretimehh(hh);
		setOffhiretimemm(mm);
		} catch (Exception e) {
			setOffhiretimehh("00");
			setOffhiretimemm("00");			
		}
	}
	public String getOffhiretimehh () {return _offhiretimehh;}
	public void setOffhiretimehh (String _offhiretimehh) {this._offhiretimehh = _offhiretimehh;}
	public String getOffhiretimemm () {return _offhiretimemm;}
	public void setOffhiretimemm (String _offhiretimemm) {this._offhiretimemm = _offhiretimemm;}
	public String getOffhiretimess () {return _offhiretimess;}
	public void setOffhiretimess (String _offhiretimess) {this._offhiretimess = _offhiretimess;}
	
	public long getOffhiretimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getOffhiredateyyyy()), 
					Integer.parseInt(getOffhiredatemm()) - 1, 
					Integer.parseInt(getOffhiredatedd()),
					Integer.parseInt(getOffhiretimehh()),
					Integer.parseInt(getOffhiretimemm()),
					Integer.parseInt(getOffhiretimess())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setOffhiretimeinmillis(String _offhiretimeinmillis)	{
		this._offhiretimeinmillis = _offhiretimeinmillis;	
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
	 * Return the value associated with the column: billfinish
	 */
	public boolean isBillfinish () {
		return _billfinish;
	}

	/**
	 * Set the value related to the column: billfinish
	 * @param _billfinish the billfinish value
	 */
	public void setBillfinish (boolean _billfinish) {
		this._billfinish = _billfinish;
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
	 * Return the value associated with the column: billstopdate
	 */
	public java.util.Date getBillstopdate () {
		return _billstopdate;
	}

	/**
	 * Set the value related to the column: billstopdate
	 * @param _billstopdate the billstopdate value
	 */
	public void setBillstopdate (java.util.Date _billstopdate) {
		this._billstopdate = _billstopdate;
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
	    								_offhiredateyyyy+"-"+
	    								_offhiredatemm+"-"+ 
	    								_offhiredatedd
										);
	        } catch (Exception e) {}	        	
	        if (date == null) {
	        	errors.add("offhiredatedd", new ActionMessage("error.offhiredate.required"));
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
