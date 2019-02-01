package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;

import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Cost;

/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-16		ITT-200906-0004		Vendor Tariff Lump Sum Breakdown
 * 												
 *
 */
public class VendortarifflumpsumDTO extends BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vendtarflumpsumId;

	private String errorflag = "";

	private String row;
	
	private String vendtarfhdrId2;

	private Address vendoraddrkey;

	private Cost costkey;

	private String lumpsum;

	public Address getVendoraddrkey() {
		return vendoraddrkey;
	}
	public void setVendoraddrkey(Address vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
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

	public Cost getCostkey() {
		return costkey;
	}
	public void setCostkey(Cost costkey) {
		this.costkey = costkey;
	}

	public String getVendtarfhdrId2() {
		return vendtarfhdrId2;
	}
	public void setVendtarfhdrId2(String vendtarfhdrId2) {
		this.vendtarfhdrId2 = vendtarfhdrId2;
	}

	public String getVendtarflumpsumId() {
		return vendtarflumpsumId;
	}
	public void setVendtarflumpsumId(String vendtarflumpsumId) {
		this.vendtarflumpsumId = vendtarflumpsumId;
	}

	public String getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}
	
}
