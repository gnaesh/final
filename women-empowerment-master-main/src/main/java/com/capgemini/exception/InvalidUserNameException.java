package com.capgemini.exception;

public class InvalidUserNameException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserNameException()
	{}
	
	public InvalidUserNameException(String msg)
	{
		super(msg);
	}

}