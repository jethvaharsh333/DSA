package RECURSION_AND_BACKTRACKING.SUBSETS.AAA_Subsets;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/subsets
 * Date: 20-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        genSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void genSubsets(int[] nums, int begin, List<Integer> currentList, List<List<Integer>> result){
        result.add(new ArrayList<>(currentList));

        for(int i=begin ; i<nums.length ; i++){
            currentList.add(nums[i]);
            genSubsets(nums, i+1, currentList, result);
            currentList.remove(currentList.size()-1);
        }

        return;
    }
}