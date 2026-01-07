package B_Two_Pointers.AAA_No_Of_Subarray_Sum_LessEqual_K;

public class JB {
    private int SubArraySumLessEqualThanK(int[] nums, int k){
        int n = nums.length;
        int count=0, sum=0;

        for(int i=0,j=0 ; j<n ; j++){
            sum += nums[j];

            while(sum > k){
                sum -= nums[i];
                i++;
            }

            count += (j - i + 1);
        }

        return count;
    }
}
