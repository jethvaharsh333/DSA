package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAF_Freq_Of_Most_Freq_Ele;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++){
            System.out.print("Enter element: ");
            arr[i] = sc.nextInt();
        }

        int ans = maxFrequency(arr, k);
        System.out.println("Answer: " + ans);
    }

    public static int maxFrequency(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);

        int len = nums.length;

        int maxFreq = 1;
        long total = 0;
        int left = 0;

        for(int right=0 ; right<len ; right++){
            total += nums[right];
            long cost = (long) nums[right] * (right-left+1);

            while((cost-total) > k){
                total -= nums[left];
                left++;
                cost = (long) nums[right] * (right-left+1);
            }

            maxFreq = Math.max(maxFreq, right-left+1);
        }

        return maxFreq;
    }
}
