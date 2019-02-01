package com.bureaueye.beacon.model.order.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.order.Ordermov;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.SectionBD;




public final class OrdermovDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public OrdermovDTO(Ordermov dao) throws ApplicationException {
		initialize(dao);		
	}
	public OrdermovDTO(Ordermov dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	
	
	protected void initialize (Ordermov dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setFromlocationkey(
				new LocationBD(this.getSessionFactoryClusterMap())
				.read(dao.getFromlocationkey()));
		this.setTolocationkey(
				new LocationBD(this.getSessionFactoryClusterMap())
				.read(dao.getTolocationkey()));
		this.setVendoraddrkey(
				new AddressBD(this.getSessionFactoryClusterMap())
				.read(dao.getVendoraddrkey()));
		this.setSectionkey(
				new SectionBD(this.getSessionFactoryClusterMap())
				.read(dao.getSectionkey()));
		
		this.setEstfromdate(dao.getEstfromdate());
		this.setEstfromtime(dao.getEstfromtime());
		this.setEsttodate(dao.getEsttodate());
		this.setEsttotime(dao.getEsttotime());		
		this.setOrdermovId(dao.getOrdermovId());
		this.setOrderhdrId(dao.getOrderhdrId());
	}
	


	// primary key
	private java.lang.Integer ordermovId;

	// fields
	private java.lang.String vendorFax;
	private boolean deleted;
	private java.lang.String vendorAddr1;
	private java.lang.String departmentkey;
	private java.lang.Long acttotimeinmillis;
	private java.lang.String tog3key;
	private java.lang.String tog4key;
	private java.lang.Long estfromtimeinmillis;
	private java.lang.String tog1key;
	private java.lang.Long actfromtimeinmillis;
	private java.lang.String vendorAddr2;
	private java.lang.Long esttotimeinmillis;
	private boolean stdCostsGenerated;
	private java.lang.String fromg2key;
	private java.util.Date acttodate;
	private java.lang.String fromg1key;
	private java.lang.String fromg4key;
	private java.lang.String vendorPhone;
	private java.lang.String vendorName;
	private java.util.Date estfromdate;
	private java.util.Date esttodate;
	private java.lang.String tog2key;
	private java.lang.String vendorContact;
	private java.lang.String actfromtime;
	private java.lang.String estfromtime;
	private java.lang.String vendorEmail;
	private java.lang.String companykey;
	private java.lang.String acttotime;
	private java.lang.String esttotime;
	private java.lang.String fromg3key;
	private java.lang.Integer orderhdrId;
	private java.util.Date actfromdate;
	private java.lang.String activitykey;
	private java.lang.String orderno;
	private Address vendoraddrkey;
	private Location fromlocationkey;
	private Location tolocationkey;
	private Section sectionkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ORDERMOV_ID"
     */
	public java.lang.Integer getOrdermovId () {
		return ordermovId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param ordermovId the new ID
	 */
	public void setOrdermovId (java.lang.Integer ordermovId) {
		this.ordermovId = ordermovId;
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
	 * Return the value associated with the column: acttotimeinmillis
	 */
	public java.lang.Long getActtotimeinmillis () {
		return acttotimeinmillis;
	}

	/**
	 * Set the value related to the column: acttotimeinmillis
	 * @param acttotimeinmillis the acttotimeinmillis value
	 */
	public void setActtotimeinmillis (java.lang.Long acttotimeinmillis) {
		this.acttotimeinmillis = acttotimeinmillis;
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
	 * Return the value associated with the column: estfromtimeinmillis
	 */
	public java.lang.Long getEstfromtimeinmillis () {
		return estfromtimeinmillis;
	}

	/**
	 * Set the value related to the column: estfromtimeinmillis
	 * @param estfromtimeinmillis the estfromtimeinmillis value
	 */
	public void setEstfromtimeinmillis (java.lang.Long estfromtimeinmillis) {
		this.estfromtimeinmillis = estfromtimeinmillis;
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
	 * Return the value associated with the column: actfromtimeinmillis
	 */
	public java.lang.Long getActfromtimeinmillis () {
		return actfromtimeinmillis;
	}

	/**
	 * Set the value related to the column: actfromtimeinmillis
	 * @param actfromtimeinmillis the actfromtimeinmillis value
	 */
	public void setActfromtimeinmillis (java.lang.Long actfromtimeinmillis) {
		this.actfromtimeinmillis = actfromtimeinmillis;
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
	 * Return the value associated with the column: esttotimeinmillis
	 */
	public java.lang.Long getEsttotimeinmillis () {
		return esttotimeinmillis;
	}

	/**
	 * Set the value related to the column: esttotimeinmillis
	 * @param esttotimeinmillis the esttotimeinmillis value
	 */
	public void setEsttotimeinmillis (java.lang.Long esttotimeinmillis) {
		this.esttotimeinmillis = esttotimeinmillis;
	}



	/**
	 * Return the value associated with the column: STD_COSTS_GENERATED
	 */
	public boolean isStdCostsGenerated () {
		return stdCostsGenerated;
	}

	/**
	 * Set the value related to the column: STD_COSTS_GENERATED
	 * @param stdCostsGenerated the STD_COSTS_GENERATED value
	 */
	public void setStdCostsGenerated (boolean stdCostsGenerated) {
		this.stdCostsGenerated = stdCostsGenerated;
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
	 * Return the value associated with the column: acttodate
	 */
	public java.util.Date getActtodate () {
		return acttodate;
	}

	/**
	 * Set the value related to the column: acttodate
	 * @param acttodate the acttodate value
	 */
	public void setActtodate (java.util.Date acttodate) {
		this.acttodate = acttodate;
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
	 * Return the value associated with the column: estfromdate
	 */
	public java.util.Date getEstfromdate () {
		return estfromdate;
	}

	/**
	 * Set the value related to the column: estfromdate
	 * @param estfromdate the estfromdate value
	 */
	public void setEstfromdate (java.util.Date estfromdate) {
		this.estfromdate = estfromdate;
	}






	/**
	 * Return the value associated with the column: esttodate
	 */
	public java.util.Date getEsttodate () {
		return esttodate;
	}

	/**
	 * Set the value related to the column: esttodate
	 * @param esttodate the esttodate value
	 */
	public void setEsttodate (java.util.Date esttodate) {
		this.esttodate = esttodate;
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
	 * Return the value associated with the column: actfromtime
	 */
	public java.lang.String getActfromtime () {
		return actfromtime;
	}

	/**
	 * Set the value related to the column: actfromtime
	 * @param actfromtime the actfromtime value
	 */
	public void setActfromtime (java.lang.String actfromtime) {
		this.actfromtime = actfromtime;
	}






	/**
	 * Return the value associated with the column: estfromtime
	 */
	public java.lang.String getEstfromtime () {
		return estfromtime;
	}

	/**
	 * Set the value related to the column: estfromtime
	 * @param estfromtime the estfromtime value
	 */
	public void setEstfromtime (java.lang.String estfromtime) {
		this.estfromtime = estfromtime;
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
	 * Return the value associated with the column: acttotime
	 */
	public java.lang.String getActtotime () {
		return acttotime;
	}

	/**
	 * Set the value related to the column: acttotime
	 * @param acttotime the acttotime value
	 */
	public void setActtotime (java.lang.String acttotime) {
		this.acttotime = acttotime;
	}



	/**
	 * Return the value associated with the column: esttotime
	 */
	public java.lang.String getEsttotime () {
		return esttotime;
	}

	/**
	 * Set the value related to the column: esttotime
	 * @param esttotime the esttotime value
	 */
	public void setEsttotime (java.lang.String esttotime) {
		this.esttotime = esttotime;
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
	 * Return the value associated with the column: ORDERHDR_ID
	 */
	public java.lang.Integer getOrderhdrId () {
		return orderhdrId;
	}

	/**
	 * Set the value related to the column: ORDERHDR_ID
	 * @param orderhdrId the ORDERHDR_ID value
	 */
	public void setOrderhdrId (java.lang.Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}



	/**
	 * Return the value associated with the column: actfromdate
	 */
	public java.util.Date getActfromdate () {
		return actfromdate;
	}

	/**
	 * Set the value related to the column: actfromdate
	 * @param actfromdate the actfromdate value
	 */
	public void setActfromdate (java.util.Date actfromdate) {
		this.actfromdate = actfromdate;
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
	 * Return the value associated with the column: ORDERNO
	 */
	public java.lang.String getOrderno () {
		return orderno;
	}

	/**
	 * Set the value related to the column: ORDERNO
	 * @param orderno the ORDERNO value
	 */
	public void setOrderno (java.lang.String orderno) {
		this.orderno = orderno;
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
