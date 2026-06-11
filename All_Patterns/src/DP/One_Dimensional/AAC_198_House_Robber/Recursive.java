package DP.One_Dimensional.AAC_198_House_Robber;

public class Recursive {
    public int rob(int[] nums) {
        return recurse(nums.length-1, nums);
    }

    public int recurse(int index, int[] nums){
        if(index < 0) return 0;
        if(index == 0) return nums[index];

        int pick = nums[index] + recurse(index-2, nums);
        int noPick = recurse(index-1, nums);

        return Math.max(pick, noPick);
    }
}
