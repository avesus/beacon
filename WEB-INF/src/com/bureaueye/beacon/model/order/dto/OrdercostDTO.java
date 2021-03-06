package com.bureaueye.beacon.model.order.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.order.Ordercost;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Cost;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CostBD;





public final class OrdercostDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public OrdercostDTO(Ordercost dao) throws ApplicationException {
		initialize(dao);		
	}
	public OrdercostDTO(Ordercost dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	
	protected void initialize (Ordercost dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setVendoraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getVendoraddrkey()));
		this.setCostkey(new CostBD(this.getSessionFactoryClusterMap()).read(dao.getCostkey()));
		this.setCosttype(dao.getCosttype());
		this.setCcykey(dao.getCcykey());
		this.setCstamt(dao.getCstamt());
		this.setOrdercostId(dao.getOrdercostId());
		this.setOrderhdrId(dao.getOrderhdrId());
		this.setOrdermovId(dao.getOrdermovId());	
		this.setVendtarfhdrId(dao.getVendtarfhdrId());
		this.setTxt(dao.getTxt());			
	}
	


	// primary key
	private java.lang.Integer ordercostId;

	// fields
	private java.lang.String vendorFax;
	private java.lang.Integer orderhdrId;
	private java.math.BigDecimal cstamt;
	private java.lang.String vendorName;
	private java.lang.String vendtarfhdrId;
	private java.lang.String vendorContact;
	private java.lang.String vendorAddr1;
	private java.lang.Integer ordermovId;
	private java.lang.String costtype;
	private java.lang.String vendorEmail;
	private java.lang.String unitname;
	private boolean deleted;
	private java.lang.String vendorAddr2;
	private java.lang.String txt;
	private java.math.BigDecimal xrate;
	private java.math.BigDecimal units;
	private java.lang.String ccykey;
	private java.lang.String vendorPhone;
	private java.math.BigDecimal rate;
	private Address vendoraddrkey;
	private Cost costkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ORDERCOST_ID"
     */
	public java.lang.Integer getOrdercostId () {
		return ordercostId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param ordercostId the new ID
	 */
	public void setOrdercostId (java.lang.Integer ordercostId) {
		this.ordercostId = ordercostId;
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
	 * Return the value associated with the column: CSTAMT
	 */
	public java.math.BigDecimal getCstamt () {
		return cstamt;
	}

	/**
	 * Set the value related to the column: CSTAMT
	 * @param cstamt the CSTAMT value
	 */
	public void setCstamt (java.math.BigDecimal cstamt) {
		this.cstamt = cstamt;
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
	 * Return the value associated with the column: VENDTARFHDR_ID
	 */
	public java.lang.String getVendtarfhdrId () {
		return vendtarfhdrId;
	}

	/**
	 * Set the value related to the column: VENDTARFHDR_ID
	 * @param vendtarfhdrId the VENDTARFHDR_ID value
	 */
	public void setVendtarfhdrId (java.lang.String vendtarfhdrId) {
		this.vendtarfhdrId = vendtarfhdrId;
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
	 * Return the value associated with the column: ORDERMOV_ID
	 */
	public java.lang.Integer getOrdermovId () {
		return ordermovId;
	}

	/**
	 * Set the value related to the column: ORDERMOV_ID
	 * @param ordermovId the ORDERMOV_ID value
	 */
	public void setOrdermovId (java.lang.Integer ordermovId) {
		this.ordermovId = ordermovId;
	}







	/**
	 * Return the value associated with the column: costtype
	 */
	public java.lang.String getCosttype () {
		return costtype;
	}

	/**
	 * Set the value related to the column: costtype
	 * @param costtype the costtype value
	 */
	public void setCosttype (java.lang.String costtype) {
		this.costtype = costtype;
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
	 * Return the value associated with the column: unitname
	 */
	public java.lang.String getUnitname () {
		return unitname;
	}

	/**
	 * Set the value related to the column: unitname
	 * @param unitname the unitname value
	 */
	public void setUnitname (java.lang.String unitname) {
		this.unitname = unitname;
	}



	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param deleted the deleted value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
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
	 * Return the value associated with the column: TXT
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: TXT
	 * @param txt the TXT value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}



	/**
	 * Return the value associated with the column: XRATE
	 */
	public java.math.BigDecimal getXrate () {
		return xrate;
	}

	/**
	 * Set the value related to the column: XRATE
	 * @param xrate the XRATE value
	 */
	public void setXrate (java.math.BigDecimal xrate) {
		this.xrate = xrate;
	}





	/**
	 * Return the value associated with the column: UNITS
	 */
	public java.math.BigDecimal getUnits () {
		return units;
	}

	/**
	 * Set the value related to the column: UNITS
	 * @param units the UNITS value
	 */
	public void setUnits (java.math.BigDecimal units) {
		this.units = units;
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
	 * Return the value associated with the column: RATE
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param rate the RATE value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
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
	 * Return the value associated with the column: costkey
	 */
	public Cost getCostkey () {
		return costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCostkey (Cost costkey) {
		this.costkey = costkey;
	}

	
	
}
