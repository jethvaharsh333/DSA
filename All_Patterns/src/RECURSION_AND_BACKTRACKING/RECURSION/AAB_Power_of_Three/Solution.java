package RECURSION_AND_BACKTRACKING.RECURSION.AAB_Power_of_Three;

import java.util.Scanner;

/*
 * Question link: https://leetcode.com/problems/power-of-three/
 * Date: 02-07-2025
*/

/*

| Approach    | Time Complexity | Space Complexity | Notes                        |
| ----------- | --------------- | ---------------- | ---------------------------- |
| Recursive   | O(log₃ n)       | O(log₃ n)        | Clean, readable, stack usage |
| Iterative   | O(log₃ n)       | O(1)             | Efficient for production     |
| Logarithmic | O(1)            | O(1)             | Slick, but be cautious       |

*/

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        boolean ans = isPowerOfThree1(n);

        System.out.println("ANS: " + ans);
    }

    public static boolean isPowerOfThree1(int n) {
        if(n <= 0) return false;

        if(n == 1) return true;

        if(n == 2) return false;

        return (n%3 == 0) && isPowerOfThree1(n/3);
    }

    public static boolean isPowerOfThree2(int n) {
        if (n <= 0) return false;

        while(n%3 == 0){
            n /= 3;
        }

        return n == 1;
    }

    public static boolean isPowerOfThree3(int n) {
        if (n <= 0) return false;
        double x = Math.log10(n) / Math.log10(3);
        return x == (int)x;
    }
}