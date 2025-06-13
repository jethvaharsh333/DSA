package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAA_Long_Substring_without_repeating_chars;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of Longest Substring Without Repeating Characters: " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int left=0, right=0;
        int maxLen = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            freq[ch]++;

            while(freq[ch] > 1){
                freq[s.charAt(left)]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
