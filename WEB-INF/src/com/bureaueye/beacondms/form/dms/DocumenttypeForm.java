package com.bureaueye.beacondms.form.dms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;



/**
 *
 * Amendments
 * ----------
 *  
 */
public final class DocumenttypeForm extends BaseForm {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";



	// primary key
	private java.lang.String documenttypeId;

	// fields
	private java.lang.String description;
	private java.lang.String doctype;
	private java.lang.String languageid;
	private java.lang.String testindicator;
	private java.lang.String buildclass;
	private java.lang.String departmentkey;
	private java.lang.String companykey;
	private java.lang.String activitykey;
	private java.lang.String categorycode;	
	private java.lang.String subcategorycode;	
	
	private java.lang.String pagesize;
	private java.lang.String leftmargin;
	private java.lang.String rightmargin;
	private java.lang.String topmargin;
	private java.lang.String bottommargin;

	
	


	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="DOCUMENTTYPE_ID"
     */
	public java.lang.String getDocumenttypeId () {
		return documenttypeId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param documenttypeId the new ID
	 */
	public void setDocumenttypeId (java.lang.String documenttypeId) {
		this.documenttypeId = documenttypeId;
	}




	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: doctype
	 */
	public java.lang.String getDoctype () {
		return doctype;
	}

	/**
	 * Set the value related to the column: doctype
	 * @param doctype the doctype value
	 */
	public void setDoctype (java.lang.String doctype) {
		this.doctype = doctype;
	}



	/**
	 * Return the value associated with the column: languageid
	 */
	public java.lang.String getLanguageid () {
		return languageid;
	}

	/**
	 * Set the value related to the column: languageid
	 * @param languageid the languageid value
	 */
	public void setLanguageid (java.lang.String languageid) {
		this.languageid = languageid;
	}



	/**
	 * Return the value associated with the column: testindicator
	 */
	public java.lang.String getTestindicator () {
		return testindicator;
	}

	/**
	 * Set the value related to the column: testindicator
	 * @param testindicator the testindicator value
	 */
	public void setTestindicator (java.lang.String testindicator) {
		this.testindicator = testindicator;
	}



	/**
	 * Return the value associated with the column: buildclass
	 */
	public java.lang.String getBuildclass () {
		return buildclass;
	}

	/**
	 * Set the value related to the column: buildclass
	 * @param buildclass the buildclass value
	 */
	public void setBuildclass (java.lang.String buildclass) {
		this.buildclass = buildclass;
	}



	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String departmentkey) {
		this.departmentkey = departmentkey;
	}



	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param companykey the companykey value
	 */
	public void setCompanykey (java.lang.String companykey) {
		this.companykey = companykey;
	}



	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String activitykey) {
		this.activitykey = activitykey;
	}




	/**
	 * Return the value associated with the column: pagesize
	 */
	public java.lang.String getPagesize () {
		return pagesize;
	}

	/**
	 * Set the value related to the column: pagesize
	 * @param pagesize the pagesize value
	 */
	public void setPagesize (java.lang.String pagesize) {
		this.pagesize = pagesize;
	}



	/**
	 * Return the value associated with the column: leftmargin
	 */
	public java.lang.String getLeftmargin () {
		return leftmargin;
	}

	/**
	 * Set the value related to the column: leftmargin
	 * @param leftmargin the leftmargin value
	 */
	public void setLeftmargin (java.lang.String leftmargin) {
		this.leftmargin = leftmargin;
	}



	/**
	 * Return the value associated with the column: rightmargin
	 */
	public java.lang.String getRightmargin () {
		return rightmargin;
	}

	/**
	 * Set the value related to the column: rightmargin
	 * @param rightmargin the rightmargin value
	 */
	public void setRightmargin (java.lang.String rightmargin) {
		this.rightmargin = rightmargin;
	}



	/**
	 * Return the value associated with the column: topmargin
	 */
	public java.lang.String getTopmargin () {
		return topmargin;
	}

	/**
	 * Set the value related to the column: topmargin
	 * @param topmargin the topmargin value
	 */
	public void setTopmargin (java.lang.String topmargin) {
		this.topmargin = topmargin;
	}



	/**
	 * Return the value associated with the column: bottommargin
	 */
	public java.lang.String getBottommargin () {
		return bottommargin;
	}

	/**
	 * Set the value related to the column: bottommargin
	 * @param bottommargin the bottommargin value
	 */
	public void setBottommargin (java.lang.String bottommargin) {
		this.bottommargin = bottommargin;
	}

	
	

	/**
     */
	public java.lang.String getCategorycode () {
		return categorycode;
	}

	/**
	 */
	public void setCategorycode (java.lang.String categorycode) {
		this.categorycode = categorycode;
	}
	
	
	/**
	 * Return the value associated with the column: subcategorycode
	 */
	public java.lang.String getSubcategorycode () {
		return subcategorycode;
	}

	/**
	 * Set the value related to the column: subcategorycode
	 * @param subcategorycode the subcategorycode value
	 */
	public void setSubcategorycode (java.lang.String subcategorycode) {
		this.subcategorycode = subcategorycode;
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
		addErrorIfBlank(errors, "description", description, "error.description.required");     
		addErrorIfBlank(errors, "languageid", languageid, "error.languageid.required");   
		addErrorIfBlank(errors, "buildclass", buildclass, "error.buildclass.required");      
		addErrorIfBlank(errors, "categorycode", categorycode, "error.categorycode.required");
		

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
