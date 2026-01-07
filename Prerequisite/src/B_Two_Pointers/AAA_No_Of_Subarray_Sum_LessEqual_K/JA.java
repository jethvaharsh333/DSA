package B_Two_Pointers.AAA_No_Of_Subarray_Sum_LessEqual_K;

public class JA {
    private int SubArraySumLessEqualThanK(int[] nums, int k){
        int n = nums.length;
        int count = 0;

        for(int i=0 ; i<n ; i++){
            long sum = 0;
            for(int j=i ; j<n ; j++){
                sum += nums[j];
                if (sum <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}
