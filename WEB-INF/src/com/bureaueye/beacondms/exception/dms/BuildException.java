package com.bureaueye.beacondms.exception.dms;



/**
 *
 * Amendments
 * ----------
 *	
 */
public class BuildException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final int GENERAL_FAILURE = 99;
	

	
	
	
	
	private int code;
	
	public BuildException(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
