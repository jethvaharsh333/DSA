/*
	Summing Digits of a Number
	Difficulty: Easy
	Topics: Basic Programming, Mathematical Computations
	Description: Write a program to calculate the sum of digits of a number.
	Example:
	Input: number = 1234
	Output: 10
	Explanation: The sum of the digits 1 + 2 + 3 + 4 = 10.
*/

import java.util.*;

public class Nine{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int num = sc.nextInt();
		int sum = 0;
		while(num>0){
			sum += (num%10);
			num /= 10;
		}

		System.out.print(sum);

		return;	
	}
}