package co.grandcircus.midterm;

import java.util.Scanner;

public class TacoCartApp {

	public static void main(String[] args) {
		
		// Make an instance of a ProductFileUtil to use for reading/writing Product files.
		ProductFileUtil fileUtil = new ProductFileUtil();
		Scanner scnr = new Scanner(System.in);
		
		// Initialize Menu and Empty Order
		Menu menu = new Menu(fileUtil.readFile());
		Order order = new Order();
		
		// Display menu to user
		menu.displayMenu();
		
		// Get order
		order.addProduct(menu.getProductChoice(scnr));
		
		// Display cart?
		// TODO: Amna is working on this right now.
		
		// Ask if user wants to order another product
		
		System.out.println(order);
		System.out.println(order.getSubTotal());
		System.out.printf("%.2f%n", order.getSalesTax());
		System.out.println(order.getGrandTotal());
		
		order.payForOrder(scnr);

	}
	
	public static void orderingLoop(/* some stuff */) {
		// TODO: make it so.
		
	}
	
	public static void pointOfSaleLoop(/* some stuff */) {
		// TODO: make it so.
	}

}
