package com.capgemini.exception;

public class FeedBackAlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FeedBackAlreadyExistsException() {
		super();
	}
	
	public FeedBackAlreadyExistsException(String message) {
		super(message);
	}

}
