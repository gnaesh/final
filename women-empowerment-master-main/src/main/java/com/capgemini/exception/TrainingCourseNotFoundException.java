package com.capgemini.exception;

public class TrainingCourseNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TrainingCourseNotFoundException() {
		super();
	}
	
	public TrainingCourseNotFoundException(String message) {
		super(message);
	}
	
}
