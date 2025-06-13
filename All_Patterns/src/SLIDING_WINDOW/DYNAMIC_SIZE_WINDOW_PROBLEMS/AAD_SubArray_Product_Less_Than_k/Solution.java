package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAD_SubArray_Product_Less_Than_k;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            System.out.print("Enter element: ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int ans = numSubarrayProductLessThanK(arr, k);
        System.out.println("ans: " + ans);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;

        int product = 1;
        int left = 0;
        int count = 0;

        for(int right=0 ; right<nums.length ; right++){
            product *= nums[right];

            while(product >= k){
                product /= nums[left++];
            }

            count += right-left+1;
        }

        return count;
    }
}
