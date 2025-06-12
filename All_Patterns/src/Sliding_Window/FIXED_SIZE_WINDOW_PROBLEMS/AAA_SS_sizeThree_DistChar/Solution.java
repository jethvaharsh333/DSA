package Sliding_Window.FIXED_SIZE_WINDOW_PROBLEMS.AAA_SS_sizeThree_DistChar;

import java.util.Arrays;
import java.util.Scanner;

/*
https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters
Time complexity: O(n), Space complexity: O(1)
* */

public class Solution {
    static int[] arr = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Arrays.fill(arr, 0);
        int count = 0, duplicateCount = 0;

        if (s.length() < 3){
            System.out.println("Count: " + count);
            return;
        }

        for (int i = 0; i < 3; i++) {
            char curr = s.charAt(i);
            arr[curr - 'a']++;
            if (arr[curr - 'a'] == 2) duplicateCount++;
        }

        if (duplicateCount == 0) count++;

        for (int i = 3; i < s.length(); i++) {
            char outChar = s.charAt(i - 3);
            char inChar = s.charAt(i);

            arr[outChar - 'a']--;
            if (arr[outChar - 'a'] == 1) duplicateCount--;

            arr[inChar - 'a']++;
            if (arr[inChar - 'a'] == 2) duplicateCount++;

            if (duplicateCount == 0) count++;
        }

        System.out.println("Count: " + count);
    }
}
