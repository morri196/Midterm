package co.grandcircus.midterm;

import java.util.Scanner;

public class TacoCartApp {

	public static void main(String[] args) {
		
		// Make an instance of a ProductFileUtil to use for reading/writing Product files.
		ProductFileUtil fileUtil = new ProductFileUtil();
		Scanner scnr = new Scanner(System.in);
		
		Menu menu = new Menu(fileUtil.readFile());
		
		menu.displayMenu();
		
		Product chosenProduct = menu.getProductChoice(scnr);
		
		Order order = new Order();
		System.out.println(order);
		order.addProduct(chosenProduct);
		System.out.println(order);
		
		
	}

}
