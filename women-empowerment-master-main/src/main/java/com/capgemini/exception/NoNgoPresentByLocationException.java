package com.capgemini.exception;

public class NoNgoPresentByLocationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/*
	 * Argument Constructor in Exception
	 */
	public NoNgoPresentByLocationException() {
		super();
	}

	/*
	 * Argument Constructor for passing Message in Exception
	 */
	public NoNgoPresentByLocationException(String message) {
		super(message);

	}
}
