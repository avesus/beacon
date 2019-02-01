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


public final class MovementForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
	
	// primary key
	private java.lang.String _movementId;
	private java.lang.String _unitId;
	
	// fields
	private java.lang.String _onhireeqpId;
	private java.lang.String _offhireeqpId;
	
	private java.lang.String _moveref;
	private java.lang.String _notes;

	private java.lang.String _invsts;
	private java.lang.String _movests;

	private java.lang.String _movedatedd;
	private java.lang.String _movedatemm;
	private java.lang.String _movedateyyyy;
	private java.lang.String _movetimehh;
	private java.lang.String _movetimemm;
	private java.lang.String _movetimess;	
	private java.lang.String _movetimeinmillis;	
	
	private java.lang.String _unitkey;
	private java.lang.String _moveproductkey;

	// many to one
	private String _moveaddrkey;
	private String _movelocationkey;
	
	
	

	

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
	public java.lang.String getMovementId () {return _movementId;}
	/**
	 */
	public void setMovementId (java.lang.String _movementId) {this._movementId = _movementId;}
	
	
	
	/**
	 */
	public java.lang.String getOnhireeqpId () {return _onhireeqpId;}
	/**
	 */
	public void setOnhireeqpId (java.lang.String _onhireeqpId) {this._onhireeqpId = _onhireeqpId;}
	/**
	 */
	public java.lang.String getOffhireeqpId () {return _offhireeqpId;}
	/**
	 */
	public void setOffhireeqpId (java.lang.String _offhireeqpId) {this._offhireeqpId = _offhireeqpId;}


	
	/**
	 * Return the value associated with the column: _moveaddrkey
	 */
	public String getMoveaddrkey () {
		return _moveaddrkey;
	}

	/**
	 * Set the value related to the column: _moveaddrkey
	 * @param __moveaddrkey the _moveaddrkey value
	 */
	public void setMoveaddrkey (String _moveaddrkey) {
		this._moveaddrkey = _moveaddrkey;
	}
	
	
	/**
	 * Set the value related to the column: __movelocationkey
	 * @param ___movelocationkey the __movelocationkey value
	 */
	public void setMovelocationkey (String _movelocationkey) {
		this._movelocationkey = _movelocationkey;
	}


	/**
	 * Return the value associated with the column: __movelocationkey
	 */
	public String getMovelocationkey () {
		return _movelocationkey;
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
	 * Return the value associated with the column: moveproductkey
	 */
	public java.lang.String getMoveproductkey () {
		return _moveproductkey;
	}

	/**
	 * Set the value related to the column: moveproductkey
	 * @param _moveproductkey the moveproductkey value
	 */
	public void setMoveproductkey (java.lang.String _moveproductkey) {
		this._moveproductkey = _moveproductkey;
	}
	
	
	
	public Date getMovedate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getMovedateyyyy()), Integer
						.parseInt(getMovedatemm()) - 1, Integer
						.parseInt(getMovedatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setMovedate(Date _movedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(_movedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setMovedateyyyy(c.get(Calendar.YEAR) + "");
		setMovedatemm((month < 10 ? "0" : "") + month);
		setMovedatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setMovedateyyyy("0000");
			setMovedatemm("00");
			setMovedatedd("00");			
		}
	}
	public String getMovedatedd () {return _movedatedd;}
	public void setMovedatedd (String _movedatedd) {this._movedatedd = _movedatedd;}
	public String getMovedatemm () {return _movedatemm;}
	public void setMovedatemm (String _movedatemm) {this._movedatemm = _movedatemm;}
	public String getMovedateyyyy () {return _movedateyyyy;}
	public void setMovedateyyyy (String _movedateyyyy) {this._movedateyyyy = _movedateyyyy;}

	public String getMovetime() {
		try {
		String time = getMovetimehh()+":"+getMovetimemm();
		return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setMovetime(String movetime) {
		try {
		String hh = "00";
		try{hh = movetime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = movetime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setMovetimehh(hh);
		setMovetimemm(mm);
		} catch (Exception e) {
			setMovetimehh("00");
			setMovetimemm("00");			
		}
	}
	public String getMovetimehh () {return _movetimehh;}
	public void setMovetimehh (String _movetimehh) {this._movetimehh = _movetimehh;}
	public String getMovetimemm () {return _movetimemm;}
	public void setMovetimemm (String _movetimemm) {this._movetimemm = _movetimemm;}
	public String getMovetimess () {return _movetimess;}
	public void setMovetimess (String _movetimess) {this._movetimess = _movetimess;}
	
	public long getMovetimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getMovedateyyyy()), 
					Integer.parseInt(getMovedatemm()) - 1, 
					Integer.parseInt(getMovedatedd()),
					Integer.parseInt(getMovetimehh()),
					Integer.parseInt(getMovetimemm()),
					Integer.parseInt(getMovetimess())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setMovetimeinmillis(String _movetimeinmillis)	{
		this._movetimeinmillis = _movetimeinmillis;	
	}
	
	
	
	/**
	 * Return the value associated with the column: _moveref
	 */
	public java.lang.String getMoveref () {
		return _moveref;
	}

	/**
	 * Set the value related to the column: _moveref
	 * @param __moveref the _moveref value
	 */
	public void setMoveref (java.lang.String _moveref) {
		this._moveref = _moveref;
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
	 * Return the value associated with the column: invsts
	 */
	public java.lang.String getInvsts () {
		return _invsts;
	}

	/**
	 * Set the value related to the column: invsts
	 * @param _invsts the invsts value
	 */
	public void setInvsts (java.lang.String _invsts) {
		this._invsts = _invsts;
	}





	/**
	 * Return the value associated with the column: movests
	 */
	public java.lang.String getMovests () {
		return _movests;
	}

	/**
	 * Set the value related to the column: movests
	 * @param _movests the movests value
	 */
	public void setMovests (java.lang.String _movests) {
		this._movests = _movests;
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
		
        if ((_movelocationkey == null) || (_movelocationkey.equals("")))
            errors.add("movelocationkey",
                    new ActionMessage("error.movelocation.required")); 

        
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_movedateyyyy+"-"+
    								_movedatemm+"-"+ 
    								_movedatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("movedatedd", new ActionMessage("error.movedate.required"));        	

		addErrorIfBlank(errors, "invsts", _invsts, "error.inventorystatus.required");

		
      
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
