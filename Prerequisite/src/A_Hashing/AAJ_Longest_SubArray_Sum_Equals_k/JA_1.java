package A_Hashing.AAJ_Longest_SubArray_Sum_Equals_k;

import java.util.Scanner;

public class JA_1 {
    public static void main(String[] args) {
        // INPUT
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        // LOGIC
        int[] result = largestSubArraySumK(arr, k);
        if (result[0] != -1) {
            System.out.println("Largest subarray with sum " + k + " is from index " + result[0] + " to " + result[1]);
        } else {
            System.out.println("No subarray with sum " + k);
        }
    }

    public static int[] largestSubArraySumK(int[] arr, int k){
        int n = arr.length;
        int[] result = {-1, -1};
        int maxLen = 0;

        for(int i=0 ; i<n ; i++){
            int currentSum = 0;
            for(int j=i ; j<n ; j++){
                currentSum += arr[j];

                if(currentSum==k && maxLen<(j-i+1)){
                    maxLen = j-i+1;
                    result[0] = i; result[1] = j;
                }
            }
        }

        return result;
    }
}
