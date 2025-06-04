package Sliding_Window.AAF_Max_Avg_SubArray_I;

/*
* https://leetcode.com/problems/maximum-average-subarray-i/
* */

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array");
        for(int i=0 ; i<arr.length ; i++){
            System.out.print("Enter element: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Output: " + findMaxAverage(arr, k));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;

        for(int i=0 ; i<k ; i++){
            sum += nums[i];
        }

        double avg = (double)sum/k;

        for(int i=k ; i<len ; i++){
            sum -= nums[i-k];
            sum += nums[i];

            avg = Math.max(avg, (double)sum/k);
        }

        return avg;
    }
}
