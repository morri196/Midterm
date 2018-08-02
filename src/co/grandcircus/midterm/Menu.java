package co.grandcircus.midterm;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
	private ArrayList<Product> menuList = new ArrayList<Product>();

	public Menu(ArrayList<Product> menuList) {
		this.menuList = menuList;
	} 
	
	public Menu() {
		this.menuList = new ArrayList<Product>(Arrays.asList());
	}

	public ArrayList<Product> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<Product> menuList) {
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		return "Menu [menuList=" + menuList + "]";
	}
	
	
}
