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
		
		order.addProduct(menu.getProductChoice(scnr));
		
		System.out.println(order);
		System.out.println(order.getSubTotal());
		System.out.printf("%.2f%n", order.getSalesTax());
		System.out.println(order.getGrandTotal());


		
	}

}
