package com.app.test;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.product.demo.product;
import com.users.demo.Customer;
import com.users.demo.User;

import otlop_DB_Helper.products_db;
import otlop_DB_Helper.users_db;

public class app {
	// scanner instance to take input
    private static Scanner in = new Scanner(System.in);
    
    private static String name;
	private static String email;
	private static int passwordId;
	private static String credit_Code;
	private static int status;
	
	// suppose this is a current user device which he connect with the system last time
	private static final String USENAME = "adel";
	
	// welcome header method
	private static void Welcome() throws SQLException {
		 users_db.ConnectDb(); // connect to database
		 // Welcome header
			System.out.println("Welcom To Otlop Ordering System in Eqypt :)");
			System.out.println(new Date());
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - ");
			 showBar();
			 
			 checkStatus(USENAME);
			
	}
	// top bar
	public static void showBar() {
		System.out.println("\n1- Account\t2- Search\t3- Logout\t4- make Order\t5- view Meal\t6- Login");
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
	   System.out.println();
	}
	
	// input loop main
	private static void loop() throws SQLException {		 
		  while(true) {
			  int res = in.nextInt();
			  switch(res) {
			
					  case 1 : 
							String x = users_db.getStatus(USENAME);
							if(!x.equals(""+0))
						       users_db.accDetails(USENAME);
							else  System.err.append("Invalid Option!");
		                    break;
					
					  case 2:
						 searchOrder();
						  break;
						  
					  case 3:
						  users_db.logOut(USENAME);
						  break;
					
					  case 6:
						  goToLogin();
						  break;
						  
					  case 5:
						  viewMealDetalis();
						  break;
						  
					  case 4:
						  makeOrder();
						  break;
				  			  
			  }
			 
			  
			   
		  }
	}
	private static void searchOrder() throws SQLException {
		System.out.println("Enter Meal Code that show besides meal name..?");
		String c = in.next();
		products_db.getProductDetails(c);
	}
	// make an order
	private static void makeOrder() throws SQLException {
		System.out.println("Enter Meal Code that show besides meal name..?");
		String c = in.next();
		System.out.println("Enter Quantity..?");
		int q = in.nextInt();
		products_db.makeorder(c, q);
		System.out.println("Done :)");
	}
	
    private static void viewMealDetalis() throws SQLException {
		System.out.println("Enter Meal Code that show besides meal name..?");
		String c = in.next();
		products_db.getProductDetails(c);
	}
	// main method
	public static void main(String[] args) throws SQLException {
		
		Welcome();
		showMeal();
	    loop();
			
	}
	
	
	
	
	// show meals
	static void showMeal() throws SQLException {
		products_db.ConnectDb();
		products_db.getProductsName();
	}
	
	  // check user status
	private static void checkStatus(String username) throws SQLException {
				String s = users_db.getStatus(username);
				if(!s.equals(String.valueOf(1)))
				{
					System.out.println("Register / Login ? R/L");
					char c = in.next().charAt(0);
					if(c == 'R') goToRegister(new Customer());
					else goToLogin();
				}
				
	}
      // login
	private static void goToLogin() throws SQLException {
		System.out.println("Enter Email , password ?");
		String email = in.next();
		int passwordId = in.nextInt();
         int p1 = users_db.getPasswordId(email);
         while(p1 != passwordId) {
     		System.out.println("invalid password..! Enter again..");
     		passwordId = in.nextInt();
         }
         
 		System.out.println("Successfull Login..!"); 
 		users_db.updateStatus(email);
        // continue     
	}
        // Register
	private static void goToRegister(User u) throws SQLException {
		System.out.println("Regitser Info..");
		System.out.print("Name : ");
		name = in.next();
		System.out.print("Email : ");
		email = in.next();
		System.out.print("PasswordId : ");
		passwordId = in.nextInt();
		System.out.print("Credit Code : ");
		credit_Code = in.next();
		u.setStatus(1);
		status = u.isStatus();
		// start connection
		users_db.ConnectDb();
		users_db.addUser(name, passwordId, email, credit_Code, u.getUserType(), status);
	}

	
}
