package A_Hashing.AAX_Count_Subarrays_having_Sum_K;

import java.util.HashMap;
import java.util.Map;

public class JA {
    private static int countSubarraysSumK(int[] arr, int k){
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();    // prefixSum -> frequency
        map.put(0, 1);
        int prefixSum=0, count=0;

        for(int i=0 ; i<n ; i++){
            prefixSum += arr[i];

            if(map.containsKey(prefixSum-k)){
                int frequency = map.get(prefixSum-k);
                count += frequency;
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }


        return count;
    }
}
