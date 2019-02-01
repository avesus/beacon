package com.bureaueye.beacon.form.salesinvoice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;

 

/**
 * 
 * Amendments ----------
 * 
 * NT	2013-12-12	WSI-201312-0002	BEACON LAKER (WSI LINER) - Generate Vessel Manifest Sales Invoices
 * 
 */
public final class SidocnoForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";


	// primary key
	private java.lang.String sidocnoId;
	
	// fields
	private java.lang.String doctype;
	
	private java.lang.String docnocount;
	private java.lang.String docnofrom;
	private java.lang.String docnoto;
	
	private java.lang.String businessyear;
	
	private java.lang.String companykey;
	private java.lang.String departmentkey;
	private java.lang.String activitykey;
	
	private java.lang.String docnoprefix;
	private java.lang.String docnosuffix;
	private java.lang.String docnoformat;
	
	
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}

	


	public java.lang.String getSidocnoId () {
		return sidocnoId;
	}
	public void setSidocnoId (java.lang.String sidocnoId) {
		this.sidocnoId = sidocnoId;
	}


	public java.lang.String getBusinessyear () {
		return businessyear;
	}
	public void setBusinessyear (java.lang.String businessyear) {
		this.businessyear = businessyear;
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





	public java.lang.String getDepartmentkey () {
		return departmentkey;
	}
	public void setDepartmentkey (java.lang.String departmentkey) {
		this.departmentkey = departmentkey;
	}
	

	public java.lang.String getActivitykey () {
		return activitykey;
	}
	public void setActivitykey (java.lang.String activitykey) {
		this.activitykey = activitykey;
	}
	
	
	

	public java.lang.String getDocnoprefix () {
		return docnoprefix;
	}
	public void setDocnoprefix (java.lang.String docnoprefix) {
		this.docnoprefix = docnoprefix;
	}

	public java.lang.String getDocnosuffix () {
		return docnosuffix;
	}
	public void setDocnosuffix (java.lang.String docnosuffix) {
		this.docnosuffix = docnosuffix;
	}

	public java.lang.String getDocnoformat () {
		return docnoformat;
	}
	public void setDocnoformat (java.lang.String docnoformat) {
		this.docnoformat = docnoformat;
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
		addErrorIfBlank(errors, "docnofrom", docnofrom, "error.docnofrom.required");      
		addErrorIfBlank(errors, "docnoto", docnoto, "error.docnoto.required");        
		addErrorIfBlank(errors, "docnocount", docnocount, "error.docnocount.required");      
		addErrorIfBlank(errors, "companykey", companykey, "error.company.required");  
		addErrorIfBlank(errors, "businessyear", businessyear, "error.businessyear.required");  
		
      
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
