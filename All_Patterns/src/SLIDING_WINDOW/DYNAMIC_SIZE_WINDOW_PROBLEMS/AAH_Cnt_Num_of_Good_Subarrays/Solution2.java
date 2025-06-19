package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAH_Cnt_Num_of_Good_Subarrays;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/count-the-number-of-good-subarrays
 * Date: 19-06-2025
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input: Array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input: Value of x
        System.out.print("Enter the value of x: ");
        int x = sc.nextInt();

        long result = countGood(nums, x);
        System.out.println("Minimum operations to reduce x to zero: " + result);

        sc.close();
    }

    public static long countGood(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        long goodSubarrays = 0;
        int pairs = 0;
        int left = 0;

        for(int right=0 ; right<len ; right++){
            int curr = nums[right];

            int freq = map.getOrDefault(curr, 0);
            pairs += freq;
            map.put(curr, freq+1);

            while(pairs >= k){
                goodSubarrays += (len-right);

                int leftEle = nums[left];
                int freqLeft = map.get(leftEle);
                map.put(leftEle, freqLeft-1);
                pairs -= (freqLeft-1);

                left++;
            }
        }

        return goodSubarrays;
    }
}