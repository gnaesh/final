package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.InvalidFieldException;
import com.capgemini.exception.TraineeNotFoundException;
import com.capgemini.model.Trainee;




public interface ITraineeService 
{
	Trainee addTrainee(Trainee course) throws InvalidFieldException, TraineeNotFoundException;
	Trainee updateTrainee(Trainee course);
	public Trainee viewTrainee(int courseId);
	List<Trainee> viewAllTrainee();
	Trainee deleteTrainee(int courseId);
	List<Trainee> viewAllTraineesByLocation(String location);
	Trainee viewTraineeByAadhar(long aadharNo);

}
