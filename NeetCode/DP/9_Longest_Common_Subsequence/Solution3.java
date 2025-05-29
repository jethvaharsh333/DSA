// Time complexity: O(m*n), Space complexity: O(m*n)

class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(), m=text2.length();
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;

        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int left = dp[i-1][j];
                    int right = dp[i][j-1];
                    dp[i][j] = Math.max(left, right);
                }
            }    
        }

        return dp[n][m];
    }
}
