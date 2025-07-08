package DP.Linear.AAB_House_Robber.Reverse;

/**
 * Question link:
 * Date: 06-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public int rob(int[] nums) {
        return recurse(0, nums);
    }

    private int recurse(int idx, int[] nums){
        if(idx >= nums.length){
            return 0;
        }

        return Math.max(recurse(idx+1, nums), nums[idx] + recurse(idx+2, nums));
    }
}