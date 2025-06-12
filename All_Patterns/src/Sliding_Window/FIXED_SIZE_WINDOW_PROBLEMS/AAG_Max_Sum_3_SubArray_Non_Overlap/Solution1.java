package Sliding_Window.FIXED_SIZE_WINDOW_PROBLEMS.AAG_Max_Sum_3_SubArray_Non_Overlap;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1, 6, 7};
        int k = 2;

        int[] result = maxSumOfThreeSubarrays(nums, k);

        System.out.println("Max sum subarray indices: " + Arrays.toString(result));
        System.out.println("Subarrays:");
        for (int index : result) {
            System.out.print("[");
            for (int i = 0; i < k; i++) {
                System.out.print(nums[index + i] + (i == k - 1 ? "" : ", "));
            }
            System.out.print("] ");
        }
    }


    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n-k+1];

        int windowSum = 0;
        for(int i=0 ; i<n; i++){
            windowSum += nums[i];
            if(i >= k) windowSum -= nums[i-k];
            if(i >= k-1) sum[i-k+1] = windowSum;
        }

        // for(int i=0 ; i<n-1 ; i++){
        //     System.out.print(sum[i] + ", ");
        // }

        int[] left = new int[sum.length];
        int bestLeftIndex = 0;
        for(int i=0 ; i<sum.length ; i++){
            if(sum[i] > sum[bestLeftIndex]) bestLeftIndex = i;
            left[i] = bestLeftIndex;
        }

        // System.out.println();
        // for(int i=0 ; i<left.length ; i++){
        //     System.out.print(left[i] + ", ");
        // }

        int[] right = new int[sum.length];
        int bestRightIndex = sum.length-1;
        for(int i=sum.length-1 ; i>=0 ; i--){
            if(sum[i] >= sum[bestRightIndex]) bestRightIndex = i;
            right[i] = bestRightIndex;
        }

        // System.out.println();
        // for(int i=0 ; i<right.length ; i++){
        //     System.out.print(right[i] + ", ");
        // }

        int maxTotal = 0;
        int[] result = new int[3];

        for(int mid=k ; mid<=sum.length-k-1 ; mid++){
            int l = left[mid-k];            // best left before mid
            int r = right[mid+k];           // best right after mid
            int total = sum[l] + sum[mid] + sum[r]; // total = left + mid + right

            /*
            * Key Idea: Fix the middle window
                If we fix the middle window of length k, we only need to:
                Find the best left window before it (non-overlapping)
                Find the best right window after it (non-overlapping)
            * */

            if(total > maxTotal){
                maxTotal = total;
                result[0] = l;
                result[1] = mid;
                result[2] = r;
            }
        }

        return result;
    }
}

/*
Let's go step-by-step and visualize the complete process for:

ini
Copy
Edit
nums = [1, 2, 3, 4, 1, 6, 7]
k = 2
🔸 Step 1: Build sum[] — sum of subarrays of size k
We compute the sum of each window of length k = 2:
| Index `i` | Subarray | sum\[i] |
| --------- | -------- | ------- |
| 0         | \[1, 2]  | 3       |
| 1         | \[2, 3]  | 5       |
| 2         | \[3, 4]  | 7       |
| 3         | \[4, 1]  | 5       |
| 4         | \[1, 6]  | 7       |
| 5         | \[6, 7]  | 13      |
sum = [3, 5, 7, 5, 7, 13]



🔸 Step 2: Build left[] — best index from the left
We walk left to right, storing the index with the max sum so far:
| i | sum\[i] | Best so far | left\[i] |
| - | ------- | ----------- | -------- |
| 0 | 3       | 0           | 0        |
| 1 | 5       | 1           | 1        |
| 2 | 7       | 2           | 2        |
| 3 | 5       | 2           | 2        |
| 4 | 7       | 2           | 2        |
| 5 | 13      | 5           | 5        |
left = [0, 1, 2, 2, 2, 5]



🔸 Step 3: Build right[] — best index from the right
We walk right to left, storing the index with the max sum so far:
| i | sum\[i] | Best so far | right\[i] |
| - | ------- | ----------- | --------- |
| 5 | 13      | 5           | 5         |
| 4 | 7       | 5           | 5         |
| 3 | 5       | 5           | 5         |
| 2 | 7       | 5           | 5         |
| 1 | 5       | 5           | 5         |
| 0 | 3       | 5           | 5         |
right = [5, 5, 5, 5, 5, 5]



🔸 Step 4: Try each valid middle index
Valid mid values: from k to sum.length - k - 1
→ from 2 to 3

✅ Try mid = 2
left index = left[0] = 0

mid index = 2

right index = right[4] = 5

sum = sum[0] + sum[2] + sum[5]
= 3 + 7 + 13 = 23

✅ Try mid = 3
left = left[1] = 1

mid = 3

right = right[5] = 5

sum = sum[1] + sum[3] + sum[5]
= 5 + 5 + 13 = 23

✅ Total is same, but [0,2,5] is lexicographically smaller → we return [0,2,5].






* */