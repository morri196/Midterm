package co.grandcircus.midterm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validators {

	// Dewey wrote me, yay!
	public static int getValidQuantity(Scanner scnr) {
		// Initialize variable you want to return
		int quantity = 1;
		// Set input valid to false initially
		boolean inputValid = false;

		// Print desired prompt
		System.out.println("How many would you like?");

		// Enter the do loop that goes as long as input is not valid
		do {
			try {
				// Try to parse user input for an integer ... might fail and kick to catch
				quantity = getParsedInteger(scnr.nextLine().trim());
				// Check if it's positive ... might fail and kick to catch
				isPositive(quantity);
				// If you survive all validators! You win. You are the valid input!
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				// Get the specific exception that was thrown's message and print it
				System.out.println(ex.getMessage());

			}
		} while (!inputValid);

		// Return the valid input
		return quantity;
	}
	
	// Kari wrote me, yay!
	public static double getValidCashPayment(Scanner scnr, Order order) {
		double cashPayment = 0;
		boolean inputValid = false;

		// Print desired prompt
		System.out.println("Enter cash amount: ");

		// Enter the do loop that goes as long as input is not valid
		do {
			try {
				// Try to parse user input for an integer ... might fail and kick to catch
				cashPayment = getParsedDouble(scnr.nextLine().trim());
				isGreaterThanMinAmount(cashPayment, order.getGrandTotal());
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				// Get the specific exception that was thrown's message and print it
				System.out.println(ex.getMessage());

			}
		} while (!inputValid);

		// Return the valid input
		return cashPayment;
	}
	
	// Amna wrote me, yay!
	public static int getValidMenuChoice(Scanner scnr, Menu menu) {
		// Set input valid to false initially
		int menuChoice = 0;
		
		// Set input valid to false initially
		boolean inputValid = false;

		// Print desired prompt
		System.out.println("Choose a menu item: ");

		// Enter the do loop that goes as long as input is not valid
		do {
			try {
				// Try to parse user input for an integer ... might fail and kick to catch
				menuChoice = getParsedInteger(scnr.nextLine().trim());
				// Check if it's positive and in range ... might fail and kick to catch	
				isInRange(menuChoice, menu.getMenuList().size());
				// If survives all validators! You win. You are the valid input!
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				// Get the specific exception that was thrown's message and print it
				System.out.println(ex.getMessage());

			}
		} while (!inputValid);

		// Return the valid input
		return menuChoice;
	}
	
	// TODO: Remaining getBLAHBLAH methods:
	// getValidCreditCard
	// getValidExpirationDate --> Add actual expiration validation
	// getValidCVV
	// getValidCheckNo (might overlap with CVV)

	public static int getParsedInteger(String userInput) {
		try {
			return Integer.parseInt(userInput);
		} catch (NumberFormatException ex) {
			// TODO: Overly specific error message! Make applicable to all situations
			throw new IllegalArgumentException("That's not a valid number of items to order! Please try again:");
		}
	}

	public static double getParsedDouble(String userInput) {
		try {
			return Double.parseDouble(userInput);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("That's not a valid money! Please try again:");
		}
	}

	// Validate that an integer is within range 0 - maxNum
	public static void isInRange(int userInput, int maxNum) {
		if (userInput < 1 || userInput > maxNum) {
			throw new IllegalArgumentException("You must enter a number (1-" + maxNum + ")! Please try again:");
		}
	}

	// Validate that an integer is positive
	public static void isPositive(int userInput) {
		if (userInput <= 0) {
			throw new IllegalArgumentException("You must enter a positive number. Please try again:");
		}
	}

	// Validate that a double is positive
	public static void isPositive(double userInput) {
		if (userInput <= 0) {
			throw new IllegalArgumentException("You must enter a positive number. Please try again:");
		}
	}

	// Validate that an integer has a specified amount of digits
	public static void isCorrectNumberOfDigits(int userInput, int correctNumDigits) {
		if (String.valueOf(userInput).length() != correctNumDigits) {
			throw new IllegalArgumentException("You must enter " + correctNumDigits + " digits. Please try again:");
		}
	}

	// Validate that an double is greater than a specified amount
	public static void isGreaterThanMinAmount(double userInput, double minAmount) {
		if (userInput < minAmount) {
			throw new IllegalArgumentException("You must enter at least $" + minAmount + ". Please try again:");
		}
	}

	// Validate that a String is alphanumeric and only contains single spaces
	public static void isValidNameOnCreditCard(String userInput) {
		if (!userInput.matches("^(?!.*  )[a-zA-Z ]*$")) {
			throw new IllegalArgumentException("You must enter your name as it appears on the card. Please try again:");
		}
	}

	// Validate that a String has the format ####-####-####-####
	public static void isValidCreditCardNumber(String userInput) {
		if (!userInput.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$")) {
			throw new IllegalArgumentException("custom yell at them message");
		}
	}

	// Validate that a String is a valid date with the format mm/yy
	public static void isValidCreditCardExpirationDate(String userInput) {
		DateFormat format = new SimpleDateFormat("MM/yy");
		format.setLenient(false); /* Inputs must match specified format */
		try {
			// Try to parse a date (non-leniently) from the input
			format.parse(userInput);
		} catch (ParseException pe) {
			throw new IllegalArgumentException("Date format must be MM/YY. Please try again:");
		}
		// Check for dates that could be parsed but do not follow mm/yy format
		// MIGHT BE OVERKILL?
		if (!userInput.matches("^[0-9]{2}/[0-9]{2}$")) {
			throw new IllegalArgumentException("Date format must be MM/YY. Please try again:");
		}

		// TODO: Add validation that the card has not expired!

	}

}
