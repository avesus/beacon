package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;




public final class DocnoForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";


	// primary key
	private java.lang.String docnoId;
	
	// fields
	private java.lang.String docnocount;
	private java.lang.String docnofrom;
	private java.lang.String doctype;
	private java.lang.String docnoto;
	private java.lang.String companykey;
	
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	


	public java.lang.String getDocnoId () {
		return docnoId;
	}
	public void setDocnoId (java.lang.String docnoId) {
		this.docnoId = docnoId;
	}


	public java.lang.String getCompanykey () {
		return companykey;
	}
	public void setCompanykey (java.lang.String companykey) {
		this.companykey = companykey;
	}



	public java.lang.String getDocnocount () {
		return docnocount;
	}
	public void setDocnocount (java.lang.String docnocount) {
		this.docnocount = docnocount;
	}




	public java.lang.String getDocnofrom () {
		return docnofrom;
	}
	public void setDocnofrom (java.lang.String docnofrom) {
		this.docnofrom = docnofrom;
	}


	
	public java.lang.String getDocnoto () {
		return docnoto;
	}
	public void setDocnoto (java.lang.String docnoto) {
		this.docnoto = docnoto;
	}
	
	

	public java.lang.String getDoctype () {
		return doctype;
	}
	public void setDoctype (java.lang.String doctype) {
		this.doctype = doctype;
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
		
       	

		addErrorIfBlank(errors, "doctype", doctype, "error.doctype.required");
		addErrorIfBlank(errors, "companykey", companykey, "error.company.required");		
		addErrorIfBlank(errors, "docnofrom", docnofrom, "error.docnofrom.required");      
		addErrorIfBlank(errors, "docnoto", docnoto, "error.docnoto.required");        
		addErrorIfBlank(errors, "docnocount", docnocount, "error.docnocount.required");      
		
      
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
	@Override
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();
		
		return keysToSkip;
	}
	
	
}
