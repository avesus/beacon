package com.bureaueye.beacon.model.standard;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoport;



public class Customertoport extends BaseCustomertoport {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customertoport () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customertoport (java.lang.Integer customertoportId) {
		super(customertoportId);
	}

	/**
	 * Constructor for required fields
	 */
	public Customertoport (
		java.lang.Integer customertoportId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		super (
			customertoportId,
			tokey,
			customeraddrkey);
	}

/*[CONSTRUCTOR MARKER END]*/


}