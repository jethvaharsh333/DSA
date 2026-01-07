package B_Two_Pointers.AAE_Longest_Subarray_AbsDiff_LessEqual_k;

import java.util.ArrayDeque;
import java.util.Deque;

public class JA {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        int maxLen = 0;
        Deque<Integer> minDeque = new ArrayDeque<>(); // monotonic storing values of array
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0;
        for(int right=0 ; right<n ; right++){
            int curr = nums[right];

            while(!minDeque.isEmpty() && minDeque.peekLast() > curr){
                minDeque.pollLast();
            }
            minDeque.addLast(curr);

            while(!maxDeque.isEmpty() && maxDeque.peekLast() < curr){
                maxDeque.pollLast();
            }
            maxDeque.addLast(curr);

            while(maxDeque.peekFirst() - minDeque.peekFirst() > limit){
                if(maxDeque.peekFirst() == nums[left]) maxDeque.pollFirst();
                if(minDeque.peekFirst() == nums[left]) minDeque.pollFirst();

                left += 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
