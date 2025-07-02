package TWO_POINTER.ON_ARRAYS.AAF_Sort_Colors;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/sort-colors/
 * Date: 30-06-2025
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("INPUT:: ");
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements: ");
        for(int i=0 ; i<n ; i++){
            nums[i] = sc.nextInt();
        }

        sortColors(nums);

        System.out.println("OUTPUT:: ");
        for(int i=0 ; i<n ; i++){
            System.out.print(nums[i] + ", ");
        }
    }

    public static void sortColors(int[] nums) {
        int red = 0, white = 0;

        for(int num : nums){
            if(num == 0) red++;
            else if(num == 1) white++;
        }

        int i = 0;

        for(; i<red; i++){
            nums[i] = 0;
        }

        for(; i<red+white ; i++){
            nums[i] = 1;
        }

        for(; i<nums.length; i++){
            nums[i] = 2;
        }
    }
}