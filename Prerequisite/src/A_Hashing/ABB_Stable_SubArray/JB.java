package A_Hashing.ABB_Stable_SubArray;

import java.util.HashMap;
import java.util.Map;

public class JB {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;

        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] prefixSum = new int[n];

        for(int j=0 ; j<n ; j++){
            int currentElement = capacity[j];
            prefixSum[j] = j==0 ? currentElement : prefixSum[j-1] + currentElement;

            if(map.containsKey(currentElement*2)){
                int previousIndex = map.get(currentElement*2);
                count = capacity[previousIndex]==currentElement ? count+1 : count;
            }

            map.putIfAbsent(prefixSum[j], j);
        }

        return count;
    }
}
