package DP.Knapsack.AAB_Ones_And_Zeroes;

/**
 * Question link: https://leetcode.com/problems/ones-and-zeroes
 * Date: 04-07-2025
 * Time complexity: O(L × M × N)
 * Space complexity: O(M × N)
 */

class Solution3 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(String s : strs){
            int zeroes = countZeroes(s);
            int ones = s.length()-zeroes;

            for(int i=m ; i>=zeroes ; i--){
                for(int j=n ; j>=ones ; j--){
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-zeroes][j-ones]);
                }
            }
        }

        return dp[m][n];
    }

    private int countZeroes(String strs){
        int zeroes = 0;

        for(char c: strs.toCharArray()){
            if(c == '0') zeroes++;
        }

        return zeroes;
    }
}

/*

**we realize — for bottom-up DP, we don’t track idx explicitly.
Instead, we process strings one-by-one like a loop.
So we remove idx dimension and loop through each string.

**dp[m][n] = max strings using up to m zeroes and n ones

**Instead of
    take = 1 + recurse(idx+1, m-zeroes, n-ones)
    notTake = recurse(idx+1, m, n)
we use
    dp[i][j] = max(dp[i][j], 1 + dp[i-zeroes][j-ones]);
with reverse loop which avoids overwriting results

*/