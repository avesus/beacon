package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


public abstract class BaseFittypPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String fittypkey;
	private java.lang.String fitgrpkey;


	public BaseFittypPK () {}
	
	public BaseFittypPK (
		java.lang.String fittypkey,
		java.lang.String fitgrpkey) {

		this.setFittypkey(fittypkey);
		this.setFitgrpkey(fitgrpkey);
	}


	/**
	 * Return the value associated with the column: fittypkey
	 */
	public java.lang.String getFittypkey () {
		return fittypkey;
	}

	/**
	 * Set the value related to the column: fittypkey
	 * @param fittypkey the fittypkey value
	 */
	public void setFittypkey (java.lang.String fittypkey) {
		this.fittypkey = fittypkey;
	}



	/**
	 * Return the value associated with the column: fitgrpkey
	 */
	public java.lang.String getFitgrpkey () {
		return fitgrpkey;
	}

	/**
	 * Set the value related to the column: fitgrpkey
	 * @param fitgrpkey the fitgrpkey value
	 */
	public void setFitgrpkey (java.lang.String fitgrpkey) {
		this.fitgrpkey = fitgrpkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.FittypPK)) return false;
		else {
			com.bureaueye.beacon.model.standard.FittypPK mObj = (com.bureaueye.beacon.model.standard.FittypPK) obj;
			if (null != this.getFittypkey() && null != mObj.getFittypkey()) {
				if (!this.getFittypkey().equals(mObj.getFittypkey())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getFitgrpkey() && null != mObj.getFitgrpkey()) {
				if (!this.getFitgrpkey().equals(mObj.getFitgrpkey())) {
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
			if (null != this.getFittypkey()) {
				sb.append(this.getFittypkey().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getFitgrpkey()) {
				sb.append(this.getFitgrpkey().hashCode());
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