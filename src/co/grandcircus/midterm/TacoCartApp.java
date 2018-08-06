package co.grandcircus.midterm;

import java.util.Scanner;

public class TacoCartApp {

	public static void main(String[] args) {
		
		// Make an instance of a ProductFileUtil to use for reading/writing Product files.
		ProductFileUtil fileUtil = new ProductFileUtil();
		Scanner scnr = new Scanner(System.in);
		
		// Initialize Menu and Empty Order
		Menu menu = new Menu(fileUtil.readFile());

		//loop begins. display menu, get the order, display the card, ask if user would like to continue ordering.
		//if no, exit loop
		// Display menu to user
		String continueShopping = "";
		Order order = new Order();

		do {
			menu.displayMenu();
			
			// Get order
			order.addProduct(menu.getProductChoice(scnr));
			
			// Display cart?
			// TODO: Amna is working on this right now.
			
			System.out.println("Would you like to select another item? (y/N)");
			continueShopping = scnr.nextLine().trim();

		} while (continueShopping.equalsIgnoreCase("y"));
		
		System.out.println(order);

		order.displayCurrentOrder();

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
