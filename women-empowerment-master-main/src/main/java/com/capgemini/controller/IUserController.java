package com.capgemini.controller;

import org.springframework.http.ResponseEntity;

import com.capgemini.model.User;

public interface IUserController {
	ResponseEntity<User> register(User user);

	ResponseEntity<User> login(String username, String password);
}
