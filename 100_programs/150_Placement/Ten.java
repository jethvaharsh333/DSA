/*
	Finding the Greatest Common Divisor (GCD)
	Difficulty: Easy
	Topics: Basic Programming, Number Theory
	Description: Write a program to find the GCD of two numbers.
	Example:
	Input: a = 48, b = 18
	Output: 6
	Explanation: The GCD of 48 and 18 is 6.
*/

import java.util.*;

public class Ten{
	static int gcd2(int a, int b) {
	    while(b != 0){
	        int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}


	static int gcd1(int a, int b){
		int gcd = 1;

		for(int i=1 ; i<=Math.min(a, b) ; i++){
			if(a%i==0 && b%i==0){
				gcd = i;
			}
		}

		return gcd;
	}

	public static void main(String[] args) {
		System.out.println("EQUAL: "+(6^6));
		System.out.println(3^7);
		System.out.println(6^5);
		// 110
		// 101
		// 011 (3)
		// 101 (-3)
		// 001

		System.out.println(7^2);
		// 111 (7)
		// 010 (2)
		// 101 (5) [ANSWER]
		// 011 (-5)
		// 110	(6) [ANSWER]

		System.out.println(5^-5);
		// Scanner sc = new Scanner(System.in);

		// System.out.print("Enter number 1: ");
		// int n1 = sc.nextInt();

		// System.out.print("Enter number 2: ");
		// int n2 = sc.nextInt();

		// int ans = gcd1(n1, n2);

		// System.out.println("ANS: "+ans);

		// return;	
	}
}