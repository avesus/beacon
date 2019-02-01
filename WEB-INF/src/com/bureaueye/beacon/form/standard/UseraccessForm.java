package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.util.Util;


/**
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module 
 *
 */
public final class UseraccessForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String copyId = "";
    

	// primary key
	private java.lang.String useraccessId;

	// fields
	private java.lang.String userid;
	private java.lang.String accessid;
	private java.lang.String txt;

	
	
    


	private String[] arraygrantactionlist;	
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}


    /**
     */
    public String getCopyId() {return (this.copyId);}
    public void setCopyId(String copyId) {this.copyId = copyId;}
    

	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="USERACCESS_ID"
     */
	public java.lang.String getUseraccessId () {
		return useraccessId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param useraccessId the new ID
	 */
	public void setUseraccessId (java.lang.String useraccessId) {
		this.useraccessId = useraccessId;
	}




	/**
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: userid
	 * @param userid the userid value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
	}



	/**
	 * Return the value associated with the column: accessid
	 */
	public java.lang.String getAccessid () {
		return accessid;
	}

	/**
	 * Set the value related to the column: accessid
	 * @param accessid the accessid value
	 */
	public void setAccessid (java.lang.String accessid) {
		this.accessid = accessid;
	}





	/**
	 * Return the value associated with the column: txt
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: txt
	 * @param txt the txt value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}









	public String getGrantactionlist() {
		return concatArray(arraygrantactionlist);
	}

	public void setGrantactionlist(String grantactionlist) {
		if (grantactionlist != null) {
			arraygrantactionlist = grantactionlist.split("\\|");
		}
	}
	
	public void setArraygrantactionlist(String[] arraygrantactionlist) {
		this.arraygrantactionlist = arraygrantactionlist;
	}

	public String[] getArraygrantactionlist() {
		return arraygrantactionlist;
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
		
		addErrorIfBlank(errors, "accessid", accessid, "error.accessid.required");        	

		if (_action.equals("Create")) {
			if (Util.invalidChars(this.accessid)) errors.add("accessid", new ActionMessage("error.accessid.invalidchars"));
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
