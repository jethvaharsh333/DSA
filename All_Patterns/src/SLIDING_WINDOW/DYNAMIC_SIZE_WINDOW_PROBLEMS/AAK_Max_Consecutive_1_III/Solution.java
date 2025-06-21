package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAK_Max_Consecutive_1_III;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/max-consecutive-ones-iii/
 * Date: 21-06-2025
 * Time complexity: O(n) — each element is visited at most twice
 * Space complexity: O(1) — only pointers and simple vars used
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.print("Enter binary elements (0 or 1): ");
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of allowed flips (k): ");
        int k = sc.nextInt();

        Solution obj = new Solution();
        int result = obj.longestOnes(nums, k);
        System.out.println("Maximum consecutive 1s after flipping at most " + k + " zero(s): " + result);

        sc.close();
    }

    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int left=0;
        int maxLength = 0;

        for(int right=0 ; right<len ; right++){
            if(nums[right] == 0){
                k--;
            }

            while(k < 0){
                if(nums[left] == 0){
                    k++;
                }

                left++;
            }

            maxLength = Math.max(maxLength , right-left+1);
        }

        return maxLength;
    }
}