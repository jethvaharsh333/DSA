// Time complexity: O(n); Space Complexity: O(1)

/*
When the goal involves calculating sums, products, or properties like distinct elements within a subarray, and you need to continuously move 
forward, sliding windows can be efficient. But if there’s no fixed size or condition to maintain, Kadane’s approach, as used in maxSubArray, works best
*/

class Solution1 {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i=1 ; i<nums.length ; i++){
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

/*
We used Kadane's Algorithm to solve this by iterating through each element, calculating the maximum sum that can be achieved at each index,
and keeping track of the overall maximum sum.
*/
