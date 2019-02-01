package com.bureaueye.beacon.model.quotation.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.SectionBD;




public final class QuomovDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public QuomovDTO(Quomov dao) throws ApplicationException {
		initialize(dao);		
	}
	public QuomovDTO(Quomov dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	
	
	protected void initialize (Quomov dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setFromlocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getFromlocationkey()));
		this.setTolocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getTolocationkey()));
		this.setVendoraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getVendoraddrkey()));
		this.setSectionkey(new SectionBD(this.getSessionFactoryClusterMap()).read(dao.getSectionkey()));
		this.setSeqno(dao.getSeqno());	
		this.setQuohdrId(dao.getQuohdrId());
		this.setQuomovId(dao.getQuomovId());
		
		this.setFromdayno(dao.getFromdayno());
		this.setTodayno(dao.getTodayno());
	}
	


	// primary key
	private java.lang.Integer quomovId;

	// fields
	private java.lang.String vendorFax;
	private java.lang.String vendorName;
	private boolean initfromday;
	private boolean deleted;
	private java.lang.String tog2key;
	private java.lang.String vendorContact;
	private java.lang.String vendorAddr1;
	private java.lang.String departmentkey;
	private boolean inittoday;
	private java.lang.String vendorEmail;
	private java.lang.String tog3key;
	private java.lang.String companykey;
	private java.lang.String tog4key;
	private java.lang.String tog1key;
	private java.lang.String vendorAddr2;
	private java.lang.Integer fromdayno;
	private java.lang.String fromg3key;
	private java.lang.Integer todayno;
	private java.lang.String fromg2key;
	private java.lang.String quotno;
	private java.lang.Integer quohdrId;
	private java.lang.Integer seqno;
	private java.lang.String fromg1key;
	private java.lang.String activitykey;
	private java.lang.String fromg4key;
	private java.lang.String vendorPhone;
	private Address vendoraddrkey;
	private Location fromlocationkey;
	private Location tolocationkey;
	private Section sectionkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="QUOMOV_ID"
     */
	public java.lang.Integer getQuomovId () {
		return quomovId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param quomovId the new ID
	 */
	public void setQuomovId (java.lang.Integer quomovId) {
		this.quomovId = quomovId;
	}




	/**
	 * Return the value associated with the column: VENDOR_FAX
	 */
	public java.lang.String getVendorFax () {
		return vendorFax;
	}

	/**
	 * Set the value related to the column: VENDOR_FAX
	 * @param vendorFax the VENDOR_FAX value
	 */
	public void setVendorFax (java.lang.String vendorFax) {
		this.vendorFax = vendorFax;
	}





	/**
	 * Return the value associated with the column: VENDOR_NAME
	 */
	public java.lang.String getVendorName () {
		return vendorName;
	}

	/**
	 * Set the value related to the column: VENDOR_NAME
	 * @param vendorName the VENDOR_NAME value
	 */
	public void setVendorName (java.lang.String vendorName) {
		this.vendorName = vendorName;
	}



	/**
	 * Return the value associated with the column: initfromday
	 */
	public boolean isInitfromday () {
		return initfromday;
	}

	/**
	 * Set the value related to the column: initfromday
	 * @param initfromday the initfromday value
	 */
	public void setInitfromday (boolean initfromday) {
		this.initfromday = initfromday;
	}





	/**
	 * Return the value associated with the column: DELETED
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: DELETED
	 * @param deleted the DELETED value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: tog2key
	 */
	public java.lang.String getTog2key () {
		return tog2key;
	}

	/**
	 * Set the value related to the column: tog2key
	 * @param tog2key the tog2key value
	 */
	public void setTog2key (java.lang.String tog2key) {
		this.tog2key = tog2key;
	}



	/**
	 * Return the value associated with the column: VENDOR_CONTACT
	 */
	public java.lang.String getVendorContact () {
		return vendorContact;
	}

	/**
	 * Set the value related to the column: VENDOR_CONTACT
	 * @param vendorContact the VENDOR_CONTACT value
	 */
	public void setVendorContact (java.lang.String vendorContact) {
		this.vendorContact = vendorContact;
	}



	/**
	 * Return the value associated with the column: VENDOR_ADDR1
	 */
	public java.lang.String getVendorAddr1 () {
		return vendorAddr1;
	}

	/**
	 * Set the value related to the column: VENDOR_ADDR1
	 * @param vendorAddr1 the VENDOR_ADDR1 value
	 */
	public void setVendorAddr1 (java.lang.String vendorAddr1) {
		this.vendorAddr1 = vendorAddr1;
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
	 * Return the value associated with the column: inittoday
	 */
	public boolean isInittoday () {
		return inittoday;
	}

	/**
	 * Set the value related to the column: inittoday
	 * @param inittoday the inittoday value
	 */
	public void setInittoday (boolean inittoday) {
		this.inittoday = inittoday;
	}





	/**
	 * Return the value associated with the column: VENDOR_EMAIL
	 */
	public java.lang.String getVendorEmail () {
		return vendorEmail;
	}

	/**
	 * Set the value related to the column: VENDOR_EMAIL
	 * @param vendorEmail the VENDOR_EMAIL value
	 */
	public void setVendorEmail (java.lang.String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}



	/**
	 * Return the value associated with the column: tog3key
	 */
	public java.lang.String getTog3key () {
		return tog3key;
	}

	/**
	 * Set the value related to the column: tog3key
	 * @param tog3key the tog3key value
	 */
	public void setTog3key (java.lang.String tog3key) {
		this.tog3key = tog3key;
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
	 * Return the value associated with the column: tog4key
	 */
	public java.lang.String getTog4key () {
		return tog4key;
	}

	/**
	 * Set the value related to the column: tog4key
	 * @param tog4key the tog4key value
	 */
	public void setTog4key (java.lang.String tog4key) {
		this.tog4key = tog4key;
	}



	/**
	 * Return the value associated with the column: tog1key
	 */
	public java.lang.String getTog1key () {
		return tog1key;
	}

	/**
	 * Set the value related to the column: tog1key
	 * @param tog1key the tog1key value
	 */
	public void setTog1key (java.lang.String tog1key) {
		this.tog1key = tog1key;
	}



	/**
	 * Return the value associated with the column: VENDOR_ADDR2
	 */
	public java.lang.String getVendorAddr2 () {
		return vendorAddr2;
	}

	/**
	 * Set the value related to the column: VENDOR_ADDR2
	 * @param vendorAddr2 the VENDOR_ADDR2 value
	 */
	public void setVendorAddr2 (java.lang.String vendorAddr2) {
		this.vendorAddr2 = vendorAddr2;
	}



	/**
	 * Return the value associated with the column: fromdayno
	 */
	public java.lang.Integer getFromdayno () {
		return fromdayno;
	}

	/**
	 * Set the value related to the column: fromdayno
	 * @param fromdayno the fromdayno value
	 */
	public void setFromdayno (java.lang.Integer fromdayno) {
		this.fromdayno = fromdayno;
	}



	/**
	 * Return the value associated with the column: fromg3key
	 */
	public java.lang.String getFromg3key () {
		return fromg3key;
	}

	/**
	 * Set the value related to the column: fromg3key
	 * @param fromg3key the fromg3key value
	 */
	public void setFromg3key (java.lang.String fromg3key) {
		this.fromg3key = fromg3key;
	}



	/**
	 * Return the value associated with the column: todayno
	 */
	public java.lang.Integer getTodayno () {
		return todayno;
	}

	/**
	 * Set the value related to the column: todayno
	 * @param todayno the todayno value
	 */
	public void setTodayno (java.lang.Integer todayno) {
		this.todayno = todayno;
	}



	/**
	 * Return the value associated with the column: fromg2key
	 */
	public java.lang.String getFromg2key () {
		return fromg2key;
	}

	/**
	 * Set the value related to the column: fromg2key
	 * @param fromg2key the fromg2key value
	 */
	public void setFromg2key (java.lang.String fromg2key) {
		this.fromg2key = fromg2key;
	}



	/**
	 * Return the value associated with the column: QUOTNO
	 */
	public java.lang.String getQuotno () {
		return quotno;
	}

	/**
	 * Set the value related to the column: QUOTNO
	 * @param quotno the QUOTNO value
	 */
	public void setQuotno (java.lang.String quotno) {
		this.quotno = quotno;
	}





	/**
	 * Return the value associated with the column: QUOHDR_ID
	 */
	public java.lang.Integer getQuohdrId () {
		return quohdrId;
	}

	/**
	 * Set the value related to the column: QUOHDR_ID
	 * @param quohdrId the QUOHDR_ID value
	 */
	public void setQuohdrId (java.lang.Integer quohdrId) {
		this.quohdrId = quohdrId;
	}



	/**
	 * Return the value associated with the column: seqno
	 */
	public java.lang.Integer getSeqno () {
		return seqno;
	}

	/**
	 * Set the value related to the column: seqno
	 * @param seqno the seqno value
	 */
	public void setSeqno (java.lang.Integer seqno) {
		this.seqno = seqno;
	}






	/**
	 * Return the value associated with the column: fromg1key
	 */
	public java.lang.String getFromg1key () {
		return fromg1key;
	}

	/**
	 * Set the value related to the column: fromg1key
	 * @param fromg1key the fromg1key value
	 */
	public void setFromg1key (java.lang.String fromg1key) {
		this.fromg1key = fromg1key;
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
	 * Return the value associated with the column: fromg4key
	 */
	public java.lang.String getFromg4key () {
		return fromg4key;
	}

	/**
	 * Set the value related to the column: fromg4key
	 * @param fromg4key the fromg4key value
	 */
	public void setFromg4key (java.lang.String fromg4key) {
		this.fromg4key = fromg4key;
	}



	/**
	 * Return the value associated with the column: VENDOR_PHONE
	 */
	public java.lang.String getVendorPhone () {
		return vendorPhone;
	}

	/**
	 * Set the value related to the column: VENDOR_PHONE
	 * @param vendorPhone the VENDOR_PHONE value
	 */
	public void setVendorPhone (java.lang.String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}





	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public Address getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (Address vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: fromlocationkey
	 */
	public Location getFromlocationkey () {
		return fromlocationkey;
	}

	/**
	 * Set the value related to the column: fromlocationkey
	 * @param fromlocationkey the fromlocationkey value
	 */
	public void setFromlocationkey (Location fromlocationkey) {
		this.fromlocationkey = fromlocationkey;
	}



	/**
	 * Return the value associated with the column: tolocationkey
	 */
	public Location getTolocationkey () {
		return tolocationkey;
	}

	/**
	 * Set the value related to the column: tolocationkey
	 * @param tolocationkey the tolocationkey value
	 */
	public void setTolocationkey (Location tolocationkey) {
		this.tolocationkey = tolocationkey;
	}



	/**
	 * Return the value associated with the column: sectionkey
	 */
	public Section getSectionkey () {
		return sectionkey;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param sectionkey the sectionkey value
	 */
	public void setSectionkey (Section sectionkey) {
		this.sectionkey = sectionkey;
	}

	
	
}
