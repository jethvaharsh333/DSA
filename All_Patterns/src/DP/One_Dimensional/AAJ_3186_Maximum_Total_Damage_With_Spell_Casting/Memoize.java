package DP.One_Dimensional.AAJ_3186_Maximum_Total_Damage_With_Spell_Casting;

import java.util.Arrays;

public class Memoize {
    public long maximumTotalDamage(int[] power) {
        int max = 0;
        for(int p: power) max = Math.max(p, max);

        long[] allPowers = new long[max+1];
        for(int p: power) allPowers[p] += p;

        long[] memo = new long[max+1];
        Arrays.fill(memo, -1);

        return recurse(max, allPowers, memo);
    }

    public long recurse(int index, long[] allPowers, long[] memo){
        if(index <= 0) return 0;
        if(memo[index] != -1) return memo[index];

        long pick = allPowers[index] + recurse(index-3, allPowers, memo);
        long noPick = recurse(index-1, allPowers, memo);

        return memo[index] = Math.max(pick, noPick);
    }
}
