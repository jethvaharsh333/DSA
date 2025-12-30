package DP.Two_Dimensional.AAA_Coin_Change_II;

public class Solution3 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n+1][amount+1];

        // By default dp[i][j] = 0, but for amount=0 => return 1 for the last index (here it is n)
        dp[n][0] = 1;

        for(int index=n-1 ; index>=0 ; index--){
            for(int amt=0 ; amt<=amount ; amt++){
                int noPick = dp[index+1][amt];

                int pick = 0;
                if(amt-coins[index] >= 0){
                    pick = dp[index][amt-coins[index]];
                }

                dp[index][amt] = noPick + pick;
            }
        }

        return dp[0][amount];
    }
}
