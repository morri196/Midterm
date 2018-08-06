package co.grandcircus.midterm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Order {

	private static final double SALES_TAX = 0.06;

	private ArrayList<Product> order = new ArrayList<Product>();

	public Order(ArrayList<Product> order) {
		this.order = order;
	}

	public Order() {
		this.order = new ArrayList<Product>(Arrays.asList());
	}

	public ArrayList<Product> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Product> order) {
		this.order = order;
	}

	// write a method that adds a product to the order:
	public void addProduct(Product product) {
		order.add(product);
	}

	@Override
	public String toString() {
		return "Order [orderList=" + order + "]";
	}

	public double getSubTotal() {
		double total = 0;

		for (Product product : order) {
			total += product.getPrice() * product.getQuantity();
		}

		return total;
	}

	public double getSalesTax() {
		return getSubTotal() * SALES_TAX;
	}

	public double getGrandTotal() {
		return getSubTotal() + getSalesTax();
	}
	
	public void displayOrder() {
		// TODO: print alllllll the things nicely!
	}

	public void payForOrder(Scanner scnr) {
		List<String> paymentOptions = new ArrayList<String>();
		paymentOptions.add("Cash");
		paymentOptions.add("Credit");
		paymentOptions.add("Check");

		System.out.println("Please select your payment type. (1-" + paymentOptions.size() + "):");

		for (int i = 1; i <= paymentOptions.size(); i++) {
			System.out.println(i + ". " + paymentOptions.get(i - 1));
		}

		int userChoice = Validators.getValidMenuChoice(scnr, paymentOptions.size());
		String paymentChoice = paymentOptions.get(userChoice - 1);

		switch (paymentChoice) {
		case "Cash":
			payWithCash(scnr);
			break;
		case "Credit":
			payWithCredit(scnr);
			break;
		case "Check":
			payWithCheck(scnr);
			break;
		default:
			break;
		}

	}

	public void payWithCredit(Scanner scnr) {
		String name = Validators.getValidNameOnCard(scnr);
		String cardNum = Validators.getValidCreditCardNumber(scnr);
		String exDate = Validators.getValidCreditCardExpiration(scnr);
		String cardVerifcationValue = Validators.getValidCreditCardCVV(scnr);

		// TODO: Enhance the receipt
		// TODO: Display final shopping cart (need to write this)
		System.out.println("Payment of " + getGrandTotal() + " confirmed. Thank you. ");

	}

	public void payWithCash(Scanner scnr) {
		double payment = Validators.getValidCashPayment(scnr, getGrandTotal());

		double change = payment - getGrandTotal();
		
		// TODO: Enhance the receipt
		System.out.printf("Your change is %.2f.%n", change);
	}

	public void payWithCheck(Scanner scnr) {
		String checkNum = Validators.getValidCheckNumber(scnr);
		
		// TODO: Enhance the receipt
		System.out.println("Check No. " + checkNum + " for " + getGrandTotal() + " confirmed.");
	}

}
