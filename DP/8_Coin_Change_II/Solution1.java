// Time complexity: O(n×amount), Space complexity: O(amount)

class Solution1 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];

        for(int a=0 ; a<amount+1 ; a++){
            if(a % coins[0] == 0){
                prev[a] = 1;
            }else{
                prev[a] = 0;
            }
        }

        for(int i=1 ; i<n ; i++){
            int[] curr = new int[amount+1];
            for(int a=0 ; a<amount+1 ; a++){
                int pick = 0;
                if(a >= coins[i]){
                    pick = curr[a-coins[i]];
                }

                int noPick = prev[a];
                curr[a] = pick + noPick;
            }
            prev = curr;
        }

        return prev[amount];
    }
}
