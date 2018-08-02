package co.grandcircus.midterm;

public class TacoCartApp {

	public static void main(String[] args) {
		
		// Make an instance of a ProductFileUtil to use for reading/writing Product files.
		ProductFileUtil fileUtil = new ProductFileUtil();
		
		Menu menu = new Menu(fileUtil.readFile());
		
		menu.displayMenu();
		
	}

}
