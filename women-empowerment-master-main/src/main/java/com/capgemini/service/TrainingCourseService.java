package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.exception.TrainingCourseNotFoundException;
import com.capgemini.model.TrainingCourse;
import com.capgemini.repository.ITrainingCourseRepository;


@Service
public class TrainingCourseService implements ITrainingCourseServices{
	private static final Logger LOG = LoggerFactory.getLogger(TrainingCourseService.class);
	@Autowired
      ITrainingCourseRepository trainrepo;
      @Override
	public TrainingCourse addTrainingCourse(TrainingCourse course) {
//           List<TrainingCourse> li=trainrepo.findByName(course.getCourseName());
//           if(li.contains(course.getCourseName())) {
//        	   throw new TrainingCourseNotFoundException("Courses is already added");
//           }
          return trainrepo.save(course);
	}

      
	@Override
	public TrainingCourse updateTrainingCourse(TrainingCourse course) {
		LOG.info("update courses");
		if(trainrepo.existsById(course.getCourseId())) {
			return trainrepo.save(course);
		}else {
			LOG.info("not found that id");
			throw new TrainingCourseNotFoundException("Course not found to update");
			
		}
	}

	
	@Override
	public TrainingCourse viewTrainingCourse(int courseId) {
		LOG.info("trainig course");
		Optional<TrainingCourse> tcOpt = trainrepo.findById(courseId);
		if(tcOpt.isPresent()) {
			return tcOpt.get();
		}
		else {
			LOG.info("course viewer");
			throw new TrainingCourseNotFoundException("training course not found");
		}
	}

	@Override
	public List<TrainingCourse> viewAllTrainingCourse() {
           LOG.info("view all the courses");
           List<TrainingCourse> li=trainrepo.findAll();
           if(li.size()==0) {
        	   throw new TrainingCourseNotFoundException("Courses  is empty");
           }
   		return trainrepo.findAll();
	}
	
	
    @Override
	public TrainingCourse deleteTrainingCourse(int courseId) {		
		LOG.info("delete training course");
		Optional<TrainingCourse> tcOpt = trainrepo.findById(courseId);
		if(tcOpt.isPresent()) {
			trainrepo.deleteById(courseId);
			return tcOpt.get();
		}
		else {
			LOG.info("course viewer");
			throw new TrainingCourseNotFoundException("can't delete the course which is not exists");
		}
	}
    

	@Override
	public TrainingCourse viewByTrainingCourseName(String courseName) {
		LOG.info("view by courses name");
		List<TrainingCourse> li=trainrepo.findAll();
		for(TrainingCourse t:li) {
			if(t.getCourseName().equalsIgnoreCase(courseName)) {
				return t;
			}
		}throw new TrainingCourseNotFoundException("There is no training course with "+courseName);
	}

}

