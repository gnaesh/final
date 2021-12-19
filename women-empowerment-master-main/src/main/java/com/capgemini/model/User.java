package com.capgemini.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@Column(name = "login_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;

	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "password")
	@NotEmpty
	@NotNull
	private String userPassword;

	@Column(name = "role")
	private String role;

	public User() {
		super();

	}

	public User(int loginId, String userName, @NotEmpty @NotNull String userPassword, String role) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", userName=" + userName + ", userPassword=" + userPassword + ", role="
				+ role + "]";
	}

}
