package com.bureaueye.beacon.model.standard;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoconsignee;



public class Customertoconsignee extends BaseCustomertoconsignee {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customertoconsignee () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customertoconsignee (java.lang.Integer customertoconsigneeId) {
		super(customertoconsigneeId);
	}

	/**
	 * Constructor for required fields
	 */
	public Customertoconsignee (
		java.lang.Integer customertoconsigneeId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		super (
			customertoconsigneeId,
			tokey,
			customeraddrkey);
	}

/*[CONSTRUCTOR MARKER END]*/


}