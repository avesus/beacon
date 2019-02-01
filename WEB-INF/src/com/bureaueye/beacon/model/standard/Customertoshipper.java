package com.bureaueye.beacon.model.standard;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoshipper;



public class Customertoshipper extends BaseCustomertoshipper {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customertoshipper () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customertoshipper (java.lang.Integer customertoshipperId) {
		super(customertoshipperId);
	}

	/**
	 * Constructor for required fields
	 */
	public Customertoshipper (
		java.lang.Integer customertoshipperId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		super (
			customertoshipperId,
			tokey,
			customeraddrkey);
	}

/*[CONSTRUCTOR MARKER END]*/


}