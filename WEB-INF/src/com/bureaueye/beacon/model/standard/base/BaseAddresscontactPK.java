package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


public abstract class BaseAddresscontactPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String contactkey;
	private java.lang.String addrkey;


	public BaseAddresscontactPK () {}
	
	public BaseAddresscontactPK (
		java.lang.String contactkey,
		java.lang.String addrkey) {

		this.setContactkey(contactkey);
		this.setAddrkey(addrkey);
	}


	/**
	 * Return the value associated with the column: contactkey
	 */
	public java.lang.String getContactkey () {
		return contactkey;
	}

	/**
	 * Set the value related to the column: contactkey
	 * @param contactkey the contactkey value
	 */
	public void setContactkey (java.lang.String contactkey) {
		this.contactkey = contactkey;
	}



	/**
	 * Return the value associated with the column: addrkey
	 */
	public java.lang.String getAddrkey () {
		return addrkey;
	}

	/**
	 * Set the value related to the column: addrkey
	 * @param addrkey the addrkey value
	 */
	public void setAddrkey (java.lang.String addrkey) {
		this.addrkey = addrkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.AddresscontactPK)) return false;
		else {
			com.bureaueye.beacon.model.standard.AddresscontactPK mObj = (com.bureaueye.beacon.model.standard.AddresscontactPK) obj;
			if (null != this.getContactkey() && null != mObj.getContactkey()) {
				if (!this.getContactkey().equals(mObj.getContactkey())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getAddrkey() && null != mObj.getAddrkey()) {
				if (!this.getAddrkey().equals(mObj.getAddrkey())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getContactkey()) {
				sb.append(this.getContactkey().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getAddrkey()) {
				sb.append(this.getAddrkey().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}