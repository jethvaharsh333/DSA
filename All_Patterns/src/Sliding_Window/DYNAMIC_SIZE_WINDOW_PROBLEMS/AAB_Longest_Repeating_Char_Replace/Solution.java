package Sliding_Window.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAB_Longest_Repeating_Char_Replace;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: string s
        System.out.print("Enter string s (uppercase letters only): ");
        String s = scanner.nextLine().trim();

        // Input: integer k
        System.out.print("Enter value of k (max replacements): ");
        int k = scanner.nextInt();

        // Call the function and print result
        int result = characterReplacement(s, k);
        System.out.println("Longest repeating character substring (with at most " + k + " replacements): " + result);

        scanner.close();
    }

    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int l=0, r=0;
        int maxFreq = 0;    // Highest freq in current window
        int maxLen = 0;     // longest substring as per question
        int[] freq = new int[26];

        while(r < len){
            char curr = s.charAt(r);
            freq[curr-'A']++;
            maxFreq = Math.max(maxFreq, freq[curr-'A']);

            while(r-l+1-maxFreq > k){       // windowSize-maxFreq > k => now no elements be swapped with the help of k
                freq[s.charAt(l)-'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}

/*
 If your current window is "AABBB" and k = 1, max char count = 3 (for B), total length = 5,
 you only need to change 2 letters to match → (5 - 3) = 2 > k → shrink
 */