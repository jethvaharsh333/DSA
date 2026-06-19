package DP.One_Dimensional.AAJ_3186_Maximum_Total_Damage_With_Spell_Casting;

import java.util.*;

public class Tabulation {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freq = new HashMap<>();
        for(int p: power) freq.put(p, freq.getOrDefault(p, 0L) + p);

        List<Integer> powers = new ArrayList<>(freq.keySet());
        Collections.sort(powers);

        int n = powers.size();
        long[] dp = new long[n+1];

        for(int i=1 ; i<=n ; i++){
            int currPower = powers.get(i-1);

            int j = i-2; // minimum atleast i-2; if we select current freq
            while(j>=0 && currPower-powers.get(j)<=2) j--; //

            long pick = dp[j+1] + freq.get(currPower);
            long noPick = dp[i-1];

            dp[i] = Math.max(pick, noPick);
        }

        return dp[n];
    }
}
