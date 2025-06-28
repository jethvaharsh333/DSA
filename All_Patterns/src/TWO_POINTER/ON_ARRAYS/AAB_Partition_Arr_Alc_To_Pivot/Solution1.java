package TWO_POINTER.ON_ARRAYS.AAB_Partition_Arr_Alc_To_Pivot;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/partition-array-according-to-given-pivot
 * Date: 28-06-2025
 * Time complexity: O(n) - We loop through the array 3 times.
 * Space complexity: O(n) - We use a new array to store the result.
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter pivot value: ");
        int pivot = sc.nextInt();

        int[] res = pivotArray(nums, pivot);

        System.out.println("Partitioned array:");
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] arr = new int[nums.length];
        int len = nums.length;
        int p = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] < pivot) {
                arr[p++] = nums[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] == pivot) {
                arr[p++] = nums[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > pivot) {
                arr[p++] = nums[i];
            }
        }

        return arr;
    }
}