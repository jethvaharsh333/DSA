package RECURSION_AND_BACKTRACKING.COMBINATION.AAB_Combinations;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return combinations(n, k, 1, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }

    private List<List<Integer>> combinations(int n, int k, int start, List<Integer> curr, List<List<Integer>> result){
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
            return result;
        }

        for(int i=start ; i<=n ; i++){
            curr.add(i);
            combinations(n, k, i+1, curr, result);
            curr.remove(curr.size()-1);
        }

        return result;
    }
}