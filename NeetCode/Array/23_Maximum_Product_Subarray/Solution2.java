// Time complexity: O(n); Space Complexity: O(1)
class Solution2 {
    public int maxProduct(int[] nums) {
        int max = nums[0], currMax = 1, reverse=1;

        for(int ele : nums){
            currMax = currMax*ele;
            max = Math.max(max, currMax);
            max = Math.max(max, ele);
            if(ele==0) currMax=1; // Handles zero if came as an element
        }
        
        // Checking for reverse product
        for(int i=nums.length-1 ; i>=0 ; i--){
            reverse *= nums[i];
            max = Math.max(max, reverse);
            if(nums[i]==0) reverse=1;
        }

        return max;
    }
}

/*
Both solutions achieve the same time and space complexity (O(n) and O(1)), but this solution is slightly more efficient in readability 
as it separates forward and reverse passes rather than handling both in a single loop. This may improve clarity, though performance-wise,
the difference is minimal.
*/
