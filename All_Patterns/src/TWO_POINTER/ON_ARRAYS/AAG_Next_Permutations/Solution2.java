package TWO_POINTER.ON_ARRAYS.AAG_Next_Permutations;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/next-permutation/
 * Date: 25-06-2025
 * Time complexity: O(n)
 *      - One pass to find the dip
 *      - One pass to find the element to swap
 *      - One pass to reverse
 * Space complexity: O(1)
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        nextPermutation(nums);

        for(int x: nums){
            System.out.print(x + ", ");
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        for(int i=n-2 ; i>=0 ; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1 ; i>index ; i--){
            if(nums[index] < nums[i]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        reverse(nums, index+1, n-1);
    }

    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}