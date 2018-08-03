package co.grandcircus.midterm;

public class Validators {

	// Get Integers

	// Validate that an integer is within range 0 - maxNum
	public static void isInRange(int num, int maxNum) {
		if (num < 1 || num > maxNum) {
			throw new IllegalArgumentException("You must enter a number (1-" + maxNum + ")! Please try again:");
		}

	}

	// Validate that an integer is positive
	public static void isPositive(int num) {
		if (num <= 0) {
			throw new IllegalArgumentException("You must enter a positive number.");
		}

	}

	// Validate that a double is positive
	public static void isPositive(double num) {
		if (num <= 0) {
			throw new IllegalArgumentException("You must enter a positive number.");
		}

	}

	// Get Menu Choice

	// Get Quantity

	// Get Check Number

	// Get Credit Card CVV

	// Get Double

	// Get Cash

	// Get Something Weird (REGEX?)

	// Get Credit Card Number

	// Get Date

	// Get Credit Card Exp

}
