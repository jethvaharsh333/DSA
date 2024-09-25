class Solution1 {
    public int fib(int n) {
        int[] dp = Arrays.stream(new int[n+1]).map(e -> -1).toArray();
        return fib(n, dp);
    }

    private int fib(int n, int[] dp){
        if(n <= 2)
            return n == 0 ? 0 : 1;

        if(dp[n] != -1)
            return dp[n];

        dp[n] = fib(n-1,dp) + fib(n-2,dp);
        return dp[n];
    }
}
