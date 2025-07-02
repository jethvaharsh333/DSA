package RECURSION_AND_BACKTRACKING.RECURSION.AAA_Power_of_Two;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/power-of-two/description/
 * Date: 02-07-2025
 * Time complexity: O(log n)
 * Space complexity: O(log n)
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        boolean ans = isPowerOfTwo1(n);

        System.out.println("ANS: " + ans);
    }

    public static boolean isPowerOfTwo1(int n) {
        if(n <= 0) return false;

        if(n == 1) return true;

        return (n%2 == 0) && isPowerOfTwo1(n/2);
    }

    public static boolean isPowerOfTwo2(int n) {        // O(1) : TIME COMPLEXITY
        return n > 0 && (n & (n - 1)) == 0;
    }
}