package DP.Two_Dimensional.AAA_Coin_Change_II;

public class Solution1 {
    public int change(int amount, int[] coins) {
        return recurse(0, amount, coins);
    }

    private int recurse(int index, int amount, int[] coins){
        if(index == coins.length-1){
            if(amount % coins[index] == 0) return 1;
            else return 0;
        }

        int noPick = recurse(index+1, amount, coins);
        int pick = 0;

        if(amount >= coins[index]){
            pick = recurse(index, amount-coins[index], coins);
        }

        return noPick+pick;
    }
}
