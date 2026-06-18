package DP.One_Dimensional.AAI_740_Delete_and_Earn;

public class Tabulation {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums) max = Math.max(max, num);

        int[] sum = new int[max+1];
        for(int num: nums) sum[num] += num;

        if(max == 0) return 0;

        int[] dp = new int[max+1];
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);

        for(int i=2 ; i<=max ; i++){
            int pick = sum[i] + dp[i-2];
            int noPick = dp[i-1];

            dp[i] = Math.max(pick, noPick);
        }

        return dp[max];
    }
}
