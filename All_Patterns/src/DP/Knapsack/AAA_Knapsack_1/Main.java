package DP.Knapsack.AAA_Knapsack_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question link:
 * Date: 04-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Main {
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

        long[][] dp = new long[n+1][W+1];
        // initialization with base case condition
        for(int w=0 ; w<=W ; w++) dp[0][w] = 0;
        for(int i=0 ; i<=n ; i++) dp[i][0] = 0;

        for(int i=1; i<=n ; i++){
            for(int j=0 ; j<=W ; j++){  // weight
                if(j >= weights[i-1]){
                    dp[i][j] = Math.max(values[i-1]+dp[i-1][j-weights[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}

