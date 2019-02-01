package com.bureaueye.beacon.exception;

public class ApplicationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int ROW_NOT_CREATED_UPDATED = 0;

	public static final int ROW_NOT_READ = 1;

	public static final int ROW_NOT_DELETED = 2;

	public static final int LIST_FAILED = 3;

	private int code;

	public ApplicationException(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
