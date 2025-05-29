// Time complexity: O(n), Space complexity: O(n)

class Solution3 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 0;

        for(int i=2 ; i<=len ; i++){
            int oneStep = dp[i-1] + cost[i-1];
            int twoStep = dp[i-2] + cost[i-2];
            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[len];
    }
}
