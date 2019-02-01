package com.bureaueye.beacon.model.edi.base;

import java.io.Serializable;


public abstract class BaseEdirouterPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String routertype;
	private java.lang.String ediid;


	public BaseEdirouterPK () {}
	
	public BaseEdirouterPK (
		java.lang.String routertype,
		java.lang.String ediid) {

		this.setRoutertype(routertype);
		this.setEdiid(ediid);
	}


	/**
	 * Return the value associated with the column: routertype
	 */
	public java.lang.String getRoutertype () {
		return routertype;
	}

	/**
	 * Set the value related to the column: routertype
	 * @param routertype the routertype value
	 */
	public void setRoutertype (java.lang.String routertype) {
		this.routertype = routertype;
	}



	/**
	 * Return the value associated with the column: ediid
	 */
	public java.lang.String getEdiid () {
		return ediid;
	}

	/**
	 * Set the value related to the column: ediid
	 * @param ediid the ediid value
	 */
	public void setEdiid (java.lang.String ediid) {
		this.ediid = ediid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.edi.EdirouterPK)) return false;
		else {
			com.bureaueye.beacon.model.edi.EdirouterPK mObj = (com.bureaueye.beacon.model.edi.EdirouterPK) obj;
			if (null != this.getRoutertype() && null != mObj.getRoutertype()) {
				if (!this.getRoutertype().equals(mObj.getRoutertype())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getEdiid() && null != mObj.getEdiid()) {
				if (!this.getEdiid().equals(mObj.getEdiid())) {
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
			if (null != this.getRoutertype()) {
				sb.append(this.getRoutertype().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getEdiid()) {
				sb.append(this.getEdiid().hashCode());
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