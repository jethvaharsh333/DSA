// Time complexity: O(2^n), Space complexity: O(n) [Time limit exceeded]

class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        return recurse(cost.length, cost);
    }

    private int recurse(int n, int[] cost){
        if(n==0 || n==1) return 0;

        return Math.min(recurse(n-1, cost)+cost[n-1], recurse(n-2, cost)+cost[n-2]);
    }
}
