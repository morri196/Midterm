package co.grandcircus.midterm;

import java.util.ArrayList;
import java.util.Arrays;

public class Order {

	private static final double SALES_TAX = 0.06; 
	
	private ArrayList<Product> order = new ArrayList<Product>();
	
	public Order(ArrayList<Product> order) {
		this.order = order;
			}
	
	public Order() {
		this.order = new ArrayList<Product>(Arrays.asList());
	}

	public ArrayList<Product> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Product> order) {
		this.order = order;
	}
	
	// write a method that adds a product to the order:
	public void addProduct(Product product) {
		order.add(product);
	}

	@Override
	public String toString() {
		return "Order [orderList=" + order + "]";
	}
	
	public double getSubTotal() {
		double total = 0;
		
		for (Product product : order) {
			total += product.getPrice();
		}
		
		return total;
	}
	
	public double getSalesTax() {
		return getSubTotal() * SALES_TAX;
	}
	
	public double getGrandTotal() {
		return getSubTotal() + getSalesTax();
	}

}
