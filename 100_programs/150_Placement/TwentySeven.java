/*
Generating a Pattern of Numbers
Difficulty: Easy
Topics: Basic Programming, Patterns
Description: Write a program to generate number patterns (e.g., sequential numbers in a matrix).
Example:
Input: rows = 3
Output:

1  
2 3  
4 5 6  
Explanation: A number pattern with 3 rows is generated.
*/

import java.util.*;

public class TwentySeven{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter rows: ");
		int n = sc.nextInt();

		int count = 1;

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<i ; j++){
				System.out.print(count+"\t");
				count++;
			}
			System.out.println();
		}

		return;	
	}
}