package SLIDING_WINDOW.DYNAMIC_SIZE_WINDOW_PROBLEMS.AAF_Freq_Of_Most_Freq_Ele;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
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
        Arrays.sort(nums);

        int len = nums.length;
        if(len == 0){
            return 0;
        }

        int maxLength = 1;

        for(int i=len-1 ; i>=0 ; i--){
            int diff = nums[i];
            int tempK = k;
            // System.out.print(nums[i] + ", ");

            for(int j=i-1 ; j>=0 ; j--){
                diff = nums[i]-nums[j];
                tempK -= diff;

                if(tempK >= 0){
                    maxLength = Math.max(maxLength, i-j+1);
                }
                if(tempK <= 0){
                    break;
                }
                // System.out.print(nums[j] + ":" + diff + ", ");
            }
            // System.out.println();
        }

        return maxLength;
    }

}
