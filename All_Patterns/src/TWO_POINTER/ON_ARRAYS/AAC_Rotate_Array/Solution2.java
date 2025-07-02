package TWO_POINTER.ON_ARRAYS.AAC_Rotate_Array;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/rotate-array
 * Date: 30-06-2025
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class Solution2 {
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
        int n = nums.length;
        k %= n;
        int[] temp = new int[n];

        for(int i=0 ; i<n ; i++){
            temp[(i+k) % n] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }
}

/*

❌ Mistake                     | \U0001f50d Why It Fails                                                                      |
----------------------------- | ------------------------------------------------------------------------------------ |
`int[] temp = new int[k];`     | ❌ Fails when `k > nums.length` — should use `k % len` and temp size must be safe      |
`for (i = k+1; i < len; i++)` | ❌ Wrong loop start. Why `k+1`? You should copy **last `k` elements**, not skip `k+1` |
`temp[i-k-1] = nums[i];`       | ❌ Broken logic — this ends up being invalid indexing for both `i` and `temp`          |
Not using `k = k % len`       | ❌ Major bug — will crash for `k > nums.length`                                       |
`nums[i] = nums[i - k];`      | ❌ Unsafe if `i - k < 0`                                                              |

*/