package co.grandcircus.midterm;

import java.time.DateTimeException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validators {
	// TODO: Maybe add specific error messages for getValidBLANK methods

	public static String getValidCheckNumber(Scanner scnr) {
		String checkNum = "";
		boolean inputValid = false;

		System.out.println("Enter your 4 digit check number: ");

		do {
			try {
				checkNum = scnr.nextLine().trim();
				isCorrectNumberOfDigits(checkNum, 4);
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
			}
		} while (!inputValid);

		return checkNum;
	}

	public static String getValidCreditCardCVV(Scanner scnr) {
		String cardVerificationValue = "";
		boolean inputValid = false;

		System.out.println("Enter your card's 3-digit CVV: ");

		do {
			try {
				cardVerificationValue = scnr.nextLine().trim();
				isCorrectNumberOfDigits(cardVerificationValue, 3);
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
			}
		} while (!inputValid);

		return cardVerificationValue;

	}

	public static String getValidCreditCardExpiration(Scanner scnr) {
		String exDate = "";
		boolean inputValid = false;

		System.out.println("Enter your card's expiration date (mm/yy): ");

		do {
			try {
				exDate = scnr.nextLine().trim();
				isValidCreditCardExpirationDate(exDate);
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());

			}
		} while (!inputValid);

		return exDate;
	}

	public static String getValidCreditCardNumber(Scanner scnr) {
		String cardNum = "";
		boolean inputValid = false;

		System.out.println("Enter your credit card number (####-####-####-####):");

		do {
			try {
				cardNum = scnr.nextLine().trim();
				isValidCreditCardNumber(cardNum);
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());

			}
		} while (!inputValid);
		return cardNum;
	}

	public static String getValidNameOnCard(Scanner scnr) {
		String name = "";
		boolean inputValid = false;

		System.out.println("Please enter your name as it appears on your card. ");

		do {
			try {
				name = scnr.nextLine().trim();
				isValidNameOnCreditCard(name);
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
			}
		} while (!inputValid);

		return name;
	}

	public static int getValidQuantity(Scanner scnr) {
		int quantity = 1;
		boolean inputValid = false;

		System.out.println("How many would you like?");

		do {
			try {
				quantity = getParsedInteger(scnr.nextLine().trim());
				isPositive(quantity);
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());

			}
		} while (!inputValid);

		return quantity;
	}

	public static double getValidCashPayment(Scanner scnr, Double grandTotal) {
		double cashPayment = 0;
		boolean inputValid = false;

		System.out.println("Enter cash amount: ");

		do {
			try {
				cashPayment = getParsedDouble(scnr.nextLine().trim());
				isGreaterThanMinAmount(cashPayment, grandTotal);
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());

			}
		} while (!inputValid);

		return cashPayment;
	}

	public static int getValidMenuChoice(Scanner scnr, int menuSize) {
		int menuChoice = 0;
		boolean inputValid = false;

		do {
			try {
				menuChoice = getParsedInteger(scnr.nextLine().trim());
				isInRange(menuChoice, menuSize);
				inputValid = true;

			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());

			}
		} while (!inputValid);

		return menuChoice;
	}

	public static int getParsedInteger(String userInput) {
		try {
			return Integer.parseInt(userInput);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("That's not even a number! Please try again:");
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
	public static void isCorrectNumberOfDigits(String userInput, int correctNumDigits) {
		if (userInput.length() != correctNumDigits) {
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
		if (!userInput.matches("^(?!.*  )[a-zA-Z ]+$")) {
			throw new IllegalArgumentException("You must enter your name as it appears on the card. Please try again:");
		}
	}

	// Validate that a String has the format ####-####-####-####
	public static void isValidCreditCardNumber(String userInput) {
		if (!userInput.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$")) {
			throw new IllegalArgumentException(
					"Credit card number must have the format ####-####-####-####. Please try again:");
		}
	}

	// Validate that a String is a valid date with the format mm/yy
	public static void isValidCreditCardExpirationDate(String userInput) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
		try {
			// Try to parse a YearMonth from the input, then check to make sure it is not in
			// the past.
			if (YearMonth.parse(userInput, formatter).isBefore(YearMonth.now())) {
				throw new IllegalArgumentException("Expiration date must be in the future! Please try again:");
			}
		} catch (DateTimeException dte) {
			throw new IllegalArgumentException("Expiration date format must be mm/yy. Please try again:");
		}

	}

}
