package RECURSION_AND_BACKTRACKING.SUBSETS.AAC_Non_decreasing_Subsequences;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/non-decreasing-subsequences/
 * Date: 20-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recurse(0, nums, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void recurse(int idx, int[] nums, List<Integer> curr, List<List<Integer>> result){
        if(curr.size() >= 2){
            result.add(new ArrayList<>(curr));
        }

        HashSet<Integer> used = new HashSet<>();

        for(int i=idx ; i<nums.length ; i++){
            if(used.contains(nums[i])) continue;
            if(curr.size()==0 || nums[i]>=curr.get(curr.size()-1)){
                used.add(nums[i]);
                curr.add(nums[i]);
                recurse(i+1, nums, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

/*

[]
├── 4
│   ├── 6           => Correct => [4,6]
│   │   ├── 7       => Correct => [4,6,7]
|   |   |   ├── 7   => Correct => [4,6,7,7]
│   │   └── 7       => Wrong [4,6,7] => duplicate
│   └── 7           => Correct => [4,7]
...

*/