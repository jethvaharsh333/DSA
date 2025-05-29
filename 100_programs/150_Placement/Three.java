/*
	Validating Leap Years
	Difficulty: Easy
	Topics: Basic Programming, Date Handling
	Description: Write a program to check if a given year is a leap year.
	Example:
	Input: year = 2020
	Output: Leap Year
	Explanation: 2020 is divisible by 4 but not by 100, or it is divisible by 400, so it is a leap year.
*/

import java.util.*;

public class Three{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter year: ");
		int year = sc.nextInt();

		if((year%4 == 0 && year%100 != 0) || year%400 == 0){
			System.out.print("LEAP YEAR");
		}else{
			System.out.print("NOT A LEAP YEAR");
		}

		return;	
	}
}