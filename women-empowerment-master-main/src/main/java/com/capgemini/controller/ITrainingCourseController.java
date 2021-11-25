package com.capgemini.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.model.TrainingCourse;


public interface ITrainingCourseController {
	ResponseEntity<TrainingCourse> addTrainingCourse(TrainingCourse course);

	ResponseEntity<TrainingCourse> updateTrainingCourse(TrainingCourse course);

	ResponseEntity<TrainingCourse> viewTrainingCourse(int courseId);

	ResponseEntity<List<TrainingCourse>> viewAllTrainingCourse();

	ResponseEntity<TrainingCourse> deleteTrainingCourse(int courseId);

	ResponseEntity<TrainingCourse> viewByTrainingCourseName(String courseName);

}
