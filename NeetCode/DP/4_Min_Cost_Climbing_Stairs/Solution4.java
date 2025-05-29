// Time complexity: O(n), Space complexity: O(1)

class Solution4 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        
        int prev = 0;
        int prevOfPrev = 0;
        int ans = 0;

        for(int i=2 ; i<=len ; i++){
            int oneStep = prev + cost[i-1];
            int twoStep = prevOfPrev + cost[i-2];
            ans = Math.min(oneStep, twoStep);

            prevOfPrev = prev;
            prev = ans;
        }

        return ans;
    }
}
