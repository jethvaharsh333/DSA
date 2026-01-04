package A_Hashing.AAV_Largest_subarray_with_Zero_sum;

import java.util.*;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(largestSubArraySumZero(arr));
    }

    private static int largestSubArraySumZero(int[] nums){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum=0, maxLength=0;

        for(int j=0 ; j<n ; j++){
            prefixSum += nums[j];

            if(map.containsKey(prefixSum)){
                int i = map.get(prefixSum);
                int currentLength = j-i;

                maxLength = Math.max(maxLength, currentLength);
            }

            map.putIfAbsent(prefixSum, j);
        }

        return maxLength;
    }
}
