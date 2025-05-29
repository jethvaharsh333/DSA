/*
	Determining Even/Odd Numbers
	Difficulty: Easy
	Topics: Basic Programming
	Description: Write a program to check whether a number is even or odd.
	Example:
	Input: number = 4
	Output: Even
	Explanation: Since 4 is divisible by 2, it is an even number.
*/

import java.util.*;

public class One{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int num = sc.nextInt();

		if(num%2 == 0){
			System.out.println("EVEN");
		}
		else{
			System.out.println("ODD");
		}

		return;
	}
}