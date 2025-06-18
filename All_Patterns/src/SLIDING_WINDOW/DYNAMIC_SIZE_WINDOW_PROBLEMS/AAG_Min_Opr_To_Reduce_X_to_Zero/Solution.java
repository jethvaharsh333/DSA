package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAG_Min_Opr_To_Reduce_X_to_Zero;

import java.util.Scanner;

public class Solution {
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

        int result = minOperations(nums, x);
        System.out.println("Minimum operations to reduce x to zero: " + result);

        sc.close();
    }

    public static int minOperations(int[] nums, int x) {
        int len = nums.length;

        int cost = 0;

        for(int element: nums){
            cost += element;
        }

        cost -= x;
        // System.out.println(" cost: " + cost);

        if(cost < 0){
            return -1;
        }

        int maxLength = -1;
        int left=0;
        int currentCost = 0;

        for(int right=0 ; right<len ; right++){
            currentCost += nums[right];
            // System.out.print(" , " + currentCost + ":add:" + nums[right]);

            while(currentCost > cost){
                currentCost -= nums[left];
                left++;
                // System.out.print(" , " + currentCost + ":remove:" + nums[left]);
            }

            if(currentCost == cost){
                maxLength = Math.max(maxLength, right-left+1);
                // System.out.print(" , " + currentCost + ":matched:" + maxLength);
            }

            // System.out.println();
        }

        return maxLength == -1 ? -1 : len-maxLength;
    }
}
