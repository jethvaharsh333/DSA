package DP.One_Dimensional.AAF_91_Decode_Ways;

public class Tabulation {
    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int i=n-1 ; i>=0 ; i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }
            else{
                int ways = dp[i+1];

                if(i < n-1){
                    int twoDigit = (s.charAt(i)-'0')*10 + s.charAt(i+1)-'0';

                    if(twoDigit>9 && twoDigit<27){
                        ways += dp[i+2];
                    }
                }

                dp[i] = ways;
            }
        }

        return dp[0];
    }
}
