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
	public Product getProductChoice(Scanner scnr) {
		// Ask user to select a product
		Product chosenProduct = menu.get(Validators.getValidMenuChoice(scnr, menu.size()) - 1);
		
		// Ask user for quantity
		int quantityChoice = Validators.getValidQuantity(scnr);
		
		// Set chosenProduct's quantity
		chosenProduct.setQuantity(quantityChoice);
		
		// return the product with the correct quantity
		return chosenProduct;
	}
	
	
}
