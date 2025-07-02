package RECURSION_AND_BACKTRACKING.RECURSION.AAE_Pow_x_n;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/powx-n/
 * Date: 02-07-2025
 * Time complexity: O(n) – due to linear recursive calls
 * Space complexity: O(n) – recursive stack space
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base (x): ");
        double x = sc.nextDouble();

        System.out.print("Enter exponent (n): ");
        int n = sc.nextInt();

        double result = myPow(x, n);
        System.out.println("Result of x^n is: " + result);
    }

    public static double myPow(double x, int n) {
        if(n == 0) return 1;

        if(n > 0){
            return x * myPow(x, n-1);
        }else{
            return 1 / myPow(x, -n);
        }
    }
}