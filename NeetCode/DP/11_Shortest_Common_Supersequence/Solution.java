// Time complexity: O(n*m), Space complexity: O(n*m)

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = longestCommonSubsequence(str1, str2);

        int n=dp.length, m=dp[0].length;
        int i=n-1, j=m-1;

        StringBuilder sb = new StringBuilder();

        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--; j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }

    public int[][] longestCommonSubsequence(String text1, String text2) {
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

        return dp;
    }
}
