// Time complexity: O(n), Space complexity: O(n)

class Solution2 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        
        int[] memo1 = new int[len];
        int[] memo2 = new int[len];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        
        return Math.max(robMemo(nums, 0, len-2, memo1), robMemo(nums, 1, len-1, memo2));
    }

    private int robMemo(int[] nums, int start, int end, int[] memo) {
        if(start > end) return 0;
        if(memo[start] != -1) return memo[start];
        
        memo[start] = Math.max(nums[start]+robMemo(nums, start+2, end, memo), robMemo(nums, start+1, end, memo));
        return memo[start];
    }
}
