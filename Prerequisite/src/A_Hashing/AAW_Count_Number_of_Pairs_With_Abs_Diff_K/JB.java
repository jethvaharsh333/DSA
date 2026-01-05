package A_Hashing.AAW_Count_Number_of_Pairs_With_Abs_Diff_K;

import java.util.*;

public class JB {
    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int element: nums){
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for(int num : nums){
            if(map.containsKey(num - k)){
                count += map.get(num - k);
            }
        }


        return count;
    }
}
