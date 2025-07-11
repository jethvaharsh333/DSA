package RECURSION_AND_BACKTRACKING.RECURSION.AAL_Predict_Winner;

/**
 * Question link: https://leetcode.com/problems/predict-the-winner/description/
 * Date: 11-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public boolean predictTheWinner(int[] nums) {
        return recurse(0, nums.length - 1, nums) >= 0;
    }

    private int recurse(int start, int end, int[] nums){
        if (start == end) return nums[start];

        int pickStart = nums[start] - recurse(start+1, end, nums);
        int pickEnd = nums[end] - recurse(start, end-1, nums);

        return Math.max(pickStart, pickEnd);
    }
}