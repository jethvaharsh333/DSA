package DP.Knapsack.AAA_Knapsack_1;

import java.util.*;

/**
 * Question link:
 * Date: 04-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int W = sc.nextInt();

        int[] weights = new int[n];
        long[] values = new long[n];

        for(int i=0 ; i<n ; i++){
            weights[i] = sc.nextInt();
            values[i] = sc.nextLong();
        }

        long[] dp = new long[W+1];

        for(int i=0 ; i<n ; i++){
            for(int j=W ; j>=weights[i] ; j--){
                dp[j] = Math.max(dp[j], values[i] + dp[j-weights[i]]); // value of item + leftover best
            }
        }

        System.out.println(dp[W]);
    }
}