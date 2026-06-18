package DP.One_Dimensional.AAI_740_Delete_and_Earn;

import java.util.Arrays;

public class Memoization {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums) max = Math.max(max, num);

        int[] sum = new int[max+1];
        for(int num: nums) sum[num] += num;

        int[] memo = new int[max+1];
        Arrays.fill(memo, -1);

        return recurse(max, sum, memo);
    }

    public int recurse(int index, int[] sum, int[] memo){
        if(index < 0) return 0;
        if(memo[index] != -1) return memo[index];

        int pick = sum[index] + recurse(index-2, sum, memo);
        int noPick = recurse(index-1, sum, memo);

        return memo[index] = Math.max(pick, noPick);
    }
}
