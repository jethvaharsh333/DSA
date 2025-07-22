package RECURSION_AND_BACKTRACKING.COMBINATION.AAH_Combination_Sum_III;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/combination-sum-iii/
 * Date: 18-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        genCombinations(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void genCombinations(int start, int k, int target, List<Integer> current, List<List<Integer>> result){
        if(target==0 && current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=start ; i<10 ; i++){
            if(target-i >= 0){
                current.add(i);
                genCombinations(i+1, k, target-i, current, result);
                current.remove(current.size()-1);
            }
        }
    }
}