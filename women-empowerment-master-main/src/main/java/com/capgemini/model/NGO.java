package com.capgemini.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Table name of NGO Module in Database
 */
@Entity
@Table(name = "ngo_table")
public class NGO {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ngoId;

	@Column
	private String ngoName;

	@Column
	private String ngoLocation;

	@Column
	private String ngoType;

	@Column
	private String ngoMotive;

	@Column
	private double donation;

	@Column
	private int ngoSize;

	@Column
	private String ngoActivities;

	/*
	 * Build the One To One Relationship with Training Course Class in model
	 * package.
	 */
//	Foreign key
	@ManyToOne
	@JoinColumn(name = "training_course")
	private TrainingCourse trainingCourse;

	/*
	 * No argument Constructor of NGO class
	 */
	public NGO() {
		super();
	}

	/*
	 * Parameterized Constructor of NGO class
	 */
	public NGO(Integer ngoId, String ngoName, String ngoLocation, String ngoType, String ngoMotive, double donation,
			int ngoSize, String ngoActivities, TrainingCourse trainingCourse) {
		super();
		this.ngoId = ngoId;
		this.ngoName = ngoName;
		this.ngoLocation = ngoLocation;
		this.ngoType = ngoType;
		this.ngoMotive = ngoMotive;
		this.donation = donation;
		this.ngoSize = ngoSize;
		this.ngoActivities = ngoActivities;
		this.trainingCourse = trainingCourse;
	}

	/*
	 * Getters and setters of NGO Class
	 */
	public Integer getNgoId() {
		return ngoId;
	}

	public void setNgoId(Integer ngoId) {
		this.ngoId = ngoId;
	}

	public String getNgoName() {
		return ngoName;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	public String getNgoLocation() {
		return ngoLocation;
	}

	public void setNgoLocation(String ngoLocation) {
		this.ngoLocation = ngoLocation;
	}

	public String getNgoType() {
		return ngoType;
	}

	public void setNgoType(String ngoType) {
		this.ngoType = ngoType;
	}

	public String getNgoMotive() {
		return ngoMotive;
	}

	public void setNgoMotive(String ngoMotive) {
		this.ngoMotive = ngoMotive;
	}

	public double getDonation() {
		return donation;
	}

	public void setDonation(double donation) {
		this.donation = donation;
	}

	public int getNgoSize() {
		return ngoSize;
	}

	public void setNgoSize(int ngoSize) {
		this.ngoSize = ngoSize;
	}

	public String getNgoActivities() {
		return ngoActivities;
	}

	public void setNgoActivities(String ngoActivities) {
		this.ngoActivities = ngoActivities;
	}

	public TrainingCourse getTrainingCourse() {
		return trainingCourse;
	}

	public void setTrainingCourse(TrainingCourse trainingCourse) {
		this.trainingCourse = trainingCourse;
	}

	/*
	 * ToString Method of NGO class.
	 */
	@Override
	public String toString() {
		return "NGO [ngoId=" + ngoId + ", ngoName=" + ngoName + ", ngoLocation=" + ngoLocation + ", ngoType=" + ngoType
				+ ", ngoMotive=" + ngoMotive + ", donation=" + donation + ", ngoSize=" + ngoSize + ", ngoActivities="
				+ ngoActivities + ", trainingCourse=" + trainingCourse + "]";
	}

}
