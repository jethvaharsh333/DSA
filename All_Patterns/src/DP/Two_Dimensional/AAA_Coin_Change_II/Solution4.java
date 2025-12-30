package DP.Two_Dimensional.AAA_Coin_Change_II;

public class Solution4 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount + 1];

        // 1 way to make 0
        prev[0] = 1;

        for(int coin: coins){
            for(int amt=coin ; amt<=amount ; amt++){
                prev[amt] += prev[amt-coin];
            }
        }

        return prev[amount];
    }
}
