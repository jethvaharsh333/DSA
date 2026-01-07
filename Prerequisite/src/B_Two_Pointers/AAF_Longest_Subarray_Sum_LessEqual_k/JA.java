package B_Two_Pointers.AAF_Longest_Subarray_Sum_LessEqual_k;

public class JA {
    private static int longestSubarraySumLessEqualK(int[] nums, int k){
        int n = nums.length;

        int maxLen = 0;

        for(int i=0 ; i<n ; i++){
            int sum = 0;
            for(int j=i ; j<n ; j++){
                sum += nums[j];

                if(sum <= k)
                    maxLen = Math.max(maxLen, j-i+1);
            }
        }

        return maxLen;
    }
}
