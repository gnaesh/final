package com.capgemini.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	public abstract User findByUserName(String userName);

}