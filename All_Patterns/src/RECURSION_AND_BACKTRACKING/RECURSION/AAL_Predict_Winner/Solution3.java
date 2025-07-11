package RECURSION_AND_BACKTRACKING.RECURSION.AAL_Predict_Winner;

import java.util.*;

/**
 * Question link:
 * Date: 11-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution3 {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];

        // Base case: if i == j, player can take only one number
        for(int i=0 ; i<n ; i++){
            dp[i][i] = nums[i];
        }

        for (int len=2 ; len<=n ; len++){
            for (int i=0 ; i<=n-len ; i++){
                int j = i + len-1;

                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }
}