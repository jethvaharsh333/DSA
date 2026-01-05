package A_Hashing.AAZ_Security_Risk_Level;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JA {
    private static long findSecurityLevel(List<Integer> pid, int k){
        /*
            Sum of sub-array, length of sub-array

            Subarray -> m ..... [a,b,c,d] => a+b+c+d
                        0        i     j
                        ---------
                        prefix[i-1] + sum = prefix[j]

                        => length_sa == sum % k = sum - (k * floor(sum/k))
                        => sum - length_sa = (k * floor(sum/k)) = k * t
                        => sum - length_sa = multiple of k
                        => (sum - length) % k == 0

                        OR

                        => sum % k = length_sa
                        => (prefix[j] − prefix[i]) % k = (j − i)
                        => A%k = B => A = k*t + B     (for some integer t)
                        => prefix[j] − prefix[i] = k*t + (j − i)
                        => prefix[j] − prefix[i] − (j − i) = k * t
                        => (prefix[j] − j) − (prefix[i] − i) = k * t
                        => (prefix[j] − j) ≡ (prefix[i] − i)   (mod k)
                        => (prefix[j] − j) % k = (prefix[i] − i) % k = sum % k = length_sa
        */

        int n = pid.size();
        Map<Integer, Long> map = new HashMap<>(); // (prefixSum - index) % k -> frequency (count)
        long riskLevel = 0;
        int prefixSum = 0;

        map.put(0, 1L);

        for(int j=0 ; j<n ; j++){
            prefixSum += pid.get(j);

            int key = (int)((prefixSum - (j+1)) % k);
            if (key < 0) key += k;

            long freq = map.getOrDefault(key, 0L);
            riskLevel += freq;

            map.put(key, freq+1);
        }

        return riskLevel;
    }
}
