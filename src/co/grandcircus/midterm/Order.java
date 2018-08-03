package co.grandcircus.midterm;
import java.util.Scanner; 
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
			total += product.getPrice() * product.getQuantity();
		}
		
		return total;
	}
	
	public double getSalesTax() {
		return getSubTotal() * SALES_TAX;
	}
	
	public double getGrandTotal() {
		return getSubTotal() + getSalesTax();
	}
	
	public void payForOrder() {
		// TODO: Let User Select Payment Method
		
	}
	
	public void payWithCredit() {
		// TODO: Make this a thing
		// TODO: Kari
	}
	
	public void payWithCash(Scanner scnr) {
		// TODO: VALIDATION
		double payment = scnr.nextDouble(); 
		
		double change = payment - getGrandTotal();  
		
		System.out.printf("Your change is %.2f.%n", change);
	}
	
	public void payWithCheck() {
		// TODO: WHY??? WHY ARE YOU DOING THIS?
		// TODO: Dewey
	}
	
	

}
