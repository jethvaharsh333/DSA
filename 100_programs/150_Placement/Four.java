/*
	Calculating Armstrong Numbers
	Difficulty: Easy
	Topics: Basic Programming, Number Theory
	Description: Write a program to check if a number is an Armstrong number.
	Example:
	Input: number = 153
	Output: Armstrong Number
	Explanation: 153 is an Armstrong number because 1^3 + 5^3 + 3^3 = 153.

	-> 1634, 371, 407
*/

import java.util.*;

public class Four{
	static boolean isArmstrong(int num){
		int len = 0;
		int temp = num;

		// check length
		while(temp>0){
			len++;
			// System.out.println("log: "+temp);
			temp /= 10;
		}
		// System.out.println("count: "+len);

		int sum = 0;
		temp = num;
		while(temp>0){
			int digit = temp%10;
			sum += Math.pow(digit, len);
			temp /= 10;
		}

		if(num == sum)
			return true;

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int num = sc.nextInt();

		if(isArmstrong(num)){
			System.out.print("ARMSTRONG NUMBER");
		}
		else{
			System.out.print("NOT ARMSTRONG NUMBER");
		}

		return;	
	}
}