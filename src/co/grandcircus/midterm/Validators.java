package co.grandcircus.midterm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validators {

	
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
			throw new IllegalArgumentException(
					"custom yell at them message");
		}
	}
	
	// Validate that a String is a valid date with the format mm/yy
	public static void isValidCreditCardExpirationDate(String userInput) {
		DateFormat format = new SimpleDateFormat("MM/yy");
		format.setLenient(false);		/* Inputs must match specified format */
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
