package DP.One_Dimensional.AAB_Climbing_Stairs;

import java.util.Arrays;

public class Memoization {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        return recurse(n, memo);
    }

    public int recurse(int n, int[] memo){
        if(n == 0) return 1;
        if(n == 1) return 1;

        if(memo[n] != -1) return memo[n];

        return recurse(n-1, memo) + recurse(n-2, memo);
    }
}
