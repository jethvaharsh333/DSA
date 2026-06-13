package DP.One_Dimensional.AAE_279_Perfect_Squares;

public class DP {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1 ; i<=n ; i++){
            int min = Integer.MAX_VALUE;

            for(int j=1 ; j*j<=i ; j++){
                int remainder = i - j*j;
                min = Math.min(min, dp[remainder]);
            }

            dp[i] = 1 + min;
        }

        return dp[n];
    }
}
