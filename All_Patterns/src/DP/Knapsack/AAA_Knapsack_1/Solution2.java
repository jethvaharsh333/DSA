package DP.Knapsack.AAA_Knapsack_1;

import java.util.*;

/**
 * Question link:
 * Date: 04-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int W = sc.nextInt();

        int[] weights = new int[n];
        long[] values = new long[n];

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextLong();
        }

        long[][] t = new long[n+1][W+1];
        for (long[] row : t) Arrays.fill(row, -1);

        long ans = knapsack(n, W, weights, values, t);
        System.out.println("ANS: "+ans);
    }

    private static long knapsack(int n, int W, int[] weights, long[] values, long[][] t){
        if(n==0 || W==0) return 0;

        if(t[n][W] != -1) return t[n][W];

        if(W >= weights[n-1]){
            t[n][W] = Math.max(values[n-1]+knapsack(n-1, W-weights[n-1], weights, values, t), knapsack(n-1, W, weights, values, t));
        }else{
            t[n][W] = knapsack(n-1, W, weights, values, t);
        }

        return t[n][W];
    }
}