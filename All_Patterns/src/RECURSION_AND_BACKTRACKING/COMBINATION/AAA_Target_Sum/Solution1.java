package RECURSION_AND_BACKTRACKING.COMBINATION.AAA_Target_Sum;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
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