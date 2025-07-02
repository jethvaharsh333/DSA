package TWO_POINTER.ON_ARRAYS.AAD_Two_Sum;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/two-sum/
 * Date: 30-06-2025
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        int[] result = twoSum(nums, k);

        if (result != null) {
            System.out.println("Indices: " + result[0] + " " + result[1]);
        } else {
            System.out.println("No valid pair found.");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=1 ; i<nums.length ; i++){
            for (int j = i; j < nums.length; j++) {
                if (target == nums[j] + nums[j - i]) {
                    return new int[]{j, j-i};
                }
            }
        }
        return null;
    }
}