/*
Finding the Largest Palindrome in a String
Difficulty: Easy
Topics: Basic Programming, String Manipulation
Description: Write a program to find the largest palindrome in a given string.
Example:
Input: string = "babad"
Output: "bab" or "aba"
Explanation: Both "bab" and "aba" are valid palindromes in the string.
*/

import java.util.*;

public class TwentyNine{
	private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of palindrome
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       // Odd length
            int len2 = expandFromCenter(s, i, i + 1);   // Even length
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	

		System.out.print("Enter string: ");
		String str = sc.nextLine();

		String result = longestPalindrome(str);
        System.out.println("Longest Palindromic Substring: " + result);
	}
}