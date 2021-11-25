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



import com.capgemini.model.FeedBack;

import com.capgemini.service.IFeedBackService;


@RestController
public class FeedbackController implements IFeedBackController{

	private static final Logger LOG = LoggerFactory.getLogger(FeedbackController.class);

	@Autowired
	private IFeedBackService feedbackService;

	@PostMapping(path = "/feedback")
	public ResponseEntity<FeedBack> addFeedBack(@RequestBody FeedBack course)  {
		LOG.info("Controller addFeedBack");
		ResponseEntity<FeedBack> response = null;
		FeedBack addFeedBack = feedbackService.addFeedBack(course);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "FeedBack added to database");
		response = new ResponseEntity<FeedBack>(addFeedBack, headers, HttpStatus.CREATED);
		return response;
	}

	// -------------------------------------------------------------------------------------------
	// http://localhost:8082/updateempfeedback
	@PutMapping("/updatefeedback")
	public ResponseEntity<FeedBack> updateFeedBack(@RequestBody FeedBack feedback) {
		LOG.info("Controller updateFeedBack");
		FeedBack updateFeedBack = feedbackService.updateFeedBack(feedback);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "" + feedback + " updated successfully");
		LOG.info(headers.toString());
		ResponseEntity<FeedBack> response = new ResponseEntity<FeedBack>(updateFeedBack, headers, HttpStatus.OK);
		return response;
	}
	// -------------------------------------------------------------------------------------------

	@GetMapping("/viewFeedBack/{feedBackId}")
	public ResponseEntity<FeedBack> viewFeedBack(@PathVariable(name="feedBackId") int feedbackId) {
		LOG.info("Controller viewFeedBack");
		FeedBack viewFeedBack = feedbackService.viewFeedBack(feedbackId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "feedback with " + feedbackId + " retrived successfully from the database");
		LOG.info(headers.toString());
		ResponseEntity<FeedBack> response = new ResponseEntity<FeedBack>(viewFeedBack, headers,
				HttpStatus.OK);
		return response;
	}
	// -------------------------------------------------------------------------------------------
	@GetMapping("/viewAllfeedback")
	public ResponseEntity<List<FeedBack>> viewAllFeedBack() {
		LOG.info("Controller viewAllFeedBack");
		List<FeedBack> viewAllFeedBack = feedbackService.viewAllFeedBack();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All feedback data retrieved successfully from the database.");
		LOG.info(headers.toString());
		ResponseEntity<List<FeedBack>> response = new ResponseEntity<>(viewAllFeedBack, headers, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/deletefeedbackbyid/{feedbackId}")
	public ResponseEntity<FeedBack> deleteFeedback(@PathVariable(name = "feedbackId") int feedbackId) {
		LOG.info("Controller deletefeedbackById");
		FeedBack sch = feedbackService.deleteFeedback(feedbackId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Scheme having id \""+ feedbackId +"\" deleted successfully.");
		LOG.info(headers.toString());
		ResponseEntity<FeedBack> response = new ResponseEntity<>(sch, headers, HttpStatus.OK);
		return response;
	}
//	// -------------------------------------------------------------------------------------------
//	@GetMapping("/viewFeedBackBySchemeName")
//	public ResponseEntity<List<FeedBack>> viewFeedBackBySchemeName(String SchemeName) {
//		LOG.info("Controller viewFeedBackBySchemeName");
//		List<FeedBack> viewFeedBackBySchemeName = feedbackService.viewFeedBackBySchemeName();
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "Data of feedback with " + SchemeName + " retrived successfully from the database");
//		LOG.info(headers.toString());
//		ResponseEntity<List<FeedBack>> response = new ResponseEntity<List<FeedBack>>(viewFeedBackBySchemeName, headers,
//				HttpStatus.OK);
//		return response;
//	}
	// -------------------------------------------------------------------------------------------

//	@GetMapping("/viewFeedBackByTrainingCourseName")
//	public ResponseEntity<List<FeedBack>> viewFeedBackByTrainingCourseName(String TrainingCourseName) {
//		LOG.info("Controller viewFeedBackByTrainingCourseName");
//		List<FeedBack> viewFeedBackByTrainingCourseName = feedbackService.viewFeedBackByTrainingCourseName();
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message",
//				"Data of feedback with " + TrainingCourseName + " retrived successfully from the database");
//		LOG.info(headers.toString());
//		ResponseEntity<List<FeedBack>> response = new ResponseEntity<>(viewFeedBackByTrainingCourseName, headers, HttpStatus.OK);
//		return response;
//	}

	// -------------------------------------------------------------------------------------------
	


}
