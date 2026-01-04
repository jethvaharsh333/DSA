package A_Hashing.AAN_Two_Disjoint_SubArray_Sum_Of_Both_Max;

import java.util.Scanner;

public class JB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        int answer = twoDisjointSubarraySum_O_n(arr);
        System.out.println(answer);
    }

    static int twoDisjointSubarraySum_O_n(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Left Kadane
        int curr = 0, best = 0;
        for (int i = 0; i < n; i++) {
            curr = Math.max(0, curr + arr[i]);
            best = Math.max(best, curr);
            leftMax[i] = best;
        }

        // Right Kadane
        curr = 0;
        best = 0;
        for (int i = n - 1; i >= 0; i--) {
            curr = Math.max(0, curr + arr[i]);
            best = Math.max(best, curr);
            rightMax[i] = best;
        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer = Math.max(answer, leftMax[i] + rightMax[i + 1]);
        }

        // single subarray case
        answer = Math.max(answer, leftMax[n - 1]);

        return answer;
    }
}
