package com.bureaueye.beacon.model.standard;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoshipline;



public class Customertoshipline extends BaseCustomertoshipline {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customertoshipline () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customertoshipline (java.lang.Integer customertoshiplineId) {
		super(customertoshiplineId);
	}

	/**
	 * Constructor for required fields
	 */
	public Customertoshipline (
		java.lang.Integer customertoshiplineId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		super (
			customertoshiplineId,
			tokey,
			customeraddrkey);
	}

/*[CONSTRUCTOR MARKER END]*/


}