package com.capgemini.exception;


public class NoSuchCourseIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchCourseIdException() {
	}

	public NoSuchCourseIdException(String msg) {
		super(msg);
	}
}
