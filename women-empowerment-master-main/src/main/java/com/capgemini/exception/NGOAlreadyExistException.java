package com.capgemini.exception;

public class NGOAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/*
	 * No Argument Constructor for Exception
	 */
	public NGOAlreadyExistException() {
		// TODO Auto-generated constructor stub
		super();

	}

	/*
	 * Argument Constructor for passing Message in Exception
	 */
	public NGOAlreadyExistException(String message) {
		super(message);

	}
}
