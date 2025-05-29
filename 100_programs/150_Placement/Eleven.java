/*
	Finding the Least Common Multiple (LCM)
	Difficulty: Easy
	Topics: Basic Programming, Number Theory
	Description: Write a program to find the LCM of two numbers.
	Example:
	Input: a = 12, b = 15
	Output: 60
	Explanation: The LCM of 12 and 15 is 60.
*/

import java.util.*;

public class Eleven{
	static int lcm1(int a, int b){
		int max = Math.max(a, b);

	    while(true) {
	        if(max%a == 0 && max%b == 0) {
	            return max;
	        }
	        max++;
	    }

	    return max;
	}

	// static int lcm2(int a, int b) {
	//     return (a * b) / gcd1(a, b);   // from program Ten.java
	// }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number 1: ");
		int n1 = sc.nextInt();

		System.out.print("Enter number 2: ");
		int n2 = sc.nextInt();

		int ans = lcm1(n1, n2);

		System.out.println("ANS: "+ans);

		return;	
	}
}