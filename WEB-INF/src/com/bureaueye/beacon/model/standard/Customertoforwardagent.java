package com.bureaueye.beacon.model.standard;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoforwardagent;



public class Customertoforwardagent extends BaseCustomertoforwardagent {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customertoforwardagent () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customertoforwardagent (java.lang.Integer customertoforwardagentId) {
		super(customertoforwardagentId);
	}

	/**
	 * Constructor for required fields
	 */
	public Customertoforwardagent (
		java.lang.Integer customertoforwardagentId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		super (
			customertoforwardagentId,
			tokey,
			customeraddrkey);
	}

/*[CONSTRUCTOR MARKER END]*/


}