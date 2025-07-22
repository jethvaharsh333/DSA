package RECURSION_AND_BACKTRACKING.SUBSETS.AAA_Subsets;

import java.util.*;

/**
 * Question link:
 * Date: 21-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = generate(nums, nums.length, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
        res.add(new ArrayList<>());
        return res;
    }

    private List<List<Integer>> generate(int[] nums, int len, int start, List<Integer> curr, List<List<Integer>> result){
        for(int i=start ; i<len ; i++){
            curr.add(nums[i]);
            result.add(new ArrayList<>(curr));
            generate(nums, len, i+1, curr, result);
            curr.remove(curr.size() - 1);
        }

        return result;
    }
}