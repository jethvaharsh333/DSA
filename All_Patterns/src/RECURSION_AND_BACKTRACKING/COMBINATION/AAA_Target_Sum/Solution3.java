package RECURSION_AND_BACKTRACKING.COMBINATION.AAA_Target_Sum;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution3 {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;

        int totalSum = 0;
        for(int num : nums) totalSum += num;
        // Edge case: target + totalSum must be even and non-negative
        if ((target+totalSum)%2 != 0 || target>totalSum || target<-totalSum)
            return 0;

        int subsetSum = (target + totalSum) / 2;
        int[] dp = new int[subsetSum+1];
        dp[0] = 1;     // base case: one way to make sum 0 (empty subset)

        for(int idx=0 ; idx<len ; idx++){
            for(int j=subsetSum ; j>=nums[idx] ; j--){
                dp[j] = dp[j] + dp[j-nums[idx]];
            }
        }

        return dp[subsetSum];
    }
}