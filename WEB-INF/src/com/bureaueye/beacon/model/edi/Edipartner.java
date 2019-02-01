package com.bureaueye.beacon.model.edi;

import com.bureaueye.beacon.model.edi.base.BaseEdipartner;



public class Edipartner extends BaseEdipartner {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Edipartner () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Edipartner (java.lang.Integer edipartnerId) {
		super(edipartnerId);
	}

	/**
	 * Constructor for required fields
	 */
	public Edipartner (
		java.lang.Integer edipartnerId,
		java.lang.String ediid) {

		super (
			edipartnerId,
			ediid);
	}

/*[CONSTRUCTOR MARKER END]*/


}