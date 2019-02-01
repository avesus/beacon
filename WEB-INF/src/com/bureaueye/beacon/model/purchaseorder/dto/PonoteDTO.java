package com.bureaueye.beacon.model.purchaseorder.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.purchaseorder.Ponote;






public final class PonoteDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public PonoteDTO(Ponote dao) throws ApplicationException {
		initialize(dao);		
	}
	public PonoteDTO(Ponote dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	
	protected void initialize (Ponote dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setNote1(dao.getNote1());
		this.setNote2(dao.getNote2());
		this.setPriority(dao.getPriority());
		this.setCategory(dao.getCategory());
		this.setCreatedate(dao.getCreatedate());
		
		this.setPonoteId(dao.getPonoteId());
		this.setPohdrId(dao.getPohdrId());
	}
	


	// primary key
	private java.lang.Integer ponoteId;

	// fields
	private java.lang.String status;
	private java.lang.String pono;
	private java.lang.String note1;
	private java.lang.Integer pohdrId;
	private java.lang.String category;
	private java.util.Date createdate;
	private java.lang.String priority;
	private java.lang.String note2;
	private boolean deleteflag;



	/**
     */
	public java.lang.Integer getPonoteId () {
		return ponoteId;
	}

	/**
	 */
	public void setPonoteId (java.lang.Integer ponoteId) {
		this.ponoteId = ponoteId;
	}





	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}






	/**
	 * Return the value associated with the column: pono
	 */
	public java.lang.String getPono () {
		return pono;
	}

	/**
	 * Set the value related to the column: pono
	 * @param pono the pono value
	 */
	public void setPono (java.lang.String pono) {
		this.pono = pono;
	}



	/**
	 * Return the value associated with the column: note1
	 */
	public java.lang.String getNote1 () {
		return note1;
	}

	/**
	 * Set the value related to the column: note1
	 * @param note1 the note1 value
	 */
	public void setNote1 (java.lang.String note1) {
		this.note1 = note1;
	}






	/**
	 * Return the value associated with the column: POHDR_ID
	 */
	public java.lang.Integer getPohdrId () {
		return pohdrId;
	}

	/**
	 * Set the value related to the column: POHDR_ID
	 * @param pohdrId the POHDR_ID value
	 */
	public void setPohdrId (java.lang.Integer pohdrId) {
		this.pohdrId = pohdrId;
	}





	/**
	 * Return the value associated with the column: category
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
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
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.String priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: note2
	 */
	public java.lang.String getNote2 () {
		return note2;
	}

	/**
	 * Set the value related to the column: note2
	 * @param note2 the note2 value
	 */
	public void setNote2 (java.lang.String note2) {
		this.note2 = note2;
	}




	/**
	 * Return the value associated with the column: deleteflag
	 */
	public boolean isDeleteflag () {
		return deleteflag;
	}

	/**
	 * Set the value related to the column: deleteflag
	 * @param deleteflag the deleteflag value
	 */
	public void setDeleteflag (boolean deleteflag) {
		this.deleteflag = deleteflag;
	}




	
	
}
