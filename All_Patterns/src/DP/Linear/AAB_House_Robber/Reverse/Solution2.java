package DP.Linear.AAB_House_Robber.Reverse;

import java.util.*;

/**
 * Question link:
 * Date: 06-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int rob(int[] nums) {
        int[] store = new int[nums.length+1];
        Arrays.fill(store, -1);

        return recurse(0, nums, store);
    }

    private int recurse(int idx, int[] nums, int[] store){
        if(idx >= nums.length){
            return 0;
        }

        if(store[idx] != -1) return store[idx];

        return store[idx] = Math.max(recurse(idx+1, nums, store), nums[idx] + recurse(idx+2, nums, store));
    }
}