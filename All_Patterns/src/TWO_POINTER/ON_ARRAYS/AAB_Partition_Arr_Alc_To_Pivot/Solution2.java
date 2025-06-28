package TWO_POINTER.ON_ARRAYS.AAB_Partition_Arr_Alc_To_Pivot;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/partition-array-according-to-given-pivot/
 * Date: 28-06-2025
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class Solution2 {
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
        int len = nums.length;
        int left = 0, right = nums.length - 1;
        int result[] = new int[len];

        for (int i = 0, j = len - 1; i < len; i++, j--) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }

            if (nums[j] > pivot) {
                result[right--] = nums[j];
            }
        }

        while (left <= right) {
            result[left++] = pivot;
        }

        return result;
    }
}