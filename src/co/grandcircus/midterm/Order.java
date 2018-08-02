package co.grandcircus.midterm;

import java.util.ArrayList;
import java.util.Arrays;

public class Order {

	private static final double SALES_TAX = 0.06; 
	
	private ArrayList<Product> orderList = new ArrayList<Product>();
	
	public Order(ArrayList<Product> orderList) {
		this.orderList = orderList;
			}
	
	public Order() {
		this.orderList = new ArrayList<Product>(Arrays.asList());
	}

	public ArrayList<Product> getCartList() {
		return orderList;
	}

	public void setCartList(ArrayList<Product> cartList) {
		this.orderList = cartList;
	}
	
	// write a method that adds a product to the order:
	public void addProduct(Product product) {
		orderList.add(product);
	}

	@Override
	public String toString() {
		return "Order [orderList=" + orderList + "]";
	}

}
