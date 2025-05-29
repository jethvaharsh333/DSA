/*
	Counting Vowels and Consonants in a String
	Difficulty: Easy
	Topics: Basic Programming, String Manipulation
	Description: Write a program to count vowels and consonants in a given string.
	Example:
	Input: string = "hello world"
	Output: Vowels: 3, Consonants: 7
	Explanation: "hello world" contains 3 vowels (e, o, o) and 7 consonants (h, l, l, w, r, l, d).
*/

import java.util.*;

public class Twelve{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter string: ");
		String str = sc.nextLine();

		int vowels = 0;
		int consonents = 0;

		int len = str.length(); 
		for(int i=0 ; i<len ; i++){
			char ch = str.charAt(i);

			if(ch==' '){
				continue;
			}
			else if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
				vowels++;
			}else{
				consonents++;
			}
		}

		System.out.print("VOWELS: "+vowels+"\tCONSONENTS: "+consonents);

		return;	
	}
}