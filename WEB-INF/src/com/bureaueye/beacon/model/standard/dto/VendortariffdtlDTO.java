package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;

import com.bureaueye.beacon.model.dto.BaseDTO;

public class VendortariffdtlDTO extends BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vendtarfdtlId;

	private String errorflag = "";

	private String row;
	
	private String fromvalue;

	private String tovalue;

	private String unitrate;

	private String lumpsum;

	public String getFromvalue() {
		return fromvalue;
	}
	public void setFromvalue(String fromvalue) {
		this.fromvalue = fromvalue;
	}

	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	
	public String getLumpsum() {
		return lumpsum;
	}
	public void setLumpsum(String lumpsum) {
		this.lumpsum = lumpsum;
	}

	public String getTovalue() {
		return tovalue;
	}
	public void setTovalue(String tovalue) {
		this.tovalue = tovalue;
	}

	public String getUnitrate() {
		return unitrate;
	}
	public void setUnitrate(String unitrate) {
		this.unitrate = unitrate;
	}

	public String getVendtarfdtlId() {
		return vendtarfdtlId;
	}
	public void setVendtarfdtlId(String vendtarfdtlId) {
		this.vendtarfdtlId = vendtarfdtlId;
	}

	public String getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}
	
}
