package B_Two_Pointers.AAD_No_Of_Subarray_Sum_GreaterEqual_K;

public class JA {

    // count of subarrays whose sum>=k = total subarrays - count of subarrays whose sum<k
    private int SubArraySumGreaterEqualThanK(int[] nums, int k){
        int n = nums.length;
        int count=0, sum=0;

        for(int i=0,j=0 ; j<n ; j++){
            sum += nums[j];

            while(sum >= k){
                sum -= nums[i];
                i++;
            }

            count += (j - i + 1);
        }

        int totalSubArray = n*(n+1)/2;

        return totalSubArray-count;
    }
}
