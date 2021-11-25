package com.capgemini.service;

import com.capgemini.model.User;

public interface IUserService {
	User registerUser(User user);

//	User login(User username, String password);

	User login(String username, String password);

//	User forgotPassword(User user);


}
