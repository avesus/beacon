package com.bureaueye.beacon.form.quotation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;

public final class QuofileForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;

	// primary key
	private java.lang.Integer quofileId;

	// fields
	private java.lang.String filename;
	private java.lang.String contenttype;
	private java.sql.Blob filebin;
	private java.lang.String filesize;
	private java.lang.String createuserid;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.Integer rowid;
	private java.lang.Integer quonoteId;
	private java.lang.Integer quohdrId;
	private org.apache.struts.upload.FormFile infile;
	private java.lang.StringBuffer outfile;
	private java.lang.String description;	
	

	public String getAction() {
		return _action;
	}

	public void setAction(String _action) {
		this._action = _action;
	}

	
	
	public java.lang.Integer getQuofileId () {
		return quofileId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param quofileId the new ID
	 */
	public void setQuofileId (java.lang.Integer quofileId) {
		this.quofileId = quofileId;
	}
	

	public org.apache.struts.upload.FormFile getInfile () {
		return infile;
	}
	public void setInfile (org.apache.struts.upload.FormFile infile) {
		this.infile = infile;
	}
	
	public StringBuffer getOutfile () {
		return outfile;
	}
	public void setOutfile (StringBuffer outfile) {
		this.outfile = outfile;
	}
	
	/**
	 * Return the value associated with the column: filename
	 */
	public java.lang.String getFilename () {
		return filename;
	}

	/**
	 * Set the value related to the column: filename
	 * @param filename the filename value
	 */
	public void setFilename (java.lang.String filename) {
		this.filename = filename;
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
	 * Return the value associated with the column: filetype
	 */
	public java.lang.String getContenttype () {
		return contenttype;
	}

	/**
	 * Set the value related to the column: filetype
	 * @param filetype the filetype value
	 */
	public void setContenttype (java.lang.String contenttype) {
		this.contenttype = contenttype;
	}



	/**
	 * Return the value associated with the column: filebin
	 */
	public java.sql.Blob getFilebin () {
		return filebin;
	}

	/**
	 * Set the value related to the column: filebin
	 * @param filebin the filebin value
	 */
	public void setFilebin (java.sql.Blob filebin) {
		this.filebin = filebin;
	}



	/**
	 * Return the value associated with the column: filesize
	 */
	public java.lang.String getFilesize () {
		return filesize;
	}

	/**
	 * Set the value related to the column: filesize
	 * @param filesize the filesize value
	 */
	public void setFilesize (java.lang.String filesize) {
		this.filesize = filesize;
	}



	/**
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: CREATEUSERID
	 * @param createuserid the CREATEUSERID value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
	}



	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: CREATETIME
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: CREATETIME
	 * @param createtime the CREATETIME value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}




	/**
	 * Return the value associated with the column: rowid
	 */
	public java.lang.Integer getRowid () {
		return rowid;
	}

	/**
	 * Set the value related to the column: rowid
	 * @param rowid the rowid value
	 */
	public void setRowid (java.lang.Integer rowid) {
		this.rowid = rowid;
	}



	/**
	 * Return the value associated with the column: ORDNOTE_ID
	 */
	public java.lang.Integer getQuonoteId () {
		return quonoteId;
	}

	/**
	 * Set the value related to the column: ORDNOTE_ID
	 * @param ordnoteId the ORDNOTE_ID value
	 */
	public void setQuonoteId (java.lang.Integer quonoteId) {
		this.quonoteId = quonoteId;
	}




	/**
	 * Return the value associated with the column: ORDHDR_ID
	 */
	public java.lang.Integer getQuohdrId () {
		return quohdrId;
	}

	/**
	 * Set the value related to the column: ORDHDR_ID
	 * @param ordhdrId the ORDHDR_ID value
	 */
	public void setQuohdrId (java.lang.Integer quohdrId) {
		this.quohdrId = quohdrId;
	}
	



	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();

		addErrorIfBlank(errors, "description", description, "error.description.required");
		addErrorIfBlank(errors, "infile", infile.getFileName(), "error.document.required");
		
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
