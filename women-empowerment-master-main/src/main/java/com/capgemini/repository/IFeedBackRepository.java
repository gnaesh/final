package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.FeedBack;



@Repository
public interface IFeedBackRepository extends JpaRepository<FeedBack, Integer>{
//	public abstract FeedBack addFeedBack(FeedBack feedback);
//
//    public abstract FeedBack updateFeedBack(FeedBack feedback);
//
//	public abstract FeedBack viewFeedBack(int feedbackId);
//
//	public abstract	List<FeedBack> viewAllFeedBack();
//	
//	
//	public abstract List<FeedBack> viewFeedBackBySchemeName();
//
//	public abstract List<FeedBack> viewFeedBackByTrainingCourseName();
	
	
}
