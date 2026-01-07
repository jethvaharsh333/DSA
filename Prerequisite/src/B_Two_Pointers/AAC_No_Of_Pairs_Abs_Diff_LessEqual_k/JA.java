package B_Two_Pointers.AAC_No_Of_Pairs_Abs_Diff_LessEqual_k;

public class JA {
    private int NumberOfPairsAbsoluteDiffLessThanEqualK(int[] nums, int k){
        int n = nums.length;
        int count = 0;

        for(int i=0 ; i<n-1 ; i++){
            for(int j=i+1 ; j<n ; j++){
                int absDiff = Math.abs(nums[i]-nums[j]);
                if(absDiff <= k) count++;
            }
        }

        return count;
    }
}
