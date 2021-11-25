package com.capgemini.exception;

public class InvalidContactException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidContactException() {
	}

	public InvalidContactException(String msg) {
		super(msg);
	}

}
