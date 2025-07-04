package DP.Knapsack.AAA_Knapsack_1;

/**
 * Question link: https://atcoder.jp/contests/dp/tasks/dp_d
 * Date: 04-07-2025
 * Time complexity:
 * Space complexity:
 */

import java.util.*;
import java.lang.Math;

public class Solution1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int W = sc.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        int ans = knapsack(n-1, W, weights, values);
        System.out.println("ANS: "+ans);
    }

    private static int knapsack(int n, int W, int[] weights, int[] values){
        if(n<0 || W==0) return 0;

        // Once we weight greater than current then we can include, or we can exclude.
        // If not then we will exclude only.

        if(W >= weights[n]){
            return Math.max(values[n]+knapsack(n-1, W-weights[n], weights, values), knapsack(n-1, W, weights, values));
        }

        return knapsack(n-1, W, weights, values);
    }
}