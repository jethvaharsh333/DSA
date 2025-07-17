package RECURSION_AND_BACKTRACKING.COMBINATION.AAA_Target_Sum;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;

        int totalSum = 0;
        for(int num : nums) totalSum += num;
        if (target > totalSum || target < -totalSum) return 0;

        Integer[][] dp = new Integer[len+1][2*totalSum + 1];

        return recurse(0, 0, nums, target, dp, totalSum);
    }

    private int recurse(int idx, int sum, int[] nums, int target, Integer[][] dp, int offset){
        if(idx == nums.length){
            return sum == target ? 1 : 0;
        }

        if(dp[idx][sum+offset] != null) return dp[idx][sum+offset];

        int plus = recurse(idx+1, sum+nums[idx], nums, target, dp, offset);
        int minus = recurse(idx+1, sum-nums[idx], nums, target, dp, offset);

        return dp[idx][sum+offset] = plus + minus;
    }
}

/*

Mistake                                          | Fix
------------------------------------------------ | ---------------------------------------------
You assumed `sum` will always be non-negative    | But `sum` can go negative, so use offset
You used `int[][] dp = new int[len+1][target+1]` | But `target+1` is not the full range of `sum`
You did not account for the full range of sum    | You need range `-totalSum` to `+totalSum`

                idx=0 sum=0
              /             \
         +1/                   \-1
       idx=1 sum=1          idx=1 sum=-1
      /         \             /         \
   +1           -1        +1           -1
idx=2 sum=2  idx=2 sum=0 idx=2 sum=0  idx=2 sum=-2

See how idx=2 sum=0 came twice

*/