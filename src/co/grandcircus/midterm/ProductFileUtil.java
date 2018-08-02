package co.grandcircus.midterm;

public class ProductFileUtil extends AbstractFileUtil<Product> {

	public ProductFileUtil() {
		super("ProductList.txt");
	}

	@Override
	protected Product convertLineToItem(String line) {
		// Get values by using .split with "~~" as the delimiter (AKA data-separator)
		String[] values = line.split("~~");

		// Create a new product and assign its fields
		Product product = new Product();
		product.setName(values[0]);
		product.setCategory(values[1]);
		product.setDescription(values[2]);
		product.setPrice(Double.parseDouble(values[3]));

		// Return the product created from the line
		return product;
	}

	@Override
	protected String convertItemToLine(Product item) {
		// Return a string formatted with all values and "~~" as the delimiter
		return String.format("%s~~%s~~%s~~%f", item.getName(), item.getCategory(), item.getDescription(),
				item.getPrice());
	}

}
