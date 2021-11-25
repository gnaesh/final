package com.capgemini.service;

import java.util.List;

import com.capgemini.model.FeedBack;



public interface IFeedBackService {
	FeedBack addFeedBack(FeedBack feedback);

	FeedBack updateFeedBack(FeedBack feedback);

	FeedBack viewFeedBack(int feedbackId);

	List<FeedBack> viewAllFeedBack();

	FeedBack deleteFeedback(int feedbackId);

	

//	List<FeedBack> viewFeedBackBySchemeName();
//
//	List<FeedBack> viewFeedBackByTrainingCourseName();
}
