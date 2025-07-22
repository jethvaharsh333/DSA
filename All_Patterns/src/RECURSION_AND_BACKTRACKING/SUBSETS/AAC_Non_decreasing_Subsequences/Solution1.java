package RECURSION_AND_BACKTRACKING.SUBSETS.AAC_Non_decreasing_Subsequences;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/non-decreasing-subsequences
 * Date: 20-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        recurse(0, nums, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void recurse(int idx, int[] nums, List<Integer> curr, Set<List<Integer>> result){
        if(curr.size() >= 2){
            result.add(new ArrayList<>(curr));
        }

        for(int i=idx ; i<nums.length ; i++){
            if(curr.size()==0 || nums[i]>=curr.get(curr.size()-1)){
                curr.add(nums[i]);
                recurse(i+1, nums, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}