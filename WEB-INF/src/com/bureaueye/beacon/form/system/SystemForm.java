package com.bureaueye.beacon.form.system;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;


import com.bureaueye.beacon.form.BaseForm;




public final class SystemForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";


	// primary key
	private String systemId;

	// fields
	private java.lang.String systemtaskstop;
	private java.lang.String ediid;
	private java.lang.String certifpath;
	private java.lang.String certifdir;
	private java.lang.String ccykey;
	private String systemtaskagentsleep;

	
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SYSTEM_ID"
     */
	public String getSystemId () {
		return systemId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param systemId the new ID
	 */
	public void setSystemId (String systemId) {
		this.systemId = systemId;
	}




	/**
	 * Return the value associated with the column: systemtaskstop
	 */
	public java.lang.String getSystemtaskstop () {
		return systemtaskstop;
	}

	/**
	 * Set the value related to the column: systemtaskstop
	 * @param systemtaskstop the systemtaskstop value
	 */
	public void setSystemtaskstop (java.lang.String systemtaskstop) {
		this.systemtaskstop = systemtaskstop;
	}



	/**
	 * Return the value associated with the column: ediid
	 */
	public java.lang.String getEdiid () {
		return ediid;
	}

	/**
	 * Set the value related to the column: ediid
	 * @param ediid the ediid value
	 */
	public void setEdiid (java.lang.String ediid) {
		this.ediid = ediid;
	}



	/**
	 * Return the value associated with the column: certifpath
	 */
	public java.lang.String getCertifpath () {
		return certifpath;
	}

	/**
	 * Set the value related to the column: certifpath
	 * @param certifpath the certifpath value
	 */
	public void setCertifpath (java.lang.String certifpath) {
		this.certifpath = certifpath;
	}



	/**
	 * Return the value associated with the column: certifdir
	 */
	public java.lang.String getCertifdir () {
		return certifdir;
	}

	/**
	 * Set the value related to the column: certifdir
	 * @param certifdir the certifdir value
	 */
	public void setCertifdir (java.lang.String certifdir) {
		this.certifdir = certifdir;
	}



	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
	}



	/**
	 * Return the value associated with the column: systemtaskagentsleep
	 */
	public String getSystemtaskagentsleep () {
		return systemtaskagentsleep;
	}

	/**
	 * Set the value related to the column: systemtaskagentsleep
	 * @param systemtaskagentsleep the systemtaskagentsleep value
	 */
	public void setSystemtaskagentsleep (String systemtaskagentsleep) {
		this.systemtaskagentsleep = systemtaskagentsleep;
	}


	
	

	@Override
	public String toString () {
		return super.toString();
	}


	
	

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();
		
       	
   
		
      
		return errors;

	}


	
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	@Override
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();
		
		return keysToSkip;
	}
	
	
}
