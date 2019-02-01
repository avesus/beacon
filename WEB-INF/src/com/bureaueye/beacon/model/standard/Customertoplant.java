package com.bureaueye.beacon.model.standard;

import com.bureaueye.beacon.model.standard.base.BaseCustomertoplant;



public class Customertoplant extends BaseCustomertoplant {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customertoplant () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customertoplant (java.lang.Integer customertoplantId) {
		super(customertoplantId);
	}

	/**
	 * Constructor for required fields
	 */
	public Customertoplant (
		java.lang.Integer customertoplantId,
		java.lang.String tokey,
		java.lang.String customeraddrkey) {

		super (
			customertoplantId,
			tokey,
			customeraddrkey);
	}

/*[CONSTRUCTOR MARKER END]*/


}