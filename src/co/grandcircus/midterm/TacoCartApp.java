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
		
		
		// Initialize a product with the user's choice
		int menuChoice = Validators.getValidMenuChoice(scnr, menu);
		System.out.println(menuChoice);
		
//		Product chosenProduct2 = menu.getProductChoice(scnr);
//				
//		// Add the chosen product to the order
//		order.addProduct(chosenProduct2);
//				
//		// Print the order (not very pretty)
//		System.out.println(order);
//		
//		System.out.println(order.getSubTotal());
//		System.out.printf("%.2f%n", order.getSalesTax());
//		System.out.println(order.getGrandTotal());


		
	}

}
