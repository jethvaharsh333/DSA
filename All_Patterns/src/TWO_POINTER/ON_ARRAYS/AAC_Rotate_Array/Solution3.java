package TWO_POINTER.ON_ARRAYS.AAC_Rotate_Array;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/rotate-array/
 * Date: 30-06-2025
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class Solution3 {
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
        int[] res = new int[nums.length];
        k = k % nums.length;
        int n = nums.length;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private static void reverse(int[] nums, int left, int right){
        while(left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}

/*

| Method                | Time Complexity | Space Complexity | Notes               |
| --------------------- | --------------- | ---------------- | ------------------- |
| Extra k-sized array   | ✅ O(n)         | ❗ O(k)         | Good, readable      |
| Full temp array       | ✅ O(n)         | ❗ O(n)         | Cleanest code       |
| Reverse (in-place)    | ✅ O(n)         | ✅ O(1)         | Best for interviews |

*/