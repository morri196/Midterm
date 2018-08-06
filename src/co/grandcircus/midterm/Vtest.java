package co.grandcircus.midterm;

import java.util.Scanner;

public class Vtest {

	public static void main(String[] args) {
		
		// THIS IS JUST A DUMMY CLASS FOR TESTING VALIDATORS
		
		Scanner scnr = new Scanner(System.in);
		
		Validators.getValidNameOnCard(scnr);
		
		Validators.getValidCreditCardNumber(scnr);
		
		Validators.getValidCreditCardExpiration(scnr);
		
		Validators.getValidCreditCardCVV(scnr);
		
		
		scnr.close();
		
	}

}
