package co.grandcircus.midterm;

import java.util.Scanner;

public class Vtest {

	public static void main(String[] args) {
		
		// THIS IS JUST A DUMMY CLASS FOR TESTING VALIDATORS
		
		Scanner scnr = new Scanner(System.in);
		
		try {
			System.out.println("Enter mm/yy");
			String userInput = scnr.nextLine();
			// Validators.isPositive(userInput);
			// Validators.isInRange(userInput, 100);
			// Validators.isCorrectNumberOfDigits(userInput, 1);
			// Validators.isGreaterThanMinAmount(userInput, 2.75);
			// Validators.isValidCreditCardNumber(userInput);
			// Validators.isValidNameOnCreditCard(userInput);
			Validators.isValidCreditCardExpirationDate(userInput);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		
		scnr.close();
		
	}

}
