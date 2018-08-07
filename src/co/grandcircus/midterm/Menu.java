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
		System.out.printf("#. %-25s%-10s%s%n", "Name", "Category", "Price");
		System.out.print("===========================================\n");

		for (int i = 0; i < menu.size(); i++) {
			Product product = menu.get(i);
			String enumeratedItem = String.format("%d. %s", (i + 1), product.getName());
			System.out.printf("%-28s%-10s$%.2f%n", enumeratedItem, product.getCategory(), product.getPrice());
		}

	}

	public Product getProductChoice(Scanner scnr) {
		System.out.println("\nPlease select an item from the menu (1-" + menu.size() + "):");

		// Ask user to select a product
		Product modelProduct = menu.get(Validators.getValidMenuChoice(scnr, menu.size()) - 1);

		// Make a new product based off the model in the menu
		// (This is to prevent altering the quantity field of the products in the menu)
		// (altering the fields of the products in the menu causes bugs when reordering the same product)
		// TODO: Fix me! maybe there is a better way of dealing with this?
		Product chosenProduct = new Product();
		chosenProduct.setName(modelProduct.getName());
		chosenProduct.setDescription(modelProduct.getDescription());
		chosenProduct.setCategory(modelProduct.getCategory());
		chosenProduct.setPrice(modelProduct.getPrice());
		;
		// Print name/description
		System.out.println("The " + chosenProduct.getName() + ":");
		System.out.println(chosenProduct.getDescription() + "\n");

		// Ask user for quantity
		int quantityChoice = Validators.getValidQuantity(scnr);

		// Set chosenProduct's quantity
		chosenProduct.setQuantity(quantityChoice);

		// return the product with the correct quantity
		return chosenProduct;
	}

}
