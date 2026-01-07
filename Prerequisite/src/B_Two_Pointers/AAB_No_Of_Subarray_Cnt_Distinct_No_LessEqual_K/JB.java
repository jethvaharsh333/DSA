package B_Two_Pointers.AAB_No_Of_Subarray_Cnt_Distinct_No_LessEqual_K;

import java.util.HashMap;
import java.util.Map;

public class JB {
    private int SubArrAAayCntOfDistinctNumberLessEqualThanK(int[] nums, int k){
        int n = nums.length;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0,j=0 ; j<n ; j++){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(map.size() > k){
                map.put(nums[i], map.get(nums[i])-1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }

            count += (j-i+1);
        }

        return count;
    }
}
