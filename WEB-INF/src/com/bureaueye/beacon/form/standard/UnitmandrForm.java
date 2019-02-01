package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;



public final class UnitmandrForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
	

	// primary key
	private java.lang.String unitmandrId;

	// fields
	private java.lang.String unitkey;
	private java.lang.String fitgrpkey;
	private java.lang.String fittypkey;
	private java.lang.String xlock;
	private boolean xinactive;
	private boolean deleted;
	private java.lang.String unitId;
	private java.lang.String mandrdesc;
	private java.lang.String mandrref;
	private java.lang.String ccykey;
	private String labouramt = "0.0";
	private String materialamt = "0.0";

	private java.lang.String mandrdatedd;
	private java.lang.String mandrdatemm;
	private java.lang.String mandrdateyyyy;
	
	private java.lang.String lesseeaddrkey;
	private java.lang.String locationkey;;	
	

	

	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="UNITMANDR_ID"
     */
	public java.lang.String getUnitmandrId () {
		return unitmandrId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param unitmandrId the new ID
	 */
	public void setUnitmandrId (java.lang.String unitmandrId) {
		this.unitmandrId = unitmandrId;
	}




	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String unitkey) {
		this.unitkey = unitkey;
	}



	/**
	 * Return the value associated with the column: fitgrpkey
	 */
	public String getFitgrpkey () {
		return fitgrpkey;
	}

	/**
	 * Set the value related to the column: fitgrpkey
	 * @param fitgrpkey the fitgrpkey value
	 */
	public void setFitgrpkey (String fitgrpkey) {
		this.fitgrpkey = fitgrpkey;
	}



	/**
	 * Return the value associated with the column: fittypkey
	 */
	public String getFittypkey () {
		return fittypkey;
	}

	/**
	 * Set the value related to the column: fittypkey
	 * @param fittypkey the fittypkey value
	 */
	public void setFittypkey (String fittypkey) {
		this.fittypkey = fittypkey;
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
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.String getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.String unitId) {
		this.unitId = unitId;
	}






	/**
	 * Return the value associated with the column: mandrdesc
	 */
	public java.lang.String getMandrdesc () {
		return mandrdesc;
	}

	/**
	 * Set the value related to the column: mandrdesc
	 * @param mandrdesc the mandrdesc value
	 */
	public void setMandrdesc (java.lang.String mandrdesc) {
		this.mandrdesc = mandrdesc;
	}



	/**
	 * Return the value associated with the column: mandrref
	 */
	public java.lang.String getMandrref () {
		return mandrref;
	}

	/**
	 * Set the value related to the column: mandrref
	 * @param mandrref the mandrref value
	 */
	public void setMandrref (java.lang.String mandrref) {
		this.mandrref = mandrref;
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
	 * Return the value associated with the column: labouramt
	 */
	public String getLabouramt () {
		return labouramt;
	}

	/**
	 * Set the value related to the column: labouramt
	 * @param labouramt the labouramt value
	 */
	public void setLabouramt (String labouramt) {
		this.labouramt = labouramt;
	}



	/**
	 * Return the value associated with the column: materialamt
	 */
	public String getMaterialamt () {
		return materialamt;
	}

	/**
	 * Set the value related to the column: materialamt
	 * @param materialamt the materialamt value
	 */
	public void setMaterialamt (String materialamt) {
		this.materialamt = materialamt;
	}







	/**
	 * Return the value associated with the column: lesseeaddrkey
	 */
	public String getLesseeaddrkey () {
		return lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (String lesseeaddrkey) {
		this.lesseeaddrkey = lesseeaddrkey;
	}



	/**
	 * Return the value associated with the column: locationkey
	 */
	public String getLocationkey () {
		return locationkey;
	}

	/**
	 * Set the value related to the column: locationkey
	 * @param locationkey the locationkey value
	 */
	public void setLocationkey (String locationkey) {
		this.locationkey = locationkey;
	}

	
	
	public Date getMandrdate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getMandrdateyyyy()), Integer
						.parseInt(getMandrdatemm()) - 1, Integer
						.parseInt(getMandrdatedd()));
		return c.getTime();
	}
	public void setMandrdate(Date mandrdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(mandrdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setMandrdateyyyy(c.get(Calendar.YEAR) + "");
		setMandrdatemm((month < 10 ? "0" : "") + month);
		setMandrdatedd((day < 10 ? "0" : "") + day);
	}
	public String getMandrdatedd () {return mandrdatedd;}
	public void setMandrdatedd (String mandrdatedd) {this.mandrdatedd = mandrdatedd;}
	public String getMandrdatemm () {return mandrdatemm;}
	public void setMandrdatemm (String mandrdatemm) {this.mandrdatemm = mandrdatemm;}
	public String getMandrdateyyyy () {return mandrdateyyyy;}
	public void setMandrdateyyyy (String mandrdateyyyy) {this.mandrdateyyyy = mandrdateyyyy;}

	
	
	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();	
		
		
		
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
