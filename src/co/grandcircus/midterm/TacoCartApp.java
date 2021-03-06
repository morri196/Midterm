package co.grandcircus.midterm;

import java.util.Scanner;

public class TacoCartApp {

	public static void main(String[] args) {
		
		// Make an instance of a ProductFileUtil to use for reading/writing Product files.
		ProductFileUtil fileUtil = new ProductFileUtil();
		
		// Make a scanner
		Scanner scnr = new Scanner(System.in);
		
		// Initialize/read the menu and make an empty OrderTracker
		Menu menu = new Menu(fileUtil.readFile());
		OrderTracker todaysOrders = new OrderTracker();
		
		takingOrdersLoop(scnr, menu, todaysOrders);	
		
		// Summarize the day's orders
		todaysOrders.orderSummary();
		
		System.out.println("Goodbye!");
		
		scnr.close();
		
	}
		
	public static Order orderingLoop(Scanner scnr, Menu menu) {
		Order order = new Order();
		String continueShopping;
		
		do {
			menu.displayMenu();
			
			// Get order
			order.addProduct(menu.getProductChoice(scnr));
			
			order.displayCurrentOrder();
			
			System.out.println("\nWould you like to select another item? (y/N)");
			continueShopping = scnr.nextLine().trim();

		} while (continueShopping.equalsIgnoreCase("y"));
		
		return order;
	}
	
	public static void takingOrdersLoop(Scanner scnr, Menu menu, OrderTracker todaysOrders) {
		String lastCall = "";
		do {
			Order newOrder = orderingLoop(scnr, menu);

			todaysOrders.addOrder(newOrder);

			newOrder.displayFinalOrder();

			newOrder.payForOrder(scnr);
		
			System.out.println("\nCan I take a new order please? (y/N)");
			lastCall = scnr.nextLine().trim();
		
		} while (lastCall.equalsIgnoreCase("y"));
	}
	

}
