package B_Two_Pointers.AAC_No_Of_Pairs_Abs_Diff_LessEqual_k;

import java.util.Arrays;

public class JB {
    private int NumberOfPairsAbsoluteDiffLessThanEqualK(int[] nums, int k){
        int n = nums.length;
        int count=0, sum=0;

        Arrays.sort(nums);

        for(int i=0,j=0 ; j<n ; j++){
            int diff = nums[j]-nums[i]; // No need abs because this is sorted now

            while(diff > k){
                i++;
                diff = nums[j] - nums[i];
            }

            count += (j-i+1);
        }

        return count;
    }
}
