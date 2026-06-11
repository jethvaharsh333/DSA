package DP.One_Dimensional.AAC_198_House_Robber;

import java.util.Arrays;

public class Memoization {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return recurse(nums.length-1, nums, memo);
    }

    public int recurse(int index, int[] nums, int[] memo){
        if(index < 0) return 0;
        if(index == 0) return nums[0];

        if(memo[index] != -1) return memo[index];

        int pick = nums[index] + recurse(index-2, nums, memo);
        int noPick = recurse(index-1, nums, memo);

        return memo[index] = Math.max(pick, noPick);
    }
}
