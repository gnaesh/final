package com.capgemini.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.model.Trainee;



public interface ITraineeController {
	ResponseEntity<Trainee> addTrainee(Trainee course);

	ResponseEntity<Trainee> updateTrainee(Trainee course);

	ResponseEntity<Trainee> viewTrainee(int courseId);

	ResponseEntity<List<Trainee>> viewAllTrainee();

	ResponseEntity<Trainee> deleteTrainee(int courseId);

	ResponseEntity<List<Trainee>> viewAllTraineesByLocation(String location);

	ResponseEntity<Trainee> viewTraineeByAadhar(long aadharNo);

}
