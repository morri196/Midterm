package co.grandcircus.midterm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private List<Product> menuList = new ArrayList<Product>();

	public Menu(List<Product> list) {
		this.menuList = list;
	} 
	
	public Menu() {
		this.menuList = new ArrayList<Product>(Arrays.asList());
	}

	public List<Product> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<Product> menuList) {
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		return "Menu [menuList=" + menuList + "]";
	}
	
	public void displayMenu() {
		// TODO: This could probably be nicer
		
		System.out.printf("#. %-25s%-10s%s%n", "Name", "Category", "Price");
		System.out.print("===========================================\n");
		
		for (int i = 0; i < menuList.size(); i++) {
			Product product = menuList.get(i);
			// TODO: Fix the period!
			System.out.printf("%d. %-25s%-10s$%.2f%n", (i + 1), product.getName(), product.getCategory(), product.getPrice());
		}

	}
	
	public Product getProductChoice(Scanner scnr/* maybe more? */) {
		System.out.println("\nWhat would you like to order? Choose an option 1-" + menuList.size() + ".");

		// TODO: Validate user has entered an integer (within the bounds of the menu)
		int userInput = Integer.parseInt(scnr.nextLine().trim());
		
		return menuList.get(userInput - 1);
		
	}
	
	
}
