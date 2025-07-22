package RECURSION_AND_BACKTRACKING.SUBSETS.AAD_The_Number_of_Beautiful_Subsets;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/the-number-of-beautiful-subsets
 * Date: 20-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    private HashMap<Integer, Integer> freq;

    public int beautifulSubsets(int[] nums, int k) {
        freq = new HashMap<Integer, Integer>();
        return beautifulSubsets(nums, k, 0) - 1;
    }

    private int beautifulSubsets(int[] nums, int k, int i) {
        if (i == nums.length) {
            return 1;
        }

        int result = beautifulSubsets(nums, k, i+1);

        if(!freq.containsKey(nums[i]-k) && !freq.containsKey(nums[i]+k)){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            result += beautifulSubsets(nums, k, i+1);

            freq.put(nums[i], freq.get(nums[i])-1);
            if(freq.get(nums[i]) == 0){
                freq.remove(nums[i]);
            }
        }

        return result;
    }
}

/*
[]                       i=0   freq={}              [initial call]
├── skip 2               i=1
│   ├── skip 4           i=2
│   │   ├── skip 6       i=3   freq={}              ✅ return 1; (empty subset ❌)
│   │   └── PICK** 6     i=3   freq={6:1}           ✅ return 1; \U0001f3af [6]
│   │       \U0001f519 backtrack       freq={}
│   │   result = 1 + 1 = 2                           \U0001f9ee [6]
│   └── PICK** 4         i=2   freq={4:1}
│       ├── skip 6       i=3   freq={4:1}           ✅ return 1; \U0001f3af [4]
│       └── PICK 6 ❌    i=3   freq={4:1}           ❌ skipped (4==6-2)
│       \U0001f519 backtrack     freq={}
│       result = 1 + 0(skipped) = 1                  \U0001f9ee [4]
│   result = 2 + 1 = 3
├── PICK** 2             i=1   freq={2:1}
│   ├── skip 4           i=2   freq={2:1}
│   │   ├── skip 6       i=3   freq={2:1}           ✅ return 1; \U0001f3af [2]
│   │   └── PICK** 6     i=3   freq={2:1,6:1}       ✅ return 1; \U0001f3af [2,6]
│   │       \U0001f519 backtrack freq={2:1}
│   │   result = 1 + 1 = 2
│   └── PICK 4 ❌        i=2   freq={2:1}           ❌ skipped (2==4-2)
│   \U0001f519 backtrack         freq={}
│   result = 2 + 0 = 2                              \U0001f9ee [2], [2,6]
result = 3 (from skip 2 path) + 2 (from pick 2 path) = 5

*/