package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.InvalidContactException;
import com.capgemini.exception.InvalidEmailException;
import com.capgemini.exception.InvalidFieldException;
import com.capgemini.exception.InvalidFirstName;
import com.capgemini.exception.NoSuchCourseIdException;
import com.capgemini.exception.NoSuchRecordException;
import com.capgemini.exception.NoSuchTraineeIdException;
import com.capgemini.exception.NotStrongPasswordException;
import com.capgemini.model.Trainee;
import com.capgemini.repository.TraineeRepository;




@Service
public class TraineeServiceImpl implements ITraineeService {
	private static final Logger LOG = LoggerFactory.getLogger(TraineeServiceImpl.class);

	@Autowired
	private TraineeRepository traineeRepository;


	@Override
	public Trainee addTrainee(Trainee course) {
		if (course.getTraineeId() != null && course.getFirstName() != null && course.getLastName() != null
				&& course.getPassword() != null && course.getAadharNo() != 0 && course.getEmail() != null
				&& course.getContact() != null && course.getDob() != null && course.getUserName() != null
				&& course.getLocation() != null) {
			String name = course.getFirstName();
			String validateName = "^[A-Za-z ]+";
			String email = course.getEmail();
			String validateEmail = "^[a-zA-z+_]+@[a-zA-z+.]+$";
			String contact = course.getContact();
			String validateContact = "(0/91)?[7-9][0-9]{9}";
			String password = course.getPassword();
			String validatePasword = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
					+ "(?=\\S+$).{8,20}$";
			if (name.matches(validateName)) {
				if (email.matches(validateEmail)) {
					if (contact.matches(validateContact)) {
						if(password.matches(validatePasword)) {
						course = traineeRepository.save(course);
						LOG.info("trainee is added successfully");
						return course;
						} else {
							LOG.error("Password is not Strong ");
							throw new NotStrongPasswordException("Password is not Strong " + password);
						}
					} else {
						LOG.error("Invalid contact");
						throw new InvalidContactException("Invalid contact " + contact);
					}

				} else {
					LOG.error("Email is not valid " + email);
					throw new InvalidEmailException("Invalid EmailId: " + email);
				}
			}
			LOG.error("Unable to add trainee");
			throw new InvalidFirstName("Invalid First Name " + name);
		}
		LOG.error("Field is Empty");
		throw new InvalidFieldException("Field is Empty");
	}

	// ------------------------------------------------------------------------------------------

	@Override
	@Transactional
	public Trainee updateTrainee(Trainee course) {
		LOG.info("updateTrainee");
		if (traineeRepository.existsById(course.getTraineeId()))
		{		return traineeRepository.save(course);
		}
		else
		{	LOG.error("Trainee with this TraineeId does not exists");
		    throw new NoSuchTraineeIdException("Trainee with this TraineeId does not exists");
		}
	
	}

	// ------------------------------------------------------------------------------------------

	@Override
	public Trainee viewTrainee(int courseId) {
		if (traineeRepository.existsById(courseId)) {
			LOG.info("viewByCourseId");
			return traineeRepository.findById(courseId).get();
		}
		LOG.error("Trainee with this couseId does");
		throw new NoSuchRecordException("Trainee with this couseId does");
	}	
	

	// ------------------------------------------------------------------------------------------

	@Override
	public List<Trainee> viewAllTrainee() {
		LOG.info("viewAllTrainee");
		List<Trainee> list = traineeRepository.findAll();
		if (!list.isEmpty()) {
			LOG.info("viewalltrainee");
			return list;
		}
		LOG.error("No Trainee Present");
		throw new NoSuchRecordException("No Trainee Present");
	}

	// ------------------------------------------------------------------------------------------

	@Override
	public Trainee deleteTrainee(int courseId) {
		LOG.info("deleteTraineeByCourseId");
		Optional<Trainee> deleteTraineeByCourseId = traineeRepository.findById(courseId);
		if (deleteTraineeByCourseId.isPresent()) {
			traineeRepository.deleteById(courseId);
			return deleteTraineeByCourseId.get();
		}
		else
		{
		LOG.error("Given courseId does not exist to remove Trainee");
		throw new NoSuchCourseIdException("Given courseId: "+ courseId +" does not exist to remove Trainee");
		}

	}
	
	// ------------------------------------------------------------------------------------------

	@Override
	public List<Trainee> viewAllTraineesByLocation(String location) {
		LOG.info("viewAllTraineesByLocation");
		List<Trainee> list = traineeRepository.getAllTraineeByLocation(location);
		if (!list.isEmpty()) {
			LOG.info("viewAllTraineesByLocation");
			return list;
		} else {
			LOG.error("No Trainee in this location");
			throw new NoSuchRecordException("No Trainee in this location");
		}
	}

	// ------------------------------------------------------------------------------------------

	@Override
	public Trainee viewTraineeByAadhar(long aadharNo) {
		LOG.info("viewTraineeByAadhar");
		Trainee trainee = traineeRepository.findByAadharNo(aadharNo);
		if (trainee != null) {
			LOG.info("viewTraineeByAadhar");
			return trainee;
		} else {
			LOG.error("Aadhar Number Does Not Exists");
			throw new NoSuchRecordException("Aadhar Number Does Not Exists");
		}
	}

}
