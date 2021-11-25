package com.capgemini.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.model.FeedBack;


public interface IFeedBackController {
	ResponseEntity<FeedBack> addFeedBack(FeedBack feedback);

	ResponseEntity<FeedBack> updateFeedBack(FeedBack feedback);

	ResponseEntity<FeedBack> viewFeedBack(int feedbackId);

	ResponseEntity<List<FeedBack>> viewAllFeedBack();

//	List<FeedBack> viewFeedBackBySchemeName();
//
//	List<FeedBack> viewFeedBackByTrainingCourseName();
}
