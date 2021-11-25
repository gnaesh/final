package com.capgemini.service;

import java.util.List;

import com.capgemini.model.TrainingCourse;



public interface ITrainingCourseServices {
		
		
		TrainingCourse addTrainingCourse(TrainingCourse course);

		TrainingCourse updateTrainingCourse(TrainingCourse course);

		TrainingCourse viewTrainingCourse(int courseId);

		List<TrainingCourse> viewAllTrainingCourse();

		TrainingCourse deleteTrainingCourse(int courseId);

		TrainingCourse viewByTrainingCourseName(String courseName);

	}



