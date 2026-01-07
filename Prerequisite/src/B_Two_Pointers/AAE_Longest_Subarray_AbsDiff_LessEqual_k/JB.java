package B_Two_Pointers.AAE_Longest_Subarray_AbsDiff_LessEqual_k;

import java.util.ArrayDeque;
import java.util.Deque;

public class JB {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        int maxLen = 0;

        Deque<Integer> minDeque = new ArrayDeque<>(); // Monotonic storing indexes
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0;
        for(int right=0 ; right<n ; right++){
            int curr = nums[right];

            while(!minDeque.isEmpty() && nums[minDeque.peekLast()] > curr){
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < curr){
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            while(nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit){
                if(maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if(minDeque.peekFirst() == left) minDeque.pollFirst();

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
