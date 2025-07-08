package DP.Knapsack.AAB_Ones_And_Zeroes;
import java.util.*;

/**
 * Question link: https://leetcode.com/problems/ones-and-zeroes
 * Date: 04-07-2025
 * Time complexity: O(L × M × N)
 * Space complexity: O(L × M × N)
 */

class Solution2 {
    public int findMaxForm(String[] strs, int m, int n) {
        // The changing parameters from basic recursion code => idx, m, n
        int[][][] dp = new int[strs.length][m+1][n+1];

        for(int i=0 ; i<strs.length ; i++){
            for(int j=0 ; j<=m ; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return recurse(0, strs, m, n, dp);
    }

    private int recurse(int idx, String[] strs, int m, int n, int[][][] dp){
        if (idx == strs.length) return 0;
        if (dp[idx][m][n] != -1) return dp[idx][m][n];

        int zeroes = countZeroes(strs[idx]);
        int ones = strs[idx].length() - zeroes;

        int take = 0;

        if(m>=zeroes && n>=ones){
            take = 1 + recurse(idx+1, strs, m-zeroes, n-ones, dp);
        }

        int notTake = recurse(idx+1, strs, m, n, dp);

        return dp[idx][m][n] = Math.max(take, notTake);
    }

    private int countZeroes(String strs){
        int zeroes = 0;

        for(char c: strs.toCharArray()){
            if(c == '0') zeroes++;
        }

        return zeroes;
    }
}