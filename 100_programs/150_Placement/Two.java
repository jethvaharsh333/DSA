/*
	Checking for Prime Numbers
	Difficulty: Easy
	Topics: Basic Programming, Number Theory
	Description: Write a program to determine if a number is prime.
	Example:
	Input: number = 7
	Output: Prime
	Explanation: 7 has no divisors other than 1 and itself, so it is a prime number.
*/

import java.util.*;

public class Two{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int num = sc.nextInt();

		if(num < 2){
			System.out.print("NOT PRIME");
			return;
		}

		int flag = 0;

		for(int i=2; i<num ; i++){
			if(num%i == 0){
				flag = 1;
				break;
			}
		}

		if(flag == 0)
			System.out.print("PRIME");
		else
			System.out.print("NOT PRIME");

		return;
	}
}