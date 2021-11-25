package com.capgemini.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.NoSuchRecordException;
import com.capgemini.model.Trainee;
import com.capgemini.service.TraineeServiceImpl;



@RestController
public class TraineeController implements ITraineeController {
	private static final Logger LOG = LoggerFactory.getLogger(TraineeController.class);

	@Autowired
	private TraineeServiceImpl traineeservice;

	@PostMapping("/addtrainee")
	public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee trainee) 
	{LOG.info("addTrainee");
	Trainee addTrainee=traineeservice.addTrainee(trainee);
	HttpHeaders headers=new HttpHeaders();
	headers.add("message", "Trainee added successfully");
	ResponseEntity<Trainee> response =new ResponseEntity<Trainee>(addTrainee,headers,HttpStatus.CREATED);
	return response;
		
	}


	// ------------------------------------------------------------------------------------------
	
	// http://localhost:8082/updateemptrainee
	@PutMapping("/updatetrainee")
	public ResponseEntity<Trainee> updateTrainee(@RequestBody Trainee trainee) {
		LOG.info("updateTrainee");
		Trainee updateTrainee = traineeservice.updateTrainee(trainee);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", ""+ trainee +" updated successfully");
		LOG.info(headers.toString());
		ResponseEntity<Trainee> response = new ResponseEntity<Trainee>(updateTrainee, headers, HttpStatus.OK);
		return response;
	}

	// ------------------------------------------------------------------------------------------
	
	@GetMapping("/viewTraineeByCourseId")
	public ResponseEntity<Trainee> viewTrainee(int courseId) {
		LOG.info("viewTraineeByCourseId");
		Trainee viewTraineeByCourseId = traineeservice.viewTrainee(courseId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Data of Trainee with "+ courseId + " retrived successfully from the database");
		LOG.info(headers.toString());
		ResponseEntity<Trainee> response = new ResponseEntity<Trainee>(viewTraineeByCourseId, headers, HttpStatus.OK);
		return response;
	}

	// ------------------------------------------------------------------------------------------
	
	@GetMapping("/viewAllTrainee")
	public ResponseEntity<List<Trainee>> viewAllTrainee() 
	{
		LOG.info("viewAllTraineesByLocation");
		List<Trainee> viewAllTrainee=traineeservice.viewAllTrainee();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All Trainees data retrieved successfully from the database.");
		LOG.info(headers.toString());
		ResponseEntity<List<Trainee>> response = new ResponseEntity<>(viewAllTrainee, headers, HttpStatus.OK);
		return response; 
	}

	// ------------------------------------------------------------------------------------------
		
	@DeleteMapping(path = "deleteTraineeByCourseId/{courseId}")
	public ResponseEntity<Trainee> deleteTrainee(@PathVariable(name= "courseId") int courseId) throws NoSuchRecordException 
	{
		LOG.info("deleteTraineeByCourseId");
		Trainee t = traineeservice.deleteTrainee(courseId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Trainee with "+ courseId +" deleted successfully.");
		LOG.info(headers.toString());
		ResponseEntity<Trainee> response = new ResponseEntity<Trainee>(t, headers, HttpStatus.OK);
		return response;
	}

	// ------------------------------------------------------------------------------------------
	
	@GetMapping("/viewAllTraineesByLocation/{location}")
	public ResponseEntity<List<Trainee>> viewAllTraineesByLocation(String location)
	{
		LOG.info("viewAllTraineesByLocation");
		List<Trainee> list=traineeservice.viewAllTraineesByLocation(location);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Trainees from \"" + location + "\" are successfully retrieved from the database.");
		LOG.info(headers.toString());
		ResponseEntity<List<Trainee>> response = new ResponseEntity<>(list, headers, HttpStatus.OK);
	    return response;
	}

	// ------------------------------------------------------------------------------------------
	
	@GetMapping("/viewbyaadharno/{aadharNo}")
	public ResponseEntity<Trainee> viewTraineeByAadhar(@PathVariable long aadharNo) 
	{
		LOG.info("getTraineeByAadharNo");
		Trainee traineeByAadaharNo=traineeservice.viewTraineeByAadhar(aadharNo);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Trainee macthing with \"" + aadharNo + "\" is successfully retrieved from the database.");
		LOG.info(headers.toString());
		ResponseEntity<Trainee> response = new ResponseEntity<>(traineeByAadaharNo, headers, HttpStatus.OK);
		return response;
		
	}

}
