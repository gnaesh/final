package com.capgemini.exception;

public class SchemeAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public SchemeAlreadyExistsException() {
		super();
	}
	
	public SchemeAlreadyExistsException(String message) {
		super(message);
	}
	
}
