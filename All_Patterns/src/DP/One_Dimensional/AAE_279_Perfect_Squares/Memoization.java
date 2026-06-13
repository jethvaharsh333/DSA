package DP.One_Dimensional.AAE_279_Perfect_Squares;

import java.util.Arrays;

public class Memoization {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return count(n, dp);
    }

    private int count(int n, int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;
        for(int i=1 ; i*i<=n ; i++){
            ans = Math.min(ans, 1 + count(n-i*i, dp));
        }

        dp[n] = ans;
        return dp[n];
    }

}
