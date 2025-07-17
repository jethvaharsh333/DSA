package RECURSION_AND_BACKTRACKING.PERMUTATION.AAC_Beautiful_Arrangement;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution3 {
    int count = 0;

    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;

        permute(nums, 0);
        return count;
    }

    private void permute(int[] nums, int index) {
        if (index == nums.length) {
            count++;
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int pos = index + 1;
            if (nums[i] % pos == 0 || pos % nums[i] == 0) {
                swap(nums, i, index);
                permute(nums, index + 1);
                swap(nums, i, index); // backtrack
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}