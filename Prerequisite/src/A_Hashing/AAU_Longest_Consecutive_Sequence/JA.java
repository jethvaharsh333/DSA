package A_Hashing.AAU_Longest_Consecutive_Sequence;

import java.util.*;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(longestConsecutiveSequence(arr));
    }

    private static int longestConsecutiveSequence(int[] nums){
        int n = nums.length;

        if(n==1) return 1;

        Arrays.sort(nums);

        int longestConsecutiveSequence = 0;
        int currentConsecutiveSequence = 0;

        for(int i=1 ; i<n ; i++){
            if(nums[i-1] == nums[i]) continue;

            if(nums[i-1]-nums[i] == 1){
                currentConsecutiveSequence++;
            }else{
                longestConsecutiveSequence = Math.max(longestConsecutiveSequence, currentConsecutiveSequence+1);
                currentConsecutiveSequence = 0;
            }
        }
        longestConsecutiveSequence = Math.max(longestConsecutiveSequence, currentConsecutiveSequence+1);

        return longestConsecutiveSequence;
    }
}
