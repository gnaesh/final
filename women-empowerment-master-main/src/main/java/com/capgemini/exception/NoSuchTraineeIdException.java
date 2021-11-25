package com.capgemini.exception;


public class NoSuchTraineeIdException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoSuchTraineeIdException()
	{}
	public NoSuchTraineeIdException(String msg)
	{
		super(msg);
	}
}
