package com.capgemini.exception;

public class NoSuchNgoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/*
	 * No Argument Constructor in Exception
	 */
	public NoSuchNgoException() {
		super();
	}

	/*
	 * Argument Constructor for passing Message in Exception
	 */
	public NoSuchNgoException(String message) {
		super(message);

	}
}