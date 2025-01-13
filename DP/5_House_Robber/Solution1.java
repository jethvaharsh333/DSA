// Time complexity: O(2^n), Space complexity: O(n) [Time limit exceeded]

class Solution1 {
    public int rob(int[] nums) {
        return recurse(nums, nums.length-1);
    }

    private int recurse(int[] nums, int i){
        if(i == 0) return nums[0];
        if(i == -1) return 0;

        int pick = recurse(nums, i-2)+nums[i];
        int noPick = recurse(nums, i-1);

        return Math.max(pick, noPick);
    } 
}
