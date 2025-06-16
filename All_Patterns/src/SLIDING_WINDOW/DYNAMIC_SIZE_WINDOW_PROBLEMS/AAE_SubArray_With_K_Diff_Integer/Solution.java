package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAE_SubArray_With_K_Diff_Integer;

/*
* https://leetcode.com/problems/subarrays-with-k-different-integers/
* */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        int result = subarraysWithKDistinct(nums, k);
        System.out.println("Number of subarrays with " + k + " distinct integers: " + result);
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int res=0, sz=nums.length;
        int[] cnt = new int[sz+1];

        for(int l=0,m=0,r=0 ; r<sz ; ++r){
            if(++cnt[nums[r]] == 1){
                if(--k < 0){
                    cnt[nums[m++]] = 0;
                    l = m;
                }
            }
            if(k <= 0){
                while(cnt[nums[m]] > 1){
                    --cnt[nums[m++]];
                }
                res += m-l+1;
            }
        }

        return res;
    }

}
