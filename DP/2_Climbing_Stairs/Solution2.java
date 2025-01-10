// Time complexity: O(n), Space complexity: O(n) [TLE]

class Solution2 {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        int[] dp = Arrays.stream(new int[n+1]).map(e -> -1).toArray();

        return recurse(n, dp);
    }

    private int recurse(int n, int[] dp){
        if(n == 0) return 1;
        if(n == 1) return 1;

        if(dp[n] != -1) return dp[n];

        return recurse(n-1, dp) + recurse(n-2, dp);
    }
}
