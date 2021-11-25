package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	public abstract User findByUserName(String username);

	public abstract User existsByUserName(String user);
//	User registerUser(User user);

//	@Query(value = "Select p From Party p Where Lower(p.partyName) = :name")
//	public Party readPartyByName(@Param("name") String partyName);
	

    public abstract  User findByUserPassword(String string);

//	User login(String username, String password);

//	User forgotPassword(User user);

}
