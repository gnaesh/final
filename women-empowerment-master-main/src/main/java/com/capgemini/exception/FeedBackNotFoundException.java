package com.capgemini.exception;

public class FeedBackNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FeedBackNotFoundException() {
		
		
	}
	public FeedBackNotFoundException(String msg) {
		super(msg);
	}
}
