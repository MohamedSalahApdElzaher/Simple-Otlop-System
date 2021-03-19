package otlop_DB_Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class users_db {
	

	// configure data base
	private static String url = "jdbc:mysql://localhost/otlop_system_db";
	private static String user = "root";
	private static String pass="";
	private static Connection con;
	private static Statement st;
	private static String s;
     int passwordId;
	
	

	// get Connection to data base
	public static void ConnectDb() throws SQLException {
		con = DriverManager.getConnection(url, user, pass);
		st = con.createStatement();
	}
	
	// retrieve user status
	public static String getStatus(String username) throws SQLException {
		String query1 = "SELECT status FROM users_db WHERE Name='"+username+"'";
		ResultSet res1 = st.executeQuery(query1);
		while(res1.next()) {
			s = res1.getString("status");
		}
		res1.close();
		return s;
	}
	
	// update status
	public static void updateStatus(String email) throws SQLException {
		String q = "UPDATE users_db SET status='1' WHERE Email='"+email+"'";
	    st.executeUpdate(q);
	}
	
	// retrieve user password
	public static int getPasswordId(String email) throws SQLException {
		String query1 = "SELECT Id FROM users_db WHERE Email='"+email+"'";
		ResultSet res1 = st.executeQuery(query1);
		while(res1.next()) {
			s = res1.getString("Id");
		}
		return Integer.parseInt(s);
	}
     
	// add new user method
	public static void addUser(String name, int passwordId , String email , String credit_Code , String userType ,  int status) throws SQLException {
		String query = "INSERT INTO users_db (Name,Id,Email,userType,status,code) "
				+ "VALUES ('"+name+"', '"+passwordId+"','"+email+"','"+userType+"','"+status+"','"+credit_Code+"' )";
		int res = st.executeUpdate(query);
		System.out.println(res > 0 ? "Successfull Register..!" : "Error..!!"); 
	}
	
	// logout
    public static void logOut(String username) throws SQLException {
		String q = "UPDATE users_db SET status='0' WHERE Name='"+username+"'";
		int res = st.executeUpdate(q);
		System.out.println(res > 0 ? "Successfull logout..!" : "Error..!!"); 
	}

    // account details
    public static void accDetails(String username) throws SQLException {
    	String query1 = "SELECT * FROM users_db WHERE Name='"+username+"'";
		ResultSet res1 = st.executeQuery(query1);
		while(res1.next()) {
           System.out.println("Name : " + res1.getString("Name")+"\n"+"Eamil : " +res1.getString("Email")
           +"\n"+"userType : " + res1.getString("userType")+"\n"+"Code : " + res1.getString("code")+"\n"+"PasswordId : "+res1.getString("Id"));
		}
    }
    
}
