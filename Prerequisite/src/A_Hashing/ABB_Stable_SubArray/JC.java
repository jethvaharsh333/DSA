package A_Hashing.ABB_Stable_SubArray;

import java.util.HashMap;
import java.util.Map;

public class JC {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;

        Map<String, Long> map = new HashMap<>();
        long prefixSum = 0;
        long count = 0;

        for(int curr : capacity){
            prefixSum += curr;

            long sumDesired = prefixSum - 2L * curr;

            /*
                                     <---prefixSum---->
                                    -------------------
                                    prefix | sub | curr
                                           ------------
                                             2L * curr

                Example: [9, 9, 0, -9, 9, 3, 3, 3, 9]
                          --------------||------||---
                             prefix       sub     curr

                             & also prefix's last number to be stored
                             so that prefix's last number and the first number after the subarray be same
            */

            String keyDesired = sumDesired + "," + curr;

            if(map.containsKey(keyDesired)){
                count += map.get(keyDesired);
            }

            String keyCurrent = prefixSum + "," + curr;
            map.put(keyCurrent, map.getOrDefault(keyCurrent, 0L) + 1);
        }

        for(int i=0 ; i<n-1 ; i++){
            if(capacity[i]==0 && capacity[i+1]==0) count--;
        }

        return count;
    }
}
