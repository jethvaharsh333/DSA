package DP.One_Dimensional.AAB_House_Robber.Forward;

import java.util.*;

/**
 * Question link:
 * Date: 06-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, -1);

        return recurse(nums, len, dp);
    }

    private int recurse(int[] nums, int i, int[] dp){
        if(i == 1){
            dp[i] = nums[0];
            return nums[0];
        }

        if(i == 0){
            dp[0] = 0;
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int pick = recurse(nums, i-2, dp)+nums[i-1];
        int noPick = recurse(nums, i-1, dp);
        dp[i] = Math.max(pick, noPick);

        return dp[i];
    }
}