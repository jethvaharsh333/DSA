package B_Two_Pointers.AAD_No_Of_Subarray_Sum_GreaterEqual_K;

public class JB {
    private int SubArraySumGreaterEqualThanK(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        int sum = 0;

        for(int i=0,j=0 ; i<n ; i++){
            while(j<n && sum<k){
                j++;
            }

            if(sum >= k)
                count += (j-i+1);

            sum -= nums[i]; //move i forward
        }


        return count;

    }
}
