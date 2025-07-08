package DP.Knapsack.AAC_Target_Sum;

/**
 * Question link:
 * Date: 05-07-2025
 * Time complexity:
 * Space complexity:
 */

class Solution1 {
    public int findTargetSumWays(int[] nums, int target) {
        return recurse(0, 0, nums.length, nums, target);
    }

    private int recurse(int idx, int sum, int len, int[] nums, int target){
        if(idx == len){
            if(sum == target){
                return 1;
            }

            return 0;
        }

        return recurse(idx+1, sum+nums[idx], len, nums, target) + recurse(idx+1, sum-nums[idx], len, nums, target);
    }
}