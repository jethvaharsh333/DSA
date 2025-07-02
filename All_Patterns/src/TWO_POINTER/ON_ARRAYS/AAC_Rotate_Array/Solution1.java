package TWO_POINTER.ON_ARRAYS.AAC_Rotate_Array;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/rotate-array/
 * Date: 30-06-2025
 * Time complexity: O(n)
 * Space complexity: O(k)
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k (rotation steps): ");
        int k = sc.nextInt();

        rotate(nums, k);

        System.out.println("Rotated array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int[] temp = new int[k];

        for(int i=0 ; i<k ; i++){
            temp[i] = nums[len-k+i];  // Don't like i+k+1... as we are storing elements of backwards so len-k+i
        }

        for(int i=len-k-1 ; i>=0 ; i--){  // Always shift backward to avoid loss
            nums[i+k] = nums[i];
        }

        for(int i=0 ; i<k ; i++){
            nums[i] = temp[i];
        }
    }

}