package RECURSION_AND_BACKTRACKING.RECURSION.AAL_Predict_Winner;

import java.util.*;

/**
 * Question link:
 * Date: 11-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);

        return recurse(0, nums.length-1, nums, dp) >= 0;
    }

    private int recurse(int start, int end, int[] nums, int[][] dp){
        if (start == end) return nums[start];

        if (dp[start][end] != -1) return dp[start][end];

        int pickStart = nums[start] - recurse(start+1, end, nums, dp);
        int pickEnd = nums[end] - recurse(start, end-1, nums, dp);

        return dp[start][end] = Math.max(pickStart, pickEnd);
    }
}