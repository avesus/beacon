package com.bureaueye.beacon.model.standard;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoproduct;



public class Customertoproduct extends BaseCustomertoproduct {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customertoproduct () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customertoproduct (java.lang.Integer customertoproductId) {
		super(customertoproductId);
	}

	/**
	 * Constructor for required fields
	 */
	public Customertoproduct (
		java.lang.Integer customertoproductId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		super (
			customertoproductId,
			tokey,
			customeraddrkey);
	}

/*[CONSTRUCTOR MARKER END]*/


}