package RECURSION_AND_BACKTRACKING.COMBINATION.AAG_Combination_Sum_II;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/combination-sum-ii/
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        getC2(candidates, 0, target, new ArrayList<>(), result);

        return new ArrayList<>(result);
    }

    private void getC2(int[] candidates, int begin, int target, List<Integer> currList, HashSet<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(currList));
            return;
        }

        for(int i=begin ; i<candidates.length ; i++){
            if(i>begin && candidates[i]==candidates[i - 1]) continue;

            if(target >= candidates[i]){
                currList.add(candidates[i]);
                getC2(candidates, i+1, target-candidates[i], currList, result);
                currList.remove(currList.size() - 1);
            }
        }
    }
}

/*

[1,1,6] is OK at diff levels
root []
 └── 1 (index 0)
     └── 1 (index 1) ALLOWED! different depth
         └── 6 (index 4) → forms [1,1,6]

But this is not allowed:
root []
 └── 1 (index 0)
 └── 1 (index 1) NOT ALLOWED, same level, skip due to duplicate

*/