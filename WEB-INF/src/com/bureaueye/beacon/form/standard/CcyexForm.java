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


public final class CcyexForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";

	// primary key
	private java.lang.String _ccyexId;

	
	// fields
	private java.lang.String _fromccykey;
	private java.lang.String _toccykey;

	private java.lang.String _exrate = "0.0";
	
	private java.lang.String _exdatedd;
	private java.lang.String _exdatemm;
	private java.lang.String _exdateyyyy;
	
	
	// collections
	

	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	

	/**
	 */
	public java.lang.String getCcyexId () {return _ccyexId;}
	/**
	 */
	public void setCcyexId (java.lang.String _ccyexId) {this._ccyexId = _ccyexId;}


	/**
	 */
	public java.lang.String getFromccykey () {return _fromccykey;}
	/**
	 */
	public void setFromccykey (java.lang.String _fromccykey) {this._fromccykey = _fromccykey;}
	
	
	/**
	 */
	public java.lang.String getToccykey () {return _toccykey;}
	/**
	 */
	public void setToccykey (java.lang.String _toccykey) {this._toccykey = _toccykey;}
	
	
	/**
	 */
	public java.lang.String getExrate () {return _exrate;}
	/**
	 */
	public void setExrate (java.lang.String _exrate) {this._exrate = _exrate;}
	


	public Date getExdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getExdateyyyy()), Integer
						.parseInt(getExdatemm()) - 1, Integer
						.parseInt(getExdatedd()));
		return c.getTime();
	}
	public void setExdate(Date _exdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(_exdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setExdateyyyy(c.get(Calendar.YEAR) + "");
		setExdatemm((month < 10 ? "0" : "") + month);
		setExdatedd((day < 10 ? "0" : "") + day);
	}
	public String getExdatedd () {return _exdatedd;}
	public void setExdatedd (String _exdatedd) {this._exdatedd = _exdatedd;}
	public String getExdatemm () {return _exdatemm;}
	public void setExdatemm (String _exdatemm) {this._exdatemm = _exdatemm;}
	public String getExdateyyyy () {return _exdateyyyy;}
	public void setExdateyyyy (String _exdateyyyy) {this._exdateyyyy = _exdateyyyy;}


	


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
		       	
        
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								_exdateyyyy+"-"+
									_exdatemm+"-"+ 
									_exdatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("exdatedd", new ActionMessage("error.exdate.notvalid")); 
        
      
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
