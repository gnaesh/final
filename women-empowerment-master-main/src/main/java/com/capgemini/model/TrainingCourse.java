package com.capgemini.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// enum CourseName{
//	SOCIALAWARENESS,
//	EMPOWERINGTHENATION,
//	SEEKINGWOMENSRIGHT,
//	PSYCHOLOGYOFPOLITICALACTIVISM
//}

@Entity
@Table(name="training")
public class TrainingCourse {
	 @Id
	@GeneratedValue//for the generation of primary key
	private int courseId;
	// @Enumerated(EnumType.STRING)
	
	 @Column(name="course_Name" )
	 private String courseName;
	
	 @Column(name="course_Durationn" )
	 private String courseDurationn;
	
	 @Column(name="course_Status" )
	 private String courseStatus;
	
	 @Column(name="starting_Date" )
	 @Temporal(TemporalType.DATE)
	private Date startingDate;
	
	 @Column(name="ending_Date" )
	 @Temporal(TemporalType.DATE)
	private Date endingDate;
	
	public TrainingCourse() {
		super();
	}
	public TrainingCourse( String courseName, String courseDurationn, String courseStatus,Date startingDate,Date endingDate) {
		super();
	
		this.courseName = courseName;
		this.courseDurationn = courseDurationn;
		this.courseStatus = courseStatus;
		this.startingDate=startingDate;
		this.endingDate=endingDate;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDurationn() {
		return courseDurationn;
	}
	public void setCourseDurationn(String courseDurationn) {
		this.courseDurationn = courseDurationn;
	}
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	@Override
	public String toString() {
		return "TrainingCourse [courseId=" + courseId + ", courseName=" + courseName + ", CourseDurationn="
				+ courseDurationn + ", courseStatus=" + courseStatus + ", startingDate=" + startingDate
				+ ", endingDate=" + endingDate + "]";
	}
	
	

}
