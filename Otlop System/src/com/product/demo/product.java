package com.product.demo;

import java.util.ArrayList;
import java.util.List;

public class product {
	
	public String productName;
	public int productQuantity;
	public double productPrice;
	public int productCode;
	
	List<product> list = new ArrayList<product>();	

	
	public product(){}
	
	public product(String productName , int productQuantity , double productPrice , int productCode) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity=productQuantity;
		this.productCode=productCode;
	}
	
	public void addproduct(String productName , int productQuantity , double productPrice) {
		new product(productName,productQuantity,productPrice,productCode);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCode() {
		return productCode;
	}
	
	// display all products
	
	public void displayProducts() {
	
			for (product p : list) {
				System.out.print(p.getProductName() + " ");
				System.out.print(p.getProductQuantity() + " ");
				System.out.print(p.getProductPrice()+" $ ");
				System.out.print(p.getProductCode() + " \n");
			}
		
	}

	

}
