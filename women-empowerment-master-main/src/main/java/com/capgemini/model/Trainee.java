package com.capgemini.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Table(name="Trainee_Details")
@Entity
public class Trainee
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Trainee_id")
	private Integer traineeId;
	
	@Column(name="UserName" , nullable=false)
	@NotEmpty
	@Size(min=3, message="user name should have atleast 3 charachters")
	private String userName;
	
	@Column(name="Password" , nullable=false)
	@NotEmpty
	@Size(min=8, message="user name should have atleast 8 charachters")
	private String password;
	
	@Column(name="FirstName" , nullable=false)
	@NotEmpty
	@Size(min=3, message="user name should have atleast 3 charachters")
	private String firstName;
	
	@Column(name="LastName" , nullable=false)
	@NotEmpty
	@Size(min=3, message="user name should have atleast 3 charachters")
	private String lastName;
	
	@Column(name="contact" , nullable=false)
	@NotEmpty
	@Size(min=10, message="user name should have atleast 10 charachters")
	private String contact;
	
	@Column(name="Email" , nullable=false)
	@NotEmpty
	@Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
	private String email;
	
	@Column(name="FamilyInfo" )
	private String familyInfo;
	
	@Column(name="AadharNo" , nullable=false , unique=true)
	@NotEmpty
	@Size(min=12, message="user name should have atleast 12 charachters")
	private long aadharNo;
	
	@Column(name="Date_of_Birth" , nullable=false)
	private LocalDate dob;
	
	@Column(name="Location")
	private String location;
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Training_course")
  	private TrainingCourse trainingCourse;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Feedback")
	private FeedBack feedBack;
	
	
	public Trainee() 
	{
	}
	public Trainee(Integer traineeId,
			@NotEmpty @Size(min = 3, message = "user name should have atleast 3 charachters") String userName,
			@NotEmpty @Size(min = 8, message = "user name should have atleast 8 charachters") String password,
			@NotEmpty @Size(min = 3, message = "user name should have atleast 3 charachters") String firstName,
			@NotEmpty @Size(min = 3, message = "user name should have atleast 3 charachters") String lastName,
			@NotEmpty @Size(min = 10, message = "user name should have atleast 10 charachters") String contact,
			@NotEmpty @Email String email, String familyInfo,
			@NotEmpty @Size(min = 12, message = "user name should have atleast 12 charachters") long aadharNo,
			LocalDate dob, String location,TrainingCourse trainingCourse,FeedBack feedBack) {
		super();
		this.traineeId = traineeId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.familyInfo = familyInfo;
		this.aadharNo = aadharNo;
		this.dob = dob;
		this.location = location;
		this.trainingCourse=trainingCourse;
		this.feedBack=feedBack;
	}

	public Integer getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFamilyInfo() {
		return familyInfo;
	}
	public void setFamilyInfo(String familyInfo) {
		this.familyInfo = familyInfo;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public FeedBack getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(FeedBack feedBack) {
		this.feedBack = feedBack;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public TrainingCourse getTrainingCourse() {
		return trainingCourse;
	}
	public void setTrainingCourse(TrainingCourse trainingCourse) {
		this.trainingCourse = trainingCourse;
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", contact=" + contact + ", email=" + email + ", familyInfo="
				+ familyInfo + ", aadharNo=" + aadharNo + ", dob=" + dob + ", location=" + location
				+ ", trainingCourse=" + trainingCourse + ", feedBack=" + feedBack + "]";
	}
	
	
	
	
	

}
