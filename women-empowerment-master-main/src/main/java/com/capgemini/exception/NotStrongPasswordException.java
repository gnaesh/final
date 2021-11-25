package com.capgemini.exception;

public class NotStrongPasswordException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotStrongPasswordException()
	{}
	
	public NotStrongPasswordException(String msg)
	{
		super(msg);
	}

}
