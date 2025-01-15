// Time complexity: O(2^n), Space complexity: O(n) [Time limit exceeded]

class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int res = recurse(coins, amount, n-1);

        if(res == (int)(1e9)){
            return -1;
        }

        return res;
    }

    public int recurse(int[] coins, int amount, int index){
        if(index == 0){
            if(amount % coins[index] == 0){
                return amount/coins[index];
            }
            return (int)(1e9);
        }

        int pick = (int)(1e9);
        if(amount >= coins[index]){
            pick = 1 + recurse(coins, amount-coins[index], index);
        }

        int noPick = recurse(coins, amount, index-1);
        return Math.min(pick, noPick);
    }
}
