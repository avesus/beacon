package com.bureaueye.beacon.model.edi;

import com.bureaueye.beacon.model.edi.base.BaseEdipartnermappingcode;



public class Edipartnermappingcode extends BaseEdipartnermappingcode {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Edipartnermappingcode () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Edipartnermappingcode (java.lang.Integer edipartnermappingcodeId) {
		super(edipartnermappingcodeId);
	}

	/**
	 * Constructor for required fields
	 */
	public Edipartnermappingcode (
		java.lang.Integer edipartnermappingcodeId,
		java.lang.String ediid) {

		super (
			edipartnermappingcodeId,
			ediid);
	}

/*[CONSTRUCTOR MARKER END]*/


}