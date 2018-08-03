package co.grandcircus.midterm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private List<Product> menu = new ArrayList<Product>();

	public Menu(List<Product> list) {
		this.menu = list;
	} 
	
	public Menu() {
		this.menu = new ArrayList<Product>(Arrays.asList());
	}

	public List<Product> getMenuList() {
		return menu;
	}

	public void setMenuList(ArrayList<Product> menuList) {
		this.menu = menuList;
	}

	@Override
	public String toString() {
		return "Menu [menuList=" + menu + "]";
	}
	
	public void displayMenu() {
		// TODO: This could probably be nicer
		
		System.out.printf("#. %-25s%-10s%s%n", "Name", "Category", "Price");
		System.out.print("===========================================\n");
		
		for (int i = 0; i < menu.size(); i++) {
			Product product = menu.get(i);
			// TODO: Fix the period!
			System.out.printf("%d. %-25s%-10s$%.2f%n", (i + 1), product.getName(), product.getCategory(), product.getPrice());
		}

	}
	
	// TODO: Refactor this to be compatible with our new validators!
	public Product getProductChoice(Scanner scnr/* maybe more? */) {
		System.out.println("\nWhat would you like to order? Choose an option 1-" + menu.size() + ".");

		// TODO: Validate user has entered an integer (within the bounds of the menu)
		int menuChoice = Integer.parseInt(scnr.nextLine().trim());
		
		Product chosenProduct = menu.get(menuChoice - 1);
		
		// Ask user for quantity
		System.out.println("How many " + chosenProduct.getName() + " would you like? ");
		
		// TODO: Validate positive whole number (do we want a limit?)
		int quantityChoice = Integer.parseInt(scnr.nextLine().trim());
		
		// Set chosenProduct's quantity
		chosenProduct.setQuantity(quantityChoice);
		
		// return the product with the correct quantity
		return chosenProduct;
	}
	
	
}
