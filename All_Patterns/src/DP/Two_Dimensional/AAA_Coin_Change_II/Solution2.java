package DP.Two_Dimensional.AAA_Coin_Change_II;

import java.util.Arrays;

public class Solution2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] memo = new int[n][amount+1];
        for(int i=0 ; i<n ; i++) Arrays.fill(memo[i], -1);

        return recurse(0, amount, coins, memo);
    }

    private int recurse(int index, int amount, int[] coins, int[][] memo){
        if(index == coins.length-1){
            if(amount % coins[index] == 0) return 1;
            else return 0;
        }

        if(memo[index][amount] != -1) return memo[index][amount];

        int noPick = recurse(index+1, amount, coins, memo);
        int pick = 0;

        if(amount >= coins[index]){
            pick = recurse(index, amount-coins[index], coins, memo);
        }

        return memo[index][amount] = noPick+pick;
    }
}
