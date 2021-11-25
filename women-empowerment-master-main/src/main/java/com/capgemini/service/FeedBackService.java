package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.FeedBackAlreadyExistsException;
import com.capgemini.exception.FeedBackNotFoundException;
import com.capgemini.model.FeedBack;
import com.capgemini.repository.IFeedBackRepository;



@Service
public class FeedBackService implements IFeedBackService{
	
	private static final Logger LOG = LoggerFactory.getLogger(FeedBackService.class);
	 
	@Autowired
	private IFeedBackRepository ifeedbackrepository;
	
	
	@Override
	public FeedBack addFeedBack(FeedBack feedback) 
	{
		LOG.info("Service addfeedback");
		boolean feedbackOpt = ifeedbackrepository.existsById(feedback.getFeedBackId());
		if (!feedbackOpt) {
			return ifeedbackrepository.save(feedback);
		} else {
			throw new FeedBackAlreadyExistsException(feedback + " is already exists.");
		}
	}
// -------------------------------------------------------------------------------------------
	@Override
	public FeedBack updateFeedBack(FeedBack feedback) {
		LOG.info("Service updatefeedback");
		Optional<FeedBack> feedbackOpt = ifeedbackrepository.findById(feedback.getFeedBackId());
		if (feedbackOpt.isPresent())
			return ifeedbackrepository.save(feedback);
		else
			throw new FeedBackNotFoundException(feedback + " not found.");
			
		}
		
	
// -------------------------------------------------------------------------------------------
	@Override
	public FeedBack viewFeedBack(int feedbackId) {
		LOG.info("Service viewfeedback");
		Optional<FeedBack> feedbackOpt = ifeedbackrepository.findById(feedbackId);
		if (!feedbackOpt.isEmpty())
			return feedbackOpt.get();
		else
			throw new FeedBackNotFoundException("feedback Id: " + feedbackId + " not found.");
	}
	// -------------------------------------------------------------------------------------------	
	@Override
	public List<FeedBack> viewAllFeedBack() {
		LOG.info("Service viewAllfeedback");
		List<FeedBack> feedbackOpt = ifeedbackrepository.findAll();
		if (!feedbackOpt.isEmpty()) {
			return feedbackOpt;
		} else {
			throw new FeedBackNotFoundException(" not found.");
		}
	}
	
	@Override
	public FeedBack deleteFeedback(int feedbackId) {
		LOG.info("Service deletefeedback");
		Optional<FeedBack> feedbackOpt = ifeedbackrepository.findById(feedbackId);
		if (feedbackOpt.isPresent()) {
			ifeedbackrepository.deleteById(feedbackId);
			return feedbackOpt.get();
		} else {
			throw new FeedBackNotFoundException("feedback Id: " + feedbackId + " not found.");
		}
	}
	
	
// -------------------------------------------------------------------------------------------
//	@Override
//	public List<FeedBack> viewFeedBackBySchemeName() {
//		
//		LOG.info("Service viewFeedBackBySchemeName");
//		List<FeedBack> feedbackOpt = ifeedbackrepository.findBySchemeName(schemeName);
//		if (!feedbackOpt.isEmpty())
//			return feedbackOpt;
//		else
//			throw new FeedBackNotFoundException("viewFeedBackBy \" " + schemeName + "\" is not found.");
//			}
//	
// -------------------------------------------------------------------------------------------
//	@Override
//	public List<FeedBack> viewFeedBackByTrainingCourseName() {
//		LOG.info("Service viewFeedBackByTrainingCourseName");
//		List<FeedBack> feedbackOpt = ifeedbackrepository.findByTrainingCourseName(TrainingCourseName);
//		if (!feedbackOpt.isEmpty())
//			return feedbackOpt;
//		else
//			throw new FeedBackNotFoundException("FeedBackBy \" " + TrainingCourseName + "\" is not found.");
//		
//	}
	
// -------------------------------------------------------------------------------------------
	

}
