// Time complexity: O(n^2), Space complexity: O(n)

class Solution3 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=0 ; i<n ; i++){
            for(int j=1 ; j<=nums[i] && i+j<n ; j++){
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }

        return dp[n-1];
    }
}
