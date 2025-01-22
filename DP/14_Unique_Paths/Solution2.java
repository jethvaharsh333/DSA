// Time complexity: O(n), Space complexity: O(n)

class Solution2 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0 ; i<m+1 ; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return recurse(m, n, dp);
    }

    private int recurse(int m, int n, int[][] dp){
        if(m==1 && n==1){
            dp[m][n] = 1;
            return 1;
        }

        if(m==0 || n==0){
            dp[m][n] = 0;
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        dp[m][n] = recurse(m-1, n, dp) + recurse(m, n-1, dp);
        return dp[m][n];
    }
}
