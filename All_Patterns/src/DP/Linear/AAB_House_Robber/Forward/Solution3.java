package DP.Linear.AAB_House_Robber.Forward;

import java.util.*;

/**
 * Question link:
 * Date: 06-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution3 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;          // no houses
        dp[1] = nums[0];    // only house 0

        for(int i=2 ; i<=nums.length ; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[nums.length];
    }
}

/*

Converting Reverse DP [2nd optimization] to forward DP [3rd optimization]

** STEP 1: Understand What the Recursive Function Represents
    Your function: recurse(idx)
    represents: "The maximum money that can be robbed from house idx to end."

    This becomes: dp[i] = max money from house i to the end
    This is bottom-up reverse DP. But your target tabulation is forward DP.

------------------------------------------------------------------

** STEP 2: Change the Definition
    Let’s change it to: dp[i] = max money from house 0 to house i-1
    So now:
        dp[0] = 0 → robbing from no houses = 0
        dp[1] = nums[0] → only one house: rob it

    And to compute dp[i]: "I can either rob the i-1-th house and add dp[i-2], or skip it and take dp[i-1]"

    So, dp[i] = max(dp[i-1], dp[i-2] + nums[i-1])

------------------------------------------------------------------

** STEP 3: Build from Smaller to Bigger
    Unlike recursion (which starts at idx = 0 and goes forward), tabulation builds:
    `
    dp[0] = 0
    dp[1] = nums[0]
    for i = 2 to n:
        dp[i] = max(dp[i-1], dp[i-2] + nums[i-1])
    `

------------------------------------------------------------------

** STEP 4: Understand Index Mapping Between Two Approaches

    | Memoization (Top-down)       | Tabulation (Bottom-up)             |
    | ---------------------------- | ---------------------------------- |
    | `recurse(idx)`               | `dp[idx] = max from idx → end`     |
    | base: `idx >= n → 0`         | `dp[n] = 0`                        |
    | `nums[idx] + recurse(idx+2)` | `dp[i-2] + nums[i-1]` ← key change |
    | Access from front            | Build from back                    |

    This is why the array index shifts from nums[idx] to nums[i-1].

------------------------------------------------------------------

**STEP 5: Understand You’re Solving Same Subproblems, Just Different Order
    You were solving idx = 0 up to idx = n-1 recursively.
    In tabulation, you solve:
        dp[0] first
        dp[1] second
        Then build up to dp[n]

*/