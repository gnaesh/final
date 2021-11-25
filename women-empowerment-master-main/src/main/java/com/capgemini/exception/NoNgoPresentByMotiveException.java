package com.capgemini.exception;

public class NoNgoPresentByMotiveException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/*
	 * Argument Constructor in Exception
	 */
	public NoNgoPresentByMotiveException() {
		super();
	}

	/*
	 * Argument Constructor for passing Message in Exception
	 */
	public NoNgoPresentByMotiveException(String message) {
		super(message);

	}
}
