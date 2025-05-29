/*
	Finding the Factorial of a Number
	Difficulty: Easy
	Topics: Basic Programming, Mathematical Computations
	Description: Write a program to compute the factorial of a given number.
	Example:
	Input: number = 5
	Output: 120
	Explanation: 5! (factorial) is 5 × 4 × 3 × 2 × 1 = 120.
*/

import java.util.*;

public class Eight{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int num = sc.nextInt();

		int ans = 1;
		for(int i=1 ; i<=num ; i++){
			ans *= i;
		}

		System.out.print(ans);

		return;	
	}
}