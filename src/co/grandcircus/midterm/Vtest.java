package co.grandcircus.midterm;

import java.util.Scanner;

public class Vtest {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		try {
			int num = Integer.parseInt(scnr.nextLine());
			Validators.isInRange(num, 10);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
