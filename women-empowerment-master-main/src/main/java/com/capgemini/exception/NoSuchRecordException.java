package com.capgemini.exception;


public class NoSuchRecordException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchRecordException()
	{}

    public NoSuchRecordException(String msg)
    {
    	super(msg);
    }
}
