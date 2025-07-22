package RECURSION_AND_BACKTRACKING.COMBINATION.AAI_Maximum_Compatibility_Score_Sum;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/maximum-compatibility-score-sum/
 * Date: 19-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int len = students.length;
        int[][] score = new int[len][len];

        for(int i=0 ; i<len ; i++){
            for(int j=0 ; j<len ; j++){
                score[i][j] = getScore(students[i], mentors[j]);
            }
        }

        int[][] dp = new int[len][1 << len]; // Memoization table
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return helper(0, 0, score, dp, len);
    }

    private int helper(int idx, int mask, int[][] score, int[][] dp, int len) {
        if(idx == len) return 0;
        if(dp[idx][mask] != -1) return dp[idx][mask];

        int max = 0;
        for(int i=0 ; i<len ; i++){
            if((mask & (1 << i)) == 0){ // check if mentor i is already used
                int newMask = mask | (1 << i); // assign mentor i to current student
                int total = score[idx][i] + helper(idx+1, newMask, score, dp, len);
                max = Math.max(max, total);
            }
        }

        return dp[idx][mask] = max;
    }

    private int getScore(int[] student, int[] mentor) {
        int count = 0;

        for(int i=0 ; i<student.length ; i++){
            if (student[i] == mentor[i]) count++;
        }

        return count;
    }
}

/*

===> A bitmask is just an integer where each bit represents the state of something (usually ON/OFF, TRUE/FALSE).
For example, if you have 3 mentors, a bitmask of 3 bits like this:
mask = 101  (binary) → means:
- Mentor 0 → Used (bit 0 = 1)
- Mentor 1 → Not Used (bit 1 = 0)
- Mentor 2 → Used (bit 2 = 1)

=> We use a bitmask integer to represent which mentors have already been assigned.
Since len ≤ 8, we can represent mentor assignment state using 8 bits:

Example for len = 3:
    -> Mask = 000 → No mentor used
    -> Mask = 101 → Mentor 0 and 2 used
    -> Mask = 111 → All mentors used

So total states of mentor assignment = 2^len → we need a table of size 1 << len = 2^len.

=> Tools:
    -> mask & (1 << i) -> Check if the i-th bit in mask is 1 (i.e. mentor i is used).
    -> mask | (1 << i) => This turns ON the i-th bit in the mask

    ->  mask = 1010 (binary) = 10 (decimal)
        i = 1 → (1 << 1) = 0010
        mask & (1 << 1) = 1010 & 0010 = 0010 ≠ 0 → mentor 1 is used

    ->  mask = 1001 (mentor 0 and 3 used)
        i = 2 → (1 << 2) = 0100
        newMask = 1001 | 0100 = 1101 → mentor 2 is now marked used too


=> dp[idx][mask]
    -> idx: Which student you're assigning now (from 0 to m-1).
    -> mask: Bitmask of which mentors are already assigned.
    -> dp[idx][mask]: The maximum score you can get from assigning student idx onward, given that mentors used so far are mask.

Let's walk through a simplified example (say len = 3):
-idx = 0, mask = 000
    -Try assigning mentor 0 → newMask = 001
        -idx = 1, mask = 001
            -Try assigning mentor 1 → newMask = 011
                -idx = 2, mask = 011
                    -Try mentor 2 → mask = 111
                        -idx = 3, return 0 (base case)
                -Result = score[2][2] + 0
            -Result = score[1][1] + result above
        -Result = score[0][0] + result above

=> left shift (<<) and right shift (>>) operators are binary bitwise operators that are used to shift the bits either left or right of the first operand by the number of positions specified by the second operand

Practice Check:
int mask = 0101; // mentor 0 and 2 used

1) Is mentor 1 used? → (mask & (1 << 1)) != 0 → ?
    1 << 1 => 0010
    Now 0101 (mask)
       &0010
        ----
        0000 == 0 => Mentor 1 not used

2) Is mentor 2 used? → (mask & (1 << 1)) != 0 → ?
    1 << 2 => 0100
    Now 0101 (mask)
       &0100
       -----
        0100 != 0 => Mentor 2 is used.

3) Assign mentor 3 → mask | (1 << 3) → ?
    1 << 3 => 1000
    Now 0101
    (or)1000
    --------
        1101 => third mentor assigned

** REMEMBER: original mask = 00000000 is our original bit as 2^8 (Alc. to question => 8 mentors → we need 8 bits.)

*/