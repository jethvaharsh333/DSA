// Time complexity: O(n), Space complexity: O(n)

class Solution3 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=2 ; i<len+1 ; i++){
            int pick = dp[i-2] + nums[i-1];
            int noPick = dp[i-1] ;
            dp[i] = Math.max(pick, noPick);
        }

        return dp[len];
    }
}
