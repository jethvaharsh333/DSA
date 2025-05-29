// Time complexity: O(n*m), Space complexity: O(m)

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        return longestCommonSubsequence(s, str.reverse().toString());
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(), m=text2.length();
        int[] prev = new int[m+1];
        prev[0] = 0;

        for(int i=1 ; i<=n ; i++){
            int[] curr = new int[m+1];
            curr[0] = 0;
            for(int j=1 ; j<=m ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    int left = prev[j];
                    int right = curr[j-1];
                    curr[j] = Math.max(left, right);
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}
