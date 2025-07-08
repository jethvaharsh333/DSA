package DP.Knapsack.AAC_Target_Sum;

import java.util.*;

/**
 * Question link:
 * Date: 05-07-2025
 * Time complexity:
 * Space complexity:
 */

class Solution2 {
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

** We create a 2D DP array because our recursive function has two changing parameters: idx (current index in the array) and sum (current accumulated sum).
However, since sum can become negative due to subtracting values (sum - nums[idx]), we can't directly use sum as an index in the DP array.
To handle this, we compute the total sum of the array (totalSum) and use it as an offset. This allows us to shift the sum range from [-totalSum, totalSum] to [0, 2 * totalSum].
Therefore, the final DP table size becomes dp[n][2 * totalSum + 1] where n = nums.length, and every state is stored as dp[idx][sum + offset].
This prevents negative indexing and ensures memoization is valid for all possible values of sum.

Mistake                                          | Fix
------------------------------------------------ | ---------------------------------------------
You assumed `sum` will always be non-negative    | But `sum` can go negative, so use offset
You used `int[][] dp = new int[len+1][target+1]` | But `target+1` is not the full range of `sum`
You did not account for the full range of sum    | You need range `-totalSum` to `+totalSum`
dp[idx][sum]                                     | dp[idx][sum+offset]

*/