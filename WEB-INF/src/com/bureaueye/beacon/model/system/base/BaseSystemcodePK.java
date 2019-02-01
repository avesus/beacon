package com.bureaueye.beacon.model.system.base;

import java.io.Serializable;


public abstract class BaseSystemcodePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String typekey;
	private java.lang.String codekey;


	public BaseSystemcodePK () {}
	
	public BaseSystemcodePK (
		java.lang.String typekey,
		java.lang.String codekey) {

		this.setTypekey(typekey);
		this.setCodekey(codekey);
	}


	/**
	 * Return the value associated with the column: typekey
	 */
	public java.lang.String getTypekey () {
		return typekey;
	}

	/**
	 * Set the value related to the column: typekey
	 * @param typekey the typekey value
	 */
	public void setTypekey (java.lang.String typekey) {
		this.typekey = typekey;
	}



	/**
	 * Return the value associated with the column: codekey
	 */
	public java.lang.String getCodekey () {
		return codekey;
	}

	/**
	 * Set the value related to the column: codekey
	 * @param codekey the codekey value
	 */
	public void setCodekey (java.lang.String codekey) {
		this.codekey = codekey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.system.SystemcodePK)) return false;
		else {
			com.bureaueye.beacon.model.system.SystemcodePK mObj = (com.bureaueye.beacon.model.system.SystemcodePK) obj;
			if (null != this.getTypekey() && null != mObj.getTypekey()) {
				if (!this.getTypekey().equals(mObj.getTypekey())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getCodekey() && null != mObj.getCodekey()) {
				if (!this.getCodekey().equals(mObj.getCodekey())) {
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
			if (null != this.getTypekey()) {
				sb.append(this.getTypekey().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getCodekey()) {
				sb.append(this.getCodekey().hashCode());
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