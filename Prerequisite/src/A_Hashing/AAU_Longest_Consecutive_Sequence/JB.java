package A_Hashing.AAU_Longest_Consecutive_Sequence;

import java.util.*;

public class JB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(longestConsecutiveSequence(arr));
    }

    private static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int maxLen = 0;

        for(int num : set){
            if (set.contains(num - 1)) continue;

            int current = num;
            int length = 1;

            while(set.contains(current + 1)){
                current++;
                length++;
            }

            maxLen = Math.max(maxLen, length);
        }

        return maxLen;
    }
}
