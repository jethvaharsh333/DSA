package Sliding_Window.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAA_Long_Substring_without_repeating_chars;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of Longest Substring Without Repeating Characters: " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left=0, right=0;
        int maxLen = 0;

        while(right < s.length()){
            char ch = s.charAt(right);

            if(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }else{
                set.add(ch);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
        }

        return maxLen;
    }
}