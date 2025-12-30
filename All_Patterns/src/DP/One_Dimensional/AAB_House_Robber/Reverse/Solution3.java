package DP.One_Dimensional.AAB_House_Robber.Reverse;

/**
 * Question link:
 * Date: 06-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution3 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+2];
        dp[len] = 0;
        dp[len+1] = 0;

        for(int i=len-1 ; i>=0 ; i--){
            dp[i] = Math.max(dp[i+1], dp[i+2] + nums[i]);
        }

        return dp[0];
    }
}