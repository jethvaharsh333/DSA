package DP.One_Dimensional.AAI_740_Delete_and_Earn;

public class Recursive {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums) max = Math.max(max, num);

        int[] sum = new int[max+1];
        for(int num: nums) sum[num] += num;

        return recurse(max, sum);
    }

    public int recurse(int index, int[] sum){
        if(index < 0) return 0;

        int pick = recurse(index-2, sum) + sum[index];
        int noPick = recurse(index-1, sum);

        return Math.max(pick, noPick);
    }
}
