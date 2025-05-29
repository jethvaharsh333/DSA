// Time complexity: O(n), Space complexity: O(n)

class Solution2 {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        return canReach(nums, 0, dp);
    }

    private boolean canReach(int[] nums, int index, int[] dp) {
        if(dp[index] != 0){
            return dp[index] == 1;
        }
        
        if(index >= nums.length-1){
            return true;
        }

        int nextJump = Math.min(index+nums[index], nums.length-1);
        
        for(int nextPosition=index+1 ; nextPosition<=nextJump ; nextPosition++){
            if(canReach(nums, nextPosition, dp)){
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = -1;
        return false;
    }
}
