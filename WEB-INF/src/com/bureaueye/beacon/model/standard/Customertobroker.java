package com.bureaueye.beacon.model.standard;

import com.bureaueye.beacon.model.standard.base.BaseCustomertobroker;



public class Customertobroker extends BaseCustomertobroker {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customertobroker () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customertobroker (java.lang.Integer customertobrokerId) {
		super(customertobrokerId);
	}

	/**
	 * Constructor for required fields
	 */
	public Customertobroker (
		java.lang.Integer customertobrokerId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		super (
			customertobrokerId,
			tokey,
			customeraddrkey);
	}

/*[CONSTRUCTOR MARKER END]*/


}