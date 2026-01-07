package B_Two_Pointers.AAF_Longest_Subarray_Sum_LessEqual_k;

public class JB {
    private static int longestSubarraySumLessEqualK(int[] nums, int k){
        int n = nums.length;

        int maxLen = 0;
        int sum = 0;

        for(int i=0,j=0 ; j<n ; j++){
            sum += nums[j];

            while(sum > k){
                sum -= nums[i];
                i--;
            }

            maxLen = Math.max(maxLen, j-i+1);
        }

        return maxLen;
    }
}
