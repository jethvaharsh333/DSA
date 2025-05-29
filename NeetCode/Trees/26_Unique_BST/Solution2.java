// Time complexity: O(n^2), Space complexity: O(n)
class Solution2 {
    public int numTrees(int n) {
        int[]arr = new int[n+1];
        Arrays.fill(arr,-1);
        return numTrees(n, arr);
    }

    public int numTrees(int n, int[]dp){
       if(n <= 1) return 1;
       if(dp[n] != -1) return dp[n];

        int ans = 0;

        for(int i=0 ; i<n ; i++){
            ans += numTrees(i, dp)*numTrees(n-i-1, dp);
        }

        return dp[n]=ans;
    }
}
