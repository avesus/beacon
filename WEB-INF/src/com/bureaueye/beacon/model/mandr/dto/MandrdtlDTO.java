package com.bureaueye.beacon.model.mandr.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;

import com.bureaueye.beacon.model.mandr.Mandrdtl;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;






public final class MandrdtlDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public MandrdtlDTO(Mandrdtl dao) throws ApplicationException {
		initialize(dao);		
	}
	public MandrdtlDTO(Mandrdtl dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	
	protected void initialize (Mandrdtl dao) throws ApplicationException {

		this.setMandrhdrId(dao.getMandrhdrId());
		this.setMandrdtlId(dao.getMandrdtlId());

		// populate data-transfer-object from data-access-object
		this.setVendoraddrkey(dao.getVendoraddrkey());
		try{this.setVendoraddr(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getVendoraddrkey()));}catch(Exception e){}


		
		this.setItemno(dao.getItemno());
		this.setCostkey(dao.getCostkey());		
		this.setCcykey(dao.getCcykey());
		
		this.setDamagecode(dao.getDamagecode());
		this.setRepaircode(dao.getRepaircode());
		this.setComponentcode(dao.getComponentcode());
		this.setLocationcode1(dao.getLocationcode1());
		this.setLocationcode2(dao.getLocationcode2());
		this.setResponsibilitycode(dao.getResponsibilitycode());
		this.setUnitmeasurecode(dao.getUnitmeasurecode());

		this.setLength(dao.getLength());
		this.setWidth(dao.getWidth());
		this.setQuantity(dao.getQuantity());
		
		this.setLaboramt(dao.getLaboramt());
		this.setLaborhours(dao.getLaborhours());
		this.setLaborrate(dao.getLaborrate());
		this.setMaterialamt(dao.getMaterialamt());
		this.setTotalamt(dao.getTotalamt());
		
		this.setXrate(dao.getXrate());
		this.setTxt1(dao.getTxt1());
		
	}
	


	// primary key
	private java.lang.Integer mandrdtlId;

	// fields
	private java.lang.Integer mandrhdrId;
	private java.lang.Integer itemno;
	
	private java.lang.String vendoraddrkey;
	private java.lang.String ccykey;
	private java.lang.String costkey;
	private java.lang.String damagecode;
	private java.lang.String repaircode;
	private java.lang.String componentcode;
	private java.lang.String locationcode1;
	private java.lang.String locationcode2;
	
	private Address vendoraddr = new Address();
	
	private java.lang.String responsibilitycode;
	
	private java.math.BigDecimal xrate;
	private java.math.BigDecimal laboramt;
	private java.math.BigDecimal laborrate;
	private java.math.BigDecimal laborhours;
	private java.lang.String materialtypecode;
	private java.math.BigDecimal materialamt;
	private java.math.BigDecimal totalamt;
	private java.lang.String txt1;
	private java.lang.String txt2;
	private java.lang.String mandrstatus;

	private java.math.BigDecimal length;
	private java.math.BigDecimal width;
	private java.math.BigDecimal quantity;
	private java.lang.String unitmeasurecode;




	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="MANDRDTL_ID"
     */
	public java.lang.Integer getMandrdtlId () {
		return mandrdtlId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param mandrdtlId the new ID
	 */
	public void setMandrdtlId (java.lang.Integer mandrdtlId) {
		this.mandrdtlId = mandrdtlId;
	}




	/**
	 * Return the value associated with the column: MANDRHDR_ID
	 */
	public java.lang.Integer getMandrhdrId () {
		return mandrhdrId;
	}

	/**
	 * Set the value related to the column: MANDRHDR_ID
	 * @param mandrhdrId the MANDRHDR_ID value
	 */
	public void setMandrhdrId (java.lang.Integer mandrhdrId) {
		this.mandrhdrId = mandrhdrId;
	}



	/**
	 * Return the value associated with the column: itemno
	 */
	public java.lang.Integer getItemno () {
		return itemno;
	}

	/**
	 * Set the value related to the column: itemno
	 * @param itemno the itemno value
	 */
	public void setItemno (java.lang.Integer itemno) {
		this.itemno = itemno;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: respparty
	 */
	public java.lang.String getResponsibilitycode () {
		return responsibilitycode;
	}

	/**
	 * Set the value related to the column: respparty
	 * @param respparty the respparty value
	 */
	public void setResponsibilitycode (java.lang.String responsibilitycode) {
		this.responsibilitycode = responsibilitycode;
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
	 * Return the value associated with the column: costkey
	 */
	public java.lang.String getCostkey () {
		return costkey;
	}

	/**
	 * Set the value related to the column: costkey
	 * @param costkey the costkey value
	 */
	public void setCostkey (java.lang.String costkey) {
		this.costkey = costkey;
	}



	/**
	 * Return the value associated with the column: damagekey
	 */
	public java.lang.String getDamagecode () {
		return damagecode;
	}

	/**
	 * Set the value related to the column: damagecode
	 * @param damagecode the damagecode value
	 */
	public void setDamagecode (java.lang.String damagecode) {
		this.damagecode = damagecode;
	}



	/**
	 * Return the value associated with the column: repaircode
	 */
	public java.lang.String getRepaircode () {
		return repaircode;
	}

	/**
	 * Set the value related to the column: repaircode
	 * @param repaircode the repaircode value
	 */
	public void setRepaircode (java.lang.String repaircode) {
		this.repaircode = repaircode;
	}



	/**
	 * Return the value associated with the column: xrate
	 */
	public java.math.BigDecimal getXrate () {
		return xrate;
	}

	/**
	 * Set the value related to the column: xrate
	 * @param xrate the xrate value
	 */
	public void setXrate (java.math.BigDecimal xrate) {
		this.xrate = xrate;
	}



	/**
	 * Return the value associated with the column: laboramt
	 */
	public java.math.BigDecimal getLaboramt () {
		return laboramt;
	}

	/**
	 * Set the value related to the column: laboramt
	 * @param laboramt the laboramt value
	 */
	public void setLaboramt (java.math.BigDecimal laboramt) {
		this.laboramt = laboramt;
	}



	/**
	 * Return the value associated with the column: laborrate
	 */
	public java.math.BigDecimal getLaborrate () {
		return laborrate;
	}

	/**
	 * Set the value related to the column: laborrate
	 * @param laborrate the laborrate value
	 */
	public void setLaborrate (java.math.BigDecimal laborrate) {
		this.laborrate = laborrate;
	}



	/**
	 * Return the value associated with the column: laborhours
	 */
	public java.math.BigDecimal getLaborhours () {
		return laborhours;
	}

	/**
	 * Set the value related to the column: laborhours
	 * @param laborhours the laborhours value
	 */
	public void setLaborhours (java.math.BigDecimal laborhours) {
		this.laborhours = laborhours;
	}



	/**
	 * Return the value associated with the column: materialcode
	 */
	public java.lang.String getMaterialtypecode () {
		return materialtypecode;
	}

	/**
	 * Set the value related to the column: materialcode
	 * @param materialcode the materialcode value
	 */
	public void setMaterialtypecode (java.lang.String materialtypecode) {
		this.materialtypecode = materialtypecode;
	}



	/**
	 * Return the value associated with the column: materialamt
	 */
	public java.math.BigDecimal getMaterialamt () {
		return materialamt;
	}

	/**
	 * Set the value related to the column: materialamt
	 * @param materialamt the materialamt value
	 */
	public void setMaterialamt (java.math.BigDecimal materialamt) {
		this.materialamt = materialamt;
	}



	/**
	 * Return the value associated with the column: totalamt
	 */
	public java.math.BigDecimal getTotalamt () {
		return totalamt;
	}

	/**
	 * Set the value related to the column: totalamt
	 * @param totalamt the totalamt value
	 */
	public void setTotalamt (java.math.BigDecimal totalamt) {
		this.totalamt = totalamt;
	}



	/**
	 * Return the value associated with the column: txt1
	 */
	public java.lang.String getTxt1 () {
		return txt1;
	}

	/**
	 * Set the value related to the column: txt1
	 * @param txt1 the txt1 value
	 */
	public void setTxt1 (java.lang.String txt1) {
		this.txt1 = txt1;
	}



	/**
	 * Return the value associated with the column: txt2
	 */
	public java.lang.String getTxt2 () {
		return txt2;
	}

	/**
	 * Set the value related to the column: txt2
	 * @param txt2 the txt2 value
	 */
	public void setTxt2 (java.lang.String txt2) {
		this.txt2 = txt2;
	}



	/**
	 * Return the value associated with the column: mandrstatus
	 */
	public java.lang.String getMandrstatus () {
		return mandrstatus;
	}

	/**
	 * Set the value related to the column: mandrstatus
	 * @param mandrstatus the mandrstatus value
	 */
	public void setMandrstatus (java.lang.String mandrstatus) {
		this.mandrstatus = mandrstatus;
	}






	/**
	 * Return the value associated with the column: materiallength
	 */
	public java.math.BigDecimal getLength () {
		return length;
	}

	/**
	 * Set the value related to the column: materiallength
	 * @param materiallength the materiallength value
	 */
	public void setLength (java.math.BigDecimal length) {
		this.length = length;
	}



	/**
	 * Return the value associated with the column: materialwidth
	 */
	public java.math.BigDecimal getWidth () {
		return width;
	}

	/**
	 * Set the value related to the column: materialwidth
	 * @param materialwidth the materialwidth value
	 */
	public void setWidth (java.math.BigDecimal width) {
		this.width = width;
	}



	/**
	 * Return the value associated with the column: materialquantity
	 */
	public java.math.BigDecimal getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: materialquantity
	 * @param materialquantity the materialquantity value
	 */
	public void setQuantity (java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}




	public java.lang.String getUnitmeasurecode () {
		return unitmeasurecode;
	}
	public void setUnitmeasurecode (java.lang.String unitmeasurecode) {
		this.unitmeasurecode = unitmeasurecode;
	}


	public Address getVendoraddr () {
		return vendoraddr;
	}
	public void setVendoraddr (Address vendoraddr) {
		this.vendoraddr = vendoraddr;
	}
	
	/**
	 * Return the value associated with the column: locationcode1
	 */
	public java.lang.String getLocationcode1 () {
		return locationcode1;
	}

	/**
	 * Set the value related to the column: locationcode1
	 * @param locationcode1 the locationcode1 value
	 */
	public void setLocationcode1 (java.lang.String locationcode1) {
		this.locationcode1 = locationcode1;
	}



	/**
	 * Return the value associated with the column: locationcode2
	 */
	public java.lang.String getLocationcode2 () {
		return locationcode2;
	}

	/**
	 * Set the value related to the column: locationcode2
	 * @param locationcode2 the locationcode2 value
	 */
	public void setLocationcode2 (java.lang.String locationcode2) {
		this.locationcode2 = locationcode2;
	}



	/**
	 * Return the value associated with the column: componentcode
	 */
	public java.lang.String getComponentcode () {
		return componentcode;
	}

	/**
	 * Set the value related to the column: componentcode
	 * @param componentcode the componentcode value
	 */
	public void setComponentcode (java.lang.String componentcode) {
		this.componentcode = componentcode;
	}
	
	
	
}
