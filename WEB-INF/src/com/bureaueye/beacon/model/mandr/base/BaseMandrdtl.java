package com.bureaueye.beacon.model.mandr.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mandrdtl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mandrdtl"
 */

public abstract class BaseMandrdtl  implements Serializable {

	public static String REF = "Mandrdtl";
	public static String PROP_COMPONENTCODE = "Componentcode";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_DAMAGECODE = "Damagecode";
	public static String PROP_CCYKEY = "Ccykey";
	public static String PROP_XRATE = "Xrate";
	public static String PROP_MANDRDTL_ID = "MandrdtlId";
	public static String PROP_MATERIALTYPECODE = "Materialtypecode";
	public static String PROP_LABORAMT = "Laboramt";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_RESPONSIBILITYCODE = "Responsibilitycode";
	public static String PROP_COSTKEY = "Costkey";
	public static String PROP_TOTALAMT = "Totalamt";
	public static String PROP_MATERIALAMT = "Materialamt";
	public static String PROP_ITEMNO = "Itemno";
	public static String PROP_UNITMEASURECODE = "Unitmeasurecode";
	public static String PROP_WIDTH = "Width";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_MANDRHDR_ID = "MandrhdrId";
	public static String PROP_LOCATIONCODE1 = "Locationcode1";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_MANDRSTATUS = "Mandrstatus";
	public static String PROP_LENGTH = "Length";
	public static String PROP_LABORHOURS = "Laborhours";
	public static String PROP_VENDORADDRKEY = "Vendoraddrkey";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_LOCATIONCODE2 = "Locationcode2";
	public static String PROP_REPAIRCODE = "Repaircode";
	public static String PROP_TXT2 = "Txt2";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_TXT1 = "Txt1";
	public static String PROP_LABORRATE = "Laborrate";


	// constructors
	public BaseMandrdtl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMandrdtl (java.lang.Integer mandrdtlId) {
		this.setMandrdtlId(mandrdtlId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer mandrdtlId;

	// fields
	private java.lang.Integer mandrhdrId;
	private java.lang.Integer itemno;
	private java.lang.String vendoraddrkey;
	private java.lang.String responsibilitycode;
	private java.lang.String ccykey;
	private java.lang.String costkey;
	private java.lang.String damagecode;
	private java.lang.String repaircode;
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
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogtime;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String xlock;
	private boolean xinactive;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;
	private java.math.BigDecimal length;
	private java.math.BigDecimal width;
	private java.math.BigDecimal quantity;
	private java.lang.String unitmeasurecode;
	private java.lang.String locationcode1;
	private java.lang.String locationcode2;
	private java.lang.String componentcode;



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
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: responsibilitycode
	 */
	public java.lang.String getResponsibilitycode () {
		return responsibilitycode;
	}

	/**
	 * Set the value related to the column: responsibilitycode
	 * @param responsibilitycode the responsibilitycode value
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
	 * Return the value associated with the column: damagecode
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
	 * Return the value associated with the column: materialtypecode
	 */
	public java.lang.String getMaterialtypecode () {
		return materialtypecode;
	}

	/**
	 * Set the value related to the column: materialtypecode
	 * @param materialtypecode the materialtypecode value
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
	 * Return the value associated with the column: systemloguserid
	 */
	public java.lang.String getSystemloguserid () {
		return systemloguserid;
	}

	/**
	 * Set the value related to the column: systemloguserid
	 * @param systemloguserid the systemloguserid value
	 */
	public void setSystemloguserid (java.lang.String systemloguserid) {
		this.systemloguserid = systemloguserid;
	}



	/**
	 * Return the value associated with the column: systemlogdate
	 */
	public java.util.Date getSystemlogdate () {
		return systemlogdate;
	}

	/**
	 * Set the value related to the column: systemlogdate
	 * @param systemlogdate the systemlogdate value
	 */
	public void setSystemlogdate (java.util.Date systemlogdate) {
		this.systemlogdate = systemlogdate;
	}



	/**
	 * Return the value associated with the column: systemlogtime
	 */
	public java.lang.String getSystemlogtime () {
		return systemlogtime;
	}

	/**
	 * Set the value related to the column: systemlogtime
	 * @param systemlogtime the systemlogtime value
	 */
	public void setSystemlogtime (java.lang.String systemlogtime) {
		this.systemlogtime = systemlogtime;
	}



	/**
	 * Return the value associated with the column: systemlogprogram
	 */
	public java.lang.String getSystemlogprogram () {
		return systemlogprogram;
	}

	/**
	 * Set the value related to the column: systemlogprogram
	 * @param systemlogprogram the systemlogprogram value
	 */
	public void setSystemlogprogram (java.lang.String systemlogprogram) {
		this.systemlogprogram = systemlogprogram;
	}



	/**
	 * Return the value associated with the column: systemlogaction
	 */
	public java.lang.String getSystemlogaction () {
		return systemlogaction;
	}

	/**
	 * Set the value related to the column: systemlogaction
	 * @param systemlogaction the systemlogaction value
	 */
	public void setSystemlogaction (java.lang.String systemlogaction) {
		this.systemlogaction = systemlogaction;
	}



	/**
	 * Return the value associated with the column: xlock
	 */
	public java.lang.String getXlock () {
		return xlock;
	}

	/**
	 * Set the value related to the column: xlock
	 * @param xlock the xlock value
	 */
	public void setXlock (java.lang.String xlock) {
		this.xlock = xlock;
	}



	/**
	 * Return the value associated with the column: xinactive
	 */
	public boolean isXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (boolean xinactive) {
		this.xinactive = xinactive;
	}



	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
	}



	/**
	 * Return the value associated with the column: length
	 */
	public java.math.BigDecimal getLength () {
		return length;
	}

	/**
	 * Set the value related to the column: length
	 * @param length the length value
	 */
	public void setLength (java.math.BigDecimal length) {
		this.length = length;
	}



	/**
	 * Return the value associated with the column: width
	 */
	public java.math.BigDecimal getWidth () {
		return width;
	}

	/**
	 * Set the value related to the column: width
	 * @param width the width value
	 */
	public void setWidth (java.math.BigDecimal width) {
		this.width = width;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.math.BigDecimal getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: unitmeasurecode
	 */
	public java.lang.String getUnitmeasurecode () {
		return unitmeasurecode;
	}

	/**
	 * Set the value related to the column: unitmeasurecode
	 * @param unitmeasurecode the unitmeasurecode value
	 */
	public void setUnitmeasurecode (java.lang.String unitmeasurecode) {
		this.unitmeasurecode = unitmeasurecode;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.mandr.Mandrdtl)) return false;
		else {
			com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl = (com.bureaueye.beacon.model.mandr.Mandrdtl) obj;
			if (null == this.getMandrdtlId() || null == mandrdtl.getMandrdtlId()) return false;
			else return (this.getMandrdtlId().equals(mandrdtl.getMandrdtlId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getMandrdtlId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getMandrdtlId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}