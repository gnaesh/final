package com.capgemini.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.IncorrectLoginCredentialsException;
import com.capgemini.exception.UserAlreadyExistsException;
import com.capgemini.model.User;
import com.capgemini.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
@Autowired
private IUserRepository userRepository;
	
private User tempuser;
private User temppassword;
private Boolean isLoggedIn;

	public User registerUser(User user) {	
		LOG.info("register");
		if (userRepository.findByUserName(user.getUserName())!=null)
		{	throw new UserAlreadyExistsException();
		
		}
		else
		{
		return userRepository.save(user);
		}
	}

	@Override
	public User login(String username,String password) {
		LOG.info("login");
		this.tempuser = userRepository.findByUserName(username);
		this.temppassword=userRepository.findByUserPassword(tempuser.getUserPassword());
		if (tempuser.getUserName().equalsIgnoreCase(username) && temppassword.getUserPassword().equals(password)) {
			isLoggedIn = true;
			return tempuser;
		}
		throw new IncorrectLoginCredentialsException();
	}
	

}
	
	

