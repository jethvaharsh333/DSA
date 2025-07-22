package RECURSION_AND_BACKTRACKING.SUBSETS.AAB_Subsets_II;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/subsets-ii
 * Date: 20-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        genSubsets(nums, 0, currentList, result);

        return result;
    }

    private void genSubsets(int[] nums, int begin, List<Integer> currentList, List<List<Integer>> result){
        if(begin == nums.length){
            result.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(nums[begin]);
        genSubsets(nums, begin+1, currentList, result);
        currentList.remove(currentList.size()-1);

        while(begin+1 < nums.length && nums[begin+1]==nums[begin]) begin++;

        genSubsets(nums, begin+1, currentList, result);
    }
}