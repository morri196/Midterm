package co.grandcircus.midterm;

import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingCart {

	private static final double SALES_TAX = 0.06; 
	
	private ArrayList<Product> cartList = new ArrayList<Product>();
	
	double subTotal;
	double salesTax;
	double grandTotal;
	
	public ShoppingCart(ArrayList<Product> cartList) {
		this.cartList = cartList;
		
		// Fancy things will happen here later!
		
	}
	
	public ShoppingCart() {
		this.cartList = new ArrayList<Product>(Arrays.asList());
	}

	public ArrayList<Product> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<Product> cartList) {
		this.cartList = cartList;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartList=" + cartList + ", subTotal=" + subTotal + ", salesTax=" + salesTax
				+ ", grandTotal=" + grandTotal + "]";
	}
	

}
