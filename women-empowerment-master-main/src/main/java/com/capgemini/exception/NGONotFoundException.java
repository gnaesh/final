package com.capgemini.exception;

public class NGONotFoundException extends RuntimeException {

	/*
	 * No Argument Constructor for Exception
	 */
	private static final long serialVersionUID = 1L;

	public NGONotFoundException() {
	}

	/*
	 * Argument Constructor for passing Message in Exception
	 */
	public NGONotFoundException(String msg) {
		super(msg);
	}
}
