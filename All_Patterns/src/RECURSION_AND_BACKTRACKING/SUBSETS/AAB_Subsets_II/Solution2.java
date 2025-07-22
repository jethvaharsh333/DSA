package RECURSION_AND_BACKTRACKING.SUBSETS.AAB_Subsets_II;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/subsets-ii
 * Date: 20-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        genSubsets(nums, 0, new ArrayList<>(), result);

        return new ArrayList<>(result);
    }

    private void genSubsets(int[] nums, int begin, List<Integer> currentList, HashSet<List<Integer>> result){
        result.add(new ArrayList<>(currentList));
        for (int i=begin ; i<nums.length ; i++){
            currentList.add(nums[i]);
            genSubsets(nums, i + 1, currentList, result);
            currentList.remove(currentList.size() - 1);
        }
    }
}