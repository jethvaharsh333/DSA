package DP.Knapsack.AAB_Ones_And_Zeroes;

/**
 * Question link: https://leetcode.com/problems/ones-and-zeroes
 * Date: 04-07-2025
 * Time complexity: O(L*m*n)
 * Space complexity: O(L*m*n)
 */

class Solution1 {
    public int findMaxForm(String[] strs, int m, int n) {
        return recurse(0, strs, m, n);
    }

    private int recurse(int idx, String[] strs, int m, int n){
        if((m==0 && n==0) || idx>=strs.length){
            return 0;
        }

        int zeroes = countZeroes(strs[idx]);
        int ones = strs[idx].length() - zeroes;

        if(m>=zeroes && n>=ones && idx<strs.length){
            return Math.max(1+recurse(idx+1, strs, m-zeroes, n-ones), recurse(idx+1, strs, m, n));
        }

        return recurse(idx+1, strs, m, n);
    }

    private int countZeroes(String strs){
        int zeroes = 0;

        for(char c: strs.toCharArray()){
            if(c == '0') zeroes++;
        }

        return zeroes;
    }
}