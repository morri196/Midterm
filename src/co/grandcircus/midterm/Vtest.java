package co.grandcircus.midterm;

import java.util.Scanner;

public class Vtest {

	public static void main(String[] args) {
		
		// THIS IS JUST A DUMMY CLASS FOR TESTING VALIDATORS
		
		Scanner scnr = new Scanner(System.in);
		
		int quantity = Validators.getValidQuantity(scnr);
		
		scnr.close();
		
	}

}
