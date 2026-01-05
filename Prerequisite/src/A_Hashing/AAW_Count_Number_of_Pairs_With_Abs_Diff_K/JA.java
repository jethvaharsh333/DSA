package A_Hashing.AAW_Count_Number_of_Pairs_With_Abs_Diff_K;

import java.util.*;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        System.out.println(countKDifference(arr, k));
    }

    private static int countKDifference(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int i=0 ; i<n ; i++){
            int element = nums[i];
            int prev = map.getOrDefault(element-k, 0);
            int next = map.getOrDefault(element+k, 0);

            count += prev + next;

            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        return count;
    }
}
