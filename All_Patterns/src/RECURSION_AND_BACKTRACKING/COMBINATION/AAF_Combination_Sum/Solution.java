package RECURSION_AND_BACKTRACKING.COMBINATION.AAF_Combination_Sum;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/combination-sum/
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        genC(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    private void genC(int[] candidates, int begin, int target, List<Integer> currentlist, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(currentlist));
            return;
        }

        for(int i=begin ; i<candidates.length ; i++){
            if(target-candidates[i] >= 0){
                currentlist.add(candidates[i]);
                genC(candidates, i, target-candidates[i], currentlist, result);
                currentlist.remove(currentlist.size()-1);
            }
        }
    }
}