package com.bean;

import org.springframework.stereotype.Component;

@Component
public class Login {
	private String emailId;
	private String password;
	private String userType;
	
	public Login(){
		super();
	}
	
	public Login(String emailId, String password, String userType)
	{
		super();
		this.emailId = emailId;
		this.password = password;
		this.userType = userType;
	}
	
	public String getEmailId()
	{
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String toString()
	{
		return "Login[emailId="+ emailId + ", password = " + password + " , userType = " + userType + "]";
	}

}
