package com.sh.project.vo;

import java.util.UUID;

public class User {
	//
	private String userName;
	private String userId;
	private String userPassword;
	private String userKey;

	public User(String userId, String userPassword, String userName) {
		//
		this.userKey = UUID.randomUUID().toString();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
	}
	
	public String getUserKey() {
		return userKey;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
