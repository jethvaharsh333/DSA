package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAI_Num_Of_SubArray_With_Bounded_Maximum;

import java.util.Scanner;

/**
* Question link: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
* Date: 20-06-2025
* Time complexity: O(n)
* Space complexity: O(1)
*/

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter left bound: ");
        int left = sc.nextInt();

        System.out.print("Enter right bound: ");
        int right = sc.nextInt();

        int result = numSubarrayBoundedMax(nums, left, right);
        System.out.println("Number of valid subarrays: " + result);

        sc.close();
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int lastValid = -1;   // index of last valid max (in [left, right])
        int start = -1;   // index where value > right (invalid)

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]>=left && nums[i]<=right){
                lastValid = i;
            }

            if(nums[i] > right){
                start = i;
            }

            res += Math.max(0, (lastValid-start));
        }

        return res;
    }
    
}