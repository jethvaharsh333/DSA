// Time complexity: O(2^n), Space complexity: O(n) [Time limit exceeded]

class Solution1 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        
        return Math.max(robRecursive(nums, 0, len-2), robRecursive(nums, 1, len-1));
    }

    private int robRecursive(int[] nums, int start, int end) {
        if(start > end) return 0;

        return Math.max(nums[start]+robRecursive(nums, start+2, end), robRecursive(nums, start+1, end));
    }
}
