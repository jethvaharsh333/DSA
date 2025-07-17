package RECURSION_AND_BACKTRACKING.PERMUTATION.AAA_Permutations;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);         // Swap current element with the start
            backtrack(nums, start + 1, result); // Recurse with the next start index
            swap(nums, start, i);         // Backtrack (undo the swap)
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}