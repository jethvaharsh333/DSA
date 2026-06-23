package DP.One_Dimensional.AAK_413_Arithmetic_Slices;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;

        int curr=0, result=0;
        for(int i=2 ; i<n ; i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                curr += 1;
                result += curr;
            }else{
                curr = 0;
            }
        }

        return result;
    }
}
