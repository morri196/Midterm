package co.grandcircus.midterm;

import java.util.Scanner;

public class TacoCartApp {

	public static void main(String[] args) {
		
		// Make an instance of a ProductFileUtil to use for reading/writing Product files.
		ProductFileUtil fileUtil = new ProductFileUtil();
		Scanner scnr = new Scanner(System.in);
		
		// Initialize Menu and Empty Order
		Menu menu = new Menu(fileUtil.readFile());
		OrderTracker todaysOrders = new OrderTracker();
		
		takingOrdersLoop(scnr, menu, todaysOrders);		
		
		
	}
		
	public static Order orderingLoop(Scanner scnr, Menu menu) {
		Order order = new Order();
		String continueShopping;
		
		do {
			menu.displayMenu();
			
			// Get order
			order.addProduct(menu.getProductChoice(scnr));
			
			order.displayCurrentOrder();
			
			System.out.println("Would you like to select another item? (y/N)");
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
		
			System.out.println("Can I take a new order please? (y/N)");
			lastCall = scnr.nextLine().trim();
		
		} while (lastCall.equalsIgnoreCase("y"));
	}
	

}
