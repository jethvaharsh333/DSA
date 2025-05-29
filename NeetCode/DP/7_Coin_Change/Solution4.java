// Time complexity: O(n), Space complexity: O(amount)

class Solution4 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];

        for(int a=0 ; a<amount+1 ; a++){
            if(a % coins[0] == 0){
                prev[a] = a/coins[0];
            }else{
                prev[a] = (int)(1e9);
            }
        }

        for(int i=1 ; i<n ; i++){
            int[] curr = new int[amount+1];
            for(int a=0 ; a<amount+1 ; a++){
                int pick = (int)(1e9);
                if(a >= coins[i]){
                    pick = 1 + curr[a-coins[i]]; //recurse(coins, a-coins[i], i, dp);
                }

                int noPick = prev[a]; //recurse(coins, a, i-1, dp);
                curr[a] =  Math.min(pick, noPick);
            }
            prev = curr;
        }

        if(prev[amount] == (int)(1e9)){
            return -1;
        }

        return prev[amount];
    }
}
