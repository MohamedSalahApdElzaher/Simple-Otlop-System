package com.users.demo;

public abstract class User {
	
	// Fields
	private String Name;
	private String passwordId;
	private String Email;
	public   String userType;
	
	// check for users online
	private int status;
	
	// default cons
	User(){}
	
	// constructor to match models data
	User (String Name, String passwordId,String Email,String userType,int status){
		this.Name=Name;
		this.passwordId=passwordId;
		this.Email=Email;
		this.userType=userType;
		this.status=status;
	}
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getpasswordId() {
		return passwordId;
	}

	public void setpasswordId(String id) {
		passwordId = id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int isStatus() {
		return status;
	}

	public void setStatus(int i) {
		this.status = i;
	}
	
	
	

}
