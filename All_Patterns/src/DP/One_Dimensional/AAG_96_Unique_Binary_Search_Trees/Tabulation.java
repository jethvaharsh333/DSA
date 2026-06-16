package DP.One_Dimensional.AAG_96_Unique_Binary_Search_Trees;

public class Tabulation {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1; dp[1]=1;

        for(int node=2 ; node<=n ; node++){
            int sum = 0;
            for(int i=1 ; i<=node ; i++){
                sum += dp[i-1] * dp[node-i];
            }
            dp[node] = sum;
        }

        return dp[n];
    }
}
