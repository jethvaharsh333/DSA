package DP.Knapsack.AAC_Target_Sum;

import java.util.*;

/**
 * Question link:
 * Date: 05-07-2025
 * Time complexity:
 * Space complexity:
 */

class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0 ; i<n ; i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;

        int totalSum = 0;
        for(int num : nums) totalSum += num;
        // Edge case: target + totalSum must be even and non-negative
        if ((target+totalSum)%2 != 0 || target>totalSum || target<-totalSum)
            return 0;

        int subsetSum = (target + totalSum) / 2;
        int[] dp = new int[subsetSum+1];
        dp[0] = 1;     // base case: one way to make sum 0 (empty subset)


        for(int j=0 ; j<=subsetSum ; j++){
            System.out.print(dp[j] + ", ");
        }
        System.out.println();

        for(int idx=0 ; idx<len ; idx++){
            for(int j=subsetSum ; j>=nums[idx] ; j--){
                dp[j] = dp[j] + dp[j-nums[idx]];
            }
            for(int j=0 ; j<=subsetSum ; j++){
                System.out.print(dp[j] + ", ");
            }
            System.out.println();
        }

        return dp[subsetSum];
    }
}

/*

Let’s say:
    P is the subset of numbers with + sign.
    N is the subset of numbers with - sign.

Then the total sum becomes:
    sum(P) - sum(N) = target   ←←← original target condition
AND
    sum(P) + sum(N) = totalSum ←←← obvious from the array
Add them:
    2 * sum(P) = target + totalSum
    ⇒ sum(P) = (target + totalSum) / 2      => Count the number of subsets in nums[] that sum to subsetSum = sum(P)

We reduce the problem to:
    How many subsets exist in nums[] with sum = (target + totalSum)/2?

**Count number of subsets in array with given sum = subsetSum
This is the Subset Sum Count problem.

-------------------
dp[i] = number of subsets that make sum i
dp[j] = number of ways to make sum `j` using available numbers
Your goal is to compute dp[subsetSum], which is the number of subsets that give sum sum(P) = (target + totalSum)/2

There's 1 way to make sum = 0 → choose empty subset. So, --> dp[0] = 1; <--

Goal: Update the number of ways to get sum j using current nums[idx].
-> Let’s say you’re building the number of ways to make sum = 5. How do you get to 5 using nums[idx] = 2?
-> You can make 5 if:
    1] You already knew how to make 5 - 2 = 3 using previous numbers
    2] Now just add 2 to those combinations to make 5.
    So, dp[5] = dp[5] + dp[3];
-> “Every way to make sum `j - nums[idx]` can now be used to make sum `j`, by including `nums[idx]`.”

Why Loop Backwards?
When you use a number only once, like in subset problems, you must go from high to low.
Otherwise, you’ll reuse the same number multiple times in one iteration.
-> For example: dp[j] += dp[j - num];
    If you go from j = num to subsetSum (i.e., low to high), dp[j - num] might already be updated in this same iteration, which corrupts the logic.
    By going backwards, you only use dp[j - num] from the previous state, as it existed before you processed num.

| Part            | Meaning                                                       |
| --------------- | ------------------------------------------------------------- |
| `j = subsetSum` | Try all target sums `j` from high to low                      |
| `j >= num`      | You can't make sum `j` if `j < num`                           |
| `dp[j - num]`   | All the ways to make `sum = j - num` (from earlier)           |
| `+=`            | Add those ways to the current count of ways to make `sum = j` |

-------------------------------------------

Let's take nums = [1, 2], target sum = 3

=> subsetSum = ((1+2) + 3)/2 = 3

Initial:
dp = [1, 0, 0, 0]   // dp[0] = 1

Process 1:
for j = 3 down to 1:
  dp[3] += dp[2] → 0
  dp[2] += dp[1] → 0
  dp[1] += dp[0] → dp[1] = 1

dp becomes:
[1, 1, 0, 0]

Process 2:
for j = 3 to 2:
  dp[3] += dp[1] → dp[3] = 1
  dp[2] += dp[0] → dp[2] = 1

Final dp = [1, 1, 1, 1]

→ dp[3] = 1 → one way to make sum 3 ([1, 2])

*/