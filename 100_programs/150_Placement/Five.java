/*
	Generating the Fibonacci Series
	Difficulty: Easy
	Topics: Basic Programming, Sequences
	Description: Write a program to generate the Fibonacci series up to a given number.
	Example:
	Input: limit = 10
	Output: [0, 1, 1, 2, 3, 5, 8]
	Explanation: The Fibonacci series up to 10 is generated as [0, 1, 1, 2, 3, 5, 8].
*/

import java.util.*;

public class Five{
	static void printFibonacci(int limit){
		int prevOfPrev = 0;
		int prev = 1;

		if(limit<0){
			return;
		}
		
		System.out.print(0+", ");
		
		if(limit<=0){
			return;	
		}
		
		System.out.print(1+", ");
		

		int sum = prev + prevOfPrev;

		while(limit>=sum){
			System.out.print(sum+", ");

			prevOfPrev = prev;
			prev = sum;
			sum = prevOfPrev + prev;
		}

		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter limit: ");
		int limit = sc.nextInt();

		printFibonacci(limit);

		return;	
	}
}