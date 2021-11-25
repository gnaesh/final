package com.capgemini.exception;

public class SchemeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public SchemeNotFoundException() {
		super();
	}
	
	public SchemeNotFoundException(String message) {
		super(message);
	}
}
