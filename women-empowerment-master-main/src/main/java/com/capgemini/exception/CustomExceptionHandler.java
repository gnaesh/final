package com.capgemini.exception;

import javax.security.auth.login.LoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(SchemeAlreadyExistsException.class)
	public ResponseEntity<Object> handleSchemeAlreadyExistsException() {
		LOG.error("handleSchemeAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Scheme is already exists.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_REQUEST);
	}

	// -----------------------------------------------------------------------------------------------

	@ExceptionHandler(SchemeNotFoundException.class)
	public ResponseEntity<Object> handleSchemeNotFoundException() {
		LOG.error("handleSchemeNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Scheme not found.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TraineeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException() {
		LOG.error("handleEmployeeNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(DepartmentNotFoundException.class)
//	public ResponseEntity<Object> handleDepartmentNotFoundException() {
//		LOG.error("handleEmployeeNotFoundException");
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "This department is NOT available in the database.");
//		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
//	}

	@ExceptionHandler(NoSuchRecordException.class)
	public ResponseEntity<Object> handleNoSuchRecordException() {
		LOG.error("handleNoSuchRecordException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NotStrongPasswordException.class)
	public ResponseEntity<Object> handleNotStrongPasswordException() {
		LOG.error("handleNotStrongPasswordException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message",
				"Enter Strong password. It must contains atleast 1 upper case alphabet, lower case alphabet, digit,special characters");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidContactException.class)
	public ResponseEntity<Object> handleInvalidContactException() {
		LOG.error("handleInvalidContactException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Contact Number must start with 0/91");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidFirstName.class)
	public ResponseEntity<Object> handleInvalidFirstName() {
		LOG.error("handleInvalidFirstName");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Name must contain only alphabets");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<Object> handleInvalidEmailException() {
		LOG.error("handleInvalidEmailException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Enter valid emailId");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchCourseIdException.class)
	public ResponseEntity<Object> handleNoSuchCourseIdException() {
		LOG.error("handleNoSuchCourseIdException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Given courseId does not exist to remove Trainee");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchTraineeIdException.class)
	public ResponseEntity<Object> handleNoSuchTraineeIdException() {
		LOG.error("handleNoSuchTraineeIdException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Trainee with this TraineeId does not exists");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TrainingCourseNotFoundException.class)
	public ResponseEntity<Object> handleTrainingCourseNotFoundException() {
		LOG.error("handle training course not found exception");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Training course not found");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FeedBackAlreadyExistsException.class)
	public ResponseEntity<Object> handleFeedBackAlreadyExistsException() {
		LOG.error("handleFeedBackAlreadyExistsExceptio");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "feedback is already exists.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_REQUEST);
	}

	// -----------------------------------------------------------------------------------------------

	@ExceptionHandler(FeedBackNotFoundException.class)
	public ResponseEntity<Object> handleFeedBackNotFoundException() {
		LOG.error("handleFeedBackNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "feedback not found.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException() {
		LOG.error("handleUserNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This User is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	// ------------------------------------------------------------------------------------------

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> handleUserAlreadyPresentException() {
		LOG.error("handleUserAlreadyPresentException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User already present in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_REQUEST);
	}

	// ------------------------------------------------------------------------------------------

	@ExceptionHandler(NoUsersFoundException.class)
	public ResponseEntity<Object> handleNoUsersFoundException() {
		LOG.error("handleNoUsersFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "No User found in database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_REQUEST);
	}

	// ------------------------------------------------------------------------------------------

	@ExceptionHandler(IncorrectLoginCredentialsException.class)
	public ResponseEntity<Object> handleIncorrectLoginCredantialsException() {
		LOG.error("handleNoUsersFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Incorrect Login Credantials found in database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_REQUEST);
	}

	// ------------------------------------------------------------------------------------------
	/*
	 * ExceptionHandler is implemented to handle the exception of NGO is not found
	 * in Database
	 */
	@ExceptionHandler(NGONotFoundException.class)
	public ResponseEntity<Object> handleNGONotFoundException() {
		LOG.error("handleNGONotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This NGO is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	// ------------------------------------------------------------------------------------------
	/*
	 * ExceptionHandler is implemented to handle the exception of NGO is not found
	 * in Database
	 */
	@ExceptionHandler(NoSuchNgoException.class)
	public ResponseEntity<Object> handleNoSuchNgoException() {
		LOG.error("handleNoSuchNgoException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NO Such NGO available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	// ------------------------------------------------------------------------------------------
	/*
	 * ExceptionHandler is implemented to handle the exception of NGO is not found
	 * in Database BY Its Location
	 */
	@ExceptionHandler(NoNgoPresentByLocationException.class)
	public ResponseEntity<Object> handleNoNgoPresentByLocationException() {
		LOG.error("handleNotvalidLocationException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO with this location not available.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	// ------------------------------------------------------------------------------------------
	/*
	 * ExceptionHandler is implemented to handle the exception of NGO is not found
	 * in Database BY Its Motive.
	 */
	@ExceptionHandler(NoNgoPresentByMotiveException.class)
	public ResponseEntity<Object> handleNoNgoPresentByMotiveException() {
		LOG.error("handleNotvalidMotiveException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO is not present database with that Motive.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	// ------------------------------------------------------------------------------------------
	/*
	 * ExceptionHandler is implemented to handle the exception of NGO is Already
	 * Present in Database.
	 */
	@ExceptionHandler(NGOAlreadyExistException.class)
	public ResponseEntity<Object> handleNGOAlreadyExistException() {
		LOG.error("handleNGOAlreadyExistException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO Already in database with that NGOID.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InvalidNgoException.class)
	public ResponseEntity<Object> handleInvalidNgoException() {
		LOG.error("handleNoSuchNgoException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Name must contain only alphabets.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotvalidActivitesException.class)
	public ResponseEntity<Object> handleNotvalidActivitesException() {
		LOG.error("handleNotvalidActivitesException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO Activites must contain only alphabets.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(NotvalidLocationException.class)
	public ResponseEntity<Object> handleNotvalidLocationException() {
		LOG.error("handleNotvalidLocationException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO Location must contain only alphabets.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotvalidMotiveException.class)
	public ResponseEntity<Object> handleNotvalidMotiveException() {
		LOG.error("handleNotvalidMotiveException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO motive must contain only alphabets.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotvalidTypeException.class)
	public ResponseEntity<Object> handleNotvalidTypeException() {
		LOG.error("handleNotvalidTypeException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO type must contain only alphabets.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InvalidUserNameException.class)
	public ResponseEntity<Object> handleInvalidUserNameException() {
		LOG.error("handleInvalidUserNameException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "UserName is not valid");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<Object> handleLoginException() {
		LOG.error("handleLoginException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "You need to login first");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
}