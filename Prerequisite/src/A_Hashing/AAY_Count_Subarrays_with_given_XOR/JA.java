package A_Hashing.AAY_Count_Subarrays_with_given_XOR;

import java.util.HashMap;
import java.util.Map;

public class JA {
    class Solution {
        public long subarrayXor(int arr[], int k) {
            // code here
            int n = arr.length;
            Map<Integer, Integer> map = new HashMap<>();    // prefixXOR -> frequency
            map.put(0, 1);
            int prefixXOR=0, count=0;

            for(int i=0 ; i<n ; i++){
                prefixXOR ^= arr[i];

                if(map.containsKey(prefixXOR^k)){
                    int frequency = map.get(prefixXOR^k);
                    count += frequency;
                }

                map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);
            }


            return count;
        }
    }
}
