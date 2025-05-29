/*
Crafting Star Patterns
Difficulty: Easy
Topics: Basic Programming, Patterns
Description: Write a program to create different star patterns (e.g., pyramid, diamond).
Example:
Input: patternType = "pyramid", height = 5
Output:

    *
   ***
  *****
 *******
*********
Explanation: A pyramid pattern with a height of 5 is generated.
*/

import java.util.*;

public class Seven{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int num = sc.nextInt();

		for(int i=0 ; i<num ; i++){
			for(int j=0 ; j<num-i-1 ; j++){
				System.out.print(" ");
			}
			for(int k=0 ; k<=i ; k++){
				System.out.print("*");
			}
			for(int l=0 ; l<i ; l++){
				System.out.print("*");
			}
			System.out.println();
		}

		return;	
	}
}