package com.users.demo;

public class Employer extends User {
	
	public String accessCode;
	
	Employer(){}
	
	Employer(String Name, String passwordId,String Email,String userType,int status){
		super(Name , passwordId , Email , userType,status);
	}
	
	// overload Constructor
	public Employer(String Name, String passwordId,String Email,String userType,int status , String accessCode){
		super(Name , passwordId , Email , userType,status);
		this.accessCode=accessCode;
	}

}
