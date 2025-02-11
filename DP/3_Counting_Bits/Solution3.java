// Time complexity: O(n), Space complexity: O(n)

class Solution3 {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        for(int i=0 ; i<=n ; i++){
            dp[i] = dp[i>>1] + (i&1);
        } 

        return dp;
    }
}
