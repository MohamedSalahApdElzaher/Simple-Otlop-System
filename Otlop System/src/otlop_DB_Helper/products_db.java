package otlop_DB_Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.product.demo.product;

public class products_db {
	
	// configure data base
		private static String url = "jdbc:mysql://localhost/otlop_system_db";
		private static String user = "root";
		private static String pass="";
		private static Connection con;
		private static Statement st;
		
		// get Connection to data base
		public static void ConnectDb() throws SQLException {
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
		}
		
		
		// add new product 
		public static void addProduct(String productName , int productQuantity , double productPrice) throws SQLException {
			product p = new product();
			p.addproduct(productName, productQuantity, productPrice);
			int c = getLastcode();
			String query = "INSERT INTO products_db (productName,productQuantity,productPrice,productCode)"
					+ "VALUES ('"+productName+"', '"+productQuantity+"','"+productPrice+"','"+ ++c +"')";
			int res = st.executeUpdate(query);
			System.out.println(res > 0 ? "Successfull Insertion..!" : "Error..!!");
		}
		
		// get last product code
		public static int getLastcode() throws SQLException {
			String query1 = "SELECT productCode FROM products_db";
			ResultSet res1 = st.executeQuery(query1);
			int code=0;
			while(res1.next()) {
				code = Integer.parseInt(res1.getString("productCode"));
			}
			return code;	
		}
		
		// display all products
		public static void getProducts() throws SQLException {
			String query = "SELECT * FROM products_db";
			ResultSet res = st.executeQuery(query);
			System.out.println("Display All Food List..\n");
			int i=0;
			while(res.next()) {
				System.out.println("#" + ++i);
                System.out.println("productName: " + res.getString("productName")
                +"\nproductQuantity: " + res.getString("productQuantity")
                +"\nproductPrice: " + res.getString("productPrice")+" $"
                +"\nproductCode: "+res.getString("productCode")+"\n");
			}
		}
		
		// display all products
		public static void getProductDetails(String code) throws SQLException {
			String query = "SELECT * FROM products_db WHERE productCode='"+code+"'";
			ResultSet res = st.executeQuery(query);
			while(res.next()) {
                System.out.println("productName: " + res.getString("productName")
                +"\nproductQuantity: " + res.getString("productQuantity")
                +"\nproductPrice: " + res.getString("productPrice")+" $"
                +"\nproductCode: "+res.getString("productCode")+"\n");
			}
		}
		
		// make order
				public static void makeorder(String code , int quantity) throws SQLException {
					String query = "SELECT productQuantity FROM products_db WHERE productCode='"+code+"'";
					ResultSet res = st.executeQuery(query);
					int q = 0;
					while(res.next()) {
		               q =  Integer.parseInt(res.getString("productQuantity"));
					}
					q -= quantity;
					String updateQuery = "UPDATE products_db SET productQuantity='"+q+"' WHERE productCode='"+code+"'";
				    st.execute(updateQuery);
				}
		
		// display all products Name
		public static void getProductsName() throws SQLException {
			String query = "SELECT productName,productCode FROM products_db";
			ResultSet res = st.executeQuery(query);
			while(res.next()) {
				System.out.print("#"+res.getString("productCode") + " ");
                System.out.println("\""+res.getString("productName")+"\"");             
			}
		}
		
		

}
