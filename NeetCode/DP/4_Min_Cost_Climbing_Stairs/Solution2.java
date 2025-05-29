// Time complexity: O(n), Space complexity: O(n)

class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, -1);

        return recurse(len, cost, dp);
    }

    private int recurse(int n, int[] cost, int[] dp){
        if(n==0 || n==1){
            dp[n] = 0;
            return 0;
        }

        if(dp[n] != -1) return dp[n];

        int oneStep = recurse(n-1, cost, dp) + cost[n-1];
        int twoStep = recurse(n-2, cost, dp) + cost[n-2];
        dp[n] = Math.min(oneStep, twoStep);
        
        return dp[n];
    }
}
