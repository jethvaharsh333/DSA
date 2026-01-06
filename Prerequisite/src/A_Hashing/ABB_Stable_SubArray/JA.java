package A_Hashing.ABB_Stable_SubArray;

import java.util.HashMap;
import java.util.Map;

// ***** FAILED: [3,3,3] => O/P: 2
// EXPECTED: 1

public class JA {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;

        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] prefixSum = new int[n];

        for(int j=0 ; j<n ; j++){
            int currentElement = capacity[j];
            prefixSum[j] = j==0 ? currentElement : prefixSum[j-1] + currentElement;

            if(map.containsKey(currentElement)){
                int previousIndex = map.get(currentElement);
                int sum = prefixSum[j] - prefixSum[previousIndex];
                count = sum==currentElement ? count+1 : count;
            }

            map.putIfAbsent(currentElement, j);
        }

        return count;
    }
}
