//  Time complexity: O(m*n), Space complexity: O(m*n)

class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(), m=text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0 ; i<=n ; i++){
            Arrays.fill(dp[i], -1);
        }
        return recurse(n, m, text1, text2, dp);
    }

    private int recurse(int i, int j, String text1, String text2, int[][] dp){
        if(i==0 || j==0){
            dp[i][j] = 0;
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            dp[i][j] = 1 + recurse(i-1, j-1, text1, text2, dp);
            return dp[i][j];
        }else{
            int left = recurse(i-1, j, text1, text2, dp);
            int right = recurse(i, j-1, text1, text2, dp);
            dp[i][j] = Math.max(left, right);
            return dp[i][j];
        }
    }
}
