package com.users.demo;

public class Customer extends User {
	
	// Fields private to only customer
	private String creditCode;
	

	public Customer(){
		super.setUserType("Customer");
	}
	
	Customer(String Name, String passwordId,String Email,String userType,int status){
		super(Name , passwordId , Email , userType ,status);
	}
	
	// overload Constructor
	public Customer(String Name, String passwordId,String Email,String userType,int status , String creditCode){
		super(Name , passwordId , Email , userType,status);
		this.creditCode=creditCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	
	
	
}
