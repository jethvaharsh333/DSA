/*
	Identifying Palindromes
	Difficulty: Easy
	Topics: Basic Programming, String Manipulation
	Description: Write a program to check if a string or number is a palindrome.
	Example:
	Input: string = "radar"
	Output: Palindrome
	Explanation: "radar" reads the same backward as forward.
*/

import java.util.*;

public class Six{
	static boolean isPalindrome(String s){
		int left = 0;
		int right = s.length()-1;

		int flag=0;

		while(right>left){
			if(s.charAt(left) != s.charAt(right)){
				flag=1;
				break;
			}
			left++;
			right--;
		}

		if(flag == 1){
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter string: ");
		String str = sc.nextLine();

		if(isPalindrome(str)){
			System.out.print("PALINDROME");
		}else{
			System.out.print("NOT PALINDROME");
		}

		return;	
	}
}