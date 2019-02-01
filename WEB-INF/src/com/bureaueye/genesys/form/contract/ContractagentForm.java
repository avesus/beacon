package com.bureaueye.genesys.form.contract;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;




public final class ContractagentForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
	
	
	// primary key
	private java.lang.String _contractagentId;
	private java.lang.String _contractId;
	
	
	// fields
	private java.lang.String _scheme;
	private java.lang.String _percentamt = "0.0";
	private java.lang.String _lumpsumamt = "0.0";


	// many to one
	private String _agentaddrkey ;
	
	
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
     *  column="CONTRACTAGENT_ID"
     */
	public java.lang.String getContractagentId () {
		return _contractagentId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param __contractagentId the new ID
	 */
	public void setContractagentId (java.lang.String _contractagentId) {
		this._contractagentId = _contractagentId;
	}


	/**
	 * Return the value associated with the column: CONTRACT_ID
	 */
	public java.lang.String getContractId () {
		return _contractId;
	}

	/**
	 * Set the value related to the column: CONTRACT_ID
	 * @param _contractId the CONTRACT_ID value
	 */
	public void setContractId (java.lang.String _contractId) {
		this._contractId = _contractId;
	}
	
	
	
	




	/**
	 * Return the value associated with the column: scheme
	 */
	public java.lang.String getScheme () {
		return _scheme;
	}

	/**
	 * Set the value related to the column: scheme
	 * @param _scheme the scheme value
	 */
	public void setScheme (java.lang.String _scheme) {
		this._scheme = _scheme;
	}


	/**
	 * Return the value associated with the column: percentamt
	 */
	public java.lang.String getPercentamt () {
		return _percentamt;
	}

	/**
	 * Set the value related to the column: percentamt
	 * @param _percentamt the percentamt value
	 */
	public void setPercentamt (java.lang.String _percentamt) {
		this._percentamt = _percentamt;
	}




	/**
	 * Return the value associated with the column: lumpsumamt
	 */
	public java.lang.String getLumpsumamt () {
		return _lumpsumamt;
	}

	/**
	 * Set the value related to the column: lumpsumamt
	 * @param _lumpsumamt the lumpsumamt value
	 */
	public void setLumpsumamt (java.lang.String _lumpsumamt) {
		this._lumpsumamt = _lumpsumamt;
	}




	/**
     * @hibernate.property
     *  column=agentaddrkey
	 */
	public String getAgentaddrkey () {
		return this._agentaddrkey;
	}

	/**
	 * Set the value related to the column: agentaddrkey
	 * @param _agentaddrkey the agentaddrkey value
	 */
	public void setAgentaddrkey (String _agentaddrkey) {
		this._agentaddrkey = _agentaddrkey;
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
		
      
		addErrorIfBlank(errors, "agentaddrkey", _agentaddrkey, "error.agent.required"); 
		
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
